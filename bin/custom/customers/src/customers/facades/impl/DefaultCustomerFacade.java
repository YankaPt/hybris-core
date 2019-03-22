package customers.facades.impl;

import customers.converters.ModelToDTOConverter;
import customers.data.CustomerData;
import customers.facades.CustomerFacade;
import customers.service.CustomerService;
import de.hybris.platform.core.model.user.CustomerModel;

import java.util.List;
import java.util.stream.Collectors;

public class DefaultCustomerFacade implements CustomerFacade {
    private ModelToDTOConverter modelToDTOConverter = new ModelToDTOConverter();
    private CustomerService customerService;

    @Override
    public CustomerData getCustomer(String id) {
        if (id == null) {
            throw new IllegalArgumentException("Customer id cannot be null");
        }
        final CustomerModel customerModel = customerService.getCustomerByUID(id);
        return modelToDTOConverter.convertCustomerModelToDTO(customerModel);
    }

    @Override
    public List<CustomerData> getCustomers() {
        final List<CustomerModel> customerModels = customerService.getCustomers();
        return customerModels.stream().map(modelToDTOConverter::convertCustomerModelToDTO).collect(Collectors.toList());
    }

    public void setCustomerService(CustomerService customersService) {
        this.customerService = customersService;
    }

    public void setModelToDTOConverter(ModelToDTOConverter modelToDTOConverter) {
        this.modelToDTOConverter = modelToDTOConverter;
    }
}
