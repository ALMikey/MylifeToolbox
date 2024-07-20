package org.almikey.mylifetoolbox;

import org.almikey.mylifetoolbox.command.Command;
import org.almikey.mylifetoolbox.listener.onPlayerJoin;
import org.bukkit.plugin.java.JavaPlugin;

public final class MylifeToolbox extends JavaPlugin {

    @Override
    public void onLoad() {
        getLogger().info("Loading...");
    }
    @Override
    public void onEnable() {
        getLogger().info("Enable！");
        saveDefaultConfig();
        // Command
        getServer().getPluginCommand("mylifetoolbox").setExecutor(new Command(this));

        // Listener
        getServer().getPluginManager().registerEvents(new onPlayerJoin(this), this);

    }

    @Override
    public void onDisable() {
        getLogger().info("Disable！");
    }

}
