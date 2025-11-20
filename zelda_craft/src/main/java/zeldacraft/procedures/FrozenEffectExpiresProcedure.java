package zeldacraft.procedures;

import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.Entity;

public class FrozenEffectExpiresProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if ((entity instanceof Mob _mobGetNoAi ? _mobGetNoAi.isNoAi() : false) == true) {
			if (entity instanceof Mob _mobSetNoAi) {
				_mobSetNoAi.setNoAi(false);
			}
		}
	}
}