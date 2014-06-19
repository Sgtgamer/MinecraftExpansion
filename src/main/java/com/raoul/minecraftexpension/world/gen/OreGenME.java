package com.raoul.minecraftexpension.world.gen;

import java.util.Random;

import com.raoul.minecraftexpension.init.BlocksInit;
import com.raoul.minecraftexpension.reference.Reference;
import com.raoul.minecraftexpension.world.WorldGenMinableME;

import cpw.mods.fml.common.IWorldGenerator;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.event.terraingen.OreGenEvent;
import net.minecraftforge.event.terraingen.OreGenEvent.GenerateMinable.EventType;

public class OreGenME implements IWorldGenerator
{
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider)
	{
		switch(world.provider.dimensionId)
		{
		        case -1:
		        				generateNether(world, random, chunkX * 16, chunkZ * 16);
		                        break;
		        case 0:
		        				generateSurface(world, random, chunkX * 16, chunkZ * 16);
		                        break;
		        case 1:
		        				generateEnd(world, random, chunkX * 16, chunkZ * 16);
		                        break;
		        case 2:
			    				generateME(world, random, chunkX * 16, chunkZ * 16);
			                    break;
		        default:
		                        break;
		}
	}
	
	private void generateME(World world, Random random, int x, int z)
	{	
		//TODO Tweak this after first test
		//this.addOreSpawn(block,                 world, random, blockXPos, blockZPos, maxX, maxZ, maxVeinSize, chancesToSpawn, minY, maxY);
		this.addOreSpawn(BlocksInit.RubyOre,      world, random, x, z, 16, 16, 4 + random.nextInt(3), 4, 12, 50);
		this.addOreSpawn(BlocksInit.SapphireOre,  world, random, x, z, 16, 16, 4 + random.nextInt(3), 4, 12, 50);
		this.addOreSpawn(BlocksInit.AmethystOre,  world, random, x, z, 16, 16, 4 + random.nextInt(3), 4, 12, 50);
		this.addOreSpawn(BlocksInit.EmeraldOre,   world, random, x, z, 16, 16, 4 + random.nextInt(3), 4, 12, 50);
		this.addOreSpawn(BlocksInit.MEIronOre,    world, random, x, z, 16, 16, 5 + random.nextInt(4), 4, 8, 55);
		this.addOreSpawn(BlocksInit.MEGoldOre,    world, random, x, z, 16, 16, 4 + random.nextInt(3), 4, 5, 25);
		this.addOreSpawn(BlocksInit.MEDiamondOre, world, random, x, z, 16, 16, 4 + random.nextInt(3), 4, 4, 13);
		this.addOreSpawn(Blocks.coal_ore,         world, random, x, z, 16, 16, 10 + random.nextInt(5), 6, 8, 65);
		this.addOreSpawn(Blocks.redstone_ore,     world, random, x, z, 16, 16, 4 + random.nextInt(3), 4, 5, 16);
	}

	private void generateEnd(World world, Random random, int x, int z)
	{
		
	}

	private void generateSurface(World world, Random random, int x, int z)
	{
		
	}

	private void generateNether(World world, Random random, int x, int z)
	{
		
	}

	/**
     * Adds an Ore Spawn to Minecraft. Simply register all Ores to spawn with this method in your Generation method in your IWorldGeneration extending Class
     *
     * @param The Block to spawn
     * @param The World to spawn in
     * @param A Random object for retrieving random positions within the world to spawn the Block
     * @param An int for passing the X-Coordinate for the Generation method
     * @param An int for passing the Z-Coordinate for the Generation method
     * @param An int for setting the maximum X-Coordinate values for spawning on the X-Axis on a Per-Chunk basis
     * @param An int for setting the maximum Z-Coordinate values for spawning on the Z-Axis on a Per-Chunk basis
     * @param An int for setting the maximum size of a vein
     * @param An int for the Number of chances available for the Block to spawn per-chunk
     * @param An int for the minimum Y-Coordinate height at which this block may spawn
     * @param An int for the maximum Y-Coordinate height at which this block may spawn
     **/	
	public void addOreSpawn(Block block, World world, Random random, int blockXPos, int blockZPos, int maxX, int maxZ, int maxVeinSize, int chancesToSpawn, int minY, int maxY)
	{              
		int maxPossY = minY + (maxY - 1);              
		assert maxY > minY;				          
		assert maxX > 0 && maxX <= 16;            
		assert minY > 0;				
		assert maxY < 256 && maxY > 0;          
		assert maxZ > 0 && maxZ <= 16;                    
		
		int diffBtwnMinMaxY = maxY - minY;              
		for(int x = 0; x < chancesToSpawn; x++)              
		{                     
			int posX = blockXPos + random.nextInt(maxX);                     
			int posY = minY + random.nextInt(diffBtwnMinMaxY);                     
			int posZ = blockZPos + random.nextInt(maxZ);                     
			(new WorldGenMinableME(block , maxVeinSize)).generate(world, random, posX, posY, posZ);             
		}        
	}	
}
