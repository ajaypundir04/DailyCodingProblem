package tutorials.coding.problems;

/**
 * Implement regular expression matching with the following special characters:
 *
 * <code>. (period)</code> which matches any single character
 * <code>* (asterisk)</code> which matches zero or more of the preceding element
 * That is, implement a function that takes in a string and a valid regular expression and returns whether or not the string matches the regular expression.
 * <p>
 * For example, given the regular expression "ra." and the string "ray", your function should return true. The same regular expression on the string "raymond" should return false.
 * <p>
 * Given the regular expression ".*at" and the string "chat", your function should return true. The same regular expression on the string "chats" should return false.
 */
public class RegexP25 {

    /**
     * check if regex matches
     *
     * @param s given string
     * @param p given regex patter
     * @return true if matched else false.
     */
    public boolean matchRegex( String s, String p ) {
        // Base conditions
        if ( isEmpty( p ) ) {
            return true;
        } else if ( isEmpty( s ) ) {
            return false;
        }

        System.out.println( s + " - " + p + " = " + s.matches( p ) );

        // chhat .*at
        int i = 0, j = 0;
        char lastMatchedChar = '\u0000';
        for ( ; i < s.length() && j < p.length(); ) {
            if ( matched( s.charAt( i ), p.charAt( j ) ) ) {
                i++;
                j++;
            } else {
                // if char is *
                if ( p.charAt( j ) == '*' ) {
                    if ( matched( s.charAt( i ), p.charAt( j - 1 ) ) ) {
                        lastMatchedChar = p.charAt( j - 1 );
                        i++;
                        j++;
                    } else {
                        j++;
                    }
                } else if ( matched( s.charAt( i ), lastMatchedChar ) ) {
                    i++;
                } else {
                    // Given pattern is other than * and .
                    if ( ( j + 1 ) < p.length() && p.charAt( j + 1 ) == '*' ) {
                        // char is followed by * so can be ignored.
                        j++;
                    } else {
                        return false;
                    }
                }
            }
        }

        if ( i < s.length() && lastMatchedChar != '\u0000' ) {
            for ( ; i < s.length(); i++ ) {
                if ( s.charAt( i ) != lastMatchedChar && lastMatchedChar != '.' ) {
                    return false;
                }
            }
        }
        boolean condition = true;
        if ( j < p.length() ) {
            condition = matched( s.charAt( s.length() - 1 ), p.charAt( p.length() - 1 ) );
        }
        return i == s.length() && condition;
    }

    private boolean isEmpty( String str ) {
        return str == null || "".equals( str );
    }

    private boolean matched( char s, char p ) {
        return s == p || p == '.';
    }
}
