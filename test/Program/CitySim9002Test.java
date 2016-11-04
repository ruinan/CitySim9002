/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Program;


import Domain.Validator;
import java.util.Stack;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import Program.visitor;
import java.lang.Integer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
/**
 *
 * @author ruinan
 */
public class CitySim9002Test {
    /**
     * Test of visit method, of class CitySim9002.
     */
    /*
        test the visit method.
        it mocks some classes;
        and stub the inside methods.
    
    */
    
    @Test
    public void testVisit(){
        String[] visitors = new String[2];
        String[] locations = new String[2];
        visitor v = new visitor("a",null);
        CitySim9002 cs = new CitySim9002();
        
        Stack<visitor> sv = new Stack<visitor>();
        sv.push(v);
        
        //doubles
        visitor mockVisitor = mock(visitor.class);
        Validator mockValidator= mock(Validator.class);
        location mockLocation = mock(location.class);
        CitySim9002 mockCS = mock(CitySim9002.class);
        
        //stubs
        when(mockVisitor.createVisitSequence(visitors, mockVisitor)).thenReturn(sv);
        when(mockCS.visitLocations(sv.elementAt(0), locations, mockLocation, 1)).thenReturn("ok");
        when(mockValidator.validateLocation(locations)).thenReturn(true);
        when(mockValidator.validateVisitor(visitors)).thenReturn(true);
        
        assertEquals("ok",cs.visit(visitors, locations, mockLocation, mockVisitor, mockValidator, mockCS));
         
    }

    /**
     * Test of visitLocations method, of class CitySim9002.
     */
    
    
    @Test
    public void testVisitorlocations(){
        CitySim9002 CS = new CitySim9002();
        ArrayList<String> list = new ArrayList<>();
        list.add("city");
        list.add("leave");
        HashMap<String,Boolean> hash = new HashMap<>();
        hash.put("city",true);
        
        //doubles
        visitor mockVisitor = mock(visitor.class);
        String[] locations = new String[2];
        location mockLocation = mock(location.class);
        int visitCount = 1;
        
        //stubs
        when(mockVisitor.getType()).thenReturn("test_visitor");
        when(mockLocation.randomLocation(locations, mockLocation)).thenReturn(list);
        when(mockVisitor.getPreference()).thenReturn(hash);
        
        String result = "Visitor 1 is a test_visitor.\n" +
                        "Visitor 1 is going to city!\n" +
                        "Visitor 1 did like city.\n" +
                        "Visitor 1 has left the city.\n" +
                        "***\n";//The return value 
        
        assertEquals(result,CS.visitLocations(mockVisitor, locations, mockLocation, visitCount));
        
    }    
}
