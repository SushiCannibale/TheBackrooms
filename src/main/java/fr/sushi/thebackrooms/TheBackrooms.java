package fr.sushi.thebackrooms;

import fr.sushi.thebackrooms.event.ModEvents;
import fr.sushi.thebackrooms.registry.BlockRegistry;
import fr.sushi.thebackrooms.registry.CreativeTabRegistry;
import fr.sushi.thebackrooms.registry.ItemRegistry;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;

@Mod(TheBackrooms.MODID)
public class TheBackrooms {
    public static final String MODID = "thebackrooms";

    public TheBackrooms(IEventBus modEventBus, ModContainer modContainer) {
        ItemRegistry.register(modEventBus);
        BlockRegistry.register(modEventBus);
        CreativeTabRegistry.register(modEventBus);

        modEventBus.register(ModEvents.class);
    }
}