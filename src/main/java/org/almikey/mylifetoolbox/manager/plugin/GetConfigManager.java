package org.almikey.mylifetoolbox.manager.plugin;

import org.almikey.mylifetoolbox.MylifeToolbox;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;

public class GetConfigManager {
    // 单例实例
    // 私有构造函数，确保只能通过getInstance()方法获取实例
    private static GetConfigManager instance;
    // 插件实例
    private final MylifeToolbox plugin;
    // 配置文件
    private FileConfiguration config;
    public GetConfigManager(MylifeToolbox plugin) {
        this.plugin = plugin;
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
