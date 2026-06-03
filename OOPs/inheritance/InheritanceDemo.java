// Inheritance -> Code Reusability + IS-A Relationship 

package inheritance;


class P1{
    public void m1(){
        System.out.println("i am parent");
    }
}
class C1 extends P1 {
    public void m2(){
        System.out.println("i am child");
    }
}
public class InheritanceDemo {
    public static void main(String[] args) {
        // case : 1 => parent ref holds childs ref
        // P1 p = new C1();
        // p.m2(); // will give error


        // case : 2 => child holds parent ref
        // C1 c = new P1(); // Will Give Error


        // case : 3 => parent class try to acess child method
        // P1.m2(); // will give error


        // case : 4 => child ref hold child method
        // C1 c = new C1(); // no error
    }
}
