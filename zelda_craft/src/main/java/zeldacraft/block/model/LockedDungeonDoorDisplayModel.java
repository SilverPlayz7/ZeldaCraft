package zeldacraft.block.model;

import zeldacraft.block.display.LockedDungeonDoorDisplayItem;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

public class LockedDungeonDoorDisplayModel extends GeoModel<LockedDungeonDoorDisplayItem> {
	@Override
	public ResourceLocation getAnimationResource(LockedDungeonDoorDisplayItem animatable) {
		return new ResourceLocation("zelda_craft", "animations/lockeddungeondoorb.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(LockedDungeonDoorDisplayItem animatable) {
		return new ResourceLocation("zelda_craft", "geo/lockeddungeondoorb.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(LockedDungeonDoorDisplayItem entity) {
		return new ResourceLocation("zelda_craft", "textures/block/dungeondoor2.png");
	}
}