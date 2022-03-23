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
public class __Footer__Test {
    
    public __Footer__Test() {
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
     * Test of setText method, of class __Footer__.
     */
    @Test
    public void testSetText() {
        System.out.println("setText");
        String string = "";
        __Footer__ instance = new __Footer__();
        instance.setText(string);
        // TODO review the generated test code and remove the default call to fail.
         
    }

    /**
     * Test of getText method, of class __Footer__.
     */
    @Test
    public void testGetText() {
        System.out.println("getText");
        __Footer__ instance = new __Footer__();
        String expResult = "No file is created";
        String result = instance.getText();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }
    
}
