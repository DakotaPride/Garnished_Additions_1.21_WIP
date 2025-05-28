package net.panda.garnished_additions.init;

import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.util.LazyLoadedValue;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;

public enum GarnishedAdditionsTiers implements Tier {
    NUTIUM(4, 3072, 10.0F, 9.0F, 20,
            () -> Ingredient.of(GarnishedAdditionsItemsInit.NUTIUM_INGOT.get()), BlockTags.INCORRECT_FOR_NETHERITE_TOOL);

    private final int level;
    private final int uses;
    private final float speed;
    private final float damage;
    private final int enchantmentValue;
    private final LazyLoadedValue<Ingredient> repairIngredient;
    private final TagKey<Block> incorrectBlocksForDrops;

    GarnishedAdditionsTiers(int level,
                            int uses,
                            float speed,
                            float damage,
                            int enchantmentValue,
                            Supplier<Ingredient> repairIngredient,
                            TagKey<Block> incorrectBlocksForDrops) {
        this.level = level;
        this.uses = uses;
        this.speed = speed;
        this.damage = damage;
        this.enchantmentValue = enchantmentValue;
        this.repairIngredient = new LazyLoadedValue<>(repairIngredient);
        this.incorrectBlocksForDrops = incorrectBlocksForDrops;
    }

    public int getUses() {
        return this.uses;
    }

    public float getSpeed() {
        return this.speed;
    }

    public float getAttackDamageBonus() {
        return this.damage;
    }

    @Override
    public @NotNull TagKey<Block> getIncorrectBlocksForDrops() {
        return incorrectBlocksForDrops;
    }

    public int getLevel() {
        return this.level;
    }

    public int getEnchantmentValue() {
        return this.enchantmentValue;
    }

    public @NotNull Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }

//    @Nullable
//    public TagKey<Block> getTag() { return ForgeHooks.getTagFromVanillaTier(this); }

    public static void load() {}
}
