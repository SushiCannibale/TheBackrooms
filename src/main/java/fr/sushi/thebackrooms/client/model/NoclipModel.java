package fr.sushi.thebackrooms.client.model;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.block.BlockModelShaper;
import net.minecraft.client.renderer.block.model.BakedQuad;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.resources.model.*;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.client.model.DelegateUnbakedModel;
import net.neoforged.neoforge.client.model.IDynamicBakedModel;
import net.neoforged.neoforge.client.model.data.ModelData;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class NoclipModel
{
	public static class Unbaked extends DelegateUnbakedModel
	{
		protected Unbaked(UnbakedModel wrapped)
		{
			super(wrapped);
		}
	}

	public static class Baked extends DelegateBakedModel
	{
		public Baked(BakedModel parent)
		{
			super(parent);
		}

		@Override
		public @NotNull List<BakedQuad> getQuads(@Nullable BlockState blockstate, @Nullable Direction direction, RandomSource random, ModelData modelData, @Nullable RenderType renderType)
		{
			BlockState srcBlockstate = Blocks.BEDROCK.defaultBlockState();
			BlockModelShaper bms = Minecraft.getInstance().getModelManager().getBlockModelShaper();
			BakedModel model = bms.getBlockModel(srcBlockstate);

			return model.getQuads(srcBlockstate, direction, random, modelData, renderType);
		}
	}
}
