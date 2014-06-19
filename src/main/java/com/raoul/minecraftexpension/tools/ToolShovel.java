package com.raoul.minecraftexpension.tools;

import com.raoul.minecraftexpension.creativetab.TabME;

import net.minecraft.item.ItemSpade;

public class ToolShovel extends ItemSpade
{

	public ToolShovel(ToolMaterial toolmaterial) 
	{
		super(toolmaterial);
		this.setCreativeTab(TabME.Tab_METools);
	}
	

}
