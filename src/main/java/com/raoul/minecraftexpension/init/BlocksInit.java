package com.raoul.minecraftexpension.init;

import net.minecraft.block.Block;

import com.raoul.minecraftexpension.blocks.BlockCobbleStone;
import com.raoul.minecraftexpension.blocks.BlockMEPortal;
import com.raoul.minecraftexpension.blocks.BlockMEStone;
import com.raoul.minecraftexpension.blocks.BlockPortalFire;
import com.raoul.minecraftexpension.blocks.BlockWorkstation;
import com.raoul.minecraftexpension.blocks.BlockSmelter;
import com.raoul.minecraftexpension.blocks.BlockCompressor;
import com.raoul.minecraftexpension.blocks.OreBlock;
import com.raoul.minecraftexpension.reference.Reference;

import cpw.mods.fml.common.registry.GameRegistry;

public class BlocksInit 
{
	public static final Block RubyOre = new OreBlock().setBlockName("rubyore").setBlockTextureName(Reference.MODID + ":" + "rubyore");
	public static final Block SapphireOre = new OreBlock().setBlockName("sapphireore").setBlockTextureName(Reference.MODID + ":" + "sapphireore");
	public static final Block AmethystOre = new OreBlock().setBlockName("amethystore").setBlockTextureName(Reference.MODID + ":" + "amethystore");
	public static final Block EmeraldOre = new OreBlock().setBlockName("emeraldore").setBlockTextureName(Reference.MODID + ":" + "emeraldore");
	
	public static final Block MEStone = new BlockMEStone().setBlockName("blockmestone").setBlockTextureName(Reference.MODID + ":" + "blockmestone");
	public static final Block MECobble = new BlockCobbleStone().setBlockName("blockcobblestone");
	public static final Block MEIronOre = new OreBlock().setBlockName("blockmeironore").setBlockTextureName(Reference.MODID + ":" + "blockmeironore");
	public static final Block MEGoldOre = new OreBlock().setBlockName("blockmegoldore").setBlockTextureName(Reference.MODID + ":" + "blockmegoldore");
	public static final Block MEDiamondOre = new OreBlock().setBlockName("blockmediamondore").setBlockTextureName(Reference.MODID + ":" + "blockmediamondore");
	
	public static final Block PortalBlock = new BlockMEPortal().setBlockName("blockmeportal").setBlockTextureName(Reference.MODID + ":" + "blockmestone");
	public static final Block PortalFire = new BlockPortalFire().setBlockName("blockportalfire");
	
	public static final Block Workstation = new BlockWorkstation().setBlockName("blockworkstation");
    public static final Block Smelter = new BlockSmelter(false).setBlockName("blocksmelter");
    public static final Block Compressor = new BlockCompressor(false).setBlockName("blockcompressor");
	
	public static void Init()
	{		
		GameRegistry.registerBlock(RubyOre, "rubyore");
		GameRegistry.registerBlock(SapphireOre, "sapphireore");
		GameRegistry.registerBlock(AmethystOre, "amerhystore");
		GameRegistry.registerBlock(EmeraldOre, "emeraldore");
		
		GameRegistry.registerBlock(MEStone, "mestone");
		GameRegistry.registerBlock(MECobble, "mecobblestone");
		GameRegistry.registerBlock(MEIronOre, "meironore");
		GameRegistry.registerBlock(MEGoldOre, "megoldore");
		GameRegistry.registerBlock(MEDiamondOre, "mediamondore");
		
		GameRegistry.registerBlock(PortalBlock, "portalblock");
		GameRegistry.registerBlock(PortalFire, "portalfire");
		
		GameRegistry.registerBlock(Workstation, "workstation");
        GameRegistry.registerBlock(Smelter, "smelter");
        GameRegistry.registerBlock(Compressor, "compressor");
	}
}