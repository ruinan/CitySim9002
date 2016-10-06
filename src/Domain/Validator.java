/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

import java.util.HashSet;

/**
 *
 *
 */
public class Validator {
    public boolean validateArguments(String[] args) {
        return validateNumberOfArguments(args) && validateArgumentType(args);
    }

    public boolean validateNumberOfArguments(String[] args) {
        return args.length == 1;
    }

    public boolean validateArgumentType(String[] args) {
        try {
            Integer.parseInt(args[0]);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    public boolean validateVisitor(String[] visitors){
        HashSet<String> vis = new HashSet<>();
        vis.add("Student");
        vis.add("Business Person");
        vis.add("Professor"); 
        vis.add("Blogger");
        if(visitors == null || visitors.length == 0){
            return false;
        }
        else{
            for(String v : visitors){
                if(!vis.contains(v)){
                //if(!v.equals("Student")){ 
                    
                    return false;
                }
            }
            return true;
        }
        
    }
    
     public boolean validateLocation(String[] locations){
        HashSet<String> locs = new HashSet<>();
        locs.add("Squirrel Hill");
        locs.add("Downtown");
        locs.add("The Point"); 
        locs.add("The Cathedral of Learning");
        locs.add("leave");
        if(locations == null || locations.length == 0){
            return false;
        }
        else{
            for(String l : locations){  
                if(!locs.contains(l)){
                 //if(!l.equals("Downtown")){   
                    return false;
                }
            }
            return true;
        }
        
    }

    
}
