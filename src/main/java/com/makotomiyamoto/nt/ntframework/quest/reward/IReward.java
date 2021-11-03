package com.makotomiyamoto.nt.ntframework.quest.reward;

import org.bukkit.entity.Player;

/**
 * Represents a reward given to a player for completing an objective.
 *
 * @author MakotoMiyamoto
 */
public interface IReward {
    /**
     * Gets whether a <code>player</code> is capable of receiving a reward.
     * @param player a player
     * @return whether the reward can be granted
     */
    boolean isRewardable(Player player);
}
