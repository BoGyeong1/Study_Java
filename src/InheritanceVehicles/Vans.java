package InheritanceVehicles;

public class Vans extends Vehicles {
    // Constructor
    Vans() {

    }

    // public Method windows_count
    public int windows_count(int oneway_count) {
        int result = oneway_count * 3;
        return result;
    }

}
