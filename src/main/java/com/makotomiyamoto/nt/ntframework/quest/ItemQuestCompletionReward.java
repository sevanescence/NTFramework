package com.makotomiyamoto.nt.ntframework.quest;

import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class ItemQuestCompletionReward implements QuestCompletionReward<ItemReward> {
    private final ArrayList<ItemReward> itemRewards = new ArrayList<>();

    public ItemQuestCompletionReward(ItemStack ... itemStacks) {
        Stream.of(itemStacks).forEach(itemStack -> itemRewards.add(new ItemReward(itemStack)));
    }

    @Override
    public List<ItemReward> getRewards() {
        return itemRewards;
    }
}
