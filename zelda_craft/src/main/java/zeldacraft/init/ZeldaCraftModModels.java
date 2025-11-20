/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package zeldacraft.init;

import zeldacraft.client.model.Modelroccape;
import zeldacraft.client.model.Modelnorender;
import zeldacraft.client.model.Modelice;
import zeldacraft.client.model.Modelfiredhook;
import zeldacraft.client.model.ModelTPChest;
import zeldacraft.client.model.ModelSwordBeam;
import zeldacraft.client.model.ModelSilverArrow;
import zeldacraft.client.model.ModelShockArrow;
import zeldacraft.client.model.ModelPegasusBoots;
import zeldacraft.client.model.ModelLightArrow;
import zeldacraft.client.model.ModelIronBoots;
import zeldacraft.client.model.ModelIceArrow;
import zeldacraft.client.model.ModelHoverBoots;
import zeldacraft.client.model.ModelHoodOfTwilight;
import zeldacraft.client.model.ModelGreavesofTwilight;
import zeldacraft.client.model.ModelGaro_Mask;
import zeldacraft.client.model.ModelFireArrow;
import zeldacraft.client.model.ModelFierceMask;
import zeldacraft.client.model.ModelDekuMask;
import zeldacraft.client.model.ModelBunnyHood;
import zeldacraft.client.model.ModelBootsofTwilight;
import zeldacraft.client.model.ModelBoomerangProjectile;
import zeldacraft.client.model.ModelBombEntity;
import zeldacraft.client.model.ModelBombArrow;
import zeldacraft.client.model.ModelBlastMask;
import zeldacraft.client.model.ModelAllNightMask;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.api.distmarker.Dist;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
public class ZeldaCraftModModels {
	@SubscribeEvent
	public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
		event.registerLayerDefinition(Modelroccape.LAYER_LOCATION, Modelroccape::createBodyLayer);
		event.registerLayerDefinition(ModelShockArrow.LAYER_LOCATION, ModelShockArrow::createBodyLayer);
		event.registerLayerDefinition(ModelBootsofTwilight.LAYER_LOCATION, ModelBootsofTwilight::createBodyLayer);
		event.registerLayerDefinition(ModelIceArrow.LAYER_LOCATION, ModelIceArrow::createBodyLayer);
		event.registerLayerDefinition(ModelSwordBeam.LAYER_LOCATION, ModelSwordBeam::createBodyLayer);
		event.registerLayerDefinition(ModelFierceMask.LAYER_LOCATION, ModelFierceMask::createBodyLayer);
		event.registerLayerDefinition(ModelSilverArrow.LAYER_LOCATION, ModelSilverArrow::createBodyLayer);
		event.registerLayerDefinition(Modelfiredhook.LAYER_LOCATION, Modelfiredhook::createBodyLayer);
		event.registerLayerDefinition(Modelice.LAYER_LOCATION, Modelice::createBodyLayer);
		event.registerLayerDefinition(ModelGreavesofTwilight.LAYER_LOCATION, ModelGreavesofTwilight::createBodyLayer);
		event.registerLayerDefinition(ModelHoodOfTwilight.LAYER_LOCATION, ModelHoodOfTwilight::createBodyLayer);
		event.registerLayerDefinition(ModelBoomerangProjectile.LAYER_LOCATION, ModelBoomerangProjectile::createBodyLayer);
		event.registerLayerDefinition(ModelHoverBoots.LAYER_LOCATION, ModelHoverBoots::createBodyLayer);
		event.registerLayerDefinition(ModelBombArrow.LAYER_LOCATION, ModelBombArrow::createBodyLayer);
		event.registerLayerDefinition(ModelPegasusBoots.LAYER_LOCATION, ModelPegasusBoots::createBodyLayer);
		event.registerLayerDefinition(ModelTPChest.LAYER_LOCATION, ModelTPChest::createBodyLayer);
		event.registerLayerDefinition(ModelBunnyHood.LAYER_LOCATION, ModelBunnyHood::createBodyLayer);
		event.registerLayerDefinition(ModelIronBoots.LAYER_LOCATION, ModelIronBoots::createBodyLayer);
		event.registerLayerDefinition(ModelAllNightMask.LAYER_LOCATION, ModelAllNightMask::createBodyLayer);
		event.registerLayerDefinition(Modelnorender.LAYER_LOCATION, Modelnorender::createBodyLayer);
		event.registerLayerDefinition(ModelBombEntity.LAYER_LOCATION, ModelBombEntity::createBodyLayer);
		event.registerLayerDefinition(ModelGaro_Mask.LAYER_LOCATION, ModelGaro_Mask::createBodyLayer);
		event.registerLayerDefinition(ModelBlastMask.LAYER_LOCATION, ModelBlastMask::createBodyLayer);
		event.registerLayerDefinition(ModelFireArrow.LAYER_LOCATION, ModelFireArrow::createBodyLayer);
		event.registerLayerDefinition(ModelLightArrow.LAYER_LOCATION, ModelLightArrow::createBodyLayer);
		event.registerLayerDefinition(ModelDekuMask.LAYER_LOCATION, ModelDekuMask::createBodyLayer);
	}
}