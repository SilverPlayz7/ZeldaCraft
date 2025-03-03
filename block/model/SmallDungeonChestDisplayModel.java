package zeldacraft.block.model;

import zeldacraft.block.display.SmallDungeonChestDisplayItem;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

public class SmallDungeonChestDisplayModel extends GeoModel<SmallDungeonChestDisplayItem> {
	@Override
	public ResourceLocation getAnimationResource(SmallDungeonChestDisplayItem animatable) {
		return new ResourceLocation("zelda_craft", "animations/smallchest.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(SmallDungeonChestDisplayItem animatable) {
		return new ResourceLocation("zelda_craft", "geo/smallchest.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(SmallDungeonChestDisplayItem entity) {
		return new ResourceLocation("zelda_craft", "textures/block/smallchest.png");
	}
}
