package org.almikey.mylifetoolbox.listener;

import org.almikey.mylifetoolbox.MylifeToolbox;
import org.almikey.mylifetoolbox.manager.NoticeguiManager;
import org.almikey.mylifetoolbox.manager.SetspawnManager;
import org.almikey.mylifetoolbox.manager.plugin.GetConfigManager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class onPlayerJoin implements Listener {

    private final MylifeToolbox plugin;
    public onPlayerJoin(MylifeToolbox plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {

        GetConfigManager gcm = new GetConfigManager(plugin);

        if (gcm.getBoolean("notice-gui.enable")){
            NoticeguiManager  noticeguiManager = new NoticeguiManager(plugin);
            noticeguiManager.open(event.getPlayer());
        }

        if (gcm.getBoolean("setspawn.enable")){
            SetspawnManager setspawnManager = new SetspawnManager(plugin);
            setspawnManager.spawn(event.getPlayer());
        }

    }

}
