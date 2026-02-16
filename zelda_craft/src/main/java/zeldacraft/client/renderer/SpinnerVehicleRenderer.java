package zeldacraft.client.renderer;

import zeldacraft.entity.SpinnerVehicleEntity;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.ChickenModel;

public class SpinnerVehicleRenderer extends MobRenderer<SpinnerVehicleEntity, ChickenModel<SpinnerVehicleEntity>> {
	public SpinnerVehicleRenderer(EntityRendererProvider.Context context) {
		super(context, new ChickenModel<SpinnerVehicleEntity>(context.bakeLayer(ModelLayers.CHICKEN)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(SpinnerVehicleEntity entity) {
		return ResourceLocation.parse("zelda_craft:textures/entities/boots2.png");
	}
}