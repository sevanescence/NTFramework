package com.makotomiyamoto.nt.ntframework.quest;

/**
 * A template interface which describes a quest objective whose premise
 * involves the use of a quantity, such as killing a certain number
 * of monsters or collecting a certain number of items.
 * {@link QuestObjective#isWinningConditionSatisfied()} should return
 * true when {@link QuantitativeObjective#getCurrent()} reaches
 * {@link QuantitativeObjective#getRequirement()}.
 *
 * @author MakotoMiyamoto
 */
public interface QuantitativeObjective extends QuestObjective {
    /**
     * Gets the current progress of a quantitative quest objective.
     * @return objective progress
     */
    int getCurrent();

    /**
     * Gets the requirement needed to satisfy {@link QuestObjective#isWinningConditionSatisfied()}.
     * @return objective requirement
     */
    int getRequirement();

    /**
     * A convenient function that increments the current progress of a quantitative objective.
     */
    void incrementCurrent();

    /**
     * Sets the progress of a quantitative quest objective to <code>current</code>
     * @param current objective progress
     */
    void setCurrent(int current);

    /**
     * Sets the requirement to progress to the next quest objective.
     * @param requirement objective requirement
     */
    void setRequirement(int requirement);
}
