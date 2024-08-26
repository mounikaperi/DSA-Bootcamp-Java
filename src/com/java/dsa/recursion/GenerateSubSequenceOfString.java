import java.util.ArrayList;
public class GenerateSubSequenceOfString {
	public static void main(String[] args) {
	    String s = "abc";
		System.out.println("The list of sequences are: " + generateSubSequence("", s));
	}
	private static ArrayList<String> generateSubSequence(String p, String inputString) {
	    if (inputString.isEmpty()) {
	        ArrayList<String> list = new ArrayList<>();
	        list.add(p);
	        return list;
	    }
	    char ch = inputString.charAt(0);
	    ArrayList<String> left = generateSubSequence(p+ch, inputString.substring(1));
	    ArrayList<String> right = generateSubSequence(p, inputString.substring(1));
	    left.addAll(right);
	    return left;
	}   
}
