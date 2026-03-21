package zeldacraft.block.renderer;

import zeldacraft.block.model.LockedBigDungeonDoorDisplayModel;
import zeldacraft.block.display.LockedBigDungeonDoorDisplayItem;

import software.bernie.geckolib.renderer.GeoItemRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

public class LockedBigDungeonDoorDisplayItemRenderer extends GeoItemRenderer<LockedBigDungeonDoorDisplayItem> {
	public LockedBigDungeonDoorDisplayItemRenderer() {
		super(new LockedBigDungeonDoorDisplayModel());
	}

	@Override
	public RenderType getRenderType(LockedBigDungeonDoorDisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}