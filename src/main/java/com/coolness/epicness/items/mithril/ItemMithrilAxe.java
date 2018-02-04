package com.coolness.epicness.items.mithril;

import com.coolness.epicness.MoreMineralsMod;
import com.coolness.epicness.init.Reference;
import com.coolness.epicness.items.ItemModAxe;

import net.minecraft.item.ItemStack;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemMithrilAxe extends ItemModAxe {
	public ItemMithrilAxe(ToolMaterial material){
	    super(material);
		setUnlocalizedName(Reference.RedstoneItems.MITHRIL_AXE.getUnlocalizedName());
		setRegistryName(Reference.RedstoneItems.MITHRIL_AXE.getRegistryName());
		setCreativeTab(MoreMineralsMod.tabMineralsTools);
        this.damageVsEntity = 10f;
        this.attackSpeed = -3f;
	}
	@SideOnly(Side.CLIENT)
	public boolean hasEffect(ItemStack par1ItemStack)
	{
	    return true;
	}
}
