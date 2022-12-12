package InheritanceVehicles;

public class Cars extends Vehicles {
    int oneway_count = 0;

    // Constructor
    Cars(int oneway_count) {
        this.oneway_count = oneway_count;
        // System.out.println("확인용");
    }

    // public Method speed 재정의
    public int speed(int kms, int hours) {
        int result = kms / hours + oneway_count;
        return result;
    }
}
