/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package zeldacraft.init;

import zeldacraft.network.OpenWalletMessage;
import zeldacraft.network.MaskAbilityMessage;
import zeldacraft.network.DoubleJumpKeyMessage;

import zeldacraft.ZeldaCraftMod;

import org.lwjgl.glfw.GLFW;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.Minecraft;
import net.minecraft.client.KeyMapping;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
public class ZeldaCraftModKeyMappings {
	public static final KeyMapping MASK_ABILITY = new KeyMapping("key.zelda_craft.mask_ability", GLFW.GLFW_KEY_M, "key.categories.zeldacraft") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				ZeldaCraftMod.PACKET_HANDLER.sendToServer(new MaskAbilityMessage(0, 0));
				MaskAbilityMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping DOUBLE_JUMP_KEY = new KeyMapping("key.zelda_craft.double_jump_key", GLFW.GLFW_KEY_SPACE, "key.categories.zeldacraft") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				ZeldaCraftMod.PACKET_HANDLER.sendToServer(new DoubleJumpKeyMessage(0, 0));
				DoubleJumpKeyMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping OPEN_WALLET = new KeyMapping("key.zelda_craft.open_wallet", GLFW.GLFW_KEY_PERIOD, "key.categories.zeldacraft") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				ZeldaCraftMod.PACKET_HANDLER.sendToServer(new OpenWalletMessage(0, 0));
				OpenWalletMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};

	@SubscribeEvent
	public static void registerKeyMappings(RegisterKeyMappingsEvent event) {
		event.register(MASK_ABILITY);
		event.register(DOUBLE_JUMP_KEY);
		event.register(OPEN_WALLET);
	}

	@Mod.EventBusSubscriber({Dist.CLIENT})
	public static class KeyEventListener {
		@SubscribeEvent
		public static void onClientTick(TickEvent.ClientTickEvent event) {
			if (Minecraft.getInstance().screen == null) {
				MASK_ABILITY.consumeClick();
				DOUBLE_JUMP_KEY.consumeClick();
				OPEN_WALLET.consumeClick();
			}
		}
	}
}