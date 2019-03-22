package customers.service.impl;

import customers.daos.SportDAO;
import customers.model.SportModel;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class DefaultSportServiceUnitTest {
    private static final String SPORT_CODE = "Ch00X";
    private static final String SPORT_NAME = "Singers All";

    private DefaultSportService sportService;
    private SportDAO sportDAO;
    private SportModel sportModel;

    @Before
    public void setUp() {
        sportService = new DefaultSportService();
        sportDAO = mock(SportDAO.class);
        sportService.setSportDAO(sportDAO);
        sportModel = new SportModel();
        sportModel.setCode(SPORT_CODE);
        sportModel.setName(SPORT_NAME);
    }

    @Test
    public void testGetAllSports() {
        final List<SportModel> sportModels = Arrays.asList(sportModel);
        when(sportDAO.findSports()).thenReturn(sportModels);

        final List<SportModel> result = sportService.getSports();

        assertEquals("We should find one", 1, result.size());
        assertEquals("And should equals what the mock returned", sportModel, result.get(0));
    }

    @Test
    public void testGetSport() {
        when(sportDAO.findSportsByCode(SPORT_CODE)).thenReturn(Collections.singletonList(sportModel));

        final SportModel result = sportService.getSportByCode(SPORT_CODE);

        assertEquals("Sport should equals() what the mock returned", sportModel, result);
    }
}