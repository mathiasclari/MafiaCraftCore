package net.acticraft.actimafiaplugin.JumpBooster;


import org.bukkit.Material;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.*;


import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.util.Vector;

/**
 * This is not very good but should work with some slight editing as it was written in discord
 */
public class PowerJump implements Listener {

    private static final Click[] COMBO = { Click.RIGHT, Click.RIGHT, Click.LEFT };
    private static final int TIMEOUT_SECONDS = 1;
    private final Map<UUID, List<RecordedClick>> records = new HashMap<>();

    @EventHandler
    public void onPlayerClick(PlayerInteractEvent e) {

        Player p = e.getPlayer();
        List<RecordedClick> clicks = records.getOrDefault(p.getUniqueId(), new ArrayList<>());

        Click lastClick = Click.of(e.getAction());

        if (null != lastClick) {
            if (clicks.size() > COMBO.length) {
                clicks.remove(0);
            }

            clicks.add(new RecordedClick(lastClick, Instant.now()));

            if (clicks.size() == COMBO.length && clicks.stream().allMatch(c -> c.getTime().plus(TIMEOUT_SECONDS, ChronoUnit.SECONDS).isBefore(Instant.now())) && Arrays.equals(clicks.stream().map(RecordedClick::getClick).toArray(), COMBO)) {
                // execute action
                    //p.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 25,10));
                    Vector v = p.getEyeLocation().getDirection().normalize().multiply(2.5);
                    v.setY(1.5);
                    p.setVelocity(v);


            }

            records.put(p.getUniqueId(), clicks);
        }

    }

    // you probably want to listen to the leave event and remove the records for a player when they leave


    public static class RecordedClick {

        private final Click click;
        private final Instant time;

        public RecordedClick(Click click, Instant time) {
            this.click = click;
            this.time = time;
        }

        public Click getClick() {
            return click;
        }

        public Instant getTime() {
            return time;
        }

    }

    public enum Click {

        LEFT(new Action[] { Action.LEFT_CLICK_AIR/*, Action.LEFT_CLICK_BLOCK */ }), // You probably don't want the CLICK_BLOCK actions as they could cause this to run when someone's breaking a block or something
        RIGHT(new Action[] { Action.RIGHT_CLICK_AIR/*, Action.RIGHT_CLICK_BLOCK */ });

        private final Action[] actions;

        Click(Action[] actions) {
            this.actions = actions;
        }

        public static Click of(Action action) {
            return Arrays.stream(values()).filter(v -> Arrays.asList(v.getActions()).contains(action)).findFirst().orElse(null);
        }

        public Action[] getActions() {
            return actions;
        }

    }

}