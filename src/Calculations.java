public class Calculations extends Object {
    int _fisrt = 0;
    int _second = 0;

    // Constructor
    Calculations() {
        System.out.println("Calculations - Constructor");
    }

    Calculations(int first, int second) {
        System.out.println("Calculations - Constructor with parms");
        this._fisrt = first;
        this._second = second;

    }

    // multiplication
    public int multiplication() {
        int result = this._fisrt * this._second;
        return result;
    }

    // Public Methods additon
    public int addition(int first, int second) {
        int result = first + second;
        return result;
    }

    // public Methods subtraction
    public int subtraction(int first, int second) {
        int result = first - second;
        return result;
    }
}
