package com.makotomiyamoto.nt.ntframework.quest.handler;

import com.makotomiyamoto.nt.ntframework.quest.ActivePlayerQuest;
import com.makotomiyamoto.nt.ntframework.quest.objective.ItemPickupQuestObjective;
import com.makotomiyamoto.nt.ntframework.quest.objective.QuantitativeObjective;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityPickupItemEvent;
import org.bukkit.inventory.ItemStack;

public class ItemEventListener implements Listener {
    private final ActivePlayerQuest activePlayerQuest;
    private final ItemStack itemStack;

    public ItemEventListener(ActivePlayerQuest activePlayerQuest, ItemStack itemStack) {
        this.activePlayerQuest = activePlayerQuest;
        this.itemStack = itemStack;
    }

    @EventHandler
    public void onItemPickup(EntityPickupItemEvent event) {
        if (! event.getEntity().getUniqueId().equals(activePlayerQuest.getPlayer().getUniqueId())) return;

        ItemPickupQuestObjective safelyAssumedObjectiveType = ((ItemPickupQuestObjective) activePlayerQuest.getCurrentObjective());
        // TODO NT item ID system. For now, just use isSimilar and get the stack count of the item.
        if (event.getItem().getItemStack().isSimilar(this.itemStack)) {
            safelyAssumedObjectiveType.setCurrent(safelyAssumedObjectiveType.getCurrent() + event.getItem().getItemStack().getAmount());
            if (event.getEntity() instanceof Player) {
                event.getEntity().sendMessage("Retrieved x%d of %s".formatted( event.getItem().getItemStack().getAmount(), event.getItem().getItemStack().getType().toString() ));
            }
        }
        if (safelyAssumedObjectiveType.getCurrent() >= safelyAssumedObjectiveType.getRequirement()) {
            event.getEntity().sendMessage("Objective complete");
            safelyAssumedObjectiveType.getQuantitativeQuestHandler().unregisterListeners();
        }
    }

    // TODO add listener for loss of items as well
}