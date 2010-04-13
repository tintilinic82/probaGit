package hr.wds.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidationUtils {

	/**
	 * Metoda validira email adressu
	 * @param email
	 * @return true if match
	 */
	public static boolean isValidEmailAdress(String email) {

		String expression = "^[\\w\\-]([\\.\\w])+[\\w]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
		CharSequence inputEmail = email;
		Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(inputEmail);
		return matcher.matches();

	}
}
