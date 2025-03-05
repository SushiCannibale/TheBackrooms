package fr.sushi.thebackrooms.registry;

import fr.sushi.thebackrooms.TheBackrooms;
import net.minecraft.world.item.BlockItem;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ItemRegistry {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(TheBackrooms.MODID);

    public static final DeferredItem<BlockItem> WALLPAPER_BLOCK_ITEM = ITEMS.registerSimpleBlockItem("wallpaper_block", BlockRegistry.WALLPAPER_BLOCK);
    public static final DeferredItem<BlockItem> NEON_BLOCK_ITEM = ITEMS.registerSimpleBlockItem("neon_block", BlockRegistry.NEON_BLOCK);

    public static void register(IEventBus bus) {
        ITEMS.register(bus);
    }
}
