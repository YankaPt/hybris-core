package customers.daos.impl;

import customers.daos.SportDAO;
import customers.model.SportModel;
import de.hybris.platform.servicelayer.search.FlexibleSearchQuery;
import de.hybris.platform.servicelayer.search.FlexibleSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component(value = "sportDAO")
public class DefaultSportDAO implements SportDAO {
    @Autowired
    private FlexibleSearchService flexibleSearchService;

    @Override
    public List<SportModel> findSports() {
        final String queryString = //
                "SELECT {p:" + SportModel.PK + "} "//
                        + "FROM {" + SportModel._TYPECODE + " AS p} ";
        final FlexibleSearchQuery query = new FlexibleSearchQuery(queryString);
        return flexibleSearchService.<SportModel>search(query).getResult();
    }

    @Override
    public List<SportModel> findSportsByCode(String code) {
        final String queryString = //
                "SELECT {p:" + SportModel.PK + "}" //
                        + "FROM {" + SportModel._TYPECODE + " AS p} "//
                        + "WHERE " + "{p:" + SportModel.CODE + "}=?code ";
        final FlexibleSearchQuery query = new FlexibleSearchQuery(queryString);
        query.addQueryParameter("code", code);
        return flexibleSearchService.<SportModel>search(query).getResult();
    }
}
