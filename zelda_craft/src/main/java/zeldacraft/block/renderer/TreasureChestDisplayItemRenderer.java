package zeldacraft.block.renderer;

import zeldacraft.block.model.TreasureChestDisplayModel;
import zeldacraft.block.display.TreasureChestDisplayItem;

import software.bernie.geckolib.renderer.GeoItemRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

public class TreasureChestDisplayItemRenderer extends GeoItemRenderer<TreasureChestDisplayItem> {
	public TreasureChestDisplayItemRenderer() {
		super(new TreasureChestDisplayModel());
	}

	@Override
	public RenderType getRenderType(TreasureChestDisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
