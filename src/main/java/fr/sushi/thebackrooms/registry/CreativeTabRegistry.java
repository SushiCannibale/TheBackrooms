package fr.sushi.thebackrooms.registry;

import fr.sushi.thebackrooms.TheBackrooms;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.Comparator;

import static fr.sushi.thebackrooms.registry.ItemRegistry.ITEMS;
import static fr.sushi.thebackrooms.registry.ItemRegistry.WALLPAPER_BLOCK_ITEM;

public class CreativeTabRegistry {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, TheBackrooms.MODID);

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> THE_BACKROOMS_TAB = CREATIVE_MODE_TABS.register("the_backrooms", () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.the_backrooms"))
            .withTabsBefore(CreativeModeTabs.COMBAT)
            .icon(() -> WALLPAPER_BLOCK_ITEM.get().getDefaultInstance())
            .displayItems((parameters, output) -> {
                ITEMS.getEntries().stream()
                        .sorted(Comparator.comparing(Holder::getRegisteredName))
                        .forEach(item -> output.accept(item.get()));
            }).build());

    public static void register(IEventBus bus) {
        CREATIVE_MODE_TABS.register(bus);
    }
}
