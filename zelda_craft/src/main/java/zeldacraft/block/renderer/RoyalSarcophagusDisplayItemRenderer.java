package zeldacraft.block.renderer;

import zeldacraft.block.model.RoyalSarcophagusDisplayModel;
import zeldacraft.block.display.RoyalSarcophagusDisplayItem;

import software.bernie.geckolib.renderer.GeoItemRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

public class RoyalSarcophagusDisplayItemRenderer extends GeoItemRenderer<RoyalSarcophagusDisplayItem> {
	public RoyalSarcophagusDisplayItemRenderer() {
		super(new RoyalSarcophagusDisplayModel());
	}

	@Override
	public RenderType getRenderType(RoyalSarcophagusDisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}