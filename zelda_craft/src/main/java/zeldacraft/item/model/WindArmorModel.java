package zeldacraft.item.model;

import zeldacraft.item.WindArmorItem;

import software.bernie.geckolib.model.GeoModel;

import net.minecraft.resources.ResourceLocation;

public class WindArmorModel extends GeoModel<WindArmorItem> {
	@Override
	public ResourceLocation getAnimationResource(WindArmorItem object) {
		return new ResourceLocation("zelda_craft", "animations/armorofwind.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(WindArmorItem object) {
		return new ResourceLocation("zelda_craft", "geo/armorofwind.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(WindArmorItem object) {
		return new ResourceLocation("zelda_craft", "textures/item/armorofwind.png");
	}
}