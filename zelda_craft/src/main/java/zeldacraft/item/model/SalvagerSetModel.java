package zeldacraft.item.model;

import zeldacraft.item.SalvagerSetItem;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

public class SalvagerSetModel extends GeoModel<SalvagerSetItem> {
	@Override
	public ResourceLocation getAnimationResource(SalvagerSetItem object) {
		return new ResourceLocation("zelda_craft", "animations/rexdivesuit.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(SalvagerSetItem object) {
		return new ResourceLocation("zelda_craft", "geo/rexdivesuit.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(SalvagerSetItem object) {
		return new ResourceLocation("zelda_craft", "textures/item/salvagerset.png");
	}
}
