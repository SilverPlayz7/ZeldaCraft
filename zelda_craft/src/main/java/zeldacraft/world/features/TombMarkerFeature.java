package zeldacraft.world.features;

import zeldacraft.world.features.configurations.StructureFeatureConfiguration;

import zeldacraft.procedures.TombMarkerAdditionalGenerationConditionProcedure;

import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.WorldGenLevel;

public class TombMarkerFeature extends StructureFeature {
	public TombMarkerFeature() {
		super(StructureFeatureConfiguration.CODEC);
	}

	public boolean place(FeaturePlaceContext<StructureFeatureConfiguration> context) {
		WorldGenLevel world = context.level();
		int x = context.origin().getX();
		int y = context.origin().getY();
		int z = context.origin().getZ();
		if (!TombMarkerAdditionalGenerationConditionProcedure.execute(world, x, y, z))
			return false;
		return super.place(context);
	}
}