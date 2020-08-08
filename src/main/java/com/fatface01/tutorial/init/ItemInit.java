package com.fatface01.tutorial.init;

import com.fatface01.tutorial.Tutorial;
import com.fatface01.tutorial.objects.items.SyrupBucketItem;
import java.util.function.Supplier;
import net.minecraft.item.AxeItem;
import net.minecraft.item.BlockItem;
import net.minecraft.item.BowItem;
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
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemInit {

  public static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS,
      Tutorial.MOD_ID);

  public static final RegistryObject<Item> GREEN_APPLE = ITEMS.register(
      "green_apple", () -> new Item(new Item.Properties()
          .group(ItemGroup.FOOD)
          .food(new Food.Builder()
              .hunger(4)
              .saturation(2.4f)
              .effect(() -> new EffectInstance(Effects.GLOWING, 200, 1), 1.0f)
              .build())));

  public static final RegistryObject<SyrupBucketItem> SYRUP = ITEMS.register(
      "syrup", () -> new SyrupBucketItem(new Item.Properties()
          .group(Tutorial.CANDY_LAND)
          .containerItem(Items.BUCKET)
          .maxStackSize(1)
          .food(new Food.Builder()
              .hunger(1)
              .saturation(0.4f)
              .effect(() -> new EffectInstance(Effects.NAUSEA, 200, 1), 0.5f)
              .build())));

  public static final RegistryObject<Item> CANDY_CHUNK = ITEMS.register(
      "candy_chunk", () -> new Item(new Item.Properties()
          .group(Tutorial.CANDY_LAND)
          .food(new Food.Builder()
              .hunger(1)
              .saturation(1.5F)
              .setAlwaysEdible()
              .build())));

  public static final RegistryObject<SwordItem> CANDY_SWORD = ITEMS.register(
      "candy_sword",
      () -> new SwordItem(ModItemTier.CANDY, 0, 3.5F, candyToolProperties(1)));

  public static final RegistryObject<ShovelItem> CANDY_SHOVEL = ITEMS.register(
      "candy_shovel",
      () -> new ShovelItem(ItemInitOld.ModItemTier.CANDY, -2, 3.5F, candyToolProperties(1)));

  public static final RegistryObject<PickaxeItem> CANDY_PICKAXE = ITEMS.register(
      "candy_pickaxe",
      () -> new PickaxeItem(ItemInitOld.ModItemTier.CANDY, -2, 3.5F, candyToolProperties(1)));

  public static final RegistryObject<AxeItem> CANDY_AXE = ITEMS.register(
      "candy_axe",
      () -> new AxeItem(ModItemTier.CANDY, 2, 2.5F, candyToolProperties(1)));

  public static final RegistryObject<HoeItem> CANDY_HOE = ITEMS.register(
      "candy_hoe",
      () -> new HoeItem(ItemInitOld.ModItemTier.CANDY, 3.5F, candyToolProperties(1)));
  public static final RegistryObject<BowItem> CANDY_BOW = ITEMS.register(
      "candy_bow",
      () -> new BowItem(candyToolProperties(1)));

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

  public static final RegistryObject<BlockItem> GREEN_APPLE_CHUNK = ITEMS.register(
      "green_apple_chunk",
      ()-> new BlockItem(BlockInit.GREEN_APPLE_CHUNK.get(),
          new Item.Properties().group(Tutorial.CANDY_LAND)));

}
