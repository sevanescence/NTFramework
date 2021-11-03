package com.makotomiyamoto.nt.ntframework.quest;

import com.makotomiyamoto.nt.ntframework.quest.reward.IReward;
import com.makotomiyamoto.nt.ntframework.quest.reward.ItemQuestCompletionReward;
import com.makotomiyamoto.nt.ntframework.quest.reward.QuestCompletionReward;
import com.makotomiyamoto.nt.ntframework.quest.reward.RewardFailedException;
import org.bukkit.entity.Player;

public class QuestUtils {
    public static void grantQuestReward(QuestCompletionReward<? extends IReward> questCompletionReward, Player player) throws RewardFailedException {
        if (questCompletionReward instanceof ItemQuestCompletionReward) {
            ItemQuestCompletionReward itemReward = (ItemQuestCompletionReward) questCompletionReward;
            boolean rewardable = itemReward.getRewards().stream().noneMatch(rewardIterator -> rewardIterator.isRewardable(player));
            if (rewardable) {
                // TODO reward player
                player.sendMessage("Quest rewarding hasn't been implemented yet. LOL!");
            } else {
                throw new RewardFailedException("Insufficient player inventory space to reward items.", RewardFailedException.Reason.INVENTORY_FULL);
            }
        }
    }
}
