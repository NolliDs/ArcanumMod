package net.nolli.arcanummod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;
import net.nolli.arcanummod.ArcanumMod;
import net.nolli.arcanummod.block.ModBlocks;
import net.nolli.arcanummod.item.ModItems;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter exporter) {
        List<ItemConvertible> SEA_CRYSTAL_SMELTABLES = List.of(ModItems.RAW_SEA_CRYSTAL, ModBlocks.SEA_CRYSTAL_ORE,
                ModBlocks.DEEPSLATE_SEA_CRYSTAL_ORE);

        offerSmelting(exporter, SEA_CRYSTAL_SMELTABLES, RecipeCategory.MISC, ModItems.SEA_CRYSTAL, 0.25f, 200, "sea_crystal");
        offerBlasting(exporter, SEA_CRYSTAL_SMELTABLES, RecipeCategory.MISC, ModItems.SEA_CRYSTAL, 0.25f, 100, "sea_crystal");

        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.SEA_CRYSTAL, RecipeCategory.DECORATIONS, ModBlocks.SEA_CRYSTAL_BLOCK);

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModBlocks.RAW_SEA_CRYSTAL_BLOCK)
                .pattern("RRR")
                .pattern("RRR")
                .pattern("RRR")
                .input('R', ModItems.RAW_SEA_CRYSTAL)
                .criterion(hasItem(ModItems.RAW_SEA_CRYSTAL), conditionsFromItem(ModItems.RAW_SEA_CRYSTAL))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.GOLD_CLOVER)
                .pattern("GSG")
                .pattern("SCS")
                .pattern("GSG")
                .input('G', Items.GOLD_INGOT)
                .input('S', ModItems.SEA_CRYSTAL)
                .input('C', ModItems.CLOVER_OF_FORTUNE)
                .criterion(hasItem(ModItems.CLOVER_OF_FORTUNE), conditionsFromItem(ModItems.CLOVER_OF_FORTUNE))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.NETHERITE_ALTAR)
                .pattern(" N ")
                .pattern("SOS")
                .pattern("OOO")
                .input('N', Items.NETHERITE_INGOT)
                .input('S', ModItems.SEA_CRYSTAL)
                .input('O', Items.OBSIDIAN)
                .criterion(hasItem(ModItems.SEA_CRYSTAL), conditionsFromItem(ModItems.SEA_CRYSTAL))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModBlocks.SEA_CRYSTAL_LAMP)
                .pattern(" S ")
                .pattern("SGS")
                .pattern(" S ")
                .input('S', ModItems.SEA_CRYSTAL)
                .input('G', Items.GLOWSTONE)
                .criterion(hasItem(ModItems.SEA_CRYSTAL), conditionsFromItem(ModItems.SEA_CRYSTAL))
                .offerTo(exporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.SEA_CRYSTAL_BEER)
                .input(Items.HONEY_BOTTLE)
                .input(ModItems.SEA_CRYSTAL)
                .input(Items.SUGAR)
                .criterion(hasItem(ModItems.SEA_CRYSTAL), conditionsFromItem(ModItems.SEA_CRYSTAL))
                .offerTo(exporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.RAW_SEA_CRYSTAL, 9)
                .input(ModBlocks.RAW_SEA_CRYSTAL_BLOCK)
                .criterion(hasItem(ModBlocks.RAW_SEA_CRYSTAL_BLOCK), conditionsFromItem(ModBlocks.RAW_SEA_CRYSTAL_BLOCK))
                .offerTo(exporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.RAW_SEA_CRYSTAL, 32)
                .input(ModBlocks.NETHERITE_ALTAR)
                .criterion(hasItem(ModBlocks.NETHERITE_ALTAR), conditionsFromItem(ModBlocks.NETHERITE_ALTAR))
                .offerTo(exporter, Identifier.of(ArcanumMod.MOD_ID, "raw_sea_crystal_from_altar_block"));

        //Sea Crystal Tools

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.SEA_CRYSTAL_SWORD)
                .pattern(" S ")
                .pattern(" S ")
                .pattern(" P ")
                .input('S', ModItems.SEA_CRYSTAL)
                .input('P', Items.STICK)
                .criterion(hasItem(ModItems.SEA_CRYSTAL), conditionsFromItem(ModItems.SEA_CRYSTAL))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.SEA_CRYSTAL_PICKAXE)
                .pattern("SSS")
                .pattern(" P ")
                .pattern(" P ")
                .input('S', ModItems.SEA_CRYSTAL)
                .input('P', Items.STICK)
                .criterion(hasItem(ModItems.SEA_CRYSTAL), conditionsFromItem(ModItems.SEA_CRYSTAL))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.SEA_CRYSTAL_SHOVEL)
                .pattern(" S ")
                .pattern(" P ")
                .pattern(" P ")
                .input('S', ModItems.SEA_CRYSTAL)
                .input('P', Items.STICK)
                .criterion(hasItem(ModItems.SEA_CRYSTAL), conditionsFromItem(ModItems.SEA_CRYSTAL))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.SEA_CRYSTAL_AXE)
                .pattern(" SS")
                .pattern(" PS")
                .pattern(" P ")
                .input('S', ModItems.SEA_CRYSTAL)
                .input('P', Items.STICK)
                .criterion(hasItem(ModItems.SEA_CRYSTAL), conditionsFromItem(ModItems.SEA_CRYSTAL))
                .offerTo(exporter, Identifier.of(ArcanumMod.MOD_ID, getRecipeName(ModItems.SEA_CRYSTAL_AXE) + "_right"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.SEA_CRYSTAL_AXE)
                .pattern("SS ")
                .pattern("SP ")
                .pattern(" P ")
                .input('S', ModItems.SEA_CRYSTAL)
                .input('P', Items.STICK)
                .criterion(hasItem(ModItems.SEA_CRYSTAL), conditionsFromItem(ModItems.SEA_CRYSTAL))
                .offerTo(exporter, Identifier.of(ArcanumMod.MOD_ID, getRecipeName(ModItems.SEA_CRYSTAL_AXE) + "_left"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.SEA_CRYSTAL_HOE)
                .pattern("SS ")
                .pattern(" P ")
                .pattern(" P ")
                .input('S', ModItems.SEA_CRYSTAL)
                .input('P', Items.STICK)
                .criterion(hasItem(ModItems.SEA_CRYSTAL), conditionsFromItem(ModItems.SEA_CRYSTAL))
                .offerTo(exporter, Identifier.of(ArcanumMod.MOD_ID, getRecipeName(ModItems.SEA_CRYSTAL_HOE) + "_left"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.SEA_CRYSTAL_HOE)
                .pattern(" SS")
                .pattern(" P ")
                .pattern(" P ")
                .input('S', ModItems.SEA_CRYSTAL)
                .input('P', Items.STICK)
                .criterion(hasItem(ModItems.SEA_CRYSTAL), conditionsFromItem(ModItems.SEA_CRYSTAL))
                .offerTo(exporter, Identifier.of(ArcanumMod.MOD_ID, getRecipeName(ModItems.SEA_CRYSTAL_HOE) + "_right"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.SEA_CRYSTAL_HELMET)
                .pattern("SSS")
                .pattern("S S")
                .pattern("   ")
                .input('S', ModItems.SEA_CRYSTAL)
                .criterion(hasItem(ModItems.SEA_CRYSTAL), conditionsFromItem(ModItems.SEA_CRYSTAL))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.SEA_CRYSTAL_CHESTPLATE)
                .pattern("S S")
                .pattern("SSS")
                .pattern("SSS")
                .input('S', ModItems.SEA_CRYSTAL)
                .criterion(hasItem(ModItems.SEA_CRYSTAL), conditionsFromItem(ModItems.SEA_CRYSTAL))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.SEA_CRYSTAL_LEGGINGS)
                .pattern("SSS")
                .pattern("S S")
                .pattern("S S")
                .input('S', ModItems.SEA_CRYSTAL)
                .criterion(hasItem(ModItems.SEA_CRYSTAL), conditionsFromItem(ModItems.SEA_CRYSTAL))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.SEA_CRYSTAL_BOOTS)
                .pattern("   ")
                .pattern("S S")
                .pattern("S S")
                .input('S', ModItems.SEA_CRYSTAL)
                .criterion(hasItem(ModItems.SEA_CRYSTAL), conditionsFromItem(ModItems.SEA_CRYSTAL))
                .offerTo(exporter);
    }
}
