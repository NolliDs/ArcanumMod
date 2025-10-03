package net.nolli.arcanummod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LeafEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.nolli.arcanummod.block.ModBlocks;
import net.nolli.arcanummod.item.ModItems;

import java.util.concurrent.CompletableFuture;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.SEA_CRYSTAL_BLOCK);
        addDrop(ModBlocks.RAW_SEA_CRYSTAL_BLOCK);
        addDrop(ModBlocks.NETHERITE_ALTAR);
        addDrop(ModBlocks.SEA_CRYSTAL_LAMP);

        addDrop(ModBlocks.SEA_CRYSTAL_ORE, oreDrops(ModBlocks.SEA_CRYSTAL_ORE, ModItems.RAW_SEA_CRYSTAL));
        addDrop(ModBlocks.DEEPSLATE_SEA_CRYSTAL_ORE, multipleOreDrops(ModBlocks.DEEPSLATE_SEA_CRYSTAL_ORE, ModItems.RAW_SEA_CRYSTAL,1,3));

        addDrop(ModBlocks.POLISHED_SEA_CRYSTAL_BLOCK);
        addDrop(ModBlocks.POLISHED_SEA_CRYSTAL_STAIRS);
        addDrop(ModBlocks.POLISHED_SEA_CRYSTAL_SLAB, slabDrops(ModBlocks.POLISHED_SEA_CRYSTAL_SLAB));

        addDrop(ModBlocks.POLISHED_SEA_CRYSTAL_BUTTON);
        addDrop(ModBlocks.POLISHED_SEA_CRYSTAL_PRESSURE_PLATE);

        addDrop(ModBlocks.POLISHED_SEA_CRYSTAL_FENCE);
        addDrop(ModBlocks.POLISHED_SEA_CRYSTAL_FENCE_GATE);
        addDrop(ModBlocks.POLISHED_SEA_CRYSTAL_WALL);

        addDrop(ModBlocks.POLISHED_SEA_CRYSTAL_DOOR, doorDrops(ModBlocks.POLISHED_SEA_CRYSTAL_DOOR));
        addDrop(ModBlocks.POLISHED_SEA_CRYSTAL_TRAPDOOR);

        addDrop(ModBlocks.WILD_CLOVER, LootTable.builder()
                .pool(LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .with(ItemEntry.builder(ModItems.CLOVER).weight(998))
                        .with(ItemEntry.builder(ModItems.CLOVER_OF_FORTUNE).weight(2))
                )
        );
    }

    public LootTable.Builder multipleOreDrops(Block drop, Item item, float minDrops, float maxDrops) {
        RegistryWrapper.Impl<Enchantment> impl = this.registryLookup.getWrapperOrThrow(RegistryKeys.ENCHANTMENT);
        return this.dropsWithSilkTouch(drop, this.applyExplosionDecay(drop, ((LeafEntry.Builder<?>)
                ItemEntry.builder(item).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(minDrops, maxDrops))))
                .apply(ApplyBonusLootFunction.oreDrops(impl.getOrThrow(Enchantments.FORTUNE)))));
    }
}
