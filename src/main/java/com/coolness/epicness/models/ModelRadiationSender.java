package com.coolness.epicness.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ModelRadiationSender extends ModelBase {
	
	/** Base of the model(bottom) */
	public ModelRenderer base;
	/** Spokes that hold up the barrel*/
	public ModelRenderer spokes;
	/** The barrel */
	public ModelRenderer barrel;

	public ModelRadiationSender() {

		this.base = (new ModelRenderer(this, 0, 19)).setTextureSize(64, 64);
		this.base.addBox(1f, 0f, 1f, 14, 1, 14);
		
		this.base.rotationPointX = 8.0F;
		this.base.rotationPointY = 1.0F;
		this.base.rotationPointZ = 8.0F;
		
		
		this.spokes.addBox(4f, 1f, 5f, 1, 4, 6);
		this.spokes.addBox(11f, 1f, 5f, 1, 4, 6);
		
		this.spokes.rotationPointX = 8.0F;
		this.spokes.rotationPointY = 1.0F;
		this.spokes.rotationPointZ = 8.0F;
		
		
		this.barrel = (new ModelRenderer(this, 0, 19)).setTextureSize(64, 64);
		this.barrel.addBox(5f, 3f, 5f, 6, 13, 6);
		
		this.barrel.rotationPointX = 8.0F;
		this.barrel.rotationPointY = 3.0F;
		this.barrel.rotationPointZ = 8.0F;
	}

	/**
	 * This method renders out all parts of the model.
	 */
	public void renderAll() {
		this.base.render(0.0625F);
		this.spokes.render(0.0625F);
		this.barrel.render(0.0625F);
	}
}