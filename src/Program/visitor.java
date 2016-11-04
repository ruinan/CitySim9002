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
    public void setType(String t){
        this.type = t;
    }
    public void setPreference(HashMap<String,Boolean> p){
        this.preference = p;
    }
    
    
    public String getType(){
        return this.type;
    }
    
    public HashMap<String,Boolean> getPreference(){
        return this.preference;
    }
    
    // A stack be used to store the visitors. 
    public Stack<visitor> createVisitSequence(String[] vis,visitor vv){//test
        Stack<visitor> visitors = new Stack<>();
        // = {"Student","Business Person","Professor","Blogger","Student"};
        if(vis != null && vis.length != 0){ 
            for(String v:vis){
                visitor temp = vv.generateVisitor(v);//Following the input array to generate the visitors set.
                System.out.println(temp);
                if(temp!= null){
                    visitors.add(temp); 
                }
                else{
                    System.err.println(v+" does not been added into visitor sequence");
                }
            }
            return visitors;
        }
        else{
            return null;
        }
        
    }
    //generate a visitor map based on hashmap
    public visitor generateVisitor(String type){ 
        switch(type){
            case "Student":
                HashMap<String, Boolean> hashmapStudent = new HashMap<>();//test all the prefereces must be reached in test
                hashmapStudent.put("Squirrel Hill",true);
                hashmapStudent.put("Downtown",true);
                hashmapStudent.put("The Point",true);
                hashmapStudent.put("The Cathedral of Learning",false);  
               // System.out.println("map"+hashmap.get("Downtown"));
                visitor student = new visitor(type,hashmapStudent);
                return student;
            case "Business Person":
                HashMap<String, Boolean> hashmapBusinessPerson = new HashMap<>();
                hashmapBusinessPerson.put("Squirrel Hill",true);
                hashmapBusinessPerson.put("Downtown",true);
                hashmapBusinessPerson.put("The Point",false);
                hashmapBusinessPerson.put("The Cathedral of Learning",false);
                visitor businessPerson  = new visitor("Business Person",hashmapBusinessPerson);
                return businessPerson;
            case "Professor":
                HashMap<String, Boolean> hashmapProfessor = new HashMap<>();
                hashmapProfessor.put("Squirrel Hill",true);
                hashmapProfessor.put("Downtown",true);
                hashmapProfessor.put("The Point",true);
                hashmapProfessor.put("The Cathedral of Learning",true);
                visitor professor  = new visitor("Professor",hashmapProfessor);
                return professor;
            case "Blogger":
                HashMap<String, Boolean> hashmapBlogger = new HashMap<>();
                hashmapBlogger.put("Squirrel Hill",false);
                hashmapBlogger.put("Downtown",false);
                hashmapBlogger.put("The Point",false);
                hashmapBlogger.put("The Cathedral of Learning",false);
                visitor blogger  = new visitor("Blogger",hashmapBlogger);
                return blogger;
            default:
                return null;
        }    
       
    }
    
}
