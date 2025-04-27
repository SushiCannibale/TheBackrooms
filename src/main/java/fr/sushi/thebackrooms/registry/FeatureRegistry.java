package fr.sushi.thebackrooms.registry;

import fr.sushi.thebackrooms.TheBackrooms;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

public class FeatureRegistry
{
	public static final ResourceKey<ConfiguredFeature<?, ?>> FEATURE_NOCLIP_DIRT = ResourceKey.create(
			Registries.CONFIGURED_FEATURE,
			ResourceLocation.fromNamespaceAndPath(TheBackrooms.MODID, "noclip_dirt"));

	public static final ResourceKey<PlacedFeature> NOCLIP_DIRT = ResourceKey.create(
			Registries.PLACED_FEATURE,
			ResourceLocation.fromNamespaceAndPath(
					TheBackrooms.MODID, "noclip_dirt"));

	public static void loadClass() {

	}
}
