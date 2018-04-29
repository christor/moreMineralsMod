package com.coolness.epicness.client.gui;

import java.io.IOException;

import com.coolness.epicness.container.ContainerAtomBonder;
import com.coolness.epicness.init.Reference;
import com.coolness.epicness.tileenitity.TileEntityAtomBonder;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.resources.I18n;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.ResourceLocation;

public class GuiAtomBonder extends GuiContainer{
	
	public static int xSize;
	public static int ySize;
	
	public static int pWidth;
	public static int pHeight;
	
	private TileEntityAtomBonder te;
	private IInventory playerInv;
	private GuiButton button;
	
	public GuiAtomBonder(IInventory playerInv, TileEntityAtomBonder tileEntityAtomBonder) {
		super(new ContainerAtomBonder(playerInv, tileEntityAtomBonder));
		// GuiFurnace
		this.xSize = 176;
		this.ySize = 245;
		this.te = tileEntityAtomBonder;
		this.playerInv = playerInv;
	}
	@Override
	public void initGui() {
	    this.buttonList.add(this.button = new GuiButton(0, 120, 78, 32, 14, "§lBond§r"));
	}
	@Override
	protected void actionPerformed(GuiButton button) throws IOException {
		if(button == this.button){
			te.craft();
		}
	}
	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
		GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
		this.pHeight = this.height;
		this.pWidth = this.width;
		this.mc.getTextureManager().bindTexture(new ResourceLocation(Reference.MODID + ":textures/gui/container/atom_bonder.png"));
        int i = (this.width - this.xSize) / 2;
        int j = (this.height - this.ySize) / 2;
		this.drawTexturedModalRect(i, j, 0, 0, this.xSize, this.ySize);
		this.drawTexturedModalRect(i, j, 0, 0, this.xSize, this.ySize);
		String s = I18n.format("container.atom_bonder");
		this.mc.fontRendererObj.drawString(s, (int)((this.xSize / 2 + this.mc.fontRendererObj.getStringWidth(s) / 2) * 1.5f), 50, 4210752);
		this.mc.fontRendererObj.drawString(this.playerInv.getDisplayName().getFormattedText(), 8, 72, 4210752);
	}
}
