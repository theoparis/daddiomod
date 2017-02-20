package me.creepinson.Main;

import me.creepinson.entities.TileEntityMobChamber;
import me.creepinson.handlers.BlockHandler;
import me.creepinson.handlers.CraftingHandler;
import me.creepinson.handlers.ItemHandler;
import me.creepinson.lib.IProxy;
import me.creepinson.lib.RefStrings;
import me.creepinson.packet.CustomPacket;
import me.creepinson.packet.CustomPacketHandler;
import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;

public class CommonProxy implements IProxy{

	@Override
	public void preInit() {
		BlockHandler.init();
		  BlockHandler.register();

		 ItemHandler.init();
		  ItemHandler.register();
		  
	}
	public static final SimpleNetworkWrapper INSTANCE = NetworkRegistry.INSTANCE.newSimpleChannel("meepersplus");
	
	@Override
	public void init() {
	
		GameRegistry.registerTileEntity(TileEntityMobChamber.class, RefStrings.MODID + ":"+ "mobchamber");
		
		INSTANCE.registerMessage(CustomPacketHandler.class, CustomPacket.class, 0, Side.SERVER);
		
		
	}

	@Override
	public void postInit() {
		
	CraftingHandler.init();
		
	}
	
	public static void registerModelBakeryVarients(){

	
}
}