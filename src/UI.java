import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class UI {
	public UI() {
		JFrame frame = new JFrame();
		frame.setVisible(true);
		frame.setSize(1200, 700);
		createTheGridLayoutsAndSegments(frame);
	}
	public void createTheGridLayoutsAndSegments(JFrame f) {
		GridLayout myGRID = new GridLayout(20,20);
		f.setLayout(myGRID);
		 try {
	           BufferedImage segmentation = ImageIO.read(new File("Resources/segmentation.png"));
	           JLabel label = new JLabel(new ImageIcon(segmentation));
	           f.getContentPane().add(label);

		 } catch (IOException ex) {
	            System.out.println(ex.getMessage());
		 }
	}
	public void populateAndGridUp(){
		Grid left = new Grid(10,10);
		Grid right = new Grid(10,10);
		
	}
}
