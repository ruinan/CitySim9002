/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Program;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author ruinan
 */
public class location {
    
    private Random r;
   
    
    public location(int seed){
       this.r = new Random(seed); 
       
    }
    
    public Random getRandom(){
        return this.r;
    }
   
    public ArrayList<String> randomLocation(String[] locations,Random random){//test
        int index = 0;
        int count = locations.length;  
        ArrayList<String> loc = new ArrayList<>();
        
        index = count-1;
        int f = random.nextInt(index);
        loc.add(locations[f]);
        
        index = random.nextInt(count);
        loc.add(locations[index]);
        
        while(index != 4){// does not have 'leave' 
            index = random.nextInt(count);
            loc.add(locations[index]);
        }
        
        return loc; 
    }
   
   
}
