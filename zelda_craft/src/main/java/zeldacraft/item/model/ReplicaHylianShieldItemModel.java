package zeldacraft.item.model;

import zeldacraft.item.ReplicaHylianShieldItem;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

public class ReplicaHylianShieldItemModel extends GeoModel<ReplicaHylianShieldItem> {
	@Override
	public ResourceLocation getAnimationResource(ReplicaHylianShieldItem animatable) {
		return new ResourceLocation("zelda_craft", "animations/hylianshield.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(ReplicaHylianShieldItem animatable) {
		return new ResourceLocation("zelda_craft", "geo/hylianshield.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(ReplicaHylianShieldItem animatable) {
		return new ResourceLocation("zelda_craft", "textures/item/replicahylianshield.png");
	}
}
