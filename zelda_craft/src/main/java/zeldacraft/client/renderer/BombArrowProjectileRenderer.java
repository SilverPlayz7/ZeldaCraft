package zeldacraft.client.renderer;

import zeldacraft.entity.BombArrowProjectileEntity;

import zeldacraft.client.model.ModelBombArrow;

import net.minecraft.util.Mth;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import com.mojang.math.Axis;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class BombArrowProjectileRenderer extends EntityRenderer<BombArrowProjectileEntity> {
	private static final ResourceLocation texture = new ResourceLocation("zelda_craft:textures/entities/bombarrow.png");
	private final ModelBombArrow model;

	public BombArrowProjectileRenderer(EntityRendererProvider.Context context) {
		super(context);
		model = new ModelBombArrow(context.bakeLayer(ModelBombArrow.LAYER_LOCATION));
	}

	@Override
	public void render(BombArrowProjectileEntity entityIn, float entityYaw, float partialTicks, PoseStack poseStack, MultiBufferSource bufferIn, int packedLightIn) {
		VertexConsumer vb = bufferIn.getBuffer(RenderType.entityCutout(this.getTextureLocation(entityIn)));
		poseStack.pushPose();
		poseStack.scale(0.75f, 0.75f, 0.75f);
		poseStack.mulPose(Axis.YP.rotationDegrees(Mth.lerp(partialTicks, entityIn.yRotO, entityIn.getYRot()) - 90));
		poseStack.mulPose(Axis.ZP.rotationDegrees(90 + Mth.lerp(partialTicks, entityIn.xRotO, entityIn.getXRot())));
		model.renderToBuffer(poseStack, vb, packedLightIn, OverlayTexture.NO_OVERLAY, 1, 1, 1, 1);
		poseStack.popPose();
		super.render(entityIn, entityYaw, partialTicks, poseStack, bufferIn, packedLightIn);
	}

	@Override
	public ResourceLocation getTextureLocation(BombArrowProjectileEntity entity) {
		return texture;
	}
}