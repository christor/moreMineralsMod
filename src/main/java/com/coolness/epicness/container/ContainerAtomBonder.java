package com.coolness.epicness.container;

import com.coolness.epicness.client.gui.GuiAtomBonder;
import com.coolness.epicness.tileenitity.TileEntityAtomBonder;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;

public class ContainerAtomBonder extends Container {

	private TileEntityAtomBonder te;

	public ContainerAtomBonder(IInventory playerInv, TileEntityAtomBonder tileEntityAtomBinder) {
		this.te = tileEntityAtomBinder;
		IItemHandler handler = tileEntityAtomBinder.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null);
        int xOffset = (GuiAtomBonder.pWidth - GuiAtomBonder.xSize) / 2;
        int yOffset = (GuiAtomBonder.pHeight - GuiAtomBonder.ySize) / 2;
        
		int id = 0;
		for (int i = 0; i < 7; i++) {
			this.addSlotToContainer(new SlotItemHandler(handler, id++, xOffset + 12, yOffset + 17 + i * 18));
			System.out.println("i: " + i + ", id:" + id);
			this.addSlotToContainer(new SlotItemHandler(handler, id++, xOffset + 30, yOffset + 17 + i * 18));
			System.out.println("i: " + i + ", id:" + id);
			this.addSlotToContainer(new SlotItemHandler(handler, id++, xOffset + 48, yOffset + 17 + i * 18));
			System.out.println("i: " + i + ", id:" + id);
			this.addSlotToContainer(new SlotItemHandler(handler, id++, xOffset + 66, yOffset + 17 + i * 18));
			System.out.println("i: " + i + ", id:" + id);
			this.addSlotToContainer(new SlotItemHandler(handler, id++, xOffset + 84, yOffset + 17 + i * 18));
			System.out.println("i: " + i + ", id:" + id);
			this.addSlotToContainer(new SlotItemHandler(handler, id++, xOffset + 102, yOffset + 17 + i * 18));
			System.out.println("i: " + i + ", id:" + id);
			this.addSlotToContainer(new SlotItemHandler(handler, id++, xOffset + 120, yOffset + 17 + i * 18));
			System.out.println("i: " + i + ", id:" + id);
		}
		int xPos = 8;
		int yPos = 163;

		for (int y = 0; y < 3; ++y) {
			for (int x = 0; x < 9; ++x) {
				this.addSlotToContainer(new Slot(playerInv, x + y * 9 + 9, xOffset + xPos + x * 18, yOffset + yPos + y * 18));
			}
		}
		for (int x = 0; x < 9; ++x) {
			this.addSlotToContainer(new Slot(playerInv, x, xOffset + xPos + x * 18, yOffset + yPos + 58));
		}
		this.addSlotToContainer(new SlotItemHandler(handler, id++, 149, 34));
	}

	@Override
	public boolean canInteractWith(EntityPlayer player) {
		return !player.isSpectator();
	}
	@Override
	public ItemStack transferStackInSlot(EntityPlayer playerIn, int fromSlot) {
		IItemHandler handler = te.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null);
	    ItemStack previous = ItemStack.EMPTY;
	    Slot slot = (Slot) this.inventorySlots.get(fromSlot);

	    if (slot != null && slot.getHasStack()) {
	        ItemStack current = slot.getStack();
	        previous = current.copy();

	        if (fromSlot < handler.getSlots()) {
	            // From the block breaker inventory to player's inventory
	            if (!this.mergeItemStack(current, handler.getSlots(), handler.getSlots() + 36, true))
	                return ItemStack.EMPTY;
	        } else {
	            // From the player's inventory to block breaker's inventory
	            if (!this.mergeItemStack(current, 0, handler.getSlots(), false))
	                return ItemStack.EMPTY;
	        }

	        if (current.getCount() == 0) //Use func_190916_E() instead of stackSize 1.11 only 1.11.2 use getCount()
	            slot.putStack(ItemStack.EMPTY); //Use ItemStack.field_190927_a instead of (ItemStack)null for a blank item stack. In 1.11.2 use ItemStack.EMPTY
	        else
	            slot.onSlotChanged();

	        if (current.getCount() == previous.getCount())
	            return null;
	        slot.onTake(playerIn, current);
	    }
	    return previous;
	}
}
