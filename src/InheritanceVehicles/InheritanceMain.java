package InheritanceVehicles;

public class InheritanceMain {

    public static void main(String[] args) {

        // Vehicles 객체생성
        Vehicles vehicles = new Vehicles();
        // Vans 객체생성
        Vans vans = new Vans();
        // Cars 객체생성
        Cars cars = new Cars(3);
        // System.out.println("확인용");
    }

}
