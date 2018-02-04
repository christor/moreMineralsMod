package com.coolness.epicness.tileenitity;

import com.coolness.epicness.init.ItemRegistry;
import com.coolness.epicness.init.Reference;

import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.RecipesArmor;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.ItemStackHandler;

public class TileEntityIronFurnace extends TileEntity implements ITickable, ICapabilityProvider {

	private int burnTime;
	private int cookTime;
	private ItemStackHandler handler;

	public TileEntityIronFurnace() {
		this.burnTime = 0;
		this.cookTime = 0;
		this.handler = new ItemStackHandler(4);
	}
	// TileEntityFurnace

	@Override
	public void readFromNBT(NBTTagCompound nbt) {
		this.burnTime = nbt.getInteger("BurnTime");
		this.cookTime = nbt.getInteger("CookTime");
		this.handler.deserializeNBT(nbt.getCompoundTag("ItemStackHandler"));
		super.readFromNBT(nbt);
	}

	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound nbt) {
		nbt.setInteger("BurnTime", this.burnTime);
		nbt.setInteger("CookTime", this.cookTime);
		nbt.setTag("ItemStackHandler", this.handler.serializeNBT());
		return super.writeToNBT(nbt);
	}

	@Override
	public void update() {
		if (this.world != null) {
			if (!this.world.isRemote) {
				// Run From The Client Only
				for (short j = 0; j < IronFurnaceRecipeManager.fuels.length; j++) {
					if (this.handler.getStackInSlot(2).getItem() == IronFurnaceRecipeManager.fuels[j].fuelItem) {
						for (short i = 0; i < IronFurnaceRecipeManager.recipes.length; i++) {

							if (this.handler.getStackInSlot(0).getItem() == IronFurnaceRecipeManager.recipes[i].item1) {
								if (this.handler.getStackInSlot(1)
										.getItem() == IronFurnaceRecipeManager.recipes[i].item2) {

									for (short l = 0; l < IronFurnaceRecipeManager.fuels.length; l++) {
										if (this.handler.getStackInSlot(2)
												.getItem() == IronFurnaceRecipeManager.fuels[l].fuelItem) {
											burnTime++;
											cookTime++;
											if (burnTime > IronFurnaceRecipeManager.fuels[l].burn) {
												if (this.handler.getStackInSlot(2).getCount() == 1) {
													this.handler.setStackInSlot(2, ItemStack.EMPTY);
													burnTime = 0;
													cookTime = 0;
													break;
												} else {
													this.handler.getStackInSlot(2).shrink(1);
													burnTime = 0;
													break;
												}
											}
										}
									}
									if (cookTime > 200) {
										if (this.handler.getStackInSlot(0)
												.getItem() == IronFurnaceRecipeManager.recipes[i].item1) {
											if (this.handler.getStackInSlot(1)
													.getItem() == IronFurnaceRecipeManager.recipes[i].item2) {
												if (this.handler.getStackInSlot(3)
														.getItem() == IronFurnaceRecipeManager.recipes[i].output
																.getItem()) {
													this.handler.setStackInSlot(3,
															new ItemStack(IronFurnaceRecipeManager.recipes[i].output
																	.getItem(),
															(IronFurnaceRecipeManager.recipes[i].output.getCount()
																	+ this.handler.getStackInSlot(3).getCount())));

													// TileEntityFurnace
												} else {
													this.handler.setStackInSlot(3,
															IronFurnaceRecipeManager.recipes[i].output);
												}
												if (this.handler.getStackInSlot(0).getCount() == 1) {
													this.handler.setStackInSlot(0, ItemStack.EMPTY);
												} else {
													this.handler.getStackInSlot(0).shrink(1);
												}
												if (this.handler.getStackInSlot(1).getCount() == 1) {
													this.handler.setStackInSlot(1, ItemStack.EMPTY);
												} else {
													this.handler.getStackInSlot(1).shrink(1);
												}
											}
										}
										cookTime = 0;
									}
								}
							}

							if (this.handler.getStackInSlot(1).getItem() == IronFurnaceRecipeManager.recipes[i].item1) {
								if (this.handler.getStackInSlot(0)
										.getItem() == IronFurnaceRecipeManager.recipes[i].item2) {
									
									

									for (short l = 0; l < IronFurnaceRecipeManager.fuels.length; l++) {
										if (this.handler.getStackInSlot(2)
												.getItem() == IronFurnaceRecipeManager.fuels[l].fuelItem) {
											burnTime++;
											cookTime++;
											if (burnTime > IronFurnaceRecipeManager.fuels[l].burn) {
												if (this.handler.getStackInSlot(2).getCount() == 1) {
													this.handler.setStackInSlot(2, ItemStack.EMPTY);
													burnTime = 0;
													cookTime = 0;
													break;
												} else {
													this.handler.getStackInSlot(2).shrink(1);
													burnTime = 0;
													break;
												}
											}
										}
									}
									if (cookTime > 200) {
										if (this.handler.getStackInSlot(0)
												.getItem() == IronFurnaceRecipeManager.recipes[i].item1) {
											if (this.handler.getStackInSlot(1)
													.getItem() == IronFurnaceRecipeManager.recipes[i].item2) {
												if (this.handler.getStackInSlot(3)
														.getItem() == IronFurnaceRecipeManager.recipes[i].output
																.getItem()) {
													this.handler.setStackInSlot(3,
															new ItemStack(IronFurnaceRecipeManager.recipes[i].output
																	.getItem(),
															(IronFurnaceRecipeManager.recipes[i].output.getCount()
																	+ this.handler.getStackInSlot(3).getCount())));

													// TileEntityFurnace
												} else {
													this.handler.setStackInSlot(3,
															IronFurnaceRecipeManager.recipes[i].output);
												}
												if (this.handler.getStackInSlot(0).getCount() == 1) {
													this.handler.setStackInSlot(0, ItemStack.EMPTY);
												} else {
													this.handler.getStackInSlot(0).shrink(1);
												}
												if (this.handler.getStackInSlot(1).getCount() == 1) {
													this.handler.setStackInSlot(1, ItemStack.EMPTY);
												} else {
													this.handler.getStackInSlot(1).shrink(1);
												}
											}
										}
										cookTime = 0;
									}
								}
							}

						}
					}
				}
			}
		}

	}
	public boolean isBurning()
    {
        return this.burnTime > 0;
    }
	@Override
	public SPacketUpdateTileEntity getUpdatePacket() {
		NBTTagCompound nbt = new NBTTagCompound();
		this.writeToNBT(nbt);
		int metadata = getBlockMetadata();
		return new SPacketUpdateTileEntity(this.pos, metadata, nbt);
	}

	@Override
	public void onDataPacket(NetworkManager net, SPacketUpdateTileEntity pkt) {
		this.readFromNBT(pkt.getNbtCompound());
	}

	@Override
	public NBTTagCompound getUpdateTag() {
		NBTTagCompound nbt = new NBTTagCompound();
		this.writeToNBT(nbt);
		return nbt;
	}

	@Override
	public void handleUpdateTag(NBTTagCompound tag) {
		this.readFromNBT(tag);
	}

	@Override
	public NBTTagCompound getTileData() {
		NBTTagCompound nbt = new NBTTagCompound();
		this.writeToNBT(nbt);
		return nbt;
	}

	@Override
	public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
		if (capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY)
			return (T) this.handler;
		return super.getCapability(capability, facing);
	}

	@Override
	public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
		if (capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY)
			return true;
		return super.hasCapability(capability, facing);
	}
}
