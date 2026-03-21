package zeldacraft.item;

import zeldacraft.procedures.RupeeWalletRightclickedProcedure;

import top.theillusivec4.curios.api.type.capability.ICurioItem;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionHand;

public class GiantWalletItem extends Item implements ICurioItem {
	public GiantWalletItem() {
		super(new Item.Properties().stacksTo(1).rarity(Rarity.COMMON));
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
		InteractionResultHolder<ItemStack> ar = super.use(world, entity, hand);
		ItemStack itemstack = ar.getObject();
		double x = entity.getX();
		double y = entity.getY();
		double z = entity.getZ();

		RupeeWalletRightclickedProcedure.execute(world, x, y, z, entity);
		return ar;
	}
}