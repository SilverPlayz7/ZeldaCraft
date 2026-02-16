package zeldacraft.block.model;

import zeldacraft.block.entity.RoyalSarcophagusTileEntity;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

public class RoyalSarcophagusBlockModel extends GeoModel<RoyalSarcophagusTileEntity> {
	@Override
	public ResourceLocation getAnimationResource(RoyalSarcophagusTileEntity animatable) {
		return new ResourceLocation("zelda_craft", "animations/hylianshield.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(RoyalSarcophagusTileEntity animatable) {
		return new ResourceLocation("zelda_craft", "geo/hylianshield.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(RoyalSarcophagusTileEntity animatable) {
		return new ResourceLocation("zelda_craft", "textures/block/wip.png");
	}
}