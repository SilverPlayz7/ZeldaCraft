package zeldacraft.block.renderer;

import zeldacraft.block.model.SmallDungeonChestDisplayModel;
import zeldacraft.block.display.SmallDungeonChestDisplayItem;

import software.bernie.geckolib.renderer.GeoItemRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

public class SmallDungeonChestDisplayItemRenderer extends GeoItemRenderer<SmallDungeonChestDisplayItem> {
	public SmallDungeonChestDisplayItemRenderer() {
		super(new SmallDungeonChestDisplayModel());
	}

	@Override
	public RenderType getRenderType(SmallDungeonChestDisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
