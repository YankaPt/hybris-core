package customers.service;

import de.hybris.platform.core.model.user.CustomerModel;

import java.util.List;

public interface CustomerService {
    CustomerModel getCustomerByUID(String id);
    List<CustomerModel> getCustomers();
}
