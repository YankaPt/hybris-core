/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN! ---
 * --- Generated at Mar 22, 2019 8:07:49 PM                     ---
 * ----------------------------------------------------------------
 */
package customers.model;

import de.hybris.bootstrap.annotations.Accessor;
import de.hybris.platform.core.model.ItemModel;
import de.hybris.platform.core.model.media.MediaContainerModel;
import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.core.model.user.CustomerModel;
import de.hybris.platform.servicelayer.model.ItemModelContext;
import java.util.Collection;
import java.util.Locale;

/**
 * Generated model class for type Sport first defined at extension customers.
 */
@SuppressWarnings("all")
public class SportModel extends ItemModel
{
	/**<i>Generated model type code constant.</i>*/
	public static final String _TYPECODE = "Sport";
	
	/**<i>Generated relation code constant for relation <code>Product2Sport</code> defining source attribute <code>products</code> in extension <code>customers</code>.</i>*/
	public static final String _PRODUCT2SPORT = "Product2Sport";
	
	/** <i>Generated constant</i> - Attribute key of <code>Sport.code</code> attribute defined at extension <code>customers</code>. */
	public static final String CODE = "code";
	
	/** <i>Generated constant</i> - Attribute key of <code>Sport.name</code> attribute defined at extension <code>customers</code>. */
	public static final String NAME = "name";
	
	/** <i>Generated constant</i> - Attribute key of <code>Sport.image</code> attribute defined at extension <code>customers</code>. */
	public static final String IMAGE = "image";
	
	/** <i>Generated constant</i> - Attribute key of <code>Sport.products</code> attribute defined at extension <code>customers</code>. */
	public static final String PRODUCTS = "products";
	
	/** <i>Generated constant</i> - Attribute key of <code>Sport.customer</code> attribute defined at extension <code>customers</code>. */
	public static final String CUSTOMER = "customer";
	
	
	/**
	 * <i>Generated constructor</i> - Default constructor for generic creation.
	 */
	public SportModel()
	{
		super();
	}
	
	/**
	 * <i>Generated constructor</i> - Default constructor for creation with existing context
	 * @param ctx the model context to be injected, must not be null
	 */
	public SportModel(final ItemModelContext ctx)
	{
		super(ctx);
	}
	
	/**
	 * <i>Generated constructor</i> - for all mandatory and initial attributes.
	 * @deprecated since 4.1.1 Please use the default constructor without parameters
	 * @param _owner initial attribute declared by type <code>Item</code> at extension <code>core</code>
	 */
	@Deprecated
	public SportModel(final ItemModel _owner)
	{
		super();
		setOwner(_owner);
	}
	
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Sport.code</code> attribute defined at extension <code>customers</code>. 
	 * @return the code - short unique code of sport model
	 */
	@Accessor(qualifier = "code", type = Accessor.Type.GETTER)
	public String getCode()
	{
		return getPersistenceContext().getPropertyValue(CODE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Sport.customer</code> attribute defined at extension <code>customers</code>. 
	 * Consider using FlexibleSearchService::searchRelation for pagination support of large result sets.
	 * @return the customer
	 */
	@Accessor(qualifier = "customer", type = Accessor.Type.GETTER)
	public Collection<CustomerModel> getCustomer()
	{
		return getPersistenceContext().getPropertyValue(CUSTOMER);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Sport.image</code> attribute defined at extension <code>customers</code>. 
	 * @return the image - picture of sport in different formats
	 */
	@Accessor(qualifier = "image", type = Accessor.Type.GETTER)
	public MediaContainerModel getImage()
	{
		return getPersistenceContext().getPropertyValue(IMAGE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Sport.name</code> attribute defined at extension <code>customers</code>. 
	 * @return the name - name of sport model
	 */
	@Accessor(qualifier = "name", type = Accessor.Type.GETTER)
	public String getName()
	{
		return getName(null);
	}
	/**
	 * <i>Generated method</i> - Getter of the <code>Sport.name</code> attribute defined at extension <code>customers</code>. 
	 * @param loc the value localization key 
	 * @return the name - name of sport model
	 * @throws IllegalArgumentException if localization key cannot be mapped to data language
	 */
	@Accessor(qualifier = "name", type = Accessor.Type.GETTER)
	public String getName(final Locale loc)
	{
		return getPersistenceContext().getLocalizedValue(NAME, loc);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>Sport.products</code> attribute defined at extension <code>customers</code>. 
	 * Consider using FlexibleSearchService::searchRelation for pagination support of large result sets.
	 * @return the products
	 */
	@Accessor(qualifier = "products", type = Accessor.Type.GETTER)
	public Collection<ProductModel> getProducts()
	{
		return getPersistenceContext().getPropertyValue(PRODUCTS);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>Sport.code</code> attribute defined at extension <code>customers</code>. 
	 *  
	 * @param value the code - short unique code of sport model
	 */
	@Accessor(qualifier = "code", type = Accessor.Type.SETTER)
	public void setCode(final String value)
	{
		getPersistenceContext().setPropertyValue(CODE, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>Sport.customer</code> attribute defined at extension <code>customers</code>. 
	 *  
	 * @param value the customer
	 */
	@Accessor(qualifier = "customer", type = Accessor.Type.SETTER)
	public void setCustomer(final Collection<CustomerModel> value)
	{
		getPersistenceContext().setPropertyValue(CUSTOMER, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>Sport.image</code> attribute defined at extension <code>customers</code>. 
	 *  
	 * @param value the image - picture of sport in different formats
	 */
	@Accessor(qualifier = "image", type = Accessor.Type.SETTER)
	public void setImage(final MediaContainerModel value)
	{
		getPersistenceContext().setPropertyValue(IMAGE, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>Sport.name</code> attribute defined at extension <code>customers</code>. 
	 *  
	 * @param value the name - name of sport model
	 */
	@Accessor(qualifier = "name", type = Accessor.Type.SETTER)
	public void setName(final String value)
	{
		setName(value,null);
	}
	/**
	 * <i>Generated method</i> - Setter of <code>Sport.name</code> attribute defined at extension <code>customers</code>. 
	 *  
	 * @param value the name - name of sport model
	 * @param loc the value localization key 
	 * @throws IllegalArgumentException if localization key cannot be mapped to data language
	 */
	@Accessor(qualifier = "name", type = Accessor.Type.SETTER)
	public void setName(final String value, final Locale loc)
	{
		getPersistenceContext().setLocalizedValue(NAME, loc, value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of <code>Sport.products</code> attribute defined at extension <code>customers</code>. 
	 *  
	 * @param value the products
	 */
	@Accessor(qualifier = "products", type = Accessor.Type.SETTER)
	public void setProducts(final Collection<ProductModel> value)
	{
		getPersistenceContext().setPropertyValue(PRODUCTS, value);
	}
	
}
