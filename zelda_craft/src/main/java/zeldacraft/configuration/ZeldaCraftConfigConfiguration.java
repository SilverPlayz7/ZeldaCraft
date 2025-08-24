package zeldacraft.configuration;

import net.minecraftforge.common.ForgeConfigSpec;

public class ZeldaCraftConfigConfiguration {
	public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
	public static final ForgeConfigSpec SPEC;

	public static final ForgeConfigSpec.ConfigValue<String> HOOKSHOT_RETICLE;
	static {
		BUILDER.push("Visual");
		HOOKSHOT_RETICLE = BUILDER.comment("The display type shown when you're looking at a block that can be hookshotted. Available types: OUTLINE, GLOW, OFF").define("Hookshot Reticle Type", "OUTLINE");
		BUILDER.pop();

		SPEC = BUILDER.build();
	}

}
