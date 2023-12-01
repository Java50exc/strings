package telran.text;

public class JoinStringsOnBuffer implements JoinStrings {

	@Override
	public String join(String[] strings, String delimiter) {
		String res = "";
		if (strings != null && strings.length > 0) {
			StringBuffer builder = new StringBuffer(strings[0]);
			for(int i = 1; i < strings.length; i++) {
				builder.append(delimiter).append(strings[i]);
				
			}
			res = builder.toString();
		}
		return res;
	}

}
