package com.fatface01.tutorial.init;

import com.fatface01.tutorial.Tutorial;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockInit {
  public static final DeferredRegister<Block> BLOCKS =
      new DeferredRegister<>(ForgeRegistries.BLOCKS, Tutorial.MOD_ID);

  public static final RegistryObject<Block> GREEN_APPLE_CHUNK = BLOCKS.register(
      "green_apple_chunk", () -> new Block(Block.Properties
          .create(Material.GOURD).sound(SoundType.CROP)));
}
