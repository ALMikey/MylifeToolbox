package org.almikey.mylifetoolbox.command;

import org.almikey.mylifetoolbox.MylifeToolbox;
import org.almikey.mylifetoolbox.manager.SetspawnManager;
import org.almikey.mylifetoolbox.manager.plugin.GetConfigManager;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class Command implements CommandExecutor, TabExecutor {
    private final MylifeToolbox plugin;
    public Command(MylifeToolbox plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, org.bukkit.command.Command command, String s, String[] strings) {

        GetConfigManager gcm = new GetConfigManager(plugin);

        if (strings.length < 1 ) return false;
        if(strings[0].equalsIgnoreCase("reload")){
            plugin.saveDefaultConfig();
            plugin.reloadConfig();
            commandSender.sendMessage(gcm.getMsgPrefix("reload"));
            return true;
        }
        if(strings[0].equalsIgnoreCase("version")){
            commandSender.sendMessage("当前版本为：" + plugin.getDescription().getVersion());
            return true;
        }
        if(strings[0].equalsIgnoreCase("setspawn")){
            SetspawnManager setspawnManager = new SetspawnManager(plugin);
            setspawnManager.setSpawn((Player) commandSender,true);
            commandSender.sendMessage(gcm.getMsgPrefix("setspawn"));
            return true;
        }
        return false;
    }

    @Override
    public List<String> onTabComplete(CommandSender commandSender, org.bukkit.command.Command command, String s, String[] strings) {

        List<String> tabCompletions = new ArrayList<>();

        if (strings.length == 1) {
            tabCompletions.add("reload");
            tabCompletions.add("version");
            tabCompletions .add("setspawn");
        }

        return tabCompletions;
    }
}
