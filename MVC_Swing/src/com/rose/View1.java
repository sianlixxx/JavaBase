package com.rose;

/* file: View1.java */
import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;
public class View1 extends JPanel implements Observer
{
   Model model;

   public View1()
   {
   }
   public View1(Model model)
   {
       try
       {
           this.model = model;
           jbInit();
       }
       catch(Exception e)
       {
           e.printStackTrace();
       }
   }
   private void jbInit() throws Exception
   {
       this.setBackground(Color.white);
       this.setBorder(new TitledBorder(BorderFactory.createLineBorder(Color.black,1),"View1"));
   }

   public void paintComponent(Graphics g)
   {
       super.paintComponent(g);
       if ( model == null ) return;
       int x = 20,y = 50;
       int h = g.getFontMetrics().getHeight();
       for ( int i=0; i< model.size(); i++ )
       {
           Data data = model.getData(i);
           g.drawString(data.name,x,y);
           y+=h;
           g.drawString(String.valueOf(data.value),x,y);
           y+=h;
       }
   }
   // 当模型数据发生改变时，会自动调用此方法来刷新图形
   public void dataUpdate(Model model)
   {
       /**@todo: Implement this Observer method*/
       this.model = model;
       repaint();
   }
}
