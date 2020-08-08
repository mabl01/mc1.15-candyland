package com.fatface01.tutorial.objects.items;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.UseAction;
import net.minecraft.stats.Stats;
import net.minecraft.world.World;

public class SyrupBucketItem extends Item {

  public SyrupBucketItem(Properties properties) {
    super(properties);
  }

  /**
   * Called when the player finishes using this Item (E.g. finishes eating.). Not called when the player stops using
   * the Item before the action is complete.
   */
  public ItemStack onItemUseFinish(ItemStack stack, World worldIn, LivingEntity entityLiving) {
    //if (!worldIn.isRemote) entityLiving.curePotionEffects(stack);

    if (entityLiving instanceof PlayerEntity && !((PlayerEntity)entityLiving).abilities.isCreativeMode) {
      stack.shrink(1);
    }

    return stack.isEmpty() ? new ItemStack(Items.BUCKET) : stack;
  }

  /**
   * How long it takes to use or consume an item
   */
  public int getUseDuration(ItemStack stack) {
    return 32;
  }

  /**
   * returns the action that specifies what animation to play when the items is being used
   */
  public UseAction getUseAction(ItemStack stack) {
    return UseAction.DRINK;
  }

}
