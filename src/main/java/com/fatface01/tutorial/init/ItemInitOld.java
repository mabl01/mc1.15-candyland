package com.fatface01.tutorial.init;

import com.fatface01.tutorial.Tutorial;
import com.fatface01.tutorial.objects.items.SyrupBucketItem;
import java.util.function.Supplier;
import net.minecraft.item.AxeItem;
import net.minecraft.item.BowItem;
import net.minecraft.item.BucketItem;
import net.minecraft.item.Food;
import net.minecraft.item.HoeItem;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Items;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.SwordItem;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.LazyValue;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.ObjectHolder;

//@Mod.EventBusSubscriber(modid = Tutorial.MOD_ID, bus = Bus.MOD)
//@ObjectHolder(Tutorial.MOD_ID)

public class ItemInitOld {

  public static final Item green_apple = null;

  // candy items
  public static final Item syrup = null;
  public static final Item candy_chunk = null;

  // candy tools
  public static final Item candy_sword = null;
  public static final Item candy_pickaxe = null;
  public static final Item candy_axe = null;
  public static final Item candy_shovel = null;
  public static final Item candy_hoe = null;
  public static final Item candy_bow = null;

  //@SubscribeEvent
  /*public static void RegisterItems(final RegistryEvent.Register<Item> event) {
    event.getRegistry().registerAll(
        new SyrupBucketItem(new Item.Properties()
            .group(Tutorial.CANDY_LAND)
            .containerItem(Items.BUCKET)
            .maxStackSize(1)
            .food(new Food.Builder()
                .hunger(1)
                .saturation(0.4f)
                .effect(() -> new EffectInstance(Effects.NAUSEA, 200, 1), 0.5f)
                .build()))
            .setRegistryName("syrup"),

        new Item(new Item.Properties()
            .group(ItemGroup.FOOD)
            .food(new Food.Builder()
                .hunger(4)
                .saturation(2.4f)
                .effect(() -> new EffectInstance(Effects.GLOWING, 200, 1), 1.0f)
                .build()))
            .setRegistryName("green_apple"),

        new Item(new Item.Properties()
            .group(Tutorial.CANDY_LAND)
            .food(new Food.Builder()
                .hunger(1)
                .saturation(1.5F)
                .setAlwaysEdible()
                .build()))
            .setRegistryName("candy_chunk"),

        new SwordItem(ModItemTier.CANDY, 0, 3.5F, candyToolProperties(1))
            .setRegistryName("candy_sword"),

        new PickaxeItem(ModItemTier.CANDY, -2, 3.5F, candyToolProperties(1))
            .setRegistryName("candy_pickaxe"),

        new AxeItem(ModItemTier.CANDY, 2, 2.5F, candyToolProperties(1))
            .setRegistryName("candy_axe"),

        new ShovelItem(ModItemTier.CANDY, -2, 3.5F, candyToolProperties(1))
            .setRegistryName("candy_shovel"),

        new HoeItem(ModItemTier.CANDY, 3.5F, candyToolProperties(1))
            .setRegistryName("candy_hoe"),

        new BowItem(candyToolProperties(1))
            .setRegistryName("candy_bow"));
  }*/

  /**
   * creates the item properties for candy tools.
   *
   * @return item properties
   */
  private static Item.Properties candyToolProperties(int hunger) {
    return new Item.Properties()
        .food(new Food.Builder()
            .hunger(hunger)
            .saturation(1.8F)
            .effect(() -> new EffectInstance(Effects.SPEED, 300, 2), 1.0f)
            .effect(() -> new EffectInstance(Effects.REGENERATION, 100, 2), 1.0f)
            .build())
        .group(Tutorial.CANDY_LAND)
        .maxStackSize(1);
  }

  /**
   * enum to represent new item tiers for items in this mod.
   */
  public enum ModItemTier implements IItemTier {

    CANDY(1, 32, 5.0F, 4.0F, 16,
        () -> {
          return Ingredient.fromItems(ItemInit.CANDY_CHUNK.get());
        });

    private final int harvestLevel;
    private final int maxUses;
    private final float efficiency;
    private final float attackDamage;
    private final int enchantability;
    private final LazyValue<Ingredient> repairMaterial;

    ModItemTier(
        int harvestLevel,
        int maxUses,
        float efficiency,
        float attackDamage,
        int enchantability,
        Supplier<Ingredient> repairMaterial) {
      this.harvestLevel = harvestLevel;
      this.maxUses = maxUses;
      this.efficiency = efficiency;
      this.attackDamage = attackDamage;
      this.enchantability = enchantability;
      this.repairMaterial = new LazyValue<>(repairMaterial);
    }

    @Override
    public int getMaxUses() {
      return this.maxUses;
    }

    @Override
    public float getEfficiency() {
      return this.efficiency;
    }

    @Override
    public float getAttackDamage() {
      return this.attackDamage;
    }

    @Override
    public int getHarvestLevel() {
      return this.harvestLevel;
    }

    @Override
    public int getEnchantability() {
      return this.enchantability;
    }

    @Override
    public Ingredient getRepairMaterial() {
      return this.repairMaterial.getValue();
    }
  }
}
