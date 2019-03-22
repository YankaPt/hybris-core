package customers.facades.impl;

import customers.data.CustomerData;
import customers.facades.CustomerFacade;
import customers.model.SportModel;
import de.hybris.platform.core.model.user.CustomerModel;
import de.hybris.platform.servicelayer.ServicelayerTransactionalTest;
import de.hybris.platform.servicelayer.exceptions.UnknownIdentifierException;
import de.hybris.platform.servicelayer.model.ModelService;
import org.junit.Before;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class DefaultCustomerFacadeIntegrationTest extends ServicelayerTransactionalTest {
    private static final String CUSTOMER_UID = "101-JAZ";
    private static final String CUSTOMER_ID = "Tight Notes";
    private static final String SPORT_CODE = "TestSportCode";

    @Resource
    private CustomerFacade customerFacade;
    @Resource
    private ModelService modelService;
    private CustomerModel customerModel;

    @Before
    public void setUp() {
        customerModel = modelService.create(CustomerModel.class);
        customerModel.setUid(CUSTOMER_UID);
        customerModel.setCustomerID(CUSTOMER_ID);
        SportModel sportModel = new SportModel();
        sportModel.setCode(SPORT_CODE);
        ArrayList<SportModel> sportModels = new ArrayList<>();
        sportModels.add(sportModel);
        customerModel.setSports(sportModels);
    }

    @Test(expected = UnknownIdentifierException.class)
    public void testInvalidParameter() {
        customerFacade.getCustomer(CUSTOMER_ID);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNullParameter() {
        customerFacade.getCustomer(null);
    }

    @Test
    public void testCustomerFacade() {
        List<CustomerData> customerListData = customerFacade.getCustomers();

        assertNotNull(customerListData);

        final int size = customerListData.size();
        modelService.save(customerModel);

        customerListData = customerFacade.getCustomers();

        assertNotNull(customerListData);
        assertEquals(size + 1, customerListData.size());
        assertEquals(CUSTOMER_UID, customerListData.get(size).getUid());
        assertEquals(CUSTOMER_ID, customerListData.get(size).getCustomerId());
        assertEquals(1, customerListData.get(size).getSports().size());

        final CustomerData persistedCustomerData = customerFacade.getCustomer(CUSTOMER_UID);

        assertNotNull(persistedCustomerData);
        assertEquals(CUSTOMER_UID, persistedCustomerData.getUid());
        assertEquals(CUSTOMER_ID, persistedCustomerData.getCustomerId());
        assertEquals(1, customerListData.get(size).getSports().size());
    }

}