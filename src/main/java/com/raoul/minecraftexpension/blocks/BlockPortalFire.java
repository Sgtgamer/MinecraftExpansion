package com.raoul.minecraftexpension.blocks;

import com.raoul.minecraftexpension.creativetab.TabME;
import com.raoul.minecraftexpension.init.BlocksInit;
import com.raoul.minecraftexpension.reference.Reference;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;



public class BlockPortalFire extends Block
{
private String texture;

public BlockPortalFire()
{
  super(Material.fire);
  //this.texture = texture;
  //this.setCreativeTab(TabME.Tab_ME);
}

public void registerIcons(IIconRegister iconReg){
  this.blockIcon = iconReg.registerIcon(this.texture);
}

public void onBlockAdded(World par1World, int par2, int par3, int par4){
  if(par1World.provider.dimensionId > Reference.DimensionID ||
par1World.getBlock(par2, par3 - 1, par4) !=
Blocks.glowstone ||
!((BlockMEPortal) BlocksInit.PortalBlock).func_150000_e(par1World, par2, par3, par4)){
   par1World.setBlockToAir(par2, par3, par4);
  }else{
   par1World.scheduleBlockUpdate(par2, par3, par4, this.getBlockById(0), this.tickRate(par1World) + par1World.rand.nextInt(10));
  }
}


}