package customers.controller;

import customers.data.SportData;
import customers.facades.SportFacade;
import de.hybris.platform.catalog.CatalogVersionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;

@Controller
public class SportController {
    private static final String CATALOG_ID = "sportsProductCatalog";
    private static final String CATALOG_VERSION_NAME = "Online";

    private CatalogVersionService catalogVersionService;
    private SportFacade sportFacade;

    @GetMapping(value = "/sports")
    public String showSports(Model model) {
        catalogVersionService.setSessionCatalogVersion(CATALOG_ID, CATALOG_VERSION_NAME);
        List<SportData> sportDataList = sportFacade.getSports();
        model.addAttribute("sports", sportDataList);
        return "sports";
    }

    @GetMapping(value = "/sports/{sportCode}")
    public String showSportDetails(@PathVariable String sportCode, Model model) throws UnsupportedEncodingException {
        catalogVersionService.setSessionCatalogVersion(CATALOG_ID, CATALOG_VERSION_NAME);
        final String decodedSportCode = URLDecoder.decode(sportCode, "UTF-8");
        SportData sportData = sportFacade.getSport(decodedSportCode);
        model.addAttribute("sport", sportData);
        return "sport";
    }

    @Autowired
    public void setCatalogVersionService(final CatalogVersionService catalogVersionServiceService) {
        this.catalogVersionService = catalogVersionServiceService;
    }

    @Autowired
    public void setSportFacade(SportFacade sportFacade) {
        this.sportFacade = sportFacade;
    }
}
