package customers.facades.impl;

import customers.data.SportData;
import customers.model.SportModel;
import customers.service.SportService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class DefaultSportFacadeUnitTest {
    private static final String SPORT_CODE = "ROCK-11";
    private static final String SPORT_NAME = "Ladies of Rock";

    private DefaultSportFacade sportFacade;
    private SportService sportService;

    private List<SportModel> dummyDataSportList() {
        final List<SportModel> sports = new ArrayList<SportModel>();
        final SportModel sport = configTestSport();
        sports.add(sport);
        return sports;
    }

    // Convenience method for returning the configured test sport
    private SportModel configTestSport() {
        final SportModel sport = new SportModel();
        sport.setCode(SPORT_CODE);
        sport.setName(SPORT_NAME);
        return sport;
    }

    @Before
    public void setUp() {
        // We will be testing the POJO DefaultSportFacade - the implementation of the SportFacade interface.
        sportFacade = new DefaultSportFacade();
        sportService = mock(SportService.class);
        // We then wire this service into the SportFacade implementation.
        sportFacade.setSportService(sportService);
    }

    /**
     * The aim of this test is to test that:
     * <p>
     * 1) The facade's method getSports makes a call to the SportService's method getSports
     * <p>
     * 2) The facade then correctly wraps SportModels that are returned to it from the SportService's getSports into Data
     * Transfer Objects of type SportData.
     */
    @Test
    public void testGetAllSports() {
        /**
         * We instantiate an object that we would like to be returned to SportFacade when the mocked out SportService's
         * method getSports is called. This will be a list of two SportModels.
         */
        final List<SportModel> sports = dummyDataSportList();
        // create test sport for the assert comparison
        final SportModel sport = configTestSport();
        // We tell Mockito we expect SportService's method getSports to be called, and that when it is, sports should be returned
        when(sportService.getSports()).thenReturn(sports);
        /**
         * We now make the call to SportFacade's getSports. If within this method a call is made to SportService's getSports,
         * Mockito will return the sports instance to it. Mockito will also remember that the call was made.
         */
        final List<SportData> dto = sportFacade.getSports();
        // We now check that dto is a DTO version of sports..
        Assert.assertNotNull(dto);
        Assert.assertEquals(sports.size(), dto.size());
        Assert.assertEquals(sport.getCode(), dto.get(0).getId());
        Assert.assertEquals(sport.getName(), dto.get(0).getName());
    }

    @Test
    public void testGetSport() {
        // create test sport
        final SportModel sport = configTestSport();
        // We tell Mockito we expect SportService's method getSportByCode to be called, and that when it is, the test sport should be returned
        when(sportService.getSportByCode(SPORT_CODE)).thenReturn(sport);
        final SportData dto = sportFacade.getSport(SPORT_CODE);
        // We now check that sport is a correct DTO representation of the test sport model
        Assert.assertNotNull(dto);
        Assert.assertEquals(sport.getCode(), dto.getId());
        Assert.assertEquals(sport.getName(), dto.getName());
    }

}