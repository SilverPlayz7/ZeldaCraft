package zeldacraft.procedures;

import zeldacraft.init.ZeldaCraftModBlocks;

import org.joml.Vector3f;
import org.joml.Matrix4f;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.common.ForgeMod;
import net.minecraftforge.client.model.data.ModelData;
import net.minecraftforge.client.event.RenderLevelStageEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.core.BlockPos;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.block.ModelBlockRenderer;
import net.minecraft.client.renderer.block.BlockRenderDispatcher;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.LightTexture;
import net.minecraft.client.renderer.LevelRenderer;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.gui.Font;
import net.minecraft.client.Minecraft;

import javax.annotation.Nullable;

import java.util.Map;
import java.util.HashMap;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.systems.RenderSystem;

@Mod.EventBusSubscriber(value = Dist.CLIENT)
public class PowerSelectRenderProcedure {
	private static RenderLevelStageEvent provider = null;
	private static Map<EntityType, Entity> data = new HashMap<>();

	public static void renderBackground(String texts, double x, double y, double z, float yaw, float pitch, float roll, float scale, int color) {
		Minecraft minecraft = Minecraft.getInstance();
		Font font = minecraft.font;
		MultiBufferSource.BufferSource bufferSource = minecraft.renderBuffers().bufferSource();
		Vec3 pos = provider.getCamera().getPosition();
		PoseStack poseStack = provider.getPoseStack();
		poseStack.pushPose();
		poseStack.translate(x - pos.x(), y - pos.y(), z - pos.z());
		poseStack.mulPose(com.mojang.math.Axis.YN.rotationDegrees(yaw));
		poseStack.mulPose(com.mojang.math.Axis.XP.rotationDegrees(pitch));
		poseStack.mulPose(com.mojang.math.Axis.ZN.rotationDegrees(roll));
		poseStack.scale(scale, -scale, 1.0F);
		poseStack.translate((font.width(texts) - 1) * -0.5F, (font.lineHeight - 1) * -0.5F, 0.0F);
		Matrix4f matrix4f = poseStack.last().pose();
		RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
		font.drawInBatch(texts, 0.0F, 0.0F, 0, false, matrix4f, bufferSource, Font.DisplayMode.SEE_THROUGH, color, LightTexture.FULL_BRIGHT);
		RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
		poseStack.popPose();
	}

	public static void renderBlock(BlockState blockState, double x, double y, double z, float yaw, float pitch, float roll, float scale, boolean glowing) {
		BlockPos blockPos = BlockPos.containing(x, y, z);
		Vec3 pos = provider.getCamera().getPosition();
		int packedLight = glowing ? LightTexture.FULL_BRIGHT : LevelRenderer.getLightColor(Minecraft.getInstance().level, blockPos);
		PoseStack poseStack = provider.getPoseStack();
		poseStack.pushPose();
		poseStack.translate(x - pos.x(), y - pos.y(), z - pos.z());
		poseStack.mulPose(com.mojang.math.Axis.YN.rotationDegrees(yaw));
		poseStack.mulPose(com.mojang.math.Axis.XP.rotationDegrees(pitch));
		poseStack.mulPose(com.mojang.math.Axis.ZN.rotationDegrees(roll));
		poseStack.scale(scale, scale, scale);
		poseStack.translate(-0.5F, -0.5F, -0.5F);
		RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
		renderBlockModel(blockState, blockPos, poseStack, packedLight);
		renderBlockEntity(blockState, blockPos, poseStack, packedLight);
		RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
		poseStack.popPose();
	}

	private static void renderBlockEntity(BlockState blockState, BlockPos blockPos, PoseStack poseStack, int packedLight) {
		if (blockState.getBlock() instanceof EntityBlock entityBlock) {
			Minecraft minecraft = Minecraft.getInstance();
			ClientLevel level = minecraft.level;
			BlockEntity blockEntity = entityBlock.newBlockEntity(blockPos, blockState);
			if (blockEntity != null) {
				BlockEntityRenderer blockEntityRenderer = minecraft.getBlockEntityRenderDispatcher().getRenderer(blockEntity);
				if (blockEntityRenderer != null) {
					MultiBufferSource.BufferSource bufferSource = minecraft.renderBuffers().bufferSource();
					blockEntity.setLevel(level);
					blockEntityRenderer.render(blockEntity, 0.0F, poseStack, bufferSource, packedLight, OverlayTexture.NO_OVERLAY);
				}
			}
		}
	}

	private static void renderBlockModel(BlockState blockState, BlockPos blockPos, PoseStack poseStack, int packedLight) {
		if (blockState.getRenderShape() == RenderShape.MODEL) {
			Minecraft minecraft = Minecraft.getInstance();
			ClientLevel level = minecraft.level;
			MultiBufferSource.BufferSource bufferSource = minecraft.renderBuffers().bufferSource();
			BlockRenderDispatcher dispatcher = minecraft.getBlockRenderer();
			ModelBlockRenderer renderer = dispatcher.getModelRenderer();
			BakedModel bakedModel = dispatcher.getBlockModel(blockState);
			ModelData modelData = bakedModel.getModelData(level, blockPos, blockState, ModelData.builder().build());
			PoseStack.Pose pose = poseStack.last();
			int color = minecraft.getBlockColors().getColor(blockState, level, blockPos);
			float red = (color >> 16 & 255) / 255.0F;
			float green = (color >> 8 & 255) / 255.0F;
			float blue = (color & 255) / 255.0F;
			for (RenderType renderType : bakedModel.getRenderTypes(blockState, RandomSource.create(42L), modelData)) {
				renderer.renderModel(pose, bufferSource.getBuffer(Sheets.translucentCullBlockSheet()), blockState, bakedModel, red, green, blue, packedLight, OverlayTexture.NO_OVERLAY, modelData, renderType);
			}
		}
	}

	public static void renderEntity(EntityType type, double x, double y, double z, float yaw, float pitch, float roll, float scale, boolean glowing) {
		if (type == null)
			return;
		Entity entity;
		ClientLevel level = Minecraft.getInstance().level;
		if (data.containsKey(type)) {
			entity = data.get(type);
			if (entity.level() != level) {
				entity = type.create(level);
				data.put(type, entity);
			}
		} else {
			entity = type.create(level);
			data.put(type, entity);
		}
		renderEntity(entity, 0.0F, x, y, z, yaw, pitch, roll, scale, glowing ? LightTexture.FULL_BRIGHT : LevelRenderer.getLightColor(level, BlockPos.containing(x, y, z)));
	}

	public static void renderEntity(Entity entity, double x, double y, double z, float yaw, float pitch, float roll, float scale, boolean glowing) {
		float partialTick = provider.getPartialTick();
		int packedLight = glowing ? LightTexture.FULL_BRIGHT : Minecraft.getInstance().getEntityRenderDispatcher().getPackedLightCoords(entity, partialTick);
		renderEntity(entity, partialTick, x, y, z, yaw, pitch, roll, scale, packedLight);
	}

	private static void renderEntity(Entity entity, float partialTick, double x, double y, double z, float yaw, float pitch, float roll, float scale, int packedLight) {
		if (entity == null)
			return;
		Minecraft minecraft = Minecraft.getInstance();
		MultiBufferSource.BufferSource bufferSource = minecraft.renderBuffers().bufferSource();
		EntityRenderer renderer = minecraft.getEntityRenderDispatcher().getRenderer(entity);
		Vec3 pos = provider.getCamera().getPosition();
		float offset = (entity.getBbHeight() / 2.0F) * scale;
		PoseStack poseStack = provider.getPoseStack();
		poseStack.pushPose();
		poseStack.translate(x - pos.x(), y + offset - pos.y(), z - pos.z());
		poseStack.mulPose(com.mojang.math.Axis.YN.rotationDegrees(yaw));
		poseStack.mulPose(com.mojang.math.Axis.XP.rotationDegrees(pitch));
		poseStack.mulPose(com.mojang.math.Axis.ZN.rotationDegrees(roll));
		poseStack.translate(0.0F, -offset, 0.0F);
		poseStack.scale(scale, scale, scale);
		RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
		renderer.render(entity, entity.getViewYRot(partialTick), partialTick, poseStack, bufferSource, packedLight);
		RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
		poseStack.popPose();
	}

	public static void renderItem(ItemStack itemStack, double x, double y, double z, float yaw, float pitch, float roll, float scale, boolean flipping, boolean glowing) {
		Minecraft minecraft = Minecraft.getInstance();
		MultiBufferSource.BufferSource bufferSource = minecraft.renderBuffers().bufferSource();
		ItemRenderer renderer = minecraft.getItemRenderer();
		Vec3 pos = provider.getCamera().getPosition();
		int packedLight = glowing ? LightTexture.FULL_BRIGHT : LevelRenderer.getLightColor(minecraft.level, BlockPos.containing(x, y, z));
		PoseStack poseStack = provider.getPoseStack();
		poseStack.pushPose();
		poseStack.translate(x - pos.x(), y - pos.y(), z - pos.z());
		poseStack.mulPose(com.mojang.math.Axis.YN.rotationDegrees(yaw));
		poseStack.mulPose(com.mojang.math.Axis.XP.rotationDegrees(pitch));
		poseStack.mulPose(com.mojang.math.Axis.ZN.rotationDegrees(roll));
		poseStack.scale(scale, scale, scale);
		RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
		renderer.renderStatic(null, itemStack, ItemDisplayContext.FIXED, flipping, poseStack, bufferSource, minecraft.level, packedLight, OverlayTexture.NO_OVERLAY, 0);
		RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
		poseStack.popPose();
	}

	public static void renderLine(double x1, double y1, double z1, double x2, double y2, double z2, int color) {
		MultiBufferSource.BufferSource bufferSource = Minecraft.getInstance().renderBuffers().bufferSource();
		Vec3 pos = provider.getCamera().getPosition();
		Vector3f normal = new Vec3(x2 - x1, y2 - y1, z2 - z1).normalize().toVector3f();
		Matrix4f matrix4f = provider.getPoseStack().last().pose();
		VertexConsumer vertexConsumer = bufferSource.getBuffer(RenderType.lines());
		vertexConsumer.vertex(matrix4f, (float) (x1 - pos.x()), (float) (y1 - pos.y()), (float) (z1 - pos.z())).color(color).normal(normal.x(), normal.y(), normal.z()).endVertex();
		vertexConsumer.vertex(matrix4f, (float) (x2 - pos.x()), (float) (y2 - pos.y()), (float) (z2 - pos.z())).color(color).normal(normal.x(), normal.y(), normal.z()).endVertex();
	}

	public static void renderTexts(String texts, double x, double y, double z, float yaw, float pitch, float roll, float scale, int color, boolean glowing) {
		Minecraft minecraft = Minecraft.getInstance();
		Font font = minecraft.font;
		MultiBufferSource.BufferSource bufferSource = minecraft.renderBuffers().bufferSource();
		Vec3 pos = provider.getCamera().getPosition();
		int packedLight = glowing ? LightTexture.FULL_BRIGHT : LevelRenderer.getLightColor(minecraft.level, BlockPos.containing(x, y, z));
		PoseStack poseStack = provider.getPoseStack();
		poseStack.pushPose();
		poseStack.translate(x - pos.x(), y - pos.y(), z - pos.z());
		poseStack.mulPose(com.mojang.math.Axis.YN.rotationDegrees(yaw));
		poseStack.mulPose(com.mojang.math.Axis.XP.rotationDegrees(pitch));
		poseStack.mulPose(com.mojang.math.Axis.ZN.rotationDegrees(roll));
		poseStack.scale(scale, -scale, 1.0F);
		poseStack.translate((font.width(texts) - 1) * -0.5F, (font.lineHeight - 1) * -0.5F, 0.0F);
		Matrix4f matrix4f = poseStack.last().pose();
		RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
		font.drawInBatch(texts, 0.0F, 0.0F, color, false, matrix4f, bufferSource, Font.DisplayMode.NORMAL, 0, packedLight);
		RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
		poseStack.popPose();
	}

	@SubscribeEvent
	public static void renderModels(RenderLevelStageEvent event) {
		provider = event;
		if (provider.getStage() == RenderLevelStageEvent.Stage.AFTER_ENTITIES) {
			ClientLevel level = Minecraft.getInstance().level;
			Entity entity = provider.getCamera().getEntity();
			Vec3 pos = entity.getPosition(provider.getPartialTick());
			execute(provider, level, entity);
			RenderSystem.defaultBlendFunc();
			RenderSystem.disableBlend();
			RenderSystem.enableCull();
			RenderSystem.enableDepthTest();
			RenderSystem.depthMask(true);
		}
	}

	public static void execute(LevelAccessor world, Entity entity) {
		execute(null, world, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == ZeldaCraftModBlocks.FLOOR_SWITCH.get().asItem()) {
			if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().getBoolean("haslocation") == false) {
				if ((world
						.getBlockState(new BlockPos(
								entity.level()
										.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
												(entity instanceof LivingEntity _livingEntity4 && _livingEntity4.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity4.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
												ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity))
										.getBlockPos().getX(),
								entity.level()
										.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
												(entity instanceof LivingEntity _livingEntity6 && _livingEntity6.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity6.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
												ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity))
										.getBlockPos().getY(),
								entity.level()
										.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
												(entity instanceof LivingEntity _livingEntity8 && _livingEntity8.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity8.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
												ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity))
										.getBlockPos().getZ())))
						.getBlock() == ZeldaCraftModBlocks.SHEIKAH_LINK.get()) {
					renderLine(
							(entity.level()
									.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
											(entity instanceof LivingEntity _livingEntity12 && _livingEntity12.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity12.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
											ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity))
									.getBlockPos().getX()),
							(entity.level()
									.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
											(entity instanceof LivingEntity _livingEntity14 && _livingEntity14.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity14.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
											ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity))
									.getBlockPos().getY()),
							(entity.level()
									.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
											(entity instanceof LivingEntity _livingEntity16 && _livingEntity16.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity16.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
											ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity))
									.getBlockPos().getZ()),
							(entity.level()
									.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
											(entity instanceof LivingEntity _livingEntity18 && _livingEntity18.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity18.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
											ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity))
									.getBlockPos().getX() + 1),
							(entity.level()
									.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
											(entity instanceof LivingEntity _livingEntity20 && _livingEntity20.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity20.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
											ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity))
									.getBlockPos().getY()),
							(entity.level()
									.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
											(entity instanceof LivingEntity _livingEntity22 && _livingEntity22.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity22.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
											ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity))
									.getBlockPos().getZ()),
							255 << 24 | 255 << 16 | 255 << 8 | 255);
					renderLine(
							(entity.level()
									.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
											(entity instanceof LivingEntity _livingEntity26 && _livingEntity26.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity26.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
											ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
									.getBlockPos().getX()),
							(entity.level()
									.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
											(entity instanceof LivingEntity _livingEntity28 && _livingEntity28.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity28.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
											ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
									.getBlockPos().getY()),
							(entity.level()
									.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
											(entity instanceof LivingEntity _livingEntity30 && _livingEntity30.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity30.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
											ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
									.getBlockPos().getZ()),
							(entity.level()
									.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
											(entity instanceof LivingEntity _livingEntity32 && _livingEntity32.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity32.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
											ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
									.getBlockPos().getX()),
							(entity.level()
									.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
											(entity instanceof LivingEntity _livingEntity34 && _livingEntity34.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity34.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
											ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
									.getBlockPos().getY() + 1),
							(entity.level()
									.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
											(entity instanceof LivingEntity _livingEntity36 && _livingEntity36.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity36.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
											ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
									.getBlockPos().getZ()),
							255 << 24 | 255 << 16 | 255 << 8 | 255);
					renderLine(
							(entity.level()
									.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
											(entity instanceof LivingEntity _livingEntity40 && _livingEntity40.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity40.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
											ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
									.getBlockPos().getX() + 1),
							(entity.level()
									.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
											(entity instanceof LivingEntity _livingEntity42 && _livingEntity42.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity42.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
											ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
									.getBlockPos().getY()),
							(entity.level()
									.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
											(entity instanceof LivingEntity _livingEntity44 && _livingEntity44.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity44.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
											ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
									.getBlockPos().getZ()),
							(entity.level()
									.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
											(entity instanceof LivingEntity _livingEntity46 && _livingEntity46.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity46.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
											ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
									.getBlockPos().getX() + 1),
							(entity.level()
									.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
											(entity instanceof LivingEntity _livingEntity48 && _livingEntity48.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity48.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
											ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
									.getBlockPos().getY() + 1),
							(entity.level()
									.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
											(entity instanceof LivingEntity _livingEntity50 && _livingEntity50.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity50.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
											ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
									.getBlockPos().getZ()),
							255 << 24 | 255 << 16 | 255 << 8 | 255);
					renderLine(
							(entity.level()
									.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
											(entity instanceof LivingEntity _livingEntity54 && _livingEntity54.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity54.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
											ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
									.getBlockPos().getX()),
							(entity.level()
									.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
											(entity instanceof LivingEntity _livingEntity56 && _livingEntity56.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity56.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
											ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
									.getBlockPos().getY() + 1),
							(entity.level()
									.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
											(entity instanceof LivingEntity _livingEntity58 && _livingEntity58.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity58.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
											ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
									.getBlockPos().getZ()),
							(entity.level()
									.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
											(entity instanceof LivingEntity _livingEntity60 && _livingEntity60.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity60.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
											ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
									.getBlockPos().getX() + 1),
							(entity.level()
									.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
											(entity instanceof LivingEntity _livingEntity62 && _livingEntity62.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity62.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
											ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
									.getBlockPos().getY() + 1),
							(entity.level()
									.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
											(entity instanceof LivingEntity _livingEntity64 && _livingEntity64.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity64.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
											ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
									.getBlockPos().getZ()),
							255 << 24 | 255 << 16 | 255 << 8 | 255);
					renderLine(
							(entity.level()
									.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
											(entity instanceof LivingEntity _livingEntity68 && _livingEntity68.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity68.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
											ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
									.getBlockPos().getX()),
							(entity.level()
									.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
											(entity instanceof LivingEntity _livingEntity70 && _livingEntity70.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity70.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
											ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
									.getBlockPos().getY()),
							(entity.level()
									.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
											(entity instanceof LivingEntity _livingEntity72 && _livingEntity72.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity72.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
											ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
									.getBlockPos().getZ()),
							(entity.level()
									.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
											(entity instanceof LivingEntity _livingEntity74 && _livingEntity74.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity74.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
											ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
									.getBlockPos().getX()),
							(entity.level()
									.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
											(entity instanceof LivingEntity _livingEntity76 && _livingEntity76.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity76.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
											ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
									.getBlockPos().getY()),
							(entity.level()
									.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
											(entity instanceof LivingEntity _livingEntity78 && _livingEntity78.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity78.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
											ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
									.getBlockPos().getZ() + 1),
							255 << 24 | 255 << 16 | 255 << 8 | 255);
					renderLine(
							(entity.level()
									.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
											(entity instanceof LivingEntity _livingEntity82 && _livingEntity82.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity82.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
											ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
									.getBlockPos().getX()),
							(entity.level()
									.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
											(entity instanceof LivingEntity _livingEntity84 && _livingEntity84.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity84.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
											ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
									.getBlockPos().getY()),
							(entity.level()
									.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
											(entity instanceof LivingEntity _livingEntity86 && _livingEntity86.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity86.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
											ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
									.getBlockPos().getZ() + 1),
							(entity.level()
									.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
											(entity instanceof LivingEntity _livingEntity88 && _livingEntity88.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity88.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
											ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
									.getBlockPos().getX()),
							(entity.level()
									.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
											(entity instanceof LivingEntity _livingEntity90 && _livingEntity90.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity90.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
											ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
									.getBlockPos().getY() + 1),
							(entity.level()
									.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
											(entity instanceof LivingEntity _livingEntity92 && _livingEntity92.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity92.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
											ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
									.getBlockPos().getZ() + 1),
							255 << 24 | 255 << 16 | 255 << 8 | 255);
					renderLine(
							(entity.level()
									.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
											(entity instanceof LivingEntity _livingEntity96 && _livingEntity96.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity96.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
											ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
									.getBlockPos().getX()),
							(entity.level()
									.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
											(entity instanceof LivingEntity _livingEntity98 && _livingEntity98.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity98.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
											ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
									.getBlockPos().getY() + 1),
							(entity.level()
									.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
											(entity instanceof LivingEntity _livingEntity100 && _livingEntity100.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity100.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
											ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
									.getBlockPos().getZ()),
							(entity.level()
									.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
											(entity instanceof LivingEntity _livingEntity102 && _livingEntity102.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity102.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
											ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
									.getBlockPos().getX()),
							(entity.level()
									.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
											(entity instanceof LivingEntity _livingEntity104 && _livingEntity104.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity104.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
											ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
									.getBlockPos().getY() + 1),
							(entity.level()
									.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
											(entity instanceof LivingEntity _livingEntity106 && _livingEntity106.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity106.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
											ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
									.getBlockPos().getZ() + 1),
							255 << 24 | 255 << 16 | 255 << 8 | 255);
					renderLine(
							(entity.level()
									.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
											(entity instanceof LivingEntity _livingEntity110 && _livingEntity110.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity110.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
											ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
									.getBlockPos().getX() + 1),
							(entity.level()
									.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
											(entity instanceof LivingEntity _livingEntity112 && _livingEntity112.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity112.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
											ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
									.getBlockPos().getY()),
							(entity.level()
									.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
											(entity instanceof LivingEntity _livingEntity114 && _livingEntity114.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity114.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
											ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
									.getBlockPos().getZ()),
							(entity.level()
									.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
											(entity instanceof LivingEntity _livingEntity116 && _livingEntity116.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity116.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
											ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
									.getBlockPos().getX() + 1),
							(entity.level()
									.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
											(entity instanceof LivingEntity _livingEntity118 && _livingEntity118.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity118.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
											ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
									.getBlockPos().getY()),
							(entity.level()
									.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
											(entity instanceof LivingEntity _livingEntity120 && _livingEntity120.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity120.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
											ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
									.getBlockPos().getZ() + 1),
							255 << 24 | 255 << 16 | 255 << 8 | 255);
					renderLine(
							(entity.level()
									.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
											(entity instanceof LivingEntity _livingEntity124 && _livingEntity124.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity124.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
											ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
									.getBlockPos().getX() + 1),
							(entity.level()
									.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
											(entity instanceof LivingEntity _livingEntity126 && _livingEntity126.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity126.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
											ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
									.getBlockPos().getY()),
							(entity.level()
									.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
											(entity instanceof LivingEntity _livingEntity128 && _livingEntity128.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity128.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
											ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
									.getBlockPos().getZ() + 1),
							(entity.level()
									.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
											(entity instanceof LivingEntity _livingEntity130 && _livingEntity130.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity130.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
											ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
									.getBlockPos().getX() + 1),
							(entity.level()
									.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
											(entity instanceof LivingEntity _livingEntity132 && _livingEntity132.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity132.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
											ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
									.getBlockPos().getY() + 1),
							(entity.level()
									.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
											(entity instanceof LivingEntity _livingEntity134 && _livingEntity134.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity134.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
											ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
									.getBlockPos().getZ() + 1),
							255 << 24 | 255 << 16 | 255 << 8 | 255);
					renderLine(
							(entity.level()
									.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
											(entity instanceof LivingEntity _livingEntity138 && _livingEntity138.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity138.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
											ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
									.getBlockPos().getX() + 1),
							(entity.level()
									.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
											(entity instanceof LivingEntity _livingEntity140 && _livingEntity140.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity140.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
											ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
									.getBlockPos().getY() + 1),
							(entity.level()
									.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
											(entity instanceof LivingEntity _livingEntity142 && _livingEntity142.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity142.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
											ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
									.getBlockPos().getZ()),
							(entity.level()
									.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
											(entity instanceof LivingEntity _livingEntity144 && _livingEntity144.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity144.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
											ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
									.getBlockPos().getX() + 1),
							(entity.level()
									.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
											(entity instanceof LivingEntity _livingEntity146 && _livingEntity146.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity146.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
											ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
									.getBlockPos().getY() + 1),
							(entity.level()
									.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
											(entity instanceof LivingEntity _livingEntity148 && _livingEntity148.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity148.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
											ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
									.getBlockPos().getZ() + 1),
							255 << 24 | 255 << 16 | 255 << 8 | 255);
					renderLine(
							(entity.level()
									.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
											(entity instanceof LivingEntity _livingEntity152 && _livingEntity152.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity152.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
											ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
									.getBlockPos().getX()),
							(entity.level()
									.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
											(entity instanceof LivingEntity _livingEntity154 && _livingEntity154.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity154.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
											ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
									.getBlockPos().getY()),
							(entity.level()
									.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
											(entity instanceof LivingEntity _livingEntity156 && _livingEntity156.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity156.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
											ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
									.getBlockPos().getZ() + 1),
							(entity.level()
									.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
											(entity instanceof LivingEntity _livingEntity158 && _livingEntity158.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity158.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
											ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
									.getBlockPos().getX() + 1),
							(entity.level()
									.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
											(entity instanceof LivingEntity _livingEntity160 && _livingEntity160.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity160.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
											ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
									.getBlockPos().getY()),
							(entity.level()
									.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
											(entity instanceof LivingEntity _livingEntity162 && _livingEntity162.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity162.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
											ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
									.getBlockPos().getZ() + 1),
							255 << 24 | 255 << 16 | 255 << 8 | 255);
					renderLine(
							(entity.level()
									.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
											(entity instanceof LivingEntity _livingEntity166 && _livingEntity166.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity166.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
											ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
									.getBlockPos().getX()),
							(entity.level()
									.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
											(entity instanceof LivingEntity _livingEntity168 && _livingEntity168.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity168.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
											ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
									.getBlockPos().getY() + 1),
							(entity.level()
									.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
											(entity instanceof LivingEntity _livingEntity170 && _livingEntity170.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity170.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
											ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
									.getBlockPos().getZ() + 1),
							(entity.level()
									.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
											(entity instanceof LivingEntity _livingEntity172 && _livingEntity172.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity172.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
											ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
									.getBlockPos().getX() + 1),
							(entity.level()
									.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
											(entity instanceof LivingEntity _livingEntity174 && _livingEntity174.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity174.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
											ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
									.getBlockPos().getY() + 1),
							(entity.level()
									.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
											(entity instanceof LivingEntity _livingEntity176 && _livingEntity176.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity176.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
											ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
									.getBlockPos().getZ() + 1),
							255 << 24 | 255 << 16 | 255 << 8 | 255);
				}
			} else {
				if (entity.isShiftKeyDown()) {
					if ((world.getBlockState(new BlockPos(
							entity.level()
									.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
											(entity instanceof LivingEntity _livingEntity181 && _livingEntity181.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity181.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
											ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity))
									.getBlockPos().getX(),
							entity.level()
									.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
											(entity instanceof LivingEntity _livingEntity183 && _livingEntity183.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity183.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
											ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity))
									.getBlockPos().getY(),
							entity.level()
									.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
											(entity instanceof LivingEntity _livingEntity185 && _livingEntity185.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity185.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
											ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity))
									.getBlockPos().getZ())))
							.getBlock() == ZeldaCraftModBlocks.SHEIKAH_LINK.get()) {
						renderLine(
								(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
										(entity instanceof LivingEntity _livingEntity189 && _livingEntity189.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity189.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
										ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity)).getBlockPos().getX()),
								(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
										(entity instanceof LivingEntity _livingEntity191 && _livingEntity191.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity191.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
										ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity)).getBlockPos().getY()),
								(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
										(entity instanceof LivingEntity _livingEntity193 && _livingEntity193.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity193.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
										ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ()),
								(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
										(entity instanceof LivingEntity _livingEntity195 && _livingEntity195.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity195.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
										ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity)).getBlockPos().getX() + 1),
								(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
										(entity instanceof LivingEntity _livingEntity197 && _livingEntity197.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity197.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
										ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity)).getBlockPos().getY()),
								(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
										(entity instanceof LivingEntity _livingEntity199 && _livingEntity199.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity199.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
										ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ()),
								255 << 24 | 255 << 16 | 255 << 8 | 255);
						renderLine(
								(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
										(entity instanceof LivingEntity _livingEntity203 && _livingEntity203.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity203.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
										ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getX()),
								(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
										(entity instanceof LivingEntity _livingEntity205 && _livingEntity205.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity205.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
										ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getY()),
								(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
										(entity instanceof LivingEntity _livingEntity207 && _livingEntity207.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity207.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
										ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ()),
								(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
										(entity instanceof LivingEntity _livingEntity209 && _livingEntity209.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity209.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
										ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getX()),
								(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
										(entity instanceof LivingEntity _livingEntity211 && _livingEntity211.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity211.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
										ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getY() + 1),
								(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
										(entity instanceof LivingEntity _livingEntity213 && _livingEntity213.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity213.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
										ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ()),
								255 << 24 | 255 << 16 | 255 << 8 | 255);
						renderLine(
								(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
										(entity instanceof LivingEntity _livingEntity217 && _livingEntity217.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity217.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
										ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getX() + 1),
								(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
										(entity instanceof LivingEntity _livingEntity219 && _livingEntity219.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity219.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
										ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getY()),
								(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
										(entity instanceof LivingEntity _livingEntity221 && _livingEntity221.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity221.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
										ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ()),
								(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
										(entity instanceof LivingEntity _livingEntity223 && _livingEntity223.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity223.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
										ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getX() + 1),
								(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
										(entity instanceof LivingEntity _livingEntity225 && _livingEntity225.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity225.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
										ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getY() + 1),
								(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
										(entity instanceof LivingEntity _livingEntity227 && _livingEntity227.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity227.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
										ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ()),
								255 << 24 | 255 << 16 | 255 << 8 | 255);
						renderLine(
								(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
										(entity instanceof LivingEntity _livingEntity231 && _livingEntity231.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity231.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
										ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getX()),
								(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
										(entity instanceof LivingEntity _livingEntity233 && _livingEntity233.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity233.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
										ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getY() + 1),
								(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
										(entity instanceof LivingEntity _livingEntity235 && _livingEntity235.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity235.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
										ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ()),
								(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
										(entity instanceof LivingEntity _livingEntity237 && _livingEntity237.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity237.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
										ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getX() + 1),
								(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
										(entity instanceof LivingEntity _livingEntity239 && _livingEntity239.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity239.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
										ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getY() + 1),
								(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
										(entity instanceof LivingEntity _livingEntity241 && _livingEntity241.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity241.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
										ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ()),
								255 << 24 | 255 << 16 | 255 << 8 | 255);
						renderLine(
								(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
										(entity instanceof LivingEntity _livingEntity245 && _livingEntity245.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity245.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
										ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getX()),
								(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
										(entity instanceof LivingEntity _livingEntity247 && _livingEntity247.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity247.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
										ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getY()),
								(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
										(entity instanceof LivingEntity _livingEntity249 && _livingEntity249.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity249.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
										ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ()),
								(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
										(entity instanceof LivingEntity _livingEntity251 && _livingEntity251.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity251.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
										ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getX()),
								(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
										(entity instanceof LivingEntity _livingEntity253 && _livingEntity253.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity253.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
										ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getY()),
								(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
										(entity instanceof LivingEntity _livingEntity255 && _livingEntity255.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity255.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
										ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ() + 1),
								255 << 24 | 255 << 16 | 255 << 8 | 255);
						renderLine(
								(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
										(entity instanceof LivingEntity _livingEntity259 && _livingEntity259.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity259.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
										ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getX()),
								(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
										(entity instanceof LivingEntity _livingEntity261 && _livingEntity261.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity261.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
										ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getY()),
								(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
										(entity instanceof LivingEntity _livingEntity263 && _livingEntity263.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity263.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
										ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ() + 1),
								(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
										(entity instanceof LivingEntity _livingEntity265 && _livingEntity265.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity265.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
										ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getX()),
								(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
										(entity instanceof LivingEntity _livingEntity267 && _livingEntity267.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity267.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
										ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getY() + 1),
								(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
										(entity instanceof LivingEntity _livingEntity269 && _livingEntity269.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity269.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
										ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ() + 1),
								255 << 24 | 255 << 16 | 255 << 8 | 255);
						renderLine(
								(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
										(entity instanceof LivingEntity _livingEntity273 && _livingEntity273.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity273.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
										ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getX()),
								(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
										(entity instanceof LivingEntity _livingEntity275 && _livingEntity275.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity275.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
										ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getY() + 1),
								(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
										(entity instanceof LivingEntity _livingEntity277 && _livingEntity277.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity277.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
										ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ()),
								(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
										(entity instanceof LivingEntity _livingEntity279 && _livingEntity279.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity279.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
										ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getX()),
								(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
										(entity instanceof LivingEntity _livingEntity281 && _livingEntity281.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity281.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
										ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getY() + 1),
								(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
										(entity instanceof LivingEntity _livingEntity283 && _livingEntity283.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity283.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
										ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ() + 1),
								255 << 24 | 255 << 16 | 255 << 8 | 255);
						renderLine(
								(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
										(entity instanceof LivingEntity _livingEntity287 && _livingEntity287.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity287.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
										ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getX() + 1),
								(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
										(entity instanceof LivingEntity _livingEntity289 && _livingEntity289.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity289.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
										ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getY()),
								(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
										(entity instanceof LivingEntity _livingEntity291 && _livingEntity291.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity291.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
										ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ()),
								(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
										(entity instanceof LivingEntity _livingEntity293 && _livingEntity293.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity293.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
										ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getX() + 1),
								(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
										(entity instanceof LivingEntity _livingEntity295 && _livingEntity295.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity295.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
										ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getY()),
								(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
										(entity instanceof LivingEntity _livingEntity297 && _livingEntity297.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity297.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
										ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ() + 1),
								255 << 24 | 255 << 16 | 255 << 8 | 255);
						renderLine(
								(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
										(entity instanceof LivingEntity _livingEntity301 && _livingEntity301.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity301.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
										ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getX() + 1),
								(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
										(entity instanceof LivingEntity _livingEntity303 && _livingEntity303.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity303.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
										ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getY()),
								(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
										(entity instanceof LivingEntity _livingEntity305 && _livingEntity305.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity305.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
										ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ() + 1),
								(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
										(entity instanceof LivingEntity _livingEntity307 && _livingEntity307.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity307.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
										ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getX() + 1),
								(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
										(entity instanceof LivingEntity _livingEntity309 && _livingEntity309.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity309.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
										ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getY() + 1),
								(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
										(entity instanceof LivingEntity _livingEntity311 && _livingEntity311.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity311.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
										ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ() + 1),
								255 << 24 | 255 << 16 | 255 << 8 | 255);
						renderLine(
								(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
										(entity instanceof LivingEntity _livingEntity315 && _livingEntity315.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity315.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
										ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getX() + 1),
								(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
										(entity instanceof LivingEntity _livingEntity317 && _livingEntity317.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity317.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
										ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getY() + 1),
								(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
										(entity instanceof LivingEntity _livingEntity319 && _livingEntity319.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity319.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
										ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ()),
								(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
										(entity instanceof LivingEntity _livingEntity321 && _livingEntity321.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity321.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
										ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getX() + 1),
								(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
										(entity instanceof LivingEntity _livingEntity323 && _livingEntity323.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity323.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
										ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getY() + 1),
								(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
										(entity instanceof LivingEntity _livingEntity325 && _livingEntity325.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity325.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
										ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ() + 1),
								255 << 24 | 255 << 16 | 255 << 8 | 255);
						renderLine(
								(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
										(entity instanceof LivingEntity _livingEntity329 && _livingEntity329.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity329.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
										ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getX()),
								(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
										(entity instanceof LivingEntity _livingEntity331 && _livingEntity331.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity331.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
										ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getY()),
								(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
										(entity instanceof LivingEntity _livingEntity333 && _livingEntity333.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity333.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
										ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ() + 1),
								(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
										(entity instanceof LivingEntity _livingEntity335 && _livingEntity335.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity335.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
										ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getX() + 1),
								(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
										(entity instanceof LivingEntity _livingEntity337 && _livingEntity337.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity337.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
										ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getY()),
								(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
										(entity instanceof LivingEntity _livingEntity339 && _livingEntity339.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity339.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
										ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ() + 1),
								255 << 24 | 255 << 16 | 255 << 8 | 255);
						renderLine(
								(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
										(entity instanceof LivingEntity _livingEntity343 && _livingEntity343.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity343.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
										ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getX()),
								(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
										(entity instanceof LivingEntity _livingEntity345 && _livingEntity345.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity345.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
										ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getY() + 1),
								(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
										(entity instanceof LivingEntity _livingEntity347 && _livingEntity347.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity347.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
										ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ() + 1),
								(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
										(entity instanceof LivingEntity _livingEntity349 && _livingEntity349.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity349.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
										ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getX() + 1),
								(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
										(entity instanceof LivingEntity _livingEntity351 && _livingEntity351.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity351.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
										ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getY() + 1),
								(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
										(entity instanceof LivingEntity _livingEntity353 && _livingEntity353.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity353.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
										ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ() + 1),
								255 << 24 | 255 << 16 | 255 << 8 | 255);
					}
				}
			}
		}
	}
}
