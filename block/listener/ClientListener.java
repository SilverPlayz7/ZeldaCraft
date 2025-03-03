package zeldacraft.block.listener;

import zeldacraft.init.ZeldaCraftModBlockEntities;

import zeldacraft.block.renderer.TreasureChestTileRenderer;
import zeldacraft.block.renderer.SmallDungeonChestTileRenderer;
import zeldacraft.block.renderer.AnchientCapsuleMachineTileRenderer;

import zeldacraft.ZeldaCraftMod;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

@Mod.EventBusSubscriber(modid = ZeldaCraftMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ClientListener {
	@OnlyIn(Dist.CLIENT)
	@SubscribeEvent
	public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
		event.registerBlockEntityRenderer(ZeldaCraftModBlockEntities.ANCHIENT_CAPSULE_MACHINE.get(), context -> new AnchientCapsuleMachineTileRenderer());
		event.registerBlockEntityRenderer(ZeldaCraftModBlockEntities.TREASURE_CHEST.get(), context -> new TreasureChestTileRenderer());
		event.registerBlockEntityRenderer(ZeldaCraftModBlockEntities.SMALL_DUNGEON_CHEST.get(), context -> new SmallDungeonChestTileRenderer());
	}
}
