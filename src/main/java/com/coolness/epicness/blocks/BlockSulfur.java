package com.coolness.epicness.blocks;

import java.util.List;
import java.util.Random;

import com.coolness.epicness.init.BlockRegistry;
import com.coolness.epicness.init.ItemRegistry;
import com.coolness.epicness.init.Reference;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;

public class BlockSulfur extends Block {
	public BlockSulfur() {
		super(Material.IRON);
		setUnlocalizedName(Reference.RedstoneBlocks.SULFUR_BLOCK.getUnlocalizedName());
		setRegistryName(Reference.RedstoneBlocks.SULFUR_BLOCK.getRegistryName());
		setHardness(2f);
		setHarvestLevel("pickaxe", 1);
		setCreativeTab(BlockRegistry.tabMineralsBlocks);
	}
	 public Item getItemDropped(IBlockState state, Random rand, int fortune)
	    {
	        return ItemRegistry.sulfur;
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
	        return 7 + random.nextInt(5);
	    }

	    /**
	     * Spawns this Block's drops into the World as EntityItems.
	     */
	    public void dropBlockAsItemWithChance(World worldIn, BlockPos pos, IBlockState state, float chance, int fortune)
	    {
	        super.dropBlockAsItemWithChance(worldIn, pos, state, chance, fortune);
	    }    
	    
	    protected ItemStack getSilkTouchDrop(IBlockState state)
	    {
	        return new ItemStack(BlockRegistry.sulfur_block);
	    }
		@Override
		public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced) {
			tooltip.add("§c§oSmells Like Rotten Eggs...§r");
			super.addInformation(stack, playerIn, tooltip, advanced);
		}
		
		@Override
		public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
				EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
			
			ItemStack handStack = playerIn.getHeldItemMainhand();
			if(handStack.getItem() == Items.FLINT_AND_STEEL){
				worldIn.createExplosion(playerIn, pos.getX(), pos.getY(), pos.getZ(), 20.0f, true);
				handStack.damageItem(1, playerIn);
			}
			return super.onBlockActivated(worldIn, pos, state, playerIn, hand, facing, hitX, hitY, hitZ);
			
		}
		
		@Override
		public void onBlockExploded(World world, BlockPos pos, Explosion explosion) {
			super.onBlockExploded(world, pos, explosion);
			EntityPlayer player = world.getClosestPlayer(pos.getX(), pos.getY(), pos.getZ(), 30, false);
			world.createExplosion(player, pos.getX(), pos.getY(), pos.getZ(), 15.0f, true);
		}
	
}
