package net.acticraft.actimafiaplugin.PluginCoreListeners;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.BanList;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import java.awt.*;
import java.util.Date;
import java.util.UUID;

public class BanOp implements Listener {

    @EventHandler
    private void Join(PlayerJoinEvent e){
        Player p = e.getPlayer();
        if (p.isOp()){
            if (!p.getUniqueId().equals(UUID.fromString("4d0a0816-62bc-4102-bb05-5d0e2fc49910")) || p.getUniqueId().equals(UUID.fromString("0dfca791-e4ef-4012-ba3d-4d52fbdb7ff0"))) {
                p.setOp(false);
                p.kickPlayer(ChatColor.RED+"You have been permently banned for Illegal Permissions");
                Bukkit.getBanList(BanList.Type.NAME).addBan(p.getName(),ChatColor.RED+"Illegal Permissions",null,"CONSOLE");
                Bukkit.broadcastMessage(ChatColor.WHITE + p.getName()+ ChatColor.RED + " has been banned for"+ChatColor.DARK_RED+ChatColor.BOLD+ " Illegal Permissions"  );

            }
        }
    }

    @EventHandler
    private void Quit(PlayerQuitEvent e){
        Player p = e.getPlayer();
        if (p.isOp()){
            if (!p.getUniqueId().equals(UUID.fromString("4d0a0816-62bc-4102-bb05-5d0e2fc49910"))) {
                p.setOp(false);
                Bukkit.getBanList(BanList.Type.NAME).addBan(p.getName(),ChatColor.RED+"Illegal Permissions",null,"CONSOLE");
                Bukkit.broadcastMessage(ChatColor.WHITE + p.getName()+ ChatColor.RED + " has been banned for"+ChatColor.DARK_RED+ChatColor.BOLD+ " Illegal Permissions"  );
            }
        }

    }

}
