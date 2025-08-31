/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package zeldacraft.init;

import net.minecraftforge.fml.common.Mod;

import net.minecraft.world.level.GameRules;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class ZeldaCraftModGameRules {
	public static final GameRules.Key<GameRules.BooleanValue> BOMB_GREIFING = GameRules.register("bombGreifing", GameRules.Category.MISC, GameRules.BooleanValue.create(false));
}