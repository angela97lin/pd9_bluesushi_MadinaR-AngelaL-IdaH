import sun.audio.*;
import java.io.*;

public class Music{
    
    public static void play(){
        try{
	    String fileName = ("background.wav");
	    InputStream in = new FileInputStream(new File(fileName));
	    AudioStream audioStream = new AudioStream(in);
	    AudioPlayer.player.start(audioStream);
	    //AudioData data = audioStream.getData();
	    //ContinuousAudioDataStream cas = new ContinuousAudioDataStream(data);
	    //AudioPlayer.player.start(cas);
	}
	catch(IOException error){
	    
	}
	
    }
}
    
