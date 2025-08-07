
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package zeldacraft.init;

import zeldacraft.block.entity.TreasureChestTileEntity;
import zeldacraft.block.entity.SwordStandBlockEntity;
import zeldacraft.block.entity.SmallDungeonChestTileEntity;
import zeldacraft.block.entity.OpenChestBlockEntity;
import zeldacraft.block.entity.LockedHylianChestBlockEntity;
import zeldacraft.block.entity.IllusionBlockBlockEntity;
import zeldacraft.block.entity.FloorSwitchBlockEntity;
import zeldacraft.block.entity.ClosedChestBlockEntity;
import zeldacraft.block.entity.AnchientCapsuleMachineTileEntity;

import zeldacraft.ZeldaCraftMod;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.Block;

public class ZeldaCraftModBlockEntities {
	public static final DeferredRegister<BlockEntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, ZeldaCraftMod.MODID);
	public static final RegistryObject<BlockEntityType<?>> OPEN_CHEST = register("open_chest", ZeldaCraftModBlocks.OPEN_CHEST, OpenChestBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> HYLIAN_CHEST = register("hylian_chest", ZeldaCraftModBlocks.HYLIAN_CHEST, ClosedChestBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> SWORD_STAND = register("sword_stand", ZeldaCraftModBlocks.SWORD_STAND, SwordStandBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> LOCKED_HYLIAN_CHEST = register("locked_hylian_chest", ZeldaCraftModBlocks.LOCKED_HYLIAN_CHEST, LockedHylianChestBlockEntity::new);
	public static final RegistryObject<BlockEntityType<AnchientCapsuleMachineTileEntity>> ANCHIENT_CAPSULE_MACHINE = REGISTRY.register("anchient_capsule_machine",
			() -> BlockEntityType.Builder.of(AnchientCapsuleMachineTileEntity::new, ZeldaCraftModBlocks.ANCHIENT_CAPSULE_MACHINE.get()).build(null));
	public static final RegistryObject<BlockEntityType<TreasureChestTileEntity>> TREASURE_CHEST = REGISTRY.register("treasure_chest",
			() -> BlockEntityType.Builder.of(TreasureChestTileEntity::new, ZeldaCraftModBlocks.TREASURE_CHEST.get()).build(null));
	public static final RegistryObject<BlockEntityType<SmallDungeonChestTileEntity>> SMALL_DUNGEON_CHEST = REGISTRY.register("small_dungeon_chest",
			() -> BlockEntityType.Builder.of(SmallDungeonChestTileEntity::new, ZeldaCraftModBlocks.SMALL_DUNGEON_CHEST.get()).build(null));
	public static final RegistryObject<BlockEntityType<?>> ILLUSION_BLOCK = register("illusion_block", ZeldaCraftModBlocks.ILLUSION_BLOCK, IllusionBlockBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> FLOOR_SWITCH = register("floor_switch", ZeldaCraftModBlocks.FLOOR_SWITCH, FloorSwitchBlockEntity::new);

	// Start of user code block custom block entities
	// End of user code block custom block entities
	private static RegistryObject<BlockEntityType<?>> register(String registryname, RegistryObject<Block> block, BlockEntityType.BlockEntitySupplier<?> supplier) {
		return REGISTRY.register(registryname, () -> BlockEntityType.Builder.of(supplier, block.get()).build(null));
	}
}
