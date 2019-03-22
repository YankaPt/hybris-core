package customers.service.impl;

import customers.daos.CustomerDAO;
import customers.service.CustomerService;
import de.hybris.platform.core.model.user.CustomerModel;
import de.hybris.platform.servicelayer.exceptions.AmbiguousIdentifierException;
import de.hybris.platform.servicelayer.exceptions.UnknownIdentifierException;
import org.springframework.beans.factory.annotation.Required;

import java.util.List;

public class DefaultCustomerService implements CustomerService {
    private CustomerDAO customerDAO;

    @Override
    public CustomerModel getCustomerByUID(String uid) {
        final List<CustomerModel> result = customerDAO.findCustomersByUID(uid);
        if (result.isEmpty()) {
            throw new UnknownIdentifierException("Customer with code '" + uid + "' not found!");
        } else if (result.size() > 1) {
            throw new AmbiguousIdentifierException("Customer code '" + uid + "' is not unique, " + result.size() + " customers found!");
        }
        return result.get(0);
    }

    @Override
    public List<CustomerModel> getCustomers() {
        return customerDAO.findCustomers();
    }

    @Required
    public void setCustomerDAO(CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }
}
