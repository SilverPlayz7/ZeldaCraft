package zeldacraft.item;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.item.RecordItem;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;
import net.minecraft.resources.ResourceLocation;

public class ClockTownItem extends RecordItem {
	public ClockTownItem() {
		super(15, () -> ForgeRegistries.SOUND_EVENTS.getValue(ResourceLocation.parse("zelda_craft:clocktown")), new Item.Properties().stacksTo(1).rarity(Rarity.RARE), 1760);
	}
}