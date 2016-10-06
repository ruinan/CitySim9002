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
/**
 *
 * @author ruinan
 */
public class CitySim9002Test {
    private static final String[] locations = {"Squirrel Hill","Downtown","The Point","The Cathedral of Learning","leave"};
    private static final String[] visitors = {"Student","Business Person","Professor","Blogger","Student"};
    private static final location loc = new location(3); 
 
    /**
     * Test of visit method, of class CitySim9002.
     */
    /*
        test the visit method.
        it mocks some classes;
        and stub the inside methods.
    
    */
    @Test
    public void testVisit() {
        Validator mockvalidator=  mock(Validator.class);
        visitor mockvisitor = mock(visitor.class);
        location mockloc = mock(location.class);
        String[] _locations = {"a"};
        String[] _visitors = {"a"};
        Stack<visitor> vs  = mock(Stack.class);
        //visitor vv = new visitor();
        CitySim9002 cs = mock(CitySim9002.class);
        int count = 1;
        when(mockvalidator.validateLocation(_locations)).thenReturn(true);
        when(mockvalidator.validateVisitor(_visitors)).thenReturn(true);
        when(mockvisitor.createVisitSequence(visitors)).thenReturn(vs);
        when(cs.visitLocations(mockvisitor, _locations, mockloc,count)).thenReturn("xx");
      
        assertFalse(new CitySim9002().visit(visitors, locations, loc).equals(""));// return value should not be ""
    }

    /**
     * Test of visitLocations method, of class CitySim9002.
     */
    // test the visitlocation method
    // stub the randomLocation  method
    @Test
    public void testVisitLocations() {
        CitySim9002 cs = new CitySim9002();
        location mockloc = mock(location.class);
        HashMap<String, Boolean> hashmapStudent = new HashMap<>();//test all the prefereces must be reached in test
                hashmapStudent.put("Squirrel Hill",true);
                hashmapStudent.put("Downtown",true);
                hashmapStudent.put("The Point",true);
                hashmapStudent.put("The Cathedral of Learning",false);  
               // System.out.println("map"+hashmap.get("Downtown"));
        visitor student = new visitor("Student",hashmapStudent);
        
        ArrayList<String> citiesList = new ArrayList<String>(); 
        citiesList.add(locations[0]);
        citiesList.add(locations[1]);
               
        when(mockloc.randomLocation(locations, loc.getRandom())).thenReturn(citiesList);
        
        assertTrue(cs.visitLocations(student, locations, loc, 1).length()>0);//return value should not be ""
       
       
    }
    
}
