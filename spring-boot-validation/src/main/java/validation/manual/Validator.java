package validation.manual;

import field.Field;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Validator {

    private Map<Field, List<Validation>> validationMap = new HashMap<>();

    public void putValidation(Field field, List<Validation> validations) {
        validationMap.put(field, validations);
    }

    public Map<Field, List<Validation>> getValidation() {
        return validationMap;
    }

}
