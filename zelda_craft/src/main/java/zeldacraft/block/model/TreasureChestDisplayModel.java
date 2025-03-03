package zeldacraft.block.model;

import zeldacraft.block.display.TreasureChestDisplayItem;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

public class TreasureChestDisplayModel extends GeoModel<TreasureChestDisplayItem> {
	@Override
	public ResourceLocation getAnimationResource(TreasureChestDisplayItem animatable) {
		return new ResourceLocation("zelda_craft", "animations/dungeonchest.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(TreasureChestDisplayItem animatable) {
		return new ResourceLocation("zelda_craft", "geo/dungeonchest.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(TreasureChestDisplayItem entity) {
		return new ResourceLocation("zelda_craft", "textures/block/treasurechest.png");
	}
}
