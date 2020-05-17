

public class Xkrementy {
    
    private static int i, j, k;
    private static String resultText = "";
    
    public static void test() {
        i = 1;
        addToText();
        j = i++;
        addToText();
        k = ++i;
        addToText();
        k = i-- + j--;
        addToText();
        k = --i + --j;
        addToText();
        P.zprava(getResultText());
        reset();
    }
    
    private static void addToText() {
        resultText += String.format("i=%d j=%d  k=%d\n", i, j, k);
    }
    
    private static void reset() {
        i = j = k = 0;
        resultText = "";
    }
    
    private static String getResultText() {
        return resultText;
    }
    
    public static void ttest() {
        i = 1;
        addToText();
        j = i++;
        addToText();
        k = ++i;
        addToText();
        k = i-- + j--;
        addToText();
        k = --i + --j;
        addToText();
        System.out.println(getResultText());
        reset();
    }
    
    public static void etest() {
        i = 1;
        addToText();
        j = i++;
        addToText();
        k = ++i;
        addToText();
        k = i-- + j--;
        addToText();
        k = --i + --j;
        addToText();
        System.err.println(getResultText());
        reset();
    }
}
