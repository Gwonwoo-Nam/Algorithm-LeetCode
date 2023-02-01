public class Prob14 {

    public String longestCommonPrefix(String[] strs) {
        int min = Integer.MAX_VALUE;
        String minStr = "";
        for (String str : strs) {
            min = Math.min(str.length(), min);
            minStr = str;
        }

        String prefix = "";
        for (int i = 0; i < min; i++) {
            for (String str : strs) {
                if (!str.startsWith(minStr.substring(0, i + 1))) {
                    return prefix;
                }
            }
            prefix = minStr.substring(0,i+1);
        }

        return prefix;
    }
}
