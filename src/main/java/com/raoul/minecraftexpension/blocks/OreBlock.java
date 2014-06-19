package com.raoul.minecraftexpension.blocks;

import java.util.Random;

import com.raoul.minecraftexpension.creativetab.TabME;
import com.raoul.minecraftexpension.init.BlocksInit;
import com.raoul.minecraftexpension.init.ItemsInit;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class OreBlock extends Block {

	public OreBlock()
	{
		this(Material.rock);
	}

	public OreBlock(Material material)
	{
		super(material);
		this.setCreativeTab(TabME.Tab_ME);
		this.setHardness(2.6F);
		this.setResistance(5.0F);
		this.setStepSound(soundTypePiston);
	}
	@Override
	public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_)
    {
        return this == BlocksInit.RubyOre ? ItemsInit.RoughRuby : (this == BlocksInit.SapphireOre ? ItemsInit.RoughSapphire : (this == BlocksInit.AmethystOre ? ItemsInit.RoughAmethyst : (this == BlocksInit.EmeraldOre ? ItemsInit.RoughEmerald : (this == BlocksInit.MEIronOre ? ItemsInit.IronOreChunk : (this == BlocksInit.MEGoldOre ? ItemsInit.GoldOreChunk : (this == BlocksInit.MEDiamondOre ? ItemsInit.RoughDiamond : Item.getItemFromBlock(this)))))));
    }
	@Override
	public int quantityDropped(Random random)
    {
        if (this == BlocksInit.MEIronOre)
        {
        	return 4 + random.nextInt(4);
        }
        else if (this == BlocksInit.MEGoldOre)
        {
        	return 3 + random.nextInt(3);
        }
        else if (this == BlocksInit.MEDiamondOre)
        {
        	return 2 + random.nextInt(3);
        }
        else if (this == BlocksInit.RubyOre)
        {
        	return 4 + random.nextInt(4);
        }
        else if (this == BlocksInit.SapphireOre)
        {
        	return 4 + random.nextInt(4);
        }
        else if (this == BlocksInit.AmethystOre)
        {
        	return 4 + random.nextInt(4);
        }
        else if (this == BlocksInit.EmeraldOre)
        {
        	return 4 + random.nextInt(4);
        }
		return 0;
    }
}
