package com.coolness.epicness.client.gui;

import com.coolness.epicness.container.ContainerIronFurnace;
import com.coolness.epicness.init.Reference;
import com.coolness.epicness.tileenitity.TileEntityIronFurnace;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.resources.I18n;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.ResourceLocation;

public class GuiIronFurnace extends GuiContainer{

	private TileEntityIronFurnace te;
	private IInventory playerInv;
	
	public GuiIronFurnace(IInventory playerInv, TileEntityIronFurnace te) {
		super(new ContainerIronFurnace(playerInv, te));
		// GuiFurnace
//		this.xSize = 176;
//		this.ySize = 166;
		this.te = te;
		this.playerInv = playerInv;
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
		GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
		this.mc.getTextureManager().bindTexture(new ResourceLocation(Reference.MODID + ":textures/gui/container/iron_furnace.png"));
		this.drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, this.xSize, this.ySize);
		String s = I18n.format("container.iron_furnace");
		
		this.mc.fontRendererObj.drawString(s, (int)((this.xSize / 2 + this.mc.fontRendererObj.getStringWidth(s) / 2) * 1.5f), 50, 4210752);
		//Draws the iron furnace name in the center on the top of the gui
		this.mc.fontRendererObj.drawString(this.playerInv.getDisplayName().getFormattedText(), 8, 72, 4210752);
		//The player's inventory name
	}

}
