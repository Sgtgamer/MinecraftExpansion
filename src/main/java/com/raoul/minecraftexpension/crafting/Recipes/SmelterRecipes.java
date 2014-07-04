package com.raoul.minecraftexpension.crafting.Recipes;

import com.raoul.minecraftexpension.init.BlocksInit;
import com.raoul.minecraftexpension.init.ItemsInit;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class SmelterRecipes
{
    private static final SmelterRecipes smeltingBase = new SmelterRecipes();

    /** The list of smelting results. */
    private Map smeltingList = new HashMap();
    private Map experienceList = new HashMap();

    /**
     * Used to call methods addSmelting and getSmeltingResult.
     */
    public static SmelterRecipes smelting()
    {
        return smeltingBase;
    }

    //Recipes
    private SmelterRecipes()
    {
        this.Smelting(BlocksInit.MECobble, new ItemStack(BlocksInit.MEStone), 0.2F);
        /*Ores Smelting to Chunks*/
        this.Smelting(BlocksInit.MEIronOre, new ItemStack(ItemsInit.IronOreChunk), 0.5F);
        this.Smelting(BlocksInit.MEGoldOre, new ItemStack(ItemsInit.GoldOreChunk), 0.5F);
        this.Smelting(BlocksInit.RubyOre, new ItemStack(ItemsInit.RoughRuby), 0.6F);
        this.Smelting(BlocksInit.SapphireOre, new ItemStack(ItemsInit.RoughSapphire), 0.6F);
        this.Smelting(BlocksInit.AmethystOre, new ItemStack(ItemsInit.RoughAmethyst), 0.6F);
        this.Smelting(BlocksInit.EmeraldOre, new ItemStack(ItemsInit.RoughEmerald), 0.6F);
        this.Smelting(BlocksInit.MEDiamondOre, new ItemStack(ItemsInit.RoughDiamond), 0.6F);
    }

    public void Smelting(Block block, ItemStack itemstack, float p_151393_3_)
    {
        this.func_151396_a(Item.getItemFromBlock(block), itemstack, p_151393_3_);
    }

    public void func_151396_a(Item item, ItemStack itemstack, float p_151396_3_)
    {
        this.func_151394_a(new ItemStack(item, 1, 32767), itemstack, p_151396_3_);
    }

    public void func_151394_a(ItemStack itemstack, ItemStack p_151394_2_, float p_151394_3_)
    {
        this.smeltingList.put(itemstack, p_151394_2_);
        this.experienceList.put(p_151394_2_, Float.valueOf(p_151394_3_));
    }

    /**
     * Returns the smelting result of an item.
     */
    public ItemStack getSmeltingResult(ItemStack itemstack)
    {
        Iterator iterator = this.smeltingList.entrySet().iterator();
        Map.Entry entry;

        do
        {
            if (!iterator.hasNext())
            {
                return null;
            }

            entry = (Map.Entry)iterator.next();
        }
        while (!this.func_151397_a(itemstack, (ItemStack)entry.getKey()));

        return (ItemStack)entry.getValue();
    }

    private boolean func_151397_a(ItemStack p_151397_1_, ItemStack p_151397_2_)
    {
        return p_151397_2_.getItem() == p_151397_1_.getItem() && (p_151397_2_.getItemDamage() == 32767 || p_151397_2_.getItemDamage() == p_151397_1_.getItemDamage());
    }

    public Map getSmeltingList()
    {
        return this.smeltingList;
    }

    public float func_151398_b(ItemStack itemstack)
    {
        float ret = itemstack.getItem().getSmeltingExperience(itemstack);
        if (ret != -1) return ret;

        Iterator iterator = this.experienceList.entrySet().iterator();
        Map.Entry entry;

        do
        {
            if (!iterator.hasNext())
            {
                return 0.0F;
            }

            entry = (Map.Entry)iterator.next();
        }
        while (!this.func_151397_a(itemstack, (ItemStack)entry.getKey()));

        return ((Float)entry.getValue()).floatValue();
    }
}