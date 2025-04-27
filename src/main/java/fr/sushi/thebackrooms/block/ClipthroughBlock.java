package fr.sushi.thebackrooms.block;

import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

/**
 * This block mimics the one that should've been placed by the natural generation. Like powder snow, players will start
 * sinking in this block when walked on.
 */
public class ClipthroughBlock extends Block
{
	public ClipthroughBlock(Properties properties)
	{
		super(properties);
	}

	@Override
	public @Nullable BlockState getStateForPlacement(BlockPlaceContext ctx)
	{
		// TODO: pick state of a neighbour
		return this.defaultBlockState();
	}
}
