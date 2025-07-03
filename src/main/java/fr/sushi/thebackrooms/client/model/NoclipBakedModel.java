package fr.sushi.thebackrooms.client.model;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.block.model.BakedQuad;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.client.resources.model.DelegateBakedModel;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.client.model.data.ModelData;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class NoclipBakedModel extends DelegateBakedModel
{
	public NoclipBakedModel(BakedModel parent)
	{
		super(parent);
	}

	// TODO: caching + model data for dynamic atlas sprite
	@Override
	public @NotNull List<BakedQuad> getQuads(@Nullable BlockState blockstate, @Nullable Direction direction, RandomSource random, ModelData modelData, @Nullable RenderType renderType)
	{
		var quads = new ArrayList<BakedQuad>();
		for (var bakedquad : this.parent.getQuads(blockstate, direction, random, modelData, renderType)) {
//			var sprite = Minecraft.getInstance()
//								  .getTextureAtlas(bakedquad.getSprite().atlasLocation())
//								  .apply();
//			var quad = new BakedQuad(bakedquad.getVertices(), bakedquad.getTintIndex(), bakedquad.getDirection(), sprite, bakedquad.isShade(),
//					bakedquad.getLightEmission(),
//					bakedquad.hasAmbientOcclusion());
			quads.add(bakedquad);
		}
		return quads;
	}
}
