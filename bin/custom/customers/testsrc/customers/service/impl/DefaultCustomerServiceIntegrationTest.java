package customers.service.impl;

import customers.service.CustomerService;
import de.hybris.platform.core.model.user.CustomerModel;
import de.hybris.platform.servicelayer.ServicelayerTest;
import de.hybris.platform.servicelayer.exceptions.UnknownIdentifierException;
import de.hybris.platform.servicelayer.model.ModelService;
import org.junit.Before;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.List;

import static org.junit.Assert.*;

public class DefaultCustomerServiceIntegrationTest extends ServicelayerTest {
    private static final String CUSTOMER_UID = "101-JAZ";
    private static final String CUSTOMER_ID = "Tight Notes";

    @Resource
    private CustomerService customerService;
    @Resource
    private ModelService modelService;
    private CustomerModel customerModel;

    @Before
    public void setUp() {
        customerModel = modelService.create(CustomerModel.class);
        customerModel.setUid(CUSTOMER_UID);
        customerModel.setCustomerID(CUSTOMER_ID);
    }

    @Test(expected = UnknownIdentifierException.class)
    public void testFailBehavior() {
        customerService.getCustomerByUID(CUSTOMER_UID);
    }

    @Test
    public void testCustomerService() {
        List<CustomerModel> customerModels = customerService.getCustomers();
        final int size = customerModels.size();
        modelService.save(customerModel);

        customerModels = customerService.getCustomers();

        assertEquals(size + 1, customerModels.size());
        assertEquals("Unexpected customer found", customerModel, customerModels.get(customerModels.size() - 1));

        final CustomerModel persistedCustomerModel = customerService.getCustomerByUID(CUSTOMER_UID);

        assertNotNull("No customer found", persistedCustomerModel);
        assertEquals("Different customer found", customerModel, persistedCustomerModel);
    }

    @Test
    public void testCustomerServiceWithImpex() throws Exception {
        createCoreData();
        importCsv("/impex/customers-sportModels.impex", "utf-8");
        importCsv("/impex/customers-sample.impex", "utf-8");

        final CustomerModel customer = customerService.getCustomerByUID("C001");

        assertNotNull("No customer found", customer);
        assertEquals(2, customer.getSports().size());
    }

}