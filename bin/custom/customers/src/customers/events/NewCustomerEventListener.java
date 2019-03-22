package customers.events;

import de.hybris.platform.core.model.user.CustomerModel;
import de.hybris.platform.servicelayer.event.impl.AbstractEventListener;
import de.hybris.platform.servicelayer.model.ModelService;
import de.hybris.platform.util.Config;
import de.hybris.platform.util.mail.MailUtils;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.log4j.Logger;

public class NewCustomerEventListener extends AbstractEventListener<MyAfterCreationEvent> {
    private static final Logger LOG = Logger.getLogger(NewCustomerEventListener.class);

    private ModelService modelService;

    public ModelService getModelService() {
        return modelService;
    }

    public void setModelService(final ModelService modelService) {
        this.modelService = modelService;
    }

    @Override
    protected void onEvent(final MyAfterCreationEvent event) {
        if (event != null && event.getSource() != null) {
            final CustomerModel customer = (CustomerModel) event.getSource();
            String message = "Customer " + customer.getUid() + " was created!";
            System.out.println(message);
            try {
                LOG.info("Sending mails. Note that org.apache.commons.mail.send() can block if behind a firewall/proxy.");
                sendEmail(message);
            } catch (EmailException exception) {
                LOG.error("Problem sending new email. Note that org.apache.commons.mail.send() can block if behind a firewall/proxy.)");
            }
        }
    }

    private void sendEmail(final String message) throws EmailException {
        final String subject = "New customer was created";
        final Email email = MailUtils.getPreConfiguredEmail();
        email.addTo(Config.getString("news_summary_mailing_address", null));
        email.setSubject(subject);
        email.setMsg(message);
        email.setTLS(true);
        email.send();
        LOG.info(subject);
        LOG.info(message);
    }
}
