package zeldacraft.block.model;

import zeldacraft.block.display.RoyalSarcophagusDisplayItem;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

public class RoyalSarcophagusDisplayModel extends GeoModel<RoyalSarcophagusDisplayItem> {
	@Override
	public ResourceLocation getAnimationResource(RoyalSarcophagusDisplayItem animatable) {
		return new ResourceLocation("zelda_craft", "animations/hylianshield.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(RoyalSarcophagusDisplayItem animatable) {
		return new ResourceLocation("zelda_craft", "geo/hylianshield.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(RoyalSarcophagusDisplayItem entity) {
		return new ResourceLocation("zelda_craft", "textures/block/wip.png");
	}
}