package cn.afternode.matrlib.liquidbounce;

import org.bukkit.Material;

import java.util.Arrays;
import java.util.List;

public class InventoryUtils {
    public static final List<Material> Material_BLACKLIST = Arrays.asList(
            Material.CHEST,
            Material.ENDER_CHEST,
            Material.TRAPPED_CHEST,
            Material.ANVIL,
            Material.SAND,
            Material.COBWEB,
            Material.TORCH,
            Material.CRAFTING_TABLE,
            Material.FURNACE,
            Material.LEGACY_WATER_LILY,
            Material.DISPENSER,
            Material.STONE_PRESSURE_PLATE,
            Material.NOTE_BLOCK,
            Material.DROPPER,
            Material.TNT,
            Material.REDSTONE_TORCH
    );
}
