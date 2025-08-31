package zeldacraft.block.model;

import zeldacraft.block.entity.SmallDungeonChestTileEntity;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

public class SmallDungeonChestBlockModel extends GeoModel<SmallDungeonChestTileEntity> {
	@Override
	public ResourceLocation getAnimationResource(SmallDungeonChestTileEntity animatable) {
		return new ResourceLocation("zelda_craft", "animations/smallchest.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(SmallDungeonChestTileEntity animatable) {
		return new ResourceLocation("zelda_craft", "geo/smallchest.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(SmallDungeonChestTileEntity animatable) {
		return new ResourceLocation("zelda_craft", "textures/block/smallchest.png");
	}
}