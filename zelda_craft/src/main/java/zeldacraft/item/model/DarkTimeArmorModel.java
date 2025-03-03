package zeldacraft.item.model;

import zeldacraft.item.DarkTimeArmorItem;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

public class DarkTimeArmorModel extends GeoModel<DarkTimeArmorItem> {
	@Override
	public ResourceLocation getAnimationResource(DarkTimeArmorItem object) {
		return new ResourceLocation("zelda_craft", "animations/darkarmoroftime.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(DarkTimeArmorItem object) {
		return new ResourceLocation("zelda_craft", "geo/darkarmoroftime.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(DarkTimeArmorItem object) {
		return new ResourceLocation("zelda_craft", "textures/item/armorofshadow.png");
	}
}
