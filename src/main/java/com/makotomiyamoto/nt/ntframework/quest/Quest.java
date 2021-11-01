package com.makotomiyamoto.nt.ntframework.quest;

public class Quest {
    private String title;
    private String description;
    private QuestObjective head;
    private QuestCompletionReward questCompletionReward;

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public QuestObjective getHead() {
        return head;
    }

    public QuestCompletionReward getQuestCompletionReward() {
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

    public void setQuestCompletionReward(QuestCompletionReward questCompletionReward) {
        this.questCompletionReward = questCompletionReward;
    }
}
