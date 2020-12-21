package adapter;

/**
 * @author Grey
 * @date 2020/4/16
 */
public class AVIPlayer implements AdvanceMediaPlayer {
    @Override
    public void playMP4(String fileName) {

    }

    @Override
    public void playAVI(String fileName) {
        System.out.println("play avi");
    }
}
