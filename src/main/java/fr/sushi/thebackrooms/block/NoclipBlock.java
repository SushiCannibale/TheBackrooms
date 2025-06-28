package fr.sushi.thebackrooms.block;

import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;

///  TODO: DelegateBlockstateModel & ModifyBakingResult event
public class NoclipBlock extends Block
{
	public NoclipBlock(Properties properties)
	{
		super(properties);
	}

	@Override
	protected void entityInside(BlockState state, Level level, BlockPos pos, Entity entity)
	{
		entity.resetFallDistance();
		Vec3 delta = entity.getDeltaMovement();
		entity.setDeltaMovement(delta.multiply(1.0D, 0.05D, 1.0D));
	}

}
