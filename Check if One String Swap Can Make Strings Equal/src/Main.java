import java.util.Objects;

public class Main {
    public boolean areAlmostEqual(String s1, String s2) {
        int len = s1.length(),
                mismatchLen = 0,
                mismatch1 = -1,
                mismatch2 = -1;
        char s1ch, s2ch;

        for (int i = 0; i < len; i++) {

            s1ch = s1.charAt(i);
            s2ch = s2.charAt(i);

            if (s1ch == s2ch) {
                continue;
            } else if (mismatchLen == 0) {
                mismatch1 = i;
                mismatchLen++;
            } else if (mismatchLen == 1) {
                mismatch2 = i;
                mismatchLen++;
            } else {
                return false;
            }
        }

        return (mismatchLen == 0) || (
                mismatchLen == 2 &&
                        s1.charAt(mismatch1) == s2.charAt(mismatch2) &&
                        s1.charAt(mismatch2) == s2.charAt(mismatch1)
        );
    }

    public static void main(String[] args) {
        System.out.println(new Main().areAlmostEqual("bank", "aknb"));
    }
}