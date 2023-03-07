package cn.afternode.matrilib.core.utils;

import org.bukkit.Location;

public class Locations {
    public static Location copy(Location base) {
        return new Location(base.getWorld(), base.getX(), base.getY(), base.getZ(), base.getYaw(), base.getPitch());
    }
}
