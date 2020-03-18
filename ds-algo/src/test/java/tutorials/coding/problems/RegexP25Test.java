package tutorials.coding.problems;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class RegexP25Test {

    private RegexP25 regexP25 = new RegexP25();

    @TestFactory
    public Stream< DynamicTest > matchRegex() {
        return Stream.of(
                Data.of( "ray", "ra.", true ),
                Data.of( "raymond", "ra.", false ),
                Data.of( "chat", ".*at", true ),
                Data.of( "aab", "c*a*b", true ),
                Data.of( "mississippi", "mis*is*ip*.", true ),
                Data.of( "aaa", "ab*a*c*a", true ),
                Data.of( "ab", ".*c", false ),
                Data.of( "chats", ".*at", false )
        ).map( d -> DynamicTest.dynamicTest(
                String.format( "Matching pattern \"%s\" with string \"%s\"", d.regex, d.string ),
                () -> {
                    boolean result = regexP25.matchRegex( d.string, d.regex );
                    assertEquals( d.status, result );
                }
        ) );
    }

    static class Data {
        private String string;
        private String regex;
        private boolean status;

        Data( String string, String regex, boolean status ) {
            this.string = string;
            this.regex = regex;
            this.status = status;
        }

        static Data of( String string, String regex, boolean status ) {
            return new Data( string, regex, status );
        }
    }

}