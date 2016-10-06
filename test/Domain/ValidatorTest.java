/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author AsphaltPanthers
 */
public class ValidatorTest {
    @Test
    public void ifOneArgumentIsProvidedReturnTrue() {
        Assert.assertTrue(new Validator().validateNumberOfArguments(new String[] { "1" }));
    }

    @Test
    public void ifOneArgumentIsNotProvidedReturnFalse() {
        Assert.assertFalse(new Validator().validateNumberOfArguments(new String[] { "1", "2" }));
       
    }

    @Test
    public void ifArgumentIsAnIntegerReturnTrue() {
        Assert.assertTrue(new Validator().validateArgumentType(new String[] { "1" }));
    }
    ///test
    @Test
    public void ifArgumentIsNotAnIntegerReturnFalse() {
        Assert.assertFalse(new Validator().validateArgumentType(new String[] { "test" }));
    }
    
    
    @Test
    public void ifLocationIsNotInArray(){
        Assert.assertFalse(new Validator().validateLocation(new String[] {"test"}) );
    }
    @Test
    public void ifLocationIsInArray(){
        Assert.assertTrue(new Validator().validateLocation(new String[] {"Squirrel Hill","Downtown","The Point","The Cathedral of Learning","leave"}) );
    }
    @Test
    public void ifVisitorArrayIsNotInArray(){
        Assert.assertFalse(new Validator().validateVisitor(new String[] {"test"}));
    }
    @Test
    public void ifVisitoArrayIsInArray(){
        Assert.assertTrue(new Validator().validateVisitor(new String[] {"Student","Business Person","Professor","Blogger","Student"}) );
    }
    
   
}
