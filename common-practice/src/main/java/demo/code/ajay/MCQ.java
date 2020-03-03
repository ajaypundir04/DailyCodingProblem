package demo.code.ajay;

public class MCQ {

    private final void add(int i, int j) {
        System.out.println(i+j);
    }

    private final void add(float i, float j) {
        System.out.println(i+j);
    }

    public static void main(String[] args) {
        new MCQ().add(1, 2);
    }
}
