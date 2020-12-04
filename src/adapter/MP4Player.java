package adapter;

/**
 * @author Grey
 * @date 2020/4/16
 */
public class MP4Player implements AdvanceMediaPlayer {
    @Override
    public void playMP4(String fileName) {
        System.out.println("play mp4");
    }

    @Override
    public void playAVI(String fileName) {

    }
}
