package ua.kpi.model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Bohdan on 30.03.2017.
 */
public class Validator {
    public static class ValidatorHolder {
        public static final Validator HOLDER_INSTANCE = new Validator();
    }

    public static Validator getInstance() {
        return ValidatorHolder.HOLDER_INSTANCE;
    }

    public boolean isValid(Matcher matcher) {
        return matcher.matches();
    }

    public boolean isValid(String inputValue, String regexp) {
        return Pattern.matches(regexp, inputValue);
    }
}
