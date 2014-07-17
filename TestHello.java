import static org.junit.Assert.assertEquals;
import junit.framework.JUnit4TestAdapter;
import org.junit.*;

import java.io.*;

public class TestHello {
    private ByteArrayOutputStream _baos;
    private PrintStream _out;

    @Before public void setUp() {
        _baos = new ByteArrayOutputStream();
        _out = System.out;
        System.setOut(
                new PrintStream(
                    new BufferedOutputStream(_baos)
                    )
                );
    }

    @After public void tearDown() {
        System.setOut(_out);
    }

    @Test public void testHello() {
        //inputのシミュレート
        String inputData = "Hello";
        System.setIn(new java.io.ByteArrayInputStream(inputData.getBytes()));
        //実際のテスト
        Hello.main(new String[0]);
        System.out.flush();
        //出力の想定
        String expected = joinStrings("Hello");
        String actual = _baos.toString();
        assertEquals(expected, actual);
    }

    private String joinStrings(String... strs) {
        String newLine = System.getProperty("line.separator");
        String result = "";
        for (String s : strs) {
            result += s + newLine;
        }
        return result;
    }

    public static junit.framework.Test suite() {
        return new JUnit4TestAdapter(TestHello.class);
    }
}
