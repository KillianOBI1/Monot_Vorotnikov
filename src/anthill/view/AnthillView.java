package anthill.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import anthill.model.Ant;
import anthill.model.Anthill;

public class AnthillView {

  private JFrame frame;

  /**
   * Launch the application.
   */
  public static void main(String[] args) {
    Random r = new Random();
    AntsWorld antsWorld = new AntsWorld(10);
    JPanel actionField = antsWorld;
    actionField.setBackground(Color.WHITE);    
    int x = 115;
    int y = 115;
    Ant q = new Ant();
    Anthill myAnthill = new Anthill(q);
    
    for (Ant a : myAnthill.listAnt) {
      System.out.println(a.getState());
      antsWorld.add(new AntView(a.getState().getRole().getPosition(), new Dimension(9, 9)));
      a.getState().getRole().move();
    }
    
    AnthillView window = new AnthillView();
  
    window.frame.getContentPane().add(actionField, BorderLayout.CENTER);
    
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {          
          window.frame.setVisible(true);
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    });
        
    while (true) {
//      List<MovableDrawable> drawables = antsWorld.contents();
//      for (Iterator<MovableDrawable> iter = drawables.iterator(); iter.hasNext();) {
////        Boolean nextStep = r.nextBoolean();
////        if (nextStep) {
////          x += 10;
////        } else {
////          x -= 10;
////        }
//        iter.next().setPosition());
//      }
//      try {
//        Thread.sleep(500);
//      } catch (InterruptedException e) {
//        e.printStackTrace();
//      }
      antsWorld.repaint();
    }
  }

  /**
   * Create the application.
   */
  public AnthillView() {
    initialize();
  }

  /**
   * Initialize the contents of the frame.
   */
  private void initialize() {
    frame = new JFrame();
    frame.setBounds(650, 200, 600, 600);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.getContentPane().setLayout(new BorderLayout(0, 0));
    
    JMenuBar menuBar = new JMenuBar();
    frame.getContentPane().add(menuBar, BorderLayout.NORTH);
    
    JMenu mnFile = new JMenu("File");
    menuBar.add(mnFile);
    
    JMenuItem mntmExit = new JMenuItem("Exit");
    mntmExit.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        System.exit(JFrame.EXIT_ON_CLOSE);
      }
    });
    mnFile.add(mntmExit);
    
    JMenu mnHelp = new JMenu("Help");
    menuBar.add(mnHelp);
    
    JPanel statusBar = new JPanel();
    statusBar.setBorder(new EmptyBorder(5, 5, 5, 5));
    frame.getContentPane().add(statusBar, BorderLayout.SOUTH);
    statusBar.setLayout(new BorderLayout(5, 5));
    
    JLabel lblStatus = new JLabel("Status :");
    lblStatus.setHorizontalAlignment(SwingConstants.LEFT);
    statusBar.add(lblStatus);
    
    JPanel panelLeft = new JPanel();
    frame.getContentPane().add(panelLeft, BorderLayout.WEST);
    
    JPanel panelRight = new JPanel();
    frame.getContentPane().add(panelRight, BorderLayout.EAST);
  }

}
