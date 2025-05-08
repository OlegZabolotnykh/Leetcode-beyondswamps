package main.java.Leetcode005LongestPalindromicSubstring;

class Solution {
    public static void main(String[] args) {
        Solution instance = new Solution();
        System.out.println(instance.longestPalindrome("babad"));
        System.out.println(instance.longestPalindrome("cbbd"));
        System.out.println(instance.longestPalindrome("bb"));
        System.out.println(instance.longestPalindrome("lalaldkdla"));
        System.out.println(instance.longestPalindrome("kztakrekvefgchersuoiuatzlmwynzjhdqqftjcqmntoyckqfawikkdrnfgbwtdpbkymvwoumurjdzygyzsbmwzpcxcdmmpwzmeibligwiiqbecxwyxigikoewwrczkanwwqukszsbjukzumzladrvjefpegyicsgctdvldetuegxwihdtitqrdmygdrsweahfrepdcudvyvrggbkthztxwicyzazjyeztytwiyybqdsczozvtegodacdokczfmwqfmyuixbeeqluqcqwxpyrkpfcdosttzooykpvdykfxulttvvwnzftndvhsvpgrgdzsvfxdtzztdiswgwxzvbpsjlizlfrlgvlnwbjwbujafjaedivvgnbgwcdbzbdbprqrflfhahsvlcekeyqueyxjfetkxpapbeejoxwxlgepmxzowldsmqllpzeymakcshfzkvyykwljeltutdmrhxcbzizihzinywggzjctzasvefcxmhnusdvlderconvaisaetcdldeveeemhugipfzbhrwidcjpfrumshbdofchpgcsbkvaexfmenpsuodatxjavoszcitjewflejjmsuvyuyrkumednsfkbgvbqxfphfqeqozcnabmtedffvzwbgbzbfydiyaevoqtfmzxaujdydtjftapkpdhnbmrylcibzuqqynvnsihmyxdcrfftkuoymzoxpnashaderlosnkxbhamkkxfhwjsyehkmblhppbyspmcwuoguptliashefdklokjpggfiixozsrlwmeksmzdcvipgkwxwynzsvxnqtchgwwadqybkguscfyrbyxudzrxacoplmcqcsmkraimfwbauvytkxdnglwfuvehpxd"));
    }

    public String longestPalindrome(String s) {
        int n = s.length();
        Boolean[][] memotab = new Boolean[n + 1][n + 1];
        int maxLen = 1;
        int resLeft = 0;
        int resRight = 0;

        for (int window = 1; window <= n; window++) {
            for (int l = 0, r; l + window <= n; l++) {
                r = l + window - 1;
                if (checkPalindrome(l, r, s, memotab)) {
                    if (window > maxLen) {
                        maxLen = window;
                        resLeft = l;
                        resRight = r;
                    }
                }
            }
        }
        return s.substring(resLeft, resRight + 1);
    }

    boolean checkPalindrome(int l, int r, String s, Boolean[][] memotab) {
        if (r == l) {
            return memotab[l][r] = true;
        }

        if (memotab[l][r] != null) {
            return memotab[l][r];
        }
        if (Character.toLowerCase(s.charAt(l)) == Character.toLowerCase(s.charAt(r))) {
            if (r - l == 1) {
                return memotab[l][r] = true;
            }
            return memotab[l + 1][r - 1] = checkPalindrome(l + 1, r - 1, s, memotab);
        } else {
            return memotab[l][r] = false;
        }
    }
}
