package demo.code.google;

import java.util.*;

public class PhoneKeyCombos {
    public static void main(String[] args) {
        PhoneKeyCombos p = new PhoneKeyCombos();
        System.out.println(p.letterCombinations("789"));
    }


    Map<Character, List<String>> db = new HashMap<>();

    public PhoneKeyCombos() {
        db.put('2', Arrays.asList("a", "b", "c"));
        db.put('3', Arrays.asList("d", "e", "f"));
        db.put('4', Arrays.asList("g", "h", "i"));
        db.put('5', Arrays.asList("j", "k", "l"));
        db.put('6', Arrays.asList("m", "n", "o"));
        db.put('7', Arrays.asList("p", "q", "r", "s"));
        db.put('8', Arrays.asList("t", "u", "v"));
        db.put('9', Arrays.asList("w", "x", "y", "z"));
    }

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();

        if (digits.length() == 0) {
            return Collections.emptyList();
        }

        if (digits.length() == 1) {
            return db.getOrDefault(digits.charAt(0), Collections.emptyList());
        }

        for (int i = 0; i < digits.length(); i++) {
            result = combos(result, db.get(digits.charAt(i)));
        }
        return result;
    }


    private List<String> combos(List<String> prev, List<String> strs) {
        List<String> tmp = new ArrayList<>();
        if (prev.size() == 0) {
            return strs;
        } else {
            for (int i = 0; i < prev.size(); i++) {
                for (int j = 0; j < strs.size(); j++) {
                    tmp.add(prev.get(i) + strs.get(j));
                }
            }
        }
        return tmp;
    }
}
