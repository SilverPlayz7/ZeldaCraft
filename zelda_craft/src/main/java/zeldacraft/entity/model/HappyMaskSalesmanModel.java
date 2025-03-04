package zeldacraft.entity.model;

import zeldacraft.entity.HappyMaskSalesmanEntity;

import software.bernie.geckolib.model.data.EntityModelData;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.constant.DataTickets;

import net.minecraft.util.Mth;
import net.minecraft.resources.ResourceLocation;

public class HappyMaskSalesmanModel extends GeoModel<HappyMaskSalesmanEntity> {
	@Override
	public ResourceLocation getAnimationResource(HappyMaskSalesmanEntity entity) {
		return new ResourceLocation("zelda_craft", "animations/happymasksalesman.animation.json");
	}

	@Override
	public ResourceLocation getModelResource(HappyMaskSalesmanEntity entity) {
		return new ResourceLocation("zelda_craft", "geo/happymasksalesman.geo.json");
	}

	@Override
	public ResourceLocation getTextureResource(HappyMaskSalesmanEntity entity) {
		return new ResourceLocation("zelda_craft", "textures/entities/" + entity.getTexture() + ".png");
	}

	@Override
	public void setCustomAnimations(HappyMaskSalesmanEntity animatable, long instanceId, AnimationState animationState) {
		CoreGeoBone head = getAnimationProcessor().getBone("head");
		if (head != null) {
			EntityModelData entityData = (EntityModelData) animationState.getData(DataTickets.ENTITY_MODEL_DATA);
			head.setRotX(entityData.headPitch() * Mth.DEG_TO_RAD);
			head.setRotY(entityData.netHeadYaw() * Mth.DEG_TO_RAD);
		}

	}
}
