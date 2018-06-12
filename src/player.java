
import de.javasoft.plaf.synthetica.SyntheticaAluOxideLookAndFeel;
import java.awt.Color;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javazoom.jl.decoder.JavaLayerException;
import java.awt.Image;
import javax.swing.Action;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetDragEvent;
import java.awt.dnd.DropTargetDropEvent;
import java.awt.dnd.DropTargetEvent;
import java.awt.dnd.DropTargetListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import javax.imageio.ImageIO;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JSlider;
import javax.swing.ListSelectionModel;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class player extends javax.swing.JFrame implements DropTargetListener {

    JFileChooser fileChooser = new JFileChooser("C:\\Users\\abano\\Desktop");
    boolean selcet;
    boolean paused;
    public static int count = 0;
    public static int SongCount = 0;
    int xMouse;
    int yMouse;
    int xxx=0;
    boolean adjusted=false;
    //Timer t= new Timer(1,this);
    int timer_count;
     DefaultListModel listModel = new DefaultListModel();
     int x=1000;
   Timer increaseValue = new Timer(1000, new ActionListener() {// 1 s interval in each increase.
        @Override
        public void actionPerformed(ActionEvent e) {
        if (filepath[0] != null) {
            try {
                jSlider1.setMaximum((int) mc.songTotal);
              if(jSlider1.getValue()!=1){
                mc.pauseSlider();
                if(adjusted==true){
                    mc.pause();
                    mc.songRemains=xxx;
                   jSlider1.setValue((int) mc.songRemains);
                   
                   mc.resume();
                   adjusted=false;
                   
                }
                else{
                jSlider1.setValue((int) mc.songRemains);
                }
       int  r= Integer.parseInt(sec.getText());
      int   t = Integer.parseInt(min.getText());
        
                if (r < 9) {
                    sec.setText("0" + (r + 1) + "");
                } else {
                    sec.setText((r + 1) + "");
                }
             if(r==59){
                 sec.setText("00");
              if (t < 9) {
                min.setText("0" + (t + 1) + "");
            } else {
                min.setText((t + 1) + "");
            }
             }
              }
              else{
                 mc.close();
                  increaseValue.stop();}
            } catch (JavaLayerException ex) {
                Logger.getLogger(player.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            jSlider1.setValue(100);
        }
        }
    });
    public enum DragState {

        Waiting,
        Accept,
        Reject
    }
    private DragState state = DragState.Waiting;
    mp3 mc = new mp3();
    public static String[] a = new String[10];
    public static String filepath[] = new String[10];
    JList l;
    
    public player() {
       
        initComponents();
        Image i = null;
        
        try {
            i = ImageIO.read(getClass().getResource("Guyman Helmet.png"));
        } catch (IOException ex) {
            Logger.getLogger(player.class.getName()).log(Level.SEVERE, null, ex);
        }
        setIconImage(i);
        DropTarget dt = new DropTarget(
                this,
                DnDConstants.ACTION_COPY_OR_MOVE,
                this,
                true);
         jList1.setModel(listModel);
         DefaultListModel colorModel = new DefaultListModel();
          colorModel.addElement("black");
        colorModel.addElement("Orange");
        colorModel.addElement("green");
        colorModel.addElement("blue");
       l=new JList(colorModel);
      l.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
      l.setSelectedIndex(0);
      l.setVisibleRowCount(3);        

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu3 = new javax.swing.JMenu();
        jLabel11 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jSlider2 = new javax.swing.JSlider();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jSlider1 = new javax.swing.JSlider();
        jLabel15 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jLabel10 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        sec = new javax.swing.JLabel();
        min = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();

        jMenu3.setText("jMenu3");

        jLabel11.setText("jLabel11");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Symphony");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel1MouseDragged(evt);
            }
        });
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel1MousePressed(evt);
            }
        });
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jSlider2.setBackground(new java.awt.Color(34, 42, 29));
        jSlider2.setForeground(new java.awt.Color(255, 0, 0));
        jSlider2.setMaximum(10);
        jSlider2.setOrientation(javax.swing.JSlider.VERTICAL);
        jSlider2.setPaintLabels(true);
        jSlider2.setVisible(false);
        jSlider2.setSnapToTicks(true);
        jSlider2.setToolTipText("");
        jSlider2.setFocusable(false);
        jSlider2.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSlider2StateChanged(evt);
            }
        });
        jPanel1.add(jSlider2, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 0, 20, 150));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/open_e.png"))); // NOI18N
        jLabel6.setToolTipText("Open Files(*.Mp3) ");
        jLabel6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel6MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jLabel6MouseReleased(evt);
            }
        });
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 140, -1, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pause.png"))); // NOI18N
        jLabel5.setToolTipText("Pause");
        jLabel5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel5MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jLabel5MouseReleased(evt);
            }
        });
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 130, -1, -1));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/next.png"))); // NOI18N
        jLabel7.setToolTipText("Next Track");
        jLabel7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel7MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jLabel7MouseReleased(evt);
            }
        });
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 130, -1, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/play.png"))); // NOI18N
        jLabel4.setToolTipText("Play");
        jLabel4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel4MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jLabel4MouseReleased(evt);
            }
        });
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 130, -1, -1));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pre.png"))); // NOI18N
        jLabel8.setToolTipText("previous track ");
        jLabel8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel8MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel8MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jLabel8MouseReleased(evt);
            }
        });
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 130, -1, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/stop.png"))); // NOI18N
        jLabel3.setToolTipText("Stop");
        jLabel3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel3MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jLabel3MouseReleased(evt);
            }
        });
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/stady.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 140, 70));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Wellcome To Symphony");
        jLabel2.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 260, 40));

        jSlider1.setBackground(new java.awt.Color(147, 140, 114));
        jSlider1.setForeground(new java.awt.Color(255, 51, 51));
        jSlider1.setMajorTickSpacing(1);
        jSlider1.setMinorTickSpacing(1);
        jSlider1.setPaintTrack(false);
        jSlider1.setSnapToTicks(true);
        jSlider1.setValue(100);
        jSlider1.setAutoscrolls(true);
        jSlider1.setBorder(new javax.swing.border.MatteBorder(null));
        jSlider1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jSlider1.setFocusable(false);
        jSlider1.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
                jSlider1AncestorMoved(evt);
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jSlider1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSlider1StateChanged(evt);
            }
        });
        jSlider1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jSlider1MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jSlider1MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jSlider1MouseReleased(evt);
            }
        });
        jPanel1.add(jSlider1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 290, -1));

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/2000px-1D_line.svg.png"))); // NOI18N
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 190, 310, -1));

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        jList1.setBackground(new java.awt.Color(74, 81, 65));
        jList1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jList1.setForeground(new java.awt.Color(255, 255, 255));
        jList1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jList1.setToolTipText("Songs PlayList");
        jList1.setAutoscrolls(false);
        jList1.setFocusable(false);
        jList1.setSelectionBackground(new java.awt.Color(0, 255, 204));
        jList1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jList1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jList1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, 290, 170));

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/error.png"))); // NOI18N
        jLabel10.setVisible(false);
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 400, -1, -1));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/soundvol.png"))); // NOI18N
        jLabel9.setToolTipText("Volume");
        jLabel9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel9MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel9MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel9MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel9MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jLabel9MouseReleased(evt);
            }
        });
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 150, -1, -1));

        sec.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        sec.setForeground(new java.awt.Color(255, 255, 255));
        sec.setText("00");
        jPanel1.add(sec, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 50, -1, -1));

        min.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        min.setForeground(new java.awt.Color(255, 255, 255));
        min.setText("00");
        jPanel1.add(min, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 50, -1, -1));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText(":");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 50, -1, -1));

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/shuffel.png"))); // NOI18N
        jLabel13.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel13MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 110, -1, -1));

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/backGrounds/Solid-Color-HD-Wallpapers-Free-Download.jpg"))); // NOI18N
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 310, 440));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        jSlider1.setValue(Integer.MAX_VALUE);
        paused = false;
        try {
            mc.close();
            increaseValue.stop();
            sec.setText("00");
            min.setText("00");
            jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("stady.png")));
        } catch (JavaLayerException ex) {
            Logger.getLogger(player.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jLabel3MouseClicked

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        
        if (filepath[SongCount] != null) {

            if (paused == true) {
                mc.resume();
                increaseValue.start();
                jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("voluomGif.gif")));
                paused = false;
            } else {
                try {
                    mc.close();
                    mc.play(filepath[SongCount]);
                    sec.setText("00");
                    min.setText("00");
                    increaseValue.start();
                    jSlider1.setValue(Integer.MAX_VALUE);
                    jLabel10.setVisible(false);
                    jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("voluomGif.gif")));
                } catch (JavaLayerException ex) {
                    Logger.getLogger(player.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            selcet = false;
        } else {
           jLabel10.setVisible(true);
           jLabel10.setText( "Thair Is No Mp3 Files To Play ");
        }
    }//GEN-LAST:event_jLabel4MouseClicked


    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
       
        try {
            paused = true;
            mc.pause();
            increaseValue.stop();
            jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("stady.png")));
        } catch (JavaLayerException ex) {
            Logger.getLogger(player.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jLabel5MouseClicked

    private void jLabel5MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MousePressed
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("pause_hover.png")));
    }//GEN-LAST:event_jLabel5MousePressed

    private void jLabel5MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseReleased
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("pause.png")));
    }//GEN-LAST:event_jLabel5MouseReleased

    private void jLabel4MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MousePressed
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("play_hover.png")));
    }//GEN-LAST:event_jLabel4MousePressed

    private void jLabel4MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseReleased
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("play.png")));
    }//GEN-LAST:event_jLabel4MouseReleased

    private void jLabel3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MousePressed
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("stop_hover.png")));
    }//GEN-LAST:event_jLabel3MousePressed

    private void jLabel3MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseReleased
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("stop.png")));
    }//GEN-LAST:event_jLabel3MouseReleased

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
         jSlider1.setValue(Integer.MAX_VALUE);
        for (int i = 0; i < filepath.length; i++) {
            listModel.clear();
            filepath[i] = null;
            a[i] = null;
        }
        fileChooser.setDialogTitle("Symphony");
        fileChooser.setAcceptAllFileFilterUsed(false);
        fileChooser.setMultiSelectionEnabled(true);
        SongCount = 0;
       
        fileChooser.addChoosableFileFilter(new FileNameExtensionFilter(String.format("(*.%1$s)mp3", "mp3"), "mp3"));
        if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            try {
                File selectedFile[] = fileChooser.getSelectedFiles();
                for (int i = 0; i < selectedFile.length; i++) {
                    filepath[i] = selectedFile[i].getAbsolutePath();
                }
                if (filepath[SongCount] != null) {
                    mc.close();
                     
                    mc.play(filepath[SongCount]);
                    increaseValue.start();
                  
                    jLabel10.setVisible(false);
                } else {
                    jLabel10.setVisible(true);
                    jLabel10.setText("no Songs to play");
                }
                jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("voluomGif.gif")));
                for (int i = 0; i < selectedFile.length; i++) {
                    a[i] = selectedFile[i].getName();
                }
               
                for (int i = 0; i < a.length; i++) {
                    if (a[i] != null) {
                        listModel.addElement("•"+(i + 1) + " : " + a[i] + "\n");
                    }
                }
            
                jLabel2.setText((SongCount + 1) + ":" + a[SongCount]);
                jLabel2.setToolTipText(a[SongCount]);
            } catch (JavaLayerException ex) {
                Logger.getLogger(player.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {

        }
    }//GEN-LAST:event_jLabel6MouseClicked

    private void jLabel6MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MousePressed
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("open_ehover.png")));
    }//GEN-LAST:event_jLabel6MousePressed

    private void jLabel6MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseReleased
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("open_e.png")));
    }//GEN-LAST:event_jLabel6MouseReleased

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
        sec.setText("00");
        min.setText("00");
        jSlider1.setValue(Integer.MAX_VALUE);
        try {

            if (filepath[SongCount + 1] != null) {
                SongCount++;
                mc.close();
                mc.play(filepath[SongCount]);
                jLabel10.setVisible(false);
                jLabel2.setText((SongCount + 1) + ":" + a[SongCount]);
                jLabel2.setToolTipText(a[SongCount]);
            } else {
                jLabel10.setVisible(true);
                jLabel10.setText("Thair is no avilable songs");
               jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("error.png")));
            }
        } catch (JavaLayerException ex) {
            Logger.getLogger(player.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jLabel7MouseClicked

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
        jSlider1.setValue(Integer.MAX_VALUE);

        try {

            if (SongCount - 1 >= 0) {
                SongCount--;
                mc.close();
                mc.play(filepath[SongCount]);
                sec.setText("00");
                min.setText("00");
                jLabel10.setVisible(false);
                jLabel2.setText((SongCount + 1) + ":" + a[SongCount]);
                jLabel2.setToolTipText(a[SongCount]);
            } else {
                jLabel10.setVisible(true);
                jLabel10.setText("Thair is no avilable songs");
                jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("error.png")));
            }
        } catch (JavaLayerException ex) {
            Logger.getLogger(player.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jLabel8MouseClicked

    private void jLabel7MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MousePressed
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("next_hover.png")));
    }//GEN-LAST:event_jLabel7MousePressed

    private void jLabel7MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseReleased
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("next.png")));
    }//GEN-LAST:event_jLabel7MouseReleased

    private void jLabel8MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MousePressed
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("pre_hover.png")));
    }//GEN-LAST:event_jLabel8MousePressed

    private void jLabel8MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseReleased
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("pre.png")));
    }//GEN-LAST:event_jLabel8MouseReleased

    private void jSlider1AncestorMoved(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jSlider1AncestorMoved

    }//GEN-LAST:event_jSlider1AncestorMoved

    private void jSlider1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSlider1StateChanged
     
    }//GEN-LAST:event_jSlider1StateChanged

    private void jPanel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MousePressed
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_jPanel1MousePressed

    private void jPanel1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();

        this.setLocation(x - xMouse, y - yMouse);
    }//GEN-LAST:event_jPanel1MouseDragged

    private void jSlider2StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSlider2StateChanged
        updateFloat(jSlider2);
        mc.setGain( updateFloat(jSlider2));
        if(updateFloat(jSlider2)==0){
        jLabel10.setText("Volume : Mute");
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("mute.png")));
        }
        else{
        jLabel10.setText("Volume : "+(int)(updateFloat(jSlider2)*1000)+"%");}
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("vol.png")));
        jLabel10.setVisible(true);
    }//GEN-LAST:event_jSlider2StateChanged

    private void jLabel9MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MousePressed
       
    }//GEN-LAST:event_jLabel9MousePressed

    private void jLabel9MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseReleased
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("soundvol.png")));
    }//GEN-LAST:event_jLabel9MouseReleased
int y=0;
    private void jLabel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseClicked
     switch(y){
     case 0:y=1;break;
     case 1:y=0;break;
     }
        if(y==1){
        jSlider2.setValue(0);
     jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("soundvol_hover.png")));
     jSlider2.setVisible(true);
      jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("mute.png")));
        }
        else{
        jSlider2.setValue(10);
         jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("soundvol.png")));
     jSlider2.setVisible(true);
        }
    }//GEN-LAST:event_jLabel9MouseClicked

    private void jLabel9MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseEntered
     if(jSlider2.isVisible()){
        jSlider2.setVisible(false);}
        else{jSlider2.setVisible(true);}
     
     if(jLabel10.isVisible()){
         jLabel10.setVisible(false);
     }
     
    }//GEN-LAST:event_jLabel9MouseEntered

    private void jLabel9MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel9MouseExited

    private void jSlider1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jSlider1MouseClicked
      
    }//GEN-LAST:event_jSlider1MouseClicked

    private void jList1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList1MouseClicked
        jList1 = (JList)evt.getSource();
        if (evt.getClickCount() == 2) {

            try {
                // Double-click detected
                int index = jList1.locationToIndex(evt.getPoint());
                mc.close();
                mc.play(filepath[index]);
                sec.setText("00");
                min.setText("00");
                jLabel2.setText((index + 1) + ":" + a[index]);
                jLabel2.setToolTipText(a[index]);
            } catch (JavaLayerException ex) {
                Logger.getLogger(player.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jList1MouseClicked

    private void jSlider1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jSlider1MousePressed
      
    }//GEN-LAST:event_jSlider1MousePressed
public static int listcount=0;
public static int shufful=0;
    private void jLabel13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseClicked
       for(int i=0;i<filepath.length;i++){
         if(filepath[i]!=null){
           listcount++;
         }
       }
       switch(shufful){
           case 0:shufful=1;
           jLabel13.setToolTipText("Shuffel : On");
           jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("shuffel_act.png")));
           break;
           case 1:shufful=0;
            jLabel13.setToolTipText("Shuffel : Off");
            jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("shuffel.png")));
           break;
       
       }
        
        
        
        
       
    }//GEN-LAST:event_jLabel13MouseClicked

    private void jSlider1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jSlider1MouseReleased
   xxx=jSlider1.getValue();
   adjusted=true;
    }//GEN-LAST:event_jSlider1MouseReleased
        float updateFloat(JSlider slider) {
          return (slider.getValue() * 0.01f);
        }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) throws UnsupportedLookAndFeelException {
        try {
            UIManager.setLookAndFeel(new SyntheticaAluOxideLookAndFeel());
        } catch (UnsupportedLookAndFeelException e) {
        } catch (ParseException ex) {
            Logger.getLogger(player.class.getName()).log(Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new player().setVisible(true);
            }
        });
        
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JLabel jLabel1;
    public static javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    public static javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JList<String> jList1;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JSlider jSlider1;
    private javax.swing.JSlider jSlider2;
    public static javax.swing.JLabel min;
    public static javax.swing.JLabel sec;
    // End of variables declaration//GEN-END:variables
int o=0;
    @Override
    public void dragEnter(DropTargetDragEvent dtde) {
        state = DragState.Reject;
        Transferable t = dtde.getTransferable();
        if (t.isDataFlavorSupported(DataFlavor.javaFileListFlavor)) {
            try {
                Object td = t.getTransferData(DataFlavor.javaFileListFlavor);
                if (td instanceof List) {
                    state = DragState.Accept;
                    for (Object value : ((List) td)) {
                        if (value instanceof File) {
                            File file = (File) value;
                            String name = file.getName();
                            a[o]=name;
                            if (!name.endsWith(".mp3")) {
                                jLabel10.setVisible(true);
                                jLabel10.setText("Not (*.mp3) file try again");

                                break;
                            } else {
                                
                                filepath[SongCount] = file.getPath();
                                mc.close();
                                mc.play(filepath[SongCount]);
                                increaseValue.start();
                                sec.setText("00");
                                min.setText("00");
                                jLabel2.setText((SongCount+1) + ":" + a[o]);
                                jLabel2.setToolTipText(name);
                                listModel.addElement("•"+(SongCount+1) + ":" + name);
                                jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("voluomGif.gif")));
                                SongCount++;
                                
                            }
                        }
                        o++;
                    }
                }
            } catch (UnsupportedFlavorException | IOException ex) {
                ex.printStackTrace();
            } catch (JavaLayerException ex) {
                Logger.getLogger(player.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (state == DragState.Accept) {
            dtde.acceptDrag(DnDConstants.ACTION_COPY);
        } else {
            dtde.rejectDrag();
        }
    }

    @Override
    public void dragOver(DropTargetDragEvent dtde) {

    }

    @Override
    public void dropActionChanged(DropTargetDragEvent dtde) {

    }

    @Override
    public void dragExit(DropTargetEvent dte) {
        state = DragState.Waiting;

    }

    @Override
    public void drop(DropTargetDropEvent dtde) {
        state = DragState.Waiting;

    }
    




}
