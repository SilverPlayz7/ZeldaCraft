package zeldacraft.block.model;

import zeldacraft.block.entity.AnchientCapsuleMachineTileEntity;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

public class AnchientCapsuleMachineBlockModel extends GeoModel<AnchientCapsuleMachineTileEntity> {
	@Override
	public ResourceLocation getAnimationResource(AnchientCapsuleMachineTileEntity animatable) {
		return new ResourceLocation("zelda_craft", "animations/gachacrank.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(AnchientCapsuleMachineTileEntity animatable) {
		return new ResourceLocation("zelda_craft", "geo/gachacrank.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(AnchientCapsuleMachineTileEntity animatable) {
		return new ResourceLocation("zelda_craft", "textures/block/gachamachine.png");
	}
}
