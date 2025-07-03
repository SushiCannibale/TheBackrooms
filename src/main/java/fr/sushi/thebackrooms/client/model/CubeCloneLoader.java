package fr.sushi.thebackrooms.client.model;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import fr.sushi.thebackrooms.TheBackrooms;
import net.minecraft.client.resources.model.UnbakedModel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.server.packs.resources.ResourceManagerReloadListener;
import net.neoforged.neoforge.client.model.UnbakedModelLoader;

public class CubeCloneLoader implements UnbakedModelLoader<NoclipModel.Unbaked>, ResourceManagerReloadListener
{
	public static final CubeCloneLoader INSTANCE = new CubeCloneLoader();
	private CubeCloneLoader() {}

	public static final ResourceLocation ID = ResourceLocation.fromNamespaceAndPath(
			TheBackrooms.MODID, "cube_clone_loader");


	@Override
	public NoclipModel.Unbaked read(JsonObject jsonObject, JsonDeserializationContext ctx) throws JsonParseException
	{
		jsonObject.remove("loader");
		UnbakedModel wrapper = ctx.deserialize(jsonObject, UnbakedModel.class);
		return new NoclipModel.Unbaked(wrapper);
	}

	@Override
	public void onResourceManagerReload(ResourceManager resourceManager)
	{
	}
}
