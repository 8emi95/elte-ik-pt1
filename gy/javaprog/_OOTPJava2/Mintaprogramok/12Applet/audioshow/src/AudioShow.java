/*
 * Mintaprogramok/12. fejezet
 * Projekt: audioshow
 * AudioShow.java
 *
 * Angster Erzsébet: OO tervezés és programozás, Java II. kötet
 * 2005.01.10.
 */

import java.awt.*;
import javax.swing.*;
import java.applet.*;
import java.awt.event.*;
import java.net.*;

public class AudioShow extends JApplet implements ActionListener {
  Container cp = getContentPane();
  JButton btSdp = new JButton("Go to SDP-city");
  JLabel lbInfo = new JLabel("",JLabel.CENTER);
  JButton btStart = new JButton("Start");
  JButton btStop = new JButton("Stop");
  AudioClip ac;
  boolean on = false;

  public void init() {
    ac = getAudioClip(getCodeBase(),"esobot.wav");
    btSdp.setBackground(Color.WHITE);
    lbInfo.setFont(new Font("Dialog",Font.PLAIN,15));
    cp.add(lbInfo);

    JPanel pnControl = new JPanel();
    cp.add(pnControl,"Center");
    pnControl.add(btStart);
    pnControl.add(btStop);
    pnControl.add(btSdp);
    btSdp.addActionListener(this);
    btStart.addActionListener(this);
    btStop.addActionListener(this);
  }

  void sound() {
    on = true;
    lbInfo.setText("Esik az esõ");
    ac.loop();
  }

  void noSound() {
    on = false;
    lbInfo.setText("Süt a nap");
    ac.stop();
  }

  public void start() {
    if (on) ac.loop();
  }

  public void stop() {
    if (on) ac.stop();
  }

  public void actionPerformed(ActionEvent ae) {
    if (ae.getSource()==btStart)
      sound();
    else if (ae.getSource()==btStop)
      noSound();
    else if (ae.getSource()==btSdp) {
      try {
        getAppletContext().showDocument(new URL("http://sdp-city.hu"));
      }
      catch (MalformedURLException me) {
        showStatus(""+me);
      }
    }
  }
}
