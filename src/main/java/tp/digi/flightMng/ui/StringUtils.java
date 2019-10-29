package tp.digi.flightMng.ui;

public class StringUtils {
	
	public static String normalizeLength(Object s) {
		int length = 20;
		StringBuilder sb = new StringBuilder();
		if (s.toString().length() > length) {
			return s.toString();
		} else {
			for(int i=0; i<(length-s.toString().length())/2; i++) sb.append(" ");
			sb.append(s);
			for(int i=0; i<(length-s.toString().length())/2; i++) sb.append(" ");
			return sb.toString();
		}
	}

}
