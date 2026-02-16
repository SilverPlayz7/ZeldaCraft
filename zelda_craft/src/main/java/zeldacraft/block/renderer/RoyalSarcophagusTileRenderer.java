package zeldacraft.block.renderer;

import zeldacraft.block.model.RoyalSarcophagusBlockModel;
import zeldacraft.block.entity.RoyalSarcophagusTileEntity;

import software.bernie.geckolib.renderer.GeoBlockRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

public class RoyalSarcophagusTileRenderer extends GeoBlockRenderer<RoyalSarcophagusTileEntity> {
	public RoyalSarcophagusTileRenderer() {
		super(new RoyalSarcophagusBlockModel());
	}

	@Override
	public RenderType getRenderType(RoyalSarcophagusTileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}