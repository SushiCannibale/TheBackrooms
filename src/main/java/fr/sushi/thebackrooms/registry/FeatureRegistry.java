package fr.sushi.thebackrooms.registry;

import fr.sushi.thebackrooms.TheBackrooms;
import fr.sushi.thebackrooms.worldgen.configured_feature.PassthroughPatchConfiguration;
import fr.sushi.thebackrooms.worldgen.placed_feature.PassthroughPatchFeature;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class FeatureRegistry
{
	public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(
			Registries.FEATURE, TheBackrooms.MODID);

	public static final DeferredHolder<Feature<?>, PassthroughPatchFeature> PASSTHROUGH_PATCH = FEATURES.register(
			"passthrough_patch", () -> new PassthroughPatchFeature(PassthroughPatchConfiguration.CODEC));

	public static void register(IEventBus bus)
	{
		FEATURES.register(bus);
	}
}
