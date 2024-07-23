package org.almikey.mylifetoolbox.listener;

import org.almikey.mylifetoolbox.MylifeToolbox;
import org.almikey.mylifetoolbox.manager.NoticeguiManager;
import org.almikey.mylifetoolbox.manager.SetspawnManager;
import org.bukkit.entity.Player;
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

        NoticeguiManager  noticeguiManager = new NoticeguiManager(plugin);
        SetspawnManager setspawnManager = new SetspawnManager(plugin);

        Player player = event.getPlayer();

        if (plugin.getConfig().getBoolean("setspawn.enable")){
            setspawnManager.spawn(player);
        }

        if (plugin.getConfig().getBoolean("notice-gui.enable")){
            noticeguiManager.open(player);
        }

    }

}
