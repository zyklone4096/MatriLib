package cn.afternode.matrlib.liquidbounce;

import org.bukkit.Location;

import java.util.ArrayList;
import java.util.List;

public class PathUtils {
    public static List<Location> findBlinkPath(final double tpX, final double tpY, final double tpZ, final Location from) {
        final List<Location> positions = new ArrayList<>();

        double curX = from.getX();
        double curY = from.getY();
        double curZ = from.getZ();
        double distance = Math.abs(curX - tpX) + Math.abs(curY - tpY) + Math.abs(curZ - tpZ);

        for (int count = 0; distance > 0.0D; count++) {
            distance = Math.abs(curX - tpX) + Math.abs(curY - tpY) + Math.abs(curZ - tpZ);

            final double diffX = curX - tpX;
            final double diffY = curY - tpY;
            final double diffZ = curZ - tpZ;
            final double offset = (count & 1) == 0 ? 0.4D : 0.1D;

            final double minX = Math.min(Math.abs(diffX), offset);
            if (diffX < 0.0D) curX += minX;
            if (diffX > 0.0D) curX -= minX;

            final double minY = Math.min(Math.abs(diffY), 0.25D);
            if (diffY < 0.0D) curY += minY;
            if (diffY > 0.0D) curY -= minY;

            double minZ = Math.min(Math.abs(diffZ), offset);
            if (diffZ < 0.0D) curZ += minZ;
            if (diffZ > 0.0D) curZ -= minZ;

            positions.add(new Location(from.getWorld(), curX, curY, curZ, from.getYaw(), from.getPitch()));
        }

        return positions;
    }

    public static List<Location> findPath(final double tpX, final double tpY, final double tpZ, final double offset, Location from) {
        final List<Location> positions = new ArrayList<>();
        final double steps = Math.ceil(getDistance(from.getX(), from.getY(), from.getZ(), tpX, tpY, tpZ) / offset);

        final double dX = tpX - from.getX();
        final double dY = tpY - from.getY();
        final double dZ = tpZ - from.getZ();

        for(double d = 1D; d <= steps; ++d) {
            positions.add(new Location(from.getWorld(),
                    from.getX() + (dX * d) / steps, from.getY() + (dY * d) / steps, from.getZ() + (dZ * d) / steps,
                    from.getYaw(), from.getPitch()));
        }

        return positions;
    }

    private static double getDistance(final double x1, final double y1, final double z1, final double x2, final double y2, final double z2) {
        final double xDiff = x1 - x2;
        final double yDiff = y1 - y2;
        final double zDiff = z1 - z2;

        return Math.sqrt(xDiff * xDiff + yDiff * yDiff + zDiff * zDiff);
    }
}
