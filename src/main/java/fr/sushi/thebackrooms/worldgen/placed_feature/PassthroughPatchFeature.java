package fr.sushi.thebackrooms.worldgen.placed_feature;

import com.mojang.serialization.Codec;
import fr.sushi.thebackrooms.worldgen.configured_feature.PassthroughPatchConfiguration;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.chunk.BulkSectionAccess;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;

public class PassthroughPatchFeature extends Feature<PassthroughPatchConfiguration>
{
	public PassthroughPatchFeature(Codec<PassthroughPatchConfiguration> codec)
	{
		super(codec);
	}

	// We're placing noclip blocks in a disk-like shape at ground level, extending up to `halfHeight` blocks
	@Override
	public boolean place(FeaturePlaceContext<PassthroughPatchConfiguration> ctx)
	{
		BlockPos origin = ctx.origin();
		WorldGenLevel level = ctx.level();
		BulkSectionAccess access = new BulkSectionAccess(level);

		// int y = ctx.config().maxHalfHeight();
		boolean succeeded = false;
		int rad = ctx.config().radius().sample(ctx.random());
		for (BlockPos pos : BlockPos.betweenClosed(origin.offset(-rad, 0, -rad), origin.offset(+rad, 0, +rad)))
		{
			int x = pos.getX() - origin.getX();
			int z = pos.getZ() - origin.getZ();

			if (x * x + z * z <= rad * rad)
			{
				for (int y = -ctx.config().maxHalfHeight() + 1; y < ctx.config().maxHalfHeight(); y++)
				{
//					placeColumn();
				}
			}
		}
		return false;
	}
}
