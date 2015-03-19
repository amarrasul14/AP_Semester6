import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JPanel;
import javax.swing.JFrame;

public class GUI extends JFrame {
	JPanel p = new JPanel();
	Car buttons[]=new Car[8];
	
	
	public GUI(){
		super("GUI");
		setSize(400,400);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		p.setLayout(new GridLayout(3,3));
		for(int i=0; i < 9; i++){
			buttons[i]= new Car();
			p.add(buttons[i]);
		}
		add(p);
		setVisible(true);
	}
	
	public static void main (String args[]){
		new GUI();
		
	}
}
