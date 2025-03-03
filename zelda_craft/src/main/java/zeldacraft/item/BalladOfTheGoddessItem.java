
package zeldacraft.item;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.item.RecordItem;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;
import net.minecraft.resources.ResourceLocation;

public class BalladOfTheGoddessItem extends RecordItem {
	public BalladOfTheGoddessItem() {
		super(15, () -> ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("zelda_craft:ballad_of_the_goddess")), new Item.Properties().stacksTo(1).rarity(Rarity.RARE), 1900);
	}
}
