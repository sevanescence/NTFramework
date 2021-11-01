package com.makotomiyamoto.nt.ntframework.quest;

/**
 * A template interface for quest objectives in the NT quest framework.
 * The types of objectives a quest has is completely up to the
 * implementations of QuestObjective, many trivial quest objectives
 * are already provided by the framework.
 *
 * @author MakotoMiyamoto
 */
public interface QuestObjective {
    /**
     * Gets the name of an objective. Not to confuse with the
     * title of the encapsulating quest.
     * @return an objective title
     */
    String getName();

    /**
     * Gets the general description of an objective.
     * @return an objective description
     */
    String getDescription();

    /**
     * Gets the progress description of an objective. A progress description
     * describes steps taken to complete a quest (e.g., monsters killed, etc.).
     * @return an objective progression body
     */
    String getProgressBody();

    /**
     * Sets the name of an objective. This likely will not be used outside
     * initializing an objective during deserialization (unless dynamic
     * content, perhaps?).
     * @param name The name of an objective
     */
    void setName(String name);

    /**
     * <p>
     * Sets the description of an objective. The general description does not
     * describe the progress of a quest objective (see {@link #setProgressBodyTemplate(String)}),
     * but rather a simple abstract that describes the general idea of an objective.
     * </p>
     * @param description The abstract of an objective
     */
    void setDescription(String description);

    /**
     * Sets the progress description of an objective. This describes what progress has
     * been made on an objective and/or what is required of an objective as it
     * progresses. Should support Printf-style formatting, and is completely up to the
     * implementation by implementing classes.
     * @param template The template for an objective progress body
     */
    void setProgressBodyTemplate(String template);

    /**
     * Checks whether the progress condition for an objective is satisfied. This should
     * be used to check if an objective is complete and can progress to the next.
     * @return Whether the winning condition is satisfied
     */
    boolean isWinningConditionSatisfied();

    /**
     * If an objective has a reward (this can include quest items that pertain to a quest),
     * it should be awarded when said objective is complete.
     * @return a quest completion reward
     */
    QuestCompletionReward getQuestCompletionReward();

    /**
     * Returns the next quest objective. This should return null if this objective is the
     * final objective.
     * @return a quest objective
     */
    QuestObjective getNextObjective();
}
