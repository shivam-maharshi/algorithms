package leetcode.medium;

/**
 * Link: https://leetcode.com/problems/longest-substring-without-repeating-characters
 * 
 * @author shivam.maharshi
 */
public class M3_LongestSubstringWithoutRepeatingCharacters {

	int[] cc = new int[256]; 
	
    public int lengthOfLongestSubstring(String s) {
    	if(s==null || s.isEmpty())
    		return 0;
    	int i=0,j=0, len=0;
    	while(j<s.length()) {
    		cc[s.charAt(j)]++;
    		while(hasRepetitions()) {
    			cc[s.charAt(i)]--;
    			i++;
    		}
    		if(j-i +1 > len)
				len = j-i+1;
    		j++;
    	}
    	return len;
    }
    
    public boolean hasRepetitions() {
    	for(int i=0;i<256;i++) {
    		if(cc[i]>1)
    			return true;
    	}
    	return false;
    }
	
}
