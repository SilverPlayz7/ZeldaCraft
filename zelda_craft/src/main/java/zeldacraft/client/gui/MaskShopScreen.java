package zeldacraft.client.gui;

import zeldacraft.world.inventory.MaskShopMenu;

import zeldacraft.procedures.RupeeCounterProcedure;
import zeldacraft.procedures.BunnyHoodSelectedProcedure;
import zeldacraft.procedures.BlastMaskSelectedProcedure;

import zeldacraft.network.MaskShopButtonMessage;

import zeldacraft.ZeldaCraftMod;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphics;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class MaskShopScreen extends AbstractContainerScreen<MaskShopMenu> {
	private final static HashMap<String, Object> guistate = MaskShopMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	Button button_bm;
	Button button_buy;
	Button button_bh;

	public MaskShopScreen(MaskShopMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 300;
		this.imageHeight = 220;
	}

	private static final ResourceLocation texture = new ResourceLocation("zelda_craft:textures/screens/mask_shop.png");

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
		guiGraphics.blit(texture, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);

		guiGraphics.blit(new ResourceLocation("zelda_craft:textures/screens/maskshop.png"), this.leftPos + 0, this.topPos + 0, 0, 0, 300, 220, 300, 220);

		if (BunnyHoodSelectedProcedure.execute(entity)) {
			guiGraphics.blit(new ResourceLocation("zelda_craft:textures/screens/withdraw1.png"), this.leftPos + 134, this.topPos + 45, 0, 0, 34, 22, 34, 22);
		}
		if (BlastMaskSelectedProcedure.execute(entity)) {
			guiGraphics.blit(new ResourceLocation("zelda_craft:textures/screens/deposit2.png"), this.leftPos + 134, this.topPos + 45, 0, 0, 34, 22, 34, 22);
		}
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
		guiGraphics.drawString(this.font,

				RupeeCounterProcedure.execute(entity), 69, 124, -12829636, false);
	}

	@Override
	public void init() {
		super.init();
		button_bm = Button.builder(Component.translatable("gui.zelda_craft.mask_shop.button_bm"), e -> {
			if (true) {
				ZeldaCraftMod.PACKET_HANDLER.sendToServer(new MaskShopButtonMessage(0, x, y, z));
				MaskShopButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 38, this.topPos + 41, 35, 20).build();
		guistate.put("button:button_bm", button_bm);
		this.addRenderableWidget(button_bm);
		button_buy = Button.builder(Component.translatable("gui.zelda_craft.mask_shop.button_buy"), e -> {
			if (true) {
				ZeldaCraftMod.PACKET_HANDLER.sendToServer(new MaskShopButtonMessage(1, x, y, z));
				MaskShopButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}).bounds(this.leftPos + 130, this.topPos + 101, 40, 20).build();
		guistate.put("button:button_buy", button_buy);
		this.addRenderableWidget(button_buy);
		button_bh = Button.builder(Component.translatable("gui.zelda_craft.mask_shop.button_bh"), e -> {
			if (true) {
				ZeldaCraftMod.PACKET_HANDLER.sendToServer(new MaskShopButtonMessage(2, x, y, z));
				MaskShopButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		}).bounds(this.leftPos + 2, this.topPos + 41, 35, 20).build();
		guistate.put("button:button_bh", button_bh);
		this.addRenderableWidget(button_bh);
	}
}
