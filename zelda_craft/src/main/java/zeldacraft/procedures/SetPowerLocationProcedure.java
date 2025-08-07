package zeldacraft.procedures;

import zeldacraft.init.ZeldaCraftModBlocks;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;

import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionHand;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class SetPowerLocationProcedure {
	@SubscribeEvent
	public static void onRightClickBlock(PlayerInteractEvent.RightClickBlock event) {
		if (event.getHand() != event.getEntity().getUsedItemHand())
			return;
		execute(event, event.getLevel(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ(), event.getLevel().getBlockState(event.getPos()), event.getEntity());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, BlockState blockstate, Entity entity) {
		execute(null, world, x, y, z, blockstate, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, BlockState blockstate, Entity entity) {
		if (entity == null)
			return;
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == ZeldaCraftModBlocks.FLOOR_SWITCH.get().asItem()) {
			if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().getBoolean("haslocation") == false) {
				if (blockstate.getBlock() == ZeldaCraftModBlocks.SHEIKAH_LINK.get()) {
					if ((blockstate.getBlock().getStateDefinition().getProperty("connected") instanceof BooleanProperty _getbp7 && blockstate.getValue(_getbp7)) == false) {
						if (event != null && event.isCancelable()) {
							event.setCanceled(true);
						}
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.chain.place")), SoundSource.NEUTRAL, (float) 0.5,
										(float) Mth.nextDouble(RandomSource.create(), 0.8, 1.2));
							} else {
								_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.chain.place")), SoundSource.NEUTRAL, (float) 0.5, (float) Mth.nextDouble(RandomSource.create(), 0.8, 1.2), false);
							}
						}
						(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().putDouble("OutputX", x);
						(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().putDouble("OutputY", y);
						(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().putDouble("OutputZ", z);
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(
									Component.literal(
											("Output set to " + (("X:" + (new java.text.DecimalFormat("##.##").format((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("OutputX")))) + ""
													+ ((" Y:" + (new java.text.DecimalFormat("##.##").format((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("OutputY")))) + ""
															+ (" Z:" + (new java.text.DecimalFormat("##.##").format((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("OutputZ")))))))),
									true);
						if (entity instanceof LivingEntity _entity)
							_entity.swing(InteractionHand.MAIN_HAND, true);
						(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().putBoolean("haslocation", true);
						{
							BlockPos _pos = BlockPos.containing(x, y, z);
							BlockState _bs = world.getBlockState(_pos);
							if (_bs.getBlock().getStateDefinition().getProperty("connected") instanceof BooleanProperty _booleanProp)
								world.setBlock(_pos, _bs.setValue(_booleanProp, true), 3);
						}
					}
				}
			} else {
				if (entity.isShiftKeyDown()) {
					if (blockstate.getBlock() == ZeldaCraftModBlocks.SHEIKAH_LINK.get()) {
						if ((blockstate.getBlock().getStateDefinition().getProperty("connected") instanceof BooleanProperty _getbp31 && blockstate.getValue(_getbp31)) == false) {
							if (event != null && event.isCancelable()) {
								event.setCanceled(true);
							}
							if (world instanceof Level _level) {
								if (!_level.isClientSide()) {
									_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.chain.place")), SoundSource.NEUTRAL, (float) 0.5,
											(float) Mth.nextDouble(RandomSource.create(), 0.8, 1.2));
								} else {
									_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.chain.place")), SoundSource.NEUTRAL, (float) 0.5, (float) Mth.nextDouble(RandomSource.create(), 0.8, 1.2), false);
								}
							}
							(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().putDouble("OutputX", x);
							(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().putDouble("OutputY", y);
							(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().putDouble("OutputZ", z);
							if (entity instanceof Player _player && !_player.level().isClientSide())
								_player.displayClientMessage(Component.literal(
										("Output set to " + (("X:" + (new java.text.DecimalFormat("##.##").format((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("OutputX")))) + ""
												+ ((" Y:" + (new java.text.DecimalFormat("##.##").format((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("OutputY")))) + ""
														+ (" Z:" + (new java.text.DecimalFormat("##.##").format((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("OutputZ")))))))),
										true);
							if (entity instanceof LivingEntity _entity)
								_entity.swing(InteractionHand.MAIN_HAND, true);
							(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().putBoolean("haslocation", true);
							{
								BlockPos _pos = BlockPos.containing(x, y, z);
								BlockState _bs = world.getBlockState(_pos);
								if (_bs.getBlock().getStateDefinition().getProperty("paired") instanceof BooleanProperty _booleanProp)
									world.setBlock(_pos, _bs.setValue(_booleanProp, true), 3);
							}
						} else {
							if (event != null && event.isCancelable()) {
								event.setCanceled(true);
							}
							if (world instanceof Level _level) {
								if (!_level.isClientSide()) {
									_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.chain.place")), SoundSource.NEUTRAL, (float) 0.5,
											(float) Mth.nextDouble(RandomSource.create(), 0.8, 1.2));
								} else {
									_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.chain.place")), SoundSource.NEUTRAL, (float) 0.5, (float) Mth.nextDouble(RandomSource.create(), 0.8, 1.2), false);
								}
							}
							{
								BlockPos _pos = BlockPos.containing((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("OutputX"),
										(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("OutputY"),
										(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("OutputZ"));
								BlockState _bs = world.getBlockState(_pos);
								if (_bs.getBlock().getStateDefinition().getProperty("paired") instanceof BooleanProperty _booleanProp)
									world.setBlock(_pos, _bs.setValue(_booleanProp, false), 3);
							}
							(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().putDouble("OutputX", x);
							(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().putDouble("OutputY", y);
							(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().putDouble("OutputZ", z);
							if (entity instanceof Player _player && !_player.level().isClientSide())
								_player.displayClientMessage(Component.literal(("Output overridden to "
										+ (("X:" + (new java.text.DecimalFormat("##.##").format((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("OutputX")))) + ""
												+ ((" Y:" + (new java.text.DecimalFormat("##.##").format((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("OutputY")))) + ""
														+ (" Z:" + (new java.text.DecimalFormat("##.##").format((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("OutputZ")))))))),
										true);
							if (entity instanceof LivingEntity _entity)
								_entity.swing(InteractionHand.MAIN_HAND, true);
							(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().putBoolean("haslocation", true);
							{
								BlockPos _pos = BlockPos.containing(x, y, z);
								BlockState _bs = world.getBlockState(_pos);
								if (_bs.getBlock().getStateDefinition().getProperty("paired") instanceof BooleanProperty _booleanProp)
									world.setBlock(_pos, _bs.setValue(_booleanProp, true), 3);
							}
						}
					} else if (blockstate.getBlock() == Blocks.AIR) {
						{
							BlockPos _pos = BlockPos.containing((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("OutputX"),
									(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("OutputY"),
									(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("OutputZ"));
							BlockState _bs = world.getBlockState(_pos);
							if (_bs.getBlock().getStateDefinition().getProperty("paired") instanceof BooleanProperty _booleanProp)
								world.setBlock(_pos, _bs.setValue(_booleanProp, false), 3);
						}
						(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().remove("OutputX");
						(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().remove("OutputY");
						(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().remove("OutputZ");
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("Output location cleared"), true);
					}
				}
			}
		}
	}
}
