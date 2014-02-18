public class isPalindrome {
  public static boolean isPalindrome(String s){
		
		StringBuffer reverse = new StringBuffer(s);
		reverse.reverse();
		
		if (reverse.toString().equals(s))
			return true;
		else
			return false;
		
	}
	
  public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        String testreg = "[^a-zA-Z0-9]"; 
        java.util.regex.Pattern matchsip = java.util.regex.Pattern.compile(testreg);
        java.util.regex.Matcher mp = matchsip.matcher(s);
        s = mp.replaceAll("");
        StringBuffer sb = new StringBuffer(s);
        return s.equals(sb.reverse().toString());
    }
	
	public static void main(String[] args){
		
		String s = "abcbcba";
		
		System.out.print(isPalindrome(s));
		
	}

}
