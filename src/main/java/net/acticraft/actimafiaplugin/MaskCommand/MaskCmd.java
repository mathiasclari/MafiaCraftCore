package net.acticraft.actimafiaplugin.MaskCommand;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.Effect;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.awt.*;

public class MaskCmd implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player && !sender.hasPermission("acticraft.mafia.default")) {
            sender.sendMessage(ChatColor.of(new Color(161, 0, 0)) + "You do not have permission to execute this command!");
            return true;
        } else {
            if (args.length == 0)
                if (sender instanceof Player) {
                    Player p = (Player) sender;
                    if (null != p.getInventory().getHelmet()) {
                        sender.sendMessage(ChatColor.of(new Color(161, 0, 0)) + "You already have a mask!");
                        // return
                    }else{
                        if(p.getInventory().equals(Material.RED_CARPET)){
                        p.getInventory().setHelmet(new ItemStack(p.getInventory().getItemInMainHand()));
                        p.getInventory().removeItem(new ItemStack(p.getInventory().getItemInMainHand()));
                        p.playEffect(p.getLocation(), Effect.CLICK1, 5);
                        p.playEffect(p.getLocation(), Effect.MOBSPAWNER_FLAMES, 5);
                        sender.sendMessage(ChatColor.of(new Color(61, 146, 255)) + "You equiped a mask!");
                        return true;}}
                } else {
                    sender.sendMessage(ChatColor.of(new Color(161, 0, 0)) + "You must be a player to execute this command!");
                    return true;
                }
        }
        return true;
    }
}
