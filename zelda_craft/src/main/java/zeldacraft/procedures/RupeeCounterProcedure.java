package zeldacraft.procedures;

import zeldacraft.init.ZeldaCraftModMenus;

import top.theillusivec4.curios.api.CuriosApi;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.ItemTags;
import net.minecraft.resources.ResourceLocation;

public class RupeeCounterProcedure {
	public static String execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return "";
		if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof ZeldaCraftModMenus.MenuAccessor _menu0 ? _menu0.getSlots().get(0).getItem() : ItemStack.EMPTY)
				.is(ItemTags.create(ResourceLocation.parse("zelda_craft:wallet")))) {
			return new java.text.DecimalFormat("##.##")
					.format((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof ZeldaCraftModMenus.MenuAccessor _menu2 ? _menu2.getSlots().get(0).getItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("RupeeCount"));
		} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).is(ItemTags.create(ResourceLocation.parse("zelda_craft:wallet")))) {
			return new java.text.DecimalFormat("##.##").format((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("RupeeCount"));
		} else if (entity instanceof LivingEntity lv ? CuriosApi.getCuriosHelper().findEquippedCurio(EquipedWalletProcedure.execute(entity).getItem(), lv).isPresent() : false) {
			if (entity instanceof LivingEntity lv) {
				CuriosApi.getCuriosHelper().findCurios(lv, EquipedWalletProcedure.execute(entity).getItem()).forEach(item -> {
					ItemStack itemstackiterator = item.stack();
					entity.getPersistentData().putString("curiosBal", (new java.text.DecimalFormat("##.##").format(itemstackiterator.getOrCreateTag().getDouble("RupeeCount"))));
				});
			}
			return entity.getPersistentData().getString("curiosBal");
		}
		return new java.text.DecimalFormat("##.##").format((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("RupeeCount"));
	}
}