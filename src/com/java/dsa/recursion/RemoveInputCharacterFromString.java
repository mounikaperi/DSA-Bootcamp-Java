class RemoveInputCharacterFromString {
    public static void main(String[] args) {
        String s = "bcaaadrfhaaa";
        System.out.println("String before character removal: " + s);
        System.out.println("String after character removal: " + removeCharacter('a', s));
    }
    private static String removeCharacter(char character, String input) {
        if (input.isEmpty()) {
            return "";
        }
        char ch = input.charAt(0);
        if (ch == character) {
            return removeCharacter(character, input.substring(1));
        } 
        return ch + removeCharacter(character, input.substring(1));
    }
}
