package customers.converters;

import customers.data.CustomerData;
import customers.data.ProductData;
import customers.data.SportData;
import customers.model.SportModel;
import de.hybris.platform.core.model.media.MediaContainerModel;
import de.hybris.platform.core.model.media.MediaFormatModel;
import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.core.model.user.CustomerModel;
import de.hybris.platform.servicelayer.media.MediaService;

import java.util.Collection;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class ModelToDTOConverter {
    private MediaService mediaService;

    public SportData convertSportModelToDTO(SportModel sportModel) {
        if (sportModel == null) {
            return null;
        }
        final MediaFormatModel formatModel = mediaService.getFormat("sportDetail");
        final SportData sportData = new SportData();
        sportData.setId(sportModel.getCode());
        sportData.setName(sportModel.getName());
        sportData.setProducts(convertProductModelsToDTOs(sportModel.getProducts()));
        sportData.setImageURL(getImageURL(sportModel, formatModel));
        return sportData;
    }

    public List<SportData> convertSportModelsToDTOs(Collection<SportModel> sportModels) {
        if (sportModels == null) {
            return null;
        }
        return sportModels.stream().map(this::convertSportModelToDTO).collect(Collectors.toList());
    }

    public List<ProductData> convertProductModelsToDTOs(Collection<ProductModel> productModels) {
        if (productModels == null) {
            return null;
        }
        return productModels.stream().map(productModel -> {
            ProductData productData = new ProductData();
            productData.setId(productModel.getCode());
            productData.setName(productModel.getName(Locale.ENGLISH));
            return productData;
        }).collect(Collectors.toList());
    }

    public CustomerData convertCustomerModelToDTO(CustomerModel customerModel) {
        if (customerModel == null) {
            return null;
        }
        final CustomerData customerData = new CustomerData();
        customerData.setUid(customerModel.getUid());
        customerData.setCustomerId(customerModel.getCustomerID());
        customerData.setSports(convertSportModelsToDTOs(customerModel.getSports()));
        customerData.setQuantityOfSport(customerModel.getQuantityOfSport());
        return customerData;
    }

    public void setMediaService(MediaService mediaService) {
        this.mediaService = mediaService;
    }

    private String getImageURL(SportModel sportModel, MediaFormatModel formatModel) {
        final MediaContainerModel containerModel = sportModel.getImage();
        return containerModel != null ? mediaService.getMediaByFormat(containerModel, formatModel).getDownloadURL() : null;
    }
}
