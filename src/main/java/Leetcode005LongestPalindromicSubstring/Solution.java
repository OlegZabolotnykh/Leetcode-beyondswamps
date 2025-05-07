package main.java.Leetcode005LongestPalindromicSubstring;

import java.util.HashMap;

class Solution {
    public static void main(String[] args) {
        Solution instance = new Solution();
//        System.out.println(instance.longestPalindrome("babad"));
//        System.out.println(instance.longestPalindrome("cbbd"));
        System.out.println(instance.longestPalindrome("lalaldkdla"));
//        System.out.println(instance.longestPalindrome("kztakrekvefgchersuoiuatzlmwynzjhdqqftjcqmntoyckqfawikkdrnfgbwtdpbkymvwoumurjdzygyzsbmwzpcxcdmmpwzmeibligwiiqbecxwyxigikoewwrczkanwwqukszsbjukzumzladrvjefpegyicsgctdvldetuegxwihdtitqrdmygdrsweahfrepdcudvyvrggbkthztxwicyzazjyeztytwiyybqdsczozvtegodacdokczfmwqfmyuixbeeqluqcqwxpyrkpfcdosttzooykpvdykfxulttvvwnzftndvhsvpgrgdzsvfxdtzztdiswgwxzvbpsjlizlfrlgvlnwbjwbujafjaedivvgnbgwcdbzbdbprqrflfhahsvlcekeyqueyxjfetkxpapbeejoxwxlgepmxzowldsmqllpzeymakcshfzkvyykwljeltutdmrhxcbzizihzinywggzjctzasvefcxmhnusdvlderconvaisaetcdldeveeemhugipfzbhrwidcjpfrumshbdofchpgcsbkvaexfmenpsuodatxjavoszcitjewflejjmsuvyuyrkumednsfkbgvbqxfphfqeqozcnabmtedffvzwbgbzbfydiyaevoqtfmzxaujdydtjftapkpdhnbmrylcibzuqqynvnsihmyxdcrfftkuoymzoxpnashaderlosnkxbhamkkxfhwjsyehkmblhppbyspmcwuoguptliashefdklokjpggfiixozsrlwmeksmzdcvipgkwxwynzsvxnqtchgwwadqybkguscfyrbyxudzrxacoplmcqcsmkraimfwbauvytkxdnglwfuvehpxd"));
    }

    public String longestPalindrome(String s) {
        HashMap<String, Boolean> memo = new HashMap<>();
        String res = s.substring(0, 1);
        int maxLen = 1;
        int n = s.length();

        for (int l = 0; l < n - 1; l++) {
            for (int r = l + 1; r < n; r++) {
                if (r - l + 1 > maxLen && checkPalindrome(s.substring(l, r + 1), memo)) {
                    maxLen = r - l + 1;
                    res = s.substring(l, r + 1);
                }
            }
        }
        return res;

    }

    Boolean checkPalindrome(String s, HashMap<String, Boolean> memo) {
        if (s.isEmpty() || s.length() == 1) {
            return true;
        }
        if (memo.containsKey(s)) {
            return memo.get(s);
        }
        if (Character.toLowerCase(s.charAt(0)) == Character.toLowerCase(s.charAt(s.length() - 1))) {
            return checkPalindrome(s.substring(1, s.length() - 1), memo);
        } else {
            memo.put(s, false);
            return false;
        }
    }
}
