package cn.afternode.matrilib.core.utils;

import org.bukkit.Location;

public class Locations {
    public static Location copy(Location base) {
        return new Location(base.getWorld(), base.getX(), base.getY(), base.getZ(), base.getYaw(), base.getPitch());
    }

    public static boolean isEquals(Location l1, Location l2, boolean includesRotation) {
        if (!includesRotation) {
            return l1.getWorld() == l2.getWorld() && l1.getX() == l2.getX() && l1.getY() == l2.getY() && l1.getZ() == l2.getZ();
        } else {
            return l1.getWorld() == l2.getWorld() && l1.getX() == l2.getX() && l1.getY() == l2.getY() && l1.getZ() == l2.getZ()
                    && l1.getYaw() == l2.getYaw() && l1.getPitch() == l2.getPitch();
        }
    }

    public static boolean isNearly(Location l1, Location l2, double bound) {
        return l1.distance(l2)<bound;
    }
}
