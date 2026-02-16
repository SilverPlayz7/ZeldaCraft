package zeldacraft.block.renderer;

import zeldacraft.block.model.LockedDungeonDoorDisplayModel;
import zeldacraft.block.display.LockedDungeonDoorDisplayItem;

import software.bernie.geckolib.renderer.GeoItemRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

public class LockedDungeonDoorDisplayItemRenderer extends GeoItemRenderer<LockedDungeonDoorDisplayItem> {
	public LockedDungeonDoorDisplayItemRenderer() {
		super(new LockedDungeonDoorDisplayModel());
	}

	@Override
	public RenderType getRenderType(LockedDungeonDoorDisplayItem animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}