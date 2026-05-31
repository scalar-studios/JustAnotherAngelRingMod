package site.scalarstudios.jaarm;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import site.scalarstudios.jaarm.item.JAARMCreativeTab;
import site.scalarstudios.jaarm.item.JAARMItems;

@Mod(JAARM.MODID)
public class JAARM {
    public static final String MODID = "jaarm";

    public JAARM(IEventBus modEventBus, ModContainer modContainer) {
        modEventBus.addListener(this::commonSetup);

        // Register Items
        JAARMItems.register(modEventBus);

        // Register Creative Tabs
        JAARMCreativeTab.register(modEventBus);
        modEventBus.addListener(JAARMCreativeTab::registerTab);

        NeoForge.EVENT_BUS.register(this);
    }

    private void commonSetup(FMLCommonSetupEvent event) {}

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {}
}
