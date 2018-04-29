package com.coolness.epicness.items.other;

import com.coolness.epicness.init.BlockRegistry;
import com.coolness.epicness.init.ItemRegistry;
import com.coolness.epicness.init.Reference;
import com.coolness.epicness.init.Reference.ConcreteTypes;

import net.minecraft.block.Block;
import net.minecraft.block.BlockColored;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class ItemConcrete extends ItemBlock {
	
	public ItemConcrete(Block block) {
		super(block);
		setUnlocalizedName(Reference.RedstoneBlocks.CONCRETE.getUnlocalizedName());
		setRegistryName(Reference.RedstoneBlocks.CONCRETE.getRegistryName());
		setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
		setHasSubtypes(true);
	}
	@Override
	public void getSubItems(Item item, CreativeTabs tab, NonNullList<ItemStack> items) {
		for (int i = 0; i < ConcreteTypes.values().length; i++) {
			items.add(new ItemStack(item, 1, i));
		}
	}

	@Override
	public String getUnlocalizedName(ItemStack stack) {
		for (int i = 0; i < ConcreteTypes.values().length; i++) {
			if (stack.getItemDamage() == i) {
				return this.getUnlocalizedName() + "." + ConcreteTypes.values()[i].getName();
			} else {
				continue;
			}
		}
		return this.getUnlocalizedName() + "." + ConcreteTypes.values()[0].getName();
	}
    public int getMetadata(int damage)
    {
        return damage;
    }
}
