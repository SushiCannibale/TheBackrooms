package fr.sushi.thebackrooms.datagen;

import fr.sushi.thebackrooms.TheBackrooms;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.data.event.GatherDataEvent;

import java.util.Set;

@EventBusSubscriber(modid = TheBackrooms.MODID, bus = EventBusSubscriber.Bus.MOD)
public class ModDataGenerators
{
	@SubscribeEvent
	public static void onDataGatherServer(GatherDataEvent.Server event)
	{
		event.addProvider(new ModDatapackProvider(event.getGenerator().getPackOutput(),
												  event.getLookupProvider(),
												  Set.of(TheBackrooms.MODID)));
	}

	@SubscribeEvent
	public static void onDataGatherClient(GatherDataEvent.Client event)
	{
		event.addProvider(new ModDatapackProvider(event.getGenerator().getPackOutput(),
												  event.getLookupProvider(),
												  Set.of(TheBackrooms.MODID)));
	}
}
