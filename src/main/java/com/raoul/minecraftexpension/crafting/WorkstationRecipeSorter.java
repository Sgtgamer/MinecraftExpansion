package com.raoul.minecraftexpension.crafting;

import java.util.Comparator;

import net.minecraft.item.crafting.IRecipe;

import com.raoul.minecraftexpension.craftmanagers.WorkstationCraftingManager;

public class WorkstationRecipeSorter implements Comparator
{
		final WorkstationCraftingManager workstation;

		public WorkstationRecipeSorter(WorkstationCraftingManager workstationCraftingManager)
		{
			this.workstation = workstationCraftingManager;
		}

		public int compareRecipes(IRecipe irecipe1, IRecipe irecipe2)
		{
			return irecipe1 instanceof WorkstationShapelessRecipes && irecipe2 instanceof WorkstationShapedRecipes ? 1: (irecipe2 instanceof WorkstationShapelessRecipes && irecipe1 instanceof WorkstationShapedRecipes ? -1 : (irecipe2.getRecipeSize() < irecipe1.getRecipeSize() ? -1 : (irecipe2.getRecipeSize() > irecipe1.getRecipeSize() ? 1 : 0)));
		}

		@Override
		public int compare(Object o1, Object o2)
		{
			return this.compareRecipes((IRecipe)o1, (IRecipe)o2);
		}
}

