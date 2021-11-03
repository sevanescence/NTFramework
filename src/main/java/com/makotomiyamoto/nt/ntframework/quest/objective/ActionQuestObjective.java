package com.makotomiyamoto.nt.ntframework.quest.objective;

import com.makotomiyamoto.nt.ntframework.quest.reward.IReward;
import com.makotomiyamoto.nt.ntframework.quest.reward.QuestCompletionReward;

public class ActionQuestObjective implements QuantitativeObjective {
    private String name;
    private String description;
    private String progressTemplate;
    private int current = 0;
    private int requirement;
    private QuestObjective nextObjective = null;
    private QuestCompletionReward<? extends IReward> questCompletionReward;

    public ActionQuestObjective(String name, String description, int requirement) {
        this.name = name;
        this.description = description;
        this.requirement = requirement;
    }

    @Override
    public int getCurrent() {
        return current;
    }

    @Override
    public int getRequirement() {
        return requirement;
    }

    @Override
    public void incrementCurrent() {
        ++current;
    }

    @Override
    public void setCurrent(int current) {
        this.current = current;
    }

    @Override
    public void setRequirement(int requirement) {
        this.requirement = requirement;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    // TODO change this
    @Override
    public String getProgressBody() {
        return progressTemplate;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public void setProgressBodyTemplate(String template) {
        this.progressTemplate = template;
    }

    @Override
    public boolean isWinningConditionSatisfied() {
        return getCurrent() >= getRequirement();
    }

    @Override
    public QuestCompletionReward<? extends IReward> getQuestCompletionReward() {
        return questCompletionReward;
    }

    @Override
    public void setQuestCompletionReward(QuestCompletionReward<? extends IReward> rewardQuestCompletionReward) {
        this.questCompletionReward = rewardQuestCompletionReward;
    }

    @Override
    public QuestObjective getNextObjective() {
        return nextObjective;
    }

    @Override
    public void setNextObjective(QuestObjective nextObjective) {
        this.nextObjective = nextObjective;
    }
}
