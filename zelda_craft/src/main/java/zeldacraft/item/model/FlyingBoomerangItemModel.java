package zeldacraft.item.model;

import zeldacraft.item.FlyingBoomerangItem;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

public class FlyingBoomerangItemModel extends GeoModel<FlyingBoomerangItem> {
	@Override
	public ResourceLocation getAnimationResource(FlyingBoomerangItem animatable) {
		return new ResourceLocation("zelda_craft", "animations/boomerangprojectile.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(FlyingBoomerangItem animatable) {
		return new ResourceLocation("zelda_craft", "geo/boomerangprojectile.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(FlyingBoomerangItem animatable) {
		return new ResourceLocation("zelda_craft", "textures/item/boomerang.png");
	}
}
