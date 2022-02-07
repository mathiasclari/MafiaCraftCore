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
        public void RCLICK(PlayerInteractEvent event) {
            if (!event.getAction().equals(Action.RIGHT_CLICK_BLOCK )||!event.getAction().equals(Action.RIGHT_CLICK_AIR )) {

             }
        }
    }

    HashMap<String, String> Booster = new HashMap<String, String>();
    @EventHandler
    public void onPlayerClick(PlayerInteractEvent e) {
    Player p = e.getPlayer();
        Booster.put("", "");


    }
}
