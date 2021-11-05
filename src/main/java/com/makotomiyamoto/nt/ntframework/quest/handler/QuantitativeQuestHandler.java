package com.makotomiyamoto.nt.ntframework.quest.handler;

import com.makotomiyamoto.nt.ntframework.quest.objective.QuantitativeObjective;
import org.bukkit.Bukkit;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;

public class QuantitativeQuestHandler implements QuestHandler<QuantitativeObjective> {
    private final ArrayList<Listener> listeners = new ArrayList<>();
    private final QuantitativeObjective quantitativeObjective;

    public QuantitativeQuestHandler(QuantitativeObjective quantitativeObjective) {
        this.quantitativeObjective = quantitativeObjective;
    }

    @Override
    public List<Listener> getListeners() {
        return listeners;
    }

    @Override
    public QuantitativeObjective getObjective() {
        return quantitativeObjective;
    }

    @Override
    public void registerListener(Listener listener, JavaPlugin plugin) {
        Bukkit.getPluginManager().registerEvents(listener, plugin);
        listeners.add(listener);
    }

    @Override
    public void unregisterListeners() {
        listeners.forEach(HandlerList::unregisterAll);
    }
}
