package customers.service.impl;

import customers.model.SportModel;
import customers.service.SportService;
import de.hybris.platform.servicelayer.ServicelayerTest;
import de.hybris.platform.servicelayer.exceptions.UnknownIdentifierException;
import de.hybris.platform.servicelayer.model.ModelService;
import org.junit.Before;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.List;

import static org.junit.Assert.*;

public class DefaultSportServiceIntegrationTest extends ServicelayerTest {
    private static final String SPORT_CODE = "101-JAZ";
    private static final String SPORT_NAME = "Tight Notes";

    @Resource
    private SportService sportService;
    @Resource
    private ModelService modelService;
    private SportModel sportModel;

    @Before
    public void setUp() {
        sportModel = modelService.create(SportModel.class);
        sportModel.setCode(SPORT_CODE);
        sportModel.setName(SPORT_NAME);
    }

    @Test(expected = UnknownIdentifierException.class)
    public void testFailBehavior() {
        sportService.getSportByCode(SPORT_CODE);
    }

    @Test
    public void testSportService() {
        List<SportModel> sportModels = sportService.getSports();
        final int size = sportModels.size();
        if (size >=1) {
            assertEquals(2, sportModels.get(0).getProducts().size());
        }
        modelService.save(sportModel);

        sportModels = sportService.getSports();

        assertEquals(size + 1, sportModels.size());
        assertEquals("Unexpected sport found", sportModel, sportModels.get(sportModels.size() - 1));

        final SportModel persistedSportModel = sportService.getSportByCode(SPORT_CODE);

        assertNotNull("No sport found", persistedSportModel);
        assertEquals("Different sport found", sportModel, persistedSportModel);
    }

    @Test
    public void testSportServiceWithImpex() throws Exception {
        createCoreData();
        importCsv("/impex/customers-sportModels.impex", "utf-8");
        importCsv("/impex/customers-sample.impex", "utf-8");

        final SportModel sport = sportService.getSportByCode("S001");

        assertNotNull("No sport found", sport);
        assertEquals(2, sport.getProducts().size());
    }
}