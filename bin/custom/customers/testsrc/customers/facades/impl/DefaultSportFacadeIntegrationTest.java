package customers.facades.impl;

import customers.data.SportData;
import customers.facades.SportFacade;
import customers.model.SportModel;
import de.hybris.platform.servicelayer.ServicelayerTransactionalTest;
import de.hybris.platform.servicelayer.exceptions.UnknownIdentifierException;
import de.hybris.platform.servicelayer.model.ModelService;
import org.junit.Before;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.List;

import static org.junit.Assert.*;

public class DefaultSportFacadeIntegrationTest extends ServicelayerTransactionalTest {
    private static final String SPORT_CODE = "101-JAZ";
    private static final String SPORT_NAME = "Tight Notes";

    @Resource
    private SportFacade sportFacade;
    @Resource
    private ModelService modelService;
    private SportModel sportModel;

    @Before
    public void setUp() {
        sportModel = modelService.create(SportModel.class);
        sportModel.setCode(SPORT_CODE);
        sportModel.setName(SPORT_NAME);
        //TODO: add Products
    }

    @Test(expected = UnknownIdentifierException.class)
    public void testInvalidParameter() {
        sportFacade.getSport(SPORT_NAME);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNullParameter() {
        sportFacade.getSport(null);
    }

    @Test
    public void testSportFacade() {
        List<SportData> sportListData = sportFacade.getSports();

        assertNotNull(sportListData);

        final int size = sportListData.size();
        modelService.save(sportModel);

        sportListData = sportFacade.getSports();

        assertNotNull(sportListData);
        assertEquals(size + 1, sportListData.size());
        assertEquals(SPORT_CODE, sportListData.get(size).getId());
        assertEquals(SPORT_NAME, sportListData.get(size).getName());

        final SportData persistedSportData = sportFacade.getSport(SPORT_CODE);

        assertNotNull(persistedSportData);
        assertEquals(SPORT_CODE, persistedSportData.getId());
        assertEquals(SPORT_NAME, persistedSportData.getName());
    }
}