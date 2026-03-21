package zeldacraft.client.screens;

import zeldacraft.procedures.RupeeTypeShownProcedure;
import zeldacraft.procedures.RupeeTypeShown4Procedure;
import zeldacraft.procedures.RupeeTypeShown3Procedure;
import zeldacraft.procedures.RupeeTypeShown2Procedure;
import zeldacraft.procedures.RupeeCounterProcedure;
import zeldacraft.procedures.RupeeCountOverlayDisplayOverlayIngameProcedure;

import org.checkerframework.checker.units.qual.h;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.client.event.RenderGuiEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.client.Minecraft;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.platform.GlStateManager;

@Mod.EventBusSubscriber({Dist.CLIENT})
public class RupeeOverlayOverlay {
	@SubscribeEvent(priority = EventPriority.NORMAL)
	public static void eventHandler(RenderGuiEvent.Pre event) {
		int w = event.getWindow().getGuiScaledWidth();
		int h = event.getWindow().getGuiScaledHeight();
		Level world = null;
		double x = 0;
		double y = 0;
		double z = 0;
		Player entity = Minecraft.getInstance().player;
		if (entity != null) {
			world = entity.level();
			x = entity.getX();
			y = entity.getY();
			z = entity.getZ();
		}
		RenderSystem.disableDepthTest();
		RenderSystem.depthMask(false);
		RenderSystem.enableBlend();
		RenderSystem.setShader(GameRenderer::getPositionTexShader);
		RenderSystem.blendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
		RenderSystem.setShaderColor(1, 1, 1, 1);
		if (RupeeCountOverlayDisplayOverlayIngameProcedure.execute(entity)) {
			event.getGuiGraphics().blit(ResourceLocation.parse("zelda_craft:textures/screens/rupee_icon.png"), 6, h - 25, 0, 0, 16, 16, 16, 16);

			if (RupeeTypeShownProcedure.execute(entity)) {
				event.getGuiGraphics().blit(ResourceLocation.parse("zelda_craft:textures/screens/rupee_icon_adult2.png"), 6, h - 25, 0, 0, 16, 16, 16, 16);
			}
			if (RupeeTypeShown2Procedure.execute(entity)) {
				event.getGuiGraphics().blit(ResourceLocation.parse("zelda_craft:textures/screens/rupee_icon_big2.png"), 6, h - 25, 0, 0, 16, 16, 16, 16);
			}
			if (RupeeTypeShown3Procedure.execute(entity)) {
				event.getGuiGraphics().blit(ResourceLocation.parse("zelda_craft:textures/screens/rupee_icon_giant2.png"), 6, h - 25, 0, 0, 16, 16, 16, 16);
			}
			if (RupeeTypeShown4Procedure.execute(entity)) {
				event.getGuiGraphics().blit(ResourceLocation.parse("zelda_craft:textures/screens/rupee_icon_tycoon2.png"), 6, h - 25, 0, 0, 16, 16, 16, 16);
			}
			event.getGuiGraphics().drawString(Minecraft.getInstance().font,

					RupeeCounterProcedure.execute(world, entity), 24, h - 18, -1, false);
		}
		RenderSystem.depthMask(true);
		RenderSystem.defaultBlendFunc();
		RenderSystem.enableDepthTest();
		RenderSystem.disableBlend();
		RenderSystem.setShaderColor(1, 1, 1, 1);
	}
}