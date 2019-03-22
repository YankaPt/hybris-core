package customers.jobs;

import customers.data.CustomerData;
import customers.facades.CustomerFacade;
import de.hybris.platform.cronjob.enums.CronJobResult;
import de.hybris.platform.cronjob.enums.CronJobStatus;
import de.hybris.platform.cronjob.model.CronJobModel;
import de.hybris.platform.servicelayer.cronjob.AbstractJobPerformable;
import de.hybris.platform.servicelayer.cronjob.PerformResult;
import de.hybris.platform.util.Config;
import de.hybris.platform.util.mail.MailUtils;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.log4j.Logger;

import java.util.List;

public class SendQuantityOfSportsJob extends AbstractJobPerformable<CronJobModel> {
    private static final Logger LOG = Logger.getLogger(SendQuantityOfSportsJob.class);

    private CustomerFacade customerFacade;

    public void setCustomerFacade(CustomerFacade customerFacade) {
        this.customerFacade = customerFacade;
    }

    @Override
    public PerformResult perform(final CronJobModel cronJob) {
        LOG.info("Sending customers quantity of sports mails. Note that org.apache.commons.mail.send() can block if behind a firewall/proxy.");
        final List<CustomerData> customerDataList = customerFacade.getCustomers();
        if (customerDataList.isEmpty()) {
            LOG.info("Customers is empty");
            return new PerformResult(CronJobResult.SUCCESS, CronJobStatus.FINISHED);
        }
        final StringBuilder mailContentBuilder = new StringBuilder(100);
        int index = 1;
        mailContentBuilder.append("Todays customers status:\n\n");
        for (final CustomerData customerData : customerDataList) {
            mailContentBuilder.append(index++);
            mailContentBuilder.append(". ");
            mailContentBuilder.append(customerData.getCustomerId());
            mailContentBuilder.append("\n");
            mailContentBuilder.append(customerData.getQuantityOfSport());
            mailContentBuilder.append("\n\n");
        }
        try {
            sendEmail(mailContentBuilder.toString());
        } catch (final EmailException e) {
            LOG.error("Problem sending new email. Note that org.apache.commons.mail.send() can block if behind a firewall/proxy.)");
            return new PerformResult(CronJobResult.FAILURE, CronJobStatus.FINISHED);
        }
        return new PerformResult(CronJobResult.SUCCESS, CronJobStatus.FINISHED);
    }

    private void sendEmail(final String message) throws EmailException {
        final String subject = "Daily Customers Summary";
        // get mail service configuration
        final Email email = MailUtils.getPreConfiguredEmail();
        //send message
        email.addTo(Config.getString("customers_summary_mailing_address", null));
        email.setSubject(subject);
        email.setMsg(message);
        email.setTLS(true);
        email.send();
        LOG.info(subject);
        LOG.info(message);
    }
}
