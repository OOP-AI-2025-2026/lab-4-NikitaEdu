package ua.opnu;

import ua.opnu.java.inheritance.point.Point;

public class Point3D extends Point {
    int z;
    public Point3D() {
        super(0, 0);
        this.z = 0;
    }

    public Point3D(int x, int y, int z) {
        super(x, y);
        this.z = z;
    }
    public void setLocation(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
    public double distance(Point3D p) {
        int dx = this.x - p.x;
        int dy = this.y - p.y;
        int dz = this.z - p.z;
        return Math.sqrt(dx * dx + dy * dy+dz * dz);
    }
    public int getZ(){
        return z;
    }
    @Override
     public void setLocation(int x, int y){
        this.x = x;
        this.y = y;
        z=0;
     }
     @Override
     public String toString(){
            return "(" + x + ", " + y + ", " + z + ")";
     }
    public double distanceFromOrigin() {
        return Math.sqrt(x * x + y * y + z * z);
    }
}
