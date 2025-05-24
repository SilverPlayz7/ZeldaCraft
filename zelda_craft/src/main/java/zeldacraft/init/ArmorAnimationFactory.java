package zeldacraft.init;

import zeldacraft.item.WindArmorItem;
import zeldacraft.item.TwilightArmorItem;
import zeldacraft.item.TimeArmorItem;
import zeldacraft.item.SalvagerSetItem;
import zeldacraft.item.RedTimeArmorItem;
import zeldacraft.item.PurpleTimeArmorItem;
import zeldacraft.item.GoldTimeArmorItem;
import zeldacraft.item.DarkTimeArmorItem;
import zeldacraft.item.BlueTimeArmorItem;

import software.bernie.geckolib.animatable.GeoItem;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.EquipmentSlot;

@Mod.EventBusSubscriber
public class ArmorAnimationFactory {
	@SubscribeEvent
	public static void animatedArmors(TickEvent.PlayerTickEvent event) {
		String animation = "";
		if (event.phase == TickEvent.Phase.END) {
			if (event.player.getItemBySlot(EquipmentSlot.HEAD).getItem() != (ItemStack.EMPTY).getItem() && event.player.getItemBySlot(EquipmentSlot.HEAD).getItem() instanceof GeoItem) {
				if (!event.player.getItemBySlot(EquipmentSlot.HEAD).getOrCreateTag().getString("geckoAnim").equals("")) {
					animation = event.player.getItemBySlot(EquipmentSlot.HEAD).getOrCreateTag().getString("geckoAnim");
					event.player.getItemBySlot(EquipmentSlot.HEAD).getOrCreateTag().putString("geckoAnim", "");
					if (event.player.getItemBySlot(EquipmentSlot.HEAD).getItem() instanceof TwilightArmorItem animatable && event.player.level().isClientSide())
						animatable.animationprocedure = animation;
					if (event.player.getItemBySlot(EquipmentSlot.HEAD).getItem() instanceof TimeArmorItem animatable && event.player.level().isClientSide())
						animatable.animationprocedure = animation;
					if (event.player.getItemBySlot(EquipmentSlot.HEAD).getItem() instanceof DarkTimeArmorItem animatable && event.player.level().isClientSide())
						animatable.animationprocedure = animation;
					if (event.player.getItemBySlot(EquipmentSlot.HEAD).getItem() instanceof SalvagerSetItem animatable && event.player.level().isClientSide())
						animatable.animationprocedure = animation;
					if (event.player.getItemBySlot(EquipmentSlot.HEAD).getItem() instanceof WindArmorItem animatable && event.player.level().isClientSide())
						animatable.animationprocedure = animation;
					if (event.player.getItemBySlot(EquipmentSlot.HEAD).getItem() instanceof BlueTimeArmorItem animatable && event.player.level().isClientSide())
						animatable.animationprocedure = animation;
					if (event.player.getItemBySlot(EquipmentSlot.HEAD).getItem() instanceof RedTimeArmorItem animatable && event.player.level().isClientSide())
						animatable.animationprocedure = animation;
					if (event.player.getItemBySlot(EquipmentSlot.HEAD).getItem() instanceof GoldTimeArmorItem animatable && event.player.level().isClientSide())
						animatable.animationprocedure = animation;
					if (event.player.getItemBySlot(EquipmentSlot.HEAD).getItem() instanceof PurpleTimeArmorItem animatable && event.player.level().isClientSide())
						animatable.animationprocedure = animation;
				}
			}
			if (event.player.getItemBySlot(EquipmentSlot.CHEST).getItem() != (ItemStack.EMPTY).getItem() && event.player.getItemBySlot(EquipmentSlot.CHEST).getItem() instanceof GeoItem) {
				if (!event.player.getItemBySlot(EquipmentSlot.CHEST).getOrCreateTag().getString("geckoAnim").equals("")) {
					animation = event.player.getItemBySlot(EquipmentSlot.CHEST).getOrCreateTag().getString("geckoAnim");
					event.player.getItemBySlot(EquipmentSlot.CHEST).getOrCreateTag().putString("geckoAnim", "");
					if (event.player.getItemBySlot(EquipmentSlot.CHEST).getItem() instanceof TwilightArmorItem animatable && event.player.level().isClientSide())
						animatable.animationprocedure = animation;
					if (event.player.getItemBySlot(EquipmentSlot.CHEST).getItem() instanceof TimeArmorItem animatable && event.player.level().isClientSide())
						animatable.animationprocedure = animation;
					if (event.player.getItemBySlot(EquipmentSlot.CHEST).getItem() instanceof DarkTimeArmorItem animatable && event.player.level().isClientSide())
						animatable.animationprocedure = animation;
					if (event.player.getItemBySlot(EquipmentSlot.CHEST).getItem() instanceof SalvagerSetItem animatable && event.player.level().isClientSide())
						animatable.animationprocedure = animation;
					if (event.player.getItemBySlot(EquipmentSlot.CHEST).getItem() instanceof WindArmorItem animatable && event.player.level().isClientSide())
						animatable.animationprocedure = animation;
					if (event.player.getItemBySlot(EquipmentSlot.CHEST).getItem() instanceof BlueTimeArmorItem animatable && event.player.level().isClientSide())
						animatable.animationprocedure = animation;
					if (event.player.getItemBySlot(EquipmentSlot.CHEST).getItem() instanceof RedTimeArmorItem animatable && event.player.level().isClientSide())
						animatable.animationprocedure = animation;
					if (event.player.getItemBySlot(EquipmentSlot.CHEST).getItem() instanceof GoldTimeArmorItem animatable && event.player.level().isClientSide())
						animatable.animationprocedure = animation;
					if (event.player.getItemBySlot(EquipmentSlot.CHEST).getItem() instanceof PurpleTimeArmorItem animatable && event.player.level().isClientSide())
						animatable.animationprocedure = animation;
				}
			}
			if (event.player.getItemBySlot(EquipmentSlot.LEGS).getItem() != (ItemStack.EMPTY).getItem() && event.player.getItemBySlot(EquipmentSlot.LEGS).getItem() instanceof GeoItem) {
				if (!event.player.getItemBySlot(EquipmentSlot.LEGS).getOrCreateTag().getString("geckoAnim").equals("")) {
					animation = event.player.getItemBySlot(EquipmentSlot.LEGS).getOrCreateTag().getString("geckoAnim");
					event.player.getItemBySlot(EquipmentSlot.LEGS).getOrCreateTag().putString("geckoAnim", "");
					if (event.player.getItemBySlot(EquipmentSlot.LEGS).getItem() instanceof TwilightArmorItem animatable && event.player.level().isClientSide())
						animatable.animationprocedure = animation;
					if (event.player.getItemBySlot(EquipmentSlot.LEGS).getItem() instanceof TimeArmorItem animatable && event.player.level().isClientSide())
						animatable.animationprocedure = animation;
					if (event.player.getItemBySlot(EquipmentSlot.LEGS).getItem() instanceof DarkTimeArmorItem animatable && event.player.level().isClientSide())
						animatable.animationprocedure = animation;
					if (event.player.getItemBySlot(EquipmentSlot.LEGS).getItem() instanceof SalvagerSetItem animatable && event.player.level().isClientSide())
						animatable.animationprocedure = animation;
					if (event.player.getItemBySlot(EquipmentSlot.LEGS).getItem() instanceof WindArmorItem animatable && event.player.level().isClientSide())
						animatable.animationprocedure = animation;
					if (event.player.getItemBySlot(EquipmentSlot.LEGS).getItem() instanceof BlueTimeArmorItem animatable && event.player.level().isClientSide())
						animatable.animationprocedure = animation;
					if (event.player.getItemBySlot(EquipmentSlot.LEGS).getItem() instanceof RedTimeArmorItem animatable && event.player.level().isClientSide())
						animatable.animationprocedure = animation;
					if (event.player.getItemBySlot(EquipmentSlot.LEGS).getItem() instanceof GoldTimeArmorItem animatable && event.player.level().isClientSide())
						animatable.animationprocedure = animation;
					if (event.player.getItemBySlot(EquipmentSlot.LEGS).getItem() instanceof PurpleTimeArmorItem animatable && event.player.level().isClientSide())
						animatable.animationprocedure = animation;
				}
			}
			if (event.player.getItemBySlot(EquipmentSlot.FEET).getItem() != (ItemStack.EMPTY).getItem() && event.player.getItemBySlot(EquipmentSlot.FEET).getItem() instanceof GeoItem) {
				if (!event.player.getItemBySlot(EquipmentSlot.FEET).getOrCreateTag().getString("geckoAnim").equals("")) {
					animation = event.player.getItemBySlot(EquipmentSlot.FEET).getOrCreateTag().getString("geckoAnim");
					event.player.getItemBySlot(EquipmentSlot.FEET).getOrCreateTag().putString("geckoAnim", "");
					if (event.player.getItemBySlot(EquipmentSlot.FEET).getItem() instanceof TwilightArmorItem animatable && event.player.level().isClientSide())
						animatable.animationprocedure = animation;
					if (event.player.getItemBySlot(EquipmentSlot.FEET).getItem() instanceof TimeArmorItem animatable && event.player.level().isClientSide())
						animatable.animationprocedure = animation;
					if (event.player.getItemBySlot(EquipmentSlot.FEET).getItem() instanceof DarkTimeArmorItem animatable && event.player.level().isClientSide())
						animatable.animationprocedure = animation;
					if (event.player.getItemBySlot(EquipmentSlot.FEET).getItem() instanceof SalvagerSetItem animatable && event.player.level().isClientSide())
						animatable.animationprocedure = animation;
					if (event.player.getItemBySlot(EquipmentSlot.FEET).getItem() instanceof WindArmorItem animatable && event.player.level().isClientSide())
						animatable.animationprocedure = animation;
					if (event.player.getItemBySlot(EquipmentSlot.FEET).getItem() instanceof BlueTimeArmorItem animatable && event.player.level().isClientSide())
						animatable.animationprocedure = animation;
					if (event.player.getItemBySlot(EquipmentSlot.FEET).getItem() instanceof RedTimeArmorItem animatable && event.player.level().isClientSide())
						animatable.animationprocedure = animation;
					if (event.player.getItemBySlot(EquipmentSlot.FEET).getItem() instanceof GoldTimeArmorItem animatable && event.player.level().isClientSide())
						animatable.animationprocedure = animation;
					if (event.player.getItemBySlot(EquipmentSlot.FEET).getItem() instanceof PurpleTimeArmorItem animatable && event.player.level().isClientSide())
						animatable.animationprocedure = animation;
				}
			}
		}
	}
}
