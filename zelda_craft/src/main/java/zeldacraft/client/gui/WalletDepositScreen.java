package zeldacraft.client.gui;

import zeldacraft.world.inventory.WalletDepositMenu;

import zeldacraft.procedures.RupeeCounterProcedure;

import zeldacraft.network.WalletDepositButtonMessage;

import zeldacraft.ZeldaCraftMod;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.GuiGraphics;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class WalletDepositScreen extends AbstractContainerScreen<WalletDepositMenu> {
	private final static HashMap<String, Object> guistate = WalletDepositMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	ImageButton imagebutton_withdrawbutton;
	ImageButton imagebutton_depositbutton;

	public WalletDepositScreen(WalletDepositMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 208;
		this.imageHeight = 166;
	}

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();

		guiGraphics.blit(new ResourceLocation("zelda_craft:textures/screens/rupeewithdrawmenu.png"), this.leftPos + 0, this.topPos + 0, 0, 0, 208, 166, 208, 166);

		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}
		return super.keyPressed(key, b, c);
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
		guiGraphics.drawString(this.font, Component.translatable("gui.zelda_craft.wallet_deposit.label_ruppes"), 141, 7, -12829636, false);
		guiGraphics.drawString(this.font,

				RupeeCounterProcedure.execute(world, entity), 180, 7, -12829636, false);
	}

	@Override
	public void init() {
		super.init();
		imagebutton_withdrawbutton = new ImageButton(this.leftPos + 128, this.topPos + 61, 77, 22, 0, 0, 22, new ResourceLocation("zelda_craft:textures/screens/atlas/imagebutton_withdrawbutton.png"), 77, 44, e -> {
			if (true) {
				ZeldaCraftMod.PACKET_HANDLER.sendToServer(new WalletDepositButtonMessage(0, x, y, z));
				WalletDepositButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		});
		guistate.put("button:imagebutton_withdrawbutton", imagebutton_withdrawbutton);
		this.addRenderableWidget(imagebutton_withdrawbutton);
		imagebutton_depositbutton = new ImageButton(this.leftPos + 43, this.topPos + 23, 88, 27, 0, 0, 27, new ResourceLocation("zelda_craft:textures/screens/atlas/imagebutton_depositbutton.png"), 88, 54, e -> {
			if (true) {
				ZeldaCraftMod.PACKET_HANDLER.sendToServer(new WalletDepositButtonMessage(1, x, y, z));
				WalletDepositButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		});
		guistate.put("button:imagebutton_depositbutton", imagebutton_depositbutton);
		this.addRenderableWidget(imagebutton_depositbutton);
	}
}
