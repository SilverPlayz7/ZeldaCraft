package zeldacraft.block.model;

import zeldacraft.block.entity.LockedBigDungeonDoorTileEntity;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

public class LockedBigDungeonDoorBlockModel extends GeoModel<LockedBigDungeonDoorTileEntity> {
	@Override
	public ResourceLocation getAnimationResource(LockedBigDungeonDoorTileEntity animatable) {
		final int blockstate = animatable.blockstateNew;
		if (blockstate == 1)
			return new ResourceLocation("zelda_craft", "animations/dungeonbigdoorlm.animation.json");
		if (blockstate == 2)
			return new ResourceLocation("zelda_craft", "animations/dungeonbigdoorlt.animation.json");
		if (blockstate == 3)
			return new ResourceLocation("zelda_craft", "animations/dungeonbigdoorrb.animation.json");
		if (blockstate == 4)
			return new ResourceLocation("zelda_craft", "animations/dungeonbigdoorrm.animation.json");
		if (blockstate == 5)
			return new ResourceLocation("zelda_craft", "animations/dungeonbigdoorrt.animation.json");
		return new ResourceLocation("zelda_craft", "animations/dungeonbigdoorlb.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(LockedBigDungeonDoorTileEntity animatable) {
		final int blockstate = animatable.blockstateNew;
		if (blockstate == 1)
			return new ResourceLocation("zelda_craft", "geo/dungeonbigdoorlm.geo.json");
		if (blockstate == 2)
			return new ResourceLocation("zelda_craft", "geo/dungeonbigdoorlt.geo.json");
		if (blockstate == 3)
			return new ResourceLocation("zelda_craft", "geo/dungeonbigdoorrb.geo.json");
		if (blockstate == 4)
			return new ResourceLocation("zelda_craft", "geo/dungeonbigdoorrm.geo.json");
		if (blockstate == 5)
			return new ResourceLocation("zelda_craft", "geo/dungeonbigdoorrt.geo.json");
		return new ResourceLocation("zelda_craft", "geo/dungeonbigdoorlb.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(LockedBigDungeonDoorTileEntity animatable) {
		final int blockstate = animatable.blockstateNew;
		if (blockstate == 1)
			return new ResourceLocation("zelda_craft", "textures/block/lockedbigkeydoor.png");
		if (blockstate == 2)
			return new ResourceLocation("zelda_craft", "textures/block/lockedbigkeydoor.png");
		if (blockstate == 3)
			return new ResourceLocation("zelda_craft", "textures/block/lockedbigkeydoor.png");
		if (blockstate == 4)
			return new ResourceLocation("zelda_craft", "textures/block/lockedbigkeydoor.png");
		if (blockstate == 5)
			return new ResourceLocation("zelda_craft", "textures/block/lockedbigkeydoor.png");
		return new ResourceLocation("zelda_craft", "textures/block/lockedbigkeydoor.png");
	}
}