package com.mixpixel;

import org.bukkit.NamespacedKey;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.loot.LootContext;
import org.bukkit.loot.LootTable;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.Random;

public class mALootTable {
    public static LootTable lootTable = new LootTable() {
        @Override
        public @NotNull Collection<ItemStack> populateLoot(@NotNull Random random, @NotNull LootContext context) {
            return null;
        }

        @Override
        public void fillInventory(@NotNull Inventory inventory, @NotNull Random random, @NotNull LootContext context) {

        }

        @Override
        public @NotNull NamespacedKey getKey() {
            return null;
        }
    };
}
