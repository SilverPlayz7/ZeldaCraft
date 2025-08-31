package zeldacraft.block.model;

import zeldacraft.block.display.AnchientCapsuleMachineDisplayItem;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

public class AnchientCapsuleMachineDisplayModel extends GeoModel<AnchientCapsuleMachineDisplayItem> {
	@Override
	public ResourceLocation getAnimationResource(AnchientCapsuleMachineDisplayItem animatable) {
		return new ResourceLocation("zelda_craft", "animations/gachacrank.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(AnchientCapsuleMachineDisplayItem animatable) {
		return new ResourceLocation("zelda_craft", "geo/gachacrank.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(AnchientCapsuleMachineDisplayItem entity) {
		return new ResourceLocation("zelda_craft", "textures/block/gachamachine.png");
	}
}