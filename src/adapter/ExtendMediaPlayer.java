package adapter;

/**
 * @author Grey
 * @date 2020/4/16
 */
public class ExtendMediaPlayer implements MediaPlayer {
    private PlayerAdapter adapter;

    @Override
    public void play(String type, String fileName) {
        adapter = new PlayerAdapter(type);
        adapter.play(type, fileName);
    }
}
