package org.almikey.mylifetoolbox.manager;

import org.almikey.mylifetoolbox.MylifeToolbox;
import org.almikey.mylifetoolbox.manager.plugin.GetConfigManager;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public class SetspawnManager {
    private final MylifeToolbox plugin;
    public SetspawnManager(MylifeToolbox plugin) { this.plugin = plugin; }

    public void setSpawn(Player player, boolean enable) {
        FileConfiguration config = plugin.getConfig();
        // 获取玩家的位置和朝向
        Location loc = player.getLocation();
        double x = loc.getX();
        double y = loc.getY();
        double z = loc.getZ();
        float yaw = loc.getYaw();
        float pitch = loc.getPitch();
        String world = loc.getWorld().getName();
        // 更新配置文件
        config.set("setspawn.enable", enable);
        config.set("setspawn.x", x);
        config.set("setspawn.y", y);
        config.set("setspawn.z", z);
        config.set("setspawn.yaw", yaw);
        config.set("setspawn.pitch", pitch);
        config.set("setspawn.world", world);
        // 保存配置
        plugin.saveConfig();
    }
    public void spawn(Player player) {
        GetConfigManager gcm = new GetConfigManager(plugin);
        // 获取配置文件中的内容
        Double x = gcm.getDouble("setspawn.x");
        Double y = gcm.getDouble("setspawn.y");
        Double z = gcm.getDouble("setspawn.z");
        Float yaw = (float) gcm.getDouble("setspawn.yaw").doubleValue();
        Float pitch = (float) gcm.getDouble("setspawn.pitch").doubleValue();

        World world = Bukkit.getWorld(gcm.getString("setspawn.world"));

        if (world == null) {
            plugin.getLogger().warning("世界 " + world + " 不存在或未加载。");
            return;
        }

        Location loc = new Location(world, x, y, z, yaw, pitch);

        player.teleport(loc);
        player.sendMessage(gcm.getMsgPrefix("spawn"));
    }

}
