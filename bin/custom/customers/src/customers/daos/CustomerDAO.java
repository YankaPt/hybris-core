package customers.daos;

import de.hybris.platform.core.model.user.CustomerModel;

import java.util.List;

public interface CustomerDAO {
    List<CustomerModel> findCustomers();
    List<CustomerModel> findCustomersByUID(String uid);
}
