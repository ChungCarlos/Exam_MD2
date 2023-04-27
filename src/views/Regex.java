package views;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {
    private static final String NAME_REGEX = "^[a-zA-Z\\p{L}' ]{2,}+$";

    private static final String ID_REGEX = "^MS\\d+$";

    public Regex() {
    }
    public boolean validateName(String regex){
        Pattern pattern= Pattern.compile(NAME_REGEX);
        Matcher matcher=pattern.matcher(regex);
        return matcher.matches();
    }public boolean validateId(String regex){
        Pattern pattern= Pattern.compile(ID_REGEX);
        Matcher matcher=pattern.matcher(regex);
        return matcher.matches();
    }
}
