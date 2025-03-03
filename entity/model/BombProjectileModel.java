package zeldacraft.entity.model;

import zeldacraft.entity.BombProjectileEntity;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

public class BombProjectileModel extends GeoModel<BombProjectileEntity> {
	@Override
	public ResourceLocation getAnimationResource(BombProjectileEntity entity) {
		return new ResourceLocation("zelda_craft", "animations/bombentity.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(BombProjectileEntity entity) {
		return new ResourceLocation("zelda_craft", "geo/bombentity.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(BombProjectileEntity entity) {
		return new ResourceLocation("zelda_craft", "textures/entities/" + entity.getTexture() + ".png");
	}

}
