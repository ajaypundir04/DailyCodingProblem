package demo.code.problems;

public class Problem1 implements Runnable {

    @Override
    public void run() {
        System.out.println("Anagram check");
        System.out.println(isAnagram("anagram", "nagaram"));
    }

    private boolean isAnagram(String s, String t) {
        return true;
    }
}
