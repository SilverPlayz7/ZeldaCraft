
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package zeldacraft.init;

import zeldacraft.client.renderer.HappyMaskSalesmanRenderer;
import zeldacraft.client.renderer.FairyRenderer;
import zeldacraft.client.renderer.BombProjectileRenderer;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.renderer.entity.ThrownItemRenderer;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ZeldaCraftModEntityRenderers {
	@SubscribeEvent
	public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
		event.registerEntityRenderer(ZeldaCraftModEntities.BOOMERANG_PROJECTILE.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(ZeldaCraftModEntities.HOOK_SHOT_PROJECTILE.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(ZeldaCraftModEntities.LONG_SHOT_PROJECTILE.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(ZeldaCraftModEntities.MASTER_SWORD_BEAM_PROJECTILE_PROJECTILE.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(ZeldaCraftModEntities.FIERCE_DEITY_SWORD_BEAM.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(ZeldaCraftModEntities.HAPPY_MASK_SALESMAN.get(), HappyMaskSalesmanRenderer::new);
		event.registerEntityRenderer(ZeldaCraftModEntities.BOMB_PROJECTILE.get(), BombProjectileRenderer::new);
		event.registerEntityRenderer(ZeldaCraftModEntities.FAIRY.get(), FairyRenderer::new);
	}
}
