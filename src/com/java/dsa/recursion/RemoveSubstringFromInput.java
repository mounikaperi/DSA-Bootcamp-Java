public class RemoveSubstringFromInput {
	public static void main(String[] args) {
		String s = "bcapplebcdrfhaaa";
// 		String s = "bcbcdrfhaaa";
        System.out.println("Input string before requested string removal: " + s);
        System.out.println("Input string after requested string removal: " + removeRequestedSubstring("apple", s));
        System.out.println("Input string after requested string removal: " + removeRequestedSubstringViaRecursion("apple", s));
	}
	private static String removeRequestedSubstring(String requestedSubString, String inputString) {
        if (inputString.isEmpty()) return "";
        if (inputString.length() == 1) return inputString;
        if (inputString.contains(requestedSubString)) {
            int requestedSubStringLength = requestedSubString.length();
            int inputStringLength = inputString.length();
            int requestedSubStringIndexStartsAt = inputString.indexOf(requestedSubString);
            int remainingIndex = (inputString.substring(0, requestedSubStringIndexStartsAt)).length() + requestedSubStringLength;
            return inputString.substring(0, requestedSubStringIndexStartsAt) + inputString.substring(remainingIndex);
        }
        return inputString;
    }
    private static String removeRequestedSubstringViaRecursion(String requestedSubString, String inputString) {
        if (inputString.isEmpty()) return "";
        if (inputString.length() == 1) return inputString;
        if (inputString.contains(requestedSubString)) {
            int requestedSubStringLength = requestedSubString.length();
            int inputStringLength = inputString.length();
            int requestedSubStringIndexStartsAt = inputString.indexOf(requestedSubString);
            int remainingIndex = (inputString.substring(0, requestedSubStringIndexStartsAt)).length() + requestedSubStringLength;
            String s = inputString.substring(0, requestedSubStringIndexStartsAt) + inputString.substring(remainingIndex);
            return removeRequestedSubstringViaRecursion(requestedSubString, s);
        }
        return inputString.charAt(0) + removeRequestedSubstringViaRecursion(requestedSubString, inputString.substring(1));
    }
}
