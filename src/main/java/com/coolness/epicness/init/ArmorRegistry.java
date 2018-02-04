package com.coolness.epicness.init;

import com.coolness.epicness.items.copper.ItemCopperArmor;
import com.coolness.epicness.items.lead.ItemLeadArmor;
import com.coolness.epicness.items.mithril.ItemMithrilArmor;
import com.coolness.epicness.items.tungsten.ItemTungstenArmor;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ArmorRegistry {
	
	//public static ArmorMaterial Material = EnumHelper.addArmorMaterial(name, textureName, durability, reductionAmounts, enchantability, soundOnEquip, toughness)
	public static ArmorMaterial leadMaterial = EnumHelper.addArmorMaterial("lead", Reference.MODID + ":lead", 12, new int[]{1,3,4,1}, 4, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0f);
	public static ArmorMaterial copperMaterial = EnumHelper.addArmorMaterial("copper", Reference.MODID + ":copper", 26, new int[]{2,5,6,2}, 12, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0f);
	public static ArmorMaterial tungstenMaterial = EnumHelper.addArmorMaterial("tungsten", Reference.MODID + ":tungsten", 45, new int[]{3,6,8,3}, 30, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 1.5f);
	public static ArmorMaterial mithrilMaterial = EnumHelper.addArmorMaterial("mithril", Reference.MODID + ":mithril", 65, new int[]{4,7,9,4}, 50, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 3f);
	
	public static ItemArmor lead_helmet;
	public static ItemArmor lead_chestplate;
	public static ItemArmor lead_leggings;
	public static ItemArmor lead_boots;
	
	public static ItemArmor copper_helmet;
	public static ItemArmor copper_chestplate;
	public static ItemArmor copper_leggings;
	public static ItemArmor copper_boots;
	
	public static ItemArmor tungsten_helmet;
	public static ItemArmor tungsten_chestplate;
	public static ItemArmor tungsten_leggings;
	public static ItemArmor tungsten_boots;
	
	public static ItemArmor mithril_helmet;
	public static ItemArmor mithril_chestplate;
	public static ItemArmor mithril_leggings;
	public static ItemArmor mithril_boots;
	
    public static void init(){
    	lead_helmet = new ItemLeadArmor(leadMaterial, 1, EntityEquipmentSlot.HEAD, "lead_helmet");
    	lead_chestplate = new ItemLeadArmor(leadMaterial, 1, EntityEquipmentSlot.CHEST, "lead_chestplate");
    	lead_leggings = new ItemLeadArmor(leadMaterial, 2, EntityEquipmentSlot.LEGS, "lead_leggings");
    	lead_boots = new ItemLeadArmor(leadMaterial, 1, EntityEquipmentSlot.FEET, "lead_boots");
    	
    	copper_helmet = new ItemCopperArmor(copperMaterial, 1, EntityEquipmentSlot.HEAD, "copper_helmet");
    	copper_chestplate = new ItemCopperArmor(copperMaterial, 1, EntityEquipmentSlot.CHEST, "copper_chestplate");
    	copper_leggings = new ItemCopperArmor(copperMaterial, 2, EntityEquipmentSlot.LEGS, "copper_leggings");
    	copper_boots = new ItemCopperArmor(copperMaterial, 1, EntityEquipmentSlot.FEET, "copper_boots");
    	
    	tungsten_helmet = new ItemTungstenArmor(tungstenMaterial, 1, EntityEquipmentSlot.HEAD, "tungsten_helmet");
    	tungsten_chestplate = new ItemTungstenArmor(tungstenMaterial, 1, EntityEquipmentSlot.CHEST, "tungsten_chestplate");
    	tungsten_leggings = new ItemTungstenArmor(tungstenMaterial, 2, EntityEquipmentSlot.LEGS, "tungsten_leggings");
    	tungsten_boots = new ItemTungstenArmor(tungstenMaterial, 1, EntityEquipmentSlot.FEET, "tungsten_boots");
    	
    	mithril_helmet = new ItemMithrilArmor(mithrilMaterial, 1, EntityEquipmentSlot.HEAD, "mithril_helmet");
    	mithril_chestplate = new ItemMithrilArmor(mithrilMaterial, 1, EntityEquipmentSlot.CHEST, "mithril_chestplate");
    	mithril_leggings = new ItemMithrilArmor(mithrilMaterial, 2, EntityEquipmentSlot.LEGS, "mithril_leggings");
    	mithril_boots = new ItemMithrilArmor(mithrilMaterial, 1, EntityEquipmentSlot.FEET, "mithril_boots");
    	
    	
    }
    public static void register(){
    	GameRegistry.register(lead_helmet);
    	GameRegistry.register(lead_chestplate);
    	GameRegistry.register(lead_leggings);
    	GameRegistry.register(lead_boots);
    	
    	GameRegistry.register(copper_helmet);
    	GameRegistry.register(copper_chestplate);
    	GameRegistry.register(copper_leggings);
    	GameRegistry.register(copper_boots);
    	
    	GameRegistry.register(tungsten_helmet);
    	GameRegistry.register(tungsten_chestplate);
    	GameRegistry.register(tungsten_leggings);
    	GameRegistry.register(tungsten_boots);
    	
    	GameRegistry.register(mithril_helmet);
    	GameRegistry.register(mithril_chestplate);
    	GameRegistry.register(mithril_leggings);
    	GameRegistry.register(mithril_boots);
    }
    public static void registerRenders(){
    	registerRender(lead_helmet);
    	registerRender(lead_chestplate);
    	registerRender(lead_leggings);
    	registerRender(lead_boots);
    	
    	registerRender(copper_helmet);
    	registerRender(copper_chestplate);
    	registerRender(copper_leggings);
    	registerRender(copper_boots);
    	
    	registerRender(tungsten_helmet);
    	registerRender(tungsten_chestplate);
    	registerRender(tungsten_leggings);
    	registerRender(tungsten_boots);
    	
    	registerRender(mithril_helmet);
    	registerRender(mithril_chestplate);
    	registerRender(mithril_leggings);
    	registerRender(mithril_boots);
    }
    private static void registerRender(Item item){
    	Minecraft.getMinecraft().getRenderItem().getItemModelMesher()
    	.register(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
    }
}
