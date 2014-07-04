package com.raoul.minecraftexpension.init;

import com.raoul.minecraftexpension.items.ItemChunk;
import com.raoul.minecraftexpension.items.ItemPortalplacer;
import com.raoul.minecraftexpension.reference.Reference;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.item.Item;

public class ItemsInit
{
	//TODO Make a Recipe for the Item Chunks into Cobblestone
	//TODO Make a Recipe for the Ore Chunks In to Ingots
	
	public static Item StoneChunk = new ItemChunk().setUnlocalizedName("stonechunk").setTextureName(Reference.MODID + ":" + "stonechunk1");
	public static Item IronOreChunk = new ItemChunk().setUnlocalizedName("ironorechunk").setTextureName(Reference.MODID + ":" + "ironorechunk");
	public static Item GoldOreChunk = new ItemChunk().setUnlocalizedName("goldorechunk").setTextureName(Reference.MODID + ":" + "goldorechunk");
	
	public static Item RoughDiamond  = new ItemChunk().setUnlocalizedName("roughdiamond").setTextureName(Reference.MODID + ":" + "roughdiamond");
	public static Item RoughRuby = new ItemChunk().setUnlocalizedName("roughruby").setTextureName(Reference.MODID + ":" + "roughruby");
	public static Item RoughSapphire = new ItemChunk().setUnlocalizedName("roughsapphire").setTextureName(Reference.MODID + ":" + "roughsapphire"); 
	public static Item RoughAmethyst = new ItemChunk().setUnlocalizedName("roughamethyst").setTextureName(Reference.MODID + ":" + "roughamethyst");
	public static Item RoughEmerald = new ItemChunk().setUnlocalizedName("roughemerald").setTextureName(Reference.MODID + ":" + "roughemerald");
	
	//TODO Give A texture To This Item
	public static Item PortalPlacer = new ItemPortalplacer().setUnlocalizedName("portalplacer");
	
	
	public static void Init()
	{
		GameRegistry.registerItem(StoneChunk, "stonechunk");
		GameRegistry.registerItem(IronOreChunk, "ironorechunk");
		GameRegistry.registerItem(GoldOreChunk, "goldorechunk");
		GameRegistry.registerItem(RoughDiamond, "roughdiamond");
		GameRegistry.registerItem(RoughRuby, "roughruby");
		GameRegistry.registerItem(RoughSapphire, "roughsapphire");
		GameRegistry.registerItem(RoughAmethyst, "roughamethyst");
		GameRegistry.registerItem(RoughEmerald, "roughemerald");
		//TODO GIVE a Name in .Lang File
		GameRegistry.registerItem(PortalPlacer, "portalplacer");
		
	}

}
