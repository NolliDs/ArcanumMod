package net.nolli.arcanummod.component;

import net.minecraft.component.ComponentType;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.util.Identifier;
import net.minecraft.util.Unit;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.nolli.arcanummod.ArcanumMod;

import java.util.function.UnaryOperator;

public class ModDataComponentTypes {

    public static final ComponentType<Unit> CLOVER_EFFECT = register(
            "clover_effect", builder -> builder.codec(Unit.CODEC).packetCodec(PacketCodec.unit(Unit.INSTANCE)));

    private static <T> ComponentType<T> register(String name, UnaryOperator<ComponentType.Builder<T>> builderUnaryOperator) {
        return Registry.register(Registries.DATA_COMPONENT_TYPE, Identifier.of(ArcanumMod.MOD_ID, name),
                builderUnaryOperator.apply(ComponentType.builder()).build());
    }

    public static void registerDataComponentTypes() {
        ArcanumMod.LOGGER.info("Registering Data Component Types for " + ArcanumMod.MOD_ID);
    }
}
