/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Program;

import java.util.HashMap;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 *
 * @author ruinan
 */
public class visitorTest {
   
    /**
     * Test of getType method, of class visitor.
     */
    @Test
    public void testGetType() {
       //if return Type is equal as expected, then pass.
        visitor instance = new visitor("test",null);
        String expResult = "test";
        String result = instance.getType();
        assertEquals(expResult, result);
       
    }

    /**
     * Test of getPreference method, of class visitor.
     */
    @Test
    public void testGetPreference() {
        //as same as previous one
        System.out.println("getPreference");
        visitor instance = new visitor("",null);
        HashMap<String, Boolean> expResult = null;
        HashMap<String, Boolean> result = instance.getPreference();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of createVisitSequence method, of class visitor.
     */
    @Test
    public void testCreateVisitSequence() {
        // test the create visit sequence
        //if successed, the amount of elements in sequence will as same as the input visitors`.
        System.out.println("createVisitSequence");
        visitor mockVisitor = mock(visitor.class);
        visitor instance =new visitor();
        String[] visitor = {"Student","Business Person","Professor","Blogger"};
       
        when(mockVisitor.generateVisitor(any(String.class))).thenReturn(mockVisitor);//stub method
       
        assertEquals(instance.createVisitSequence(visitor).size(), 4);
        
       
    }
    
    
//    /**
//     * Test of generateVisitor method, of class visitor.
//     */
    @Test
    public void testGenerateVisitor() {
        visitor instance = new visitor();
        String[] visitor = {"Student","Business Person","Professor","Blogger","default"};
        //in order to test all possible input value;
        for(String v: visitor){
            if(v.equals("default")){
                assertNull(instance.generateVisitor(v));
            }
            else{
                assertEquals(instance.generateVisitor(v).getType(),v);
            }
            
        }
        
        
        
    }
    
}
