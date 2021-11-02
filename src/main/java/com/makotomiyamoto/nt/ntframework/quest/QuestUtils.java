package com.makotomiyamoto.nt.ntframework.quest;

import org.bukkit.entity.Player;

public class QuestUtils {
    public static void grantQuestReward(QuestCompletionReward<? extends IReward> questCompletionReward, Player player) throws UnrewardableRewardException {
        if (questCompletionReward instanceof ItemQuestCompletionReward) {
            ItemQuestCompletionReward itemReward = (ItemQuestCompletionReward) questCompletionReward;
            boolean rewardable = itemReward.getRewards().stream().noneMatch(rewardIterator -> rewardIterator.isRewardable(player));
            if (rewardable) {
                // TODO reward player
                player.sendMessage("Quest rewarding hasn't been implemented yet. LOL!");
            } else {
                throw new UnrewardableRewardException("Insufficient player inventory space to reward items.");
            }
        }
    }
}
