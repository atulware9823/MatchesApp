package com.cg.repository;
import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.cg.model.Matches;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class MatchesRepositoryTest 
{
    @Autowired
    private MatchesRepository matchRepo;
    
    @Test
    public void givenMatchReturnMatchrObject() 
    {
        Matches m1 = new Matches(10,"India","Srilanka"); //user input
        matchRepo.save(m1); // data saved to database
        
        Matches m2 = matchRepo.findById(m1.getMatchID()).get();//fetching data from database
        assertNotNull(m2); // to check if it is returning  Object
        assertEquals(m1.getTeam1(),m2.getTeam1());
    }
    
    @Test
    public void getAllmustReturnAllMatches()
    {
    	Matches m3 = new Matches(11,"India","Bangladesh"); //user input
    	Matches m4 = new Matches(12,"England","Bangladesh"); //user input
    	matchRepo.save(m3); //data saved to database
    	matchRepo.save(m4); //data saved to database
        
        List<Matches> match1 =(List<Matches>)matchRepo.findAll();
        assertEquals("Bangladesh",match1.get(3).getTeam2());
        
    }
    
    
}
