package zeldacraft.item.model;

import zeldacraft.item.TwilightArmorItem;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

public class TwilightArmorModel extends GeoModel<TwilightArmorItem> {
	@Override
	public ResourceLocation getAnimationResource(TwilightArmorItem object) {
		return new ResourceLocation("zelda_craft", "animations/twilightset.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(TwilightArmorItem object) {
		return new ResourceLocation("zelda_craft", "geo/twilightset.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(TwilightArmorItem object) {
		return new ResourceLocation("zelda_craft", "textures/item/armoroftwilight.png");
	}
}
