/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Program;

import java.util.ArrayList;
import java.util.Random;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import Program.location;

/**
 *
 * @author ruinan
 */
public class locationTest {
    
    /**
     * Test of getRandom method, of class location.
     */
    @Test
    public void testGetRandom() {
        location l = new location(2);
        assertNotNull(l.getRandom());
    }
    
    /**
     * Test of randomLocation method, of class location.
     */
    @Test
    public void testRandomLocation() {
       location  mockLocation = mock(location.class);//mock the location
       location l = new location();
       String[] locations = {"test","leave"};
       
       //stubs
       when(mockLocation.randomGenerating(locations.length-1, mockLocation.getRandom(), locations)).thenReturn("test");
       when(mockLocation.randomGenerating(locations.length, mockLocation.getRandom(), locations)).thenReturn("leave");
       
       assertEquals(1,l.randomLocation(locations,mockLocation).size());
       assertEquals("test",l.randomLocation(locations,mockLocation).get(0));
    }
    
    @Test
    public void testGenerating(){
        location l = new location();
        String[] locations = {"test","leave"};
        int count = locations.length;
        //mock
        Random mockRandom = mock(Random.class);
        //stub
        when(mockRandom.nextInt(count)).thenReturn(0);
        assertEquals(l.randomGenerating(count, mockRandom, locations),"test");
    }
}
