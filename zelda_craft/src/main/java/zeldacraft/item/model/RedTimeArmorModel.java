package zeldacraft.item.model;

import zeldacraft.item.RedTimeArmorItem;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

public class RedTimeArmorModel extends GeoModel<RedTimeArmorItem> {
	@Override
	public ResourceLocation getAnimationResource(RedTimeArmorItem object) {
		return new ResourceLocation("zelda_craft", "animations/armoroftime.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(RedTimeArmorItem object) {
		return new ResourceLocation("zelda_craft", "geo/armoroftime.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(RedTimeArmorItem object) {
		return new ResourceLocation("zelda_craft", "textures/item/armoroftimered.png");
	}
}
