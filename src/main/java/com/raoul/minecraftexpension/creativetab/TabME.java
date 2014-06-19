package com.raoul.minecraftexpension.creativetab;

import com.raoul.minecraftexpension.init.ToolInit;
import com.raoul.minecraftexpension.reference.Reference;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

public class TabME
{
	public static final CreativeTabs Tab_ME = new CreativeTabs(Reference.MODID)
	{
		@Override
	    public Item getTabIconItem()
		{
			return Items.compass;
	    }

	    @Override
	    @SideOnly(Side.CLIENT)
	    public String getTranslatedTabLabel()
        {
	    	return "Minecraft Expansion";
	    }   
	};
	
	public static final CreativeTabs Tab_METools = new CreativeTabs(Reference.MODID)
	{
		@Override
	    public Item getTabIconItem()
		{
			return ToolInit.RubyPickaxe;
	    }

	    @Override
	    @SideOnly(Side.CLIENT)
	    public String getTranslatedTabLabel()
        {
	    	return "Minecraft Expansion Tools";
	    }   
	};
}
