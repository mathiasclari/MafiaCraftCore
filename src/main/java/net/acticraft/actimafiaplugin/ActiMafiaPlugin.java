package net.acticraft.actimafiaplugin;

import net.acticraft.actimafiaplugin.Licences.AdvancedLicense;
import net.acticraft.actimafiaplugin.MaskCommand.MaskCmd;
import net.acticraft.actimafiaplugin.PluginCoreListeners.BanOp;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public final class ActiMafiaPlugin extends JavaPlugin {

    private final YamlConfiguration conf = new YamlConfiguration();
    private static final String USER = "Mat";
    private static final String PASSW = "mTgbXRtKDtN9CVkxbvadkR62pWe9rUhm";
    private static final String LICENCE = "DtkC-Uy6n-xYyM-wWfu";



    @Override
    public void onEnable() {
        if(!new AdvancedLicense("YourLicense", "http://www.metaxcrew.com/License/verify.php", this).setSecurityKey("hecoF0I6M0wthxLeokoHuu8iUhTdIUInjkfF").register()) return;


        File co = new File(getDataFolder(), "config.yml");
        if(!co.exists()) saveResource("config.yml", false);

        try{
            this.conf.load(co);
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }

        if (!getConfig().getString("user").equals(USER) || !getConfig().getString("licence").equals(LICENCE) || !getConfig().getString("password").equals(PASSW)){
// print error  user
                Bukkit.getConsoleSender().sendMessage(ChatColor.GRAY + "[]=================[" + ChatColor.of(new Color(100, 100, 100)) + ChatColor.BOLD + "ActiCraft" + ChatColor.GRAY + "]=================[]");
                Bukkit.getConsoleSender().sendMessage(ChatColor.GRAY + "|");
                Bukkit.getConsoleSender().sendMessage(ChatColor.GRAY + "|" + ChatColor.of(new Color(65, 65, 65)) + "       Name:" + ChatColor.of(new Color(100, 100, 100)) + " ActiMafia");
                Bukkit.getConsoleSender().sendMessage(ChatColor.GRAY + "|" + ChatColor.of(new Color(65, 65, 65)) + "       Developer:" + ChatColor.of(new Color(100, 100, 100)) + " Mat");
                Bukkit.getConsoleSender().sendMessage(ChatColor.GRAY + "|" + ChatColor.of(new Color(65, 65, 65)) + "       Discord:" + ChatColor.of(new Color(100, 100, 100)) + " Mat#5000");
                Bukkit.getConsoleSender().sendMessage(ChatColor.GRAY + "|" + ChatColor.of(new Color(65, 65, 65)) + "       Mail:" + ChatColor.of(new Color(100, 100, 100)) + " support@acticraft.net");
                Bukkit.getConsoleSender().sendMessage(ChatColor.GRAY + "|" + ChatColor.of(new Color(65, 65, 65)) + "       Discord:" + ChatColor.of(new Color(100, 100, 100)) + " https://discord.gg/acticraft");
                Bukkit.getConsoleSender().sendMessage(ChatColor.GRAY + "|");
                Bukkit.getConsoleSender().sendMessage(ChatColor.GRAY + "|" + ChatColor.of(new Color(65, 65, 65)) + "       Type:" + ChatColor.of(new Color(100, 100, 100)) + "LICENCED");
                Bukkit.getConsoleSender().sendMessage(ChatColor.GRAY + "|");
                Bukkit.getConsoleSender().sendMessage(ChatColor.GRAY + "|" + ChatColor.of(new Color(65, 65, 65)) + "       Licence:" + ChatColor.of(new Color(192, 0, 52)) + " Unvalid");
                Bukkit.getConsoleSender().sendMessage(ChatColor.GRAY + "|");
                Bukkit.getConsoleSender().sendMessage(ChatColor.GRAY + "|" + ChatColor.of(new Color(65, 65, 65)) + "       Pls re-enter the licence or user again");
                Bukkit.getConsoleSender().sendMessage(ChatColor.GRAY + "|");
                Bukkit.getConsoleSender().sendMessage(ChatColor.GRAY + "[]===============================================[]");
                Bukkit.shutdown();
                return;
            }else {


                Bukkit.getConsoleSender().sendMessage(ChatColor.GRAY + "[]=================[" + ChatColor.of(new Color(100, 100, 100)) + ChatColor.BOLD + "ActiCraft" + ChatColor.GRAY + "]=================[]");
                Bukkit.getConsoleSender().sendMessage(ChatColor.GRAY + "|");
                Bukkit.getConsoleSender().sendMessage(ChatColor.GRAY + "|" + ChatColor.of(new Color(65, 65, 65)) + "       Name:" + ChatColor.of(new Color(100, 100, 100)) + " ActiMafia");
                Bukkit.getConsoleSender().sendMessage(ChatColor.GRAY + "|" + ChatColor.of(new Color(65, 65, 65)) + "       Developer:" + ChatColor.of(new Color(100, 100, 100)) + " Mat");
                Bukkit.getConsoleSender().sendMessage(ChatColor.GRAY + "|" + ChatColor.of(new Color(65, 65, 65)) + "       Discord:" + ChatColor.of(new Color(100, 100, 100)) + " Mat#5000");
                Bukkit.getConsoleSender().sendMessage(ChatColor.GRAY + "|" + ChatColor.of(new Color(65, 65, 65)) + "       Mail:" + ChatColor.of(new Color(100, 100, 100)) + " support@acticraft.net");
                Bukkit.getConsoleSender().sendMessage(ChatColor.GRAY + "|" + ChatColor.of(new Color(65, 65, 65)) + "       Discord:" + ChatColor.of(new Color(100, 100, 100)) + " https://discord.gg/acticraft");
                Bukkit.getConsoleSender().sendMessage(ChatColor.GRAY + "|");
                Bukkit.getConsoleSender().sendMessage(ChatColor.GRAY + "|" + ChatColor.of(new Color(65, 65, 65)) + "       Type:" + ChatColor.of(new Color(100, 100, 100)) + "LICENCED");
                Bukkit.getConsoleSender().sendMessage(ChatColor.GRAY + "|");
                Bukkit.getConsoleSender().sendMessage(ChatColor.GRAY + "|" + ChatColor.of(new Color(65, 65, 65)) + "       Licence:" + ChatColor.of(new Color(61, 168, 255)) + " Valid");
                Bukkit.getConsoleSender().sendMessage(ChatColor.GRAY + "|");
                Bukkit.getConsoleSender().sendMessage(ChatColor.GRAY + "[]===============================================[]");


                //CoreListeners
            getServer().getPluginManager().registerEvents(new BanOp(), this);

            //CoreCommands
            getCommand("mask").setExecutor(new MaskCmd());

                /* getCommand("youtube").setExecutor(new YouTubeCommand());
                getCommand("discord").setExecutor(new DiscordCommand());
                getCommand("tiktok").setExecutor(new TikTokCommand());
                getCommand("twitter").setExecutor(new TwitterCommand());
                getCommand("faq").setExecutor(new FAQCommand());
                getCommand("website").setExecutor(new WebsiteCommand());
                getCommand("acshelp").setExecutor(new SciHelp());*/
            }

    }

    @Override
    public void onDisable() {

        // Plugin shutdown logic
    }
    public YamlConfiguration getConf() { return this.conf; }
}
