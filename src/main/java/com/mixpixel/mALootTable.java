package com.mixpixel;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.loot.LootContext;
import org.bukkit.loot.LootTable;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

public class mALootTable {
    public static LootTable lootTable = new LootTable() {
        @Override
        public @NotNull Collection<ItemStack> populateLoot(@NotNull Random random, @NotNull LootContext context) {
            Collection<ItemStack> lootItems = new ArrayList<>();
            int possibility1 = random.nextInt(100);
            if (possibility1<50){
                ItemStack itemStack = new ItemStack(Material.DIAMOND, 4);
                lootItems.add(itemStack);
            }
            if (possibility1<20) {
                ItemStack itemStack = new ItemStack(Material.EMERALD, 8);
                lootItems.add(itemStack);
            }
            if (possibility1<10){
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
