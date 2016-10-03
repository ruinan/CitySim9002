/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Program;

import java.util.HashMap;
import java.util.Stack;

/**
 *
 * @author ruinan
 */
public class visitor {
    
    private String type;
    private HashMap<String,Boolean> preference;
    
    
    public visitor(){
    }
    
    public visitor(String t,HashMap<String,Boolean> p){
        this.type = t;
        this.preference = p;
    }

    
    
    public String getType(){
        return this.type;
    }
    
    public HashMap<String,Boolean> getPreference(){
        return this.preference;
    }
    
    
    public Stack<visitor> getAllVisitors(){
        
        HashMap<String, Boolean> hashmapStudent = new HashMap<>();//test all the prefereces must be reached in test
       
        hashmapStudent.put("Squirrel Hill",true);
        hashmapStudent.put("Downtown",true);
        hashmapStudent.put("The Point",true);
        hashmapStudent.put("The Cathedral of Learning",false);  
       // System.out.println("map"+hashmap.get("Downtown"));
        visitor student  = new visitor("student",hashmapStudent);
        
        HashMap<String, Boolean> hashmapBusinessPerson = new HashMap<>();
        hashmapBusinessPerson.put("Squirrel Hill",true);
        hashmapBusinessPerson.put("Downtown",true);
        hashmapBusinessPerson.put("The Point",false);
        hashmapBusinessPerson.put("The Cathedral of Learning",false);
        visitor businessPerson  = new visitor("Business Person",hashmapBusinessPerson);
        
        HashMap<String, Boolean> hashmapProfessor = new HashMap<>();
        hashmapProfessor.put("Squirrel Hill",true);
        hashmapProfessor.put("Downtown",true);
        hashmapProfessor.put("The Point",true);
        hashmapProfessor.put("The Cathedral of Learning",true);
        visitor professor  = new visitor("Professor",hashmapProfessor);
        
        HashMap<String, Boolean> hashmapBlogger = new HashMap<>();
        hashmapBlogger.put("Squirrel Hill",false);
        hashmapBlogger.put("Downtown",false);
        hashmapBlogger.put("The Point",false);
        hashmapBlogger.put("The Cathedral of Learning",false);
        visitor blogger  = new visitor("Blogger",hashmapBlogger);
        
        Stack<visitor> visitors = new Stack<>();
        visitors.add(blogger);
        visitors.add(student);
        visitors.add(businessPerson);
        visitors.add(professor);
        visitors.add(blogger);
        visitors.add(blogger);
        visitors.add(student);
        visitors.add(businessPerson);
        visitors.add(professor);
        visitors.add(blogger);
        //does it require randomly generated?
        
        return visitors;
    }
}
