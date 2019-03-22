package customers.interceptors;

import customers.events.MyAfterCreationEvent;
import de.hybris.platform.core.model.user.CustomerModel;
import de.hybris.platform.servicelayer.event.EventService;
import de.hybris.platform.servicelayer.interceptor.InterceptorContext;
import de.hybris.platform.servicelayer.interceptor.InterceptorException;
import de.hybris.platform.servicelayer.interceptor.PrepareInterceptor;
import org.springframework.beans.factory.annotation.Autowired;

public class NewCustomerInterceptor implements PrepareInterceptor<CustomerModel> {
    @Autowired
    private EventService eventService;

    @Override
    public void onPrepare(CustomerModel customerModel, InterceptorContext interceptorContext) throws InterceptorException {
        if (interceptorContext.isNew(customerModel)) {
            MyAfterCreationEvent myAfterCreationEvent = new MyAfterCreationEvent(customerModel);
            eventService.publishEvent(myAfterCreationEvent);
        }
    }
}
