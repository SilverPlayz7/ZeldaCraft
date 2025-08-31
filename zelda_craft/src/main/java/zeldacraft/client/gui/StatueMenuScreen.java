package zeldacraft.client.gui;

import zeldacraft.world.inventory.StatueMenuMenu;

import zeldacraft.procedures.Warp5ShowProcedure;
import zeldacraft.procedures.Warp4ShowProcedure;
import zeldacraft.procedures.Warp3ShowProcedure;
import zeldacraft.procedures.Warp2ShowProcedure;
import zeldacraft.procedures.Warp1ShowProcedure;
import zeldacraft.procedures.Name4Procedure;
import zeldacraft.procedures.Name3Procedure;
import zeldacraft.procedures.Name2Procedure;
import zeldacraft.procedures.Name1Procedure;

import zeldacraft.network.StatueMenuButtonMessage;

import zeldacraft.init.ZeldaCraftModScreens;

import zeldacraft.ZeldaCraftMod;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.Minecraft;

import com.mojang.blaze3d.systems.RenderSystem;

public class StatueMenuScreen extends AbstractContainerScreen<StatueMenuMenu> implements ZeldaCraftModScreens.ScreenAccessor {
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private boolean menuStateUpdateActive = false;
	EditBox Warp5;
	ImageButton imagebutton_owlstatueactive;
	ImageButton imagebutton_owlstatueactive1;
	ImageButton imagebutton_owlstatueactive2;
	ImageButton imagebutton_owlstatueactive3;
	ImageButton imagebutton_owlstatueactive4;
	ImageButton imagebutton_deletewarp;
	ImageButton imagebutton_deletewarp1;
	ImageButton imagebutton_deletewarp2;
	ImageButton imagebutton_deletewarp3;
	ImageButton imagebutton_deletewarp4;

	public StatueMenuScreen(StatueMenuMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 200;
		this.imageHeight = 166;
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
		Warp5.render(guiGraphics, mouseX, mouseY, partialTicks);
		boolean customTooltipShown = false;
		if (Warp1ShowProcedure.execute(world, entity))
			if (mouseX > leftPos + 166 && mouseX < leftPos + 190 && mouseY > topPos + 14 && mouseY < topPos + 38) {
				guiGraphics.renderTooltip(font, Component.translatable("gui.zelda_craft.statue_menu.tooltip_delete"), mouseX, mouseY);
				customTooltipShown = true;
			}
		if (Warp2ShowProcedure.execute(world, entity))
			if (mouseX > leftPos + 166 && mouseX < leftPos + 190 && mouseY > topPos + 45 && mouseY < topPos + 69) {
				guiGraphics.renderTooltip(font, Component.translatable("gui.zelda_craft.statue_menu.tooltip_delete1"), mouseX, mouseY);
				customTooltipShown = true;
			}
		if (Warp3ShowProcedure.execute(world, entity))
			if (mouseX > leftPos + 166 && mouseX < leftPos + 190 && mouseY > topPos + 75 && mouseY < topPos + 99) {
				guiGraphics.renderTooltip(font, Component.translatable("gui.zelda_craft.statue_menu.tooltip_delete2"), mouseX, mouseY);
				customTooltipShown = true;
			}
		if (Warp4ShowProcedure.execute(world, entity))
			if (mouseX > leftPos + 166 && mouseX < leftPos + 190 && mouseY > topPos + 105 && mouseY < topPos + 129) {
				guiGraphics.renderTooltip(font, Component.translatable("gui.zelda_craft.statue_menu.tooltip_delete3"), mouseX, mouseY);
				customTooltipShown = true;
			}
		if (Warp5ShowProcedure.execute(world, entity))
			if (mouseX > leftPos + 166 && mouseX < leftPos + 190 && mouseY > topPos + 135 && mouseY < topPos + 159) {
				guiGraphics.renderTooltip(font, Component.translatable("gui.zelda_craft.statue_menu.tooltip_delete4"), mouseX, mouseY);
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
		guiGraphics.blit(ResourceLocation.parse("zelda_craft:textures/screens/songofsoaringgui.png"), this.leftPos + -21, this.topPos + -34, 0, 0, 240, 216, 240, 216);
		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}
		if (Warp5.isFocused())
			return Warp5.keyPressed(key, b, c);
		return super.keyPressed(key, b, c);
	}

	@Override
	protected void containerTick() {
		super.containerTick();
		this.imagebutton_owlstatueactive.visible = Warp1ShowProcedure.execute(world, entity);
		this.imagebutton_owlstatueactive1.visible = Warp2ShowProcedure.execute(world, entity);
		this.imagebutton_owlstatueactive2.visible = Warp3ShowProcedure.execute(world, entity);
		this.imagebutton_owlstatueactive3.visible = Warp4ShowProcedure.execute(world, entity);
		this.imagebutton_owlstatueactive4.visible = Warp5ShowProcedure.execute(world, entity);
		this.imagebutton_deletewarp.visible = Warp1ShowProcedure.execute(world, entity);
		this.imagebutton_deletewarp1.visible = Warp2ShowProcedure.execute(world, entity);
		this.imagebutton_deletewarp2.visible = Warp3ShowProcedure.execute(world, entity);
		this.imagebutton_deletewarp3.visible = Warp4ShowProcedure.execute(world, entity);
		this.imagebutton_deletewarp4.visible = Warp5ShowProcedure.execute(world, entity);
		Warp5.tick();
	}

	@Override
	public void resize(Minecraft minecraft, int width, int height) {
		String Warp5Value = Warp5.getValue();
		super.resize(minecraft, width, height);
		Warp5.setValue(Warp5Value);
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
		guiGraphics.drawString(this.font, Name1Procedure.execute(world, entity), 45, 23, -12829636, false);
		guiGraphics.drawString(this.font, Name2Procedure.execute(world, entity), 45, 53, -12829636, false);
		guiGraphics.drawString(this.font, Name3Procedure.execute(world, entity), 45, 83, -12829636, false);
		guiGraphics.drawString(this.font, Name4Procedure.execute(world, entity), 45, 113, -12829636, false);
	}

	@Override
	public void init() {
		super.init();
		Warp5 = new EditBox(this.font, this.leftPos + 42, this.topPos + 138, 118, 18, Component.translatable("gui.zelda_craft.statue_menu.Warp5"));
		Warp5.setHint(Component.translatable("gui.zelda_craft.statue_menu.Warp5"));
		Warp5.setMaxLength(8192);
		Warp5.setResponder(content -> {
			if (!menuStateUpdateActive)
				menu.sendMenuStateUpdate(entity, 0, "Warp5", content, false);
		});
		this.addWidget(this.Warp5);
		imagebutton_owlstatueactive = new ImageButton(this.leftPos + 11, this.topPos + 14, 27, 26, 0, 0, 26, ResourceLocation.parse("zelda_craft:textures/screens/atlas/imagebutton_owlstatueactive.png"), 27, 52, e -> {
			int x = StatueMenuScreen.this.x;
			int y = StatueMenuScreen.this.y;
			if (Warp1ShowProcedure.execute(world, entity)) {
				ZeldaCraftMod.PACKET_HANDLER.sendToServer(new StatueMenuButtonMessage(0, x, y, z));
				StatueMenuButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		});
		this.addRenderableWidget(imagebutton_owlstatueactive);
		imagebutton_owlstatueactive1 = new ImageButton(this.leftPos + 11, this.topPos + 44, 27, 26, 0, 0, 26, ResourceLocation.parse("zelda_craft:textures/screens/atlas/imagebutton_owlstatueactive1.png"), 27, 52, e -> {
			int x = StatueMenuScreen.this.x;
			int y = StatueMenuScreen.this.y;
			if (Warp2ShowProcedure.execute(world, entity)) {
				ZeldaCraftMod.PACKET_HANDLER.sendToServer(new StatueMenuButtonMessage(1, x, y, z));
				StatueMenuButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		});
		this.addRenderableWidget(imagebutton_owlstatueactive1);
		imagebutton_owlstatueactive2 = new ImageButton(this.leftPos + 11, this.topPos + 74, 27, 26, 0, 0, 26, ResourceLocation.parse("zelda_craft:textures/screens/atlas/imagebutton_owlstatueactive2.png"), 27, 52, e -> {
			int x = StatueMenuScreen.this.x;
			int y = StatueMenuScreen.this.y;
			if (Warp3ShowProcedure.execute(world, entity)) {
				ZeldaCraftMod.PACKET_HANDLER.sendToServer(new StatueMenuButtonMessage(2, x, y, z));
				StatueMenuButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		});
		this.addRenderableWidget(imagebutton_owlstatueactive2);
		imagebutton_owlstatueactive3 = new ImageButton(this.leftPos + 11, this.topPos + 104, 27, 26, 0, 0, 26, ResourceLocation.parse("zelda_craft:textures/screens/atlas/imagebutton_owlstatueactive3.png"), 27, 52, e -> {
			int x = StatueMenuScreen.this.x;
			int y = StatueMenuScreen.this.y;
			if (Warp4ShowProcedure.execute(world, entity)) {
				ZeldaCraftMod.PACKET_HANDLER.sendToServer(new StatueMenuButtonMessage(3, x, y, z));
				StatueMenuButtonMessage.handleButtonAction(entity, 3, x, y, z);
			}
		});
		this.addRenderableWidget(imagebutton_owlstatueactive3);
		imagebutton_owlstatueactive4 = new ImageButton(this.leftPos + 11, this.topPos + 134, 27, 26, 0, 0, 26, ResourceLocation.parse("zelda_craft:textures/screens/atlas/imagebutton_owlstatueactive4.png"), 27, 52, e -> {
			int x = StatueMenuScreen.this.x;
			int y = StatueMenuScreen.this.y;
			if (Warp5ShowProcedure.execute(world, entity)) {
				ZeldaCraftMod.PACKET_HANDLER.sendToServer(new StatueMenuButtonMessage(4, x, y, z));
				StatueMenuButtonMessage.handleButtonAction(entity, 4, x, y, z);
			}
		});
		this.addRenderableWidget(imagebutton_owlstatueactive4);
		imagebutton_deletewarp = new ImageButton(this.leftPos + 166, this.topPos + 13, 25, 26, 0, 0, 26, ResourceLocation.parse("zelda_craft:textures/screens/atlas/imagebutton_deletewarp.png"), 25, 52, e -> {
			int x = StatueMenuScreen.this.x;
			int y = StatueMenuScreen.this.y;
			if (Warp1ShowProcedure.execute(world, entity)) {
				ZeldaCraftMod.PACKET_HANDLER.sendToServer(new StatueMenuButtonMessage(5, x, y, z));
				StatueMenuButtonMessage.handleButtonAction(entity, 5, x, y, z);
			}
		});
		this.addRenderableWidget(imagebutton_deletewarp);
		imagebutton_deletewarp1 = new ImageButton(this.leftPos + 166, this.topPos + 44, 25, 26, 0, 0, 26, ResourceLocation.parse("zelda_craft:textures/screens/atlas/imagebutton_deletewarp1.png"), 25, 52, e -> {
			int x = StatueMenuScreen.this.x;
			int y = StatueMenuScreen.this.y;
			if (Warp2ShowProcedure.execute(world, entity)) {
				ZeldaCraftMod.PACKET_HANDLER.sendToServer(new StatueMenuButtonMessage(6, x, y, z));
				StatueMenuButtonMessage.handleButtonAction(entity, 6, x, y, z);
			}
		});
		this.addRenderableWidget(imagebutton_deletewarp1);
		imagebutton_deletewarp2 = new ImageButton(this.leftPos + 166, this.topPos + 74, 25, 26, 0, 0, 26, ResourceLocation.parse("zelda_craft:textures/screens/atlas/imagebutton_deletewarp2.png"), 25, 52, e -> {
			int x = StatueMenuScreen.this.x;
			int y = StatueMenuScreen.this.y;
			if (Warp3ShowProcedure.execute(world, entity)) {
				ZeldaCraftMod.PACKET_HANDLER.sendToServer(new StatueMenuButtonMessage(7, x, y, z));
				StatueMenuButtonMessage.handleButtonAction(entity, 7, x, y, z);
			}
		});
		this.addRenderableWidget(imagebutton_deletewarp2);
		imagebutton_deletewarp3 = new ImageButton(this.leftPos + 166, this.topPos + 104, 25, 26, 0, 0, 26, ResourceLocation.parse("zelda_craft:textures/screens/atlas/imagebutton_deletewarp3.png"), 25, 52, e -> {
			int x = StatueMenuScreen.this.x;
			int y = StatueMenuScreen.this.y;
			if (Warp4ShowProcedure.execute(world, entity)) {
				ZeldaCraftMod.PACKET_HANDLER.sendToServer(new StatueMenuButtonMessage(8, x, y, z));
				StatueMenuButtonMessage.handleButtonAction(entity, 8, x, y, z);
			}
		});
		this.addRenderableWidget(imagebutton_deletewarp3);
		imagebutton_deletewarp4 = new ImageButton(this.leftPos + 166, this.topPos + 134, 25, 26, 0, 0, 26, ResourceLocation.parse("zelda_craft:textures/screens/atlas/imagebutton_deletewarp4.png"), 25, 52, e -> {
			int x = StatueMenuScreen.this.x;
			int y = StatueMenuScreen.this.y;
			if (Warp5ShowProcedure.execute(world, entity)) {
				ZeldaCraftMod.PACKET_HANDLER.sendToServer(new StatueMenuButtonMessage(9, x, y, z));
				StatueMenuButtonMessage.handleButtonAction(entity, 9, x, y, z);
			}
		});
		this.addRenderableWidget(imagebutton_deletewarp4);
	}
}