package zeldacraft.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.Minecraft;

public class SpinnerVehicleOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (entity.isVehicle()) {
			if (entity.getPersistentData().getDouble("spinTimer") < 150) {
				entity.setDeltaMovement(
						new Vec3((entity.getLookAngle().x / (entity.getPersistentData().getDouble("spinTimer") / 15 + 2)), (entity.getDeltaMovement().y()), (entity.getLookAngle().z / (entity.getPersistentData().getDouble("spinTimer") / 15 + 2))));
				if (new Object() {
					public boolean getValue() {
						boolean retBool = Minecraft.getInstance().options.keyLeft.isDown();
						if (retBool) {
							if (Minecraft.getInstance().options.keyLeft.getKeyModifier().toString().equals("SHIFT")) {
								retBool = Screen.hasShiftDown();
							} else if (Minecraft.getInstance().options.keyLeft.getKeyModifier().toString().equals("CONTROL")) {
								retBool = Screen.hasControlDown();
							} else if (Minecraft.getInstance().options.keyLeft.getKeyModifier().toString().equals("ALT")) {
								retBool = Screen.hasAltDown();
							}
						}
						return retBool;
					}
				}.getValue()) {
					{
						Entity _ent = entity;
						_ent.setYRot(entity.getYRot() - 5);
						_ent.setXRot(0);
						_ent.setYBodyRot(_ent.getYRot());
						_ent.setYHeadRot(_ent.getYRot());
						_ent.yRotO = _ent.getYRot();
						_ent.xRotO = _ent.getXRot();
						if (_ent instanceof LivingEntity _entity) {
							_entity.yBodyRotO = _entity.getYRot();
							_entity.yHeadRotO = _entity.getYRot();
						}
					}
				} else if (new Object() {
					public boolean getValue() {
						boolean retBool = Minecraft.getInstance().options.keyRight.isDown();
						if (retBool) {
							if (Minecraft.getInstance().options.keyRight.getKeyModifier().toString().equals("SHIFT")) {
								retBool = Screen.hasShiftDown();
							} else if (Minecraft.getInstance().options.keyRight.getKeyModifier().toString().equals("CONTROL")) {
								retBool = Screen.hasControlDown();
							} else if (Minecraft.getInstance().options.keyRight.getKeyModifier().toString().equals("ALT")) {
								retBool = Screen.hasAltDown();
							}
						}
						return retBool;
					}
				}.getValue()) {
					{
						Entity _ent = entity;
						_ent.setYRot(entity.getYRot() + 5);
						_ent.setXRot(0);
						_ent.setYBodyRot(_ent.getYRot());
						_ent.setYHeadRot(_ent.getYRot());
						_ent.yRotO = _ent.getYRot();
						_ent.xRotO = _ent.getXRot();
						if (_ent instanceof LivingEntity _entity) {
							_entity.yBodyRotO = _entity.getYRot();
							_entity.yHeadRotO = _entity.getYRot();
						}
					}
				}
				if (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(0.75)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity)).getType() == HitResult.Type.BLOCK) {
					if ((entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(0.75)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity))
							.getDirection()) == Direction.NORTH
							|| (entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(0.75)), ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, entity))
									.getDirection()) == Direction.SOUTH) {
						{
							Entity _ent = entity;
							_ent.setYRot(180 - entity.getYRot());
							_ent.setXRot(0);
							_ent.setYBodyRot(_ent.getYRot());
							_ent.setYHeadRot(_ent.getYRot());
							_ent.yRotO = _ent.getYRot();
							_ent.xRotO = _ent.getXRot();
							if (_ent instanceof LivingEntity _entity) {
								_entity.yBodyRotO = _entity.getYRot();
								_entity.yHeadRotO = _entity.getYRot();
							}
						}
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(ResourceLocation.parse("block.chain.break")), SoundSource.PLAYERS, (float) 0.5,
										(float) (1.25 - entity.getPersistentData().getDouble("spinTimer") / 100));
							} else {
								_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(ResourceLocation.parse("block.chain.break")), SoundSource.PLAYERS, (float) 0.5,
										(float) (1.25 - entity.getPersistentData().getDouble("spinTimer") / 100), false);
							}
						}
					} else {
						{
							Entity _ent = entity;
							_ent.setYRot((-1) * entity.getYRot());
							_ent.setXRot(0);
							_ent.setYBodyRot(_ent.getYRot());
							_ent.setYHeadRot(_ent.getYRot());
							_ent.yRotO = _ent.getYRot();
							_ent.xRotO = _ent.getXRot();
							if (_ent instanceof LivingEntity _entity) {
								_entity.yBodyRotO = _entity.getYRot();
								_entity.yHeadRotO = _entity.getYRot();
							}
						}
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(ResourceLocation.parse("block.chain.break")), SoundSource.PLAYERS, (float) 0.5,
										(float) (1.25 - entity.getPersistentData().getDouble("spinTimer") / 100));
							} else {
								_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(ResourceLocation.parse("block.chain.break")), SoundSource.PLAYERS, (float) 0.5,
										(float) (1.25 - entity.getPersistentData().getDouble("spinTimer") / 100), false);
							}
						}
					}
				}
				if (entity.getPersistentData().getBoolean("grinding") == false) {
					entity.getPersistentData().putDouble("spinTimer", (entity.getPersistentData().getDouble("spinTimer") + 1));
				}
			} else {
				if (!entity.level().isClientSide())
					entity.discard();
			}
		} else {
			if (!entity.level().isClientSide())
				entity.discard();
		}
	}
}