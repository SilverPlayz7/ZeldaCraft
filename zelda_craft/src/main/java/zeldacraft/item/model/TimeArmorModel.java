package zeldacraft.item.model;

import zeldacraft.item.TimeArmorItem;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

public class TimeArmorModel extends GeoModel<TimeArmorItem> {
	@Override
	public ResourceLocation getAnimationResource(TimeArmorItem object) {
		return new ResourceLocation("zelda_craft", "animations/armoroftime.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(TimeArmorItem object) {
		return new ResourceLocation("zelda_craft", "geo/armoroftime.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(TimeArmorItem object) {
		return new ResourceLocation("zelda_craft", "textures/item/armoroftime.png");
	}
}