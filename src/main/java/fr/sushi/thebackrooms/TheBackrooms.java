package fr.sushi.thebackrooms;

import fr.sushi.thebackrooms.registry.*;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;

@Mod(TheBackrooms.MODID)
public class TheBackrooms {
    public static final String MODID = "thebackrooms";

    public TheBackrooms(IEventBus modEventBus, ModContainer modContainer) {
        BlockRegistry.register(modEventBus);
        ItemRegistry.register(modEventBus);
        CreativeTabRegistry.register(modEventBus);
        BiomeFeatureRegistry.register(modEventBus);
        FeatureRegistry.loadClass();
    }
}