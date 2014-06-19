package com.raoul.minecraftexpension.tools;

import com.raoul.minecraftexpension.creativetab.TabME;

import net.minecraft.item.ItemHoe;

public class ToolHoe extends ItemHoe
{

	public ToolHoe(ToolMaterial toolmaterial)
	{
		super(toolmaterial);
		this.setCreativeTab(TabME.Tab_METools);
	}

}
