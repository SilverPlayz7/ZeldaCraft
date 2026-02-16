package zeldacraft.block.model;

import zeldacraft.block.entity.LockedDungeonDoorTileEntity;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

public class LockedDungeonDoorBlockModel extends GeoModel<LockedDungeonDoorTileEntity> {
	@Override
	public ResourceLocation getAnimationResource(LockedDungeonDoorTileEntity animatable) {
		final int blockstate = animatable.blockstateNew;
		if (blockstate == 1)
			return new ResourceLocation("zelda_craft", "animations/lockeddungeondoort.animation.json");
		return new ResourceLocation("zelda_craft", "animations/lockeddungeondoorb.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(LockedDungeonDoorTileEntity animatable) {
		final int blockstate = animatable.blockstateNew;
		if (blockstate == 1)
			return new ResourceLocation("zelda_craft", "geo/lockeddungeondoort.geo.json");
		return new ResourceLocation("zelda_craft", "geo/lockeddungeondoorb.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(LockedDungeonDoorTileEntity animatable) {
		final int blockstate = animatable.blockstateNew;
		if (blockstate == 1)
			return new ResourceLocation("zelda_craft", "textures/block/dungeondoor2.png");
		return new ResourceLocation("zelda_craft", "textures/block/dungeondoor2.png");
	}
}