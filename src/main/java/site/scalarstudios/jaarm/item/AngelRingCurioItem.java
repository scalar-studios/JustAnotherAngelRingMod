package site.scalarstudios.jaarm.item;

import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import top.theillusivec4.curios.api.CuriosApi;
import top.theillusivec4.curios.api.SlotContext;
import top.theillusivec4.curios.api.type.capability.ICurioItem;

public class AngelRingCurioItem extends Item implements ICurioItem {
    private static final String GRANTED_FLIGHT_TAG = "jaarm_granted_flight";

    public AngelRingCurioItem(Properties properties) {
        super(properties.stacksTo(1));
    }

    @Override
    public void curioTick(SlotContext slotContext, ItemStack stack) {
        Entity entity = slotContext.entity();

        if (!(entity instanceof Player player) || player.isCreative() || player.isSpectator()) {
            return;
        }

        if (!player.getAbilities().mayfly) {
            player.getAbilities().mayfly = true;
            player.getPersistentData().putBoolean(GRANTED_FLIGHT_TAG, true);
            syncAbilities(player);
        }

        ICurioItem.super.curioTick(slotContext, stack);
    }

    @Override
    public void onUnequip(SlotContext slotContext, ItemStack newStack, ItemStack stack) {
        Entity entity = slotContext.entity();

        if (!(entity instanceof Player player) || player.isCreative() || player.isSpectator()) {
            return;
        }

        if (!player.getPersistentData().getBoolean(GRANTED_FLIGHT_TAG).orElse(false)) {
            return;
        }

        boolean hasAnotherAngelRing = CuriosApi.getCuriosInventory(player)
                .map(handler -> handler.isEquipped(otherStack -> otherStack.getItem() instanceof AngelRingCurioItem))
                .orElse(false);

        if (hasAnotherAngelRing) {
            return;
        }

        player.getAbilities().mayfly = false;

        if (player.getAbilities().flying) {
            player.getAbilities().flying = false;
        }

        player.getPersistentData().remove(GRANTED_FLIGHT_TAG);
        syncAbilities(player);

        ICurioItem.super.onUnequip(slotContext, newStack, stack);
    }

    private static void syncAbilities(Player player) {
        if (player instanceof ServerPlayer serverPlayer) {
            serverPlayer.onUpdateAbilities();
        }
    }
}
