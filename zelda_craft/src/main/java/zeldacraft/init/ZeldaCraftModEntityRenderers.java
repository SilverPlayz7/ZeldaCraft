/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package zeldacraft.init;

import zeldacraft.client.renderer.SilverArrowProjectileRenderer;
import zeldacraft.client.renderer.ShockArrowProjectileRenderer;
import zeldacraft.client.renderer.MasterSwordBeamProjectileProjectileRenderer;
import zeldacraft.client.renderer.LongShotProjectileRenderer;
import zeldacraft.client.renderer.LightArrowProjectileRenderer;
import zeldacraft.client.renderer.IceArrowProjectileRenderer;
import zeldacraft.client.renderer.HookShotProjectileRenderer;
import zeldacraft.client.renderer.HappyMaskSalesmanRenderer;
import zeldacraft.client.renderer.FireArrowProjectileRenderer;
import zeldacraft.client.renderer.FairyRenderer;
import zeldacraft.client.renderer.BombProjectileRenderer;
import zeldacraft.client.renderer.BombArrowProjectileRenderer;

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
		event.registerEntityRenderer(ZeldaCraftModEntities.HOOK_SHOT_PROJECTILE.get(), HookShotProjectileRenderer::new);
		event.registerEntityRenderer(ZeldaCraftModEntities.LONG_SHOT_PROJECTILE.get(), LongShotProjectileRenderer::new);
		event.registerEntityRenderer(ZeldaCraftModEntities.MASTER_SWORD_BEAM_PROJECTILE_PROJECTILE.get(), MasterSwordBeamProjectileProjectileRenderer::new);
		event.registerEntityRenderer(ZeldaCraftModEntities.HAPPY_MASK_SALESMAN.get(), HappyMaskSalesmanRenderer::new);
		event.registerEntityRenderer(ZeldaCraftModEntities.BOMB_PROJECTILE.get(), BombProjectileRenderer::new);
		event.registerEntityRenderer(ZeldaCraftModEntities.FAIRY.get(), FairyRenderer::new);
		event.registerEntityRenderer(ZeldaCraftModEntities.FIRE_ARROW_PROJECTILE.get(), FireArrowProjectileRenderer::new);
		event.registerEntityRenderer(ZeldaCraftModEntities.ICE_ARROW_PROJECTILE.get(), IceArrowProjectileRenderer::new);
		event.registerEntityRenderer(ZeldaCraftModEntities.LIGHT_ARROW_PROJECTILE.get(), LightArrowProjectileRenderer::new);
		event.registerEntityRenderer(ZeldaCraftModEntities.SILVER_ARROW_PROJECTILE.get(), SilverArrowProjectileRenderer::new);
		event.registerEntityRenderer(ZeldaCraftModEntities.BOMB_ARROW_PROJECTILE.get(), BombArrowProjectileRenderer::new);
		event.registerEntityRenderer(ZeldaCraftModEntities.SHOCK_ARROW_PROJECTILE.get(), ShockArrowProjectileRenderer::new);
	}
}