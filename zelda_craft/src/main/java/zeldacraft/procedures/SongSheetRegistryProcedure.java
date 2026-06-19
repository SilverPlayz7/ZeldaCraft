package zeldacraft.procedures;

import zeldacraft.init.ZeldaCraftModItems;

import net.minecraft.world.item.ItemStack;

public class SongSheetRegistryProcedure {
	public static String execute(ItemStack itemstack) {
		if (itemstack.getItem() == ZeldaCraftModItems.SONG_SHEET_MASTER.get()) {
			return "\"z_lullaby\"" + "" + "\"epona\"" + "\"sun\"" + "\"saria\"" + "\"time\"" + "\"storms\"" + "\"minuet\"" + "\"bolero\"" + "\"serenade\"" + "\"nocturne\"" + "\"requriem\"" + "\"prelude\"" + "\"double_time\"" + "\"inverted_time\""
					+ "\"healing\"" + "\"soaring\"" + "\"sonata\"" + "\"g_lullaby\"" + "\"bossa_nova\"" + "\"elegy\"" + "\"oath\"";
		}
		if (itemstack.getItem() == ZeldaCraftModItems.SONG_SHEET_ZELDAS_LULLABY.get()) {
			return "\"z_lullaby\"";
		}
		if (itemstack.getItem() == ZeldaCraftModItems.SONG_SHEET_EPONAS_SONG.get()) {
			return "\"epona\"";
		}
		if (itemstack.getItem() == ZeldaCraftModItems.SONG_SHEET_SUNS_SONG.get()) {
			return "\"sun\"";
		}
		if (itemstack.getItem() == ZeldaCraftModItems.SONG_SHEET_SARIAS_SONG.get()) {
			return "\"saria\"";
		}
		if (itemstack.getItem() == ZeldaCraftModItems.SONG_SHEET_SONG_OF_TIME.get()) {
			return "\"time\"";
		}
		if (itemstack.getItem() == ZeldaCraftModItems.SONG_SHEET_SONG_OF_STORMS.get()) {
			return "\"storms\"";
		}
		if (itemstack.getItem() == ZeldaCraftModItems.SONG_SHEET_MINUET_OF_FOREST.get()) {
			return "\"minuet\"";
		}
		if (itemstack.getItem() == ZeldaCraftModItems.SONG_SHEET_BOLERO_OF_FIRE.get()) {
			return "\"bolero\"";
		}
		if (itemstack.getItem() == ZeldaCraftModItems.SONG_SHEET_SERENADE_OF_WATER.get()) {
			return "\"serenade\"";
		}
		if (itemstack.getItem() == ZeldaCraftModItems.SONG_SHEET_NOCTURNE_OF_SHADOW.get()) {
			return "\"nocturne\"";
		}
		if (itemstack.getItem() == ZeldaCraftModItems.SONG_SHEET_REQUIEM_OF_SPIRIT.get()) {
			return "\"requriem\"";
		}
		if (itemstack.getItem() == ZeldaCraftModItems.SONG_SHEET_PRELUDE_OF_LIGHT.get()) {
			return "\"prelude\"";
		}
		if (itemstack.getItem() == ZeldaCraftModItems.SONG_SHEET_SONG_OF_DOUBLE_TIME.get()) {
			return "\"double_time\"";
		}
		if (itemstack.getItem() == ZeldaCraftModItems.SONG_SHEET_INVERTED_SONG_OF_TIME.get()) {
			return "\"inverted_time\"";
		}
		if (itemstack.getItem() == ZeldaCraftModItems.SONG_SHEET_SONG_OF_HEALING.get()) {
			return "\"healing\"";
		}
		if (itemstack.getItem() == ZeldaCraftModItems.SONG_SHEET_SONG_OF_SOARING.get()) {
			return "\"soaring\"";
		}
		if (itemstack.getItem() == ZeldaCraftModItems.SONG_SHEET_SONATA_OF_AWAKENING.get()) {
			return "\"sonata\"";
		}
		if (itemstack.getItem() == ZeldaCraftModItems.SONG_SHEET_GORON_LULLABY.get()) {
			return "\"g_lullaby\"";
		}
		if (itemstack.getItem() == ZeldaCraftModItems.SONG_SHEET_NEW_WAVE_BOSSA_NOVA.get()) {
			return "\"bossa_nova\"";
		}
		if (itemstack.getItem() == ZeldaCraftModItems.SONG_SHEET_ELEGY_OF_EMPTINESS.get()) {
			return "\"elegy\"";
		}
		if (itemstack.getItem() == ZeldaCraftModItems.SONG_SHEET_OATH_TO_ORDER.get()) {
			return "\"oath\"";
		}
		return "";
	}
}