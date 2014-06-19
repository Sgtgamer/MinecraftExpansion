package com.raoul.minecraftexpension.Handler;

import com.raoul.minecraftexpension.init.BlocksInit;
import com.raoul.minecraftexpension.inventory.Compressor.ContainerCompressor;
import com.raoul.minecraftexpension.inventory.Compressor.GuiCompressor;
import com.raoul.minecraftexpension.inventory.Smelter.ContainerSmelter;
import com.raoul.minecraftexpension.inventory.Workstation.ContainerWorkstation;
import com.raoul.minecraftexpension.inventory.Smelter.GuiSmelter;
import com.raoul.minecraftexpension.inventory.Workstation.GuiWorkstation;

import com.raoul.minecraftexpension.reference.GuiId;
import com.raoul.minecraftexpension.tile_entity.TileEntityCompressor;
import com.raoul.minecraftexpension.tile_entity.TileEntityMESmelter;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler
{
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world,	int x, int y, int z)
    {
        if(ID == GuiId.Smelter)
        {
            TileEntityMESmelter tileentitymesmelter = (TileEntityMESmelter) world.getTileEntity(x, y, z);
            return ID == GuiId.Smelter && world.getBlock(x, y, z) == BlocksInit.Smelter ? new ContainerSmelter(player.inventory, tileentitymesmelter) : null;
        }

        if(ID == GuiId.Compressor)
        {
            TileEntityCompressor tileentitycompressor = (TileEntityCompressor) world.getTileEntity(x, y, z);
            return ID == GuiId.Compressor && world.getBlock(x, y, z) == BlocksInit.Compressor ? new ContainerCompressor(player.inventory, tileentitycompressor) : null;
        }

		if(ID == GuiId.Workstation)
        {
			return ID == GuiId.Workstation && world.getBlock(x, y, z) == BlocksInit.Workstation ? new ContainerWorkstation(player.inventory, world, x, y, z) : null;
		}

		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world,	int x, int y, int z)
	{
        if(ID == GuiId.Smelter)
        {
            TileEntityMESmelter tileentitymesmelter = (TileEntityMESmelter) world.getTileEntity(x, y, z);
            return ID == GuiId.Smelter && world.getBlock(x, y, z) == BlocksInit.Smelter ? new GuiSmelter(player.inventory, tileentitymesmelter): null;
        }

        if(ID == GuiId.Compressor)
        {
            TileEntityCompressor tileentitycompressor = (TileEntityCompressor) world.getTileEntity(x, y, z);
            return ID == GuiId.Compressor && world.getBlock(x, y, z) == BlocksInit.Compressor ? new GuiCompressor(player.inventory, tileentitycompressor): null;
        }

		if(ID == GuiId.Workstation)
        {
			return ID == GuiId.Workstation && world.getBlock(x, y, z) == BlocksInit.Workstation ? new GuiWorkstation(player.inventory, world, x, y, z) : null;
		}

		return null;
	}
}