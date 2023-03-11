package cn.afternode.matrilib.core.utils;

public class Maths {
    public static double positive(double d) {
        if (d < 0) return -d;
        return d;
    }
}
