package zeldacraft.entity.model;

import zeldacraft.entity.FairyEntity;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

public class FairyModel extends GeoModel<FairyEntity> {
	@Override
	public ResourceLocation getAnimationResource(FairyEntity entity) {
		return new ResourceLocation("zelda_craft", "animations/fairy.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(FairyEntity entity) {
		return new ResourceLocation("zelda_craft", "geo/fairy.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(FairyEntity entity) {
		return new ResourceLocation("zelda_craft", "textures/entities/" + entity.getTexture() + ".png");
	}

}
