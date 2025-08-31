package zeldacraft.procedures;

import zeldacraft.init.ZeldaCraftModBlocks;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.BlockItem;
import net.minecraft.tags.BlockTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.Screen;

import javax.annotation.Nullable;

import java.util.List;

@Mod.EventBusSubscriber
public class SheikahLinkDescriptionProcedure {
	@OnlyIn(Dist.CLIENT)
	@SubscribeEvent
	public static void onItemTooltip(ItemTooltipEvent event) {
		execute(event, event.getItemStack(), event.getToolTip());
	}

	public static void execute(ItemStack itemstack, List<Component> tooltip) {
		execute(null, itemstack, tooltip);
	}

	private static void execute(@Nullable Event event, ItemStack itemstack, List<Component> tooltip) {
		if (tooltip == null)
			return;
		if (itemstack.getItem() == ZeldaCraftModBlocks.SHEIKAH_LINK.get().asItem()) {
			tooltip.add(Component.literal("\u00A71Shift for more"));
			if (Screen.hasShiftDown()) {
				tooltip.add(Component.literal("\u00A71Right-click on with any dungeon switch (e.x. floor switch, eye switch, torch, etc) to link it's output to the block"));
			}
		}
		if (itemstack.getItem() == ZeldaCraftModBlocks.FLOOR_SWITCH.get().asItem()) {
			tooltip.add(Component.literal("\u00A71Shift for more"));
			if (Screen.hasShiftDown()) {
				tooltip.add(Component.literal("\u00A71When activated, right-click to reset it"));
			}
		}
		if (itemstack.getItem() == ZeldaCraftModBlocks.TIMED_FLOOR_SWITCH.get().asItem()) {
			tooltip.add(Component.literal("\u00A71Shift for more"));
			if (Screen.hasShiftDown()) {
				tooltip.add(Component.literal("\u00A71It deactivates after the set timer runs out."));
			}
		}
		if (itemstack.getItem() == ZeldaCraftModBlocks.WEIGHTED_FLOOR_SWITCH.get().asItem()) {
			tooltip.add(Component.literal("\u00A71Shift for more"));
			if (Screen.hasShiftDown()) {
				tooltip.add(Component.literal("\u00A71Deactivates as soon as something isn't on top of it"));
			}
		}
		if (itemstack.getItem() == ZeldaCraftModBlocks.RUSTY_FLOOR_SWITCH.get().asItem()) {
			tooltip.add(Component.literal("\u00A71Shift for more"));
			if (Screen.hasShiftDown()) {
				tooltip.add(Component.literal("\u00A71After years of disuse this switch has become rusted to the point of needing heavy impact to be pressed"));
			}
		}
		if (itemstack.getItem() == ZeldaCraftModBlocks.LULLABY_SWITCH.get().asItem()) {
			tooltip.add(Component.literal("\u00A71Shift for more"));
			if (Screen.hasShiftDown()) {
				tooltip.add(Component.literal("\u00A71Play Zelda's Lullaby to activate/deactivate it"));
			}
		}
		if ((itemstack.getItem() instanceof BlockItem _bi ? _bi.getBlock().defaultBlockState() : Blocks.AIR.defaultBlockState()).is(BlockTags.create(ResourceLocation.parse("zelda_craft:switch")))) {
			tooltip.add(Component.literal("\u00A74Ctrl to see output"));
			if (Screen.hasControlDown()) {
				tooltip.add(Component.literal(((new java.text.DecimalFormat("##.##").format(itemstack.getOrCreateTag().getDouble("OutputX")) + "X:") + ""
						+ ((" Y:" + new java.text.DecimalFormat("##.##").format(itemstack.getOrCreateTag().getDouble("OutputY"))) + "" + (" Z:" + new java.text.DecimalFormat("##.##").format(itemstack.getOrCreateTag().getDouble("OutputZ")))))));
			}
		}
	}
}