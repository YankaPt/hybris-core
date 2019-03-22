package customers.service.impl;

import customers.daos.SportDAO;
import customers.model.SportModel;
import customers.service.SportService;
import de.hybris.platform.servicelayer.exceptions.AmbiguousIdentifierException;
import de.hybris.platform.servicelayer.exceptions.UnknownIdentifierException;
import org.springframework.beans.factory.annotation.Required;

import java.util.List;

public class DefaultSportService implements SportService {
    private SportDAO sportDAO;

    @Override
    public List<SportModel> getSports() {
        return sportDAO.findSports();
    }

    @Override
    public SportModel getSportByCode(String code) throws AmbiguousIdentifierException, UnknownIdentifierException {
        final List<SportModel> result = sportDAO.findSportsByCode(code);
        if (result.isEmpty()) {
            throw new UnknownIdentifierException("Sport with code '" + code + "' not found!");
        } else if (result.size() > 1) {
            throw new AmbiguousIdentifierException("Sport code '" + code + "' is not unique, " + result.size() + " sports found!");
        }
        return result.get(0);
    }

    @Required
    public void setSportDAO(final SportDAO sportDAO) {
        this.sportDAO = sportDAO;
    }
}
