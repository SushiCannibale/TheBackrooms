package fr.sushi.thebackrooms;

import fr.sushi.thebackrooms.client.ModClientEventHandler;
import fr.sushi.thebackrooms.common.registry.BlockRegistry;
import fr.sushi.thebackrooms.common.registry.CreativeTabRegistry;
import fr.sushi.thebackrooms.common.registry.ItemRegistry;
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

        modEventBus.register(ModClientEventHandler.class);
    }
}