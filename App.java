import java.awt.*;
import java.awt.geom.*;
import java.awt.font.*;
import javax.swing.*;

public class App extends JPanel{

static int angdeg=0;

// importing paint method to use Graphics library

public void paint(Graphics g){

    // creating 2D graphic object
    Graphics2D g2d = (Graphics2D) g;
    g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,  RenderingHints.VALUE_ANTIALIAS_ON); 


    //setting backgroundcolor
    g2d.setColor(Color.blue); 


    //to remove trail of painting
    g2d.fillRect(0,0,getWidth(),getHeight());

    // creating font
    Font font =  new Font("Algerian",Font.CENTER_BASELINE,300);
    g2d.setFont(font);  
    
    //setting font of surface
    FontRenderContext frc = g2d.getFontRenderContext();
    TextLayout layout = new TextLayout("9", font, frc);

    //getting width & height of the text
    double sw = layout.getBounds().getWidth();
    double sh = layout.getBounds().getHeight();

    //getting original transform instance
    AffineTransform saveTransform=g2d.getTransform();
    //main color
    
    g2d.setColor(Color.white);
    Rectangle rect = this.getBounds();

    //drawing the axis
    // g2d.drawLine((int)(rect.width)/2,0,(int)(rect.width)/2,rect.height);
    // g2d.drawLine(0,(int)(rect.height)/2,rect.width,(int)(rect.height)/2);

    /*creating instance set the translation to the mid of the component*/
    AffineTransform affineTransform = new AffineTransform();
    affineTransform.setToTranslation((rect.width)/2,(rect.height)/2);

    //rotate with the anchor point as the mid of the text
    affineTransform.rotate(Math.toRadians(angdeg), 0, 0);
    g2d.setTransform(affineTransform);
    g2d.drawString("9",(int)-sw/2,(int)sh/2);

    //restoring original transform
    g2d.setTransform(saveTransform);
}

public static void main(String[] args) throws Exception{
    JFrame frame = new JFrame("ADS21B00213Y - SEM PROJECT 1");

    App rt = new App();


    frame.add(rt);

    frame.setSize(500, 500);

    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    frame.setLocationRelativeTo(null);

    frame.setVisible(true);
    for(;;){
        Thread.sleep(50);
        
        //sleeping then increasing angle by 1
        angdeg=(angdeg>=-360)?0:angdeg+9;

        //repainting the surface
        rt.repaint();
    }
  }
}

/* 
 * INTRODUCTION
 * TOOLS
 * SYSTEM REQUIREMENT
 * DEVELOPMENT PROCESS
 */