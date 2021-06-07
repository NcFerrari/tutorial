package pokrocilyPriklad;

import java.util.Random;

public class Model {

    private final Random random = new Random();

    private String[] words = {"i t n e t w o r k", "t e s t", "a p l i k a c e", "a u t o", "j e l e n", "o v o c e", "p r o j e k t"};
    private String winWord;
    private String tips;

    public void newGame() {
        setWinWord(words[random.nextInt(words.length)]);
        setTips(winWord.replaceAll("[a-z]", "_"));
    }

    public String getTips() {
        return tips;
    }

    public void setWinWord(String winWord) {
        this.winWord = winWord;
    }

    public void setTips(String tips) {
        this.tips = tips;
    }

    public String getWinWord() {
        return winWord.toUpperCase();
    }

    public void correctTip(String inputLetter) {
        String result = "";
        for (int i = 0; i < winWord.split("").length; i++) {
            if (winWord.toUpperCase().split("")[i].equals(inputLetter)) {
                result += inputLetter;
            } else {
                result += tips.toUpperCase().split("")[i];
            }
        }
        setTips(result);
    }

}
