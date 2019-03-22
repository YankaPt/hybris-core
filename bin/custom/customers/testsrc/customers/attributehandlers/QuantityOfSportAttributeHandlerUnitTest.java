package customers.attributehandlers;

import customers.model.SportModel;
import de.hybris.bootstrap.annotations.UnitTest;
import de.hybris.platform.core.model.user.CustomerModel;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

@UnitTest
public class QuantityOfSportAttributeHandlerUnitTest {
    @Test
    public void testGetQuantityOfSport() throws Exception {
        final CustomerModel customer = new CustomerModel();
        final QuantityOfSportAttributeHandler handler = new QuantityOfSportAttributeHandler();
        final SportModel sportModel = new SportModel();
        customer.setSports(new ArrayList<>());
        customer.getSports().add(sportModel);
        Assert.assertEquals("Wrong value for concert in the future", 1L, handler.get(customer).longValue());
    }

    @Test
    public void testGetNullSport() {
        final CustomerModel customer = new CustomerModel();
        final QuantityOfSportAttributeHandler handler = new QuantityOfSportAttributeHandler();
        Assert.assertNull(handler.get(customer));
    }
}
