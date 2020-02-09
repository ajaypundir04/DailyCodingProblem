package demo.code.graphs;


import java.util.*;

public class ValidParenthesisStrings {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = "abc";
        System.out.println("Type string with parenthesis (or 'exit' to terminate): ");
        while (input != null && !"exit".equals(input)) {
            input = sc.nextLine();
            System.out.println(
                    validCombos(input)
            );
        }
        sc.close();
    }

    static List<String> validCombos(String input) {
        return usingBFS(input);
    }

    private static boolean isBalanced(String str) {
        int counter = 0;
        for (char c : str.toCharArray()) {
            if (c == '(') {
                counter++;
            } else if (c == ')') {
                counter--;
                if (counter < 0) {
                    return false;
                }
            }
        }
        return counter == 0;
    }

    static List<String> usingBFS(String input) {
        List<String> answer = new ArrayList<>();
        Set<String> visited = new HashSet<>();

        Queue<String> queue = new LinkedList<>();
        queue.add(input);
        int counter = 0;

        while (!queue.isEmpty()) {
            counter++;
            boolean found = false;
            String tmp = queue.poll();
            if (visited.contains(tmp)) {
                continue;
            }
            visited.add(tmp);
            if (isBalanced(tmp)) {
                answer.add(tmp);
                found = true;
            }
            if(found) {
                continue;
            }
            for (int i = 0; i < tmp.length(); i++) {
                char c = tmp.charAt(i);
                if (c == '(' || c == ')') {
                    String st = tmp.substring(0, i).concat(tmp.substring(i + 1));
                    queue.add(st);
                }
            }
        }
        System.out.println(counter);
        return answer;
    }
}
