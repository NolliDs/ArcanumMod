package net.nolli.arcanummod.item.custom;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.world.World;

import java.util.List;
import java.util.Map;

public class GoldCloverItem extends Item {
    private static final Map<Block, Block> GOLD_CLOVER_MAP =
            Map.of(
                    Blocks.STONE, Blocks.GOLD_BLOCK
            );

    public GoldCloverItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        Block clickedBlock = world.getBlockState(context.getBlockPos()).getBlock();

        if(GOLD_CLOVER_MAP.containsKey(clickedBlock)) {
            if(!world.isClient()) {
                world.setBlockState(context.getBlockPos(), GOLD_CLOVER_MAP.get(clickedBlock).getDefaultState());

                context.getStack().damage(1, ((ServerWorld) world), ((ServerPlayerEntity) context.getPlayer()),
                    item ->context.getPlayer().sendEquipmentBreakStatus(item, EquipmentSlot.MAINHAND ));

                world.playSound(null, context.getBlockPos(), SoundEvents.BLOCK_AMETHYST_BLOCK_CHIME, SoundCategory.BLOCKS, 10f,1f);

            }

        }

        return ActionResult.SUCCESS;
    }

    @Override
    public boolean canBeEnchantedWith(
            ItemStack stack,
            net.minecraft.registry.entry.RegistryEntry<net.minecraft.enchantment.Enchantment> enchantment,
            net.fabricmc.fabric.api.item.v1.EnchantingContext context
    ) {
        if (enchantment.matchesKey(net.minecraft.enchantment.Enchantments.MENDING)) {
            return false;
        }
        return super.canBeEnchantedWith(stack, enchantment, context);
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        if(Screen.hasShiftDown()) {
            tooltip.add(Text.translatable("tooltip.arcanummod.goldclover.tooltip.shift_down"));
        } else {
            tooltip.add(Text.translatable("tooltip.arcanummod.goldclover"));
        }

        super.appendTooltip(stack, context, tooltip, type);
    }
}
