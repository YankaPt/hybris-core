package customers.facades;

import customers.data.CustomerData;

import java.util.List;

public interface CustomerFacade {
    CustomerData getCustomer(String id);
    List<CustomerData> getCustomers();
}
