package com.mixpixel;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class mACommand implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (args.length==0) {
            sender.sendMessage("重载插件 /ma reload");
            sender.sendMessage("插件帮助 /ma help");
            sender.sendMessage("开启宝箱 /ma getChest");
            return false;
        }
        else if (args.length==1) {
            String string = args[0];
            switch (string) {
                case ("reload") -> {
                    MineArea.main.loadConfigs();
                    sender.sendMessage("插件已经重载！");
                }
                case ("help") -> {
                    sender.sendMessage("重载插件（管理员） /ma reload");
                    sender.sendMessage("插件帮助 /ma help");
                    sender.sendMessage("开启宝箱（管理员） /ma getChest");
                }
                case ("getChest") ->{
                    if (sender instanceof Player player){
                        player.openInventory(mALooting.openChestInventory(player));
                    }
                    else{
                        sender.sendMessage("This command can't be used by Console.");
                    }
                }
                case ("getchest")->{
                    if (sender instanceof Player player){
                        player.openInventory(mALooting.openChestInventory(player));
                    }
                    else{
                        sender.sendMessage("This command can't be used by Console.");
                    }
                }
                default ->  sender.sendMessage("Unknown command. /ma help for Plugin help. By MaplePi.");
            }
        }
        else {
            sender.sendMessage("Unknown command. /ma help for Plugin help. By MaplePi.");
            }
        return false;
    }
}
