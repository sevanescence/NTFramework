package com.makotomiyamoto.nt.ntframework.quest.reward;

import com.makotomiyamoto.nt.ntframework.quest.reward.IReward;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.Arrays;

public class ItemReward implements IReward {
    private ItemStack itemStack;

    public ItemReward(ItemStack itemStack) {
        this.itemStack = itemStack;
    }

    @Override
    public boolean isRewardable(Player player) {
        return player.getInventory().firstEmpty() != -1 || Arrays.stream(player.getInventory().getStorageContents()).allMatch(itemStack -> itemStack.isSimilar(this.itemStack));
    }

    public ItemStack getItemStack() {
        return itemStack;
    }

    public void setItemStack(ItemStack itemStack) {
        this.itemStack = itemStack.clone();
    }
}
