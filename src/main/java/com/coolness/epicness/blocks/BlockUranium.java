package com.coolness.epicness.blocks;

import com.coolness.epicness.Elements.RadiationTypes;
import com.coolness.epicness.MoreMineralsMod;
import com.coolness.epicness.init.ArmorRegistry;
import com.coolness.epicness.init.BlockRegistry;
import com.coolness.epicness.init.Reference;
import com.coolness.epicness.radiation.RadiationWorldSavedData;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockUranium extends Block implements BlockRadioactive {
	public BlockUranium() {
		super(Material.IRON);
		setUnlocalizedName(Reference.RedstoneBlocks.URANIUM_BLOCK.getUnlocalizedName());
		setRegistryName(Reference.RedstoneBlocks.URANIUM_BLOCK.getRegistryName());
		setLightLevel(1.0f);
		setHardness(10f);
		setHarvestLevel("pickaxe", 2);
		setCreativeTab(BlockRegistry.tabMineralsBlocks);
	}
	@Override
	public void onBlockAdded(World worldIn, BlockPos pos, IBlockState state) {
		RadiationWorldSavedData data = RadiationWorldSavedData.get(worldIn);
		NBTTagCompound nbt = new NBTTagCompound();
		nbt.setString("Moo", "MOOP");
		data.writeToNBT(nbt);
		data.setDirty(true);
		super.onBlockAdded(worldIn, pos, state);
	}
	@Override
	public void onBlockClicked(World worldIn, BlockPos pos, EntityPlayer playerIn) {
		System.out.println(RadiationWorldSavedData.get(worldIn).serializeNBT().getString("Moo"));
		super.onBlockClicked(worldIn, pos, playerIn);
	}
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
			EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {

		ItemStack handStack = playerIn.getHeldItemMainhand();
		if (handStack.getItem() == Items.FLINT_AND_STEEL) {
			worldIn.setBlockToAir(pos);
			for (byte x = -1; x < 1; x++) {
				for (byte y = -1; y < 1; y++) {
					for (byte z = -1; z < 1; z++) {
						worldIn.createExplosion(playerIn, pos.getX() + (x * 10), pos.getY() + (y * 10),
								pos.getZ() + (z * 10), 100.0f, true);
					}
				}
			}
			for (byte x = -50; x < 50; x++) {
				for (byte y = -50; y < 50; y++) {
					for (byte z = -50; z < 50; z++) {
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
						if (Math.random() < 0.1) {
							if (!worldIn.isAirBlock(realPos)) {
								worldIn.setBlockState(realPos, BlockRegistry.nuclear_waste.getDefaultState());

							}
						}
					}
				}
			}
			for (short p = 0; p < worldIn.playerEntities.size(); p++) {
				System.out.println(p);
				if (!worldIn.playerEntities.get(p).isCreative()) {
					if ((Math.abs(pos.getX()) - Math.abs(worldIn.playerEntities.get(p).posX)) < 100
							&& (Math.abs(pos.getZ()) - Math.abs(worldIn.playerEntities.get(p).posZ)) < 100
							&& (Math.abs(pos.getY()) - Math.abs(worldIn.playerEntities.get(p).posY)) < 100) {
						worldIn.playerEntities.get(p).addPotionEffect(new PotionEffect(Potion.getPotionById(7), 2, 3));
						worldIn.playerEntities.get(p)
								.addPotionEffect(new PotionEffect(Potion.getPotionById(15), 200, 0));
						worldIn.playerEntities.get(p)
								.addPotionEffect(new PotionEffect(Potion.getPotionById(17), 1200, 4));
						worldIn.playerEntities.get(p)
								.addPotionEffect(new PotionEffect(Potion.getPotionById(18), 1200, 1));
						worldIn.playerEntities.get(p)
								.addPotionEffect(new PotionEffect(Potion.getPotionById(27), 36000, 100));

						ItemStack boots = worldIn.playerEntities.get(p).inventory.armorItemInSlot(0);
						ItemStack legs = worldIn.playerEntities.get(p).inventory.armorItemInSlot(1);
						ItemStack chest = worldIn.playerEntities.get(p).inventory.armorItemInSlot(2);
						ItemStack head = worldIn.playerEntities.get(p).inventory.armorItemInSlot(3);
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
							worldIn.playerEntities.get(p)
									.addPotionEffect(new PotionEffect(Potion.getPotionById(19), 600, 0));
							worldIn.playerEntities.get(p)
									.addPotionEffect(new PotionEffect(Potion.getPotionById(20), 300, 0));
							worldIn.playerEntities.get(p)
									.addPotionEffect(new PotionEffect(Potion.getPotionById(17), 1200, 1));
							worldIn.playerEntities.get(p)
									.addPotionEffect(new PotionEffect(Potion.getPotionById(18), 1200, 1));
							worldIn.playerEntities.get(p)
									.addPotionEffect(new PotionEffect(Potion.getPotionById(2), 3000, 1));
						}
					}
				}
			}
			handStack.damageItem(1, playerIn);
		}
		return super.onBlockActivated(worldIn, pos, state, playerIn, hand, facing, hitX, hitY, hitZ);

	}

	public void onEntityWalk(World worldIn, BlockPos pos, Entity entityIn) {
		if (!entityIn.isImmuneToFire() && entityIn instanceof EntityLivingBase
				&& !EnchantmentHelper.hasFrostWalkerEnchantment((EntityLivingBase) entityIn)) {
			entityIn.attackEntityFrom(MoreMineralsMod.radiation_damage, 5.0F);
		}

		super.onEntityWalk(worldIn, pos, entityIn);
	}
	@Override
	public RadiationTypes getType() {
		return RadiationTypes.GAMMA;
	}
}
