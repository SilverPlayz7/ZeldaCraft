package zeldacraft.block.model;

import zeldacraft.block.display.LockedBigDungeonDoorDisplayItem;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

public class LockedBigDungeonDoorDisplayModel extends GeoModel<LockedBigDungeonDoorDisplayItem> {
	@Override
	public ResourceLocation getAnimationResource(LockedBigDungeonDoorDisplayItem animatable) {
		return new ResourceLocation("zelda_craft", "animations/dungeonbigdoorlb.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(LockedBigDungeonDoorDisplayItem animatable) {
		return new ResourceLocation("zelda_craft", "geo/dungeonbigdoorlb.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(LockedBigDungeonDoorDisplayItem entity) {
		return new ResourceLocation("zelda_craft", "textures/block/lockedbigkeydoor.png");
	}
}