package fr.sushi.thebackrooms;

import net.minecraft.client.resources.model.DelegateBakedModel;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;

@EventBusSubscriber(modid = TheBackrooms.MODID, value = Dist.CLIENT, bus = EventBusSubscriber.Bus.MOD)
public class ClientEvents
{
	@SubscribeEvent
	public void registerRenderer(EntityRenderersEvent.RegisterRenderers event) {

	}
}
