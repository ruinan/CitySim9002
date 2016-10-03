/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Program;
import Domain.Validator;
import java.util.ArrayList;
import java.util.Stack;
/**
 *
 * @author ruinan
 */
public class CitySim9002 {
    
    public static void main(String[] args){
        
        Validator v= new Validator();
        if (v.validateArguments(args)) {
            
            System.out.println(args[0]);  
            CitySim9002 cs = new CitySim9002();
            cs.visitLocs(Integer.parseInt(args[0]));  
        }
        else {
           
            System.out.println("Sorry");
        }
    
    }
    
    public void visitLocs(int seed){
        visitor v = new visitor();
        Stack<visitor> visitors;
        visitors = v.getAllVisitors();
        //System.out.println(visitors.size());
      
        location l = new location(seed);
        
        //System.out.println(citiesList.toArray());
        
        int visitCount = 1;
        String result = "";
        while(!visitors.empty()){
            visitor visitor  = new visitor();
            visitor= visitors.pop();
            result += ("Visitor "+visitCount+" is a "+visitor.getType()+".\n");
            ArrayList<String> citiesList = l.randomLocation();
            
            for(int i = 0;i<citiesList.size()-1;i++){
                String city = citiesList.get(i);
                result += ("Visitor "+visitCount+" is going to "+city+"!\n");
                
                if(visitor.getPreference().get(city)){// need test inputs for Hashmap
                   result += ("Visitor "+visitCount+" did like "+city+".\n");
                }
                else{
                    result += ("Visitor "+visitCount+" did not like "+city+".\n");
                }
            }
            result += ("Visitor "+visitCount+" has left the city.\n***\n");
            visitCount++;
        }
        System.out.println(result);
        
    }
    
   
}
