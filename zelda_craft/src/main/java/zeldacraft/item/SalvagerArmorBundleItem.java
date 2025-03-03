
package zeldacraft.item;

import zeldacraft.procedures.SalvagerArmorBundleOnRightClickProcedure;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionHand;

public class SalvagerArmorBundleItem extends Item {
	public SalvagerArmorBundleItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON));
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
		InteractionResultHolder<ItemStack> ar = super.use(world, entity, hand);
		SalvagerArmorBundleOnRightClickProcedure.execute(entity);
		return ar;
	}
}
