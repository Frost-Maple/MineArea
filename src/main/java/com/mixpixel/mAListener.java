package com.mixpixel;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.bukkit.Bukkit.getServer;
public class mAListener implements Listener {
    public List<Location> locations = new ArrayList<>();
    @EventHandler
    public void playerDig(BlockBreakEvent event){
        Player player = event.getPlayer();
        Block block = event.getBlock();
        Location dugBlock = block.getLocation();
        Boolean check = matchLocation(dugBlock);
        if (check){
            event.setDropItems(false);
            loadLoot(MineArea.main.configUsed);
            player.sendMessage("你正在满足"+MineArea.main.configUsed+"规定的条件！");
            mALooting.looting(player, dugBlock);
        }
        Material material = block.getType();

    }
    public Boolean matchLocation(Location location){
        MineArea main = MineArea.main;
        main.reloadConfig();
        for (FileConfiguration fileConfiguration: main.fileConfigurations) {
            int xMin = fileConfiguration.getInt("Area.xMin");
            int xMax = fileConfiguration.getInt("Area.xMax");
            int zMin = fileConfiguration.getInt("Area.zMin");
            int zMax = fileConfiguration.getInt("Area.zMax");
            for (int i = xMin; i <= xMax; i++) {
                for (int z = zMin; z <= zMax; z++) {
                    World world = getServer().getWorld("world");
                    for (int y = 0; y <= 256; y++) {
                        Location location1 = new Location(world, i, y, z);
                        if (location1.equals(location)){
                            MineArea.main.configUsed = fileConfiguration;
                            return true;
                        }
                    }
                }
            }
            System.out.println("Loaded specified Mining Area: x coordinates "+xMin+" to "+xMax+", z coordinates "+zMin+" to "+zMax);
        }
        return false;
    }
    public void loadLoot(FileConfiguration fileConfiguration){
        MineArea.main.looter.clear();
        ConfigurationSection configurationSection = fileConfiguration.getConfigurationSection("LootTable");
        if (configurationSection != null){
            Set<String> loots = configurationSection.getKeys(false);
            System.out.println(loots);
            MineArea.main.looter.addAll(loots);
        }
    }

}
