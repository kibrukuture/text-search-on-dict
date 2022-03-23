/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author feled
 */
public class __Wrapper__Test {
    
    public __Wrapper__Test() {
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
     * Test of getWrapper method, of class __Wrapper__.
     */
    @Test
    public void testGetWrapper() {
        System.out.println("getWrapper");
        __Wrapper__ instance = new __Wrapper__();
        __Wrapper__ expResult = null;
        __Wrapper__ result = instance.getWrapper();
        assertEquals(expResult, result); 
    }

    /**
     * Test of setWrapper method, of class __Wrapper__.
     */
    @Test
    public void testSetWrapper() {
        System.out.println("setWrapper");
        __Wrapper__ wrapper = null;
        __Wrapper__ instance = new __Wrapper__();
        instance.setWrapper(wrapper); 
    }

    /**
     * Test of isValidWord method, of class __Wrapper__.
     */
    @Test
    public void testIsValidWord() {
        System.out.println("isValidWord");
        String word = "";
        __Wrapper__ instance = new __Wrapper__();
        boolean expResult = false;
        boolean result = instance.isValidWord(word);
        assertEquals(expResult, result); 
    }

    /**
     * Test of main method, of class __Wrapper__.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] prop = null;
        __Wrapper__.main(prop);
       
    }
    
}
