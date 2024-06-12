import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.Test;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.junit.Assert.*;
import hackerDemo.TextAnalyzer;

import javax.swing.*;


public class TextAnalyzerTest {

    private TextAnalyzer tg;
    private List list = new ArrayList<>();

    @Before
    public void setUp() throws IOException {
        Scanner scanner = new Scanner(System.in); // 创建Scanner对象
        String input = "D:/demo/SWE/aaa.txt";
        tg = new TextAnalyzer(input);
        if(tg == null)
        {
            System.out.println("Input file not found");
        }
        tg.showDirectedGraph();
        list.add(" ");
    }
    @Test
    public void testqueryBridgeWords1() throws IOException {
        Assert.assertEquals("usecase1 failed!", list, tg.queryBridgeWords("to", "yes"));
    }
    @Test
    public void testqueryBridgeWords2() throws IOException {
        Assert.assertEquals("usecase2 failed!", list, tg.queryBridgeWords("no", "yes"));
    }
    @Test
    public void testqueryBridgeWords5() throws IOException{
        List sk = new ArrayList<>();
        sk.add("life");
        Assert.assertEquals("usecase5 failed!", sk, tg.queryBridgeWords("new", "and"));
    }

    @Test
    public void testqueryBridgeWords3() throws IOException {
        List sk = new ArrayList<>();
        sk.add("seek");
        sk.add("pop");
        Assert.assertEquals("usecase3 failed!", sk, tg.queryBridgeWords("to", "out"));
    }
    @Test
    public void testqueryBridgeWords4() throws IOException {
        List sk = new ArrayList<>();
        Assert.assertEquals("usecase4 failed!", sk, tg.queryBridgeWords("to", "and"));
    }
    @Test
    public void testqueryBridgeWords6() throws IOException {
        Assert.assertEquals("usecase6 failed!", list, tg.queryBridgeWords(null, "no and yes ok!"));
    }

    // 清理输出流
    @After
    public void aftertest(){
        System.setOut(System.out);
    }


}
