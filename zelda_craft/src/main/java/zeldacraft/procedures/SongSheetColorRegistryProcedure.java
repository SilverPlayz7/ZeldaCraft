package zeldacraft.procedures;

import zeldacraft.init.ZeldaCraftModItems;

import net.minecraft.world.item.ItemStack;

public class SongSheetColorRegistryProcedure {
	public static String execute(ItemStack itemstack) {
		if (itemstack.getItem() == ZeldaCraftModItems.SONG_SHEET_ZELDAS_LULLABY.get()) {
			return "\u00A73";
		}
		if (itemstack.getItem() == ZeldaCraftModItems.SONG_SHEET_EPONAS_SONG.get()) {
			return "\u00A76 ";
		}
		if (itemstack.getItem() == ZeldaCraftModItems.SONG_SHEET_SUNS_SONG.get()) {
			return "\u00A7e ";
		}
		if (itemstack.getItem() == ZeldaCraftModItems.SONG_SHEET_SARIAS_SONG.get()) {
			return "\u00A7a ";
		}
		if (itemstack.getItem() == ZeldaCraftModItems.SONG_SHEET_SONG_OF_TIME.get()) {
			return "\u00A79 ";
		}
		if (itemstack.getItem() == ZeldaCraftModItems.SONG_SHEET_SONG_OF_STORMS.get()) {
			return "\u00A71";
		}
		if (itemstack.getItem() == ZeldaCraftModItems.SONG_SHEET_MINUET_OF_FOREST.get()) {
			return "\u00A72";
		}
		if (itemstack.getItem() == ZeldaCraftModItems.SONG_SHEET_BOLERO_OF_FIRE.get()) {
			return "\u00A7c";
		}
		if (itemstack.getItem() == ZeldaCraftModItems.SONG_SHEET_SERENADE_OF_WATER.get()) {
			return "\u00A7b ";
		}
		if (itemstack.getItem() == ZeldaCraftModItems.SONG_SHEET_NOCTURNE_OF_SHADOW.get()) {
			return "\u00A75 ";
		}
		if (itemstack.getItem() == ZeldaCraftModItems.SONG_SHEET_REQUIEM_OF_SPIRIT.get()) {
			return "\u00A76 ";
		}
		if (itemstack.getItem() == ZeldaCraftModItems.SONG_SHEET_PRELUDE_OF_LIGHT.get()) {
			return "\u00A7e";
		}
		if (itemstack.getItem() == ZeldaCraftModItems.SONG_SHEET_SONG_OF_DOUBLE_TIME.get()) {
			return "\u00A7b";
		}
		if (itemstack.getItem() == ZeldaCraftModItems.SONG_SHEET_INVERTED_SONG_OF_TIME.get()) {
			return "\u00A71";
		}
		if (itemstack.getItem() == ZeldaCraftModItems.SONG_SHEET_SONG_OF_HEALING.get()) {
			return "\u00A7d ";
		}
		if (itemstack.getItem() == ZeldaCraftModItems.SONG_SHEET_SONG_OF_SOARING.get()) {
			return "\u00A7f ";
		}
		if (itemstack.getItem() == ZeldaCraftModItems.SONG_SHEET_SONATA_OF_AWAKENING.get()) {
			return "\u00A7e ";
		}
		if (itemstack.getItem() == ZeldaCraftModItems.SONG_SHEET_GORON_LULLABY.get()) {
			return "\u00A74";
		}
		if (itemstack.getItem() == ZeldaCraftModItems.SONG_SHEET_NEW_WAVE_BOSSA_NOVA.get()) {
			return "\u00A73 ";
		}
		if (itemstack.getItem() == ZeldaCraftModItems.SONG_SHEET_ELEGY_OF_EMPTINESS.get()) {
			return "\u00A78";
		}
		if (itemstack.getItem() == ZeldaCraftModItems.SONG_SHEET_OATH_TO_ORDER.get()) {
			return "\u00A77 ";
		}
		return "";
	}
}