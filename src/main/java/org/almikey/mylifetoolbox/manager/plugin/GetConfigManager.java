package org.almikey.mylifetoolbox.manager.plugin;

import org.almikey.mylifetoolbox.MylifeToolbox;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;

public class GetConfigManager {
    private final MylifeToolbox plugin;
    // 配置文件
    private final FileConfiguration config;
    public GetConfigManager( MylifeToolbox plugin) {
        this.plugin = plugin;
        // 插件实例
        plugin.reloadConfig();
        this.config = plugin.getConfig();
    }

    public String getString(String key) { return config.getString(key); }
    public int getInt(String key) { return config.getInt(key); }
    public boolean getBoolean(String key) { return config.getBoolean(key); }
    public Double getDouble(String key) { return config.getDouble(key); }

    public String getMsgPrefix(String key) {
        String msg = config.getString("messages." + key);
        String prefix = config.getString("messages.prefix");
        String msglist = prefix+msg;
        return ChatColor.translateAlternateColorCodes('&', msglist);
    }



}
