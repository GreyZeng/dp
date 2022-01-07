package adapter;

public class Main {
    public static void main(String[] args) throws Exception {
        /*FileInputStream fis = new FileInputStream("D:/test.txt");

        InputStreamReader isr = new InputStreamReader(fis);
        BufferedReader br = new BufferedReader(isr);
        String line = br.readLine();
        while (line != null && !line.equals("")) {
            System.out.println(line);
        }
        br.close();*/
        MediaPlayer audioPlayer = new ExtendMediaPlayer();

        audioPlayer.play("mp3", "beyond the horizon.mp3");
        audioPlayer.play("mp4", "alone.mp4");
        audioPlayer.play("avi", "far far away.vlc");
        audioPlayer.play("avi", "mind me.avi");
        audioPlayer.play("vlc", "mind me.avi");

    }
}


