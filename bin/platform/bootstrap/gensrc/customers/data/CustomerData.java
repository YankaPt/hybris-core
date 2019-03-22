/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at Mar 22, 2019 8:07:50 PM
 * ----------------------------------------------------------------
 *
 * [y] hybris Platform
 *
 * Copyright (c) 2018 SAP SE or an SAP affiliate company. All rights reserved.
 *
 * This software is the confidential and proprietary information of SAP
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with SAP.
 */
package customers.data;

import java.io.Serializable;
import customers.data.SportData;
import java.util.List;

/**
 * Customer DTO
 */
public  class CustomerData  implements Serializable 
{

 	/** Default serialVersionUID value. */
 
 	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>CustomerData.uid</code> property defined at extension <code>customers</code>. */
		
	private String uid;

	/** <i>Generated property</i> for <code>CustomerData.customerId</code> property defined at extension <code>customers</code>. */
		
	private String customerId;

	/** <i>Generated property</i> for <code>CustomerData.sports</code> property defined at extension <code>customers</code>. */
		
	private List<SportData> sports;

	/** <i>Generated property</i> for <code>CustomerData.quantityOfSport</code> property defined at extension <code>customers</code>. */
		
	private Long quantityOfSport;
	
	public CustomerData()
	{
		// default constructor
	}
	
		
	
	public void setUid(final String uid)
	{
		this.uid = uid;
	}

		
	
	public String getUid() 
	{
		return uid;
	}
	
		
	
	public void setCustomerId(final String customerId)
	{
		this.customerId = customerId;
	}

		
	
	public String getCustomerId() 
	{
		return customerId;
	}
	
		
	
	public void setSports(final List<SportData> sports)
	{
		this.sports = sports;
	}

		
	
	public List<SportData> getSports() 
	{
		return sports;
	}
	
		
	
	public void setQuantityOfSport(final Long quantityOfSport)
	{
		this.quantityOfSport = quantityOfSport;
	}

		
	
	public Long getQuantityOfSport() 
	{
		return quantityOfSport;
	}
	


}
