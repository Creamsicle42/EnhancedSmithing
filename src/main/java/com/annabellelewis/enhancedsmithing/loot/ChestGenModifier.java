package com.annabellelewis.enhancedsmithing.loot;

import com.annabellelewis.enhancedsmithing.Registration;
import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.common.loot.IGlobalLootModifier;
import net.minecraftforge.common.loot.LootModifier;
import org.jetbrains.annotations.NotNull;

public class ChestGenModifier extends LootModifier {


    public static final Supplier<Codec<ChestGenModifier>> CODEC = Suppliers.memoize(
            () -> RecordCodecBuilder.create(inst -> codecStart(inst).apply(inst, ChestGenModifier::new)
    ));

    protected ChestGenModifier(LootItemCondition[] conditionsIn) {
        super(conditionsIn);
    }

    @Override
    protected @NotNull ObjectArrayList<ItemStack> doApply(ObjectArrayList<ItemStack> generatedLoot, LootContext context) {
        if (context.getRandom().nextFloat() % 1f > 0.8f) {
            generatedLoot.add(new ItemStack(Registration.ATTRIBUTE_CRYSTAL.get()));
        }
        if (context.getRandom().nextFloat() % 1f > 0.8f) {
            generatedLoot.add(new ItemStack(Registration.REFINED_IRON_INGOT.get()));
        }
        if (context.getRandom().nextFloat() % 1f > 0.95f) {
            generatedLoot.add(new ItemStack(Registration.BLOOD_GOLD_INGOT.get()));
        }
        if (context.getRandom().nextFloat() % 1f > 0.99f) {
            generatedLoot.add(new ItemStack(Registration.DIAMONDSTEEL_INGOT.get()));
        }
        return generatedLoot;
    }

    @Override
    public Codec<? extends IGlobalLootModifier> codec() {
        return CODEC.get();
    }
}
