package zeldacraft.block.renderer;

import zeldacraft.block.model.TreasureChestBlockModel;
import zeldacraft.block.entity.TreasureChestTileEntity;

import software.bernie.geckolib.renderer.GeoBlockRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

public class TreasureChestTileRenderer extends GeoBlockRenderer<TreasureChestTileEntity> {
	public TreasureChestTileRenderer() {
		super(new TreasureChestBlockModel());
	}

	@Override
	public RenderType getRenderType(TreasureChestTileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
