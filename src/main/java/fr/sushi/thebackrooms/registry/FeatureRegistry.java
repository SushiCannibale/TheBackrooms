package fr.sushi.thebackrooms.registry;

import fr.sushi.thebackrooms.TheBackrooms;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

public class FeatureRegistry
{
	public static final ResourceKey<ConfiguredFeature<?, ?>> CONFIGURED_NOCLIP_DIRT = ResourceKey.create(
			Registries.CONFIGURED_FEATURE,
			ResourceLocation.fromNamespaceAndPath(TheBackrooms.MODID, "noclip_dirt"));

	public static final ResourceKey<PlacedFeature> PLACED_NOCLIP_DIRT = ResourceKey.create(
			Registries.PLACED_FEATURE,
			ResourceLocation.fromNamespaceAndPath(
					TheBackrooms.MODID, "noclip_dirt"));

	public static void setupConfigured(BootstrapContext<ConfiguredFeature<?, ?>> ctx)
	{
//		HolderGetter<ConfiguredFeature<?, ?>> holdgetter = ctx.lookup(Registries.CONFIGURED_FEATURE);
		FeatureUtils.register(ctx,
							  CONFIGURED_NOCLIP_DIRT,
							  Feature.NO_OP);
	}

	public static void setupPlaced(BootstrapContext<PlacedFeature> ctx)
	{
		HolderGetter<ConfiguredFeature<?, ?>> holdergetter = ctx.lookup(Registries.CONFIGURED_FEATURE);

		PlacementUtils.register(ctx,
								PLACED_NOCLIP_DIRT,
								holdergetter.getOrThrow(CONFIGURED_NOCLIP_DIRT));
	}
}
