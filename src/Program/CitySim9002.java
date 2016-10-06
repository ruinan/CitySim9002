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
        CitySim9002 cs = new CitySim9002();
        
        String[] locations = {"Squirrel Hill","Downtown","The Point","The Cathedral of Learning","leave"};
        String[] visitors = {"Student","Business Person","Professor","Blogger","Student"};
        if (v.validateArguments(args)) {// validation
              
            System.out.println("Welcome to CitySim! Your seed is "+args[0]+".");  
            location loc = new location(Integer.parseInt(args[0]));
            System.out.println(cs.visit(visitors,locations,loc));
           
        }
        else {
           
            System.out.println("Please enter one integer argument, seed");
        }
    
    }
    
    
    public String visit(String[] visitors,String[] locations,location loc){
        visitor visitor = new visitor();
        Validator v= new Validator();
        
        String result = "";
        if(v.validateLocation(locations) && v.validateVisitor(visitors)){
            Stack<visitor> vs = visitor.createVisitSequence(visitors);
            int visitCount = 1;
            while(!vs.empty()){
                result+=this.visitLocations(vs.pop(), locations, loc, visitCount);
                visitCount++;
            }
            
        }
        else{
            result = "The input arraies for visitors or locations has wrong spelling name! ";
        }
        
        return result;
        
    }
    
    public String visitLocations(visitor v,String[] locations,location loc,int visitCount){
        String result = ("Visitor "+visitCount+" is a "+v.getType()+".\n");
        ArrayList<String> citiesList = loc.randomLocation(locations, loc.getRandom());
        for(int i = 0;i<citiesList.size()-1;i++){
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
        return result;
    }
}
