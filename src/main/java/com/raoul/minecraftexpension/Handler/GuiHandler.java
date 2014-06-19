package com.raoul.minecraftexpension.Handler;

import com.raoul.minecraftexpension.init.BlocksInit;
import com.raoul.minecraftexpension.inventory.ContainerSmelter;
import com.raoul.minecraftexpension.inventory.ContainerWorkstation;
import com.raoul.minecraftexpension.inventory.GuiSmelter;
import com.raoul.minecraftexpension.inventory.GuiWorkstation;

import com.raoul.minecraftexpension.reference.GuiId;
import com.raoul.minecraftexpension.tile_entity.TileEntityMESmelter;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler
{
    /*
    @Override
    public Object getServerGuiElement(int id, EntityPlayer player, World world, int x, int y, int z)
    {
        TileEntity TE = world.getTileEntity(x, y, z);
        switch(id)
        {
            case 1: return new ContainerSmelter(player.inventory, (TileEntityMESmelter) TE);

            case 2: return new ContainerWorkstation(player.inventory, world, x, y, z);
        }
        return null;
    }

    @Override
    public Object getClientGuiElement(int id, EntityPlayer player, World world, int x, int y, int z)
    {
        TileEntity TE = world.getTileEntity(x, y, z);
        switch(id)
        {
            case 1: return new GuiSmelter(player.inventory, (TileEntityMESmelter) TE);

            case 2: return new GuiWorkstation(player.inventory, world, x, y, z);
        }
        return null;
    }*/

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world,	int x, int y, int z)
    {
        if(ID == GuiId.Smelter)
        {
            TileEntityMESmelter tileentitymesmelter = (TileEntityMESmelter) world.getTileEntity(x, y, z);
            return ID == GuiId.Smelter && world.getBlock(x, y, z) == BlocksInit.Smelter ? new ContainerSmelter(player.inventory, tileentitymesmelter) : null;
        }
        //if(ID == GuiId.Smelter)
        //{
        //    TileEntityMESmelter tileentitymesmelter = (TileEntityMESmelter) world.getTileEntity(x, y, z);
        //    return new ContainerSmelter(player.inventory, tileentitymesmelter);
        //}
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
        //if(ID == GuiId.Smelter)
        //{
        //    TileEntityMESmelter tileentitymesmelter = (TileEntityMESmelter) world.getTileEntity(x, y, z);
        //    return new GuiSmelter(player.inventory, tileentitymesmelter);
        //}

		if(ID == GuiId.Workstation)
        {
			return ID == GuiId.Workstation && world.getBlock(x, y, z) == BlocksInit.Workstation ? new GuiWorkstation(player.inventory, world, x, y, z) : null;
		}

		return null;
	}
}