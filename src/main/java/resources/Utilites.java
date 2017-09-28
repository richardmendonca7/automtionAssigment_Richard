package resources;

import org.apache.commons.lang3.RandomStringUtils;

/***
 * This class will contain methods which will be common throughout the framework
 * @author Richard Mendonca
 *
 */
public class Utilites {

	static char[] alphanumeric = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r',
            's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M',
            'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
            '1','2','3','4','5','6','7','8','9','0',' '};
	
	static char[] alpha = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r',
            's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
	
	public static String getRandomAlphaNumericVal(int namelength) {
		return RandomStringUtils.randomAlphanumeric(namelength);
	}

	public static String getRandomEmailId() {
		String email= RandomStringUtils.random(14,alpha);
		return email+"@gmail.com";
	}

	public static String getRandomString(int length) {
		return RandomStringUtils.random(length,alphanumeric);
	}
}
