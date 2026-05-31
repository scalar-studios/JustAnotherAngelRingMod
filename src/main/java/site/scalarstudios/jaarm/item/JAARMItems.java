package site.scalarstudios.jaarm.item;

import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import site.scalarstudios.jaarm.JAARM;

public class JAARMItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(JAARM.MODID);

    public static final DeferredItem<Item> ANGEL_RING = ITEMS.registerItem("angel_ring", AngelRingCurioItem::new);

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
