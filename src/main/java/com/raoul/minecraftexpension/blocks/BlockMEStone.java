package com.raoul.minecraftexpension.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;

import com.raoul.minecraftexpension.creativetab.TabME;
import com.raoul.minecraftexpension.init.ItemsInit;

public class BlockMEStone extends Block
{
	public BlockMEStone()
	{
		super(Material.rock);
		this.setHardness(1.5F);
		this.setResistance(6.0F);
		this.setStepSound(soundTypeStone);
		this.setHarvestLevel("pickaxe", 2);
		this.setCreativeTab(TabME.Tab_ME);
	}
	@Override
	public Item getItemDropped(int i, Random rand, int j)
    {
        return ItemsInit.StoneChunk;
    }
	
	@Override
	public int quantityDropped(Random random)
    {
        return 3 + random.nextInt(3);
    }
}