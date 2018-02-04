package com.coolness.epicness.blocks;

import java.util.List;

import com.coolness.epicness.MoreMineralsMod;
import com.coolness.epicness.client.gui.GuiHandler;
import com.coolness.epicness.init.ArmorRegistry;
import com.coolness.epicness.init.BlockRegistry;
import com.coolness.epicness.init.Reference;
import com.coolness.epicness.tileenitity.TileEntityBomb;

import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityFallingBlock;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;

public class BlockBomb extends Block implements ITileEntityProvider {
	/**
	 * Bounding Box From XYZ of first 3 Numbers, to the last 3, changes hitbox
	 * to destroy, and for collisions, return from getBoundingBox
	 */
	// BlockAnvil BlockRedstoneLight
	protected static final AxisAlignedBB X_AXIS_AABB = new AxisAlignedBB(-0.1875D, 0.0D, 0.25D, 1.1875D, 0.5D, 0.75D);

	public BlockBomb() {
		super(Material.IRON);
		setUnlocalizedName(Reference.RedstoneBlocks.BOMB.getUnlocalizedName());
		setRegistryName(Reference.RedstoneBlocks.BOMB.getRegistryName());
		setHardness(20f);
		setHarvestLevel("pickaxe", 3);
		setCreativeTab(BlockRegistry.tabMineralsBlocks);
	}

	@Override
	public TileEntity createTileEntity(World world, IBlockState state) {
		return new TileEntityBomb();
	}

	@Override
	public void breakBlock(World world, BlockPos pos, IBlockState state) {
		TileEntityBomb te = (TileEntityBomb) world.getTileEntity(pos);
		IItemHandler handler = te.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null);
		for (int slot = 0; slot < handler.getSlots() - 1; slot++) {
			ItemStack stack = handler.getStackInSlot(slot);
			InventoryHelper.spawnItemStack(world, pos.getX(), pos.getY(), pos.getZ(), stack);
		}
		super.breakBlock(world, pos, state);
	}

	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return new TileEntityBomb();
	}

	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		return X_AXIS_AABB;
	}

	@Override
	public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced) {
		tooltip.add("§8§oR.I.P Entire World...§r");
		super.addInformation(stack, playerIn, tooltip, advanced);
	}

	@Override
	public boolean canConnectRedstone(IBlockState state, IBlockAccess world, BlockPos pos, EnumFacing side) {
		return true;
	}

	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
			EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		ItemStack handStack = playerIn.getHeldItemMainhand();
		if (handStack.getItem() == Items.FLINT_AND_STEEL) {
			playerIn.sendMessage(new TextComponentString("§o§eA Bomb Is Going Off...§r"));
			int power = worldIn.getTileEntity(pos).getTileData().getInteger("Strength");
			power = (int) Math.round(power * 0.75);
			explode(power, power * 4, pos, worldIn);
			// explode(50, 200, pos, worldIn);
			if (!playerIn.isCreative()) {
				playerIn.addPotionEffect(new PotionEffect(Potion.getPotionById(27), 72000, 255));
			}
			handStack.damageItem(1, playerIn);
		} else {
			if (!worldIn.isRemote) {
				playerIn.openGui(MoreMineralsMod.instance, GuiHandler.BOMB, worldIn, pos.getX(), pos.getY(),
						pos.getZ());
			}
			playerIn.sendStatusMessage(
					new TextComponentString("§o§eYou Must Have A Flint And Steel To Set Off This Bomb...§r"), true);
		}
		return super.onBlockActivated(worldIn, pos, state, playerIn, hand, facing, hitX, hitY, hitZ);

	}

	public void onEntityWalk(World worldIn, BlockPos pos, Entity entityIn) {
		if (!entityIn.isImmuneToFire()) {
			entityIn.attackEntityFrom(MoreMineralsMod.radiation_damage, 5.0F);
		}

		super.onEntityWalk(worldIn, pos, entityIn);
	}

	public boolean isFullCube(IBlockState state) {
		return false;
	}

	/**
	 * Used to determine ambient occlusion and culling when rebuilding chunks
	 * for render
	 */
	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}

	public void explode(int radius, int radiationRadius, BlockPos pos, World worldIn) {
		createSphere(radius, pos, worldIn);
		for (int x = -radiationRadius; x < radiationRadius; x++) {
			for (int y = -radiationRadius; y < radiationRadius; y++) {
				for (int z = -radiationRadius; z < radiationRadius; z++) {
					BlockPos realPos = new BlockPos((pos.getX() + x), (pos.getY() + y), (pos.getZ() + z));
					if (worldIn.getBlockState(realPos).getBlock() == Blocks.LEAVES
							|| worldIn.getBlockState(realPos).getBlock() == Blocks.LEAVES2) {
						worldIn.setBlockToAir(realPos);
					} else if (worldIn.getBlockState(realPos).getBlock() == Blocks.GRASS
							|| worldIn.getBlockState(realPos).getBlock() == Blocks.GRASS_PATH) {
						if (Math.random() > 0.05) {
							worldIn.setBlockState(realPos, Blocks.DIRT.getDefaultState());
						}
					} else if (worldIn.getBlockState(realPos).getBlock() == Blocks.TALLGRASS
							|| worldIn.getBlockState(realPos).getBlock() == Blocks.SNOW_LAYER
							|| worldIn.getBlockState(realPos).getBlock() == Blocks.RED_FLOWER
							|| worldIn.getBlockState(realPos).getBlock() == Blocks.YELLOW_FLOWER
							|| worldIn.getBlockState(realPos).getBlock() == Blocks.WHEAT
							|| worldIn.getBlockState(realPos).getBlock() == Blocks.CARROTS
							|| worldIn.getBlockState(realPos).getBlock() == Blocks.POTATOES
							|| worldIn.getBlockState(realPos).getBlock() == Blocks.BEETROOTS) {
						worldIn.setBlockToAir(realPos);
					}
					if (Math.random() < 0.15) {
						if (!worldIn.isAirBlock(realPos)) {
							worldIn.setBlockState(realPos, BlockRegistry.nuclear_waste.getDefaultState());

						}
					}
				}
			}
		}
		for (short p = 0; p < worldIn.playerEntities.size(); p++) {
			System.out.println("Player Loop Position: " + p);
			EntityPlayer player = worldIn.playerEntities.get(p);
			if (!player.isCreative()) {
				if ((Math.abs(pos.getX()) - Math.abs(player.posX)) < 100
						&& (Math.abs(pos.getZ()) - Math.abs(player.posZ)) < 100
						&& (Math.abs(pos.getY()) - Math.abs(player.posY)) < 100) {
					player.attackEntityFrom(MoreMineralsMod.radiation_damage, (15.0F + ((float) Math.random() * 6)));

					player.addPotionEffect(new PotionEffect(Potion.getPotionById(15), 300, 0));
					player.addPotionEffect(new PotionEffect(Potion.getPotionById(17), 12000, 1));
					player.addPotionEffect(new PotionEffect(Potion.getPotionById(18), 6000, 1));
					player.addPotionEffect(new PotionEffect(Potion.getPotionById(27), 12000, 100));
					player.addPotionEffect(new PotionEffect(Potion.getPotionById(2), 3000, 0));

					ItemStack boots = player.inventory.armorItemInSlot(0);
					ItemStack legs = player.inventory.armorItemInSlot(1);
					ItemStack chest = player.inventory.armorItemInSlot(2);
					ItemStack head = player.inventory.armorItemInSlot(3);
					// Radiation Protective Armor(Lead And Tungsten)
					if (!((boots.getItem() == ArmorRegistry.tungsten_boots
							|| boots.getItem() == ArmorRegistry.lead_boots)
							&& (legs.getItem() == ArmorRegistry.tungsten_leggings
									|| legs.getItem() == ArmorRegistry.lead_leggings)
							&& (chest.getItem() == ArmorRegistry.tungsten_chestplate
									|| chest.getItem() == ArmorRegistry.lead_chestplate)
							&& (head.getItem() == ArmorRegistry.tungsten_helmet
									|| head.getItem() == ArmorRegistry.lead_helmet))) {
						// 19 = poison, 20 = wither, 17 = hunger, 18 =
						// weakness, 2 = slowness
						player.addPotionEffect(new PotionEffect(Potion.getPotionById(17), 12000, 4));
						player.addPotionEffect(new PotionEffect(Potion.getPotionById(18), 12000, 1));
						player.addPotionEffect(new PotionEffect(Potion.getPotionById(19), 1200, 0));
						player.addPotionEffect(new PotionEffect(Potion.getPotionById(20), 600, 0));
						player.addPotionEffect(new PotionEffect(Potion.getPotionById(2), 6000, 1));
					}
				}
			}
		}
	}

	public void createSphere(int r, BlockPos pos, World worldIn) {
		for (int tx = -r; tx < r + 1; tx++) {
			for (int ty = -r; ty < r + 1; ty++) {
				for (int tz = -r; tz < r + 1; tz++) {
					if (Math.sqrt(Math.pow(tx, 2) + Math.pow(ty, 2) + Math.pow(tz, 2)) <= r - 2) {
						worldIn.setBlockToAir(new BlockPos(tx + pos.getX(), ty + pos.getY(), tz + pos.getZ()));
					}
				}
			}
		}
	}

	protected void onStartFalling(EntityFallingBlock fallingEntity) {
		fallingEntity.setHurtEntities(true);
	}

	public void onEndFalling(World worldIn, BlockPos pos) {
		worldIn.playEvent(1031, pos, 0);
	}

	public void onBlockAdded(World worldIn, BlockPos pos, IBlockState state) {
		if (!worldIn.isRemote) {
			if (worldIn.isBlockPowered(pos)) {
				worldIn.setBlockToAir(pos);
				explode(50, 200, pos, worldIn);
			}
		}
	}

	public void neighborChanged(IBlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos) {
		if (!worldIn.isRemote) {
			if (worldIn.isBlockPowered(pos)) {
				worldIn.setBlockToAir(pos);
				explode(50, 200, pos, worldIn);
			}
		}
	}
}
