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
        visitor visitor = new visitor();
        
        CitySim9002 cs = new CitySim9002();
        
        String[] locations = {"Squirrel Hill","Downtown","The Point","The Cathedral of Learning","leave"};
        String[] visitors = {"Student","Business Person","Professor","Blogger","Student"};
        // initialize the constain variables
        if (v.validateArguments(args)) {// The input should be only one characters and the type should be Integer
              
            System.out.println("Welcome to CitySim! Your seed is "+args[0]+".");  
            location loc = new location(Integer.parseInt(args[0]));//convert String to Int to regard as seed 
            System.out.println(cs.visit(visitors,locations,loc,visitor,v,cs));// Use the method to iterate all visitors in visitor sequence.
           
        }
        else {
           
            System.out.println("Please enter one integer argument, seed");
        }
    
    }
    
    
    public String visit(String[] visitors,String[] locations,location loc,visitor visitor,Validator v,CitySim9002 cs){
  
        
        String result = "";
        
        //test locations and visitors validation in order to match the setting of location names and visitor names.
        if(v.validateLocation(locations) && v.validateVisitor(visitors)){

            Stack<visitor> vs = visitor.createVisitSequence(visitors,visitor);//generate a sequence which contains 5 visitors.
            int visitCount = 1;
            while(!vs.empty()){
            // For each visitor, generate random number of location to visit, avoid the situation for no visiting any locations
                result+=cs.visitLocations(vs.pop(), locations, loc, visitCount);
                visitCount++;
            }   
        }
        else{
            result = "The input arraies for visitors or locations has wrong spelling name! ";//warning
        }
        
        return result;
        
    }
    
    public String visitLocations(visitor v,String[] locations,location loc,int visitCount){
        
        String result = ("Visitor "+visitCount+" is a "+v.getType()+".\n");
        ArrayList<String> citiesList = loc.randomLocation(locations,loc);//list to contains random number of locations for a certain visitor to visit.
        //System.out.println(citiesList.toArray());
        //System.out.println(citiesList.size());
        if(locations.length>1){
            
            for(int i = 0;i<citiesList.size()-1;i++){//traversing all array to match preferences
                String city = citiesList.get(i);
                result += ("Visitor "+visitCount+" is going to "+city+"!\n");

                if(v.getPreference().get(city)){// need test inputs for Hashmap
                    result += ("Visitor "+visitCount+" did like "+city+".\n");
                }
                else{
                    result += ("Visitor "+visitCount+" did not like "+city+".\n");
                }
            }
            result += ("Visitor "+visitCount+" has left the city.\n***\n");
        }
        else{
            result = ("Cities list is empty!");
        }
        return result;//return result for current visitor.
    }
}
