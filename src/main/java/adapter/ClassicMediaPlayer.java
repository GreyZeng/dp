package adapter;

/**
 * @author Grey
 * @date 2020/4/16
 */
public class ClassicMediaPlayer implements MediaPlayer {
    @Override
    public void play(String type, String fileName) {
        if ("mp3".equalsIgnoreCase(type)) {
            System.out.println("play mp3");
        } else {
            System.out.println("not supported format");
        }

    }
}
