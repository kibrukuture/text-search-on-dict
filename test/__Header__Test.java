 

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
 
public class __Header__Test {
    
    public __Header__Test() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of setFooter method, of class __Header__.
     */
    @Test
    public void testSetFooter() {
        System.out.println("setFooter");
        __Footer__ footer = null;
        __Header__ instance = new __Header__();
        instance.setFooter(footer);
       
    }

   
    @Test
    public void testGetFooter() {
        System.out.println("getFooter");
        __Header__ instance = new __Header__();
        __Footer__ expResult = null;
        __Footer__ result = instance.getFooter();
        assertEquals(expResult, result); 
    }
  
    @Test
    public void testGetWrapper() {
        System.out.println("getWrapper");
        __Header__ instance = new __Header__();
        __Wrapper__ expResult = null;
        __Wrapper__ result = instance.getWrapper();
        assertEquals(expResult, result);
       
    }

    /**
     * Test of setWrapper method, of class __Header__.
     */
    @Test
    public void testSetWrapper() {
        System.out.println("setWrapper");
        __Wrapper__ wrapper = null;
        __Header__ instance = new __Header__();
        instance.setWrapper(wrapper);
        // TODO review the generated test code and remove the default call to fail.
         
    }

    /**
     * Test of getPATH method, of class __Header__.
     */
    @Test
    public void testGetPATH() {
        System.out.println("getPATH");
        __Header__ instance = new __Header__();
        String expResult = "";
        String result = instance.getPATH();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
         
    }

    /**
     * Test of setPATH method, of class __Header__.
     */
    @Test
    public void testSetPATH() {
        System.out.println("setPATH");
        String PATH = "";
        __Header__ instance = new __Header__();
        instance.setPATH(PATH);
        // TODO review the generated test code and remove the default call to fail.
      
    }
 
    @Test
    public void testGetFILENAME() {
        System.out.println("getFILENAME");
        __Header__ instance = new __Header__();
        String expResult = "";
        String result = instance.getFILENAME();
        assertEquals(expResult, result);
       
    }

    /**
     * Test of setFILENAME method, of class __Header__.
     */
    @Test
    public void testSetFILENAME() {
        System.out.println("setFILENAME");
        String FILENAME = "";
        __Header__ instance = new __Header__();
        instance.setFILENAME(FILENAME);
       
    }

    /**
     * Test of getContent method, of class __Header__.
     */
    @Test
    public void testGetContent() {
        System.out.println("getContent");
        __Header__ instance = new __Header__();
        __Content__ expResult = null;
        __Content__ result = instance.getContent();
        assertEquals(expResult, result); 
    }

    /**
     * Test of setContent method, of class __Header__.
     */
    @Test
    public void testSetContent() {
        System.out.println("setContent");
        __Content__ content = null;
        __Header__ instance = new __Header__();
        instance.setContent(content); 
    }

    /**
     * Test of getSearchWord method, of class __Header__.
     */
    @Test
    public void testGetSearchWord() {
        System.out.println("getSearchWord");
        __Header__ instance = new __Header__();
        String expResult = "";
        String result = instance.getSearchWord();
        assertEquals(expResult, result); 
    }

    /**
     * Test of setSearchWord method, of class __Header__.
     */
    @Test
    public void testSetSearchWord() {
        System.out.println("setSearchWord");
        String searchWord = "";
        __Header__ instance = new __Header__();
        instance.setSearchWord(searchWord); 
    }

    
    @Test
    public void testKeyPressed() {
        System.out.println("keyPressed");
        KeyEvent e = null;
        __Header__ instance = new __Header__();
        instance.keyPressed(e); 
    }

   
    @Test
    public void testKeyReleased() {
        System.out.println("keyReleased");
        KeyEvent e = null;
        __Header__ instance = new __Header__();
        instance.keyReleased(e); 
    }
 
}
