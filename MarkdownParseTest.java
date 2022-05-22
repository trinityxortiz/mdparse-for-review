import static org.junit.Assert.*;
import org.junit.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class MarkdownParseTest {
    @Test
    public void addition() {
        assertEquals(2, 1 + 1);
    }

    @Test
    public void test1() throws IOException {
        Path fileName = Path.of("test-file.md");
        String content = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(content);
        assertEquals(List.of("https://something.com", "some-thing.html"), links);
    }

    @Test
    public void test2() throws IOException {
        Path fileName = Path.of("test-file2.md");
        String content = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(content);
        assertEquals(List.of(), links);
    }

    @Test
    public void test3() throws IOException {
        Path fileName = Path.of("test-file3.md");
        String content = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(content);
        assertEquals(List.of("https://something.com", "some-thing.html"), links);
    }

    @Test
    public void test4() throws IOException {
        Path fileName = Path.of("test-file4.md");
        String content = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(content);
        assertEquals(List.of(), links);
    }

    @Test
    public void failTest() {
        assertEquals(2, 1+1);
    }

    //TESTS FOR LAB REPORT 4
    public String readString(String path) throws IOException {
        Path fileName = Path.of(path);
        return Files.readString(fileName);
    }
    
    @Test
    public void testsnippet1() {
        try {
            assertEquals(List.of("`google.com", "google.com", "ucsd.edu"), 
            MarkdownParse.getLinks(readString("snippet1.md")));
        } catch (IOException e) {
        }
        
    }

    @Test
    public void testsnippet2(){
        try {
            assertEquals(List.of("a.com", "a.com(())", "example.com"), 
            MarkdownParse.getLinks(readString("snippet2.md")));
        } catch (IOException e) {
        }
    }


    @Test
    public void testsnippet3(){
        try {
            assertEquals(List.of("https://www.twitter.com", "https://sites.google.com/eng.ucsd.edu/cse-15l-spring-2022/schedule", 
                "https://cse.ucsd.edu/"), 
            MarkdownParse.getLinks(readString("snippet3.md")));
        } catch (IOException e) {
        }
    }
}