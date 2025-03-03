
package zeldacraft.client.renderer;

import zeldacraft.entity.model.BombProjectileModel;
import zeldacraft.entity.layer.BombProjectileLayer;
import zeldacraft.entity.BombProjectileEntity;

import software.bernie.geckolib.renderer.GeoEntityRenderer;
import software.bernie.geckolib.cache.object.BakedGeoModel;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;

public class BombProjectileRenderer extends GeoEntityRenderer<BombProjectileEntity> {
	public BombProjectileRenderer(EntityRendererProvider.Context renderManager) {
		super(renderManager, new BombProjectileModel());
		this.shadowRadius = 0.4f;
		this.addRenderLayer(new BombProjectileLayer(this));
	}

	@Override
	public RenderType getRenderType(BombProjectileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}

	@Override
	public void preRender(PoseStack poseStack, BombProjectileEntity entity, BakedGeoModel model, MultiBufferSource bufferSource, VertexConsumer buffer, boolean isReRender, float partialTick, int packedLight, int packedOverlay, float red, float green,
			float blue, float alpha) {
		float scale = 1f;
		this.scaleHeight = scale;
		this.scaleWidth = scale;
		super.preRender(poseStack, entity, model, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, red, green, blue, alpha);
	}

	@Override
	protected float getDeathMaxRotation(BombProjectileEntity entityLivingBaseIn) {
		return 0.0F;
	}
}
