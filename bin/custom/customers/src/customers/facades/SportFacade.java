package customers.facades;

import customers.data.SportData;

import java.util.List;

public interface SportFacade {
    SportData getSport(String code);
    List<SportData> getSports();
}
