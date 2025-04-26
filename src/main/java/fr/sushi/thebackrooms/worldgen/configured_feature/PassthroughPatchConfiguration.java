package fr.sushi.thebackrooms.worldgen.configured_feature;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;

public record PassthroughPatchConfiguration(BlockPredicate target, IntProvider radius, int maxHalfHeight) implements FeatureConfiguration {
    public static final Codec<PassthroughPatchConfiguration> CODEC = RecordCodecBuilder.create(
            configFeature -> configFeature.group(
                    BlockPredicate.CODEC.fieldOf("target").forGetter(PassthroughPatchConfiguration::target),
                    IntProvider.codec(0, 8).fieldOf("radius").forGetter(PassthroughPatchConfiguration::radius),
                    Codec.intRange(0, 4).fieldOf("max_half_height").forGetter(PassthroughPatchConfiguration::maxHalfHeight)
            ).apply(configFeature, PassthroughPatchConfiguration::new)
    );
}
