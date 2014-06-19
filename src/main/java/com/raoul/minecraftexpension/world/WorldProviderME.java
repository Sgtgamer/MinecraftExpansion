package com.raoul.minecraftexpension.world;

import com.raoul.minecraftexpension.MinecraftExpansion;
import com.raoul.minecraftexpension.reference.Reference;

import net.minecraft.world.WorldProvider;
import net.minecraft.world.WorldProviderEnd;
import net.minecraft.world.WorldProviderHell;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.WorldChunkManager;
import net.minecraft.world.biome.WorldChunkManagerHell;
import net.minecraft.world.chunk.IChunkProvider;

public class WorldProviderME extends WorldProvider
{
	@Override
	public void registerWorldChunkManager()
	{
		this.worldChunkMgr = new WorldChunkManagerHell(MinecraftExpansion.me, 0.1F);
		this.isHellWorld = false;
		this.hasNoSky = false;
	}

	public IChunkProvider createChunkGenerator()
	{        
		return new ChunkProviderME(worldObj, worldObj.getSeed(), true);
	}
	
	/**
     * A message to display to the user when they transfer to this dimension.
     *
     * @return The message to be displayed
     */
	@Override
    public String getWelcomeMessage()
    {
        if (this instanceof WorldProviderME)
        {
            return "Entering MC 2.0";
        }
        return null;
    }

    /**
     * A Message to display to the user when they transfer out of this dismension.
     *
     * @return The message to be displayed
     */
    @Override
    public String getDepartMessage()
    {
        if (this instanceof WorldProviderME)
        {
            return "Leaving MC 2.0";
        } 
        return null;
    }
    
    /**
     * True if the player can respawn in this dimension (true = overworld, false = nether).
     */
    @Override
    public boolean canRespawnHere()
    {
        return true;
    }
	
	@Override
	public String getDimensionName() 
	{		
		return "Minecraft Expension";
	}
 }
