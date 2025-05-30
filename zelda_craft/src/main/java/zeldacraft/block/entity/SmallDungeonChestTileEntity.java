package zeldacraft.block.entity;

import zeldacraft.world.inventory.ChestMenu;

import zeldacraft.init.ZeldaCraftModBlockEntities;

import zeldacraft.block.SmallDungeonChestBlock;

import software.bernie.geckolib.util.GeckoLibUtil;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.core.animation.RawAnimation;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animatable.GeoBlockEntity;

import net.minecraftforge.items.wrapper.SidedInvWrapper;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.capabilities.Capability;

import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.RandomizableContainerBlockEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.WorldlyContainer;
import net.minecraft.world.ContainerHelper;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.network.chat.Component;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.NonNullList;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import javax.annotation.Nullable;

import java.util.stream.IntStream;

import io.netty.buffer.Unpooled;

public class SmallDungeonChestTileEntity extends RandomizableContainerBlockEntity implements GeoBlockEntity, WorldlyContainer {
	private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);
	private NonNullList<ItemStack> stacks = NonNullList.<ItemStack>withSize(46, ItemStack.EMPTY);
	private final LazyOptional<? extends IItemHandler>[] handlers = SidedInvWrapper.create(this, Direction.values());

	public SmallDungeonChestTileEntity(BlockPos pos, BlockState state) {
		super(ZeldaCraftModBlockEntities.SMALL_DUNGEON_CHEST.get(), pos, state);
	}

	private PlayState predicate(AnimationState event) {
		String animationprocedure = ("" + this.getBlockState().getValue(SmallDungeonChestBlock.ANIMATION));
		if (animationprocedure.equals("0")) {
			return event.setAndContinue(RawAnimation.begin().thenLoop(animationprocedure));
		}
		return PlayState.STOP;
	}

	String prevAnim = "0";

	private PlayState procedurePredicate(AnimationState event) {
		String animationprocedure = ("" + this.getBlockState().getValue(SmallDungeonChestBlock.ANIMATION));
		if (!animationprocedure.equals("0") && event.getController().getAnimationState() == AnimationController.State.STOPPED || (!animationprocedure.equals(prevAnim) && !animationprocedure.equals("0"))) {
			if (!animationprocedure.equals(prevAnim))
				event.getController().forceAnimationReset();
			event.getController().setAnimation(RawAnimation.begin().thenPlay(animationprocedure));
			if (event.getController().getAnimationState() == AnimationController.State.STOPPED) {
				if (this.getBlockState().getBlock().getStateDefinition().getProperty("animation") instanceof IntegerProperty _integerProp)
					level.setBlock(this.getBlockPos(), this.getBlockState().setValue(_integerProp, 0), 3);
				event.getController().forceAnimationReset();
			}
		} else if (animationprocedure.equals("0")) {
			prevAnim = "0";
			return PlayState.STOP;
		}
		prevAnim = animationprocedure;
		return PlayState.CONTINUE;
	}

	@Override
	public void registerControllers(AnimatableManager.ControllerRegistrar data) {
		data.add(new AnimationController<SmallDungeonChestTileEntity>(this, "controller", 0, this::predicate));
		data.add(new AnimationController<SmallDungeonChestTileEntity>(this, "procedurecontroller", 0, this::procedurePredicate));
	}

	@Override
	public AnimatableInstanceCache getAnimatableInstanceCache() {
		return this.cache;
	}

	@Override
	public void load(CompoundTag compound) {
		super.load(compound);
		if (!this.tryLoadLootTable(compound))
			this.stacks = NonNullList.withSize(this.getContainerSize(), ItemStack.EMPTY);
		ContainerHelper.loadAllItems(compound, this.stacks);
	}

	@Override
	public void saveAdditional(CompoundTag compound) {
		super.saveAdditional(compound);
		if (!this.trySaveLootTable(compound)) {
			ContainerHelper.saveAllItems(compound, this.stacks);
		}
	}

	@Override
	public ClientboundBlockEntityDataPacket getUpdatePacket() {
		return ClientboundBlockEntityDataPacket.create(this);
	}

	@Override
	public CompoundTag getUpdateTag() {
		return this.saveWithFullMetadata();
	}

	@Override
	public int getContainerSize() {
		return stacks.size();
	}

	@Override
	public boolean isEmpty() {
		for (ItemStack itemstack : this.stacks)
			if (!itemstack.isEmpty())
				return false;
		return true;
	}

	@Override
	public Component getDefaultName() {
		return Component.literal("small_dungeon_chest");
	}

	@Override
	public int getMaxStackSize() {
		return 64;
	}

	@Override
	public AbstractContainerMenu createMenu(int id, Inventory inventory) {
		return new ChestMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(this.worldPosition));
	}

	@Override
	public Component getDisplayName() {
		return Component.literal("Small Chest");
	}

	@Override
	protected NonNullList<ItemStack> getItems() {
		return this.stacks;
	}

	@Override
	protected void setItems(NonNullList<ItemStack> stacks) {
		this.stacks = stacks;
	}

	@Override
	public boolean canPlaceItem(int index, ItemStack stack) {
		return true;
	}

	@Override
	public int[] getSlotsForFace(Direction side) {
		return IntStream.range(0, this.getContainerSize()).toArray();
	}

	@Override
	public boolean canPlaceItemThroughFace(int index, ItemStack stack, @Nullable Direction direction) {
		return this.canPlaceItem(index, stack);
	}

	@Override
	public boolean canTakeItemThroughFace(int index, ItemStack stack, Direction direction) {
		if (index == 0)
			return false;
		if (index == 1)
			return false;
		if (index == 2)
			return false;
		if (index == 3)
			return false;
		if (index == 4)
			return false;
		if (index == 5)
			return false;
		if (index == 6)
			return false;
		if (index == 7)
			return false;
		if (index == 8)
			return false;
		if (index == 9)
			return false;
		if (index == 10)
			return false;
		if (index == 11)
			return false;
		if (index == 12)
			return false;
		if (index == 13)
			return false;
		if (index == 14)
			return false;
		if (index == 15)
			return false;
		if (index == 16)
			return false;
		if (index == 17)
			return false;
		if (index == 18)
			return false;
		if (index == 19)
			return false;
		if (index == 20)
			return false;
		if (index == 21)
			return false;
		if (index == 22)
			return false;
		if (index == 23)
			return false;
		if (index == 24)
			return false;
		if (index == 25)
			return false;
		if (index == 26)
			return false;
		if (index == 28)
			return false;
		if (index == 29)
			return false;
		if (index == 30)
			return false;
		if (index == 31)
			return false;
		if (index == 32)
			return false;
		if (index == 33)
			return false;
		if (index == 34)
			return false;
		if (index == 35)
			return false;
		if (index == 36)
			return false;
		if (index == 37)
			return false;
		if (index == 38)
			return false;
		if (index == 39)
			return false;
		if (index == 40)
			return false;
		if (index == 41)
			return false;
		if (index == 42)
			return false;
		if (index == 43)
			return false;
		if (index == 44)
			return false;
		if (index == 45)
			return false;
		return true;
	}

	@Override
	public <T> LazyOptional<T> getCapability(Capability<T> capability, @Nullable Direction facing) {
		if (!this.remove && facing != null && capability == ForgeCapabilities.ITEM_HANDLER)
			return handlers[facing.ordinal()].cast();
		return super.getCapability(capability, facing);
	}

	@Override
	public void setRemoved() {
		super.setRemoved();
		for (LazyOptional<? extends IItemHandler> handler : handlers)
			handler.invalidate();
	}
}
