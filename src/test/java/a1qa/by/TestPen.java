package a1qa.by;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.*;

import static org.testng.Assert.assertEquals;

/**
 * Created by User on 05.06.2017.
 */
public class TestPen {

    @Test(expectedExceptions = Exception.class)
    public void testPenNegativeInkContainerValue() {
        Pen pen = new Pen(-1);
    }

    @Test(expectedExceptions = Exception.class)
    public void testPenInkContainerValueNegativeSizeLetter() {
        Pen pen = new Pen(1, -1);
    }

    @Test(expectedExceptions = Exception.class)
    public void testPenIntContainerValueNegativeSizeLetterColor() {
        Pen pen = new Pen(1, -1, "ORANGE");
    }

    @Test(expectedExceptions = Exception.class)
    public void testPenNegativeInkContainerValueSizeLetterColor() {
        Pen pen = new Pen(-1, 1, "ORANGE");
    }

    @Test
    public void testPenIsWorkPositiveMax(){
        Pen pen = new Pen(Integer.MAX_VALUE);
        boolean boo = pen.isWork();
        assertEquals(boo, true);
    }

    @Test
    public void testPenIsWorkNegativeNull() {
        Pen pen = new Pen(0);
        boolean boo = pen.isWork();
        assertEquals(boo, false);
    }

    @Test
    public void testPenIsWorkNegativeMin() {
        Pen pen = new Pen(Integer.MIN_VALUE);
        boolean boo = pen.isWork();
        assertEquals(boo, false);
    }

    @Test
    public void testWriteIsWorkCondition() {
        Pen pen = new Pen(-1);
        assertEquals(pen.write("a"), "");
    }

    @Test
    public void testWritePartOfWord() {
        Pen pen = new Pen(4, 0.5);
        assertEquals(pen.write("qwertyuiop"), "qwertyui");
    }

    @Test
    public void testWriteWholeWordEqualInkContainerValue() {
        Pen pen = new Pen(10, 2);
        assertEquals(pen.write("qwert"), "qwert");
    }

    @Test
    public void testWriteWholeWordMoreInkContainerValue() {
        Pen pen = new Pen(100, 2);
        assertEquals(pen.write("qwert"), "qwert");
    }

    @Test
    public void testWriteEmptyWord() {
        Pen pen = new Pen(10, 2);
        assertEquals(pen.write(" "), " ");
    }


    @Test
    public void testWriteDoubleSizeOfWordRoundDown() {
        Pen pen = new Pen(4, 0.7);
        assertEquals(pen.write("qwertyuio"), "qwerty");
    }

    @Test
    public void testWriteDoubleSizeOfWordRoundUp() {
        Pen pen = new Pen(4, 0.5);
        assertEquals(pen.write("qwertyuio"), "qwert");
    }

    @Test
    public void getColorTest() {
        Pen pen = new Pen(10, 2, "RED");
        assertEquals(pen.getColor(), "RED");
    }

    @Test
    public void doSomethingElseTest() throws IOException {
        int inkContainerValue = 30;
        double letterSize = 1.0;
        Pen testPenThreeArgs = new Pen(inkContainerValue, letterSize, "RED");
        File file = new File("1.txt");
        PrintStream ps = new PrintStream(file);
        PrintStream standardOut = System.out;
        System.setOut(ps);
        testPenThreeArgs.doSomethingElse();
        System.setOut(standardOut);
        BufferedReader fin = new BufferedReader(new FileReader(file));
        String line;
        line = fin.readLine();
        Assert.assertEquals("RED", line);
    }
}
