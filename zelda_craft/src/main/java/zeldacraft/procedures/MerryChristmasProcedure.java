package zeldacraft.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.player.PlayerEvent;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import javax.annotation.Nullable;

import java.util.Calendar;

@Mod.EventBusSubscriber
public class MerryChristmasProcedure {
	@SubscribeEvent
	public static void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
		execute(event, event.getEntity());
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

	private static void execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return;
		if ((new java.text.SimpleDateFormat("MM-dd").format(Calendar.getInstance().getTime())).equals("12-25")) {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal((("\u00A7c-\u00A7a-\u00A7c-\u00A7a-\u00A7c-\u00A7a-\u00A7c-\u00A7a-\u00A7c-\u00A7a-\u00A7c-\u00A7a-"
						+ "\u00A7c-\u00A7a-\u00A7c-\u00A7a-\u00A7c-\u00A7a-\u00A7c-\u00A7a-\u00A7c-\u00A7a-\u00A7c-\u00A7a-" + "\u00A7c-\u00A7a-\u00A7c-\u00A7a-\u00A7c-\u00A7a-\u00A7c-\u00A7a-\u00A7c-\u00A7a-\u00A7c-\u00A7a-")
						+ "\n"
						+ ("\u00A7f" + entity.getDisplayName().getString() + "," + "\n" + "I hope you have a merry Christmas," + "\n" + "and happy New Year! Thank you for" + "\n" + "all the support over these past "
								+ new java.text.DecimalFormat("##.##").format(Calendar.getInstance().get(Calendar.YEAR) - 2021) + "\n" + "years, and hopefully more to come." + "\n" + "If you're new or returning, I hope you" + "\n"
								+ "you enjoy the mod.")
						+ "\n" + ("" + ("\u00A7c-\u00A7a-\u00A7c-\u00A7a-\u00A7c-\u00A7a-\u00A7c-\u00A7a-\u00A7c-\u00A7a-\u00A7c-\u00A7a-" + "\u00A7f[SilverPlayz7]"
								+ "\u00A7c-\u00A7a-\u00A7c-\u00A7a-\u00A7c-\u00A7a-\u00A7c-\u00A7a-\u00A7c-\u00A7a-\u00A7c-\u00A7a-")))),
						false);
		}
	}
}