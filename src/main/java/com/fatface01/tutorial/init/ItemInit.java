package com.fatface01.tutorial.init;

import com.fatface01.tutorial.Tutorial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.ObjectHolder;

@Mod.EventBusSubscriber(modid = Tutorial.MOD_ID, bus = Bus.MOD)
@ObjectHolder(Tutorial.MOD_ID)
public class ItemInit {
  public static final Item green_apple = null;

  @SubscribeEvent
  public static void RegisterItems(final RegistryEvent.Register<Item> event) {
    event.getRegistry().register(
        new Item(new Item.Properties().group(ItemGroup.FOOD)).setRegistryName("green_apple"));
  }
}
