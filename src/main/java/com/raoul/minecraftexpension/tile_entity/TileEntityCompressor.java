package com.raoul.minecraftexpension.tile_entity;

import com.raoul.minecraftexpension.blocks.BlockCompressor;
import com.raoul.minecraftexpension.crafting.Recipes.CompressorRecipes;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;

public class TileEntityCompressor extends TileEntity implements ISidedInventory
{
    private static final int[] slotsTop = new int[] {0};
    private static final int[] slotsBottom = new int[] {2, 1};
    private static final int[] slotsSides = new int[] {1};

    /**
     * The ItemStacks that hold the items currently being used in the compressor
     */
    private ItemStack[] compressorItemStacks = new ItemStack[3];
    /** The number of ticks that the compressor will keep burning */
    public int compressorBurnTime;
    /**
     * The number of ticks that a fresh copy of the currently-burning item would keep the compressor burning for
     */
    public int currentItemBurnTime;
    /** The number of ticks that the current item has been cooking for */
    public int compressorCookTime;
    private String field_145958_o;

    /**
     * Returns the number of slots in the inventory.
     */
    public int getSizeInventory()
    {
        return this.compressorItemStacks.length;
    }

    /**
     * Returns the stack in slot i
     */
    public ItemStack getStackInSlot(int par1)
    {
        return this.compressorItemStacks[par1];
    }

    /**
     * Removes from an inventory slot (first arg) up to a specified number (second arg) of items and returns them in a
     * new stack.
     */
    public ItemStack decrStackSize(int par1, int par2)
    {
        if (this.compressorItemStacks[par1] != null)
        {
            ItemStack itemstack;

            if (this.compressorItemStacks[par1].stackSize <= par2)
            {
                itemstack = this.compressorItemStacks[par1];
                this.compressorItemStacks[par1] = null;
                return itemstack;
            }
            else
            {
                itemstack = this.compressorItemStacks[par1].splitStack(par2);

                if (this.compressorItemStacks[par1].stackSize == 0)
                {
                    this.compressorItemStacks[par1] = null;
                }

                return itemstack;
            }
        }
        else
        {
            return null;
        }
    }

    /**
     * When some containers are closed they call this on each slot, then drop whatever it returns as an EntityItem -
     * like when you close a workbench GUI.
     */
    public ItemStack getStackInSlotOnClosing(int par1)
    {
        if (this.compressorItemStacks[par1] != null)
        {
            ItemStack itemstack = this.compressorItemStacks[par1];
            this.compressorItemStacks[par1] = null;
            return itemstack;
        }
        else
        {
            return null;
        }
    }

    /**
     * Sets the given item stack to the specified slot in the inventory (can be crafting or armor sections).
     */
    public void setInventorySlotContents(int par1, ItemStack par2ItemStack)
    {
        this.compressorItemStacks[par1] = par2ItemStack;

        if (par2ItemStack != null && par2ItemStack.stackSize > this.getInventoryStackLimit())
        {
            par2ItemStack.stackSize = this.getInventoryStackLimit();
        }
    }

    /**
     * Returns the name of the inventory
     */
    public String getInventoryName()
    {
        return this.hasCustomInventoryName() ? this.field_145958_o : "container.compressor";
    }

    /**
     * Returns if the inventory is named
     */
    public boolean hasCustomInventoryName()
    {
        return this.field_145958_o != null && this.field_145958_o.length() > 0;
    }

    public void func_145951_a(String p_145951_1_)
    {
        this.field_145958_o = p_145951_1_;
    }

    public void readFromNBT(NBTTagCompound p_145839_1_)
    {
        super.readFromNBT(p_145839_1_);
        NBTTagList nbttaglist = p_145839_1_.getTagList("Items", 10);
        this.compressorItemStacks = new ItemStack[this.getSizeInventory()];

        for (int i = 0; i < nbttaglist.tagCount(); ++i)
        {
            NBTTagCompound nbttagcompound1 = nbttaglist.getCompoundTagAt(i);
            byte b0 = nbttagcompound1.getByte("Slot");

            if (b0 >= 0 && b0 < this.compressorItemStacks.length)
            {
                this.compressorItemStacks[b0] = ItemStack.loadItemStackFromNBT(nbttagcompound1);
            }
        }

        this.compressorBurnTime = p_145839_1_.getShort("BurnTime");
        this.compressorCookTime = p_145839_1_.getShort("CookTime");
        this.currentItemBurnTime = getItemBurnTime(this.compressorItemStacks[1]);

        if (p_145839_1_.hasKey("CustomName", 8))
        {
            this.field_145958_o = p_145839_1_.getString("CustomName");
        }
    }

    public void writeToNBT(NBTTagCompound p_145841_1_)
    {
        super.writeToNBT(p_145841_1_);
        p_145841_1_.setShort("BurnTime", (short)this.compressorBurnTime);
        p_145841_1_.setShort("CookTime", (short)this.compressorCookTime);
        NBTTagList nbttaglist = new NBTTagList();

        for (int i = 0; i < this.compressorItemStacks.length; ++i)
        {
            if (this.compressorItemStacks[i] != null)
            {
                NBTTagCompound nbttagcompound1 = new NBTTagCompound();
                nbttagcompound1.setByte("Slot", (byte)i);
                this.compressorItemStacks[i].writeToNBT(nbttagcompound1);
                nbttaglist.appendTag(nbttagcompound1);
            }
        }

        p_145841_1_.setTag("Items", nbttaglist);

        if (this.hasCustomInventoryName())
        {
            p_145841_1_.setString("CustomName", this.field_145958_o);
        }
    }

    /**
     * Returns the maximum stack size for a inventory slot.
     */
    public int getInventoryStackLimit()
    {
        return 64;
    }

    /**
     * Returns an integer between 0 and the passed value representing how close the current item is to being completely
     * cooked
     */
    @SideOnly(Side.CLIENT)
    public int getCookProgressScaled(int p_145953_1_)
    {
        return this.compressorCookTime * p_145953_1_ / 200;
    }

    /**
     * Returns an integer between 0 and the passed value representing how much burn time is left on the current fuel
     * item, where 0 means that the item is exhausted and the passed value means that the item is fresh
     */
    @SideOnly(Side.CLIENT)
    public int getBurnTimeRemainingScaled(int p_145955_1_)
    {
        if (this.currentItemBurnTime == 0)
        {
            this.currentItemBurnTime = 200;
        }

        return this.compressorBurnTime * p_145955_1_ / this.currentItemBurnTime;

    }

    /**
     * compressor isBurning
     */
    public boolean isBurning()
    {
        return this.compressorBurnTime > 0;
    }

    public void updateEntity()
    {
        boolean flag = this.compressorBurnTime > 0;
        boolean flag1 = false;

        if (this.compressorBurnTime > 0)
        {
            --this.compressorBurnTime;
        }

        if (!this.worldObj.isRemote)
        {
            if (this.compressorBurnTime == 0 && this.canSmelt())
            {
                this.currentItemBurnTime = this.compressorBurnTime = getItemBurnTime(this.compressorItemStacks[1]);

                if (this.compressorBurnTime > 0)
                {
                    flag1 = true;

                    if (this.compressorItemStacks[1] != null)
                    {
                        --this.compressorItemStacks[1].stackSize;

                        if (this.compressorItemStacks[1].stackSize == 0)
                        {
                            this.compressorItemStacks[1] = compressorItemStacks[1].getItem().getContainerItem(compressorItemStacks[1]);
                        }
                    }
                }
            }

            if (this.isBurning() && this.canSmelt())
            {
                ++this.compressorCookTime;

                if (this.compressorCookTime == 200)
                {
                    this.compressorCookTime = 0;
                    this.smeltItem();
                    flag1 = true;
                }
            }
            else
            {
                this.compressorCookTime = 0;
            }

            if (flag != this.compressorBurnTime > 0)
            {
                flag1 = true;
                BlockCompressor.updateCompressorBlockState(this.compressorBurnTime > 0, this.worldObj, this.xCoord, this.yCoord, this.zCoord);
            }
        }

        if (flag1)
        {
            this.markDirty();
        }
    }

    /**
     * Returns true if the compressor can smelt an item, i.e. has a source item, destination stack isn't full, etc.
     */
    private boolean canSmelt()
    {
        if (this.compressorItemStacks[0] == null)
        {
            return false;
        }
        else
        {
            ItemStack itemstack = CompressorRecipes.smelting().getSmeltingResult(this.compressorItemStacks[0]);
            if (itemstack == null) return false;
            if (this.compressorItemStacks[2] == null) return true;
            if (!this.compressorItemStacks[2].isItemEqual(itemstack)) return false;
            int result = compressorItemStacks[2].stackSize + itemstack.stackSize;
            return result <= getInventoryStackLimit() && result <= this.compressorItemStacks[2].getMaxStackSize(); //Forge BugFix: Make it respect stack sizes properly.
        }
    }

    /**
     * Turn one item from the compressor source stack into the appropriate smelted item in the compressor result stack
     */
    public void smeltItem()
    {
        if (this.canSmelt())
        {
            ItemStack itemstack = CompressorRecipes.smelting().getSmeltingResult(this.compressorItemStacks[0]);

            if (this.compressorItemStacks[2] == null)
            {
                this.compressorItemStacks[2] = itemstack.copy();
            }
            else if (this.compressorItemStacks[2].getItem() == itemstack.getItem())
            {
                this.compressorItemStacks[2].stackSize += itemstack.stackSize; // Forge BugFix: Results may have multiple items
            }

            --this.compressorItemStacks[0].stackSize;

            if (this.compressorItemStacks[0].stackSize <= 0)
            {
                this.compressorItemStacks[0] = null;
            }
        }
    }

    /**
     * Returns the number of ticks that the supplied fuel item will keep the compressor burning, or 0 if the item isn't
     * fuel
     */
    public static int getItemBurnTime(ItemStack p_145952_0_)
    {
        if (p_145952_0_ == null)
        {
            return 0;
        }
        else
        {
            Item item = p_145952_0_.getItem();

            if (item instanceof ItemBlock && Block.getBlockFromItem(item) != Blocks.air)
            {
                Block block = Block.getBlockFromItem(item);

                if (block == Blocks.wooden_slab)
                {
                    return 150;
                }

                if (block.getMaterial() == Material.wood)
                {
                    return 300;
                }

                if (block == Blocks.coal_block)
                {
                    return 16000;
                }
            }

            if (item == Items.stick) return 100;
            if (item == Items.coal) return 1600;
            if (item == Items.lava_bucket) return 20000;
            if (item == Item.getItemFromBlock(Blocks.sapling)) return 100;
            if (item == Items.blaze_rod) return 2400;
            return GameRegistry.getFuelValue(p_145952_0_);
        }
    }

    public static boolean isItemFuel(ItemStack p_145954_0_)
    {
        /**
         * Returns the number of ticks that the supplied fuel item will keep the compressor burning, or 0 if the item isn't
         * fuel
         */
        return getItemBurnTime(p_145954_0_) > 0;
    }

    /**
     * Do not make give this method the name canInteractWith because it clashes with Container
     */
    public boolean isUseableByPlayer(EntityPlayer par1EntityPlayer)
    {
        return this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord) != this ? false : par1EntityPlayer.getDistanceSq((double)this.xCoord + 0.5D, (double)this.yCoord + 0.5D, (double)this.zCoord + 0.5D) <= 64.0D;
    }

    public void openInventory() {}

    public void closeInventory() {}

    /**
     * Returns true if automation is allowed to insert the given stack (ignoring stack size) into the given slot.
     */
    public boolean isItemValidForSlot(int par1, ItemStack par2ItemStack)
    {
        return par1 == 2 ? false : (par1 == 1 ? isItemFuel(par2ItemStack) : true);
    }

    /**
     * Returns an array containing the indices of the slots that can be accessed by automation on the given side of this
     * block.
     */
    public int[] getAccessibleSlotsFromSide(int par1)
    {
        return par1 == 0 ? slotsBottom : (par1 == 1 ? slotsTop : slotsSides);
    }

    /**
     * Returns true if automation can insert the given item in the given slot from the given side. Args: Slot, item,
     * side
     */
    public boolean canInsertItem(int par1, ItemStack par2ItemStack, int par3)
    {
        return this.isItemValidForSlot(par1, par2ItemStack);
    }

    /**
     * Returns true if automation can extract the given item in the given slot from the given side. Args: Slot, item,
     * side
     */
    public boolean canExtractItem(int par1, ItemStack par2ItemStack, int par3)
    {
        return par3 != 0 || par1 != 1 || par2ItemStack.getItem() == Items.bucket;
    }
}