package com.makotomiyamoto.nt.ntframework.quest.objective;

import org.bukkit.inventory.ItemStack;

public class ItemPickupQuestObjective extends ActionQuestObjective {
    // TODO change this to a list of ItemStacks
    private ItemStack itemStack;

    public ItemPickupQuestObjective(String name, String description, int requirement) {
        super(name, description, requirement);
    }

    public ItemStack getItemStack() {
        return itemStack;
    }

    public void setItemStack(ItemStack itemStack) {
        this.itemStack = itemStack;
        setRequirement(itemStack.getAmount());
    }
}
