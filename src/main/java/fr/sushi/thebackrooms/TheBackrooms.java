package fr.sushi.thebackrooms;

import fr.sushi.thebackrooms.datagen.ModDataGenerators;
import fr.sushi.thebackrooms.registry.*;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;

@Mod(TheBackrooms.MODID)
public class TheBackrooms {
    public static final String MODID = "thebackrooms";

    public TheBackrooms(IEventBus modEventBus, ModContainer modContainer) {
        BlockRegistry.register(modEventBus);
        ItemRegistry.register(modEventBus);
        CreativeTabRegistry.register(modEventBus);
        BiomeFeatureRegistry.register(modEventBus);

        modEventBus.register(ModDataGenerators.class);
    }
}