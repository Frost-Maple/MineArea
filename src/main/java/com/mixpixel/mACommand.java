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
            sender.sendMessage("/ma reload ���ز��");
            sender.sendMessage("/ma help �������");
            return false;
        }
        else if (args.length==1){
            if (args[0].equals("reload")) {
                MineArea.main.loadConfigs();
                sender.sendMessage("����Ѿ����أ�");
            }
            if (args[0].equals("help")){
                sender.sendMessage("/ma reload ���ز��");
                sender.sendMessage("/ma help �������");
            }
        else {
            sender.sendMessage("Unknown command. /ma help for Plugin help. By MaplePi.");
            }

        }
        return false;
    }
}
