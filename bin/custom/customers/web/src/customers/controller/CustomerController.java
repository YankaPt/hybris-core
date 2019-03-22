package customers.controller;

import customers.data.CustomerData;
import customers.facades.CustomerFacade;
import de.hybris.platform.catalog.CatalogVersionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class CustomerController {
    private static final String CATALOG_ID = "sportsProductCatalog";
    private static final String CATALOG_VERSION_NAME = "Online";
    private static final String CUSTOMERS_ATTRIBUTE = "customers";
    private static final String CUSTOMER_LIST_PAGE_ADDRESS = "customerListPage";

    private CustomerFacade customerFacade;
    private CatalogVersionService catalogVersionService;

    @GetMapping(value = "/customerList")
    public String showCustomers(Model model) {
        catalogVersionService.setSessionCatalogVersion(CATALOG_ID, CATALOG_VERSION_NAME);
        List<CustomerData> customerDataList = customerFacade.getCustomers();
        model.addAttribute(CUSTOMERS_ATTRIBUTE, customerDataList);
        return CUSTOMER_LIST_PAGE_ADDRESS;
    }

    @Autowired
    public void setCatalogVersionService(final CatalogVersionService catalogVersionServiceService) {
        this.catalogVersionService = catalogVersionServiceService;
    }

    @Autowired
    public void setCustomerFacade(CustomerFacade customerFacade) {
        this.customerFacade = customerFacade;
    }
}
