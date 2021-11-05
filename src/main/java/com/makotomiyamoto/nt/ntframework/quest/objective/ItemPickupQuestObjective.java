package com.makotomiyamoto.nt.ntframework.quest.objective;

import com.makotomiyamoto.nt.ntframework.quest.handler.QuantitativeQuestHandler;
import org.bukkit.inventory.ItemStack;

public class ItemPickupQuestObjective extends ActionQuestObjective {
    private QuantitativeQuestHandler quantitativeQuestHandler;
    private ItemStack itemStack;

    public ItemPickupQuestObjective(String name, String description, int requirement) {
        super(name, description, requirement);
    }

    public QuantitativeQuestHandler getQuantitativeQuestHandler() {
        return quantitativeQuestHandler;
    }

    public void setQuantitativeQuestHandler(QuantitativeQuestHandler quantitativeQuestHandler) {
        this.quantitativeQuestHandler = quantitativeQuestHandler;
    }

    public ItemStack getItemStack() {
        return itemStack;
    }

    public void setItemStack(ItemStack itemStack) {
        this.itemStack = itemStack;
        setRequirement(itemStack.getAmount());
    }
}
