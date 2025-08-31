package zeldacraft.block.renderer;

import zeldacraft.block.model.SmallDungeonChestBlockModel;
import zeldacraft.block.entity.SmallDungeonChestTileEntity;

import software.bernie.geckolib.renderer.GeoBlockRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

public class SmallDungeonChestTileRenderer extends GeoBlockRenderer<SmallDungeonChestTileEntity> {
	public SmallDungeonChestTileRenderer() {
		super(new SmallDungeonChestBlockModel());
	}

	@Override
	public RenderType getRenderType(SmallDungeonChestTileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}