
/*
*	MCreator note: This file will be REGENERATED on each build.
*/
package zeldacraft.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.common.BasicItemListing;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.npc.VillagerProfession;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ZeldaCraftModTrades {
	@SubscribeEvent
	public static void registerTrades(VillagerTradesEvent event) {
		if (event.getType() == VillagerProfession.TOOLSMITH) {
			event.getTrades().get(3).add(new BasicItemListing(new ItemStack(ZeldaCraftModItems.GREEN_RUPIE.get(), 15),

					new ItemStack(ZeldaCraftModItems.NEW_HYRULE_SHIELD.get()), 3, 6, 0.05f));
			event.getTrades().get(4).add(new BasicItemListing(new ItemStack(ZeldaCraftModItems.BLUE_RUPEE.get(), 16),

					new ItemStack(ZeldaCraftModItems.REPLICA_HYLIAN_SHIELD.get()), 1, 10, 0.05f));
		}
	}
}
