/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package zeldacraft.init;

import zeldacraft.ZeldaCraftMod;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class ZeldaCraftModTabs {
	public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, ZeldaCraftMod.MODID);
	public static final RegistryObject<CreativeModeTab> ZELDA_CRAFT = REGISTRY.register("zelda_craft",
			() -> CreativeModeTab.builder().title(Component.translatable("item_group.zelda_craft.zelda_craft")).icon(() -> new ItemStack(ZeldaCraftModItems.TRIFORCE.get())).displayItems((parameters, tabData) -> {
				tabData.accept(ZeldaCraftModItems.TRIFORCE.get());
				tabData.accept(ZeldaCraftModItems.KOKIRI_SWORD.get());
				tabData.accept(ZeldaCraftModItems.RAZOR_SWORD.get());
				tabData.accept(ZeldaCraftModItems.RECRUIT_SWORD.get());
				tabData.accept(ZeldaCraftModItems.PHANTOM_SWORD.get());
				tabData.accept(ZeldaCraftModItems.LOKOMO_SWORD.get());
				tabData.accept(ZeldaCraftModItems.DEMON_TRIBE_SWORD.get());
				tabData.accept(ZeldaCraftModItems.GODDESS_SWORD.get());
				tabData.accept(ZeldaCraftModItems.UN_POWERED_MASTER_SWORD.get());
				tabData.accept(ZeldaCraftModItems.MASTER_SWORD.get());
				tabData.accept(ZeldaCraftModItems.GIANT_KNIFE.get());
				tabData.accept(ZeldaCraftModItems.BIGGORON_SWORD.get());
				tabData.accept(ZeldaCraftModItems.MEGATON_HAMMER.get());
				tabData.accept(ZeldaCraftModItems.NEW_HYRULE_SHIELD.get());
				tabData.accept(ZeldaCraftModItems.REPLICA_HYLIAN_SHIELD.get());
				tabData.accept(ZeldaCraftModItems.HYLIAN_SHIELD.get());
				tabData.accept(ZeldaCraftModItems.MIRROR_SHIELD_OOT.get());
				tabData.accept(ZeldaCraftModItems.BOMB.get());
				tabData.accept(ZeldaCraftModItems.BOOMERANG.get());
				tabData.accept(ZeldaCraftModItems.HERO_BOW.get());
				tabData.accept(ZeldaCraftModItems.FIRE_ARROW.get());
				tabData.accept(ZeldaCraftModItems.ICE_ARROW.get());
				tabData.accept(ZeldaCraftModItems.SHOCK_ARROW.get());
				tabData.accept(ZeldaCraftModItems.BOMB_ARROW.get());
				tabData.accept(ZeldaCraftModItems.LIGHT_ARROW.get());
				tabData.accept(ZeldaCraftModItems.SILVER_ARROW.get());
				tabData.accept(ZeldaCraftModItems.HOOK_SHOT.get());
				tabData.accept(ZeldaCraftModItems.LONG_SHOT.get());
				tabData.accept(ZeldaCraftModItems.CHAIN_SPOOL.get());
				tabData.accept(ZeldaCraftModItems.WARP_FLUTE.get());
				tabData.accept(ZeldaCraftModItems.FAIRY_OCARINA.get());
				tabData.accept(ZeldaCraftModItems.OCCARINA_OF_TIME.get());
				tabData.accept(ZeldaCraftModItems.SPIRIT_FLUTE.get());
				tabData.accept(ZeldaCraftModItems.MAGIC_MIRROR.get());
				tabData.accept(ZeldaCraftModItems.LENS_OF_TRUTH.get());
				tabData.accept(ZeldaCraftModItems.ROC_FEATHER.get());
				tabData.accept(ZeldaCraftModItems.ROC_CAPE.get());
				tabData.accept(ZeldaCraftModItems.PEGASUS_BOOTS_BOOTS.get());
				tabData.accept(ZeldaCraftModItems.IRON_BOOTS_BOOTS.get());
				tabData.accept(ZeldaCraftModItems.HOVER_BOOTS_BOOTS.get());
				tabData.accept(ZeldaCraftModItems.TWILIGHT_ARMOR_BUNDLE.get());
				tabData.accept(ZeldaCraftModItems.TWILIGHT_ARMOR_HELMET.get());
				tabData.accept(ZeldaCraftModItems.TWILIGHT_ARMOR_CHESTPLATE.get());
				tabData.accept(ZeldaCraftModItems.TWILIGHT_ARMOR_LEGGINGS.get());
				tabData.accept(ZeldaCraftModItems.TWILIGHT_ARMOR_BOOTS.get());
				tabData.accept(ZeldaCraftModItems.TIME_ARMOR_BUNDLE.get());
				tabData.accept(ZeldaCraftModItems.TIME_ARMOR_HELMET.get());
				tabData.accept(ZeldaCraftModItems.TIME_ARMOR_CHESTPLATE.get());
				tabData.accept(ZeldaCraftModItems.TIME_ARMOR_LEGGINGS.get());
				tabData.accept(ZeldaCraftModItems.TIME_ARMOR_BOOTS.get());
				tabData.accept(ZeldaCraftModItems.BLUE_TIME_ARMOR_BUNDLE.get());
				tabData.accept(ZeldaCraftModItems.BLUE_TIME_ARMOR_HELMET.get());
				tabData.accept(ZeldaCraftModItems.BLUE_TIME_ARMOR_CHESTPLATE.get());
				tabData.accept(ZeldaCraftModItems.BLUE_TIME_ARMOR_LEGGINGS.get());
				tabData.accept(ZeldaCraftModItems.RED_TIME_ARMOR_BUNDLE.get());
				tabData.accept(ZeldaCraftModItems.RED_TIME_ARMOR_HELMET.get());
				tabData.accept(ZeldaCraftModItems.RED_TIME_ARMOR_CHESTPLATE.get());
				tabData.accept(ZeldaCraftModItems.RED_TIME_ARMOR_LEGGINGS.get());
				tabData.accept(ZeldaCraftModItems.GOLD_TIME_ARMOR_BUNDLE.get());
				tabData.accept(ZeldaCraftModItems.GOLD_TIME_ARMOR_HELMET.get());
				tabData.accept(ZeldaCraftModItems.GOLD_TIME_ARMOR_CHESTPLATE.get());
				tabData.accept(ZeldaCraftModItems.GOLD_TIME_ARMOR_LEGGINGS.get());
				tabData.accept(ZeldaCraftModItems.PURPLE_TIME_ARMOR_BUNDLE.get());
				tabData.accept(ZeldaCraftModItems.PURPLE_TIME_ARMOR_HELMET.get());
				tabData.accept(ZeldaCraftModItems.PURPLE_TIME_ARMOR_CHESTPLATE.get());
				tabData.accept(ZeldaCraftModItems.PURPLE_TIME_ARMOR_LEGGINGS.get());
				tabData.accept(ZeldaCraftModItems.DARK_TIME_ARMOR_BUNDLE.get());
				tabData.accept(ZeldaCraftModItems.DARK_TIME_ARMOR_HELMET.get());
				tabData.accept(ZeldaCraftModItems.DARK_TIME_ARMOR_CHESTPLATE.get());
				tabData.accept(ZeldaCraftModItems.DARK_TIME_ARMOR_LEGGINGS.get());
				tabData.accept(ZeldaCraftModItems.DARK_TIME_ARMOR_BOOTS.get());
				tabData.accept(ZeldaCraftModItems.WIND_ARMOR_BUNDLE.get());
				tabData.accept(ZeldaCraftModItems.WIND_ARMOR_HELMET.get());
				tabData.accept(ZeldaCraftModItems.WIND_ARMOR_CHESTPLATE.get());
				tabData.accept(ZeldaCraftModItems.WIND_ARMOR_LEGGINGS.get());
				tabData.accept(ZeldaCraftModItems.WIND_ARMOR_BOOTS.get());
				tabData.accept(ZeldaCraftModItems.SALVAGER_ARMOR_BUNDLE.get());
				tabData.accept(ZeldaCraftModItems.SALVAGER_ARMOR_HELMET.get());
				tabData.accept(ZeldaCraftModItems.SALVAGER_ARMOR_CHESTPLATE.get());
				tabData.accept(ZeldaCraftModItems.SALVAGER_ARMOR_LEGGINGS.get());
				tabData.accept(ZeldaCraftModItems.SALVAGER_ARMOR_BOOTS.get());
				tabData.accept(ZeldaCraftModItems.BLAST_MASK_CONTRACT.get());
				tabData.accept(ZeldaCraftModItems.BUNNY_HOOD_CONTRACT.get());
				tabData.accept(ZeldaCraftModItems.BLAST_MASK.get());
				tabData.accept(ZeldaCraftModItems.BUNNY_HOOD.get());
				tabData.accept(ZeldaCraftModItems.DEKU_MASK.get());
				tabData.accept(ZeldaCraftModItems.ALL_NIGHT_MASK.get());
				tabData.accept(ZeldaCraftModItems.GARO_MASK_HELMET.get());
				tabData.accept(ZeldaCraftModItems.CHILD_WALLET.get());
				tabData.accept(ZeldaCraftModItems.GREEN_RUPEE.get());
				tabData.accept(ZeldaCraftModItems.BLUE_RUPEE.get());
				tabData.accept(ZeldaCraftModItems.RED_RUPEE.get());
				tabData.accept(ZeldaCraftModItems.PURPLE_RUPEE.get());
				tabData.accept(ZeldaCraftModItems.SILVER_RUPEE.get());
				tabData.accept(ZeldaCraftModItems.GOLD_RUPEE.get());
				tabData.accept(ZeldaCraftModItems.SMALL_KEY.get());
				tabData.accept(ZeldaCraftModBlocks.OWL_STATUE.get().asItem());
				tabData.accept(ZeldaCraftModBlocks.SHEIKAH_LINK.get().asItem());
				tabData.accept(ZeldaCraftModBlocks.FLOOR_SWITCH.get().asItem());
				tabData.accept(ZeldaCraftModBlocks.WEIGHTED_FLOOR_SWITCH.get().asItem());
				tabData.accept(ZeldaCraftModBlocks.TIMED_FLOOR_SWITCH.get().asItem());
				tabData.accept(ZeldaCraftModBlocks.RUSTY_FLOOR_SWITCH.get().asItem());
				tabData.accept(ZeldaCraftModBlocks.LULLABY_SWITCH.get().asItem());
				tabData.accept(ZeldaCraftModBlocks.ILLUSION_BLOCK.get().asItem());
				tabData.accept(ZeldaCraftModBlocks.FALSE_ILLUSION_BLOCK.get().asItem());
				tabData.accept(ZeldaCraftModBlocks.HIDDEN_ILLUSION_BLOCK.get().asItem());
				tabData.accept(ZeldaCraftModBlocks.CLIMBABLE_HIDDEN_ILLUSION_BLOCK.get().asItem());
				tabData.accept(ZeldaCraftModBlocks.BOMBABLE_ILLUSION_BLOCK.get().asItem());
				tabData.accept(ZeldaCraftModBlocks.BOMBABLE_WALL.get().asItem());
				tabData.accept(ZeldaCraftModBlocks.HOOKSHOT_TARGET.get().asItem());
				tabData.accept(ZeldaCraftModBlocks.MOUNTAIN_ROK.get().asItem());
				tabData.accept(ZeldaCraftModBlocks.MOLTEN_ORE.get().asItem());
				tabData.accept(ZeldaCraftModItems.MOLTEN_SCRAP.get());
				tabData.accept(ZeldaCraftModItems.GORON_STEEL.get());
				tabData.accept(ZeldaCraftModItems.PURIFIED_GORON_STEEL.get());
				tabData.accept(ZeldaCraftModItems.MYSTIC_STEEL.get());
				tabData.accept(ZeldaCraftModBlocks.TIMESHIFT_ORE.get().asItem());
				tabData.accept(ZeldaCraftModItems.TIMESHIFT_SHARD.get());
				tabData.accept(ZeldaCraftModItems.HYRULE_CREST.get());
				tabData.accept(ZeldaCraftModItems.SPIRIT_OF_THE_LOKOMO.get());
				tabData.accept(ZeldaCraftModItems.CRIMSONINE.get());
				tabData.accept(ZeldaCraftModItems.AZURINE.get());
				tabData.accept(ZeldaCraftModItems.AQUANINE.get());
				tabData.accept(ZeldaCraftModItems.PURE_ALLOY.get());
				tabData.accept(ZeldaCraftModBlocks.PHANTOM_HOURGLASS.get().asItem());
				tabData.accept(ZeldaCraftModItems.SONG_OF_STORMS.get());
				tabData.accept(ZeldaCraftModItems.SARIAS_SONG.get());
				tabData.accept(ZeldaCraftModItems.GURUDO_VALLY.get());
				tabData.accept(ZeldaCraftModItems.BALLAD_OF_THE_GODDESS.get());
				tabData.accept(ZeldaCraftModItems.MIDNAS_LAMENT.get());
				tabData.accept(ZeldaCraftModItems.MAIN_THEME.get());
				tabData.accept(ZeldaCraftModItems.CLOCK_TOWN.get());
				tabData.accept(ZeldaCraftModItems.EMPTY_BOTTLE.get());
				tabData.accept(ZeldaCraftModItems.RED_POTION.get());
				tabData.accept(ZeldaCraftModItems.FAIRY_BOTTLE.get());
				tabData.accept(ZeldaCraftModItems.LON_LON_MILK.get());
				tabData.accept(ZeldaCraftModItems.CHATEAU_ROMANI.get());
				tabData.accept(ZeldaCraftModBlocks.HYLIAN_CHEST.get().asItem());
				tabData.accept(ZeldaCraftModBlocks.SMALL_DUNGEON_CHEST.get().asItem());
				tabData.accept(ZeldaCraftModBlocks.TREASURE_CHEST.get().asItem());
				tabData.accept(ZeldaCraftModBlocks.SWORD_STAND.get().asItem());
				tabData.accept(ZeldaCraftModBlocks.ANCHIENT_CAPSULE_MACHINE.get().asItem());
				tabData.accept(ZeldaCraftModItems.COSTUME_COIN.get());
				tabData.accept(ZeldaCraftModItems.COSTUME_COIN_PIECE.get());
				tabData.accept(ZeldaCraftModItems.HYLIAN_COIN.get());
				tabData.accept(ZeldaCraftModItems.GORON_COIN.get());
				tabData.accept(ZeldaCraftModItems.ZORA_COIN.get());
				tabData.accept(ZeldaCraftModItems.GERUDO_COIN.get());
			}).build());

	@SubscribeEvent
	public static void buildTabContentsVanilla(BuildCreativeModeTabContentsEvent tabData) {
		if (tabData.getTabKey() == CreativeModeTabs.SPAWN_EGGS) {
			tabData.accept(ZeldaCraftModItems.HAPPY_MASK_SALESMAN_SPAWN_EGG.get());
			tabData.accept(ZeldaCraftModItems.FAIRY_SPAWN_EGG.get());
		}
	}
}