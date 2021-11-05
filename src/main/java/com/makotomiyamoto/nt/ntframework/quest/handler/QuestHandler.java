package com.makotomiyamoto.nt.ntframework.quest.handler;

import com.makotomiyamoto.nt.ntframework.quest.Quest;
import com.makotomiyamoto.nt.ntframework.quest.objective.QuestObjective;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.List;

/**
 * The purpose of a QuestHandler is to manage Bukkit event listeners
 * in conjunction with the NTFramework library. QuestHandlers should
 * be members of active quests in order to know when an action is
 * performed by a player in order to advance the quest objective.
 * QuestHandlers should be coupled with {@link QuestObjective QuestObjectives}
 * and thus their listeners must be unregistered from the Bukkit API
 * upon their deletion, lest performance leaks occur.
 * @param <ObjectiveType> an implementation of {@link QuestObjective}
 */
public interface QuestHandler<ObjectiveType extends QuestObjective> {
    /**
     * Gets the list of (assumed to be) registered event listeners. It is not
     * recommended that you add event listeners to this list unless you know
     * they are registered. To add an event to the list and register it, use
     * {@link #registerListener(Listener, JavaPlugin)} instead.
     * @return a list of {@link Listener Listeners}
     */
    List<Listener> getListeners();

    /**
     * Gets the current objective, which is assumed to be an objective
     * coupled to a player rather than a reference to the default {@link Quest quest object}.
     * @return a quest objective
     */
    ObjectiveType getObjective();

    /**
     * Adds a Bukkit event listener to {@link #getListeners()} and registers the listener
     * with the Bukkit API.
     * @param listener a Bukkit event listener
     */
    void registerListener(Listener listener, JavaPlugin plugin);

    /**
     * Unregisters all listeners in {@link #getListeners()}
     */
    void unregisterListeners();

    void initialize(JavaPlugin plugin);
}
