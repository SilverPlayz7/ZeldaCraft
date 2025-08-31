package zeldacraft.init;

import zeldacraft.configuration.ZeldaCraftConfigConfiguration;

import zeldacraft.ZeldaCraftMod;

import net.minecraftforge.fml.event.lifecycle.FMLConstructModEvent;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.eventbus.api.SubscribeEvent;

@Mod.EventBusSubscriber(modid = ZeldaCraftMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ZeldaCraftModConfigs {
	@SubscribeEvent
	public static void register(FMLConstructModEvent event) {
		event.enqueueWork(() -> {
			ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, ZeldaCraftConfigConfiguration.SPEC, "zeldacarft_config.toml");
		});
	}
}