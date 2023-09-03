package com.mixpixel;

import net.kyori.adventure.text.Component;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.block.ShulkerBox;
import org.bukkit.block.data.BlockData;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.loot.LootTable;
import org.bukkit.material.MaterialData;
import org.bukkit.metadata.MetadataValue;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.UUID;

public class mALooting {
    public static void looting(Player player){
        player.sendMessage("A loot is coming to You!");
        ShulkerBox shulkerBox = new ShulkerBox() {
            @Override
            public @Nullable DyeColor getColor() {
                return null;
            }

            @Override
            public boolean isRefillEnabled() {
                return false;
            }

            @Override
            public boolean hasBeenFilled() {
                return false;
            }

            @Override
            public boolean hasPlayerLooted(@NotNull UUID player) {
                return false;
            }

            @Override
            public @Nullable Long getLastLooted(@NotNull UUID player) {
                return null;
            }

            @Override
            public boolean setHasPlayerLooted(@NotNull UUID player, boolean looted) {
                return false;
            }

            @Override
            public boolean hasPendingRefill() {
                return false;
            }

            @Override
            public long getLastFilled() {
                return 0;
            }

            @Override
            public long getNextRefill() {
                return 0;
            }

            @Override
            public long setNextRefill(long refillAt) {
                return 0;
            }

            @Override
            public @NotNull Inventory getInventory() {
                return null;
            }

            @Override
            public @NotNull Inventory getSnapshotInventory() {
                return null;
            }

            @Override
            public @Nullable Component customName() {
                return null;
            }

            @Override
            public void customName(@Nullable Component customName) {

            }

            @Override
            public @Nullable String getCustomName() {
                return null;
            }

            @Override
            public void setCustomName(@Nullable String name) {

            }

            @Override
            public @NotNull PersistentDataContainer getPersistentDataContainer() {
                return null;
            }

            @Override
            public @NotNull Block getBlock() {
                return null;
            }

            @Override
            public @NotNull MaterialData getData() {
                return null;
            }

            @Override
            public @NotNull BlockData getBlockData() {
                return null;
            }

            @Override
            public @NotNull Material getType() {
                return null;
            }

            @Override
            public byte getLightLevel() {
                return 0;
            }

            @Override
            public @NotNull World getWorld() {
                return null;
            }

            @Override
            public int getX() {
                return 0;
            }

            @Override
            public int getY() {
                return 0;
            }

            @Override
            public int getZ() {
                return 0;
            }

            @Override
            public @NotNull Location getLocation() {
                return null;
            }

            @Override
            public @Nullable Location getLocation(@Nullable Location loc) {
                return null;
            }

            @Override
            public @NotNull Chunk getChunk() {
                return null;
            }

            @Override
            public void setData(@NotNull MaterialData data) {

            }

            @Override
            public void setBlockData(@NotNull BlockData data) {

            }

            @Override
            public void setType(@NotNull Material type) {

            }

            @Override
            public boolean update() {
                return false;
            }

            @Override
            public boolean update(boolean force) {
                return false;
            }

            @Override
            public boolean update(boolean force, boolean applyPhysics) {
                return false;
            }

            @Override
            public byte getRawData() {
                return 0;
            }

            @Override
            public void setRawData(byte data) {

            }

            @Override
            public boolean isPlaced() {
                return false;
            }

            @Override
            public boolean isCollidable() {
                return false;
            }

            @Override
            public void open() {

            }

            @Override
            public void close() {

            }

            @Override
            public boolean isOpen() {
                return false;
            }

            @Override
            public boolean isLocked() {
                return false;
            }

            @Override
            public @NotNull String getLock() {
                return null;
            }

            @Override
            public void setLock(@Nullable String key) {

            }

            @Override
            public void setLootTable(@Nullable LootTable table) {

            }

            @Override
            public @Nullable LootTable getLootTable() {
                return null;
            }

            @Override
            public void setSeed(long seed) {

            }

            @Override
            public long getSeed() {
                return 0;
            }

            @Override
            public void setMetadata(@NotNull String metadataKey, @NotNull MetadataValue newMetadataValue) {

            }

            @Override
            public @NotNull List<MetadataValue> getMetadata(@NotNull String metadataKey) {
                return null;
            }

            @Override
            public boolean hasMetadata(@NotNull String metadataKey) {
                return false;
            }

            @Override
            public void removeMetadata(@NotNull String metadataKey, @NotNull Plugin owningPlugin) {

            }
        };
        shulkerBox.setCustomName("±¶≤ÿœ‰");
        shulkerBox.setLootTable(mALootTable.lootTable);
        Inventory inventory = shulkerBox.getInventory();
        ItemStack itemStack = new ItemStack(Material.EMERALD);
        ItemMeta meta = itemStack.getItemMeta();
        inventory.addItem(itemStack);

    }
}
