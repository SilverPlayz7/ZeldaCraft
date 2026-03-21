package zeldacraft.procedures;

import zeldacraft.init.ZeldaCraftModItems;
import zeldacraft.init.ZeldaCraftModBlocks;

import zeldacraft.ZeldaCraftMod;

import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.GameType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.core.BlockPos;
import net.minecraft.client.Minecraft;

import java.util.Map;

public class LockedBigDungeonDoorOnBlockRightClickedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, BlockState blockstate, Entity entity) {
		if (entity == null)
			return;
		double soundClock = 0;
		soundClock = 0;
		if ((blockstate.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip1 ? blockstate.getValue(_getip1) : -1) == 1) {
			if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == ZeldaCraftModItems.BIG_KEY.get()) {
				if (!(new Object() {
					public boolean checkGamemode(Entity _ent) {
						if (_ent instanceof ServerPlayer _serverPlayer) {
							return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.CREATIVE;
						} else if (_ent.level().isClientSide() && _ent instanceof Player _player) {
							return Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null
									&& Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode() == GameType.CREATIVE;
						}
						return false;
					}
				}.checkGamemode(entity))) {
					if (entity instanceof Player _player) {
						ItemStack _stktoremove = new ItemStack(ZeldaCraftModItems.BIG_KEY.get());
						_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
					}
				}
				{
					int _value = 1;
					BlockPos _pos = BlockPos.containing(x, y, z);
					BlockState _bs = world.getBlockState(_pos);
					if (_bs.getBlock().getStateDefinition().getProperty("animation") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
						world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
				}
				ZeldaCraftMod.queueServerWork(22, () -> {
					if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == blockstate.getBlock()) {
						{
							BlockPos _bp = BlockPos.containing(x, y, z);
							BlockState _bs = (new Object() {
								public BlockState with(BlockState _bs, String _property, int _newValue) {
									Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
									return _prop instanceof IntegerProperty _ip && _prop.getPossibleValues().contains(_newValue) ? _bs.setValue(_ip, _newValue) : _bs;
								}
							}.with(ZeldaCraftModBlocks.LOCKED_BIG_DUNGEON_DOOR.get().defaultBlockState(), "blockstate", 2));
							BlockState _bso = world.getBlockState(_bp);
							for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
								Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
								if (_property != null && _bs.getValue(_property) != null)
									try {
										_bs = _bs.setValue(_property, (Comparable) entry.getValue());
									} catch (Exception e) {
									}
							}
							world.setBlock(_bp, _bs, 3);
						}
					}
				});
			}
		} else if ((blockstate.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip14 ? blockstate.getValue(_getip14) : -1) == 2) {
			if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == ZeldaCraftModItems.BIG_KEY.get()) {
				if (!(new Object() {
					public boolean checkGamemode(Entity _ent) {
						if (_ent instanceof ServerPlayer _serverPlayer) {
							return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.CREATIVE;
						} else if (_ent.level().isClientSide() && _ent instanceof Player _player) {
							return Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null
									&& Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode() == GameType.CREATIVE;
						}
						return false;
					}
				}.checkGamemode(entity))) {
					if (entity instanceof Player _player) {
						ItemStack _stktoremove = new ItemStack(ZeldaCraftModItems.BIG_KEY.get());
						_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
					}
				}
				{
					int _value = 1;
					BlockPos _pos = BlockPos.containing(x, y - 1, z);
					BlockState _bs = world.getBlockState(_pos);
					if (_bs.getBlock().getStateDefinition().getProperty("animation") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
						world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
				}
				ZeldaCraftMod.queueServerWork(22, () -> {
					if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == blockstate.getBlock()) {
						{
							BlockPos _bp = BlockPos.containing(x, y - 1, z);
							BlockState _bs = (new Object() {
								public BlockState with(BlockState _bs, String _property, int _newValue) {
									Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
									return _prop instanceof IntegerProperty _ip && _prop.getPossibleValues().contains(_newValue) ? _bs.setValue(_ip, _newValue) : _bs;
								}
							}.with(ZeldaCraftModBlocks.BIG_DUNGEON_DOOR.get().defaultBlockState(), "blockstate", 0));
							BlockState _bso = world.getBlockState(_bp);
							for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
								Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
								if (_property != null && _bs.getValue(_property) != null)
									try {
										_bs = _bs.setValue(_property, (Comparable) entry.getValue());
									} catch (Exception e) {
									}
							}
							world.setBlock(_bp, _bs, 3);
						}
						{
							BlockPos _bp = BlockPos.containing(x, y, z);
							BlockState _bs = (new Object() {
								public BlockState with(BlockState _bs, String _property, int _newValue) {
									Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty(_property);
									return _prop instanceof IntegerProperty _ip && _prop.getPossibleValues().contains(_newValue) ? _bs.setValue(_ip, _newValue) : _bs;
								}
							}.with(ZeldaCraftModBlocks.BIG_DUNGEON_DOOR.get().defaultBlockState(), "blockstate", 1));
							BlockState _bso = world.getBlockState(_bp);
							for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
								Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
								if (_property != null && _bs.getValue(_property) != null)
									try {
										_bs = _bs.setValue(_property, (Comparable) entry.getValue());
									} catch (Exception e) {
									}
							}
							world.setBlock(_bp, _bs, 3);
						}
					}
				});
			}
		}
	}
}