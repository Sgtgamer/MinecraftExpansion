package com.raoul.minecraftexpension.inventory.Compressor;

import com.raoul.minecraftexpension.crafting.Recipes.CompressorRecipes;
import com.raoul.minecraftexpension.tile_entity.TileEntityCompressor;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class ContainerCompressor extends Container
{
    private TileEntityCompressor tilecompressor;
    private int lastCookTime;
    private int lastBurnTime;
    private int lastItemBurnTime;

    public ContainerCompressor(InventoryPlayer par1InventoryPlayer, TileEntityCompressor tileentitycompressor)
    {
        this.tilecompressor = tileentitycompressor;
        this.addSlotToContainer(new Slot(tileentitycompressor, 0, 56, 17));
        this.addSlotToContainer(new Slot(tileentitycompressor, 1, 56, 53));
        this.addSlotToContainer(new SlotCompressor(par1InventoryPlayer.player, tileentitycompressor, 2, 116, 35));
        int i;

        for (i = 0; i < 3; ++i)
        {
            for (int j = 0; j < 9; ++j)
            {
                this.addSlotToContainer(new Slot(par1InventoryPlayer, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
            }
        }

        for (i = 0; i < 9; ++i)
        {
            this.addSlotToContainer(new Slot(par1InventoryPlayer, i, 8 + i * 18, 142));
        }
    }


    public void addCraftingToCrafters(ICrafting par1ICrafting)
    {
        super.addCraftingToCrafters(par1ICrafting);
        par1ICrafting.sendProgressBarUpdate(this, 0, this.tilecompressor.compressorCookTime);
        par1ICrafting.sendProgressBarUpdate(this, 1, this.tilecompressor.compressorBurnTime);
        par1ICrafting.sendProgressBarUpdate(this, 2, this.tilecompressor.currentItemBurnTime);
    }

    /**
     * Looks for changes made in the container, sends them to every listener.
     */
    public void detectAndSendChanges()
    {
        super.detectAndSendChanges();

        for (int i = 0; i < this.crafters.size(); ++i)
        {
            ICrafting icrafting = (ICrafting)this.crafters.get(i);

            if (this.lastCookTime != this.tilecompressor.compressorCookTime)
            {
                icrafting.sendProgressBarUpdate(this, 0, this.tilecompressor.compressorCookTime);
            }

            if (this.lastBurnTime != this.tilecompressor.compressorBurnTime)
            {
                icrafting.sendProgressBarUpdate(this, 1, this.tilecompressor.compressorBurnTime);
            }

            if (this.lastItemBurnTime != this.tilecompressor.currentItemBurnTime)
            {
                icrafting.sendProgressBarUpdate(this, 2, this.tilecompressor.currentItemBurnTime);
            }
        }

        this.lastCookTime = this.tilecompressor.compressorCookTime;
        this.lastBurnTime = this.tilecompressor.compressorBurnTime;
        this.lastItemBurnTime = this.tilecompressor.currentItemBurnTime;
    }


    public void updateProgressBar(int par1, int par2)
    {
        if (par1 == 0)
        {
            this.tilecompressor.compressorCookTime = par2;
        }

        if (par1 == 1)
        {
            this.tilecompressor.compressorBurnTime = par2;
        }

        if (par1 == 2)
        {
            this.tilecompressor.currentItemBurnTime = par2;
        }
    }

    public boolean canInteractWith(EntityPlayer par1EntityPlayer)
    {
        return this.tilecompressor.isUseableByPlayer(par1EntityPlayer);
    }

    /**
     * Called when a player shift-clicks on a slot. You must override this or you will crash when someone does that.
     */
    public ItemStack transferStackInSlot(EntityPlayer par1EntityPlayer, int par2)
    {
        ItemStack itemstack = null;
        Slot slot = (Slot)this.inventorySlots.get(par2);

        if (slot != null && slot.getHasStack())
        {
            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();

            if (par2 == 2)
            {
                if (!this.mergeItemStack(itemstack1, 3, 39, true))
                {
                    return null;
                }

                slot.onSlotChange(itemstack1, itemstack);
            }
            else if (par2 != 1 && par2 != 0)
            {
                if (CompressorRecipes.smelting().getSmeltingResult(itemstack1) != null)
                {
                    if (!this.mergeItemStack(itemstack1, 0, 1, false))
                    {
                        return null;
                    }
                }
                else if (TileEntityCompressor.isItemFuel(itemstack1))
                {
                    if (!this.mergeItemStack(itemstack1, 1, 2, false))
                    {
                        return null;
                    }
                }
                else if (par2 >= 3 && par2 < 30)
                {
                    if (!this.mergeItemStack(itemstack1, 30, 39, false))
                    {
                        return null;
                    }
                }
                else if (par2 >= 30 && par2 < 39 && !this.mergeItemStack(itemstack1, 3, 30, false))
                {
                    return null;
                }
            }
            else if (!this.mergeItemStack(itemstack1, 3, 39, false))
            {
                return null;
            }

            if (itemstack1.stackSize == 0)
            {
                slot.putStack((ItemStack)null);
            }
            else
            {
                slot.onSlotChanged();
            }

            if (itemstack1.stackSize == itemstack.stackSize)
            {
                return null;
            }

            slot.onPickupFromSlot(par1EntityPlayer, itemstack1);
        }

        return itemstack;
    }
}