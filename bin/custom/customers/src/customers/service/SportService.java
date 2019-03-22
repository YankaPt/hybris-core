package customers.service;

import customers.model.SportModel;

import java.util.List;

public interface SportService {
        List<SportModel> getSports();
        SportModel getSportByCode(String code);
}
