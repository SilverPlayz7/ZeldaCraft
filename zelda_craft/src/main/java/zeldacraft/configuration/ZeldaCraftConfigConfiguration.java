package zeldacraft.configuration;

import net.minecraftforge.common.ForgeConfigSpec;

public class ZeldaCraftConfigConfiguration {
	public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
	public static final ForgeConfigSpec SPEC;

	public static final ForgeConfigSpec.ConfigValue<String> HOOKSHOT_RETICLE;
	public static final ForgeConfigSpec.ConfigValue<Boolean> PARTICLE_TRAIL;
	public static final ForgeConfigSpec.ConfigValue<Boolean> ONLY_TARGETS;
	static {
		BUILDER.push("Visual");
		HOOKSHOT_RETICLE = BUILDER.comment("The display type shown when you're looking at a block that can be hookshotted. Available types: OUTLINE, GLOW, OFF").define("Hookshot Reticle Type", "OUTLINE");
		PARTICLE_TRAIL = BUILDER.comment("Changes whether this mod's arrows will spawn trail particles").define("Show Arrow Particle Trail", true);
		BUILDER.pop();
		BUILDER.push("Hookshot");
		ONLY_TARGETS = BUILDER.comment("If enabled, the hookshot/longshot will only be able to attach to the 'hookshot target' block").define("Only Hit Targets", false);
		BUILDER.pop();

		SPEC = BUILDER.build();
	}

}