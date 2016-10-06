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
       location l = mock(location.class);
       Random random = mock(Random.class);
       Random r = new Random();
       String[] loc = {"a"};
       assertNotNull(l.randomLocation(loc, r));
    }
    
    
    
}
