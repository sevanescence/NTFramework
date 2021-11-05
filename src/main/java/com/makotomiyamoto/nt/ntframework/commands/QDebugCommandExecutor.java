package com.makotomiyamoto.nt.ntframework.commands;

import com.makotomiyamoto.nt.ntframework.NTFramework;
import com.makotomiyamoto.nt.ntframework.quest.ActivePlayerQuest;
import com.makotomiyamoto.nt.ntframework.quest.Quest;
import com.makotomiyamoto.nt.ntframework.quest.handler.ItemEventListener;
import com.makotomiyamoto.nt.ntframework.quest.handler.QuantitativeQuestHandler;
import com.makotomiyamoto.nt.ntframework.quest.objective.ItemPickupQuestObjective;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.List;
import java.util.Objects;

public class QDebugCommandExecutor implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (! (sender instanceof Player)) {
            System.out.println("Only players can execute this.");
            return false;
        }

        ActivePlayerQuest playerQuest = new ActivePlayerQuest("debug_GettingStarted", (Player) sender);
        playerQuest.initialize(NTFramework.getInstance());
        sender.sendMessage("Quest started: " + playerQuest.getQuest().getTitle());
        sender.sendMessage("Objective: " + playerQuest.getCurrentObjective().getDescription());
//        Quest debug_GettingStarted = NTFramework.getQuests().get("debug_GettingStarted");
//        if (debug_GettingStarted == null) {
//            sender.sendMessage("For some reason, debug_GettingStarted does not exist. Ditto.");
//            return false;
//        }
//        ActivePlayerQuest quest = new ActivePlayerQuest("debug_GettingStarted", ((Player) sender));
//        NTFramework.getActiveQuests().put(((Player) sender).getUniqueId(), List.of(quest));
//        // TODO handle this part in some sort of quest init event
//        ItemPickupQuestObjective objective = (ItemPickupQuestObjective) quest.getCurrentObjective();
//        ItemEventListener itemEventListener = new ItemEventListener(quest, objective.getItemStack());
//        objective.setQuantitativeQuestHandler(new QuantitativeQuestHandler(objective));
//        objective.getQuantitativeQuestHandler().registerListener(itemEventListener, NTFramework.getInstance());
//        sender.sendMessage("Pick up a %s".formatted(Objects.requireNonNull(objective.getItemStack().getItemMeta()).getDisplayName()));

        return true;
    }
}
