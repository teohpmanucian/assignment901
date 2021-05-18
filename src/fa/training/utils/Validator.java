package fa.training.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {
	private static final String VALID_PHONE = "^(([+]([0-9]{2}))|[0][1-9])[0-9]{8}" ;
	private static final String VALID_ORDER_NUMBER = "\\d{10}";
	public static boolean isPhoneNumber(String phone) {
		Pattern pattern = Pattern.compile(VALID_PHONE);
		Matcher matcher = pattern.matcher(phone);
		return matcher.matches();
	}
	public static boolean isOrderNumber(String orderNumber) {
		Pattern pattern = Pattern.compile(VALID_ORDER_NUMBER);
		Matcher matcher = pattern.matcher(orderNumber);
		return matcher.matches();
	}
}
