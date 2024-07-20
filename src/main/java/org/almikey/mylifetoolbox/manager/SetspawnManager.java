package org.almikey.mylifetoolbox.manager;

import org.almikey.mylifetoolbox.MylifeToolbox;
import org.almikey.mylifetoolbox.manager.plugin.GetConfigManager;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public class SetspawnManager {
    private final MylifeToolbox plugin;
    public SetspawnManager(MylifeToolbox plugin) { this.plugin = plugin; }

    public void setSpawn(Player player, boolean enable) {
        FileConfiguration config = plugin.getConfig();
        // 获取玩家的位置
        double x = player.getLocation().getX();
        double y = player.getLocation().getY();
        double z = player.getLocation().getZ();
        // 更新配置文件
        config.set("setspawn.x", x);
        config.set("setspawn.y", y);
        config.set("setspawn.z", z);
        config.set("setspawn.enable", true);
        // 保存配置
        plugin.saveConfig();
    }
    public void spawn(Player player) {
        GetConfigManager gcm = new GetConfigManager(plugin);

        Double x = gcm.getDouble("setspawn.x");;
        Double y = gcm.getDouble("setspawn.y");
        Double z = gcm.getDouble("setspawn.z");;

        Location loc = new Location(player.getWorld(), x, y, z);

        player.teleport(loc);
        player.sendMessage(gcm.getMsgPrefix("spawn"));
    }

}
