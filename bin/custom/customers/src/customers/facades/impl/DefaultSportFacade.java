package customers.facades.impl;

import customers.converters.ModelToDTOConverter;
import customers.data.SportData;
import customers.facades.SportFacade;
import customers.model.SportModel;
import customers.service.SportService;

import java.util.List;

public class DefaultSportFacade implements SportFacade {
    private ModelToDTOConverter modelToDTOConverter = new ModelToDTOConverter();
    private SportService sportService;

    @Override
    public SportData getSport(String code) {
        if (code == null) {
            throw new IllegalArgumentException("Sport name cannot be null");
        }
        final SportModel sportModel = sportService.getSportByCode(code);
        return modelToDTOConverter.convertSportModelToDTO(sportModel);
    }

    @Override
    public List<SportData> getSports() {
        final List<SportModel> sportModels = sportService.getSports();
        return modelToDTOConverter.convertSportModelsToDTOs(sportModels);
    }

    public void setSportService(final SportService sportService) {
        this.sportService = sportService;
    }

    public void setModelToDTOConverter(ModelToDTOConverter modelToDTOConverter) {
        this.modelToDTOConverter = modelToDTOConverter;
    }
}
