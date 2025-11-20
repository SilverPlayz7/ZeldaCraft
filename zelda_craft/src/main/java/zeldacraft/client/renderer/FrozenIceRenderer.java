package zeldacraft.client.renderer;

import zeldacraft.entity.FrozenIceEntity;

import zeldacraft.client.model.Modelice;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.Minecraft;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class FrozenIceRenderer extends MobRenderer<FrozenIceEntity, Modelice<FrozenIceEntity>> {
	public FrozenIceRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelice<FrozenIceEntity>(context.bakeLayer(Modelice.LAYER_LOCATION)), 0.5f);
		this.addLayer(new RenderLayer<FrozenIceEntity, Modelice<FrozenIceEntity>>(this) {
			final ResourceLocation LAYER_TEXTURE = ResourceLocation.parse("zelda_craft:textures/entities/ice.png");

			@Override
			public void render(PoseStack poseStack, MultiBufferSource bufferSource, int light, FrozenIceEntity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
				VertexConsumer vertexConsumer = bufferSource.getBuffer(RenderType.entityTranslucent(LAYER_TEXTURE));
				EntityModel model = new Modelice(Minecraft.getInstance().getEntityModels().bakeLayer(Modelice.LAYER_LOCATION));
				this.getParentModel().copyPropertiesTo(model);
				model.prepareMobModel(entity, limbSwing, limbSwingAmount, partialTicks);
				model.setupAnim(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
				model.renderToBuffer(poseStack, vertexConsumer, light, LivingEntityRenderer.getOverlayCoords(entity, 0), 1, 1, 1, 1);
			}
		});
		this.addLayer(new RenderLayer<FrozenIceEntity, Modelice<FrozenIceEntity>>(this) {
			final ResourceLocation LAYER_TEXTURE = ResourceLocation.parse("zelda_craft:textures/entities/snow.png");

			@Override
			public void render(PoseStack poseStack, MultiBufferSource bufferSource, int light, FrozenIceEntity entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
				VertexConsumer vertexConsumer = bufferSource.getBuffer(RenderType.entityCutoutNoCull(LAYER_TEXTURE));
				EntityModel model = new Modelice(Minecraft.getInstance().getEntityModels().bakeLayer(Modelice.LAYER_LOCATION));
				this.getParentModel().copyPropertiesTo(model);
				model.prepareMobModel(entity, limbSwing, limbSwingAmount, partialTicks);
				model.setupAnim(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
				model.renderToBuffer(poseStack, vertexConsumer, light, LivingEntityRenderer.getOverlayCoords(entity, 0), 1, 1, 1, 1);
			}
		});
	}

	@Override
	public ResourceLocation getTextureLocation(FrozenIceEntity entity) {
		return ResourceLocation.parse("zelda_craft:textures/entities/norender.png");
	}
}