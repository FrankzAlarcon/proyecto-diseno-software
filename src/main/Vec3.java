package main;

public class Vec3 {

    public static void main(String[] args) {
        Ubicacion u1 = new Ubicacion();
        Ubicacion u2 = new Ubicacion(0,20,-2);
        Vec3 v1 = toVec3(u1);
        Vec3 v2 = toVec3(u2);

        System.out.println(v1);
        System.out.println(v2);

        Vec3 a = toVec3(u1);
        Vec3 b = toVec3(u2);
        Vec3 c = b.minus(a);
        Vec3 b1 = b.times(a.getModule()/b.getModule());
        Vec3 d = b1.minus(a);

        double ang1 = d.angle(b1);
        double ang2 = a.angle(c.times(-1));
        double tetha = ang2 - ang1;

        System.out.println(tetha);

    }

    private static Vec3 toVec3(Ubicacion ubicacion){
        //6371e3
        double R = 10 + ubicacion.getElevacion();
        double tetha = Math.toRadians(ubicacion.getLongitud());
        double phi = Math.toRadians(ubicacion.getLatitud());

        double x = R * Math.cos(phi) * Math.sin(tetha);
        double y = R * Math.sin(phi);
        double z = R * Math.cos(phi) * Math.cos(tetha);

        return new Vec3(x, y, z);
    }
    public double x,y,z;

    public Vec3(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Vec3(double val) {
        this(val, val, val);
    }

    public double getModule(){
        return Math.sqrt(Math.pow(x,2) + Math.pow(y,2) + Math.pow(z,2));
    }

    public Vec3 getDir(){
        return Vec3.times(this, 1/getModule());
    }

    public Vec3 add(Vec3 v1){
        return Vec3.add(this, v1);
    }

    public Vec3 minus(Vec3 v1){
        return Vec3.minus(this, v1);
    }

    public Vec3 times(double d){
        return Vec3.times(this, d);
    }

    public double dot(Vec3 vec){
        return Vec3.dot(this, vec);
    }

    public Vec3 cross(Vec3 vec){
        return Vec3.cross(this, vec);
    }

    @Override
    public String toString() {
        return "x:" + x + ", y:" + y + ", z:" + z;
    }

    public double angle(Vec3 vec3){
        return Vec3.angle(this, vec3);
    }

    public static Vec3 add(Vec3 A, Vec3 B){
        double x = A.x + B.x;
        double y = A.y + B.y;
        double z = A.z + B.z;
        return new Vec3(x, y, z);
    }

    public static Vec3 minus(Vec3 A, Vec3 B){
        double x = A.x - B.x;
        double y = A.y - B.y;
        double z = A.z - B.z;
        return new Vec3(x, y, z);
    }

    public static Vec3 times(Vec3 A, double d){
        return new Vec3(
                A.x * d,
                A.y * d,
                A.z * d
        );
    }

    public static Vec3 cross(Vec3 A, Vec3 B){
        double x = A.y*B.z - A.z*B.y;
        double y = B.x*A.z - A.x*B.z;
        double z = A.x*B.y - A.y*B.x;
        return new Vec3(x, y, z);
    }

    public static double dot(Vec3 A, Vec3 B){
        return A.x*B.x + A.y*B.y + A.z*B.z;
    }

    public static double angle(Vec3 A, Vec3 B){
        return Math.acos(A.dot(B)/(A.getModule()*B.getModule()));
    }

}
