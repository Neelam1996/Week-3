package Week_3;

import java.util.*;


/*1.	PROBLEM STATEMENT:
 * Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine if s can be segmented into a space-separated sequence of one or more dictionary words. You may assume the dictionary does not contain duplicate words.
  2.    EXAMPLE :
  Consider the dictionary
  { pear, salmon, foot, prints, footprints, leave, you, sun, girl, enjoy },
	INPUTS								OUTPUT					EXPLANATION
	youenjoy							true				can be segmented as "you enjoy"
	youleavefootprints					true				can be segmented as "you leave footprints" or "you leave foot prints"
	salmonenjoyapples					false				cannot be segmented 
3. OPTIMIZATION
	Using dynamic programming

*/
public class Word_Break {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		List<String> wordDict= new ArrayList<>();
		int n=s.nextInt();
		for(int i=0;i<n;i++) {
			wordDict.add(s.next());
		}
		String str=s.next();
		System.out.println(wordBreak(str,wordDict));
	}
	 public static boolean wordBreak(String s, List<String> wordDict) {
		 if (s == null ||  wordDict.size() == 0) {
	            return false;
	        }
		 if(s.length()==0) {
			 return true;
		 }
	        
	        Set<String> dict = new HashSet<String>();
	        int maxLen = 0;
	        for (String word: wordDict) {
	            dict.add(word);
	            maxLen = Math.max(maxLen, word.length());
	        }
	        
	        int strLen = s.length();
	        boolean[] dp =  new boolean[strLen + 1];
	        dp[0] = true;
	        for (int i = 1; i <= strLen; i++) {
	            
	            for (int j = Math.max(1, i-maxLen+1); j <= i; j++) {
	                if (!dp[j-1]) {
	                    continue;
	                }
	                
	                if (dict.contains(s.substring(j-1, i))) {
	                    dp[i] = true;
	                    break;
	                }
	            }
	        } 
	        
	        return dp[strLen];
	 }

}
