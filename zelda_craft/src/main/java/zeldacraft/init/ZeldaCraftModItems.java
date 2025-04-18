
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package zeldacraft.init;

import zeldacraft.procedures.LensOfTruthPropertyValueProviderProcedure;
import zeldacraft.procedures.HeroBowPropertyValueProviderProcedure;

import zeldacraft.item.ZoraCoinItem;
import zeldacraft.item.WindArmorItem;
import zeldacraft.item.WindArmorBundleItem;
import zeldacraft.item.WarpFluteItem;
import zeldacraft.item.UnPoweredMasterSwordItem;
import zeldacraft.item.TwilightArmorItem;
import zeldacraft.item.TwilightArmorBundleItem;
import zeldacraft.item.TriforceItem;
import zeldacraft.item.TimeshiftShardItem;
import zeldacraft.item.TimeArmorItem;
import zeldacraft.item.TimeArmorBundleItem;
import zeldacraft.item.SpriritFluteItem;
import zeldacraft.item.SongOfStormsItem;
import zeldacraft.item.SmallKeyItem;
import zeldacraft.item.SilverRupeeItem;
import zeldacraft.item.SariasSongItem;
import zeldacraft.item.SalvagerSetItem;
import zeldacraft.item.SalvagerArmorBundleItem;
import zeldacraft.item.RocFeatherItem;
import zeldacraft.item.RocCapeItem;
import zeldacraft.item.RedRupeeItem;
import zeldacraft.item.RazorSwordItem;
import zeldacraft.item.PurpleRupeeItem;
import zeldacraft.item.PurifiedGoronSteelItem;
import zeldacraft.item.PegasusBootsItem;
import zeldacraft.item.OccarinaOfTimeItem;
import zeldacraft.item.NewHyrleShieldBetterWayTestItem;
import zeldacraft.item.MysticSteelItem;
import zeldacraft.item.MoltenScrapItem;
import zeldacraft.item.MirrorShieldOotItem;
import zeldacraft.item.MidnasLamentItem;
import zeldacraft.item.MegatonHammerItem;
import zeldacraft.item.MasterSwordItem;
import zeldacraft.item.MasterSwordBeamRepresentitiveItem;
import zeldacraft.item.MasterSwordBeamProjectileItem;
import zeldacraft.item.MainThemeItem;
import zeldacraft.item.MagicMirrorItem;
import zeldacraft.item.LongShotItem;
import zeldacraft.item.LokomoSwordItem;
import zeldacraft.item.LensOfTruthItem;
import zeldacraft.item.KokiriSwordItem;
import zeldacraft.item.IronBootsItem;
import zeldacraft.item.HyruleCrestItem;
import zeldacraft.item.HylianShieldItem;
import zeldacraft.item.HylianCoinItem;
import zeldacraft.item.HoverBootsItem;
import zeldacraft.item.HookShotItem;
import zeldacraft.item.HeroBowItem;
import zeldacraft.item.GurudoVallyItem;
import zeldacraft.item.GreenRupieItem;
import zeldacraft.item.GoronSteelItem;
import zeldacraft.item.GoronCoinItem;
import zeldacraft.item.GoldRupeeItem;
import zeldacraft.item.GoddessSwordItem;
import zeldacraft.item.GiantKnifeItem;
import zeldacraft.item.GerudoCoinItem;
import zeldacraft.item.GaroMaskItem;
import zeldacraft.item.FlyingBoomerangItem;
import zeldacraft.item.FierceDeitySwordBeamRepresentativeItem;
import zeldacraft.item.FairyOcarinaItem;
import zeldacraft.item.FairyItemItem;
import zeldacraft.item.FairyBottleItem;
import zeldacraft.item.EmptyBottleItem;
import zeldacraft.item.DemonTribeSwordItem;
import zeldacraft.item.DekuMaskItem;
import zeldacraft.item.DarkTimeArmorItem;
import zeldacraft.item.DarkTimeArmorBundleItem;
import zeldacraft.item.CostumeCoinPieceItem;
import zeldacraft.item.CostumeCoinItem;
import zeldacraft.item.ClockTownItem;
import zeldacraft.item.ChildWalletItem;
import zeldacraft.item.ChainSpoolItem;
import zeldacraft.item.BunnyHoodItem;
import zeldacraft.item.BrokenGiantKnifeItem;
import zeldacraft.item.BoomerangItem;
import zeldacraft.item.BombItem;
import zeldacraft.item.BlueRupeeItem;
import zeldacraft.item.BlastMaskContractItem;
import zeldacraft.item.BlastMaskBaubleItem;
import zeldacraft.item.BiggoronSwordItem;
import zeldacraft.item.BalladOfTheGoddessItem;
import zeldacraft.item.AllNightMaskItem;

import zeldacraft.block.display.TreasureChestDisplayItem;
import zeldacraft.block.display.SmallDungeonChestDisplayItem;
import zeldacraft.block.display.AnchientCapsuleMachineDisplayItem;

import zeldacraft.ZeldaCraftMod;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.item.ItemProperties;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ZeldaCraftModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, ZeldaCraftMod.MODID);
	public static final RegistryObject<Item> MASTER_SWORD = REGISTRY.register("master_sword", () -> new MasterSwordItem());
	public static final RegistryObject<Item> GREEN_RUPIE = REGISTRY.register("green_rupie", () -> new GreenRupieItem());
	public static final RegistryObject<Item> BLUE_RUPEE = REGISTRY.register("blue_rupee", () -> new BlueRupeeItem());
	public static final RegistryObject<Item> RED_RUPEE = REGISTRY.register("red_rupee", () -> new RedRupeeItem());
	public static final RegistryObject<Item> PURPLE_RUPEE = REGISTRY.register("purple_rupee", () -> new PurpleRupeeItem());
	public static final RegistryObject<Item> SILVER_RUPEE = REGISTRY.register("silver_rupee", () -> new SilverRupeeItem());
	public static final RegistryObject<Item> GOLD_RUPEE = REGISTRY.register("gold_rupee", () -> new GoldRupeeItem());
	public static final RegistryObject<Item> PEGASUS_BOOTS_BOOTS = REGISTRY.register("pegasus_boots_boots", () -> new PegasusBootsItem.Boots());
	public static final RegistryObject<Item> TRIFORCE = REGISTRY.register("triforce", () -> new TriforceItem());
	public static final RegistryObject<Item> BIGGORON_SWORD = REGISTRY.register("biggoron_sword", () -> new BiggoronSwordItem());
	public static final RegistryObject<Item> GORON_STEEL = REGISTRY.register("goron_steel", () -> new GoronSteelItem());
	public static final RegistryObject<Item> MOLTEN_ORE = block(ZeldaCraftModBlocks.MOLTEN_ORE);
	public static final RegistryObject<Item> MOUNTAIN_ROK = block(ZeldaCraftModBlocks.MOUNTAIN_ROK);
	public static final RegistryObject<Item> UN_POWERED_MASTER_SWORD = REGISTRY.register("un_powered_master_sword", () -> new UnPoweredMasterSwordItem());
	public static final RegistryObject<Item> KOKIRI_SWORD = REGISTRY.register("kokiri_sword", () -> new KokiriSwordItem());
	public static final RegistryObject<Item> SMALL_KEY = REGISTRY.register("small_key", () -> new SmallKeyItem());
	public static final RegistryObject<Item> GODDESS_SWORD = REGISTRY.register("goddess_sword", () -> new GoddessSwordItem());
	public static final RegistryObject<Item> OPEN_CHEST = block(ZeldaCraftModBlocks.OPEN_CHEST);
	public static final RegistryObject<Item> HYLIAN_CHEST = block(ZeldaCraftModBlocks.HYLIAN_CHEST);
	public static final RegistryObject<Item> SWORD_STAND = block(ZeldaCraftModBlocks.SWORD_STAND);
	public static final RegistryObject<Item> MASTER_SWORD_STAND = block(ZeldaCraftModBlocks.MASTER_SWORD_STAND);
	public static final RegistryObject<Item> CHAIN_SPOOL = REGISTRY.register("chain_spool", () -> new ChainSpoolItem());
	public static final RegistryObject<Item> OCCARINA_OF_TIME = REGISTRY.register("occarina_of_time", () -> new OccarinaOfTimeItem());
	public static final RegistryObject<Item> EMPTY_BOTTLE = REGISTRY.register("empty_bottle", () -> new EmptyBottleItem());
	public static final RegistryObject<Item> FAIRY_BOTTLE = REGISTRY.register("fairy_bottle", () -> new FairyBottleItem());
	public static final RegistryObject<Item> FAIRY_ITEM = REGISTRY.register("fairy_item", () -> new FairyItemItem());
	public static final RegistryObject<Item> LOKOMO_SWORD = REGISTRY.register("lokomo_sword", () -> new LokomoSwordItem());
	public static final RegistryObject<Item> IRON_BOOTS_BOOTS = REGISTRY.register("iron_boots_boots", () -> new IronBootsItem.Boots());
	public static final RegistryObject<Item> HOVER_BOOTS_BOOTS = REGISTRY.register("hover_boots_boots", () -> new HoverBootsItem.Boots());
	public static final RegistryObject<Item> RAZOR_SWORD = REGISTRY.register("razor_sword", () -> new RazorSwordItem());
	public static final RegistryObject<Item> MEGATON_HAMMER = REGISTRY.register("megaton_hammer", () -> new MegatonHammerItem());
	public static final RegistryObject<Item> MOLTEN_SCRAP = REGISTRY.register("molten_scrap", () -> new MoltenScrapItem());
	public static final RegistryObject<Item> SPIRIT_FLUTE = REGISTRY.register("spirit_flute", () -> new SpriritFluteItem());
	public static final RegistryObject<Item> HYRULE_CREST = REGISTRY.register("hyrule_crest", () -> new HyruleCrestItem());
	public static final RegistryObject<Item> LOKOMO_SWORD_STAND = block(ZeldaCraftModBlocks.LOKOMO_SWORD_STAND);
	public static final RegistryObject<Item> MASTER_SWORD_BEAM_REPRESENTITIVE = REGISTRY.register("master_sword_beam_representitive", () -> new MasterSwordBeamRepresentitiveItem());
	public static final RegistryObject<Item> NEW_HYRULE_SHIELD = REGISTRY.register("new_hyrule_shield", () -> new NewHyrleShieldBetterWayTestItem());
	public static final RegistryObject<Item> BOOMERANG = REGISTRY.register("boomerang", () -> new BoomerangItem());
	public static final RegistryObject<Item> BOMB = REGISTRY.register("bomb", () -> new BombItem());
	public static final RegistryObject<Item> HOOK_SHOT = REGISTRY.register("hook_shot", () -> new HookShotItem());
	public static final RegistryObject<Item> LONG_SHOT = REGISTRY.register("long_shot", () -> new LongShotItem());
	public static final RegistryObject<Item> MASTER_SWORD_BEAM_PROJECTILE = REGISTRY.register("master_sword_beam_projectile", () -> new MasterSwordBeamProjectileItem());
	public static final RegistryObject<Item> DEMON_TRIBE_SWORD = REGISTRY.register("demon_tribe_sword", () -> new DemonTribeSwordItem());
	public static final RegistryObject<Item> LOCKED_HYLIAN_CHEST = block(ZeldaCraftModBlocks.LOCKED_HYLIAN_CHEST);
	public static final RegistryObject<Item> TIMESHIFT_ORE = block(ZeldaCraftModBlocks.TIMESHIFT_ORE);
	public static final RegistryObject<Item> TIMESHIFT_SHARD = REGISTRY.register("timeshift_shard", () -> new TimeshiftShardItem());
	public static final RegistryObject<Item> WARP_FLUTE = REGISTRY.register("warp_flute", () -> new WarpFluteItem());
	public static final RegistryObject<Item> PURIFIED_GORON_STEEL = REGISTRY.register("purified_goron_steel", () -> new PurifiedGoronSteelItem());
	public static final RegistryObject<Item> MYSTIC_STEEL = REGISTRY.register("mystic_steel", () -> new MysticSteelItem());
	public static final RegistryObject<Item> GIANT_KNIFE = REGISTRY.register("giant_knife", () -> new GiantKnifeItem());
	public static final RegistryObject<Item> BROKEN_GIANT_KNIFE = REGISTRY.register("broken_giant_knife", () -> new BrokenGiantKnifeItem());
	public static final RegistryObject<Item> COSTUME_COIN = REGISTRY.register("costume_coin", () -> new CostumeCoinItem());
	public static final RegistryObject<TwilightArmorItem> TWILIGHT_ARMOR_HELMET = REGISTRY.register("twilight_armor_helmet", () -> new TwilightArmorItem(ArmorItem.Type.HELMET, new Item.Properties().fireResistant()));
	public static final RegistryObject<TwilightArmorItem> TWILIGHT_ARMOR_CHESTPLATE = REGISTRY.register("twilight_armor_chestplate", () -> new TwilightArmorItem(ArmorItem.Type.CHESTPLATE, new Item.Properties()));
	public static final RegistryObject<TwilightArmorItem> TWILIGHT_ARMOR_LEGGINGS = REGISTRY.register("twilight_armor_leggings", () -> new TwilightArmorItem(ArmorItem.Type.LEGGINGS, new Item.Properties()));
	public static final RegistryObject<TwilightArmorItem> TWILIGHT_ARMOR_BOOTS = REGISTRY.register("twilight_armor_boots", () -> new TwilightArmorItem(ArmorItem.Type.BOOTS, new Item.Properties()));
	public static final RegistryObject<Item> ANCHIENT_CAPSULE_MACHINE = REGISTRY.register(ZeldaCraftModBlocks.ANCHIENT_CAPSULE_MACHINE.getId().getPath(),
			() -> new AnchientCapsuleMachineDisplayItem(ZeldaCraftModBlocks.ANCHIENT_CAPSULE_MACHINE.get(), new Item.Properties()));
	public static final RegistryObject<Item> FIERCE_DEITY_SWORD_BEAM_REPRESENTATIVE = REGISTRY.register("fierce_deity_sword_beam_representative", () -> new FierceDeitySwordBeamRepresentativeItem());
	public static final RegistryObject<TimeArmorItem> TIME_ARMOR_HELMET = REGISTRY.register("time_armor_helmet", () -> new TimeArmorItem(ArmorItem.Type.HELMET, new Item.Properties()));
	public static final RegistryObject<TimeArmorItem> TIME_ARMOR_CHESTPLATE = REGISTRY.register("time_armor_chestplate", () -> new TimeArmorItem(ArmorItem.Type.CHESTPLATE, new Item.Properties()));
	public static final RegistryObject<TimeArmorItem> TIME_ARMOR_LEGGINGS = REGISTRY.register("time_armor_leggings", () -> new TimeArmorItem(ArmorItem.Type.LEGGINGS, new Item.Properties()));
	public static final RegistryObject<TimeArmorItem> TIME_ARMOR_BOOTS = REGISTRY.register("time_armor_boots", () -> new TimeArmorItem(ArmorItem.Type.BOOTS, new Item.Properties()));
	public static final RegistryObject<Item> FLYING_BOOMERANG = REGISTRY.register("flying_boomerang", () -> new FlyingBoomerangItem());
	public static final RegistryObject<Item> FAIRY_OCARINA = REGISTRY.register("fairy_ocarina", () -> new FairyOcarinaItem());
	public static final RegistryObject<Item> COSTUME_COIN_PIECE = REGISTRY.register("costume_coin_piece", () -> new CostumeCoinPieceItem());
	public static final RegistryObject<Item> TWILIGHT_ARMOR_BUNDLE = REGISTRY.register("twilight_armor_bundle", () -> new TwilightArmorBundleItem());
	public static final RegistryObject<Item> TIME_ARMOR_BUNDLE = REGISTRY.register("time_armor_bundle", () -> new TimeArmorBundleItem());
	public static final RegistryObject<DarkTimeArmorItem> DARK_TIME_ARMOR_HELMET = REGISTRY.register("dark_time_armor_helmet", () -> new DarkTimeArmorItem(ArmorItem.Type.HELMET, new Item.Properties()));
	public static final RegistryObject<DarkTimeArmorItem> DARK_TIME_ARMOR_CHESTPLATE = REGISTRY.register("dark_time_armor_chestplate", () -> new DarkTimeArmorItem(ArmorItem.Type.CHESTPLATE, new Item.Properties()));
	public static final RegistryObject<DarkTimeArmorItem> DARK_TIME_ARMOR_LEGGINGS = REGISTRY.register("dark_time_armor_leggings", () -> new DarkTimeArmorItem(ArmorItem.Type.LEGGINGS, new Item.Properties()));
	public static final RegistryObject<DarkTimeArmorItem> DARK_TIME_ARMOR_BOOTS = REGISTRY.register("dark_time_armor_boots", () -> new DarkTimeArmorItem(ArmorItem.Type.BOOTS, new Item.Properties()));
	public static final RegistryObject<Item> LENS_OF_TRUTH = REGISTRY.register("lens_of_truth", () -> new LensOfTruthItem());
	public static final RegistryObject<Item> TREASURE_CHEST = REGISTRY.register(ZeldaCraftModBlocks.TREASURE_CHEST.getId().getPath(), () -> new TreasureChestDisplayItem(ZeldaCraftModBlocks.TREASURE_CHEST.get(), new Item.Properties()));
	public static final RegistryObject<Item> BLAST_MASK = REGISTRY.register("blast_mask", () -> new BlastMaskBaubleItem());
	public static final RegistryObject<Item> HYLIAN_SHIELD = REGISTRY.register("hylian_shield", () -> new HylianShieldItem());
	public static final RegistryObject<Item> GARO_MASK = REGISTRY.register("garo_mask", () -> new GaroMaskItem());
	public static final RegistryObject<Item> ALL_NIGHT_MASK = REGISTRY.register("all_night_mask", () -> new AllNightMaskItem());
	public static final RegistryObject<Item> DARK_TIME_ARMOR_BUNDLE = REGISTRY.register("dark_time_armor_bundle", () -> new DarkTimeArmorBundleItem());
	public static final RegistryObject<Item> HAPPY_MASK_SALESMAN_SPAWN_EGG = REGISTRY.register("happy_mask_salesman_spawn_egg", () -> new ForgeSpawnEggItem(ZeldaCraftModEntities.HAPPY_MASK_SALESMAN, -13434778, -6750055, new Item.Properties()));
	public static final RegistryObject<Item> HERO_BOW = REGISTRY.register("hero_bow", () -> new HeroBowItem());
	public static final RegistryObject<Item> BOMBABLE_WALL = block(ZeldaCraftModBlocks.BOMBABLE_WALL);
	public static final RegistryObject<Item> DUNGEON_1_PORTAL = block(ZeldaCraftModBlocks.DUNGEON_1_PORTAL);
	public static final RegistryObject<Item> HYLIAN_COIN = REGISTRY.register("hylian_coin", () -> new HylianCoinItem());
	public static final RegistryObject<Item> GORON_COIN = REGISTRY.register("goron_coin", () -> new GoronCoinItem());
	public static final RegistryObject<Item> ZORA_COIN = REGISTRY.register("zora_coin", () -> new ZoraCoinItem());
	public static final RegistryObject<Item> GERUDO_COIN = REGISTRY.register("gerudo_coin", () -> new GerudoCoinItem());
	public static final RegistryObject<Item> ROC_FEATHER = REGISTRY.register("roc_feather", () -> new RocFeatherItem());
	public static final RegistryObject<Item> MAGIC_MIRROR = REGISTRY.register("magic_mirror", () -> new MagicMirrorItem());
	public static final RegistryObject<Item> HOOKSHOT_TARGET = block(ZeldaCraftModBlocks.HOOKSHOT_TARGET);
	public static final RegistryObject<Item> ROC_CAPE = REGISTRY.register("roc_cape", () -> new RocCapeItem());
	public static final RegistryObject<Item> DEKU_MASK = REGISTRY.register("deku_mask", () -> new DekuMaskItem());
	public static final RegistryObject<SalvagerSetItem> SALVAGER_ARMOR_HELMET = REGISTRY.register("salvager_armor_helmet", () -> new SalvagerSetItem(ArmorItem.Type.HELMET, new Item.Properties()));
	public static final RegistryObject<SalvagerSetItem> SALVAGER_ARMOR_CHESTPLATE = REGISTRY.register("salvager_armor_chestplate", () -> new SalvagerSetItem(ArmorItem.Type.CHESTPLATE, new Item.Properties()));
	public static final RegistryObject<SalvagerSetItem> SALVAGER_ARMOR_LEGGINGS = REGISTRY.register("salvager_armor_leggings", () -> new SalvagerSetItem(ArmorItem.Type.LEGGINGS, new Item.Properties()));
	public static final RegistryObject<SalvagerSetItem> SALVAGER_ARMOR_BOOTS = REGISTRY.register("salvager_armor_boots", () -> new SalvagerSetItem(ArmorItem.Type.BOOTS, new Item.Properties()));
	public static final RegistryObject<Item> SALVAGER_ARMOR_BUNDLE = REGISTRY.register("salvager_armor_bundle", () -> new SalvagerArmorBundleItem());
	public static final RegistryObject<WindArmorItem> WIND_ARMOR_HELMET = REGISTRY.register("wind_armor_helmet", () -> new WindArmorItem(ArmorItem.Type.HELMET, new Item.Properties()));
	public static final RegistryObject<WindArmorItem> WIND_ARMOR_CHESTPLATE = REGISTRY.register("wind_armor_chestplate", () -> new WindArmorItem(ArmorItem.Type.CHESTPLATE, new Item.Properties()));
	public static final RegistryObject<WindArmorItem> WIND_ARMOR_LEGGINGS = REGISTRY.register("wind_armor_leggings", () -> new WindArmorItem(ArmorItem.Type.LEGGINGS, new Item.Properties()));
	public static final RegistryObject<WindArmorItem> WIND_ARMOR_BOOTS = REGISTRY.register("wind_armor_boots", () -> new WindArmorItem(ArmorItem.Type.BOOTS, new Item.Properties()));
	public static final RegistryObject<Item> WIND_ARMOR_BUNDLE = REGISTRY.register("wind_armor_bundle", () -> new WindArmorBundleItem());
	public static final RegistryObject<Item> MIRROR_SHIELD_OOT = REGISTRY.register("mirror_shield_oot", () -> new MirrorShieldOotItem());
	public static final RegistryObject<Item> FAIRY_SPAWN_EGG = REGISTRY.register("fairy_spawn_egg", () -> new ForgeSpawnEggItem(ZeldaCraftModEntities.FAIRY, -26113, -39169, new Item.Properties()));
	public static final RegistryObject<Item> BLAST_MASK_CONTRACT = REGISTRY.register("blast_mask_contract", () -> new BlastMaskContractItem());
	public static final RegistryObject<Item> BUNNY_HOOD = REGISTRY.register("bunny_hood", () -> new BunnyHoodItem());
	public static final RegistryObject<Item> CHILD_WALLET = REGISTRY.register("child_wallet", () -> new ChildWalletItem());
	public static final RegistryObject<Item> SMALL_DUNGEON_CHEST = REGISTRY.register(ZeldaCraftModBlocks.SMALL_DUNGEON_CHEST.getId().getPath(),
			() -> new SmallDungeonChestDisplayItem(ZeldaCraftModBlocks.SMALL_DUNGEON_CHEST.get(), new Item.Properties()));
	public static final RegistryObject<Item> SONG_OF_STORMS = REGISTRY.register("song_of_storms", () -> new SongOfStormsItem());
	public static final RegistryObject<Item> SARIAS_SONG = REGISTRY.register("sarias_song", () -> new SariasSongItem());
	public static final RegistryObject<Item> GURUDO_VALLY = REGISTRY.register("gurudo_vally", () -> new GurudoVallyItem());
	public static final RegistryObject<Item> BALLAD_OF_THE_GODDESS = REGISTRY.register("ballad_of_the_goddess", () -> new BalladOfTheGoddessItem());
	public static final RegistryObject<Item> MIDNAS_LAMENT = REGISTRY.register("midnas_lament", () -> new MidnasLamentItem());
	public static final RegistryObject<Item> MAIN_THEME = REGISTRY.register("main_theme", () -> new MainThemeItem());
	public static final RegistryObject<Item> CLOCK_TOWN = REGISTRY.register("clock_town", () -> new ClockTownItem());

	// Start of user code block custom items
	// End of user code block custom items
	private static RegistryObject<Item> block(RegistryObject<Block> block) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties()));
	}

	@SubscribeEvent
	public static void clientLoad(FMLClientSetupEvent event) {
		event.enqueueWork(() -> {
			ItemProperties.register(LENS_OF_TRUTH.get(), new ResourceLocation("zelda_craft:lens_of_truth_using_lens"), (itemStackToRender, clientWorld, entity, itemEntityId) -> (float) LensOfTruthPropertyValueProviderProcedure.execute(entity));
			ItemProperties.register(HERO_BOW.get(), new ResourceLocation("zelda_craft:hero_bow_pulling"), (itemStackToRender, clientWorld, entity, itemEntityId) -> (float) HeroBowPropertyValueProviderProcedure.execute(entity));
		});
	}
}
