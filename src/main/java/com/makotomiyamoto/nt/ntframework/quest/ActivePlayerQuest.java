package com.makotomiyamoto.nt.ntframework.quest;

import com.makotomiyamoto.nt.ntframework.NTFramework;
import com.makotomiyamoto.nt.ntframework.quest.handler.ItemEventListener;
import com.makotomiyamoto.nt.ntframework.quest.handler.QuantitativeQuestHandler;
import com.makotomiyamoto.nt.ntframework.quest.handler.QuestHandler;
import com.makotomiyamoto.nt.ntframework.quest.objective.ItemPickupQuestObjective;
import com.makotomiyamoto.nt.ntframework.quest.objective.QuantitativeObjective;
import com.makotomiyamoto.nt.ntframework.quest.objective.QuestObjective;
import com.makotomiyamoto.nt.ntframework.quest.reward.RewardFailedException;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class ActivePlayerQuest implements PlayerQuest {
    private final String questKey;
    private final Player player;
    private QuestObjective currentObjective;
    private transient QuestHandler<? extends QuestObjective> questHandler;

    public ActivePlayerQuest(String questKey, Player player) {
        this(questKey, player, NTFramework.getQuests().get(questKey).getHead());
    }

    public ActivePlayerQuest(String questKey, Player player, QuestObjective currentObjective) {
        this.questKey = questKey;
        this.player = player;

        try {
            this.currentObjective = (QuestObjective) currentObjective.clone();
            for (QuestObjective iterator = this.currentObjective; iterator.getNextObjective() != null; iterator = iterator.getNextObjective()) {
                iterator.setNextObjective((QuestObjective) iterator.getNextObjective().clone());
            }
        } catch (CloneNotSupportedException ignored) {
            System.out.println("Clone error lol");
        }
    }

    /**
     * funny factory method to handle initialization on the back end
     * @param questKey The fact that you think I care about documentation here is laughable
     * @param player You know what these parameters are for.
     * @return an {@link ActivePlayerQuest}
     */
    public static ActivePlayerQuest createInitializedActiveQuest(String questKey, Player player) {
        ActivePlayerQuest quest = new ActivePlayerQuest(questKey, player);
        quest.initialize();
        return quest;
    }

    @Override
    public Quest getQuest() {
        return NTFramework.getQuests().get(questKey);
    }

    @Override
    public Player getPlayer() {
        return player;
    }

    @Override
    public QuestObjective getCurrentObjective() {
        return currentObjective;
    }

    @Override
    public QuestHandler<? extends QuestObjective> getQuestHandler() {
        return questHandler;
    }

    @Override
    public boolean advanceObjective() throws RewardFailedException {
        if (currentObjective.getQuestCompletionReward() != null) {
            QuestUtils.grantQuestReward(currentObjective.getQuestCompletionReward(), player);
        }
        currentObjective = currentObjective.getNextObjective();

        if (currentObjective != null) {
            this.uninitialize();
        }
        return currentObjective != null;
    }

    @Override
    public void initialize() {
        if (getCurrentObjective() instanceof ItemPickupQuestObjective) {
            this.questHandler = new QuantitativeQuestHandler((QuantitativeObjective) getCurrentObjective());
            this.questHandler.registerListener(new ItemEventListener(this, ((ItemPickupQuestObjective) getCurrentObjective()).getItemStack()), NTFramework.getInstance());
        } else {
            System.out.println("Quest objective type not yet supported: " + getCurrentObjective().getClass().getName());
        }
    }

    @Override
    public void uninitialize() {
        questHandler.unregisterListeners();
        this.initialize();
    }
}
