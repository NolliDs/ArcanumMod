package net.nolli.arcanummod.util;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.nolli.arcanummod.ArcanumMod;

public class ModTags {

    public static class Blocks {

        public static final TagKey<Block> NEEDS_SEA_CRYSTAL_TOOL = createTag("needs_sea_crystal_tool");
        public static final TagKey<Block> INCORRECT_FOR_SEA_CRYSTAL_TOOL = createTag("incorrect_for_sea_crystal_tool");

        public static final TagKey<Block> TRANSFORMABLE_BLOCKS = createTag("transformable_blocks");

        private static TagKey<Block> createTag(String name) {
            return TagKey.of(RegistryKeys.BLOCK, Identifier.of(ArcanumMod.MOD_ID, name));
        }

    }
    public static class Items {

        public static final TagKey<Item> TRANSFORMABLE_ITEMS = createTag("transformable_items");

        private static TagKey<Item> createTag(String name) {
             return TagKey.of(RegistryKeys.ITEM, Identifier.of(ArcanumMod.MOD_ID, name));
        }

    }
}
