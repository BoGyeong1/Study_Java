public class ExtendsCalcaulations extends Calculations {
    // Constructor
    ExtendsCalcaulations() {
        System.out.println("ExtendsCalcaulations - Constructor");
    }

    // public Method multiplication
    public int multiplication(int first, int second) {
        int result = first * second;
        return result;
    }

    // public Methods subtraction 재정의 return도 바꾸면 안됨
    // 상속을 받는 애와 해주는 애가 이름과 리턴값이 동일해야한다.
    @Override
    public int subtraction(int first, int second) {
        // int result = first - second;
        int result = second - first;
        return result;
    }
}
