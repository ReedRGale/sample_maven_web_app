/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objects;

import java.util.LinkedList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * JUnit Test Example
 * 
 * @author wlloyd
 */
public class UserTest {
    
    public UserTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getName method, of class User.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        User instance = new User();
        String expResult = null;
        String result = instance.getName();
        assertEquals(expResult, result);
    }

    /**
     * Test of setName method, of class User.
     */
    @Test
    public void testSetName() {
        System.out.println("setName");
        String name = "Fred";
        User instance = new User();
        instance.setName(name);
        String result = instance.getName();
        assertEquals(name, result);
    }

    /**
     * Test of getAge method, of class User.
     */
    @Test
    public void testGetAge() {
        System.out.println("getAge");
        User instance = new User();
        int expResult = 0;
        int result = instance.getAge();
        assertEquals(expResult, result);
    }

    /**
     * Test of setAge method, of class User.
     */
    @Test
    public void testSetAge() {
        System.out.println("setAge");
        int age = 35;
        User instance = new User();
        instance.setAge(age);
        int result = instance.getAge();
        assertEquals(age, result);
    }

    /**
     * Test of getMessages method, of class User.
     */
    @Test
    public void testGetMessages() {
        System.out.println("getMessages");
        User instance = new User();
        List<String> expResult = null;
        List<String> result = instance.getMessages();
        assertEquals(expResult, result);
    }

    /**
     * Test of setMessages method, of class User.
     */
    @Test
    public void testSetMessages() {
        System.out.println("setMessages");
        List<String> messages = new LinkedList<String>();
        messages.add("Hello Fred");
        messages.add("What time is it?");
        User instance = new User();
        instance.setMessages(messages);
        List<String> result = instance.getMessages();
        assertEquals(messages.size(), result.size());
        assertEquals(messages.get(0), result.get(0));
        assertEquals(messages.get(1), result.get(1));
    }

    /**
     * Test of getuserid method, of class User.
     */
    @Test
    public void testGetuserid() {
        System.out.println("getUserId");
        User instance = new User();
        int expResult = 0;
        int result = instance.getUserId();
        assertEquals(expResult, result);
    }

    /**
     * Test of setuserid method, of class User.
     */
    @Test
    public void testSetuserid() {
        System.out.println("setUserId");
        int userid = 10;
        User instance = new User();
        instance.setUserId(userid);
        int result = instance.getUserId();
        assertEquals(userid, result);  
    }
    
}
