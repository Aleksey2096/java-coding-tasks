/*
 * Validate an IPv4 address
 */
public class IPv4Validator {
	public static boolean isValidIPv4(String ip) {
		if (ip == null || ip.isEmpty()) {
			return false;
		}

		String[] segments = ip.split("\\.");
		if (segments.length != 4) {
			return false;
		}

		for (String segment : segments) {
			if (segment.isEmpty() || segment.length() > 3) {
				return false;
			}
			try {
				int num = Integer.parseInt(segment);
				if (num < 0 || num > 255 || (segment.startsWith("0") && segment.length() > 1)) {
					return false;
				}
			} catch (NumberFormatException e) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		String ip1 = "192.168.1.1";
		String ip2 = "256.100.50.25";

		System.out.println(ip1 + " is valid: " + isValidIPv4(ip1));
		System.out.println(ip2 + " is valid: " + isValidIPv4(ip2));
	}
}
