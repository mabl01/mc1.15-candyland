package com.fatface01.tutorial;

import com.fatface01.tutorial.init.BlockInit;
import com.fatface01.tutorial.init.ItemInit;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.FlowingFluidBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.IForgeRegistry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.stream.Collectors;

// The value here should match an entry in the META-INF/mods.toml file
@Mod("tutorial")
public class Tutorial {

  public static final Logger LOGGER = LogManager.getLogger();
  public static final String MOD_ID = "tutorial";
  public static Tutorial instance;

  public Tutorial() {
    final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
    modEventBus.addListener(this::setup);

    // Register the setup method for modloading
    FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
    // Register the doClientStuff method for modloading
    FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);

    ItemInit.ITEMS.register(modEventBus);
    BlockInit.BLOCKS.register(modEventBus);

    instance = this;
    // Register ourselves for server and other game events we are interested in
    MinecraftForge.EVENT_BUS.register(this);
  }

/*  @SubscribeEvent
  public static void onRegisterItems(final RegistryEvent.Register<Item> event) {
    final IForgeRegistry<Item> registry = event.getRegistry();

    BlockInit.BLOCKS.getEntries().stream()
        //.filter(block -> !(block.get() instanceof FlowingFluidBlock))
        .map(RegistryObject::get).forEach(block -> {
      final Item.Properties properties = new Item.Properties().group(ItemGroup.FOOD);
      final BlockItem blockItem = new BlockItem(block, properties);
      blockItem.setRegistryName(block.getRegistryName());
      registry.register(blockItem);
    });

    LOGGER.debug("Registered BlockItems!");
  }*/

  private void setup(final FMLCommonSetupEvent event) {
  }

  private void doClientStuff(final FMLClientSetupEvent event) {
  }

  // You can use SubscribeEvent and let the Event Bus discover methods to call
  @SubscribeEvent
  public void onServerStarting(FMLServerStartingEvent event) {
  }

  public static final ItemGroup CANDY_LAND = new ItemGroup("candy_land") {
    @Override
    public ItemStack createIcon() {
      return new ItemStack(ItemInit.CANDY_CHUNK.get());
    }
  };
}
