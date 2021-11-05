package com.makotomiyamoto.nt.ntframework.quest;

import com.makotomiyamoto.nt.ntframework.NTFramework;
import com.makotomiyamoto.nt.ntframework.quest.objective.QuestObjective;
import com.makotomiyamoto.nt.ntframework.quest.reward.RewardFailedException;
import org.bukkit.entity.Player;

public class ActivePlayerQuest implements PlayerQuest {
    private final String questKey;
    private final Player player;
    private QuestObjective currentObjective;

    public ActivePlayerQuest(String questKey, Player player) {
        this.questKey = questKey;
        this.player = player;
        try {
            this.currentObjective = (QuestObjective) getQuest().getHead().clone();
        } catch (CloneNotSupportedException ignored) {
            System.out.println("Clone error lol");
        }
    }

    public ActivePlayerQuest(String questKey, Player player, QuestObjective currentObjective) {
        this.questKey = questKey;
        this.player = player;

        try {
            this.currentObjective = (QuestObjective) currentObjective.clone();
        } catch (CloneNotSupportedException ignored) {
            System.out.println("Clone error lol");
        }
    }

    @Override
    public Quest getQuest() {
        return NTFramework.getQuests().get(questKey);
    }

    @Override
    public Player getPlayer() {
        return player;
    }

    @Override
    public QuestObjective getCurrentObjective() {
        return currentObjective;
    }

    @Override
    public boolean advanceObjective() throws RewardFailedException {
        if (currentObjective.getQuestCompletionReward() != null) {
            QuestUtils.grantQuestReward(currentObjective.getQuestCompletionReward(), player);
        }

        currentObjective = currentObjective.getNextObjective();
        return currentObjective != null;
    }
}
