package com.makotomiyamoto.nt.ntframework.quest;

import java.util.Collection;

/**
 * Describes the types of rewards players can receive for completing quests
 * or objectives. The reward type can be anything from a container to
 * something that describes an action or any other user-defined operation.
 *
 * This class is extremely generic (no pun intended) and simply serves as
 * a frame for more sophisticated quest reward operations.
 * @param <RewardType> Type of reward, must be a {@link IReward}
 */
public interface QuestCompletionReward<RewardType extends IReward> {
    /**
     * Gets a collection of RewardType whose type and functionality is
     * completely up to the user implementation.
     * @return A collection of rewards
     */
    Collection<RewardType> getRewards();
}
