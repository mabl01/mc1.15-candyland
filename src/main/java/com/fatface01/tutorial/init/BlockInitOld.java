package com.fatface01.tutorial.init;

import com.fatface01.tutorial.Tutorial;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;

import net.minecraft.item.ItemGroup;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.ObjectHolder;

//@Mod.EventBusSubscriber(modid = Tutorial.MOD_ID, bus = Bus.MOD)
//@ObjectHolder(Tutorial.MOD_ID)
public class BlockInitOld {
  public static final Block green_apple_chunk = null;

  //@SubscribeEvent
/*  public static void RegisterBlocks(final RegistryEvent.Register<Block> event) {
    event.getRegistry().register(
        new Block(Block.Properties
            .create(Material.GOURD).sound(SoundType.CROP))
            .setRegistryName("green_apple_chunk"));
  }*/

  //@SubscribeEvent
/*  public static void RegisterBlockItems(final RegistryEvent.Register<Item> event) {
    event.getRegistry().register(
        new BlockItem(
            green_apple_chunk,
            new Item.Properties().maxStackSize(16).group(ItemGroup.FOOD))
            .setRegistryName("green_apple_chunk"));
  }*/
}
