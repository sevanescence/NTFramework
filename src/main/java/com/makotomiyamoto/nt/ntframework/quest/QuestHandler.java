package com.makotomiyamoto.nt.ntframework.quest;

import com.makotomiyamoto.nt.ntframework.quest.objective.QuestObjective;
import org.bukkit.event.Listener;

import java.util.List;

public interface QuestHandler<ObjectiveType extends QuestObjective> {
    List<Listener> getListeners();
    ObjectiveType getObjective();

}
