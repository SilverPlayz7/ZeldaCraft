package zeldacraft.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class PureAlloyItem extends Item {
	public PureAlloyItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.RARE));
	}
}