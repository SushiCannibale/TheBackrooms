package fr.sushi.thebackrooms.registry;

import fr.sushi.thebackrooms.TheBackrooms;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

public class BlockRegistry {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(TheBackrooms.MODID);

    public static final DeferredBlock<Block> WALLPAPER_BLOCK = BLOCKS.registerSimpleBlock("wallpaper_block", BlockBehaviour.Properties.of()
            .mapColor(MapColor.STONE)
            .sound(SoundType.WOOL)
            .strength(-1.0F, 3600000.0F)
            .noLootTable()
            .isValidSpawn(Blocks::never)
    );

    public static final DeferredBlock<Block> NEON_BLOCK = BLOCKS.registerSimpleBlock("neon_block", BlockBehaviour.Properties.of()
            .mapColor(MapColor.SAND)
            .instrument(NoteBlockInstrument.PLING)
            .sound(SoundType.GLASS)
            .lightLevel(state -> 15)
            .strength(-1.0F, 3600000.0F)
            .noLootTable()
            .isValidSpawn(Blocks::never)
    );

    public static void register(IEventBus bus) {
        BLOCKS.register(bus);
    }
}
