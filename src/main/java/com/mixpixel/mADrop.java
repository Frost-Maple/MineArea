package com.mixpixel;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.*;

import static org.bukkit.Material.matchMaterial;

public class mADrop {
    public static void dropItem(Location location, ItemStack treasureChest){
        Random random = new Random();
        ConfigurationSection configurationSection = MineArea.main.getConfig().getConfigurationSection("Drops");
        assert configurationSection != null: "Invalid configurationSection";
        Set<String> set = configurationSection.getKeys(false);
        for (String str: set){
            if (Objects.equals(configurationSection.getString(str + ".Id"), "Treasure_Chest")){
                if (random.nextInt(10000) < configurationSection.getInt(str + ".Possibility")){
                    location.getWorld().dropItemNaturally(location, treasureChest);
                }
            }
            else{
                Material material = matchMaterial(Objects.requireNonNull(configurationSection.getString(str + ".Id")));
                if (material != null) {
                    ItemStack itemStack = new ItemStack(material);
                    ItemMeta itemMeta = itemStack.getItemMeta();
                    itemMeta.setDisplayName(Objects.requireNonNull(configurationSection.getString(str + ".Display")).replace("&","¡ì"));
                    List<String> list = configurationSection.getStringList(str+".Lore");
                    List<String> newLore = new ArrayList<>();
                    for (String string: list){
                        newLore.add(string.replace("&","¡ì"));
                    }
                    itemMeta.setLore(newLore);
                    itemStack.setItemMeta(itemMeta);
                    if (random.nextInt(10000) < configurationSection.getInt(str+".Possibility")){
                        location.getWorld().dropItemNaturally(location, itemStack);
                    }
                }
                else {
                    throw new RuntimeException("There is an error in the Config.yml file and MineArea cannot proceed looting.");
                }
            }



        }


    }
}
