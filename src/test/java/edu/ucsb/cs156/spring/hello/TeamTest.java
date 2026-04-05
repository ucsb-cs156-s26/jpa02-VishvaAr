package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TeamTest {

    Team team;

    @BeforeEach
    public void setup() {
        team = new Team("test-team");    
    }

    @Test
    public void getName_returns_correct_name() {
       assert(team.getName().equals("test-team"));
    }
    @Test
    public void toString_returns_correct_string() {
        assertEquals("Team(name=test-team, members=[])", team.toString());
    }

    @Test
    public void equals_returns_true_when_same_object() {
        Team t1 = new Team("s26-14");
        assertTrue(t1.equals(t1));
    }

    @Test
    public void equals_returns_false_when_different_class() {
        Team t1 = new Team("s26-14");
        Object dummyObject = new Object();
        assertFalse(t1.equals(dummyObject));
    }

    @Test
    public void equals_returns_true_when_fields_are_same() {
        Team t1 = new Team("s26-14");
        t1.addMember("Vishva");
        
        Team t2 = new Team("s26-14");
        t2.addMember("Vishva");
        
        assertTrue(t1.equals(t2));
    }

    @Test
    public void equals_returns_false_when_names_are_different() {
        Team t1 = new Team("s26-14");
        t1.addMember("Vishva");
        
        Team t2 = new Team("different-team-name");
        t2.addMember("Vishva");
        
        assertFalse(t1.equals(t2));
    }

    @Test
    public void equals_returns_false_when_members_are_different() {
        Team t1 = new Team("s26-14");
        t1.addMember("Vishva");
        
        Team t2 = new Team("s26-14");
        t2.addMember("Someone Else");
        
        assertFalse(t1.equals(t2));
    }
    @Test
    public void hashCode_returns_correct_value() {
        Team t = new Team("s26-14");
        int result = t.hashCode();
        
        int expectedResult = -954785351; 
        
        assertEquals(expectedResult, result);
    }
   
    // TODO: Add additional tests as needed to get to 100% jacoco line coverage, and
    // 100% mutation coverage (all mutants timed out or killed)

}
