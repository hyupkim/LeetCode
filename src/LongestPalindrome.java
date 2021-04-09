/*
Loop through the string with O(n),
expand from each character with inside O(n)
which results time complexity to be O(n^2)
Remeber to set up starting point as i - (len - 1) / 2
for even strings
*/

public class LongestPalindrome {

    public String longestPalindrome(String s) {

        int start = 0;
        int len = 0;

        for (int i = 0; i < s.length(); i++) {
            int odd = expand(i, i, s);
            int even = expand(i, i + 1, s);
            if (Math.max(odd, even) > len) {
                len = Math.max(odd, even);
                start = i - (len - 1) / 2;
            }
        }
        return s.substring(start, start + len);

    }

    public int expand(int i, int j, String s){

        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
        }
        return j - i - 1;

    
}
