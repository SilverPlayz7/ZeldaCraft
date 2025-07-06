package zeldacraft.client.gui;

import zeldacraft.world.inventory.WalletWithdrawMenu;

import zeldacraft.procedures.RupeeCounterProcedure;

import zeldacraft.network.WalletWithdrawButtonMessage;

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

public class WalletWithdrawScreen extends AbstractContainerScreen<WalletWithdrawMenu> {
	private final static HashMap<String, Object> guistate = WalletWithdrawMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	ImageButton imagebutton_withdraw1;
	ImageButton imagebutton_deposit2;
	ImageButton imagebutton_deposit20;
	ImageButton imagebutton_deposit50;
	ImageButton imagebutton_deposit100;
	ImageButton imagebutton_deposit300;
	ImageButton imagebutton_depositswitch;

	public WalletWithdrawScreen(WalletWithdrawMenu container, Inventory inventory, Component text) {
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

		guiGraphics.blit(new ResourceLocation("zelda_craft:textures/screens/rupeedepositmenu.png"), this.leftPos + 0, this.topPos + 0, 0, 0, 208, 166, 208, 166);

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
		guiGraphics.drawString(this.font, Component.translatable("gui.zelda_craft.wallet_withdraw.label_rupees"), 141, 7, -12829636, false);
		guiGraphics.drawString(this.font,

				RupeeCounterProcedure.execute(world, entity), 180, 7, -12829636, false);
	}

	@Override
	public void init() {
		super.init();
		imagebutton_withdraw1 = new ImageButton(this.leftPos + 4, this.topPos + 35, 34, 22, 0, 0, 22, new ResourceLocation("zelda_craft:textures/screens/atlas/imagebutton_withdraw1.png"), 34, 44, e -> {
			if (true) {
				ZeldaCraftMod.PACKET_HANDLER.sendToServer(new WalletWithdrawButtonMessage(0, x, y, z));
				WalletWithdrawButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		});
		guistate.put("button:imagebutton_withdraw1", imagebutton_withdraw1);
		this.addRenderableWidget(imagebutton_withdraw1);
		imagebutton_deposit2 = new ImageButton(this.leftPos + 37, this.topPos + 35, 34, 22, 0, 0, 22, new ResourceLocation("zelda_craft:textures/screens/atlas/imagebutton_deposit2.png"), 34, 44, e -> {
			if (true) {
				ZeldaCraftMod.PACKET_HANDLER.sendToServer(new WalletWithdrawButtonMessage(1, x, y, z));
				WalletWithdrawButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		});
		guistate.put("button:imagebutton_deposit2", imagebutton_deposit2);
		this.addRenderableWidget(imagebutton_deposit2);
		imagebutton_deposit20 = new ImageButton(this.leftPos + 70, this.topPos + 35, 34, 22, 0, 0, 22, new ResourceLocation("zelda_craft:textures/screens/atlas/imagebutton_deposit20.png"), 34, 44, e -> {
			if (true) {
				ZeldaCraftMod.PACKET_HANDLER.sendToServer(new WalletWithdrawButtonMessage(2, x, y, z));
				WalletWithdrawButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		});
		guistate.put("button:imagebutton_deposit20", imagebutton_deposit20);
		this.addRenderableWidget(imagebutton_deposit20);
		imagebutton_deposit50 = new ImageButton(this.leftPos + 104, this.topPos + 35, 34, 22, 0, 0, 22, new ResourceLocation("zelda_craft:textures/screens/atlas/imagebutton_deposit50.png"), 34, 44, e -> {
			if (true) {
				ZeldaCraftMod.PACKET_HANDLER.sendToServer(new WalletWithdrawButtonMessage(3, x, y, z));
				WalletWithdrawButtonMessage.handleButtonAction(entity, 3, x, y, z);
			}
		});
		guistate.put("button:imagebutton_deposit50", imagebutton_deposit50);
		this.addRenderableWidget(imagebutton_deposit50);
		imagebutton_deposit100 = new ImageButton(this.leftPos + 137, this.topPos + 35, 34, 22, 0, 0, 22, new ResourceLocation("zelda_craft:textures/screens/atlas/imagebutton_deposit100.png"), 34, 44, e -> {
		});
		guistate.put("button:imagebutton_deposit100", imagebutton_deposit100);
		this.addRenderableWidget(imagebutton_deposit100);
		imagebutton_deposit300 = new ImageButton(this.leftPos + 170, this.topPos + 35, 34, 22, 0, 0, 22, new ResourceLocation("zelda_craft:textures/screens/atlas/imagebutton_deposit300.png"), 34, 44, e -> {
			if (true) {
				ZeldaCraftMod.PACKET_HANDLER.sendToServer(new WalletWithdrawButtonMessage(5, x, y, z));
				WalletWithdrawButtonMessage.handleButtonAction(entity, 5, x, y, z);
			}
		});
		guistate.put("button:imagebutton_deposit300", imagebutton_deposit300);
		this.addRenderableWidget(imagebutton_deposit300);
		imagebutton_depositswitch = new ImageButton(this.leftPos + 127, this.topPos + 66, 78, 17, 0, 0, 17, new ResourceLocation("zelda_craft:textures/screens/atlas/imagebutton_depositswitch.png"), 78, 34, e -> {
			if (true) {
				ZeldaCraftMod.PACKET_HANDLER.sendToServer(new WalletWithdrawButtonMessage(6, x, y, z));
				WalletWithdrawButtonMessage.handleButtonAction(entity, 6, x, y, z);
			}
		});
		guistate.put("button:imagebutton_depositswitch", imagebutton_depositswitch);
		this.addRenderableWidget(imagebutton_depositswitch);
	}
}
