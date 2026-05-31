package OOPs;
public class abstrMethodandClass {
    public static void main(String[] args) {
        Bus b = new Bus(); // object creation is possible only coz it is not abstract 
        System.out.println(b.getNoOfWheels()); // 6
        Auto  a = new Auto(); // object creation is possible only coz it is not abstract 
        System.out.println(a.getNoOfWheels()); // 3
    }
}

abstract class vehicle{
    public abstract int getNoOfWheels(); // only declaration
}
class Bus extends vehicle{
    // implementation
    public int getNoOfWheels(){
        return 6;
    }
}

class Auto extends vehicle{
    // implementation
    public int getNoOfWheels(){
        return 3;
    }
}