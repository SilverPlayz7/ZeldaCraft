/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package zeldacraft.init;

import zeldacraft.potion.StunnedMobEffect;
import zeldacraft.potion.FrozenMobEffect;

import zeldacraft.ZeldaCraftMod;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.effect.MobEffect;

public class ZeldaCraftModMobEffects {
	public static final DeferredRegister<MobEffect> REGISTRY = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, ZeldaCraftMod.MODID);
	public static final RegistryObject<MobEffect> STUNNED = REGISTRY.register("stunned", () -> new StunnedMobEffect());
	public static final RegistryObject<MobEffect> FROZEN = REGISTRY.register("frozen", () -> new FrozenMobEffect());
}