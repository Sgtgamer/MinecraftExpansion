package com.raoul.minecraftexpension.init;

import com.raoul.minecraftexpension.reference.Reference;
import com.raoul.minecraftexpension.tools.ToolAxe;
import com.raoul.minecraftexpension.tools.ToolHoe;
import com.raoul.minecraftexpension.tools.ToolPickaxe;
import com.raoul.minecraftexpension.tools.ToolShovel;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraftforge.common.util.EnumHelper;

public class ToolInit 
{
	//Tools
	public static Item RubySword;
	public static Item RubyPickaxe;
	public static Item RubyAxe;
	public static Item RubyShovel;
	public static Item RubyHoe;
	
	public static Item SapphireSword;
	public static Item SapphirePickaxe;
	public static Item SapphireAxe;
	public static Item SapphireShovel;
	public static Item SapphireHoe;
	
	public static Item AmethystSword;
	public static Item AmethystPickaxe;
	public static Item AmethystAxe;
	public static Item AmethystShovel;
	public static Item AmethystHoe;
	
	public static Item EmeraldSword;
	public static Item EmeraldPickaxe;
	public static Item EmeraldAxe;
	public static Item EmeraldShovel;
	public static Item EmeraldHoe;
	
	//Tool Material
	static ToolMaterial GemsMaterial = EnumHelper.addToolMaterial("Gems", 2, 1525, 6.0F, 2.0F, 14);
	
	
	public static void Init()
	{
		//Ruby Tools
		RubySword = new ToolPickaxe(GemsMaterial).setUnlocalizedName("rubysword").setTextureName(Reference.MODID + ":" + "rubysword");
		SapphireSword = new ToolPickaxe(GemsMaterial).setUnlocalizedName("sapphiresword").setTextureName(Reference.MODID + ":" + "sapphiresword");
		AmethystSword = new ToolPickaxe(GemsMaterial).setUnlocalizedName("amethystsword").setTextureName(Reference.MODID + ":" + "amethystsword");
		EmeraldSword = new ToolPickaxe(GemsMaterial).setUnlocalizedName("emeraldsword").setTextureName(Reference.MODID + ":" + "emeraldsword");
		
		RubyPickaxe = new ToolPickaxe(GemsMaterial).setUnlocalizedName("rubypickaxe").setTextureName(Reference.MODID + ":" + "rubypickaxe");
		SapphirePickaxe = new ToolPickaxe(GemsMaterial).setUnlocalizedName("sapphirepickaxe").setTextureName(Reference.MODID + ":" + "sapphirepickaxe");
		AmethystPickaxe = new ToolPickaxe(GemsMaterial).setUnlocalizedName("amethystpickaxe").setTextureName(Reference.MODID + ":" + "amethystpickaxe");
		EmeraldPickaxe = new ToolPickaxe(GemsMaterial).setUnlocalizedName("emeraldpickaxe").setTextureName(Reference.MODID + ":" + "emeraldpickaxe");
		
		RubyAxe = new ToolAxe(GemsMaterial).setUnlocalizedName("rubyaxe").setTextureName(Reference.MODID + ":" + "rubyaxe");
		SapphireAxe = new ToolAxe(GemsMaterial).setUnlocalizedName("sapphireaxe").setTextureName(Reference.MODID + ":" + "sapphireaxe");
		AmethystAxe = new ToolAxe(GemsMaterial).setUnlocalizedName("amethystaxe").setTextureName(Reference.MODID + ":" + "amethystaxe");
		EmeraldAxe = new ToolAxe(GemsMaterial).setUnlocalizedName("emeraldaxe").setTextureName(Reference.MODID + ":" + "emeraldaxe");
		
		RubyShovel = new ToolShovel(GemsMaterial).setUnlocalizedName("rubyshovel").setTextureName(Reference.MODID + ":" + "rubyshovel");
		SapphireShovel = new ToolShovel(GemsMaterial).setUnlocalizedName("sapphireshovel").setTextureName(Reference.MODID + ":" + "sapphireshovel");
		AmethystShovel = new ToolShovel(GemsMaterial).setUnlocalizedName("amethystshovel").setTextureName(Reference.MODID + ":" + "amethystshovel");
		EmeraldShovel = new ToolShovel(GemsMaterial).setUnlocalizedName("emeraldshovel").setTextureName(Reference.MODID + ":" + "emeraldshovel");
		
		RubyHoe = new ToolHoe(GemsMaterial).setUnlocalizedName("rubyhoe").setTextureName(Reference.MODID + ":" + "rubyhoe");
		SapphireHoe = new ToolHoe(GemsMaterial).setUnlocalizedName("sapphirehoe").setTextureName(Reference.MODID + ":" + "sapphirehoe");
		AmethystHoe = new ToolHoe(GemsMaterial).setUnlocalizedName("amethysthoe").setTextureName(Reference.MODID + ":" + "amethysthoe");
		EmeraldHoe = new ToolHoe(GemsMaterial).setUnlocalizedName("emeraldhoe").setTextureName(Reference.MODID + ":" + "emeraldhoe");
		
		//GameRegistry
		GameRegistry.registerItem(RubySword, "RubySword");
		GameRegistry.registerItem(RubyPickaxe, "Ruby Pickaxe");
		GameRegistry.registerItem(RubyAxe, "Ruby Axe");
		GameRegistry.registerItem(RubyShovel, "Ruby Shovel");
		GameRegistry.registerItem(RubyHoe, "Ruby Hoe");
		
		GameRegistry.registerItem(SapphireSword, "SapphireSword");
		GameRegistry.registerItem(SapphirePickaxe, "Sapphire Pickaxe");
		GameRegistry.registerItem(SapphireAxe, "Sapphire Axe");
		GameRegistry.registerItem(SapphireShovel, "Sapphire Shovel");
		GameRegistry.registerItem(SapphireHoe, "Sapphire Hoe");
		
		GameRegistry.registerItem(AmethystSword, "AmethystSword");
		GameRegistry.registerItem(AmethystPickaxe, "Amethyst Pickaxe");
		GameRegistry.registerItem(AmethystAxe, "Amethyst Axe");
		GameRegistry.registerItem(AmethystShovel, "Amethyst Shovel");
		GameRegistry.registerItem(AmethystHoe, "Amethyst Hoe");
		
		GameRegistry.registerItem(EmeraldSword, "EmeraldSword");
		GameRegistry.registerItem(EmeraldPickaxe, "Emerald Pickaxe");
		GameRegistry.registerItem(EmeraldAxe, "Emerald Axe");
		GameRegistry.registerItem(EmeraldShovel, "Emerald Shovel");
		GameRegistry.registerItem(EmeraldHoe, "Emerald Hoe");
	}
}
