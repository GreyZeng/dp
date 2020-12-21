package adapter;

/**
 * @author Grey
 * @date 2020/4/16
 */
public class PlayerAdapter implements MediaPlayer {
    private AdvanceMediaPlayer advanceMediaPlayer;

    public PlayerAdapter(String type) {
        if ("mp4".equalsIgnoreCase(type)) {
            advanceMediaPlayer = new MP4Player();
        } else if ("AVI".equalsIgnoreCase(type)) {
            advanceMediaPlayer = new AVIPlayer();
        }
    }

    @Override
    public void play(String type, String fileName) {
        if ("mp4".equalsIgnoreCase(type)) {
            advanceMediaPlayer.playMP4(fileName);
        } else if ("AVI".equalsIgnoreCase(type)) {
            advanceMediaPlayer.playAVI(fileName);
        } else {
            new ClassicMediaPlayer().play(type, fileName);
        }
    }
}
