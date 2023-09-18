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
                ConfigurationSection configurationSection = MineArea.main.configUsed.getConfigurationSection("LootTable");
                assert configurationSection != null;
                int randomInteger = random.nextInt(10000);
                if (configurationSection.get(loot+".Possibility") == null || configurationSection.get(loot + ".Id") == null){
                    throw new RuntimeException("Config.yml ≈‰÷√¥ÌŒÛ£°");
                }
                if (randomInteger<configurationSection.getInt(loot+".Possibility")){
                    Material material = Material.matchMaterial(Objects.requireNonNull(configurationSection.getString(loot + ".Id")));
                    if (material != null){
                        ItemStack itemStack = new ItemStack(material);
                        ItemMeta itemMeta = itemStack.getItemMeta();
                        itemMeta.setDisplayName(Objects.requireNonNull(configurationSection.getString(loot + ".Display")).replace("&","°Ï"));
                        List<String>newLore = new ArrayList<>();
                        for (String loreLine : configurationSection.getStringList(loot+".Lore")){
                            newLore.add(loreLine.replace("&","°Ï"));
                        }
                        itemMeta.setLore(newLore);
                        itemStack.setItemMeta(itemMeta);
                        lootItems.add(itemStack);
                    }
                    else {
                        throw new RuntimeException("ŒÔ∆∑"+loot+"÷–µƒ Id ≈‰÷√¥ÌŒÛ£°");
                    }
                }
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
