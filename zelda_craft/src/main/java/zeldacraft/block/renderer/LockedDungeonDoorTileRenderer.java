package zeldacraft.block.renderer;

import zeldacraft.block.model.LockedDungeonDoorBlockModel;
import zeldacraft.block.entity.LockedDungeonDoorTileEntity;

import software.bernie.geckolib.renderer.GeoBlockRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

public class LockedDungeonDoorTileRenderer extends GeoBlockRenderer<LockedDungeonDoorTileEntity> {
	public LockedDungeonDoorTileRenderer() {
		super(new LockedDungeonDoorBlockModel());
	}

	@Override
	public RenderType getRenderType(LockedDungeonDoorTileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}