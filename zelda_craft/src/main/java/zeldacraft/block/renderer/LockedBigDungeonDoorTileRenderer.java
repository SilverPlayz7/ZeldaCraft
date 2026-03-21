package zeldacraft.block.renderer;

import zeldacraft.block.model.LockedBigDungeonDoorBlockModel;
import zeldacraft.block.entity.LockedBigDungeonDoorTileEntity;

import software.bernie.geckolib.renderer.GeoBlockRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

public class LockedBigDungeonDoorTileRenderer extends GeoBlockRenderer<LockedBigDungeonDoorTileEntity> {
	public LockedBigDungeonDoorTileRenderer() {
		super(new LockedBigDungeonDoorBlockModel());
	}

	@Override
	public RenderType getRenderType(LockedBigDungeonDoorTileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}