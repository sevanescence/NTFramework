package com.makotomiyamoto.nt.ntframework.quest.handler;

import com.makotomiyamoto.nt.ntframework.quest.ActivePlayerQuest;
import com.makotomiyamoto.nt.ntframework.quest.objective.ItemPickupQuestObjective;
import com.makotomiyamoto.nt.ntframework.quest.objective.QuantitativeObjective;
import com.makotomiyamoto.nt.ntframework.quest.reward.RewardFailedException;
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

        ItemPickupQuestObjective objective = (ItemPickupQuestObjective) activePlayerQuest.getCurrentObjective();
        // TODO NT item ID system. For now, just use isSimilar and get the stack count of the item.
        if (event.getItem().getItemStack().isSimilar(this.itemStack)) {
            objective.setCurrent(objective.getCurrent() + event.getItem().getItemStack().getAmount());
            event.getEntity().sendMessage("Retrieved x%d of %s".formatted(event.getItem().getItemStack().getAmount(), event.getItem().getItemStack().getType().toString()));
        }
        // TODO handle this in a separate event listener since every quest has to do this
        if (objective.isWinningConditionSatisfied()) {
            event.getEntity().sendMessage("Objective complete: %s".formatted(objective.getDescription()));
            this.activePlayerQuest.getQuestHandler().unregisterListeners();
            try {
                if (! this.activePlayerQuest.advanceObjective()) {
                    event.getEntity().sendMessage("End of quest.");
                }
            } catch (RewardFailedException ignored) {
                System.out.println("Error: failed to reward.");
            }
        }

//        ItemPickupQuestObjective safelyAssumedObjectiveType = ((ItemPickupQuestObjective) activePlayerQuest.getCurrentObjective());
//        // TODO NT item ID system. For now, just use isSimilar and get the stack count of the item.
//        if (event.getItem().getItemStack().isSimilar(this.itemStack)) {
//            safelyAssumedObjectiveType.setCurrent(safelyAssumedObjectiveType.getCurrent() + event.getItem().getItemStack().getAmount());
//            if (event.getEntity() instanceof Player) {
//                event.getEntity().sendMessage("Retrieved x%d of %s".formatted( event.getItem().getItemStack().getAmount(), event.getItem().getItemStack().getType().toString() ));
//            }
//        }
//        if (safelyAssumedObjectiveType.getCurrent() >= safelyAssumedObjectiveType.getRequirement()) {
//            event.getEntity().sendMessage("Objective complete");
//            safelyAssumedObjectiveType.getQuantitativeQuestHandler().unregisterListeners();
//        }
    }

    // TODO add listener for loss of items as well
}
