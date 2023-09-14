package com.mixpixel;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.loot.LootContext;
import org.bukkit.loot.LootTable;
import org.jetbrains.annotations.NotNull;

import java.util.*;

public class mALootTable {
    private static final List<String> loots = MineArea.main.looter;
    public static LootTable lootTable = new LootTable() {

        @Override
        public @NotNull Collection<ItemStack> populateLoot(@NotNull Random random, @NotNull LootContext context) {
            Collection<ItemStack> lootItems = new ArrayList<>();
            for (String loot : loots) {
                @NotNull FileConfiguration config =  MineArea.main.getConfig();
                ConfigurationSection configurationSection = MineArea.main.getConfig().getConfigurationSection("LootTable");
                if (random.nextInt(10000)<config.getInt(loot+".Possibility")){
                    System.out.println("Random generated.");
                    assert configurationSection != null;
                    Material material = Material.matchMaterial(Objects.requireNonNull(configurationSection.getString(loot + ".Id")));
                    System.out.println(material);
                    assert material != null;
                    ItemStack itemStack = new ItemStack(material);
                    ItemMeta itemMeta = itemStack.getItemMeta();
                    itemMeta.setDisplayName(configurationSection.getString(loot+".Display"));
                    List<String>newLore = new ArrayList<>();
                    for (String loreLine : configurationSection.getStringList(loot+".Lore")){
                        newLore.add(loreLine.replace("&","§"));
                    }
                    itemMeta.setLore(newLore);
                    itemStack.setItemMeta(itemMeta);
                    lootItems.add(itemStack);
                }
            }

            int possibility1 = random.nextInt(100000);
            if (possibility1<0){
                ItemStack itemStack = new ItemStack(Material.DIAMOND, 4);
                lootItems.add(itemStack);
            }
            if (possibility1<0) {
                ItemStack itemStack = new ItemStack(Material.EMERALD, 8);
                lootItems.add(itemStack);
            }
            if (possibility1<0){
                ItemStack itemStack = new ItemStack(Material.ENCHANTED_GOLDEN_APPLE, 1);
                lootItems.add(itemStack);
            }
            return lootItems;
        }

        @Override
        public void fillInventory(@NotNull Inventory inventory, @NotNull Random random, @NotNull LootContext context) {
            Collection<ItemStack> items = populateLoot(random, context);
            for (ItemStack itemStack: items){
                inventory.addItem(itemStack);
            }
        }

        @Override
        public @NotNull NamespacedKey getKey() {
            return new NamespacedKey(MineArea.main,"LootTable");
        }
    };
}
