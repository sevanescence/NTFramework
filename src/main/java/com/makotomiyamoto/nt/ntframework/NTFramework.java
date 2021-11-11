package com.makotomiyamoto.nt.ntframework;

import com.makotomiyamoto.nt.ntframework.commands.EntityShootBowListener;
import com.makotomiyamoto.nt.ntframework.commands.QDebugCommandExecutor;
import com.makotomiyamoto.nt.ntframework.lib.GsonManager;
import com.makotomiyamoto.nt.ntframework.lib.adapters.ActionQuestObjectiveSerializationAdapter;
import com.makotomiyamoto.nt.ntframework.lib.adapters.ItemStackSerializationAdapter;
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

    // TODO ***URGENT*** : load quest objectives before quests and active quests
    // in fact, active quests should not load until a player logs in
    // TODO reinitialize quest handlers when an active quest loads.
    // ^ on that, uninitialize them (delete events) when a player session ends

    @Override
    public void onEnable() {
        // Plugin startup logic
        this.getCommand("qdebug").setExecutor(new QDebugCommandExecutor());
        this.getServer().getPluginManager().registerEvents(new EntityShootBowListener(), this);

        // registering type adapters
        GsonManager.registerSerializationHierarchyAdapter(new ItemStackSerializationAdapter());
        GsonManager.flush();

        Quest quest = new Quest();
        quest.setTitle("Getting Started");
        quest.setDescription("This is the beginning quest.");
        ItemPickupQuestObjective objective = new ItemPickupQuestObjective("Wooden sword :)", "Pick up a wooden sword.", 1);
        objective.setItemStack(new ItemStack(Material.WOODEN_SWORD));
        quest.setHead(objective);
        ItemPickupQuestObjective objective1 = new ItemPickupQuestObjective("Leather Chestplate!", "Pick up a leather chestplate.", 1);
        objective1.setItemStack(new ItemStack(Material.LEATHER_CHESTPLATE));
        quest.getHead().setNextObjective(objective1);
        quest.setQuestCompletionReward(new ItemQuestCompletionReward(new ItemStack(Material.DIAMOND, 3)));
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
