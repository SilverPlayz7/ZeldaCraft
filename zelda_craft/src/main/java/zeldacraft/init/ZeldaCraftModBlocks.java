/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package zeldacraft.init;

import zeldacraft.block.WeightedFloorSwitchBlock;
import zeldacraft.block.TreasureChestBlock;
import zeldacraft.block.TimeshiftOreBlock;
import zeldacraft.block.TimedFloorSwitchBlock;
import zeldacraft.block.SwordStandBlock;
import zeldacraft.block.SmallDungeonChestBlock;
import zeldacraft.block.SheikahLinkBlock;
import zeldacraft.block.RustyFloorSwitchBlock;
import zeldacraft.block.PhantomHourglassBlock;
import zeldacraft.block.OwlStatueBlock;
import zeldacraft.block.OpenChestBlock;
import zeldacraft.block.MountainRokBlock;
import zeldacraft.block.MoltenOreBlock;
import zeldacraft.block.LullabySwitchBlock;
import zeldacraft.block.LockedHylianChestBlock;
import zeldacraft.block.IllusionBlockBlock;
import zeldacraft.block.HookshotTargetBlock;
import zeldacraft.block.HiddenIllusionBlockBlock;
import zeldacraft.block.FloorSwitchBlock;
import zeldacraft.block.FalseIllusionBlockBlock;
import zeldacraft.block.Dungeon1PortalBlock;
import zeldacraft.block.ClosedChestBlock;
import zeldacraft.block.ClimbableHiddenIllusionBlockBlock;
import zeldacraft.block.BombableWallBlock;
import zeldacraft.block.BombableIllusionBlockBlock;
import zeldacraft.block.AnchientCapsuleMachineBlock;

import zeldacraft.ZeldaCraftMod;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.Block;

public class ZeldaCraftModBlocks {
	public static final DeferredRegister<Block> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCKS, ZeldaCraftMod.MODID);
	public static final RegistryObject<Block> MOLTEN_ORE = REGISTRY.register("molten_ore", () -> new MoltenOreBlock());
	public static final RegistryObject<Block> MOUNTAIN_ROK = REGISTRY.register("mountain_rok", () -> new MountainRokBlock());
	public static final RegistryObject<Block> OPEN_CHEST = REGISTRY.register("open_chest", () -> new OpenChestBlock());
	public static final RegistryObject<Block> HYLIAN_CHEST = REGISTRY.register("hylian_chest", () -> new ClosedChestBlock());
	public static final RegistryObject<Block> SWORD_STAND = REGISTRY.register("sword_stand", () -> new SwordStandBlock());
	public static final RegistryObject<Block> LOCKED_HYLIAN_CHEST = REGISTRY.register("locked_hylian_chest", () -> new LockedHylianChestBlock());
	public static final RegistryObject<Block> TIMESHIFT_ORE = REGISTRY.register("timeshift_ore", () -> new TimeshiftOreBlock());
	public static final RegistryObject<Block> ANCHIENT_CAPSULE_MACHINE = REGISTRY.register("anchient_capsule_machine", () -> new AnchientCapsuleMachineBlock());
	public static final RegistryObject<Block> TREASURE_CHEST = REGISTRY.register("treasure_chest", () -> new TreasureChestBlock());
	public static final RegistryObject<Block> BOMBABLE_WALL = REGISTRY.register("bombable_wall", () -> new BombableWallBlock());
	public static final RegistryObject<Block> DUNGEON_1_PORTAL = REGISTRY.register("dungeon_1_portal", () -> new Dungeon1PortalBlock());
	public static final RegistryObject<Block> HOOKSHOT_TARGET = REGISTRY.register("hookshot_target", () -> new HookshotTargetBlock());
	public static final RegistryObject<Block> SMALL_DUNGEON_CHEST = REGISTRY.register("small_dungeon_chest", () -> new SmallDungeonChestBlock());
	public static final RegistryObject<Block> ILLUSION_BLOCK = REGISTRY.register("illusion_block", () -> new IllusionBlockBlock());
	public static final RegistryObject<Block> FALSE_ILLUSION_BLOCK = REGISTRY.register("false_illusion_block", () -> new FalseIllusionBlockBlock());
	public static final RegistryObject<Block> HIDDEN_ILLUSION_BLOCK = REGISTRY.register("hidden_illusion_block", () -> new HiddenIllusionBlockBlock());
	public static final RegistryObject<Block> CLIMBABLE_HIDDEN_ILLUSION_BLOCK = REGISTRY.register("climbable_hidden_illusion_block", () -> new ClimbableHiddenIllusionBlockBlock());
	public static final RegistryObject<Block> BOMBABLE_ILLUSION_BLOCK = REGISTRY.register("bombable_illusion_block", () -> new BombableIllusionBlockBlock());
	public static final RegistryObject<Block> PHANTOM_HOURGLASS = REGISTRY.register("phantom_hourglass", () -> new PhantomHourglassBlock());
	public static final RegistryObject<Block> FLOOR_SWITCH = REGISTRY.register("floor_switch", () -> new FloorSwitchBlock());
	public static final RegistryObject<Block> SHEIKAH_LINK = REGISTRY.register("sheikah_link", () -> new SheikahLinkBlock());
	public static final RegistryObject<Block> TIMED_FLOOR_SWITCH = REGISTRY.register("timed_floor_switch", () -> new TimedFloorSwitchBlock());
	public static final RegistryObject<Block> WEIGHTED_FLOOR_SWITCH = REGISTRY.register("weighted_floor_switch", () -> new WeightedFloorSwitchBlock());
	public static final RegistryObject<Block> RUSTY_FLOOR_SWITCH = REGISTRY.register("rusty_floor_switch", () -> new RustyFloorSwitchBlock());
	public static final RegistryObject<Block> LULLABY_SWITCH = REGISTRY.register("lullaby_switch", () -> new LullabySwitchBlock());
	public static final RegistryObject<Block> OWL_STATUE = REGISTRY.register("owl_statue", () -> new OwlStatueBlock());
	// Start of user code block custom blocks
	// End of user code block custom blocks
}