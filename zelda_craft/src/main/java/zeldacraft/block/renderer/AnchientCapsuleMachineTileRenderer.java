package zeldacraft.block.renderer;

import zeldacraft.block.model.AnchientCapsuleMachineBlockModel;
import zeldacraft.block.entity.AnchientCapsuleMachineTileEntity;

import software.bernie.geckolib.renderer.GeoBlockRenderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

public class AnchientCapsuleMachineTileRenderer extends GeoBlockRenderer<AnchientCapsuleMachineTileEntity> {
	public AnchientCapsuleMachineTileRenderer() {
		super(new AnchientCapsuleMachineBlockModel());
	}

	@Override
	public RenderType getRenderType(AnchientCapsuleMachineTileEntity animatable, ResourceLocation texture, MultiBufferSource bufferSource, float partialTick) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
}
