package anthill.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
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
import anthill.observer.Observer;
import anthill.visitor.Visitor;
import anthill.model.roles.Queen;
import anthill.model.states.Adult;


public class AnthillWorldView {

  private JFrame frame;

  /**
   * Launch the application.
   */
  public static void main(String[] args) {
    Random r = new Random();
    Visitor v = new Visitor();
    AntsWorld antsWorld = new AntsWorld(10);
    JPanel actionField = antsWorld;
    actionField.setBackground(Color.WHITE);    
    int x = 0;
    int y = 0;
    Ant q = new Ant();
    q.state = new Adult(new Queen());
    System.out.println(q.state.getRole().ifQueen(q).getPosition());
    Anthill myAnthill = new Anthill(q);
    myAnthill.listAnt.add(new Ant());
    myAnthill.listAnt.add(new Ant());
    Observer o = new Observer();
    World w = new World(antsWorld,myAnthill);
    w.init();
    for (Ant a : myAnthill.listAnt) {
      Calendar cal = Calendar.getInstance();
      cal.set(2017, 10, 05);
      a.setDateStart(cal.getTime());
      a.notifyToObserverEvol(myAnthill);
      a.notifyToObserverEvol(myAnthill);
      a.notifyToObserverEvol(myAnthill);
      Point antPos = a.getState().getRole().getPosition();
      antsWorld.addAnthill(new AnthillView(myAnthill.getPosition(), new Dimension(30,30)));
      antsWorld.addAnt(new AntView(antPos, new Dimension(10, 10)));
      if (a.state.getRole().toString(a).equals("Worker")) {
        a.state.getRole().ifWorker(a).registerObserver(w);
      }
    }

    AnthillWorldView window = new AnthillWorldView();
    
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
      List<MovableDrawable> drawables = antsWorld.contents();
      int i = 0;
      for (Ant a : myAnthill.listAnt) {
        Point antPos = a.getState().getRole().getPosition();
        a.getState().getRole().move();
        v.visit(a);
        x = antPos.x;
        y = antPos.y;
        drawables.get(i).setPosition(new Point(x,y));
        i++;
      }
      
      try {
        Thread.sleep(50);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      antsWorld.repaint();
    }
    
  }

  /**
   * Create the application.
   */
  public AnthillWorldView() {
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
