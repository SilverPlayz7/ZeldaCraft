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
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.tags.BlockTags;
import net.minecraft.resources.ResourceLocation;
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
		if (((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() instanceof BlockItem _bi ? _bi.getBlock().defaultBlockState() : Blocks.AIR.defaultBlockState())
				.is(BlockTags.create(ResourceLocation.parse("zelda_craft:switch")))) {
			if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().getBoolean("haslocation") == false) {
				if ((world
						.getBlockState(new BlockPos(
								entity.level()
										.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
												(entity instanceof LivingEntity _livingEntity5 && _livingEntity5.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity5.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
												ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity))
										.getBlockPos().getX(),
								entity.level()
										.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
												(entity instanceof LivingEntity _livingEntity7 && _livingEntity7.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity7.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
												ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity))
										.getBlockPos().getY(),
								entity.level()
										.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
												(entity instanceof LivingEntity _livingEntity9 && _livingEntity9.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity9.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
												ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity))
										.getBlockPos().getZ())))
						.getBlock() == ZeldaCraftModBlocks.SHEIKAH_LINK.get()) {
					renderLine(
							(entity.level()
									.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
											(entity instanceof LivingEntity _livingEntity13 && _livingEntity13.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity13.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
											ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity))
									.getBlockPos().getX()),
							(entity.level()
									.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
											(entity instanceof LivingEntity _livingEntity15 && _livingEntity15.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity15.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
											ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity))
									.getBlockPos().getY()),
							(entity.level()
									.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
											(entity instanceof LivingEntity _livingEntity17 && _livingEntity17.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity17.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
											ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity))
									.getBlockPos().getZ()),
							(entity.level()
									.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
											(entity instanceof LivingEntity _livingEntity19 && _livingEntity19.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity19.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
											ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity))
									.getBlockPos().getX() + 1),
							(entity.level()
									.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
											(entity instanceof LivingEntity _livingEntity21 && _livingEntity21.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity21.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
											ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity))
									.getBlockPos().getY()),
							(entity.level()
									.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
											(entity instanceof LivingEntity _livingEntity23 && _livingEntity23.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity23.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
											ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity))
									.getBlockPos().getZ()),
							255 << 24 | 255 << 16 | 255 << 8 | 255);
					renderLine(
							(entity.level()
									.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
											(entity instanceof LivingEntity _livingEntity27 && _livingEntity27.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity27.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
											ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
									.getBlockPos().getX()),
							(entity.level()
									.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
											(entity instanceof LivingEntity _livingEntity29 && _livingEntity29.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity29.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
											ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
									.getBlockPos().getY()),
							(entity.level()
									.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
											(entity instanceof LivingEntity _livingEntity31 && _livingEntity31.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity31.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
											ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
									.getBlockPos().getZ()),
							(entity.level()
									.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
											(entity instanceof LivingEntity _livingEntity33 && _livingEntity33.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity33.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
											ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
									.getBlockPos().getX()),
							(entity.level()
									.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
											(entity instanceof LivingEntity _livingEntity35 && _livingEntity35.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity35.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
											ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
									.getBlockPos().getY() + 1),
							(entity.level()
									.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
											(entity instanceof LivingEntity _livingEntity37 && _livingEntity37.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity37.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
											ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
									.getBlockPos().getZ()),
							255 << 24 | 255 << 16 | 255 << 8 | 255);
					renderLine(
							(entity.level()
									.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
											(entity instanceof LivingEntity _livingEntity41 && _livingEntity41.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity41.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
											ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
									.getBlockPos().getX() + 1),
							(entity.level()
									.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
											(entity instanceof LivingEntity _livingEntity43 && _livingEntity43.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity43.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
											ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
									.getBlockPos().getY()),
							(entity.level()
									.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
											(entity instanceof LivingEntity _livingEntity45 && _livingEntity45.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity45.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
											ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
									.getBlockPos().getZ()),
							(entity.level()
									.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
											(entity instanceof LivingEntity _livingEntity47 && _livingEntity47.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity47.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
											ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
									.getBlockPos().getX() + 1),
							(entity.level()
									.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
											(entity instanceof LivingEntity _livingEntity49 && _livingEntity49.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity49.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
											ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
									.getBlockPos().getY() + 1),
							(entity.level()
									.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
											(entity instanceof LivingEntity _livingEntity51 && _livingEntity51.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity51.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
											ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
									.getBlockPos().getZ()),
							255 << 24 | 255 << 16 | 255 << 8 | 255);
					renderLine(
							(entity.level()
									.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
											(entity instanceof LivingEntity _livingEntity55 && _livingEntity55.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity55.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
											ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
									.getBlockPos().getX()),
							(entity.level()
									.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
											(entity instanceof LivingEntity _livingEntity57 && _livingEntity57.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity57.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
											ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
									.getBlockPos().getY() + 1),
							(entity.level()
									.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
											(entity instanceof LivingEntity _livingEntity59 && _livingEntity59.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity59.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
											ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
									.getBlockPos().getZ()),
							(entity.level()
									.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
											(entity instanceof LivingEntity _livingEntity61 && _livingEntity61.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity61.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
											ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
									.getBlockPos().getX() + 1),
							(entity.level()
									.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
											(entity instanceof LivingEntity _livingEntity63 && _livingEntity63.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity63.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
											ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
									.getBlockPos().getY() + 1),
							(entity.level()
									.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
											(entity instanceof LivingEntity _livingEntity65 && _livingEntity65.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity65.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
											ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
									.getBlockPos().getZ()),
							255 << 24 | 255 << 16 | 255 << 8 | 255);
					renderLine(
							(entity.level()
									.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
											(entity instanceof LivingEntity _livingEntity69 && _livingEntity69.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity69.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
											ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
									.getBlockPos().getX()),
							(entity.level()
									.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
											(entity instanceof LivingEntity _livingEntity71 && _livingEntity71.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity71.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
											ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
									.getBlockPos().getY()),
							(entity.level()
									.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
											(entity instanceof LivingEntity _livingEntity73 && _livingEntity73.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity73.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
											ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
									.getBlockPos().getZ()),
							(entity.level()
									.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
											(entity instanceof LivingEntity _livingEntity75 && _livingEntity75.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity75.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
											ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
									.getBlockPos().getX()),
							(entity.level()
									.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
											(entity instanceof LivingEntity _livingEntity77 && _livingEntity77.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity77.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
											ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
									.getBlockPos().getY()),
							(entity.level()
									.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
											(entity instanceof LivingEntity _livingEntity79 && _livingEntity79.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity79.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
											ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
									.getBlockPos().getZ() + 1),
							255 << 24 | 255 << 16 | 255 << 8 | 255);
					renderLine(
							(entity.level()
									.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
											(entity instanceof LivingEntity _livingEntity83 && _livingEntity83.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity83.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
											ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
									.getBlockPos().getX()),
							(entity.level()
									.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
											(entity instanceof LivingEntity _livingEntity85 && _livingEntity85.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity85.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
											ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
									.getBlockPos().getY()),
							(entity.level()
									.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
											(entity instanceof LivingEntity _livingEntity87 && _livingEntity87.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity87.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
											ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
									.getBlockPos().getZ() + 1),
							(entity.level()
									.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
											(entity instanceof LivingEntity _livingEntity89 && _livingEntity89.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity89.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
											ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
									.getBlockPos().getX()),
							(entity.level()
									.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
											(entity instanceof LivingEntity _livingEntity91 && _livingEntity91.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity91.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
											ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
									.getBlockPos().getY() + 1),
							(entity.level()
									.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
											(entity instanceof LivingEntity _livingEntity93 && _livingEntity93.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity93.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
											ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
									.getBlockPos().getZ() + 1),
							255 << 24 | 255 << 16 | 255 << 8 | 255);
					renderLine(
							(entity.level()
									.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
											(entity instanceof LivingEntity _livingEntity97 && _livingEntity97.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity97.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
											ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
									.getBlockPos().getX()),
							(entity.level()
									.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
											(entity instanceof LivingEntity _livingEntity99 && _livingEntity99.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity99.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
											ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
									.getBlockPos().getY() + 1),
							(entity.level()
									.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
											(entity instanceof LivingEntity _livingEntity101 && _livingEntity101.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity101.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
											ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
									.getBlockPos().getZ()),
							(entity.level()
									.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
											(entity instanceof LivingEntity _livingEntity103 && _livingEntity103.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity103.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
											ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
									.getBlockPos().getX()),
							(entity.level()
									.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
											(entity instanceof LivingEntity _livingEntity105 && _livingEntity105.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity105.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
											ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
									.getBlockPos().getY() + 1),
							(entity.level()
									.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
											(entity instanceof LivingEntity _livingEntity107 && _livingEntity107.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity107.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
											ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
									.getBlockPos().getZ() + 1),
							255 << 24 | 255 << 16 | 255 << 8 | 255);
					renderLine(
							(entity.level()
									.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
											(entity instanceof LivingEntity _livingEntity111 && _livingEntity111.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity111.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
											ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
									.getBlockPos().getX() + 1),
							(entity.level()
									.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
											(entity instanceof LivingEntity _livingEntity113 && _livingEntity113.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity113.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
											ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
									.getBlockPos().getY()),
							(entity.level()
									.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
											(entity instanceof LivingEntity _livingEntity115 && _livingEntity115.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity115.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
											ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
									.getBlockPos().getZ()),
							(entity.level()
									.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
											(entity instanceof LivingEntity _livingEntity117 && _livingEntity117.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity117.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
											ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
									.getBlockPos().getX() + 1),
							(entity.level()
									.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
											(entity instanceof LivingEntity _livingEntity119 && _livingEntity119.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity119.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
											ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
									.getBlockPos().getY()),
							(entity.level()
									.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
											(entity instanceof LivingEntity _livingEntity121 && _livingEntity121.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity121.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
											ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
									.getBlockPos().getZ() + 1),
							255 << 24 | 255 << 16 | 255 << 8 | 255);
					renderLine(
							(entity.level()
									.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
											(entity instanceof LivingEntity _livingEntity125 && _livingEntity125.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity125.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
											ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
									.getBlockPos().getX() + 1),
							(entity.level()
									.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
											(entity instanceof LivingEntity _livingEntity127 && _livingEntity127.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity127.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
											ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
									.getBlockPos().getY()),
							(entity.level()
									.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
											(entity instanceof LivingEntity _livingEntity129 && _livingEntity129.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity129.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
											ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
									.getBlockPos().getZ() + 1),
							(entity.level()
									.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
											(entity instanceof LivingEntity _livingEntity131 && _livingEntity131.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity131.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
											ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
									.getBlockPos().getX() + 1),
							(entity.level()
									.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
											(entity instanceof LivingEntity _livingEntity133 && _livingEntity133.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity133.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
											ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
									.getBlockPos().getY() + 1),
							(entity.level()
									.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
											(entity instanceof LivingEntity _livingEntity135 && _livingEntity135.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity135.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
											ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
									.getBlockPos().getZ() + 1),
							255 << 24 | 255 << 16 | 255 << 8 | 255);
					renderLine(
							(entity.level()
									.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
											(entity instanceof LivingEntity _livingEntity139 && _livingEntity139.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity139.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
											ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
									.getBlockPos().getX() + 1),
							(entity.level()
									.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
											(entity instanceof LivingEntity _livingEntity141 && _livingEntity141.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity141.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
											ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
									.getBlockPos().getY() + 1),
							(entity.level()
									.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
											(entity instanceof LivingEntity _livingEntity143 && _livingEntity143.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity143.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
											ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
									.getBlockPos().getZ()),
							(entity.level()
									.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
											(entity instanceof LivingEntity _livingEntity145 && _livingEntity145.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity145.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
											ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
									.getBlockPos().getX() + 1),
							(entity.level()
									.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
											(entity instanceof LivingEntity _livingEntity147 && _livingEntity147.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity147.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
											ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
									.getBlockPos().getY() + 1),
							(entity.level()
									.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
											(entity instanceof LivingEntity _livingEntity149 && _livingEntity149.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity149.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
											ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
									.getBlockPos().getZ() + 1),
							255 << 24 | 255 << 16 | 255 << 8 | 255);
					renderLine(
							(entity.level()
									.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
											(entity instanceof LivingEntity _livingEntity153 && _livingEntity153.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity153.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
											ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
									.getBlockPos().getX()),
							(entity.level()
									.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
											(entity instanceof LivingEntity _livingEntity155 && _livingEntity155.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity155.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
											ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
									.getBlockPos().getY()),
							(entity.level()
									.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
											(entity instanceof LivingEntity _livingEntity157 && _livingEntity157.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity157.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
											ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
									.getBlockPos().getZ() + 1),
							(entity.level()
									.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
											(entity instanceof LivingEntity _livingEntity159 && _livingEntity159.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity159.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
											ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
									.getBlockPos().getX() + 1),
							(entity.level()
									.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
											(entity instanceof LivingEntity _livingEntity161 && _livingEntity161.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity161.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
											ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
									.getBlockPos().getY()),
							(entity.level()
									.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
											(entity instanceof LivingEntity _livingEntity163 && _livingEntity163.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity163.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
											ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
									.getBlockPos().getZ() + 1),
							255 << 24 | 255 << 16 | 255 << 8 | 255);
					renderLine(
							(entity.level()
									.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
											(entity instanceof LivingEntity _livingEntity167 && _livingEntity167.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity167.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
											ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
									.getBlockPos().getX()),
							(entity.level()
									.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
											(entity instanceof LivingEntity _livingEntity169 && _livingEntity169.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity169.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
											ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
									.getBlockPos().getY() + 1),
							(entity.level()
									.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
											(entity instanceof LivingEntity _livingEntity171 && _livingEntity171.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity171.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
											ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
									.getBlockPos().getZ() + 1),
							(entity.level()
									.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
											(entity instanceof LivingEntity _livingEntity173 && _livingEntity173.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity173.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
											ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
									.getBlockPos().getX() + 1),
							(entity.level()
									.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
											(entity instanceof LivingEntity _livingEntity175 && _livingEntity175.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity175.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
											ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
									.getBlockPos().getY() + 1),
							(entity.level()
									.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
											(entity instanceof LivingEntity _livingEntity177 && _livingEntity177.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity177.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
											ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity))
									.getBlockPos().getZ() + 1),
							255 << 24 | 255 << 16 | 255 << 8 | 255);
				}
			} else {
				if (entity.isShiftKeyDown()) {
					if ((world.getBlockState(new BlockPos(
							entity.level()
									.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
											(entity instanceof LivingEntity _livingEntity182 && _livingEntity182.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity182.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
											ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity))
									.getBlockPos().getX(),
							entity.level()
									.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
											(entity instanceof LivingEntity _livingEntity184 && _livingEntity184.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity184.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
											ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity))
									.getBlockPos().getY(),
							entity.level()
									.clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
											(entity instanceof LivingEntity _livingEntity186 && _livingEntity186.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity186.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
											ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity))
									.getBlockPos().getZ())))
							.getBlock() == ZeldaCraftModBlocks.SHEIKAH_LINK.get()) {
						renderLine(
								(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
										(entity instanceof LivingEntity _livingEntity190 && _livingEntity190.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity190.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
										ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity)).getBlockPos().getX()),
								(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
										(entity instanceof LivingEntity _livingEntity192 && _livingEntity192.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity192.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
										ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity)).getBlockPos().getY()),
								(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
										(entity instanceof LivingEntity _livingEntity194 && _livingEntity194.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity194.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
										ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ()),
								(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
										(entity instanceof LivingEntity _livingEntity196 && _livingEntity196.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity196.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
										ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity)).getBlockPos().getX() + 1),
								(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
										(entity instanceof LivingEntity _livingEntity198 && _livingEntity198.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity198.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
										ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity)).getBlockPos().getY()),
								(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
										(entity instanceof LivingEntity _livingEntity200 && _livingEntity200.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity200.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
										ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ()),
								255 << 24 | 255 << 16 | 255 << 8 | 255);
						renderLine(
								(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
										(entity instanceof LivingEntity _livingEntity204 && _livingEntity204.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity204.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
										ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getX()),
								(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
										(entity instanceof LivingEntity _livingEntity206 && _livingEntity206.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity206.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
										ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getY()),
								(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
										(entity instanceof LivingEntity _livingEntity208 && _livingEntity208.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity208.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
										ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ()),
								(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
										(entity instanceof LivingEntity _livingEntity210 && _livingEntity210.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity210.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
										ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getX()),
								(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
										(entity instanceof LivingEntity _livingEntity212 && _livingEntity212.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity212.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
										ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getY() + 1),
								(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
										(entity instanceof LivingEntity _livingEntity214 && _livingEntity214.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity214.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
										ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ()),
								255 << 24 | 255 << 16 | 255 << 8 | 255);
						renderLine(
								(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
										(entity instanceof LivingEntity _livingEntity218 && _livingEntity218.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity218.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
										ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getX() + 1),
								(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
										(entity instanceof LivingEntity _livingEntity220 && _livingEntity220.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity220.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
										ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getY()),
								(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
										(entity instanceof LivingEntity _livingEntity222 && _livingEntity222.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity222.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
										ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ()),
								(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
										(entity instanceof LivingEntity _livingEntity224 && _livingEntity224.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity224.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
										ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getX() + 1),
								(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
										(entity instanceof LivingEntity _livingEntity226 && _livingEntity226.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity226.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
										ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getY() + 1),
								(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
										(entity instanceof LivingEntity _livingEntity228 && _livingEntity228.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity228.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
										ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ()),
								255 << 24 | 255 << 16 | 255 << 8 | 255);
						renderLine(
								(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
										(entity instanceof LivingEntity _livingEntity232 && _livingEntity232.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity232.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
										ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getX()),
								(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
										(entity instanceof LivingEntity _livingEntity234 && _livingEntity234.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity234.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
										ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getY() + 1),
								(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
										(entity instanceof LivingEntity _livingEntity236 && _livingEntity236.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity236.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
										ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ()),
								(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
										(entity instanceof LivingEntity _livingEntity238 && _livingEntity238.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity238.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
										ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getX() + 1),
								(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
										(entity instanceof LivingEntity _livingEntity240 && _livingEntity240.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity240.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
										ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getY() + 1),
								(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
										(entity instanceof LivingEntity _livingEntity242 && _livingEntity242.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity242.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
										ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ()),
								255 << 24 | 255 << 16 | 255 << 8 | 255);
						renderLine(
								(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
										(entity instanceof LivingEntity _livingEntity246 && _livingEntity246.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity246.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
										ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getX()),
								(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
										(entity instanceof LivingEntity _livingEntity248 && _livingEntity248.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity248.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
										ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getY()),
								(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
										(entity instanceof LivingEntity _livingEntity250 && _livingEntity250.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity250.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
										ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ()),
								(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
										(entity instanceof LivingEntity _livingEntity252 && _livingEntity252.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity252.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
										ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getX()),
								(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
										(entity instanceof LivingEntity _livingEntity254 && _livingEntity254.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity254.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
										ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getY()),
								(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
										(entity instanceof LivingEntity _livingEntity256 && _livingEntity256.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity256.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
										ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ() + 1),
								255 << 24 | 255 << 16 | 255 << 8 | 255);
						renderLine(
								(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
										(entity instanceof LivingEntity _livingEntity260 && _livingEntity260.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity260.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
										ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getX()),
								(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
										(entity instanceof LivingEntity _livingEntity262 && _livingEntity262.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity262.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
										ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getY()),
								(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
										(entity instanceof LivingEntity _livingEntity264 && _livingEntity264.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity264.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
										ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ() + 1),
								(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
										(entity instanceof LivingEntity _livingEntity266 && _livingEntity266.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity266.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
										ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getX()),
								(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
										(entity instanceof LivingEntity _livingEntity268 && _livingEntity268.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity268.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
										ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getY() + 1),
								(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
										(entity instanceof LivingEntity _livingEntity270 && _livingEntity270.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity270.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
										ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ() + 1),
								255 << 24 | 255 << 16 | 255 << 8 | 255);
						renderLine(
								(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
										(entity instanceof LivingEntity _livingEntity274 && _livingEntity274.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity274.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
										ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getX()),
								(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
										(entity instanceof LivingEntity _livingEntity276 && _livingEntity276.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity276.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
										ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getY() + 1),
								(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
										(entity instanceof LivingEntity _livingEntity278 && _livingEntity278.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity278.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
										ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ()),
								(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
										(entity instanceof LivingEntity _livingEntity280 && _livingEntity280.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity280.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
										ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getX()),
								(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
										(entity instanceof LivingEntity _livingEntity282 && _livingEntity282.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity282.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
										ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getY() + 1),
								(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
										(entity instanceof LivingEntity _livingEntity284 && _livingEntity284.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity284.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
										ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ() + 1),
								255 << 24 | 255 << 16 | 255 << 8 | 255);
						renderLine(
								(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
										(entity instanceof LivingEntity _livingEntity288 && _livingEntity288.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity288.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
										ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getX() + 1),
								(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
										(entity instanceof LivingEntity _livingEntity290 && _livingEntity290.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity290.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
										ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getY()),
								(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
										(entity instanceof LivingEntity _livingEntity292 && _livingEntity292.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity292.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
										ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ()),
								(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
										(entity instanceof LivingEntity _livingEntity294 && _livingEntity294.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity294.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
										ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getX() + 1),
								(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
										(entity instanceof LivingEntity _livingEntity296 && _livingEntity296.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity296.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
										ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getY()),
								(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
										(entity instanceof LivingEntity _livingEntity298 && _livingEntity298.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity298.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
										ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ() + 1),
								255 << 24 | 255 << 16 | 255 << 8 | 255);
						renderLine(
								(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
										(entity instanceof LivingEntity _livingEntity302 && _livingEntity302.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity302.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
										ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getX() + 1),
								(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
										(entity instanceof LivingEntity _livingEntity304 && _livingEntity304.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity304.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
										ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getY()),
								(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
										(entity instanceof LivingEntity _livingEntity306 && _livingEntity306.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity306.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
										ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ() + 1),
								(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
										(entity instanceof LivingEntity _livingEntity308 && _livingEntity308.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity308.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
										ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getX() + 1),
								(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
										(entity instanceof LivingEntity _livingEntity310 && _livingEntity310.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity310.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
										ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getY() + 1),
								(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
										(entity instanceof LivingEntity _livingEntity312 && _livingEntity312.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity312.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
										ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ() + 1),
								255 << 24 | 255 << 16 | 255 << 8 | 255);
						renderLine(
								(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
										(entity instanceof LivingEntity _livingEntity316 && _livingEntity316.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity316.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
										ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getX() + 1),
								(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
										(entity instanceof LivingEntity _livingEntity318 && _livingEntity318.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity318.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
										ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getY() + 1),
								(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
										(entity instanceof LivingEntity _livingEntity320 && _livingEntity320.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity320.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
										ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ()),
								(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
										(entity instanceof LivingEntity _livingEntity322 && _livingEntity322.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity322.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
										ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getX() + 1),
								(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
										(entity instanceof LivingEntity _livingEntity324 && _livingEntity324.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity324.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
										ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getY() + 1),
								(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
										(entity instanceof LivingEntity _livingEntity326 && _livingEntity326.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity326.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
										ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ() + 1),
								255 << 24 | 255 << 16 | 255 << 8 | 255);
						renderLine(
								(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
										(entity instanceof LivingEntity _livingEntity330 && _livingEntity330.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity330.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
										ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getX()),
								(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
										(entity instanceof LivingEntity _livingEntity332 && _livingEntity332.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity332.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
										ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getY()),
								(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
										(entity instanceof LivingEntity _livingEntity334 && _livingEntity334.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity334.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
										ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ() + 1),
								(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
										(entity instanceof LivingEntity _livingEntity336 && _livingEntity336.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity336.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
										ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getX() + 1),
								(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
										(entity instanceof LivingEntity _livingEntity338 && _livingEntity338.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity338.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
										ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getY()),
								(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
										(entity instanceof LivingEntity _livingEntity340 && _livingEntity340.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity340.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
										ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ() + 1),
								255 << 24 | 255 << 16 | 255 << 8 | 255);
						renderLine(
								(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
										(entity instanceof LivingEntity _livingEntity344 && _livingEntity344.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity344.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
										ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getX()),
								(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
										(entity instanceof LivingEntity _livingEntity346 && _livingEntity346.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity346.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
										ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getY() + 1),
								(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
										(entity instanceof LivingEntity _livingEntity348 && _livingEntity348.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity348.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
										ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ() + 1),
								(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
										(entity instanceof LivingEntity _livingEntity350 && _livingEntity350.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity350.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
										ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getX() + 1),
								(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
										(entity instanceof LivingEntity _livingEntity352 && _livingEntity352.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity352.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
										ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getY() + 1),
								(entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(
										(entity instanceof LivingEntity _livingEntity354 && _livingEntity354.getAttributes().hasAttribute(ForgeMod.BLOCK_REACH.get()) ? _livingEntity354.getAttribute(ForgeMod.BLOCK_REACH.get()).getValue() : 0))),
										ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ() + 1),
								255 << 24 | 255 << 16 | 255 << 8 | 255);
					}
				}
			}
		}
	}
}