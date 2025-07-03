package fr.sushi.thebackrooms.client.model;

import net.minecraft.client.renderer.block.model.ItemTransforms;
import net.minecraft.client.renderer.block.model.TextureSlots;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.client.resources.model.ModelBaker;
import net.minecraft.client.resources.model.ModelState;
import net.minecraft.client.resources.model.UnbakedModel;
import net.minecraft.util.context.ContextMap;
import net.neoforged.neoforge.client.model.DelegateUnbakedModel;

public class NoclipUnbakedModel extends DelegateUnbakedModel
{
	protected NoclipUnbakedModel(UnbakedModel wrapped)
	{
		super(wrapped);
	}

	@Override
	public BakedModel bake(TextureSlots textures, ModelBaker baker, ModelState modelState, boolean useAmbientOcclusion, boolean usesBlockLight, ItemTransforms itemTransforms, ContextMap additionalProperties)
	{
		return super.bake(textures,
				baker,
				modelState,
				useAmbientOcclusion,
				usesBlockLight,
				itemTransforms,
				additionalProperties);
	}
}
