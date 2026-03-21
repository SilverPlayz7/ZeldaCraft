package zeldacraft.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

public class DungeonDoorOnBlockRightClickedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, BlockState blockstate) {
		if (!world.isClientSide()) {
			DoorActivatorProcedure.execute(world, x, y, z, blockstate);
			if ((blockstate.getBlock().getStateDefinition().getProperty("open") instanceof BooleanProperty _getbp3 && blockstate.getValue(_getbp3)) == false) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(ResourceLocation.parse("block.iron_door.open")), SoundSource.BLOCKS, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(ResourceLocation.parse("block.iron_door.open")), SoundSource.BLOCKS, 1, 1, false);
					}
				}
			} else {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(ResourceLocation.parse("block.iron_door.close")), SoundSource.BLOCKS, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(ResourceLocation.parse("block.iron_door.close")), SoundSource.BLOCKS, 1, 1, false);
					}
				}
			}
		}
	}
}