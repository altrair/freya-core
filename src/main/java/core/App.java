package core;

/**
 * Created by Altair on 21.09.2017.
 */
public class App {

    public static void main(String[] args) {
        useJavaConfiguration();
    }

    private static void useJavaConfiguration() {
        //TODO
        /*AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(FreyaConfiguration.class);
        RecipesHandlerService recipesHandlerService = (RecipesHandlerService) context.getBean("recipeHandlerService");
        try {
            Collection<Recipe> recipes = recipesHandlerService.getAll();
            recipes.forEach(System.out::println);
        } catch (HandlerServiceException e) {
            e.printStackTrace(System.err);
        }*/
    }
}
