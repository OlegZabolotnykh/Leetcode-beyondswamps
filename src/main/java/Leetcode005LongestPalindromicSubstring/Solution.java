package main.java.Leetcode005LongestPalindromicSubstring;

import java.util.HashMap;

class Solution {
    public static void main(String[] args) {
        Solution instance = new Solution();
//        System.out.println(instance.longestPalindrome("babad"));
//        System.out.println(instance.longestPalindrome("cbbd"));
//        System.out.println(instance.longestPalindrome("bb"));
//        System.out.println(instance.longestPalindrome("lalaldkdla"));
        System.out.println(instance.longestPalindrome("kztakrekvefgchersuoiuatzlmwynzjhdqqftjcqmntoyckqfawikkdrnfgbwtdpbkymvwoumurjdzygyzsbmwzpcxcdmmpwzmeibligwiiqbecxwyxigikoewwrczkanwwqukszsbjukzumzladrvjefpegyicsgctdvldetuegxwihdtitqrdmygdrsweahfrepdcudvyvrggbkthztxwicyzazjyeztytwiyybqdsczozvtegodacdokczfmwqfmyuixbeeqluqcqwxpyrkpfcdosttzooykpvdykfxulttvvwnzftndvhsvpgrgdzsvfxdtzztdiswgwxzvbpsjlizlfrlgvlnwbjwbujafjaedivvgnbgwcdbzbdbprqrflfhahsvlcekeyqueyxjfetkxpapbeejoxwxlgepmxzowldsmqllpzeymakcshfzkvyykwljeltutdmrhxcbzizihzinywggzjctzasvefcxmhnusdvlderconvaisaetcdldeveeemhugipfzbhrwidcjpfrumshbdofchpgcsbkvaexfmenpsuodatxjavoszcitjewflejjmsuvyuyrkumednsfkbgvbqxfphfqeqozcnabmtedffvzwbgbzbfydiyaevoqtfmzxaujdydtjftapkpdhnbmrylcibzuqqynvnsihmyxdcrfftkuoymzoxpnashaderlosnkxbhamkkxfhwjsyehkmblhppbyspmcwuoguptliashefdklokjpggfiixozsrlwmeksmzdcvipgkwxwynzsvxnqtchgwwadqybkguscfyrbyxudzrxacoplmcqcsmkraimfwbauvytkxdnglwfuvehpxd"));
    }

    public String longestPalindrome(String s) {
        HashMap<String, Boolean> memo = new HashMap<>();
        String res = s.substring(0, 1);
        int maxLen = 1;
        int n = s.length();
        String windowStr;

        for (int window = 1; window <= n; window++) {
            for (int l = 0; l + window <= n; l++) {
                windowStr = s.substring(l, l + window);
                if (window > maxLen && checkPalindrome(windowStr, memo)) {
                    maxLen = window;
                    res = windowStr;
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
            boolean checked = checkPalindrome(s.substring(1, s.length() - 1), memo);
            memo.put(s, checked);
            return checked;
        } else {
            memo.put(s, false);
            return false;
        }
    }
}
