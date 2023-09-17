package com.mixpixel;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class mATabCompleter implements TabCompleter {
    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String alias, @NotNull String[] args) {
        List<String> completions = new ArrayList<>();
        if (command.getName().equalsIgnoreCase("MineArea")||command.getName().equalsIgnoreCase("ma")){
            if(args.length == 1){
                completions.add("help");
                if (sender.isOp()){
                    completions.add("reload");
                    completions.add("getChest");
                }
            }
        }
        return completions;
    }
}
