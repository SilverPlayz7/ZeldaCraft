
package zeldacraft.item;

import zeldacraft.init.ZeldaCraftModItems;

import zeldacraft.client.renderer.TwilightArmorArmorRenderer;

import software.bernie.geckolib.util.GeckoLibUtil;
import software.bernie.geckolib.renderer.GeoArmorRenderer;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.core.animation.RawAnimation;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.animatable.GeoItem;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.entity.decoration.ArmorStand;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.model.HumanoidModel;

import java.util.function.Consumer;
import java.util.Set;
import java.util.List;

import it.unimi.dsi.fastutil.objects.ObjectOpenHashSet;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;

public class TwilightArmorItem extends ArmorItem implements GeoItem {
	private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);
	public String animationprocedure = "empty";

	public TwilightArmorItem(ArmorItem.Type type, Item.Properties properties) {
		super(new ArmorMaterial() {
			@Override
			public int getDurabilityForType(ArmorItem.Type type) {
				return new int[]{13, 15, 16, 11}[type.getSlot().getIndex()] * 0;
			}

			@Override
			public int getDefenseForType(ArmorItem.Type type) {
				return new int[]{3, 6, 8, 2}[type.getSlot().getIndex()];
			}

			@Override
			public int getEnchantmentValue() {
				return 9;
			}

			@Override
			public SoundEvent getEquipSound() {
				return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.armor.equip_leather"));
			}

			@Override
			public Ingredient getRepairIngredient() {
				return Ingredient.of();
			}

			@Override
			public String getName() {
				return "twilight_armor";
			}

			@Override
			public float getToughness() {
				return 2.5f;
			}

			@Override
			public float getKnockbackResistance() {
				return 0f;
			}
		}, type, properties);
	}

	@Override
	public void initializeClient(Consumer<IClientItemExtensions> consumer) {
		consumer.accept(new IClientItemExtensions() {
			private GeoArmorRenderer<?> renderer;

			@Override
			public HumanoidModel<?> getHumanoidArmorModel(LivingEntity livingEntity, ItemStack itemStack, EquipmentSlot equipmentSlot, HumanoidModel<?> original) {
				if (this.renderer == null)
					this.renderer = new TwilightArmorArmorRenderer();
				this.renderer.prepForRender(livingEntity, itemStack, equipmentSlot, original);
				return this.renderer;
			}
		});
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, world, list, flag);
		if (itemstack.getItem() instanceof TwilightArmorItem armor && armor.getType() == ArmorItem.Type.HELMET) {
			list.add(Component.literal("According to legend this cap was once worn by a hero who battled the monsters of twilight. For one reason or another it seems to smell of some beast..."));
		}
		if (itemstack.getItem() instanceof TwilightArmorItem armor && armor.getType() == ArmorItem.Type.CHESTPLATE) {
			list.add(Component.literal("Legend has it this armor was worn by a hero who battled the monsters of twilight. There still seems to be some hair clinging to it... Looks like it may be from a wolf?"));
		}
		if (itemstack.getItem() instanceof TwilightArmorItem armor && armor.getType() == ArmorItem.Type.LEGGINGS) {
			list.add(Component.literal("Legends say these greaves were once worn by a hero who battled the beasts of twilight. There seem to be some unnatural knee bends in them."));
		}
		if (itemstack.getItem() instanceof TwilightArmorItem armor && armor.getType() == ArmorItem.Type.BOOTS) {
			list.add(Component.literal("Legends say these boots were once worn by a hero who battled the beasts of twilight. The insides are lined with cozy wolf fur."));
		}
	}

	private PlayState predicate(AnimationState event) {
		if (this.animationprocedure.equals("empty")) {
			event.getController().setAnimation(RawAnimation.begin().thenLoop("animation.TPChest.new"));
			Entity entity = (Entity) event.getData(DataTickets.ENTITY);
			if (entity instanceof ArmorStand) {
				return PlayState.CONTINUE;
			}
			Set<Item> wornArmor = new ObjectOpenHashSet<>();
			for (ItemStack stack : entity.getArmorSlots()) {
				if (stack.isEmpty())
					return PlayState.STOP;
				wornArmor.add(stack.getItem());
			}
			boolean isWearingAll = wornArmor
					.containsAll(ObjectArrayList.of(ZeldaCraftModItems.TWILIGHT_ARMOR_BOOTS.get(), ZeldaCraftModItems.TWILIGHT_ARMOR_LEGGINGS.get(), ZeldaCraftModItems.TWILIGHT_ARMOR_CHESTPLATE.get(), ZeldaCraftModItems.TWILIGHT_ARMOR_HELMET.get()));
			return isWearingAll ? PlayState.CONTINUE : PlayState.STOP;
		}
		return PlayState.STOP;
	}

	String prevAnim = "empty";

	private PlayState procedurePredicate(AnimationState event) {
		if (!this.animationprocedure.equals("empty") && event.getController().getAnimationState() == AnimationController.State.STOPPED || (!this.animationprocedure.equals(prevAnim) && !this.animationprocedure.equals("empty"))) {
			if (!this.animationprocedure.equals(prevAnim))
				event.getController().forceAnimationReset();
			event.getController().setAnimation(RawAnimation.begin().thenPlay(this.animationprocedure));
			if (event.getController().getAnimationState() == AnimationController.State.STOPPED) {
				this.animationprocedure = "empty";
				event.getController().forceAnimationReset();
			}
			Entity entity = (Entity) event.getData(DataTickets.ENTITY);
			if (entity instanceof ArmorStand) {
				return PlayState.CONTINUE;
			}
			Set<Item> wornArmor = new ObjectOpenHashSet<>();
			for (ItemStack stack : entity.getArmorSlots()) {
				if (stack.isEmpty())
					return PlayState.STOP;
				wornArmor.add(stack.getItem());
			}
			boolean isWearingAll = wornArmor
					.containsAll(ObjectArrayList.of(ZeldaCraftModItems.TWILIGHT_ARMOR_BOOTS.get(), ZeldaCraftModItems.TWILIGHT_ARMOR_LEGGINGS.get(), ZeldaCraftModItems.TWILIGHT_ARMOR_CHESTPLATE.get(), ZeldaCraftModItems.TWILIGHT_ARMOR_HELMET.get()));
			return isWearingAll ? PlayState.CONTINUE : PlayState.STOP;
		} else if (animationprocedure.equals("empty")) {
			prevAnim = "empty";
			return PlayState.STOP;
		}
		prevAnim = this.animationprocedure;
		return PlayState.CONTINUE;
	}

	@Override
	public void registerControllers(AnimatableManager.ControllerRegistrar data) {
		data.add(new AnimationController(this, "controller", 5, this::predicate));
		data.add(new AnimationController(this, "procedureController", 5, this::procedurePredicate));
	}

	@Override
	public AnimatableInstanceCache getAnimatableInstanceCache() {
		return this.cache;
	}
}
