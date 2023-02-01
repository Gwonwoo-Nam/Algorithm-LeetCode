public class Prob9 {
    public boolean isPalindrome(int x) {

        String str = Integer.toString(x);
        StringBuffer revStr = new StringBuffer(str);
        revStr.reverse();
        if (str.equals(revStr.toString())) {
            return true;
        }
        return false;
    }
}
