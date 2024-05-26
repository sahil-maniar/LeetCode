import java.util.HashSet;

public class Main {

    private boolean isNumeric(char ch) {
        return ch >= '0' && ch <= '9';
    }
    public int numDifferentIntegers(String word) {
        HashSet<String> hashSet = new HashSet<>();

        StringBuilder numberTillNow = new StringBuilder();
        boolean zero = false;
        char ch;

        for (int i = 0; i < word.length(); i++) {
            ch = word.charAt(i);

            if (this.isNumeric(ch)) {
                if (ch == '0' && numberTillNow.isEmpty()) {
                    zero = true;
                } else {
                    zero = false;
                    numberTillNow.append(word.charAt(i));
                }
            } else {
                if (numberTillNow.isEmpty()) {
                    if (zero) {
                        zero = false;
                        hashSet.add("0");
                    }
                } else {
                    hashSet.add(numberTillNow.toString());
                    numberTillNow = new StringBuilder();
                }
            }
        }

        if (zero) {
            hashSet.add("0");
        }

        if (!numberTillNow.isEmpty()) {
            hashSet.add(numberTillNow.toString());
        }

        return hashSet.size();
    }
    public static void main(String[] args) {
        System.out.println(new Main().numDifferentIntegers("000123abc000a1234sah65il123"));
    }
}