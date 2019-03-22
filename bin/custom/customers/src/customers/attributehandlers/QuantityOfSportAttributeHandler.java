package customers.attributehandlers;

import de.hybris.platform.core.model.user.CustomerModel;
import de.hybris.platform.servicelayer.model.attribute.AbstractDynamicAttributeHandler;
import org.springframework.stereotype.Component;

@Component
public class QuantityOfSportAttributeHandler extends AbstractDynamicAttributeHandler<Long, CustomerModel> {
    @Override
    public Long get(final CustomerModel model) {
        if (model.getSports() == null) {
            return null;
        }
        return (long) model.getSports().size();
    }
}