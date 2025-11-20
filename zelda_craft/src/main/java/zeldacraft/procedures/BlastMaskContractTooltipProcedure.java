package zeldacraft.procedures;

import zeldacraft.network.ZeldaCraftModVariables;

import zeldacraft.init.ZeldaCraftModItems;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import javax.annotation.Nullable;

import java.util.List;

@Mod.EventBusSubscriber
public class BlastMaskContractTooltipProcedure {
	@OnlyIn(Dist.CLIENT)
	@SubscribeEvent
	public static void onItemTooltip(ItemTooltipEvent event) {
		execute(event, event.getEntity(), event.getItemStack(), event.getToolTip());
	}

	public static void execute(Entity entity, ItemStack itemstack, List<Component> tooltip) {
		execute(null, entity, itemstack, tooltip);
	}

	private static void execute(@Nullable Event event, Entity entity, ItemStack itemstack, List<Component> tooltip) {
		if (entity == null || tooltip == null)
			return;
		if (itemstack.getItem() == ZeldaCraftModItems.BLAST_MASK_CONTRACT.get()) {
			if ((entity.getCapability(ZeldaCraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ZeldaCraftModVariables.PlayerVariables())).BombsCrafted == 10) {
				tooltip.add(Component.literal(("\u00A7a" + "\u00A7m" + "Bombs Crafted: "
						+ new java.text.DecimalFormat("##.##").format((entity.getCapability(ZeldaCraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ZeldaCraftModVariables.PlayerVariables())).BombsCrafted) + "/10")));
			} else {
				tooltip.add(Component.literal(("\u00A74" + "Bombs Crafted: "
						+ new java.text.DecimalFormat("##.##").format((entity.getCapability(ZeldaCraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ZeldaCraftModVariables.PlayerVariables())).BombsCrafted) + "/10")));
			}
			if ((entity.getCapability(ZeldaCraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ZeldaCraftModVariables.PlayerVariables())).CreepersDetonated == 5) {
				tooltip.add(Component.literal(("\u00A7a" + "\u00A7m" + "Creepers Detonated: "
						+ new java.text.DecimalFormat("##.##").format((entity.getCapability(ZeldaCraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ZeldaCraftModVariables.PlayerVariables())).CreepersDetonated) + "/5")));
			} else {
				tooltip.add(Component.literal(("\u00A74" + "Creepers Detonated: "
						+ new java.text.DecimalFormat("##.##").format((entity.getCapability(ZeldaCraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ZeldaCraftModVariables.PlayerVariables())).CreepersDetonated) + "/5")));
			}
			if ((entity.getCapability(ZeldaCraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ZeldaCraftModVariables.PlayerVariables())).ExplosiveKills == 25) {
				tooltip.add(Component.literal(("\u00A7a" + "\u00A7m" + "Mobs Killed With Explosives: "
						+ new java.text.DecimalFormat("##.##").format((entity.getCapability(ZeldaCraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ZeldaCraftModVariables.PlayerVariables())).ExplosiveKills) + "/25")));
			} else {
				tooltip.add(Component.literal(("\u00A74" + "Mobs Killed With Explosives: "
						+ new java.text.DecimalFormat("##.##").format((entity.getCapability(ZeldaCraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ZeldaCraftModVariables.PlayerVariables())).ExplosiveKills) + "/25")));
			}
		}
		if (itemstack.getItem() == ZeldaCraftModItems.BUNNY_HOOD_CONTRACT.get()) {
			if ((entity.getCapability(ZeldaCraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ZeldaCraftModVariables.PlayerVariables())).StepsRun == 1000) {
				tooltip.add(Component.literal(("\u00A7a" + "\u00A7m" + "Steps Taken: "
						+ new java.text.DecimalFormat("##.##").format((entity.getCapability(ZeldaCraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ZeldaCraftModVariables.PlayerVariables())).StepsRun) + "/1,000")));
			} else {
				tooltip.add(Component.literal(("\u00A74" + "Steps Taken: "
						+ new java.text.DecimalFormat("##.##").format((entity.getCapability(ZeldaCraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ZeldaCraftModVariables.PlayerVariables())).StepsRun) + "/1,000")));
			}
			if ((entity.getCapability(ZeldaCraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ZeldaCraftModVariables.PlayerVariables())).TimedJumped == 100) {
				tooltip.add(Component.literal(("\u00A7a" + "\u00A7m" + "Times Jumped: "
						+ new java.text.DecimalFormat("##.##").format((entity.getCapability(ZeldaCraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ZeldaCraftModVariables.PlayerVariables())).TimedJumped) + "/100")));
			} else {
				tooltip.add(Component.literal(("\u00A74" + "Times Jumped: "
						+ new java.text.DecimalFormat("##.##").format((entity.getCapability(ZeldaCraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ZeldaCraftModVariables.PlayerVariables())).TimedJumped) + "/100")));
			}
			if ((entity.getCapability(ZeldaCraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new ZeldaCraftModVariables.PlayerVariables())).Fell50 == true) {
				tooltip.add(Component.literal(("\u00A7a" + "\u00A7m" + "Fall 50 Blocks Unstopped: " + "Complete")));
			} else {
				tooltip.add(Component.literal(("\u00A74" + "Fall 50 Blocks Unstopped: " + "Incomplete")));
			}
		}
	}
}