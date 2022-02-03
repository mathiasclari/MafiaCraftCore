package net.acticraft.actimafiaplugin.NeededCommands;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.awt.*;

public class Creative implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player && !sender.hasPermission("meta.gamemode")) {
            sender.sendMessage(ChatColor.of(new Color(161, 0, 0)) + "You do not have permission to execute this command!");
            return true;
        } else {
            if (args.length < 1) {
                if (sender instanceof Player) {
                    ((Player) sender).setGameMode(GameMode.ADVENTURE);
                    sender.sendMessage(ChatColor.of(new Color(61, 146, 255)) + "You changed your gamemode to Adventure!");
                    return true;
                } else {
                    sender.sendMessage(ChatColor.of(new Color(161, 0, 0)) + "You must be a player to execute this command!");
                    return true;
                }
            } else if (args.length == 1) {
                Player target = Bukkit.getPlayer(args[0]);
                if (null != target && target.isOnline()) {
                    target.setGameMode(GameMode.ADVENTURE);
                    target.sendMessage(ChatColor.of(new Color(61, 146, 255)) + "Your gamemode was changed to Adventure!");
                    sender.sendMessage(ChatColor.of(new Color(61, 146, 255)) + "You changed " + args[0] + "'s gamemode to Adventure!");
                    return true;
                } else {
                    sender.sendMessage(ChatColor.of(new Color(161, 0, 0)) + "Cannot find player with name '" + args[0] + "', are they online?");
                    return true;
                }
            } else {
                return false;
            }
        }
    }
}
