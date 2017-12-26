package core.web.controllers;

import com.sun.org.apache.regexp.internal.RE;
import core.entities.Dimension;
import core.entities.Place;
import core.entities.Recipe;
import core.services.DimensionHandlerService;
import core.services.HandlerServiceException;
import core.services.PlacesHandlerService;
import core.services.RecipesHandlerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Sergei_Vasilev.
 */
@Controller
public class MainController {

    @Autowired
    @Qualifier("dimensionHandlerService")
    private DimensionHandlerService dimensionHandlerService;

    @Autowired
    @Qualifier("recipesHandlerService")
    private RecipesHandlerService recipesHandlerService;

    @Autowired
    @Qualifier("placesHandlerService")
    private PlacesHandlerService placesHandlerService;

    @RequestMapping("/")
    public String home() {
        return "redirect:/index";
    }

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView();
        try {
            Place place = placesHandlerService.getById(1L);
            modelAndView.addObject("place", place);
        } catch (HandlerServiceException e) {
            e.printStackTrace(System.err);
        }
        modelAndView.setViewName("index");
        return modelAndView;
    }
}