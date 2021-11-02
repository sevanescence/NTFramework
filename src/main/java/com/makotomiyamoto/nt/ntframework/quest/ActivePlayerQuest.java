package com.makotomiyamoto.nt.ntframework.quest;

import org.bukkit.entity.Player;

public class ActivePlayerQuest implements PlayerQuest<QuestObjective> {
    private final Quest quest;
    private final Player player;
    private QuestObjective currentObjective;

    public ActivePlayerQuest(Quest quest, Player player) {
        this.quest = quest;
        this.player = player;
        this.currentObjective = quest.getHead();
    }

    @Override
    public Quest getQuest() {
        return quest;
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
    public boolean advanceObjective() throws UnrewardableRewardException {
        if (currentObjective.getQuestCompletionReward() != null) {
            QuestUtils.grantQuestReward(currentObjective.getQuestCompletionReward(), player);
        }

        currentObjective = currentObjective.getNextObjective();
        return currentObjective != null;
    }
}
