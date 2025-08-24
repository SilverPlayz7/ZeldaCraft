package zeldacraft.procedures;

import zeldacraft.init.ZeldaCraftModBlocks;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

public class ZeldasLullabyProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		boolean found = false;
		double sx = 0;
		double sy = 0;
		double sz = 0;
		double fx = 0;
		double fy = 0;
		double fz = 0;
		if (!world.isClientSide()) {
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("zelda_craft:ocarina_song_correct")), SoundSource.RECORDS, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("zelda_craft:ocarina_song_correct")), SoundSource.RECORDS, 1, 1, false);
				}
			}
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("zelda_craft:zeldalullaby")), SoundSource.RECORDS, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("zelda_craft:zeldalullaby")), SoundSource.RECORDS, 1, 1, false);
				}
			}
			found = false;
			sx = -5;
			for (int index0 = 0; index0 < 10; index0++) {
				sy = -5;
				for (int index1 = 0; index1 < 10; index1++) {
					sz = -5;
					for (int index2 = 0; index2 < 10; index2++) {
						if ((world.getBlockState(BlockPos.containing(x + sx, y + sy, z + sz))).getBlock() == ZeldaCraftModBlocks.LULLABY_SWITCH.get()) {
							found = true;
							fx = x + sx;
							fy = y + sy;
							fz = z + sz;
						}
						sz = sz + 1;
					}
					sy = sy + 1;
				}
				sx = sx + 1;
			}
			if (found == true) {
				if ((new Object() {
					public boolean getValue(LevelAccessor world, BlockPos pos, String tag) {
						BlockEntity blockEntity = world.getBlockEntity(pos);
						if (blockEntity != null)
							return blockEntity.getPersistentData().getBoolean(tag);
						return false;
					}
				}.getValue(world, BlockPos.containing(fx, fy, fz), "triggered")) == false) {
					if (!world.isClientSide()) {
						BlockPos _bp = BlockPos.containing(fx, fy, fz);
						BlockEntity _blockEntity = world.getBlockEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_blockEntity != null)
							_blockEntity.getPersistentData().putBoolean("triggered", true);
						if (world instanceof Level _level)
							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
					}
				} else if ((new Object() {
					public boolean getValue(LevelAccessor world, BlockPos pos, String tag) {
						BlockEntity blockEntity = world.getBlockEntity(pos);
						if (blockEntity != null)
							return blockEntity.getPersistentData().getBoolean(tag);
						return false;
					}
				}.getValue(world, BlockPos.containing(fx, fy, fz), "triggered")) == true) {
					if (!world.isClientSide()) {
						BlockPos _bp = BlockPos.containing(fx, fy, fz);
						BlockEntity _blockEntity = world.getBlockEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_blockEntity != null)
							_blockEntity.getPersistentData().putBoolean("triggered", false);
						if (world instanceof Level _level)
							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
					}
				}
			}
		}
	}
}
