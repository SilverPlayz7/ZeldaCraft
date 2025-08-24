package zeldacraft.client.gui;

import zeldacraft.world.inventory.SwitchTimerSetMenu;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.Minecraft;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class SwitchTimerSetScreen extends AbstractContainerScreen<SwitchTimerSetMenu> {
	private final static HashMap<String, Object> guistate = SwitchTimerSetMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	EditBox timer_length;

	public SwitchTimerSetScreen(SwitchTimerSetMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 66;
	}

	private static final ResourceLocation texture = new ResourceLocation("zelda_craft:textures/screens/switch_timer_set.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		timer_length.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
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
		if (timer_length.isFocused())
			return timer_length.keyPressed(key, b, c);
		return super.keyPressed(key, b, c);
	}

	@Override
	public void containerTick() {
		super.containerTick();
		timer_length.tick();
	}

	@Override
	public void resize(Minecraft minecraft, int width, int height) {
		String timer_lengthValue = timer_length.getValue();
		super.resize(minecraft, width, height);
		timer_length.setValue(timer_lengthValue);
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
		guiGraphics.drawString(this.font, Component.translatable("gui.zelda_craft.switch_timer_set.label_set_timer_to_turn_off_in_ticks"), 7, 7, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.zelda_craft.switch_timer_set.label_close_to_confirm"), 7, 18, -12829636, false);
	}

	@Override
	public void init() {
		super.init();
		timer_length = new EditBox(this.font, this.leftPos + 28, this.topPos + 35, 118, 18, Component.translatable("gui.zelda_craft.switch_timer_set.timer_length")) {
			@Override
			public void insertText(String text) {
				super.insertText(text);
				if (getValue().isEmpty())
					setSuggestion(Component.translatable("gui.zelda_craft.switch_timer_set.timer_length").getString());
				else
					setSuggestion(null);
			}

			@Override
			public void moveCursorTo(int pos) {
				super.moveCursorTo(pos);
				if (getValue().isEmpty())
					setSuggestion(Component.translatable("gui.zelda_craft.switch_timer_set.timer_length").getString());
				else
					setSuggestion(null);
			}
		};
		timer_length.setSuggestion(Component.translatable("gui.zelda_craft.switch_timer_set.timer_length").getString());
		timer_length.setMaxLength(32767);
		guistate.put("text:timer_length", timer_length);
		this.addWidget(this.timer_length);
	}
}
