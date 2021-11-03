package com.makotomiyamoto.nt.ntframework.quest;

import com.makotomiyamoto.nt.ntframework.quest.objective.QuestObjective;
import com.makotomiyamoto.nt.ntframework.quest.reward.IReward;
import com.makotomiyamoto.nt.ntframework.quest.reward.QuestCompletionReward;

public class Quest {
    private String title;
    private String description;
    private QuestObjective head;
    private QuestCompletionReward<? extends IReward> questCompletionReward;

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public QuestObjective getHead() {
        return head;
    }

    public QuestCompletionReward<? extends IReward> getQuestCompletionReward() {
        return questCompletionReward;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setHead(QuestObjective head) {
        this.head = head;
    }

    public void setQuestCompletionReward(QuestCompletionReward<? extends IReward> questCompletionReward) {
        this.questCompletionReward = questCompletionReward;
    }
}
