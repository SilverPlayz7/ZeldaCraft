package zeldacraft.block.renderer;

import zeldacraft.block.model.AnchientCapsuleMachineDisplayModel;
import zeldacraft.block.display.AnchientCapsuleMachineDisplayItem;

import software.bernie.geckolib.renderer.GeoItemRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

public class AnchientCapsuleMachineDisplayItemRenderer extends GeoItemRenderer<AnchientCapsuleMachineDisplayItem> {
	public AnchientCapsuleMachineDisplayItemRenderer() {
		super(new AnchientCapsuleMachineDisplayModel());
	}

	@Override
	public RenderType getRenderType(AnchientCapsuleMachineDisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
