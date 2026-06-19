package zeldacraft.procedures;

import zeldacraft.init.ZeldaCraftModItems;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.ItemTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;

public class SongLearnProcedureProcedure {
	public static void execute(Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if (itemstack.is(ItemTags.create(ResourceLocation.parse("zelda_craft:song_sheets")))) {
			if (itemstack.getItem() == ZeldaCraftModItems.SONG_SHEET_MASTER.get()) {
				if (!(entity.getPersistentData().getString("learned_songs")).contains(SongSheetRegistryProcedure.execute(itemstack))) {
					entity.getPersistentData().putString("learned_songs", SongSheetRegistryProcedure.execute(itemstack));
					if (entity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal(("\u00A76 " + "You learned every song")), true);
				} else {
					if (entity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal(("\u00A76 " + "You already know every song")), true);
				}
			} else if (itemstack.getItem() == ZeldaCraftModItems.SONG_SHEET_CURSED.get()) {
				if (!(entity.getPersistentData().getString("learned_songs")).isEmpty()) {
					entity.getPersistentData().putString("learned_songs", "");
					if (entity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal(("\u00A74" + "The songs you've learned escape your memory")), true);
				}
			} else {
				if (!(entity.getPersistentData().getString("learned_songs")).contains(SongSheetRegistryProcedure.execute(itemstack))) {
					entity.getPersistentData().putString("learned_songs", (entity.getPersistentData().getString("learned_songs") + "" + SongSheetRegistryProcedure.execute(itemstack)));
					if (entity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal((SongSheetColorRegistryProcedure.execute(itemstack) + "You learned " + ("\u00A7l" + Component.translatable((itemstack.getDescriptionId() + ".description_0")).getString()))),
								true);
				}
			}
		}
	}
}