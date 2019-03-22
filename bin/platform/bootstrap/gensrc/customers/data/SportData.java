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
import customers.data.ProductData;
import java.util.List;

/**
 * Sport DTO
 */
public  class SportData  implements Serializable 
{

 	/** Default serialVersionUID value. */
 
 	private static final long serialVersionUID = 1L;

	/** <i>Generated property</i> for <code>SportData.id</code> property defined at extension <code>customers</code>. */
		
	private String id;

	/** <i>Generated property</i> for <code>SportData.name</code> property defined at extension <code>customers</code>. */
		
	private String name;

	/** <i>Generated property</i> for <code>SportData.products</code> property defined at extension <code>customers</code>. */
		
	private List<ProductData> products;

	/** <i>Generated property</i> for <code>SportData.imageURL</code> property defined at extension <code>customers</code>. */
		
	private String imageURL;
	
	public SportData()
	{
		// default constructor
	}
	
		
	
	public void setId(final String id)
	{
		this.id = id;
	}

		
	
	public String getId() 
	{
		return id;
	}
	
		
	
	public void setName(final String name)
	{
		this.name = name;
	}

		
	
	public String getName() 
	{
		return name;
	}
	
		
	
	public void setProducts(final List<ProductData> products)
	{
		this.products = products;
	}

		
	
	public List<ProductData> getProducts() 
	{
		return products;
	}
	
		
	
	public void setImageURL(final String imageURL)
	{
		this.imageURL = imageURL;
	}

		
	
	public String getImageURL() 
	{
		return imageURL;
	}
	


}
