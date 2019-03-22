package customers.daos.impl;

import customers.daos.SportDAO;
import customers.model.SportModel;
import de.hybris.bootstrap.annotations.IntegrationTest;
import de.hybris.platform.catalog.model.CatalogVersionModel;
import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.servicelayer.ServicelayerTransactionalTest;
import de.hybris.platform.servicelayer.model.ModelService;
import org.junit.Assert;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;

@IntegrationTest
public class DefaultSportDAOIntegrationTest extends ServicelayerTransactionalTest {
    private static final String SPORT_CODE = "S001";
    private static final String SPORT_NAME = "Ladies of Rock";
    private static final String PRODUCT_CODE = "code";

    @Resource
    private SportDAO sportDAO;
    @Resource
    private ModelService modelService;

    @Test
    public void sportDAOTest() {
        List<SportModel> sportsByCode = sportDAO.findSportsByCode(SPORT_CODE);
        assertTrue("No Sport should be returned", sportsByCode.isEmpty());

        List<SportModel> allSports = sportDAO.findSports();
        final int size = allSports.size();
        Set<ProductModel> products = new HashSet<>();
        ProductModel productModel = new ProductModel();
        CatalogVersionModel catalogVersionModel = new CatalogVersionModel();
        productModel.setCatalogVersion(catalogVersionModel);
        productModel.setCode(PRODUCT_CODE);
        products.add(new ProductModel());
        final SportModel sportModel = modelService.create(SportModel.class);
        sportModel.setCode(SPORT_CODE);
        sportModel.setName(SPORT_NAME);
        sportModel.setProducts(products);
        modelService.save(sportModel);

        allSports = sportDAO.findSports();
        Assert.assertEquals(size + 1, allSports.size());
        Assert.assertTrue("sport not found", allSports.contains(sportModel));

        sportsByCode = sportDAO.findSportsByCode(SPORT_CODE);
        Assert.assertEquals("Did not find the Sport we just saved", 1, sportsByCode.size());
        Assert.assertEquals("Retrieved Sport's code attribute incorrect", SPORT_CODE, sportsByCode.get(0).getCode());
        Assert.assertEquals("Retrieved Sport's name attribute incorrect", SPORT_NAME, sportsByCode.get(0).getName());
        Assert.assertEquals("Retrieved Sport's products attribute incorrect", 1, sportsByCode.get(0).getProducts().size());
    }

    @Test
    public void testFindSportsWithEmptyStringParam() {
        final List<SportModel> bands = sportDAO.findSportsByCode("");
        Assert.assertTrue("No Band should be returned", bands.isEmpty());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFindSportsWithNullParam() {
        sportDAO.findSportsByCode(null);
    }

}