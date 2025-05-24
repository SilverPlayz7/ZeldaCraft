package zeldacraft.item.model;

import zeldacraft.item.PurpleTimeArmorItem;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

public class PurpleTimeArmorModel extends GeoModel<PurpleTimeArmorItem> {
	@Override
	public ResourceLocation getAnimationResource(PurpleTimeArmorItem object) {
		return new ResourceLocation("zelda_craft", "animations/armoroftime.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(PurpleTimeArmorItem object) {
		return new ResourceLocation("zelda_craft", "geo/armoroftime.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(PurpleTimeArmorItem object) {
		return new ResourceLocation("zelda_craft", "textures/item/armoroftimepurple.png");
	}
}
