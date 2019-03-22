package customers.daos.impl;

import customers.daos.CustomerDAO;
import de.hybris.platform.core.model.user.CustomerModel;
import de.hybris.platform.servicelayer.search.FlexibleSearchQuery;
import de.hybris.platform.servicelayer.search.FlexibleSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component(value = "customerDAO")
public class DefaultCustomerDAO implements CustomerDAO {
    @Autowired
    private FlexibleSearchService flexibleSearchService;

    @Override
    public List<CustomerModel> findCustomers() {
        final String queryString = //
                "SELECT {p:" + CustomerModel.PK + "} "//
                        + "FROM {" + CustomerModel._TYPECODE + " AS p} ";
        final FlexibleSearchQuery query = new FlexibleSearchQuery(queryString);
        return flexibleSearchService.<CustomerModel>search(query).getResult();
    }

    @Override
    public List<CustomerModel> findCustomersByUID(String uid) {
        final String queryString = //
                "SELECT {p:" + CustomerModel.PK + "}" //
                        + "FROM {" + CustomerModel._TYPECODE + " AS p} "
                        + "WHERE " + "{p:" + CustomerModel.UID + "}=?uid ";
        final FlexibleSearchQuery query = new FlexibleSearchQuery(queryString);
        query.addQueryParameter("uid", uid);
        return flexibleSearchService.<CustomerModel>search(query).getResult();
    }
}
