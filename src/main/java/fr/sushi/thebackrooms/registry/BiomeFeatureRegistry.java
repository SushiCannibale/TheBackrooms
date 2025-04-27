package fr.sushi.thebackrooms.registry;

import fr.sushi.thebackrooms.TheBackrooms;
import fr.sushi.thebackrooms.worldgen.NoclipPatchConfiguration;
import fr.sushi.thebackrooms.worldgen.NoclipPatchFeature;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class BiomeFeatureRegistry
{
	public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(
			Registries.FEATURE, TheBackrooms.MODID);

	public static final Supplier<Feature<NoclipPatchConfiguration>> NOCLIP_PATCH = FEATURES.register(
			"noclip_patch",
			() -> new NoclipPatchFeature(NoclipPatchConfiguration.CODEC));


	public static void register(IEventBus bus)
	{
		FEATURES.register(bus);
	}
}
