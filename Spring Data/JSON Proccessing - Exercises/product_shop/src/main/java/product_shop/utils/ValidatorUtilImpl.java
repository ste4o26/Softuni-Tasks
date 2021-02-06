package product_shop.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import product_shop.utils.interfaces.ValidatorUtil;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;

@Component
public class ValidatorUtilImpl implements ValidatorUtil {
    private final Validator validator;

    @Autowired
    public ValidatorUtilImpl(Validator validator) {
        this.validator = validator;
    }

    @Override
    public <T> boolean isValid(T entity) {
        return this.validator.validate(entity).isEmpty();
    }

    @Override
    public <T> Set<ConstraintViolation<T>> violations(T entity) {
        return this.validator.validate(entity);
    }
}
