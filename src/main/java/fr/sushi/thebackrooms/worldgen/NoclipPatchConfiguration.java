package fr.sushi.thebackrooms.worldgen;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;

public record NoclipPatchConfiguration(BlockPredicate target, IntProvider radius, int maxHalfHeight) implements FeatureConfiguration {
    public static final Codec<NoclipPatchConfiguration> CODEC = RecordCodecBuilder.create(
            configFeature -> configFeature.group(
                    BlockPredicate.CODEC.fieldOf("target").forGetter(NoclipPatchConfiguration::target),
                    IntProvider.codec(0, 8).fieldOf("radius").forGetter(NoclipPatchConfiguration::radius),
                    Codec.intRange(0, 4).fieldOf("max_half_height").forGetter(NoclipPatchConfiguration::maxHalfHeight)
            ).apply(configFeature, NoclipPatchConfiguration::new)
																						 );
}
