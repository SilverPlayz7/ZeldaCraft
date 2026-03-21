package zeldacraft.procedures;

import zeldacraft.init.ZeldaCraftModItems;

import top.theillusivec4.curios.api.CuriosApi;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

public class EquipedWalletProcedure {
	public static ItemStack execute(Entity entity) {
		if (entity == null)
			return ItemStack.EMPTY;
		if (entity instanceof LivingEntity lv ? CuriosApi.getCuriosHelper().findEquippedCurio(ZeldaCraftModItems.CHILD_WALLET.get(), lv).isPresent() : false) {
			return new ItemStack(ZeldaCraftModItems.CHILD_WALLET.get());
		}
		if (entity instanceof LivingEntity lv ? CuriosApi.getCuriosHelper().findEquippedCurio(ZeldaCraftModItems.ADULT_WALLET.get(), lv).isPresent() : false) {
			return new ItemStack(ZeldaCraftModItems.ADULT_WALLET.get());
		}
		if (entity instanceof LivingEntity lv ? CuriosApi.getCuriosHelper().findEquippedCurio(ZeldaCraftModItems.BIG_WALLET.get(), lv).isPresent() : false) {
			return new ItemStack(ZeldaCraftModItems.BIG_WALLET.get());
		}
		if (entity instanceof LivingEntity lv ? CuriosApi.getCuriosHelper().findEquippedCurio(ZeldaCraftModItems.GIANT_WALLET.get(), lv).isPresent() : false) {
			return new ItemStack(ZeldaCraftModItems.GIANT_WALLET.get());
		}
		if (entity instanceof LivingEntity lv ? CuriosApi.getCuriosHelper().findEquippedCurio(ZeldaCraftModItems.TYCOON_WALLET.get(), lv).isPresent() : false) {
			return new ItemStack(ZeldaCraftModItems.TYCOON_WALLET.get());
		}
		return new ItemStack(Blocks.AIR);
	}
}