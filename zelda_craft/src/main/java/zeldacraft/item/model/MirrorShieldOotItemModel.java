package zeldacraft.item.model;

import zeldacraft.item.MirrorShieldOotItem;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

public class MirrorShieldOotItemModel extends GeoModel<MirrorShieldOotItem> {
	@Override
	public ResourceLocation getAnimationResource(MirrorShieldOotItem animatable) {
		return new ResourceLocation("zelda_craft", "animations/ootmirrorshield.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(MirrorShieldOotItem animatable) {
		return new ResourceLocation("zelda_craft", "geo/ootmirrorshield.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(MirrorShieldOotItem animatable) {
		return new ResourceLocation("zelda_craft", "textures/item/ootmirrorshield.png");
	}
}
