import javazoom.jl.player.Player;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.Mixer;
import javax.sound.sampled.Port;
import javax.sound.sampled.UnsupportedAudioFileException;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.spi.mpeg.sampled.file.MpegAudioFileReader;



public class mp3 {
    private String filename;
    private Player playerq;
    FileInputStream fis;
    BufferedInputStream bis;
    public static long songRemains;
    public static long songTotal;
    String filelocation;
    public mp3(){
    
    }
    public void close() throws JavaLayerException{
      if( playerq !=null){
       playerq.close();
      songRemains=0;
      songTotal=0;
      }
    }
     public void pause() throws JavaLayerException{
      if( playerq !=null){
          try {
              songRemains=fis.available();
               playerq.close();
          } catch (IOException ex) {
              Logger.getLogger(mp3.class.getName()).log(Level.SEVERE, null, ex);
          }
      }
    }
           public void pauseSlider() throws JavaLayerException{
      if( playerq !=null){
          try {
              songRemains=fis.available();
          } catch (IOException ex) {
              Logger.getLogger(mp3.class.getName()).log(Level.SEVERE, null, ex);
          }
      }
    } 
    public void play(String path) {
       
        
        try {
            fis =new FileInputStream(path);
            bis =new BufferedInputStream(fis);
            
             playerq =new Player(bis);
            
            songTotal=fis.available();
            filelocation =path;
        
            
        } catch (FileNotFoundException ex) {
            
        } catch (IOException ex) {
            Logger.getLogger(mp3.class.getName()).log(Level.SEVERE, null, ex);
        }
        
      new Thread(){
        @Override
        public void run(){
            try {
                 playerq.play();
                
                 if(playerq.isComplete()){
                     player.sec.setText("00");
                     player.min.setText("00");
                    if(player.shufful==1){
                     player.SongCount=0 + (int) (Math.random() * (((player.listcount-1) - 0) + 1)); 
                     
                     close();
                  play(player.filepath[player.SongCount]);
                   player.jLabel2.setText((player.SongCount+1)+":"+player.a[player.SongCount]);
                   player.jLabel2.setToolTipText(player.a[player.SongCount]);
                     
                    }
                    else{
                     if(player.filepath[player.SongCount+1]!=null){
                  player.SongCount++;
                  close();
                  play(player.filepath[player.SongCount]);
                   player.jLabel2.setText((player.SongCount+1)+":"+player.a[player.SongCount]);
                   player.jLabel2.setToolTipText(player.a[player.SongCount]);
                     }else{player.jLabel10.setVisible(true);player.jLabel10.setText("End Songs"); 
                     player.jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("stady.png")));}
                 }}
            } catch (JavaLayerException ex) {
                
            }
        
             }
            
            
        }.start();
    }
 
      
 public void resume() {
       
        
        try {
            fis =new FileInputStream(filelocation);
            bis =new BufferedInputStream(fis);
            
             playerq =new Player(bis);
            fis.skip(songTotal-songRemains);
            
        } catch (FileNotFoundException ex) {
            
        } catch (IOException ex) {
            Logger.getLogger(mp3.class.getName()).log(Level.SEVERE, null, ex);
        }
        
      new Thread(){
        @Override
        public void run(){
            try {
                 playerq.play();
                 if(playerq.isComplete()){
                     player.sec.setText("00");
                     player.min.setText("00");
                       if(player.shufful==1){
                           player.SongCount=0 + (int) (Math.random() * (((player.listcount-1) - 0) + 1)); 
                      
                     close();
                  play(player.filepath[player.SongCount]);
                   player.jLabel2.setText((player.SongCount+1)+":"+player.a[player.SongCount]);
                   player.jLabel2.setToolTipText(player.a[player.SongCount]);
                         
                    }
                    else{
                     if(player.filepath[player.SongCount+1]!=null){
                        player.SongCount++;
                        close();
                        play(player.filepath[player.SongCount]);
                          player.jLabel2.setText((player.SongCount+1)+":"+player.a[player.SongCount]);
                          player.jLabel2.setToolTipText(player.a[player.SongCount]);
                     }else{player.jLabel10.setVisible(true);player.jLabel10.setText("End Songs"); 
                     player.jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("stady.png")));}
                 }}
            } catch (JavaLayerException ex) {
                
            }
        
             }
            
            
        }.start();
    }   

    public void setGain(float ctrl)  
    {          
        try {  
        Mixer.Info[] infos = AudioSystem.getMixerInfo();    
        for (Mixer.Info info: infos)    
        {    
           Mixer mixer = AudioSystem.getMixer(info);  
           if (mixer.isLineSupported(Port.Info.SPEAKER))    
           {    
              Port port = (Port)mixer.getLine(Port.Info.SPEAKER);    
              port.open();    
              if (port.isControlSupported(FloatControl.Type.VOLUME))    
              {    
                 FloatControl volume =  (FloatControl)port.getControl(FloatControl.Type.VOLUME);                    
                 volume.setValue(ctrl);  
              }    
              port.close();    
           }    
         }    
        } catch (Exception e) {   
          player.jLabel10.setVisible(true);player.jLabel10.setText("Erro\n"+e);  
        }
    }

   
}
