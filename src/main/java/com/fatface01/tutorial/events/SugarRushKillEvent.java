package com.fatface01.tutorial.events;

import com.fatface01.tutorial.Tutorial;
import com.fatface01.tutorial.init.BlockInit;
import com.fatface01.tutorial.init.ItemInit;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.world.Explosion;
import net.minecraft.world.Explosion.Mode;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@Mod.EventBusSubscriber(modid = Tutorial.MOD_ID, bus = Bus.FORGE)
public class SugarRushKillEvent {

  @SubscribeEvent
  public static void sugarRushKillEvent(LivingDeathEvent event) {

    LivingEntity killer = null;
    Entity killed;
    Item heldItem = null;
    World world;
    try {
      if (event.getSource().getTrueSource() instanceof LivingEntity) {
        killer = (LivingEntity) event.getSource().getTrueSource();
        if (killer == null) {
          return;
        }
        heldItem = killer.getHeldItemMainhand().getItem();
      }
      killed = event.getEntity();
      world = killed.getEntityWorld();
    } catch (Exception e) {
      return;
    }

    //world.setBlockState(killed.getPosition(), BlockInit.green_apple_chunk.getDefaultState());
    //killer.addPotionEffect(new EffectInstance(Effects.REGENERATION, 100, 1));
    //killer.addPotionEffect(new EffectInstance(Effects.SPEED, 300, 1));

    if (heldItem != null && heldItem.equals(ItemInit.CANDY_SWORD.get())) {
      killer.addPotionEffect(new EffectInstance(Effects.REGENERATION, 100, 1));
      killer.addPotionEffect(new EffectInstance(Effects.SPEED, 300, 1));
    } else if (heldItem != null && heldItem.equals(ItemInit.CANDY_BOW.get())) {
      world.createExplosion(
          null, killed.getPosX(), killed.getPosY(), killed.getPosZ(), 3.0F, Mode.BREAK);
    }
  }
}
