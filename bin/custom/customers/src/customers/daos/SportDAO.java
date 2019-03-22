package customers.daos;

import customers.model.SportModel;

import java.util.List;

public interface SportDAO {
    List<SportModel> findSports();
    List<SportModel> findSportsByCode(String code);

}
