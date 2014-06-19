package com.raoul.minecraftexpension.tools;

import com.raoul.minecraftexpension.MinecraftExpansion;
import com.raoul.minecraftexpension.creativetab.TabME;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemPickaxe;

public class ToolPickaxe extends ItemPickaxe
{
	public ToolPickaxe(ToolMaterial toolmaterial) 
	{
		super(toolmaterial);
		this.setCreativeTab(TabME.Tab_METools);
	}	
}
