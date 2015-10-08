/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asyncSwing;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JTextField;

/**
 *
 * @author samuraipanzer
 */
public class ThreadList implements Runnable{
  
  private JList jList1;
  private String text;

  public ThreadList(JList jList, String text) {
	this.jList1 = jList;
	this.text = text;
  }
  
  @Override
  public void run() {
	try {
	  Random rand = new Random();
	  int time = this.randInt(1, 20) * 1000;
	  Thread.sleep(time);
	  DefaultListModel<String> model = (DefaultListModel<String>) jList1.getModel();
	  model.addElement(this.text);
	  jList1.setModel(model);
	} catch (InterruptedException ex) {
	  Logger.getLogger(ThreadList.class.getName()).log(Level.SEVERE, null, ex);
	}
  }
  
  /**
  * Returns a psuedo-random number between min and max, inclusive.
  * The difference between min and max can be at most
  * <code>Integer.MAX_VALUE - 1</code>.
  *
  * @param min Minimim value
  * @param max Maximim value.  Must be greater than min.
  * @return Integer between min and max, inclusive.
  * @see java.util.Random#nextInt(int)
  */
  private int randInt(int min, int max) {

	  // Usually this can be a field rather than a method variable
	  Random rand = new Random();

	  // nextInt is normally exclusive of the top value,
	  // so add 1 to make it inclusive
	  int randomNum = rand.nextInt((max - min) + 1) + min;

	  return randomNum;
  }
  
}
