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
    public location(int s){
       r = new Random(s); 
    }
    private String[] l = {"Squirrel Hill","Downtown","The Point","The Cathedral of Learning","leave"};
   
    public String getLocation(int index){
        return this.l[index];
        //check the index;
    }
   
    public ArrayList<String> randomLocation(){
        int index = 0;
        int count = l.length;
        
        ArrayList<String> loc = new ArrayList<>();// stack is fine
        
        index = count-1;
        int f = r.nextInt(index);
        //System.out.println(l[f]);//test the leave would or would not be reached;
        loc.add(l[f]);
        
        
        index = r.nextInt(count);
        //System.out.println(l[index]);
        loc.add(l[index]);
        while(index != 4){
            index = r.nextInt(count);
            loc.add(l[index]);
            //System.out.println(l[index]);
        }
        
        return loc; 
    }
   
   
}
