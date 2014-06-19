package com.raoul.minecraftexpension;

import com.raoul.minecraftexpension.tile_entity.TileEntityCompressor;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.DimensionManager;

import com.raoul.minecraftexpension.tile_entity.TileEntityMESmelter;
import com.raoul.minecraftexpension.Handler.GuiHandler;
import com.raoul.minecraftexpension.init.BlocksInit;
import com.raoul.minecraftexpension.init.ItemsInit;
import com.raoul.minecraftexpension.init.ToolInit;
import com.raoul.minecraftexpension.proxy.CommonProxy;
import com.raoul.minecraftexpension.reference.Reference;
import com.raoul.minecraftexpension.world.BiomeGenBaseME;
import com.raoul.minecraftexpension.world.WorldProviderME;
import com.raoul.minecraftexpension.world.gen.OreGenME;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid = Reference.MODID, name = Reference.NAME, version = Reference.VERSION)
public class MinecraftExpansion
{
	@Mod.Instance
	public static MinecraftExpansion instance = new MinecraftExpansion();
	
	@SidedProxy(clientSide=Reference.CLIENTPROXY, serverSide=Reference.COMMONPROXY)
	public static CommonProxy proxy;
	
	public static final BiomeGenBase me = (new BiomeGenBaseME(50)).setColor(0x000000).setBiomeName("ME");
	OreGenME oregenme = new OreGenME();
	
	private GuiHandler GuiHandler = new GuiHandler();
	
	// Use if you need to handle something before the server has even been created.
	@EventHandler
	public void PreInit(FMLPreInitializationEvent event)
	{
		
	}
	
	// Do your mod setup. Build whatever data structures you care about. Register recipes
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        proxy.registerRenderInformation();
    	ToolInit.Init();
    	BlocksInit.Init();
    	ItemsInit.Init();
    	
    	DimensionManager.registerProviderType(Reference.DimensionID, WorldProviderME.class, false);
    	DimensionManager.registerDimension(Reference.DimensionID, Reference.DimensionID);
    	BiomeDictionary.registerBiomeType(me, Type.PLAINS);
    	BiomeManager.addSpawnBiome(me);
    	GameRegistry.registerWorldGenerator(oregenme, 15);
       	NetworkRegistry.INSTANCE.registerGuiHandler(this, new GuiHandler());
        GameRegistry.registerTileEntity(TileEntityMESmelter.class, "tileentitymesmelter");
        GameRegistry.registerTileEntity(TileEntityCompressor.class, "tileenstitycompressor");
    }
    
    //Handle interaction with other mods, complete your setup based on this.
    public void PostInit(FMLPostInitializationEvent event)
    {
    	
    }
}