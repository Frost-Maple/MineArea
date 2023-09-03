package com.mixpixel;

import org.bukkit.*;
import org.bukkit.block.ShulkerBox;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BlockStateMeta;
import org.bukkit.loot.LootContext;
import org.bukkit.loot.LootTable;


import java.util.Collection;
import java.util.Random;

public class mALooting {
    public static void looting(Player player, World world, Location location){
        player.sendMessage("A loot is coming to You!");
        ItemStack shulkerBox = new ItemStack(Material.SHULKER_BOX);
        BlockStateMeta blockStateMeta = (BlockStateMeta) shulkerBox.getItemMeta();
        ShulkerBox shulkerBox1 = (ShulkerBox) blockStateMeta.getBlockState();
        Inventory inventory = shulkerBox1.getInventory();
        LootContext lootContext = new LootContext.Builder(location).build();
        LootTable lootTable = mALootTable.lootTable;
        Collection<ItemStack> items = lootTable.populateLoot(new Random(),lootContext);
        for (ItemStack itemStack: items){
            inventory.addItem(itemStack);
        }
        ItemStack itemStack = new ItemStack(Material.EMERALD_BLOCK);
        inventory.addItem(itemStack);
        blockStateMeta.setBlockState(shulkerBox1);
        shulkerBox.setItemMeta(blockStateMeta);
        world.dropItemNaturally(location, shulkerBox);
    }
}
