package com.fatface01.tutorial.events;

import com.fatface01.tutorial.Tutorial;
import com.fatface01.tutorial.init.ItemInit;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.player.PlayerEvent.ItemSmeltedEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

//@Mod.EventBusSubscriber(modid = Tutorial.MOD_ID, bus = Bus.FORGE)
public class SyrupSpitBucketEvent {

  @SubscribeEvent
  public static void syrupSpitBucketEvent(ItemSmeltedEvent event) {
    if (event.getSmelting().equals(ItemInit.SYRUP.get())) {

    }
  }
}
