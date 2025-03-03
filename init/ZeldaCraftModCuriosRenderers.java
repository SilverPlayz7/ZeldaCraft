package zeldacraft.init;

import zeldacraft.client.renderer.RocCapeRenderer;
import zeldacraft.client.renderer.GaroMaskRenderer;
import zeldacraft.client.renderer.DekuMaskRenderer;
import zeldacraft.client.renderer.BunnyHoodRenderer;
import zeldacraft.client.renderer.BlastMaskBaubleRenderer;
import zeldacraft.client.renderer.AllNightMaskRenderer;
import zeldacraft.client.model.Modelroccape;
import zeldacraft.client.model.ModelGaro_Mask;
import zeldacraft.client.model.ModelDekuMask;
import zeldacraft.client.model.ModelBunnyHood;
import zeldacraft.client.model.ModelBlastMask;
import zeldacraft.client.model.ModelAllNightMask;

import top.theillusivec4.curios.api.client.CuriosRendererRegistry;

import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class ZeldaCraftModCuriosRenderers {
	@SubscribeEvent
	public static void registerLayers(final EntityRenderersEvent.RegisterLayerDefinitions evt) {
		evt.registerLayerDefinition(ZeldaCraftModLayerDefinitions.BLAST_MASK, ModelBlastMask::createBodyLayer);
		evt.registerLayerDefinition(ZeldaCraftModLayerDefinitions.GARO_MASK, ModelGaro_Mask::createBodyLayer);
		evt.registerLayerDefinition(ZeldaCraftModLayerDefinitions.ALL_NIGHT_MASK, ModelAllNightMask::createBodyLayer);
		evt.registerLayerDefinition(ZeldaCraftModLayerDefinitions.ROC_CAPE, Modelroccape::createBodyLayer);
		evt.registerLayerDefinition(ZeldaCraftModLayerDefinitions.DEKU_MASK, ModelDekuMask::createBodyLayer);
		evt.registerLayerDefinition(ZeldaCraftModLayerDefinitions.BUNNY_HOOD, ModelBunnyHood::createBodyLayer);
	}

	@SubscribeEvent
	public static void clientSetup(final FMLClientSetupEvent evt) {
		CuriosRendererRegistry.register(ZeldaCraftModItems.BLAST_MASK.get(), BlastMaskBaubleRenderer::new);
		CuriosRendererRegistry.register(ZeldaCraftModItems.GARO_MASK.get(), GaroMaskRenderer::new);
		CuriosRendererRegistry.register(ZeldaCraftModItems.ALL_NIGHT_MASK.get(), AllNightMaskRenderer::new);
		CuriosRendererRegistry.register(ZeldaCraftModItems.ROC_CAPE.get(), RocCapeRenderer::new);
		CuriosRendererRegistry.register(ZeldaCraftModItems.DEKU_MASK.get(), DekuMaskRenderer::new);
		CuriosRendererRegistry.register(ZeldaCraftModItems.BUNNY_HOOD.get(), BunnyHoodRenderer::new);
	}
}
