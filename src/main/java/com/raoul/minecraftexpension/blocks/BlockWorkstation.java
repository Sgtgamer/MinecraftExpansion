package com.raoul.minecraftexpension.blocks;

import com.raoul.minecraftexpension.MinecraftExpansion;
import com.raoul.minecraftexpension.creativetab.TabME;
import com.raoul.minecraftexpension.reference.GuiId;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class BlockWorkstation extends Block
{
	public BlockWorkstation()
	{
		super(Material.wood);
		this.setCreativeTab(TabME.Tab_ME);
	}

/**
 * Called upon block activation (right click on the block.)
 */
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int p_149727_6_, float p_149727_7_, float p_149727_8_, float p_149727_9_)
	{
		if (!player.isSneaking()) {
			player.openGui(MinecraftExpansion.instance, GuiId.Workstation, world, x, y, z);
			return true;
		}
		else
		{
			return false;
		}
	}
}
