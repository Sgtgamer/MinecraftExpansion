package com.raoul.minecraftexpension.tools;

import com.raoul.minecraftexpension.creativetab.TabME;

import net.minecraft.item.ItemAxe;

public class ToolAxe extends ItemAxe
{

	public ToolAxe(ToolMaterial toolmaterial)
	{
		super(toolmaterial);
		this.setCreativeTab(TabME.Tab_METools);
	}

}
