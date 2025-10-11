package net.nolli.arcanummod;

import net.fabricmc.api.ModInitializer;

import net.nolli.arcanummod.block.ModBlocks;
import net.nolli.arcanummod.component.ModDataComponentTypes;
import net.nolli.arcanummod.effect.ModEffects;
import net.nolli.arcanummod.event.SoulDrainKillHandler;
import net.nolli.arcanummod.item.ModItemGroups;
import net.nolli.arcanummod.item.ModItems;
import net.nolli.arcanummod.sound.ModSounds;
import net.nolli.arcanummod.world.gen.ModWorldGeneration;
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

		ModDataComponentTypes.registerDataComponentTypes();

		ModEffects.registerEffects();

		SoulDrainKillHandler.register();

		ModSounds.registerSounds();

		ModWorldGeneration.generateModWorldGen();

		//FuelRegistry.INSTANCE.add(ModItems.F, 20000); tak sie dodaje przedmiot ktory ma sie palic
	}
}