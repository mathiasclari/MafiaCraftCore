package net.acticraft.actimafiaplugin.JumpBooster;

import net.md_5.bungee.api.chat.ClickEvent;
import org.bukkit.Material;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import java.util.HashMap;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class PowerJump implements Listener {


    public enum Clicks{
        RIGHT, MIDDLE, LEFT;
    }

    enum RIGHT {
    }

    @EventHandler
    public void onPlayerClick(PlayerInteractEvent e) {

        Clicks rclick = Clicks.RIGHT;
    Player p = e.getPlayer();
    if(!e.getAction().equals(Action.RIGHT_CLICK_AIR)|| !e.getAction().equals(Action.RIGHT_CLICK_AIR)){

        }



    }
}
