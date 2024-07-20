package org.almikey.mylifetoolbox.manager;

import org.almikey.mylifetoolbox.MylifeToolbox;
import org.almikey.mylifetoolbox.manager.plugin.GetConfigManager;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class NoticeguiManager {
    private final MylifeToolbox plugin;
    public NoticeguiManager(MylifeToolbox plugin) {
        this.plugin = plugin;
    }
    public void open(Player player) {
        GetConfigManager gcm = new GetConfigManager(plugin);
        /*
         * 没思路了，想支持MiniMessage来着
         */
        // 创建一个新的箱子界面，大小为9格，标题为 配置文件中的 内容
        Inventory welcomeChest = Bukkit.createInventory(null, 54, gcm.getString("notice-gui.title"));

        // 添加一些物品到箱子中（示例：添加一个钻石）
        welcomeChest.addItem(new org.bukkit.inventory.ItemStack(Material.DIAMOND, 1));

        // 打开箱子给玩家
        player.openInventory(welcomeChest);
    }
}
