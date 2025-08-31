package zeldacraft.client.gui;

import zeldacraft.world.inventory.StatueNameSetMenu;

import zeldacraft.network.StatueNameSetButtonMessage;

import zeldacraft.init.ZeldaCraftModScreens;

import zeldacraft.ZeldaCraftMod;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.Minecraft;

import com.mojang.blaze3d.systems.RenderSystem;

public class StatueNameSetScreen extends AbstractContainerScreen<StatueNameSetMenu> implements ZeldaCraftModScreens.ScreenAccessor {
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private boolean menuStateUpdateActive = false;
	EditBox name;
	Button button_confirm;
	Button button_cancel;

	public StatueNameSetScreen(StatueNameSetMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 174;
		this.imageHeight = 75;
	}

	@Override
	public void updateMenuState(int elementType, String name, Object elementState) {
		menuStateUpdateActive = true;
		menuStateUpdateActive = false;
	}

	private static final ResourceLocation texture = ResourceLocation.parse("zelda_craft:textures/screens/statue_name_set.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		name.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int mouseX, int mouseY) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		guiGraphics.blit(texture, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);
		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}
		if (name.isFocused())
			return name.keyPressed(key, b, c);
		return super.keyPressed(key, b, c);
	}

	@Override
	protected void containerTick() {
		super.containerTick();
		name.tick();
	}

	@Override
	public void resize(Minecraft minecraft, int width, int height) {
		String nameValue = name.getValue();
		super.resize(minecraft, width, height);
		name.setValue(nameValue);
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
		guiGraphics.drawString(this.font, Component.translatable("gui.zelda_craft.statue_name_set.label_set_timer_to_turn_off_in_ticks"), 5, 6, -12829636, false);
	}

	@Override
	public void init() {
		super.init();
		name = new EditBox(this.font, this.leftPos + 28, this.topPos + 24, 118, 18, Component.translatable("gui.zelda_craft.statue_name_set.name"));
		name.setMaxLength(8192);
		name.setResponder(content -> {
			if (!menuStateUpdateActive)
				menu.sendMenuStateUpdate(entity, 0, "name", content, false);
		});
		this.addWidget(this.name);
		button_confirm = Button.builder(Component.translatable("gui.zelda_craft.statue_name_set.button_confirm"), e -> {
			int x = StatueNameSetScreen.this.x;
			int y = StatueNameSetScreen.this.y;
			if (true) {
				ZeldaCraftMod.PACKET_HANDLER.sendToServer(new StatueNameSetButtonMessage(0, x, y, z));
				StatueNameSetButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 86, this.topPos + 47, 61, 20).build();
		this.addRenderableWidget(button_confirm);
		button_cancel = Button.builder(Component.translatable("gui.zelda_craft.statue_name_set.button_cancel"), e -> {
			int x = StatueNameSetScreen.this.x;
			int y = StatueNameSetScreen.this.y;
			if (true) {
				ZeldaCraftMod.PACKET_HANDLER.sendToServer(new StatueNameSetButtonMessage(1, x, y, z));
				StatueNameSetButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}).bounds(this.leftPos + 27, this.topPos + 47, 56, 20).build();
		this.addRenderableWidget(button_cancel);
	}
}