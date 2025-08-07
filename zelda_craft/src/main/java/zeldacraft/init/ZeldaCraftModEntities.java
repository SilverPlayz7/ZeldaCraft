
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package zeldacraft.init;

import zeldacraft.entity.MasterSwordBeamProjectileProjectileEntity;
import zeldacraft.entity.LongShotProjectileEntity;
import zeldacraft.entity.HookShotProjectileEntity;
import zeldacraft.entity.HappyMaskSalesmanEntity;
import zeldacraft.entity.FairyEntity;
import zeldacraft.entity.BoomerangProjectileEntity;
import zeldacraft.entity.BombProjectileEntity;

import zeldacraft.ZeldaCraftMod;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;

import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class ZeldaCraftModEntities {
	public static final DeferredRegister<EntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, ZeldaCraftMod.MODID);
	public static final RegistryObject<EntityType<BoomerangProjectileEntity>> BOOMERANG_PROJECTILE = register("boomerang_projectile", EntityType.Builder.<BoomerangProjectileEntity>of(BoomerangProjectileEntity::new, MobCategory.MISC)
			.setCustomClientFactory(BoomerangProjectileEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<HookShotProjectileEntity>> HOOK_SHOT_PROJECTILE = register("hook_shot_projectile", EntityType.Builder.<HookShotProjectileEntity>of(HookShotProjectileEntity::new, MobCategory.MISC)
			.setCustomClientFactory(HookShotProjectileEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<LongShotProjectileEntity>> LONG_SHOT_PROJECTILE = register("long_shot_projectile", EntityType.Builder.<LongShotProjectileEntity>of(LongShotProjectileEntity::new, MobCategory.MISC)
			.setCustomClientFactory(LongShotProjectileEntity::new).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<MasterSwordBeamProjectileProjectileEntity>> MASTER_SWORD_BEAM_PROJECTILE_PROJECTILE = register("master_sword_beam_projectile_projectile",
			EntityType.Builder.<MasterSwordBeamProjectileProjectileEntity>of(MasterSwordBeamProjectileProjectileEntity::new, MobCategory.MISC).setCustomClientFactory(MasterSwordBeamProjectileProjectileEntity::new)
					.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final RegistryObject<EntityType<HappyMaskSalesmanEntity>> HAPPY_MASK_SALESMAN = register("happy_mask_salesman", EntityType.Builder.<HappyMaskSalesmanEntity>of(HappyMaskSalesmanEntity::new, MobCategory.CREATURE)
			.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(HappyMaskSalesmanEntity::new).fireImmune().sized(1f, 2f));
	public static final RegistryObject<EntityType<BombProjectileEntity>> BOMB_PROJECTILE = register("bomb_projectile", EntityType.Builder.<BombProjectileEntity>of(BombProjectileEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true)
			.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(BombProjectileEntity::new).fireImmune().sized(0.6f, 0.6f));
	public static final RegistryObject<EntityType<FairyEntity>> FAIRY = register("fairy",
			EntityType.Builder.<FairyEntity>of(FairyEntity::new, MobCategory.AMBIENT).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(FairyEntity::new)

					.sized(0.4f, 0.4f));

	// Start of user code block custom entities
	// End of user code block custom entities
	private static <T extends Entity> RegistryObject<EntityType<T>> register(String registryname, EntityType.Builder<T> entityTypeBuilder) {
		return REGISTRY.register(registryname, () -> (EntityType<T>) entityTypeBuilder.build(registryname));
	}

	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		event.enqueueWork(() -> {
			HappyMaskSalesmanEntity.init();
			BombProjectileEntity.init();
			FairyEntity.init();
		});
	}

	@SubscribeEvent
	public static void registerAttributes(EntityAttributeCreationEvent event) {
		event.put(HAPPY_MASK_SALESMAN.get(), HappyMaskSalesmanEntity.createAttributes().build());
		event.put(BOMB_PROJECTILE.get(), BombProjectileEntity.createAttributes().build());
		event.put(FAIRY.get(), FairyEntity.createAttributes().build());
	}
}
