package com.makotomiyamoto.nt.ntframework.commands;

import com.makotomiyamoto.nt.ntframework.NTFramework;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.CrossbowMeta;

import java.util.List;

public class EntityShootBowListener implements Listener {
    @EventHandler
    public void onCrossBowFire(EntityShootBowEvent event) {
//        if (event.getBow().getType() != Material.CROSSBOW) {
//            return;
//        }
//
//        if (event.getEntity() instanceof Player) {
//            event.getEntity().sendMessage("lol!");
//            Bukkit.getScheduler().runTaskLater(NTFramework.getInstance(), () -> {
//                ((CrossbowMeta) event.getBow().getItemMeta()).setChargedProjectiles(List.of(new ItemStack(Material.ARROW)));
//            }, 20);
//        }
    }
}
