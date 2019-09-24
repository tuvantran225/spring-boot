package validation;

import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.Optional;

public class Validator {

    public boolean isRequiredName(String fieldName) {
        return StringUtils.isEmpty(fieldName);
    }

    public boolean isRequiredCode(Integer fieldCode) {
        return !Optional.ofNullable(fieldCode).isPresent();
    }

    public boolean isExceedLength(String fieldName, int fieldLength) {
        return !isRequiredName(fieldName) && fieldName.length() > fieldLength;
    }

    public boolean isDuplicatedName(String fieldName, List<String> values) {
        return !isRequiredName(fieldName) &&
                Optional.ofNullable(values)
                .get()
                .stream()
                .filter(v -> v.equals(fieldName))
                .map(v -> true).findFirst().orElse(false);
    }

    public boolean isDuplicatedCode(Integer fieldName, List<Integer> values) {
        return !isRequiredCode(fieldName) &&
                Optional.ofNullable(values)
                        .get()
                        .stream()
                        .filter(v -> v == fieldName)
                        .map(v -> true).findFirst().orElse(false);
    }

}
