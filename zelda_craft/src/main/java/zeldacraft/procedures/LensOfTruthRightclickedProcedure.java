package zeldacraft.procedures;

import zeldacraft.init.ZeldaCraftModItems;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

public class LensOfTruthRightclickedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if ((entity instanceof LivingEntity _entUseItem0 ? _entUseItem0.getUseItem() : ItemStack.EMPTY).getItem() == ZeldaCraftModItems.LENS_OF_TRUTH.get()) {
			if (entity.getPersistentData().getDouble("UsingLens") == 0) {
				entity.getPersistentData().putDouble("UsingLens", 0.75);
			}
			if (entity.getPersistentData().getDouble("UsingLens") == 0.75) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("zelda_craft:lense_of_truth_on")), SoundSource.PLAYERS, (float) 0.8, 1);
					} else {
						_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("zelda_craft:lense_of_truth_on")), SoundSource.PLAYERS, (float) 0.8, 1, false);
					}
				}
				entity.getPersistentData().putDouble("UsingLens", 1);
			}
		} else {
			entity.getPersistentData().putDouble("UsingLens", 0);
		}
	}
}
