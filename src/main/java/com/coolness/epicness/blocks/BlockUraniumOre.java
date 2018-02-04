package com.coolness.epicness.blocks;

import java.util.List;
import java.util.Random;

import com.coolness.epicness.MoreMineralsMod;
import com.coolness.epicness.init.ArmorRegistry;
import com.coolness.epicness.init.BlockRegistry;
import com.coolness.epicness.init.ItemRegistry;
import com.coolness.epicness.init.Reference;

import net.minecraft.block.BlockOre;
import net.minecraft.block.state.IBlockState;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;

public class BlockUraniumOre extends BlockOre {
	public BlockUraniumOre() {
		super();
		setUnlocalizedName(Reference.RedstoneBlocks.URANIUM_ORE.getUnlocalizedName());
		setRegistryName(Reference.RedstoneBlocks.URANIUM_ORE.getRegistryName());
		setLightLevel(0.2f);
		setHardness(3f);
		setHarvestLevel("pickaxe", 2);
		setCreativeTab(BlockRegistry.tabMineralsBlocks);
	}
	 public Item getItemDropped(IBlockState state, Random rand, int fortune)
	    {
	        return ItemRegistry.uranium;
	    }

	    /**
	     * Get the quantity dropped based on the given fortune level
	     */
	    public int quantityDroppedWithBonus(int fortune, Random random)
	    {
	        return this.quantityDropped(random) + random.nextInt(fortune + 1);
	    }

	    /**
	     * Returns the quantity of items to drop on block destruction.
	     */
	    public int quantityDropped(Random random)
	    {
	        return 1 + random.nextInt(2);
	    }

	    /**
	     * Spawns this Block's drops into the World as EntityItems.
	     */
	    public void dropBlockAsItemWithChance(World worldIn, BlockPos pos, IBlockState state, float chance, int fortune)
	    {
	        super.dropBlockAsItemWithChance(worldIn, pos, state, chance, fortune);
	    }

	    @Override
	    public int getExpDrop(IBlockState state, net.minecraft.world.IBlockAccess world, BlockPos pos, int fortune)
	    {
	        if (this.getItemDropped(state, RANDOM, fortune) != Item.getItemFromBlock(this))
	        {
	            return 3 + RANDOM.nextInt(4);
	        }
	        return 0;
	    }    
	    
	    protected ItemStack getSilkTouchDrop(IBlockState state)
	    {
	        return new ItemStack(BlockRegistry.uranium_ore);
	    }
		
		@Override
		public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
				EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
			
			ItemStack handStack = playerIn.getHeldItemMainhand();
			if(handStack.getItem() == Items.FLINT_AND_STEEL){
				worldIn.setBlockToAir(pos);
				worldIn.createExplosion(playerIn, pos.getX(), pos.getY(), pos.getZ(), 300.0f, true);
				handStack.damageItem(1, playerIn);
			}
			return super.onBlockActivated(worldIn, pos, state, playerIn, hand, facing, hitX, hitY, hitZ);
			
		}
		
		@Override
		public void onBlockExploded(World world, BlockPos pos, Explosion explosion) {
			super.onBlockExploded(world, pos, explosion);
			EntityPlayer player = world.getClosestPlayer(pos.getX(), pos.getY(), pos.getZ(), 30, false);
			world.createExplosion(player, pos.getX(), pos.getY(), pos.getZ(), 150.0f, true);
		}
		public void onEntityWalk(World worldIn, BlockPos pos, Entity entityIn) {
			if (!entityIn.isImmuneToFire() && entityIn instanceof EntityLivingBase
					&& !EnchantmentHelper.hasFrostWalkerEnchantment((EntityLivingBase) entityIn)) {
				entityIn.attackEntityFrom(MoreMineralsMod.radiation_damage, 2.0F);
			}

			super.onEntityWalk(worldIn, pos, entityIn);
		}
}
