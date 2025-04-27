package fr.sushi.thebackrooms.datagen;

import fr.sushi.thebackrooms.registry.FeatureRegistry;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.DatapackBuiltinEntriesProvider;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class ModDatapackProvider extends DatapackBuiltinEntriesProvider
{
	public static final RegistrySetBuilder BUILDER = new RegistrySetBuilder()
			.add(Registries.CONFIGURED_FEATURE, FeatureRegistry::setupConfigured)
			.add(Registries.PLACED_FEATURE, FeatureRegistry::setupPlaced);

	public ModDatapackProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries, Set<String> modIds)
	{
		super(output, registries, BUILDER, modIds);
	}
}
