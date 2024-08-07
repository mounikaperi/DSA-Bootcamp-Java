public class IntegerToEnglishWords {
    private static  String[] belowTwenty = {
	      "", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven",
	      "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"
	    };
  	private static final String[] tens = {
  	     "", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"  
  	};
  	public static void main(String[] args) {
  		int num = 1234567;
  		System.out.println("The number is  " + numberToWords(num));
  	}
  	private static String numberToWords(int num) {
  	    StringBuilder s = new StringBuilder();
  	    if (num < 20)
  	        s.append(belowTwenty[num]);
  	    else if (num < 100)
  	        s.append(tens[num / 10]).append(" ").append(belowTwenty[num % 10]);
  	    else if (num < 1000)
  	        s.append(numberToWords(num / 100)).append(" Hundred ").append(numberToWords(num % 100));
  	    else if (num < 1000000)
              s.append(numberToWords(num / 1000)).append(" Thousand ").append(numberToWords(num % 1000));
          else if (num < 1000000000)
              s.append(numberToWords(num / 1000000)).append(" Million ").append(numberToWords(num % 1000000));
          else
              s.append(numberToWords(num / 1000000000)).append(" Billion ").append(numberToWords(num % 1000000000));
  	    return num == 0 ? "Zero" : s.toString().trim();
  	}
}
