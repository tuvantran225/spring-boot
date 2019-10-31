package validation.manual;

import org.apache.commons.lang3.StringUtils;

import java.util.Optional;

public class RequiredValidation implements Validation {

    private Object value;

    public RequiredValidation(Object value) {
        this.value = value;
    }

    @Override
    public String validate() {
        return Optional.ofNullable(value)
                .filter(v -> StringUtils.isBlank(v.toString()))
                .map(v -> " is required.")
                .orElse(null);
    }
}
