package zeldacraft.item.model;

import zeldacraft.item.BlueTimeArmorItem;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

public class BlueTimeArmorModel extends GeoModel<BlueTimeArmorItem> {
	@Override
	public ResourceLocation getAnimationResource(BlueTimeArmorItem object) {
		return new ResourceLocation("zelda_craft", "animations/armoroftime.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(BlueTimeArmorItem object) {
		return new ResourceLocation("zelda_craft", "geo/armoroftime.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(BlueTimeArmorItem object) {
		return new ResourceLocation("zelda_craft", "textures/item/armoroftimeblue.png");
	}
}
