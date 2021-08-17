package template.case1;

/**
 * @author Grey
 * @date 2020/4/17
 */
public class Main {
    public static void main(String[] args) {
        Game basketballGame = new BasketballGame();
        basketballGame.play();
        Game footballGame = new FootballGame();
        footballGame.play();
    }
}
