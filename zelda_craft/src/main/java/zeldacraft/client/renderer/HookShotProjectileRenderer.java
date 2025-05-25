package zeldacraft.client.renderer;

import zeldacraft.entity.HookShotProjectileEntity;

import zeldacraft.client.model.Modelfiredhook;

import org.checkerframework.checker.units.qual.m;
import org.checkerframework.checker.units.qual.h;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.HumanoidArm;
import net.minecraft.world.InteractionHand;
import net.minecraft.util.Mth;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.Minecraft;

import com.mojang.math.Axis;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class HookShotProjectileRenderer extends EntityRenderer<HookShotProjectileEntity> {
	private static final ResourceLocation TEXTURE = new ResourceLocation("zelda_craft:textures/entities/hook.png");
	private static final ResourceLocation CHAIN_TEXTURE = new ResourceLocation("zelda_craft:textures/entities/chain.png");
	private static final RenderType CHAIN_LAYER = RenderType.entityCutoutNoCull(CHAIN_TEXTURE);
	private final Modelfiredhook model;

	public HookShotProjectileRenderer(EntityRendererProvider.Context context) {
		super(context);
		model = new Modelfiredhook(context.bakeLayer(Modelfiredhook.LAYER_LOCATION));
	}

	@Override
	public void render(HookShotProjectileEntity hookshotEntity, float yaw, float partialTicks, PoseStack poseStack, MultiBufferSource buffer, int packedLight) {
		Player player = Minecraft.getInstance().player;
		if (player != null && !player.getMainHandItem().isEmpty()) { // Replace with your condition for hook presence
			HumanoidArm mainArm = Minecraft.getInstance().options.mainHand().get();
			ItemStack activeItem = player.getUseItem();
			poseStack.pushPose();
			boolean rightHandIsActive = (mainArm == HumanoidArm.RIGHT && player.getUsedItemHand() == InteractionHand.MAIN_HAND) || (mainArm == HumanoidArm.LEFT && player.getUsedItemHand() == InteractionHand.OFF_HAND);
			double bodyYawToRads = Math.toRadians(player.yBodyRot);
			double radius = rightHandIsActive ? -0.4D : 0.4D;
			double startX = player.getX() + radius * Math.cos(bodyYawToRads);
			double startY = player.getY() + (player.getBbHeight() / 3D);
			double startZ = player.getZ() + radius * Math.sin(bodyYawToRads);
			float distanceX = (float) (startX - hookshotEntity.getX());
			float distanceY = (float) (startY - hookshotEntity.getY());
			float distanceZ = (float) (startZ - hookshotEntity.getZ());
			float distanceSquared = distanceX * distanceX + distanceY * distanceY + distanceZ * distanceZ;
			if (distanceSquared >= 2) {
				renderChain(distanceX, distanceY, distanceZ, partialTicks, hookshotEntity.tickCount, poseStack, buffer, packedLight);
				renderSecondChain(distanceX, distanceY, distanceZ, partialTicks, hookshotEntity.tickCount, poseStack, buffer, packedLight);
			}
			renderHook(distanceX, distanceY, distanceZ, partialTicks, hookshotEntity.tickCount, poseStack, buffer, packedLight);
			poseStack.popPose();
		}
		super.render(hookshotEntity, yaw, partialTicks, poseStack, buffer, packedLight);
	}

	private void renderHook(float x, float y, float z, float partialTicks, int age, PoseStack poseStack, MultiBufferSource buffer, int packedLight) {
		float lengthXY = Mth.sqrt(x * x + z * z);
		poseStack.pushPose();
		poseStack.mulPose(Axis.YP.rotation((float) (-Math.atan2(z, x)) - Mth.HALF_PI));
		poseStack.mulPose(Axis.XP.rotation((float) (-Math.atan2(lengthXY, y)) - Mth.HALF_PI));
		poseStack.scale(1.0F, 1.0F, 1.0F);
		VertexConsumer vertexConsumer = buffer.getBuffer(model.renderType(TEXTURE));
		model.renderToBuffer(poseStack, vertexConsumer, packedLight, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
		poseStack.popPose();
	}

	private void renderChain(float x, float y, float z, float partialTicks, int age, PoseStack poseStack, MultiBufferSource buffer, int packedLight) {
		renderChainSegment(x, y, z, partialTicks, age, poseStack, buffer, packedLight, 0.75F);
	}

	private void renderSecondChain(float x, float y, float z, float partialTicks, int age, PoseStack poseStack, MultiBufferSource buffer, int packedLight) {
		renderChainSegment(x, y, z, partialTicks, age, poseStack, buffer, packedLight, -0.10F);
	}

	private void renderChainSegment(float x, float y, float z, float partialTicks, int age, PoseStack poseStack, MultiBufferSource buffer, int packedLight, float yOffset) {
		float lengthXY = Mth.sqrt(x * x + z * z);
		float squaredLength = x * x + y * y + z * z;
		float length = Mth.sqrt(squaredLength);
		poseStack.pushPose();
		poseStack.mulPose(Axis.YP.rotation((float) (-Math.atan2(z, x)) - Mth.HALF_PI));
		poseStack.mulPose(Axis.XP.rotation((float) (-Math.atan2(lengthXY, y)) - Mth.HALF_PI));
		VertexConsumer vertexConsumer = buffer.getBuffer(CHAIN_LAYER);
		float h = 0.0F - ((float) age + partialTicks) * 0.01F;
		float i = Mth.sqrt(squaredLength) / 32.0F - ((float) age + partialTicks) * 0.01F;
		float k = 0.0F;
		float l = yOffset;
		float m = 0.0F;
		PoseStack.Pose pose = poseStack.last();
		for (int n = 1; n <= 8; ++n) {
			float o = Mth.sin((float) n * Mth.TWO_PI / 8.0F) * 0.125F;
			float p = Mth.cos((float) n * Mth.TWO_PI / 8.0F) * 0.125F;
			float q = (float) n / 8.0F;
			vertexConsumer.vertex(pose.pose(), k * 0.2F, l * 0.2F, 0.0F).color(0, 0, 0, 255).uv(m, h).overlayCoords(OverlayTexture.NO_OVERLAY).uv2(packedLight).normal(pose.normal(), 0.0F, -1.0F, 0.0F).endVertex();
			vertexConsumer.vertex(pose.pose(), k, l, length).color(255, 255, 255, 255).uv(m, i).overlayCoords(OverlayTexture.NO_OVERLAY).uv2(packedLight).normal(pose.normal(), 0.0F, -1.0F, 0.0F).endVertex();
			vertexConsumer.vertex(pose.pose(), o, p, length).color(255, 255, 255, 255).uv(q, i).overlayCoords(OverlayTexture.NO_OVERLAY).uv2(packedLight).normal(pose.normal(), 0.0F, -1.0F, 0.0F).endVertex();
			vertexConsumer.vertex(pose.pose(), o * 0.2F, p * 0.2F, 0.0F).color(0, 0, 0, 255).uv(q, h).overlayCoords(OverlayTexture.NO_OVERLAY).uv2(packedLight).normal(pose.normal(), 0.0F, -1.0F, 0.0F).endVertex();
			k = o;
			l = p;
			m = q;
		}
		poseStack.popPose();
	}

	@Override
	public ResourceLocation getTextureLocation(HookShotProjectileEntity entity) {
		return TEXTURE;
	}
}
