
package zeldacraft.item;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.item.RecordItem;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;
import net.minecraft.resources.ResourceLocation;

public class GurudoVallyItem extends RecordItem {
	public GurudoVallyItem() {
		super(15, () -> ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("zelda_craft:gerudo_valley")), new Item.Properties().stacksTo(1).rarity(Rarity.RARE), 1820);
	}
}
