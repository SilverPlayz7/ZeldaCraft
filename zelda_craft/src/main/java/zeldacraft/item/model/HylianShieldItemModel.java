package zeldacraft.item.model;

import zeldacraft.item.HylianShieldItem;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

public class HylianShieldItemModel extends GeoModel<HylianShieldItem> {
	@Override
	public ResourceLocation getAnimationResource(HylianShieldItem animatable) {
		return new ResourceLocation("zelda_craft", "animations/hylianshield.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(HylianShieldItem animatable) {
		return new ResourceLocation("zelda_craft", "geo/hylianshield.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(HylianShieldItem animatable) {
		return new ResourceLocation("zelda_craft", "textures/item/hylianshield.png");
	}
}
