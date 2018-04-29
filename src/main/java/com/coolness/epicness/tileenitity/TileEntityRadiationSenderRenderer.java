package com.coolness.epicness.tileenitity;

import com.coolness.epicness.init.Reference;
import com.coolness.epicness.models.ModelRadiationSender;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

public class TileEntityRadiationSenderRenderer extends TileEntitySpecialRenderer {
	private static ModelRadiationSender modelBlock = new ModelRadiationSender();
	public static ResourceLocation texture = new ResourceLocation(Reference.MODID, "textures/blocks/lead_block.png");

	protected float rotation;
	
	public void renderTileEntityRadiationSenderAt(TileEntityRadiationSenderRenderer tileEntity, double posX,
			double posY, double posZ, float partialTicks, int damageCount) {
		// Open Matrix
		GlStateManager.pushMatrix();
		// Place the block at X Y Z coordinates
		GlStateManager.translate(posX + 0.5F, posY + 1.5F, posZ + 0.5F);
		// Turn up side down the block
		GlStateManager.rotate(rotation, 1.0F, 0.0F, 0.0F);
		//GlStateManager.rotate(180F, 0.0F, 1.0F, 0.0F);
		//GlStateManager.rotate(90F * tileEntity, 0.0F, 1.0F, 0.0F);
		// Draw the texture
		this.bindTexture(texture);
		// Doing the 3D render
		modelBlock.renderAll();
		// We close Matrix
		GlStateManager.popMatrix();

	}

	@Override
	public void renderTileEntityAt(TileEntity tileEntity, double posX, double posY, double posZ, float partialTicks,
			int damageCount) {
		this.renderTileEntityRadiationSenderAt(this, posX, posY, posZ, partialTicks,
				damageCount);
	}
}
