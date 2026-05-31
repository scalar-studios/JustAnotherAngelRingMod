package site.scalarstudios.jaarm.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import site.scalarstudios.jaarm.JAARM;

public class JAARMCreativeTab {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, JAARM.MODID);

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> JAARM_ITEMS_TAB = CREATIVE_MODE_TABS.register("jaarm_items", () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.jaarm.items"))
            .icon(() -> new ItemStack(JAARMItems.ANGEL_RING.get()))
            .build());

    public static void registerTab(BuildCreativeModeTabContentsEvent event) {
        if (event.getTab() == JAARM_ITEMS_TAB.get()) {
            event.accept(JAARMItems.ANGEL_RING.get());
        }
    }

    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
