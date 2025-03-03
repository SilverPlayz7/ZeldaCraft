package zeldacraft.client.gui;

import zeldacraft.world.inventory.OcarinaBlankMenu;

import zeldacraft.procedures.Show6YProcedure;
import zeldacraft.procedures.Show6XProcedure;
import zeldacraft.procedures.Show6RProcedure;
import zeldacraft.procedures.Show6LProcedure;
import zeldacraft.procedures.Show6AProcedure;
import zeldacraft.procedures.Show5YProcedure;
import zeldacraft.procedures.Show5XProcedure;
import zeldacraft.procedures.Show5RProcedure;
import zeldacraft.procedures.Show5LProcedure;
import zeldacraft.procedures.Show5AProcedure;
import zeldacraft.procedures.Show4YProcedure;
import zeldacraft.procedures.Show4XProcedure;
import zeldacraft.procedures.Show4RProcedure;
import zeldacraft.procedures.Show4LProcedure;
import zeldacraft.procedures.Show4AProcedure;
import zeldacraft.procedures.Show3YProcedure;
import zeldacraft.procedures.Show3XProcedure;
import zeldacraft.procedures.Show3RProcedure;
import zeldacraft.procedures.Show3LProcedure;
import zeldacraft.procedures.Show3AProcedure;
import zeldacraft.procedures.Show2YProcedure;
import zeldacraft.procedures.Show2XProcedure;
import zeldacraft.procedures.Show2RProcedure;
import zeldacraft.procedures.Show2LProcedure;
import zeldacraft.procedures.Show2AProcedure;
import zeldacraft.procedures.Show1YProcedure;
import zeldacraft.procedures.Show1XProcedure;
import zeldacraft.procedures.Show1RProcedure;
import zeldacraft.procedures.Show1LProcedure;
import zeldacraft.procedures.Show1AProcedure;
import zeldacraft.procedures.OcarinaYButtonProcedure;
import zeldacraft.procedures.OcarinaXButtonProcedure;
import zeldacraft.procedures.OcarinaRButtonProcedure;
import zeldacraft.procedures.OcarinaLButtonProcedure;
import zeldacraft.procedures.OcarinaAButtonProcedure;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.GuiGraphics;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class OcarinaBlankScreen extends AbstractContainerScreen<OcarinaBlankMenu> {
	private final static HashMap<String, Object> guistate = OcarinaBlankMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;

	public OcarinaBlankScreen(OcarinaBlankMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 0;
		this.imageHeight = 0;
	}

	private static final ResourceLocation texture = new ResourceLocation("zelda_craft:textures/screens/ocarina_blank.png");

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
		guiGraphics.blit(new ResourceLocation("zelda_craft:textures/screens/ocarinastaff.png"), this.leftPos + -99, this.topPos + 57, 0, 0, 200, 46, 200, 46);
		if (Show1AProcedure.execute(entity)) {
			guiGraphics.blit(new ResourceLocation("zelda_craft:textures/screens/a.png"), this.leftPos + -63, this.topPos + 63, 0, 0, 13, 12, 13, 12);
		}
		if (Show2AProcedure.execute(entity)) {
			guiGraphics.blit(new ResourceLocation("zelda_craft:textures/screens/a.png"), this.leftPos + -44, this.topPos + 63, 0, 0, 13, 12, 13, 12);
		}
		if (Show3AProcedure.execute(entity)) {
			guiGraphics.blit(new ResourceLocation("zelda_craft:textures/screens/a.png"), this.leftPos + -26, this.topPos + 63, 0, 0, 13, 12, 13, 12);
		}
		if (Show4AProcedure.execute(entity)) {
			guiGraphics.blit(new ResourceLocation("zelda_craft:textures/screens/a.png"), this.leftPos + -6, this.topPos + 63, 0, 0, 13, 12, 13, 12);
		}
		if (Show5AProcedure.execute(entity)) {
			guiGraphics.blit(new ResourceLocation("zelda_craft:textures/screens/a.png"), this.leftPos + 14, this.topPos + 63, 0, 0, 13, 12, 13, 12);
		}
		if (Show6AProcedure.execute(entity)) {
			guiGraphics.blit(new ResourceLocation("zelda_craft:textures/screens/a.png"), this.leftPos + 33, this.topPos + 63, 0, 0, 13, 12, 13, 12);
		}
		if (Show1XProcedure.execute(entity)) {
			guiGraphics.blit(new ResourceLocation("zelda_craft:textures/screens/x.png"), this.leftPos + -62, this.topPos + 71, 0, 0, 12, 12, 12, 12);
		}
		if (Show2XProcedure.execute(entity)) {
			guiGraphics.blit(new ResourceLocation("zelda_craft:textures/screens/x.png"), this.leftPos + -43, this.topPos + 71, 0, 0, 12, 12, 12, 12);
		}
		if (Show3XProcedure.execute(entity)) {
			guiGraphics.blit(new ResourceLocation("zelda_craft:textures/screens/x.png"), this.leftPos + -25, this.topPos + 71, 0, 0, 12, 12, 12, 12);
		}
		if (Show4XProcedure.execute(entity)) {
			guiGraphics.blit(new ResourceLocation("zelda_craft:textures/screens/x.png"), this.leftPos + -5, this.topPos + 71, 0, 0, 12, 12, 12, 12);
		}
		if (Show5XProcedure.execute(entity)) {
			guiGraphics.blit(new ResourceLocation("zelda_craft:textures/screens/x.png"), this.leftPos + 15, this.topPos + 71, 0, 0, 12, 12, 12, 12);
		}
		if (Show6XProcedure.execute(entity)) {
			guiGraphics.blit(new ResourceLocation("zelda_craft:textures/screens/x.png"), this.leftPos + 34, this.topPos + 71, 0, 0, 12, 12, 12, 12);
		}
		if (Show1YProcedure.execute(entity)) {
			guiGraphics.blit(new ResourceLocation("zelda_craft:textures/screens/y.png"), this.leftPos + -63, this.topPos + 75, 0, 0, 13, 12, 13, 12);
		}
		if (Show2YProcedure.execute(entity)) {
			guiGraphics.blit(new ResourceLocation("zelda_craft:textures/screens/y.png"), this.leftPos + -44, this.topPos + 75, 0, 0, 13, 12, 13, 12);
		}
		if (Show3YProcedure.execute(entity)) {
			guiGraphics.blit(new ResourceLocation("zelda_craft:textures/screens/y.png"), this.leftPos + -25, this.topPos + 75, 0, 0, 13, 12, 13, 12);
		}
		if (Show4YProcedure.execute(entity)) {
			guiGraphics.blit(new ResourceLocation("zelda_craft:textures/screens/y.png"), this.leftPos + -6, this.topPos + 75, 0, 0, 13, 12, 13, 12);
		}
		if (Show5YProcedure.execute(entity)) {
			guiGraphics.blit(new ResourceLocation("zelda_craft:textures/screens/y.png"), this.leftPos + 14, this.topPos + 75, 0, 0, 13, 12, 13, 12);
		}
		if (Show6YProcedure.execute(entity)) {
			guiGraphics.blit(new ResourceLocation("zelda_craft:textures/screens/y.png"), this.leftPos + 33, this.topPos + 75, 0, 0, 13, 12, 13, 12);
		}
		if (Show1RProcedure.execute(entity)) {
			guiGraphics.blit(new ResourceLocation("zelda_craft:textures/screens/r.png"), this.leftPos + -62, this.topPos + 84, 0, 0, 12, 10, 12, 10);
		}
		if (Show2RProcedure.execute(entity)) {
			guiGraphics.blit(new ResourceLocation("zelda_craft:textures/screens/r.png"), this.leftPos + -43, this.topPos + 84, 0, 0, 12, 10, 12, 10);
		}
		if (Show3RProcedure.execute(entity)) {
			guiGraphics.blit(new ResourceLocation("zelda_craft:textures/screens/r.png"), this.leftPos + -24, this.topPos + 84, 0, 0, 12, 10, 12, 10);
		}
		if (Show4RProcedure.execute(entity)) {
			guiGraphics.blit(new ResourceLocation("zelda_craft:textures/screens/r.png"), this.leftPos + -5, this.topPos + 84, 0, 0, 12, 10, 12, 10);
		}
		if (Show5RProcedure.execute(entity)) {
			guiGraphics.blit(new ResourceLocation("zelda_craft:textures/screens/r.png"), this.leftPos + 15, this.topPos + 84, 0, 0, 12, 10, 12, 10);
		}
		if (Show6RProcedure.execute(entity)) {
			guiGraphics.blit(new ResourceLocation("zelda_craft:textures/screens/r.png"), this.leftPos + 34, this.topPos + 84, 0, 0, 12, 10, 12, 10);
		}
		if (Show1LProcedure.execute(entity)) {
			guiGraphics.blit(new ResourceLocation("zelda_craft:textures/screens/l.png"), this.leftPos + -62, this.topPos + 91, 0, 0, 12, 10, 12, 10);
		}
		if (Show2LProcedure.execute(entity)) {
			guiGraphics.blit(new ResourceLocation("zelda_craft:textures/screens/l.png"), this.leftPos + -43, this.topPos + 91, 0, 0, 12, 10, 12, 10);
		}
		if (Show3LProcedure.execute(entity)) {
			guiGraphics.blit(new ResourceLocation("zelda_craft:textures/screens/l.png"), this.leftPos + -24, this.topPos + 91, 0, 0, 12, 10, 12, 10);
		}
		if (Show4LProcedure.execute(entity)) {
			guiGraphics.blit(new ResourceLocation("zelda_craft:textures/screens/l.png"), this.leftPos + -5, this.topPos + 91, 0, 0, 12, 10, 12, 10);
		}
		if (Show5LProcedure.execute(entity)) {
			guiGraphics.blit(new ResourceLocation("zelda_craft:textures/screens/l.png"), this.leftPos + 15, this.topPos + 91, 0, 0, 12, 10, 12, 10);
		}
		if (Show6LProcedure.execute(entity)) {
			guiGraphics.blit(new ResourceLocation("zelda_craft:textures/screens/l.png"), this.leftPos + 34, this.topPos + 91, 0, 0, 12, 10, 12, 10);
		}
		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		} else {
			if (key == 68) {
				OcarinaAButtonProcedure.execute(entity);
				return true;
			} else {
				if (key == 87) {
					OcarinaXButtonProcedure.execute(entity);
					return true;
				} else {
					if (key == 65) {
						OcarinaYButtonProcedure.execute(entity);
						return true;
					} else {
						if (key == 16) {
							OcarinaLButtonProcedure.execute(entity);
							return true;
						} else {
							if (key == 32) {
								OcarinaRButtonProcedure.execute(entity);
								return true;
							}
						}
					}
				}
			}
		}
		return super.keyPressed(key, b, c);
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
	}

	@Override
	public void init() {
		super.init();
	}
}
