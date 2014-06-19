package com.raoul.minecraftexpension.tools;

import com.raoul.minecraftexpension.creativetab.TabME;

import net.minecraft.item.ItemSword;

public class ToolSword extends ItemSword
{
	public ToolSword(ToolMaterial toolmaterial)
	{
		super(toolmaterial);
		this.setCreativeTab(TabME.Tab_METools);
	}

}
