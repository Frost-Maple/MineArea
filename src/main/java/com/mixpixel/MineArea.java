package com.mixpixel;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.util.*;

public final class MineArea extends JavaPlugin {
    static MineArea main;
    public List<String> looter = new ArrayList<>();
    public List<String> configs = new ArrayList<>();
    public List<FileConfiguration> fileConfigurations = new ArrayList<>();
    @Override
    public void onEnable() {
        // Plugin startup logic
        saveDefaultConfig();
        loadConfigs();
        main = this;
        Objects.requireNonNull(Bukkit.getPluginCommand("MineArea")).setExecutor(new mACommand());
        Bukkit.getPluginManager().registerEvents(new mAListener(),this);
        Objects.requireNonNull(Bukkit.getPluginCommand("MineArea")).setTabCompleter(new mATabCompleter());
        System.out.println("MineArea for MixPixel has loaded.");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        System.out.println("""
                MineArea is Unloading. Thank you for using.
                Build 0.3.20(0161)
                To MixPixel
                By Lettuce
                With help from OpenAI's ChatGPT
                On 18 Sep '23
                In memories of Six Sixty
                Bye!
                """);
    }
    public void loadConfigs(){
        loadOtherFiles();
        loadLoot();
        }

    public void loadLoot(){
        reloadConfig();
        looter.clear();
        ConfigurationSection configurationSection = getConfig().getConfigurationSection("LootTable");
        if (configurationSection != null){
            Set<String>loots = configurationSection.getKeys(false);
            System.out.println(loots);
            looter.addAll(loots);
        }
    }
    public void loadOtherFiles(){
        File[] configurations = getDataFolder().listFiles();
        assert configurations != null;
        for (File config: configurations) {
                if (!config.getName().equals("config.yml")) {
                    configs.add(config.getName());
                    FileConfiguration fileConfiguration = YamlConfiguration.loadConfiguration(config);
                    fileConfigurations.add(fileConfiguration);
                }
        }

    }
}
