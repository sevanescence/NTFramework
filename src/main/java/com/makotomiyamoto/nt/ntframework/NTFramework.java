package com.makotomiyamoto.nt.ntframework;

import com.makotomiyamoto.nt.ntframework.commands.QDebugCommandExecutor;
import com.makotomiyamoto.nt.ntframework.lib.GsonManager;
import com.makotomiyamoto.nt.ntframework.quest.*;
import com.makotomiyamoto.nt.ntframework.quest.objective.ActionQuestObjective;
import com.makotomiyamoto.nt.ntframework.quest.objective.ItemPickupQuestObjective;
import com.makotomiyamoto.nt.ntframework.quest.objective.QuantitativeObjective;
import com.makotomiyamoto.nt.ntframework.quest.objective.QuestObjective;
import com.makotomiyamoto.nt.ntframework.quest.reward.IReward;
import com.makotomiyamoto.nt.ntframework.quest.reward.ItemQuestCompletionReward;
import com.makotomiyamoto.nt.ntframework.quest.reward.ItemReward;
import com.makotomiyamoto.nt.ntframework.quest.reward.QuestCompletionReward;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public final class NTFramework extends JavaPlugin {
    private static NTFramework plugin = null;
    public static HashMap<String, Quest> quests = new HashMap<>();
    public static HashMap<UUID, List<ActivePlayerQuest>> activeQuests = new HashMap<>();

    @Override
    public void onEnable() {
        // Plugin startup logic
        this.getCommand("qdebug").setExecutor(new QDebugCommandExecutor());

        Quest quest = new Quest();
        quest.setTitle("Getting Started");
        quest.setDescription("This is the beginning quest.");
        ItemPickupQuestObjective objective = new ItemPickupQuestObjective("Pick up wooden sword", "Description :)", 1);
        objective.setItemStack(new ItemStack(Material.WOODEN_SWORD, 1));
        quest.setHead(objective);
        quests.put("debug_GettingStarted", quest);

        NTFramework.plugin = this;
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static HashMap<String, Quest> getQuests() {
        return quests;
    }

    public static HashMap<UUID, List<ActivePlayerQuest>> getActiveQuests() {
        return activeQuests;
    }

    public static NTFramework getInstance() {
        return plugin;
    }
}
