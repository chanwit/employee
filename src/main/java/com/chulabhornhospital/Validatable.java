package com.chulabhornhospital;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

public interface Validatable<T> {

    public default Set<ConstraintViolation<T>> validate() {
        Validator v = Validation.buildDefaultValidatorFactory().getValidator();
        Set<ConstraintViolation<T>> result = v.validate((T)this);
        return result;
    }

}