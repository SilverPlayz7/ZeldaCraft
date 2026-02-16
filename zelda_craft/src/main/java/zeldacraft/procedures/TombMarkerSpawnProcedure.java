package zeldacraft.procedures;

import zeldacraft.init.ZeldaCraftModBlocks;

import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.BlockPos;

public class TombMarkerSpawnProcedure {
	public static void execute(LevelAccessor world, double x, double z, BlockState blockstate) {
		if (blockstate.getBlock() == ZeldaCraftModBlocks.ROYAL_SARCOPHAGUS.get()) {
			if (world instanceof ServerLevel _level)
				_level.registryAccess().registryOrThrow(Registries.CONFIGURED_FEATURE).getHolderOrThrow(FeatureUtils.createKey("zelda_craft:tomb_marker")).value().place(_level, _level.getChunkSource().getGenerator(), _level.getRandom(),
						BlockPos.containing(x, world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) x, (int) z), z));
		}
	}
}