package com.mixpixel;

import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class mAListener implements Listener {
    @EventHandler
    public void playerDig(BlockBreakEvent event){
        Player player = event.getPlayer();
        Block block = event.getBlock();
        Location dugBlock = block.getLocation();
        if (MineArea.main.locations.contains(dugBlock)){
            event.setDropItems(false);
            player.sendMessage("�����ڿ����ھ�");
            mALooting.looting(player);
        }
    }
}
