
package zeldacraft.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class AquanineItem extends Item {
	public AquanineItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.UNCOMMON));
	}
}
