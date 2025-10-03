package net.nolli.arcanummod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;
import net.nolli.arcanummod.item.ModItems;
import net.nolli.arcanummod.util.ModTags;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(ModTags.Items.TRANSFORMABLE_ITEMS)
                .add(ModItems.SEA_CRYSTAL);

        getOrCreateTagBuilder(ItemTags.SWORDS)
                .add(ModItems.SEA_CRYSTAL_SWORD);

        getOrCreateTagBuilder(ItemTags.PICKAXES)
                .add(ModItems.SEA_CRYSTAL_PICKAXE);

        getOrCreateTagBuilder(ItemTags.SHOVELS)
                .add(ModItems.SEA_CRYSTAL_SHOVEL);

        getOrCreateTagBuilder(ItemTags.AXES)
                .add(ModItems.SEA_CRYSTAL_AXE);

        getOrCreateTagBuilder(ItemTags.HOES)
                .add(ModItems.SEA_CRYSTAL_HOE);

    }
}
