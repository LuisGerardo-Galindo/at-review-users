package at.review.users.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidationUtils {

	public static boolean isValidString(String string) {
		if (string == null || string.isEmpty())
			return false;
		Pattern patternString = Pattern.compile("^\\s+$");
		Matcher matcherString = patternString.matcher(string);
		return !matcherString.find();
	}

	private ValidationUtils() {
	}
}
