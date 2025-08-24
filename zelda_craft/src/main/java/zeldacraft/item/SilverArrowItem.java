
package zeldacraft.item;

import zeldacraft.init.ZeldaCraftModEntities;

import zeldacraft.entity.SilverArrowProjectileEntity;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ArrowItem;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.LivingEntity;

public class SilverArrowItem extends ArrowItem {
	public SilverArrowItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON));
	}

	public AbstractArrow createArrow(Level world, ItemStack stack, LivingEntity shooter) {
		return new SilverArrowProjectileEntity(ZeldaCraftModEntities.SILVER_ARROW_PROJECTILE.get(), shooter, world);
	}
}
