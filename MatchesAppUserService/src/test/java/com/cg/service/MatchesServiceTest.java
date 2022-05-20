package com.cg.service;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import com.cg.model.Matches;
import com.cg.repository.MatchesRepository;


@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class MatchesServiceTest 
{
    @Mock
    private MatchesRepository matchRepo;
    
    @InjectMocks             //used in implementation layer
    private MatchesServiceImpl msl;
    
    
    @Test
    public void testGetAllMatches()
    {
    	 Matches m1=new Matches(11,"India","Srilanka"); // user input
    	 Matches m2=new Matches(12,"Bangladesh","Srilanka"); // user input
    	 Matches m3=new Matches(13,"India","Bangladesh"); // user input
    	
    	 matchRepo.save(m1); //data saved to database
    	 matchRepo.save(m2); //data saved to database
    	 matchRepo.save(m3); //data saved to database
        
        
        List<Matches> mlist=new ArrayList<>(); // crating list object
        mlist.add(m1);
        mlist.add(m2);
        mlist.add(m3);
        
        
        when(matchRepo.findAll()).thenReturn(mlist); // return player list
        List<Matches> mlist1 = msl.getAllMatches();
        assertEquals(mlist, mlist1); //checking both objects are equal
        verify(matchRepo,times(1)).save(m1);
        verify(matchRepo,times(1)).findAll();
        
    
}
}