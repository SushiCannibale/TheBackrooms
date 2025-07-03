package fr.sushi.thebackrooms.client;

import fr.sushi.thebackrooms.TheBackrooms;
import fr.sushi.thebackrooms.client.model.CubeCloneLoader;
import fr.sushi.thebackrooms.client.model.NoclipModel;
import fr.sushi.thebackrooms.common.registry.BlockRegistry;
import net.minecraft.client.renderer.block.BlockModelShaper;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.ModelEvent;

@EventBusSubscriber(modid = TheBackrooms.MODID, value = Dist.CLIENT, bus = EventBusSubscriber.Bus.MOD)
public class ClientEventHandler
{
	@SubscribeEvent
	public static void registerUnbakedLoaders(ModelEvent.RegisterLoaders event)
	{
		event.register(CubeCloneLoader.ID, CubeCloneLoader.INSTANCE);
	}

	@SubscribeEvent
	public static void modifyBakingResult(ModelEvent.ModifyBakingResult event)
	{
		event.getBakingResult().blockStateModels().computeIfPresent(
				BlockModelShaper.stateToModelLocation(BlockRegistry.NOCLIP_BLOCK.get().defaultBlockState()),
				(location, model) -> new NoclipModel.Baked(model));
	}
}
