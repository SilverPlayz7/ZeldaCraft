/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package zeldacraft.init;

import zeldacraft.block.WeightedFloorSwitchBlock;
import zeldacraft.block.TreasureChestBlock;
import zeldacraft.block.TimeshiftOreBlock;
import zeldacraft.block.TimedFloorSwitchBlock;
import zeldacraft.block.SwordStandBlock;
import zeldacraft.block.SpinnerRailBlock;
import zeldacraft.block.SmallDungeonChestBlock;
import zeldacraft.block.SheikahLinkBlock;
import zeldacraft.block.RustyFloorSwitchBlock;
import zeldacraft.block.RoyalSarcophagusBlock;
import zeldacraft.block.PhantomHourglassBlock;
import zeldacraft.block.OwlStatueBlock;
import zeldacraft.block.OpenChestBlock;
import zeldacraft.block.MountainRokBlock;
import zeldacraft.block.MoltenOreBlock;
import zeldacraft.block.LullabySwitchBlock;
import zeldacraft.block.LockedHylianChestBlock;
import zeldacraft.block.LockedDungeonDoorBlock;
import zeldacraft.block.LockedBigDungeonDoorBlock;
import zeldacraft.block.IllusionBlockBlock;
import zeldacraft.block.HookshotTargetBlock;
import zeldacraft.block.HiddenIllusionBlockBlock;
import zeldacraft.block.FloorSwitchBlock;
import zeldacraft.block.FalseIllusionBlockBlock;
import zeldacraft.block.DungeonDoorBlock;
import zeldacraft.block.Dungeon1PortalBlock;
import zeldacraft.block.CrimsonineOreBlock;
import zeldacraft.block.ClosedChestBlock;
import zeldacraft.block.ClimbableHiddenIllusionBlockBlock;
import zeldacraft.block.BombableWallBlock;
import zeldacraft.block.BombableIllusionBlockBlock;
import zeldacraft.block.BigDungeonDoorBlock;
import zeldacraft.block.AzurineOreBlock;
import zeldacraft.block.AquanineOreBlock;
import zeldacraft.block.AnchientCapsuleMachineBlock;

import zeldacraft.ZeldaCraftMod;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.Block;

public class ZeldaCraftModBlocks {
	public static final DeferredRegister<Block> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCKS, ZeldaCraftMod.MODID);
	public static final RegistryObject<Block> MOLTEN_ORE = REGISTRY.register("molten_ore", MoltenOreBlock::new);
	public static final RegistryObject<Block> MOUNTAIN_ROK = REGISTRY.register("mountain_rok", MountainRokBlock::new);
	public static final RegistryObject<Block> OPEN_CHEST = REGISTRY.register("open_chest", OpenChestBlock::new);
	public static final RegistryObject<Block> HYLIAN_CHEST = REGISTRY.register("hylian_chest", ClosedChestBlock::new);
	public static final RegistryObject<Block> SWORD_STAND = REGISTRY.register("sword_stand", SwordStandBlock::new);
	public static final RegistryObject<Block> LOCKED_HYLIAN_CHEST = REGISTRY.register("locked_hylian_chest", LockedHylianChestBlock::new);
	public static final RegistryObject<Block> TIMESHIFT_ORE = REGISTRY.register("timeshift_ore", TimeshiftOreBlock::new);
	public static final RegistryObject<Block> ANCHIENT_CAPSULE_MACHINE = REGISTRY.register("anchient_capsule_machine", AnchientCapsuleMachineBlock::new);
	public static final RegistryObject<Block> TREASURE_CHEST = REGISTRY.register("treasure_chest", TreasureChestBlock::new);
	public static final RegistryObject<Block> BOMBABLE_WALL = REGISTRY.register("bombable_wall", BombableWallBlock::new);
	public static final RegistryObject<Block> DUNGEON_1_PORTAL = REGISTRY.register("dungeon_1_portal", Dungeon1PortalBlock::new);
	public static final RegistryObject<Block> HOOKSHOT_TARGET = REGISTRY.register("hookshot_target", HookshotTargetBlock::new);
	public static final RegistryObject<Block> SMALL_DUNGEON_CHEST = REGISTRY.register("small_dungeon_chest", SmallDungeonChestBlock::new);
	public static final RegistryObject<Block> ILLUSION_BLOCK = REGISTRY.register("illusion_block", IllusionBlockBlock::new);
	public static final RegistryObject<Block> FALSE_ILLUSION_BLOCK = REGISTRY.register("false_illusion_block", FalseIllusionBlockBlock::new);
	public static final RegistryObject<Block> HIDDEN_ILLUSION_BLOCK = REGISTRY.register("hidden_illusion_block", HiddenIllusionBlockBlock::new);
	public static final RegistryObject<Block> CLIMBABLE_HIDDEN_ILLUSION_BLOCK = REGISTRY.register("climbable_hidden_illusion_block", ClimbableHiddenIllusionBlockBlock::new);
	public static final RegistryObject<Block> BOMBABLE_ILLUSION_BLOCK = REGISTRY.register("bombable_illusion_block", BombableIllusionBlockBlock::new);
	public static final RegistryObject<Block> PHANTOM_HOURGLASS = REGISTRY.register("phantom_hourglass", PhantomHourglassBlock::new);
	public static final RegistryObject<Block> FLOOR_SWITCH = REGISTRY.register("floor_switch", FloorSwitchBlock::new);
	public static final RegistryObject<Block> SHEIKAH_LINK = REGISTRY.register("sheikah_link", SheikahLinkBlock::new);
	public static final RegistryObject<Block> TIMED_FLOOR_SWITCH = REGISTRY.register("timed_floor_switch", TimedFloorSwitchBlock::new);
	public static final RegistryObject<Block> WEIGHTED_FLOOR_SWITCH = REGISTRY.register("weighted_floor_switch", WeightedFloorSwitchBlock::new);
	public static final RegistryObject<Block> RUSTY_FLOOR_SWITCH = REGISTRY.register("rusty_floor_switch", RustyFloorSwitchBlock::new);
	public static final RegistryObject<Block> LULLABY_SWITCH = REGISTRY.register("lullaby_switch", LullabySwitchBlock::new);
	public static final RegistryObject<Block> OWL_STATUE = REGISTRY.register("owl_statue", OwlStatueBlock::new);
	public static final RegistryObject<Block> ROYAL_SARCOPHAGUS = REGISTRY.register("royal_sarcophagus", RoyalSarcophagusBlock::new);
	public static final RegistryObject<Block> AZURINE_ORE = REGISTRY.register("azurine_ore", AzurineOreBlock::new);
	public static final RegistryObject<Block> CRIMSONINE_ORE = REGISTRY.register("crimsonine_ore", CrimsonineOreBlock::new);
	public static final RegistryObject<Block> AQUANINE_ORE = REGISTRY.register("aquanine_ore", AquanineOreBlock::new);
	public static final RegistryObject<Block> DUNGEON_DOOR = REGISTRY.register("dungeon_door", DungeonDoorBlock::new);
	public static final RegistryObject<Block> LOCKED_DUNGEON_DOOR = REGISTRY.register("locked_dungeon_door", LockedDungeonDoorBlock::new);
	public static final RegistryObject<Block> SPINNER_RAIL = REGISTRY.register("spinner_rail", SpinnerRailBlock::new);
	public static final RegistryObject<Block> LOCKED_BIG_DUNGEON_DOOR = REGISTRY.register("locked_big_dungeon_door", LockedBigDungeonDoorBlock::new);
	public static final RegistryObject<Block> BIG_DUNGEON_DOOR = REGISTRY.register("big_dungeon_door", BigDungeonDoorBlock::new);
	// Start of user code block custom blocks
	// End of user code block custom blocks
}