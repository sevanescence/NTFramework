package com.makotomiyamoto.nt.ntframework.quest;

import org.bukkit.entity.Player;

/**
 * Describes a quest currently occupied by a player.
 * @param <ObjectiveType> The type of quest objective.
 *
 * @author MakotoMiyamoto
 */
public interface PlayerQuest<ObjectiveType extends QuestObjective> {
    /**
     * Gets the quest a player is on.
     * @return a quest
     */
    Quest getQuest();

    /**
     * Gets the player.
     * @return a player
     */
    Player getPlayer();

    /**
     * Gets the current objective of a quest a player is on. The initial
     * value of the current objective should be the head of encompassing
     * quest.
     * @return a quest objective
     */
    ObjectiveType getCurrentObjective();

    /**
     * Sets the current quest objective to the next objective of a quest.
     * If the next objective does not exist (i.e., it is null) then it
     * must return false. Otherwise, return true.
     * @return whether the next objective is null
     * @throws UnrewardableRewardException if the objective reward cannot be granted
     */
    boolean advanceObjective() throws UnrewardableRewardException;
}
