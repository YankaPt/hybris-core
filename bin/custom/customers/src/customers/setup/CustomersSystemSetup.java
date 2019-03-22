/*
 * [y] hybris Platform
 *
 * Copyright (c) 2018 SAP SE or an SAP affiliate company. All rights reserved.
 *
 * This software is the confidential and proprietary information of SAP
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with SAP.
 */
package customers.setup;

import static customers.constants.CustomersConstants.PLATFORM_LOGO_CODE;

import de.hybris.platform.core.initialization.SystemSetup;

import java.io.InputStream;

import customers.constants.CustomersConstants;
import customers.service.CustomersService;


@SystemSetup(extension = CustomersConstants.EXTENSIONNAME)
public class CustomersSystemSetup {
    private final CustomersService customersService;

    public CustomersSystemSetup(final CustomersService customersService) {
        this.customersService = customersService;
    }

    @SystemSetup(process = SystemSetup.Process.INIT, type = SystemSetup.Type.ESSENTIAL)
    public void createEssentialData() {
        customersService.createLogo(PLATFORM_LOGO_CODE);
    }

    private InputStream getImageStream() {
        return CustomersSystemSetup.class.getResourceAsStream("/customers/sap-hybris-platform.png");
    }
}
