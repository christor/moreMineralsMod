package com.coolness.epicness.client.gui;

import com.coolness.epicness.container.ContainerAtomBonder;
import com.coolness.epicness.container.ContainerBomb;
import com.coolness.epicness.container.ContainerIronFurnace;
import com.coolness.epicness.tileenitity.TileEntityAtomBonder;
import com.coolness.epicness.tileenitity.TileEntityBomb;
import com.coolness.epicness.tileenitity.TileEntityIronFurnace;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler{

	public static final int IRON_FURNACE = 0;
	public static final int BOMB = 1;
	public static final int ATOM_BONDER = 2;
	
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		if(ID == IRON_FURNACE){
			return new ContainerIronFurnace(player.inventory, (TileEntityIronFurnace) world.getTileEntity(new BlockPos(x,y,z)));
		}
		if(ID == BOMB){
			return new ContainerBomb(player.inventory, (TileEntityBomb) world.getTileEntity(new BlockPos(x,y,z)));
		}
		if(ID == ATOM_BONDER){
			return new ContainerAtomBonder(player.inventory, (TileEntityAtomBonder) world.getTileEntity(new BlockPos(x,y,z)));
		}
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		if(ID == IRON_FURNACE){
			return new GuiIronFurnace(player.inventory, (TileEntityIronFurnace) world.getTileEntity(new BlockPos(x,y,z)));
		}
		if(ID == BOMB){
			return new GuiBomb(player.inventory, (TileEntityBomb) world.getTileEntity(new BlockPos(x,y,z)));
		}
		if(ID == ATOM_BONDER){
			return new GuiAtomBonder(player.inventory, (TileEntityAtomBonder) world.getTileEntity(new BlockPos(x,y,z)));
		}
		return null;
	}

}
