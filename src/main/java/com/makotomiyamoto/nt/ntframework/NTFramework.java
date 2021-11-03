package com.makotomiyamoto.nt.ntframework;

import com.makotomiyamoto.nt.ntframework.lib.GsonManager;
import com.makotomiyamoto.nt.ntframework.quest.*;
import com.makotomiyamoto.nt.ntframework.quest.objective.ActionQuestObjective;
import com.makotomiyamoto.nt.ntframework.quest.objective.QuantitativeObjective;
import com.makotomiyamoto.nt.ntframework.quest.objective.QuestObjective;
import com.makotomiyamoto.nt.ntframework.quest.reward.IReward;
import com.makotomiyamoto.nt.ntframework.quest.reward.ItemQuestCompletionReward;
import com.makotomiyamoto.nt.ntframework.quest.reward.ItemReward;
import com.makotomiyamoto.nt.ntframework.quest.reward.QuestCompletionReward;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;

public final class NTFramework extends JavaPlugin {
    public static HashMap<String, Quest> quests = new HashMap<>();

    @Override
    public void onEnable() {
        // Plugin startup logic
        Quest quest = new Quest();
        quest.setTitle("Getting Started");
        quest.setDescription("I seem to have woken up in a ruin with no recollection of who I am. I need to find a way out.");
        QuestObjective objective = new ActionQuestObjective("Clearing Debris", "Clear the wooden debris.", 1);
        ItemQuestCompletionReward reward = new ItemQuestCompletionReward(new ItemStack(Material.WOODEN_SWORD));
        objective.setQuestCompletionReward(reward);
        objective.setProgressBodyTemplate("Debris cleared: %d/%d");
        quest.setHead(objective);
        quests.put("story_GettingStarted", quest);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
