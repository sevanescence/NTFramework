package com.makotomiyamoto.nt.ntframework.quest;

import com.makotomiyamoto.nt.ntframework.quest.handler.QuestHandler;
import com.makotomiyamoto.nt.ntframework.quest.objective.QuestObjective;
import com.makotomiyamoto.nt.ntframework.quest.reward.RewardFailedException;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Describes a quest currently occupied by a player.
 *
 * @author MakotoMiyamoto
 */
public interface PlayerQuest {
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
    QuestObjective getCurrentObjective();

    QuestHandler<? extends QuestObjective> getQuestHandler();

    /**
     * Sets the current quest objective to the next objective of a quest.
     * If the next objective does not exist (i.e., it is null) then it
     * must return false. Otherwise, return true.
     * @return whether the next objective is null
     * @throws RewardFailedException if the objective reward cannot be granted
     */
    boolean advanceObjective() throws RewardFailedException;

    void initialize();

    void uninitialize();
}
