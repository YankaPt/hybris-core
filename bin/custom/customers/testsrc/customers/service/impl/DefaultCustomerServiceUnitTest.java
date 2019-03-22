package customers.service.impl;

import customers.daos.CustomerDAO;
import de.hybris.platform.core.model.user.CustomerModel;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class DefaultCustomerServiceUnitTest {
    private static final String CUSTOMER_UID = "Ch00X";
    private static final String CUSTOMER_ID = "Singers All";

    private DefaultCustomerService customerService;
    private CustomerDAO customerDAO;
    private CustomerModel customerModel;

    @Before
    public void setUp() {
        customerService = new DefaultCustomerService();
        customerDAO = mock(CustomerDAO.class);
        customerService.setCustomerDAO(customerDAO);
        customerModel = new CustomerModel();
        customerModel.setUid(CUSTOMER_UID);
        customerModel.setCustomerID(CUSTOMER_ID);
    }

    @Test
    public void testGetAllCustomers() {
        final List<CustomerModel> customerModels = Arrays.asList(customerModel);
        when(customerDAO.findCustomers()).thenReturn(customerModels);

        final List<CustomerModel> result = customerService.getCustomers();

        assertEquals("We should find one", 1, result.size());
        assertEquals("And should equals what the mock returned", customerModel, result.get(0));
    }

    @Test
    public void testGetCustomer() {
        when(customerDAO.findCustomersByUID(CUSTOMER_UID)).thenReturn(Collections.singletonList(customerModel));

        final CustomerModel result = customerService.getCustomerByUID(CUSTOMER_UID);

        assertEquals("Customer should equals() what the mock returned", customerModel, result);
    }
}