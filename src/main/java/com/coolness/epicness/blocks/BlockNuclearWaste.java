package com.coolness.epicness.blocks;

import java.util.Random;

import com.coolness.epicness.MoreMineralsMod;
import com.coolness.epicness.init.ArmorRegistry;
import com.coolness.epicness.init.BlockRegistry;
import com.coolness.epicness.init.ItemRegistry;
import com.coolness.epicness.init.Reference;

import net.minecraft.block.Block;
import net.minecraft.block.BlockMagma;
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
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockNuclearWaste extends Block {
	public BlockNuclearWaste() {
		super(Material.CRAFTED_SNOW);
		setUnlocalizedName(Reference.RedstoneBlocks.NUCLEAR_WASTE.getUnlocalizedName());
		setRegistryName(Reference.RedstoneBlocks.NUCLEAR_WASTE.getRegistryName());
		setHardness(0.1f);
		setHarvestLevel("shovel", 0);
		setSoundType(SoundType.SNOW);
		setCreativeTab(BlockRegistry.tabMineralsBlocks);
		setResistance(0.1f);
	}

	/**
	 * Returns the items to drop on block destruction.
	 */
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		return ItemRegistry.uranium;
	}

	/**
	 * Returns the quantity of items to drop on block destruction.
	 */
	public int quantityDropped(Random random) {
		if (Math.random() < 0.05) {
			return 1;
		}
		return 0;
	}

	/**
	 * Spawns this Block's drops into the World as EntityItems.
	 */
	public void dropBlockAsItemWithChance(World worldIn, BlockPos pos, IBlockState state, float chance, int fortune) {
		super.dropBlockAsItemWithChance(worldIn, pos, state, chance, fortune);
	}

	protected ItemStack getSilkTouchDrop(IBlockState state) {
		return new ItemStack(BlockRegistry.nuclear_waste);
	}

	public void onEntityWalk(World worldIn, BlockPos pos, Entity entityIn) {
		if (!entityIn.isImmuneToFire() && entityIn instanceof EntityLivingBase
				&& !EnchantmentHelper.hasFrostWalkerEnchantment((EntityLivingBase) entityIn)) {
			entityIn.attackEntityFrom(MoreMineralsMod.radiation_damage, 2.0F);
		}

		super.onEntityWalk(worldIn, pos, entityIn);
	}

	public boolean canEntitySpawn() {
		return false;
	}
}
