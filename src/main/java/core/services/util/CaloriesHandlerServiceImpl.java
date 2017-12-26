package core.services.util;

import core.entities.Ingredient;
import core.entities.IngredientEntry;
import core.entities.Recipe;
import core.services.CaloriesHandlerService;
import core.services.HandlerServiceException;
import core.services.IngredientHandlerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;
import java.util.Set;

/**
 * Created by Sergei_Vasilev.
 */
@Transactional
@Repository("caloriesHandlerService")
public class CaloriesHandlerServiceImpl implements CaloriesHandlerService {

  @Autowired
  @Qualifier("ingredientHandlerService")
  private IngredientHandlerService ingredientHandlerService;

  @Override
  public long getCaloriesFromRecipe(Recipe recipe) throws HandlerServiceException {
    long value = 0;
    Set<IngredientEntry> ingredients = recipe.getIngredients();
    for(IngredientEntry ingredientEntry : ingredients){
      long calories = ingredientEntry.getIngredient().getCalories();
        //ingredientHandlerService.getById(ingredientEntry.getIngredient()).getCalories();
      value += calories * ingredientEntry.getAmount();
    }
    return value;
  }
}
