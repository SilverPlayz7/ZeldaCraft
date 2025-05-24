package zeldacraft.item.model;

import zeldacraft.item.GoldTimeArmorItem;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

public class GoldTimeArmorModel extends GeoModel<GoldTimeArmorItem> {
	@Override
	public ResourceLocation getAnimationResource(GoldTimeArmorItem object) {
		return new ResourceLocation("zelda_craft", "animations/armoroftime.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(GoldTimeArmorItem object) {
		return new ResourceLocation("zelda_craft", "geo/armoroftime.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(GoldTimeArmorItem object) {
		return new ResourceLocation("zelda_craft", "textures/item/armoroftimegold.png");
	}
}
