package zeldacraft.client.gui;

import zeldacraft.world.inventory.StatueMenuMenu;

import zeldacraft.procedures.Warp5ShowProcedure;
import zeldacraft.procedures.Warp4ShowProcedure;
import zeldacraft.procedures.Warp3ShowProcedure;
import zeldacraft.procedures.Warp2ShowProcedure;
import zeldacraft.procedures.Warp1ShowProcedure;

import zeldacraft.network.StatueMenuButtonMessage;

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

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class StatueMenuScreen extends AbstractContainerScreen<StatueMenuMenu> {
	private final static HashMap<String, Object> guistate = StatueMenuMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	EditBox Warp1;
	EditBox Warp2;
	EditBox Warp3;
	EditBox Warp4;
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
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		Warp1.render(guiGraphics, mouseX, mouseY, partialTicks);
		Warp2.render(guiGraphics, mouseX, mouseY, partialTicks);
		Warp3.render(guiGraphics, mouseX, mouseY, partialTicks);
		Warp4.render(guiGraphics, mouseX, mouseY, partialTicks);
		Warp5.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
		if (Warp1ShowProcedure.execute(entity))
			if (mouseX > leftPos + 166 && mouseX < leftPos + 190 && mouseY > topPos + 14 && mouseY < topPos + 38)
				guiGraphics.renderTooltip(font, Component.translatable("gui.zelda_craft.statue_menu.tooltip_delete"), mouseX, mouseY);
		if (Warp2ShowProcedure.execute(entity))
			if (mouseX > leftPos + 166 && mouseX < leftPos + 190 && mouseY > topPos + 45 && mouseY < topPos + 69)
				guiGraphics.renderTooltip(font, Component.translatable("gui.zelda_craft.statue_menu.tooltip_delete1"), mouseX, mouseY);
		if (Warp3ShowProcedure.execute(entity))
			if (mouseX > leftPos + 166 && mouseX < leftPos + 190 && mouseY > topPos + 75 && mouseY < topPos + 99)
				guiGraphics.renderTooltip(font, Component.translatable("gui.zelda_craft.statue_menu.tooltip_delete2"), mouseX, mouseY);
		if (Warp4ShowProcedure.execute(entity))
			if (mouseX > leftPos + 166 && mouseX < leftPos + 190 && mouseY > topPos + 105 && mouseY < topPos + 129)
				guiGraphics.renderTooltip(font, Component.translatable("gui.zelda_craft.statue_menu.tooltip_delete3"), mouseX, mouseY);
		if (Warp5ShowProcedure.execute(entity))
			if (mouseX > leftPos + 166 && mouseX < leftPos + 190 && mouseY > topPos + 135 && mouseY < topPos + 159)
				guiGraphics.renderTooltip(font, Component.translatable("gui.zelda_craft.statue_menu.tooltip_delete4"), mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();

		guiGraphics.blit(new ResourceLocation("zelda_craft:textures/screens/songofsoaringgui.png"), this.leftPos + -21, this.topPos + -34, 0, 0, 240, 216, 240, 216);

		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}
		if (Warp1.isFocused())
			return Warp1.keyPressed(key, b, c);
		if (Warp2.isFocused())
			return Warp2.keyPressed(key, b, c);
		if (Warp3.isFocused())
			return Warp3.keyPressed(key, b, c);
		if (Warp4.isFocused())
			return Warp4.keyPressed(key, b, c);
		if (Warp5.isFocused())
			return Warp5.keyPressed(key, b, c);
		return super.keyPressed(key, b, c);
	}

	@Override
	public void containerTick() {
		super.containerTick();
		Warp1.tick();
		Warp2.tick();
		Warp3.tick();
		Warp4.tick();
		Warp5.tick();
	}

	@Override
	public void resize(Minecraft minecraft, int width, int height) {
		String Warp1Value = Warp1.getValue();
		String Warp2Value = Warp2.getValue();
		String Warp3Value = Warp3.getValue();
		String Warp4Value = Warp4.getValue();
		String Warp5Value = Warp5.getValue();
		super.resize(minecraft, width, height);
		Warp1.setValue(Warp1Value);
		Warp2.setValue(Warp2Value);
		Warp3.setValue(Warp3Value);
		Warp4.setValue(Warp4Value);
		Warp5.setValue(Warp5Value);
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
	}

	@Override
	public void init() {
		super.init();
		Warp1 = new EditBox(this.font, this.leftPos + 41, this.topPos + 17, 118, 18, Component.translatable("gui.zelda_craft.statue_menu.Warp1")) {
			@Override
			public void insertText(String text) {
				super.insertText(text);
				if (getValue().isEmpty())
					setSuggestion(Component.translatable("gui.zelda_craft.statue_menu.Warp1").getString());
				else
					setSuggestion(null);
			}

			@Override
			public void moveCursorTo(int pos) {
				super.moveCursorTo(pos);
				if (getValue().isEmpty())
					setSuggestion(Component.translatable("gui.zelda_craft.statue_menu.Warp1").getString());
				else
					setSuggestion(null);
			}
		};
		Warp1.setSuggestion(Component.translatable("gui.zelda_craft.statue_menu.Warp1").getString());
		Warp1.setMaxLength(32767);
		guistate.put("text:Warp1", Warp1);
		this.addWidget(this.Warp1);
		Warp2 = new EditBox(this.font, this.leftPos + 41, this.topPos + 48, 118, 18, Component.translatable("gui.zelda_craft.statue_menu.Warp2")) {
			@Override
			public void insertText(String text) {
				super.insertText(text);
				if (getValue().isEmpty())
					setSuggestion(Component.translatable("gui.zelda_craft.statue_menu.Warp2").getString());
				else
					setSuggestion(null);
			}

			@Override
			public void moveCursorTo(int pos) {
				super.moveCursorTo(pos);
				if (getValue().isEmpty())
					setSuggestion(Component.translatable("gui.zelda_craft.statue_menu.Warp2").getString());
				else
					setSuggestion(null);
			}
		};
		Warp2.setSuggestion(Component.translatable("gui.zelda_craft.statue_menu.Warp2").getString());
		Warp2.setMaxLength(32767);
		guistate.put("text:Warp2", Warp2);
		this.addWidget(this.Warp2);
		Warp3 = new EditBox(this.font, this.leftPos + 41, this.topPos + 78, 118, 18, Component.translatable("gui.zelda_craft.statue_menu.Warp3")) {
			@Override
			public void insertText(String text) {
				super.insertText(text);
				if (getValue().isEmpty())
					setSuggestion(Component.translatable("gui.zelda_craft.statue_menu.Warp3").getString());
				else
					setSuggestion(null);
			}

			@Override
			public void moveCursorTo(int pos) {
				super.moveCursorTo(pos);
				if (getValue().isEmpty())
					setSuggestion(Component.translatable("gui.zelda_craft.statue_menu.Warp3").getString());
				else
					setSuggestion(null);
			}
		};
		Warp3.setSuggestion(Component.translatable("gui.zelda_craft.statue_menu.Warp3").getString());
		Warp3.setMaxLength(32767);
		guistate.put("text:Warp3", Warp3);
		this.addWidget(this.Warp3);
		Warp4 = new EditBox(this.font, this.leftPos + 42, this.topPos + 108, 118, 18, Component.translatable("gui.zelda_craft.statue_menu.Warp4")) {
			@Override
			public void insertText(String text) {
				super.insertText(text);
				if (getValue().isEmpty())
					setSuggestion(Component.translatable("gui.zelda_craft.statue_menu.Warp4").getString());
				else
					setSuggestion(null);
			}

			@Override
			public void moveCursorTo(int pos) {
				super.moveCursorTo(pos);
				if (getValue().isEmpty())
					setSuggestion(Component.translatable("gui.zelda_craft.statue_menu.Warp4").getString());
				else
					setSuggestion(null);
			}
		};
		Warp4.setSuggestion(Component.translatable("gui.zelda_craft.statue_menu.Warp4").getString());
		Warp4.setMaxLength(32767);
		guistate.put("text:Warp4", Warp4);
		this.addWidget(this.Warp4);
		Warp5 = new EditBox(this.font, this.leftPos + 42, this.topPos + 138, 118, 18, Component.translatable("gui.zelda_craft.statue_menu.Warp5")) {
			@Override
			public void insertText(String text) {
				super.insertText(text);
				if (getValue().isEmpty())
					setSuggestion(Component.translatable("gui.zelda_craft.statue_menu.Warp5").getString());
				else
					setSuggestion(null);
			}

			@Override
			public void moveCursorTo(int pos) {
				super.moveCursorTo(pos);
				if (getValue().isEmpty())
					setSuggestion(Component.translatable("gui.zelda_craft.statue_menu.Warp5").getString());
				else
					setSuggestion(null);
			}
		};
		Warp5.setSuggestion(Component.translatable("gui.zelda_craft.statue_menu.Warp5").getString());
		Warp5.setMaxLength(32767);
		guistate.put("text:Warp5", Warp5);
		this.addWidget(this.Warp5);
		imagebutton_owlstatueactive = new ImageButton(this.leftPos + 11, this.topPos + 14, 27, 26, 0, 0, 26, new ResourceLocation("zelda_craft:textures/screens/atlas/imagebutton_owlstatueactive.png"), 27, 52, e -> {
			if (Warp1ShowProcedure.execute(entity)) {
				ZeldaCraftMod.PACKET_HANDLER.sendToServer(new StatueMenuButtonMessage(0, x, y, z));
				StatueMenuButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}) {
			@Override
			public void render(GuiGraphics guiGraphics, int gx, int gy, float ticks) {
				if (Warp1ShowProcedure.execute(entity))
					super.render(guiGraphics, gx, gy, ticks);
			}
		};
		guistate.put("button:imagebutton_owlstatueactive", imagebutton_owlstatueactive);
		this.addRenderableWidget(imagebutton_owlstatueactive);
		imagebutton_owlstatueactive1 = new ImageButton(this.leftPos + 11, this.topPos + 44, 27, 26, 0, 0, 26, new ResourceLocation("zelda_craft:textures/screens/atlas/imagebutton_owlstatueactive1.png"), 27, 52, e -> {
			if (Warp2ShowProcedure.execute(entity)) {
				ZeldaCraftMod.PACKET_HANDLER.sendToServer(new StatueMenuButtonMessage(1, x, y, z));
				StatueMenuButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}) {
			@Override
			public void render(GuiGraphics guiGraphics, int gx, int gy, float ticks) {
				if (Warp2ShowProcedure.execute(entity))
					super.render(guiGraphics, gx, gy, ticks);
			}
		};
		guistate.put("button:imagebutton_owlstatueactive1", imagebutton_owlstatueactive1);
		this.addRenderableWidget(imagebutton_owlstatueactive1);
		imagebutton_owlstatueactive2 = new ImageButton(this.leftPos + 11, this.topPos + 74, 27, 26, 0, 0, 26, new ResourceLocation("zelda_craft:textures/screens/atlas/imagebutton_owlstatueactive2.png"), 27, 52, e -> {
			if (Warp3ShowProcedure.execute(entity)) {
				ZeldaCraftMod.PACKET_HANDLER.sendToServer(new StatueMenuButtonMessage(2, x, y, z));
				StatueMenuButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		}) {
			@Override
			public void render(GuiGraphics guiGraphics, int gx, int gy, float ticks) {
				if (Warp3ShowProcedure.execute(entity))
					super.render(guiGraphics, gx, gy, ticks);
			}
		};
		guistate.put("button:imagebutton_owlstatueactive2", imagebutton_owlstatueactive2);
		this.addRenderableWidget(imagebutton_owlstatueactive2);
		imagebutton_owlstatueactive3 = new ImageButton(this.leftPos + 11, this.topPos + 104, 27, 26, 0, 0, 26, new ResourceLocation("zelda_craft:textures/screens/atlas/imagebutton_owlstatueactive3.png"), 27, 52, e -> {
			if (Warp4ShowProcedure.execute(entity)) {
				ZeldaCraftMod.PACKET_HANDLER.sendToServer(new StatueMenuButtonMessage(3, x, y, z));
				StatueMenuButtonMessage.handleButtonAction(entity, 3, x, y, z);
			}
		}) {
			@Override
			public void render(GuiGraphics guiGraphics, int gx, int gy, float ticks) {
				if (Warp4ShowProcedure.execute(entity))
					super.render(guiGraphics, gx, gy, ticks);
			}
		};
		guistate.put("button:imagebutton_owlstatueactive3", imagebutton_owlstatueactive3);
		this.addRenderableWidget(imagebutton_owlstatueactive3);
		imagebutton_owlstatueactive4 = new ImageButton(this.leftPos + 11, this.topPos + 134, 27, 26, 0, 0, 26, new ResourceLocation("zelda_craft:textures/screens/atlas/imagebutton_owlstatueactive4.png"), 27, 52, e -> {
			if (Warp5ShowProcedure.execute(entity)) {
				ZeldaCraftMod.PACKET_HANDLER.sendToServer(new StatueMenuButtonMessage(4, x, y, z));
				StatueMenuButtonMessage.handleButtonAction(entity, 4, x, y, z);
			}
		}) {
			@Override
			public void render(GuiGraphics guiGraphics, int gx, int gy, float ticks) {
				if (Warp5ShowProcedure.execute(entity))
					super.render(guiGraphics, gx, gy, ticks);
			}
		};
		guistate.put("button:imagebutton_owlstatueactive4", imagebutton_owlstatueactive4);
		this.addRenderableWidget(imagebutton_owlstatueactive4);
		imagebutton_deletewarp = new ImageButton(this.leftPos + 166, this.topPos + 13, 25, 26, 0, 0, 26, new ResourceLocation("zelda_craft:textures/screens/atlas/imagebutton_deletewarp.png"), 25, 52, e -> {
			if (Warp1ShowProcedure.execute(entity)) {
				ZeldaCraftMod.PACKET_HANDLER.sendToServer(new StatueMenuButtonMessage(5, x, y, z));
				StatueMenuButtonMessage.handleButtonAction(entity, 5, x, y, z);
			}
		}) {
			@Override
			public void render(GuiGraphics guiGraphics, int gx, int gy, float ticks) {
				if (Warp1ShowProcedure.execute(entity))
					super.render(guiGraphics, gx, gy, ticks);
			}
		};
		guistate.put("button:imagebutton_deletewarp", imagebutton_deletewarp);
		this.addRenderableWidget(imagebutton_deletewarp);
		imagebutton_deletewarp1 = new ImageButton(this.leftPos + 166, this.topPos + 44, 25, 26, 0, 0, 26, new ResourceLocation("zelda_craft:textures/screens/atlas/imagebutton_deletewarp1.png"), 25, 52, e -> {
			if (Warp2ShowProcedure.execute(entity)) {
				ZeldaCraftMod.PACKET_HANDLER.sendToServer(new StatueMenuButtonMessage(6, x, y, z));
				StatueMenuButtonMessage.handleButtonAction(entity, 6, x, y, z);
			}
		}) {
			@Override
			public void render(GuiGraphics guiGraphics, int gx, int gy, float ticks) {
				if (Warp2ShowProcedure.execute(entity))
					super.render(guiGraphics, gx, gy, ticks);
			}
		};
		guistate.put("button:imagebutton_deletewarp1", imagebutton_deletewarp1);
		this.addRenderableWidget(imagebutton_deletewarp1);
		imagebutton_deletewarp2 = new ImageButton(this.leftPos + 166, this.topPos + 74, 25, 26, 0, 0, 26, new ResourceLocation("zelda_craft:textures/screens/atlas/imagebutton_deletewarp2.png"), 25, 52, e -> {
			if (Warp3ShowProcedure.execute(entity)) {
				ZeldaCraftMod.PACKET_HANDLER.sendToServer(new StatueMenuButtonMessage(7, x, y, z));
				StatueMenuButtonMessage.handleButtonAction(entity, 7, x, y, z);
			}
		}) {
			@Override
			public void render(GuiGraphics guiGraphics, int gx, int gy, float ticks) {
				if (Warp3ShowProcedure.execute(entity))
					super.render(guiGraphics, gx, gy, ticks);
			}
		};
		guistate.put("button:imagebutton_deletewarp2", imagebutton_deletewarp2);
		this.addRenderableWidget(imagebutton_deletewarp2);
		imagebutton_deletewarp3 = new ImageButton(this.leftPos + 166, this.topPos + 104, 25, 26, 0, 0, 26, new ResourceLocation("zelda_craft:textures/screens/atlas/imagebutton_deletewarp3.png"), 25, 52, e -> {
			if (Warp4ShowProcedure.execute(entity)) {
				ZeldaCraftMod.PACKET_HANDLER.sendToServer(new StatueMenuButtonMessage(8, x, y, z));
				StatueMenuButtonMessage.handleButtonAction(entity, 8, x, y, z);
			}
		}) {
			@Override
			public void render(GuiGraphics guiGraphics, int gx, int gy, float ticks) {
				if (Warp4ShowProcedure.execute(entity))
					super.render(guiGraphics, gx, gy, ticks);
			}
		};
		guistate.put("button:imagebutton_deletewarp3", imagebutton_deletewarp3);
		this.addRenderableWidget(imagebutton_deletewarp3);
		imagebutton_deletewarp4 = new ImageButton(this.leftPos + 166, this.topPos + 134, 25, 26, 0, 0, 26, new ResourceLocation("zelda_craft:textures/screens/atlas/imagebutton_deletewarp4.png"), 25, 52, e -> {
			if (Warp5ShowProcedure.execute(entity)) {
				ZeldaCraftMod.PACKET_HANDLER.sendToServer(new StatueMenuButtonMessage(9, x, y, z));
				StatueMenuButtonMessage.handleButtonAction(entity, 9, x, y, z);
			}
		}) {
			@Override
			public void render(GuiGraphics guiGraphics, int gx, int gy, float ticks) {
				if (Warp5ShowProcedure.execute(entity))
					super.render(guiGraphics, gx, gy, ticks);
			}
		};
		guistate.put("button:imagebutton_deletewarp4", imagebutton_deletewarp4);
		this.addRenderableWidget(imagebutton_deletewarp4);
	}
}
