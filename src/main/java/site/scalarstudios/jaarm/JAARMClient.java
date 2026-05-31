package site.scalarstudios.jaarm;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;

@Mod(value = JAARM.MODID, dist = Dist.CLIENT)
@EventBusSubscriber(modid = JAARM.MODID, value = Dist.CLIENT)
public class JAARMClient {
    public JAARMClient(ModContainer container) {
    }

    @SubscribeEvent
    static void onClientSetup(FMLClientSetupEvent event) {}
}
