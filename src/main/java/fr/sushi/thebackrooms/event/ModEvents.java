package fr.sushi.thebackrooms.event;

import fr.sushi.thebackrooms.TheBackrooms;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, modid = TheBackrooms.MODID)
public class ModEvents {
    @SubscribeEvent
    public static void addCreative(BuildCreativeModeTabContentsEvent event) {
//        if (event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS) {
//            event.accept(ItemRegistry.WALLPAPER_BLOCK_ITEM);
//        }
    }
}
