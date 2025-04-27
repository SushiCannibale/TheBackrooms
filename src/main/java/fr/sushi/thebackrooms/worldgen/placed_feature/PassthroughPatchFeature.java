package fr.sushi.thebackrooms.worldgen.placed_feature;

import com.mojang.serialization.Codec;
import fr.sushi.thebackrooms.registry.BlockRegistry;
import fr.sushi.thebackrooms.worldgen.configured_feature.PassthroughPatchConfiguration;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.DiskConfiguration;

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
		PassthroughPatchConfiguration config = ctx.config();
		BlockPos blockpos = ctx.origin();
		WorldGenLevel worldgenlevel = ctx.level();
		RandomSource randomsource = ctx.random();
		boolean flag = false;
		int i = blockpos.getY();
		int j = i + config.maxHalfHeight();
		int k = i - config.maxHalfHeight() - 1;
		int l = config.radius().sample(randomsource);
		BlockPos.MutableBlockPos blockpos$mutableblockpos = new BlockPos.MutableBlockPos();

		for (BlockPos blockpos1 : BlockPos.betweenClosed(blockpos.offset(-l, 0, -l), blockpos.offset(l, 0, l)))
		{
			int i1 = blockpos1.getX() - blockpos.getX();
			int j1 = blockpos1.getZ() - blockpos.getZ();
			if (i1 * i1 + j1 * j1 <= l * l)
			{
				flag |= this.placeColumn(
						config, worldgenlevel, randomsource, j, k, blockpos$mutableblockpos.set(blockpos1));
			}
		}

		return flag;
//		BlockPos origin = ctx.origin();
//		WorldGenLevel level = ctx.level();
//
//		// int y = ctx.config().maxHalfHeight();
//		boolean succeeded = false;
//		int rad = ctx.config().radius().sample(ctx.random());
//		for (BlockPos pos : BlockPos.betweenClosed(origin.offset(-rad, 0, -rad), origin.offset(+rad, 0, +rad)))
//		{
//			int x = pos.getX() - origin.getX();
//			int z = pos.getZ() - origin.getZ();
//
//			if (x * x + z * z <= rad * rad)
//			{
//				for (int y = -ctx.config().maxHalfHeight() + 1; y < ctx.config().maxHalfHeight(); y++)
//				{
////					placeColumn();
//				}
//			}
//		}
//		return false;
	}

	protected boolean placeColumn(PassthroughPatchConfiguration config, WorldGenLevel level, RandomSource random, int maxY, int minY, BlockPos.MutableBlockPos pos) {
		boolean flag = false;
		boolean flag1 = false;

		for(int i = maxY; i > minY; --i) {
			pos.setY(i);
			if (config.target().test(level, pos)) {
				// TODO: copy current blockstate into ClipthroughBlock's default state
				BlockState blockstate = BlockRegistry.CLIPTHROUGH_BLOCK.get().defaultBlockState();
				level.setBlock(pos, blockstate, 2);
				if (!flag1) {
					this.markAboveForPostProcessing(level, pos);
				}

				flag = true;
				flag1 = true;
			} else {
				flag1 = false;
			}
		}

		return flag;
	}
}
