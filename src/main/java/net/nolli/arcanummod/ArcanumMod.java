package net.nolli.arcanummod;

import net.fabricmc.api.ModInitializer;

import net.nolli.arcanummod.block.ModBlocks;
import net.nolli.arcanummod.item.ModItemGroups;
import net.nolli.arcanummod.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ArcanumMod implements ModInitializer {
	public static final String MOD_ID = "arcanummod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItemGroups.registerItemGroups();

		ModItems.registerModItens();
		ModBlocks.registerModBlocks();
	}
}