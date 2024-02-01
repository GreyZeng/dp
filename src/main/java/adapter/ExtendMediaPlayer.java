package adapter;

/**
 * @author Grey
 * @date 2020/4/16
 */
public class ExtendMediaPlayer implements MediaPlayer {
    @Override
    public void play(String type, String fileName) {
        PlayerAdapter adapter = new PlayerAdapter(type);
        adapter.play(type, fileName);
    }
}
