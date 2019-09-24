import validation.Validator;

import java.util.ArrayList;

public class Application {

    public static void main(String[] args) {
        Validator validator = new Validator();
        String fieldName = "Frank";
        ArrayList<String> values = new ArrayList<>();
        values.add("Jeff");
        values.add("Patrik");
        values.add("Simon");
        System.out.println(validator.isDuplicatedName(fieldName, values));
    }

}
