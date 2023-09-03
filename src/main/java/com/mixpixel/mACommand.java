package com.mixpixel;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public class mACommand implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        sender.sendMessage("This is working normally.");
        if (args.length==0) {
            sender.sendMessage("/ma reload 重载插件");
            sender.sendMessage("/ma help 插件帮助");
            return false;
        }
        else if (args.length==1){
            if (args[0].equals("reload")) {
                MineArea.main.loadConfigs();
                sender.sendMessage("插件已经重载！");
            }
            if (args[0].equals("help")){
                sender.sendMessage("/ma reload 重载插件");
                sender.sendMessage("/ma help 插件帮助");
            }
        else {
            sender.sendMessage("Unknown command. /ma help for Plugin help. By MaplePi.");
            }

        }
        return false;
    }
}
