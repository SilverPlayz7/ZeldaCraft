package zeldacraft.block.model;

import zeldacraft.block.entity.TreasureChestTileEntity;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

public class TreasureChestBlockModel extends GeoModel<TreasureChestTileEntity> {
	@Override
	public ResourceLocation getAnimationResource(TreasureChestTileEntity animatable) {
		return new ResourceLocation("zelda_craft", "animations/dungeonchest.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(TreasureChestTileEntity animatable) {
		return new ResourceLocation("zelda_craft", "geo/dungeonchest.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(TreasureChestTileEntity animatable) {
		return new ResourceLocation("zelda_craft", "textures/block/treasurechest.png");
	}
}
