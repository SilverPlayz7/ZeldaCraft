package zeldacraft.client.gui;

import zeldacraft.world.inventory.MaskShopMenu;

import zeldacraft.procedures.RupeeCounterProcedure;
import zeldacraft.procedures.MaskPriceProcedure;
import zeldacraft.procedures.MaskLine6Procedure;
import zeldacraft.procedures.MaskLine5Procedure;
import zeldacraft.procedures.MaskLine4Procedure;
import zeldacraft.procedures.MaskLine3Procedure;
import zeldacraft.procedures.MaskLine2Procedure;
import zeldacraft.procedures.MaskLine1Procedure;
import zeldacraft.procedures.ContractShowProcedure;
import zeldacraft.procedures.BuyButtonShowProcedure;

import zeldacraft.network.MaskShopButtonMessage;

import zeldacraft.init.ZeldaCraftModScreens;

import zeldacraft.ZeldaCraftMod;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.PlainTextButton;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphics;

import com.mojang.blaze3d.systems.RenderSystem;

public class MaskShopScreen extends AbstractContainerScreen<MaskShopMenu> implements ZeldaCraftModScreens.ScreenAccessor {
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private boolean menuStateUpdateActive = false;
	Button button_empty;
	Button button_empty1;
	ImageButton imagebutton_bunny_hood_icon;
	ImageButton imagebutton_blast_mask_icon;
	ImageButton imagebutton_buy_button;
	ImageButton imagebutton_contract_button;

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

	@Override
	public void updateMenuState(int elementType, String name, Object elementState) {
		menuStateUpdateActive = true;
		menuStateUpdateActive = false;
	}

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		boolean customTooltipShown = false;
		if (mouseX > leftPos + 7 && mouseX < leftPos + 31 && mouseY > topPos + 39 && mouseY < topPos + 63) {
			guiGraphics.renderTooltip(font, Component.translatable("gui.zelda_craft.mask_shop.tooltip_bunny_hood"), mouseX, mouseY);
			customTooltipShown = true;
		}
		if (mouseX > leftPos + 39 && mouseX < leftPos + 63 && mouseY > topPos + 42 && mouseY < topPos + 66) {
			guiGraphics.renderTooltip(font, Component.translatable("gui.zelda_craft.mask_shop.tooltip_blast_mask"), mouseX, mouseY);
			customTooltipShown = true;
		}
		if (mouseX > leftPos + 352 && mouseX < leftPos + 376 && mouseY > topPos + 222 && mouseY < topPos + 246) {
			guiGraphics.renderTooltip(font, Component.translatable("gui.zelda_craft.mask_shop.tooltip_reset"), mouseX, mouseY);
			customTooltipShown = true;
		}
		if (!customTooltipShown)
			this.renderTooltip(guiGraphics, mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int mouseX, int mouseY) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		guiGraphics.blit(ResourceLocation.parse("zelda_craft:textures/screens/maskshop.png"), this.leftPos + 0, this.topPos + 0, 0, 0, 300, 220, 300, 220);
		guiGraphics.blit(ResourceLocation.parse("zelda_craft:textures/screens/rupee_icon.png"), this.leftPos + 69, this.topPos + 126, 0, 0, 8, 8, 8, 8);
		guiGraphics.blit(ResourceLocation.parse("zelda_craft:textures/screens/contract_button_locked.png"), this.leftPos + 131, this.topPos + 120, 0, 0, 38, 12, 38, 12);
		guiGraphics.blit(ResourceLocation.parse("zelda_craft:textures/screens/buy_button_locked.png"), this.leftPos + 125, this.topPos + 103, 0, 0, 50, 18, 50, 18);
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
	protected void containerTick() {
		super.containerTick();
		this.button_empty.visible = BuyButtonShowProcedure.execute(entity);
		this.button_empty1.visible = ContractShowProcedure.execute(entity);
		this.imagebutton_buy_button.visible = BuyButtonShowProcedure.execute(entity);
		this.imagebutton_contract_button.visible = ContractShowProcedure.execute(entity);
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
		guiGraphics.drawString(this.font, RupeeCounterProcedure.execute(world, entity), 80, 126, -12829636, false);
		guiGraphics.drawString(this.font, MaskPriceProcedure.execute(entity), 145, 91, -12829636, false);
		guiGraphics.drawString(this.font, MaskLine1Procedure.execute(entity), 72, 21, -12829636, false);
		guiGraphics.drawString(this.font, MaskLine2Procedure.execute(entity), 72, 31, -12829636, false);
		guiGraphics.drawString(this.font, MaskLine3Procedure.execute(entity), 72, 41, -12829636, false);
		guiGraphics.drawString(this.font, MaskLine4Procedure.execute(entity), 72, 51, -12829636, false);
		guiGraphics.drawString(this.font, MaskLine5Procedure.execute(entity), 72, 61, -12829636, false);
		guiGraphics.drawString(this.font, MaskLine6Procedure.execute(entity), 72, 71, -12829636, false);
	}

	@Override
	public void init() {
		super.init();
		button_empty = new PlainTextButton(this.leftPos + 358, this.topPos + 225, 25, 20, Component.translatable("gui.zelda_craft.mask_shop.button_empty"), e -> {
			int x = MaskShopScreen.this.x;
			int y = MaskShopScreen.this.y;
			if (BuyButtonShowProcedure.execute(entity)) {
				ZeldaCraftMod.PACKET_HANDLER.sendToServer(new MaskShopButtonMessage(0, x, y, z));
				MaskShopButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}, this.font);
		this.addRenderableWidget(button_empty);
		button_empty1 = new PlainTextButton(this.leftPos + -64, this.topPos + 210, 25, 20, Component.translatable("gui.zelda_craft.mask_shop.button_empty1"), e -> {
		}, this.font);
		this.addRenderableWidget(button_empty1);
		imagebutton_bunny_hood_icon = new ImageButton(this.leftPos + 3, this.topPos + 19, 32, 48, 0, 0, 48, ResourceLocation.parse("zelda_craft:textures/screens/atlas/imagebutton_bunny_hood_icon.png"), 32, 96, e -> {
			int x = MaskShopScreen.this.x;
			int y = MaskShopScreen.this.y;
			if (true) {
				ZeldaCraftMod.PACKET_HANDLER.sendToServer(new MaskShopButtonMessage(2, x, y, z));
				MaskShopButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		});
		this.addRenderableWidget(imagebutton_bunny_hood_icon);
		imagebutton_blast_mask_icon = new ImageButton(this.leftPos + 40, this.topPos + 42, 25, 25, 0, 0, 25, ResourceLocation.parse("zelda_craft:textures/screens/atlas/imagebutton_blast_mask_icon.png"), 25, 50, e -> {
			int x = MaskShopScreen.this.x;
			int y = MaskShopScreen.this.y;
			if (true) {
				ZeldaCraftMod.PACKET_HANDLER.sendToServer(new MaskShopButtonMessage(3, x, y, z));
				MaskShopButtonMessage.handleButtonAction(entity, 3, x, y, z);
			}
		});
		this.addRenderableWidget(imagebutton_blast_mask_icon);
		imagebutton_buy_button = new ImageButton(this.leftPos + 125, this.topPos + 103, 50, 18, 0, 0, 18, ResourceLocation.parse("zelda_craft:textures/screens/atlas/imagebutton_buy_button.png"), 50, 36, e -> {
			int x = MaskShopScreen.this.x;
			int y = MaskShopScreen.this.y;
			if (BuyButtonShowProcedure.execute(entity)) {
				ZeldaCraftMod.PACKET_HANDLER.sendToServer(new MaskShopButtonMessage(4, x, y, z));
				MaskShopButtonMessage.handleButtonAction(entity, 4, x, y, z);
			}
		});
		this.addRenderableWidget(imagebutton_buy_button);
		imagebutton_contract_button = new ImageButton(this.leftPos + 131, this.topPos + 120, 38, 12, 0, 0, 12, ResourceLocation.parse("zelda_craft:textures/screens/atlas/imagebutton_contract_button.png"), 38, 24, e -> {
			int x = MaskShopScreen.this.x;
			int y = MaskShopScreen.this.y;
			if (ContractShowProcedure.execute(entity)) {
				ZeldaCraftMod.PACKET_HANDLER.sendToServer(new MaskShopButtonMessage(5, x, y, z));
				MaskShopButtonMessage.handleButtonAction(entity, 5, x, y, z);
			}
		});
		this.addRenderableWidget(imagebutton_contract_button);
	}
}