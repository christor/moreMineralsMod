package com.coolness.epicness.blocks;

import java.util.Random;

import com.coolness.epicness.MoreMineralsMod;
import com.coolness.epicness.init.ArmorRegistry;
import com.coolness.epicness.init.BlockRegistry;
import com.coolness.epicness.init.ItemRegistry;
import com.coolness.epicness.init.Reference;
import com.coolness.epicness.tileenitity.TileEntityRadiationSenderRenderer;

import net.minecraft.block.Block;
import net.minecraft.block.BlockMagma;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockRadiationSender extends Block {
	public BlockRadiationSender() {
		super(Material.IRON);
		setUnlocalizedName(Reference.RedstoneBlocks.RADIATION_SENDER.getUnlocalizedName());
		setRegistryName(Reference.RedstoneBlocks.RADIATION_SENDER.getRegistryName());
		setHardness(4f);
		setHarvestLevel("pickaxe", 2);
		setSoundType(SoundType.METAL);
		setCreativeTab(BlockRegistry.tabMineralsBlocks);
		setResistance(5f);
	}
}
