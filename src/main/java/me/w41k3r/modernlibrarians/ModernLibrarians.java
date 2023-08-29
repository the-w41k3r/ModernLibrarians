package me.w41k3r.modernlibrarians;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public final class ModernLibrarians extends JavaPlugin implements CommandExecutor {

    public static ModernLibrarians plugin;
    @Override
    public void onEnable() {
        plugin = this;
        getLogger().info("VillagerTradeLimitPlugin enabled.");

        getServer().getPluginManager().registerEvents(new Listener(), this);
    }

    @Override
    public void onDisable() {
        getLogger().info("VillagerTradeLimitPlugin disabled.");
    }

}
