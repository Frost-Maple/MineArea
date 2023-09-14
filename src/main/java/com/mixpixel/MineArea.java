package com.mixpixel;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.*;

public final class MineArea extends JavaPlugin {
    static MineArea main;
    public List<Location> locations = new ArrayList<>();
    public List<String> looter = new ArrayList<>();

    @Override
    public void onEnable() {
        // Plugin startup logic
        saveDefaultConfig();
        loadConfigs();
        main = this;
        Objects.requireNonNull(Bukkit.getPluginCommand("MineArea")).setExecutor(new mACommand());
        Bukkit.getPluginManager().registerEvents(new mAListener(),this);
        System.out.println("MineArea for MixPixel has loaded.");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        System.out.println("""
                MineArea is Unloading. Thank you for using.
                Build 0.2.16(0137)
                By Lettuce
                With help from OPenAI's ChatGPT
                On 14 Sep '23
                Bye!
                """);
    }
    public void loadConfigs(){
        loadLocations();
        loadLoot();
        }
    public void loadLocations(){
        locations.clear();
        reloadConfig();
        int xMin = getConfig().getInt("Area.xMin");
        int xMax = getConfig().getInt("Area.xMax");
        int zMin = getConfig().getInt("Area.zMin");
        int zMax = getConfig().getInt("Area.zMax");
        for (int i = xMin; i <= xMax; i++){
            for (int z = zMin; z <= zMax; z++){
                World world = getServer().getWorld("world");
                for (int y = 0; y <= 256; y++) {
                    Location location = new Location(world, i, y, z);
                    locations.add(location);
                }
            }
        }
        System.out.println("Loaded specified Mining Area: x coordinates "+xMin+" to "+xMax+", z coordinates "+zMin+" to "+zMax);
    }
    public void loadLoot(){
        ConfigurationSection configurationSection = getConfig().getConfigurationSection("LootTable");
        if (configurationSection != null){
            Set<String>loots = configurationSection.getKeys(false);
            System.out.println(loots);
            looter.addAll(loots);
        }
    }
}
