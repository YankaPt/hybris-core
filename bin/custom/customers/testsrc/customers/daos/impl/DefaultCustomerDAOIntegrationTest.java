package customers.daos.impl;

import customers.daos.CustomerDAO;
import de.hybris.bootstrap.annotations.IntegrationTest;
import de.hybris.platform.core.model.user.CustomerModel;
import de.hybris.platform.servicelayer.ServicelayerTransactionalTest;
import de.hybris.platform.servicelayer.model.ModelService;
import org.junit.Assert;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.List;

import static org.junit.Assert.*;

@IntegrationTest
public class DefaultCustomerDAOIntegrationTest extends ServicelayerTransactionalTest {
    private static final String CUSTOMER_UID = "S001";
    private static final String CUSTOMER_ID = "Ladies of Rock";

    @Resource
    private CustomerDAO customerDAO;
    @Resource
    private ModelService modelService;

    @Test
    public void customerDAOTest() {
        List<CustomerModel> customersByUID = customerDAO.findCustomersByUID(CUSTOMER_UID);
        assertTrue("No Customer should be returned", customersByUID.isEmpty());

        List<CustomerModel> allCustomers = customerDAO.findCustomers();
        final int size = allCustomers.size();
        final CustomerModel customerModel = modelService.create(CustomerModel.class);
        customerModel.setUid(CUSTOMER_UID);
        customerModel.setCustomerID(CUSTOMER_ID);
        modelService.save(customerModel);

        allCustomers = customerDAO.findCustomers();
        Assert.assertEquals(size + 1, allCustomers.size());
        Assert.assertTrue("customer not found", allCustomers.contains(customerModel));

        customersByUID = customerDAO.findCustomersByUID(CUSTOMER_UID);
        Assert.assertEquals("Did not find the Customer we just saved", 1, customersByUID.size());
        Assert.assertEquals("Retrieved Customer's uid attribute incorrect", CUSTOMER_UID, customersByUID.get(0).getUid());
        Assert.assertEquals("Retrieved Customer's id attribute incorrect", CUSTOMER_ID, customersByUID.get(0).getCustomerID());
    }

    @Test
    public void testFindCustomersWithEmptyStringParam() {
        final List<CustomerModel> customerModels = customerDAO.findCustomersByUID("");
        Assert.assertTrue("No Band should be returned", customerModels.isEmpty());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFindCustomersWithNullParam() {
        customerDAO.findCustomersByUID(null);
    }

}