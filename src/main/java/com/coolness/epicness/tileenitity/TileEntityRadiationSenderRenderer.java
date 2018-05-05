package com.coolness.epicness.tileenitity;

import static net.minecraft.client.renderer.GlStateManager.*;

import com.coolness.epicness.init.Reference;
import com.coolness.epicness.models.ModelRadiationSender;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

public class TileEntityRadiationSenderRenderer extends TileEntitySpecialRenderer<TileEntityRadiationSender> {
	private ModelRadiationSender mahModel = new ModelRadiationSender();
	
	@Override
	public void renderTileEntityAt(TileEntityRadiationSender te, double x, double y, double z, float partialTicks,
			int destroyStage) {
		super.renderTileEntityAt(te, x, y, z, partialTicks, destroyStage);
		pushMatrix();
		translate(-x, -y, -z);
		scale(1.0F, -1F, -1F);
		rotate(1,te.serializeNBT().getFloat("rotY"),te.serializeNBT().getFloat("rotX"),0);
		bindTexture(new ResourceLocation(Reference.MODID, "textures/blocks/lead_block.png"));
		mahModel.renderAll();
		popMatrix();
	}
}
