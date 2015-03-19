import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Car extends JButton implements ActionListener {
	ImageIcon X,car1, car2;
	byte value = 0;
	// 0 nothing //1 car1 //2 car2
	
	public Car(){
		X= new ImageIcon(this.getClass().getResource("X.png"));
		//car1= new ImageIcon(this.getClass().getResource("carimage"));
		//car1= new ImageIcon(this.getClass().getResource("carimage2"));
		this.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e){
		value++;
		value%=3; //if its more than or equal to subtract 3 from it
		switch(value){
		case 0:
			setIcon(null);
			break;
		case 1:
			setIcon(X);
			break;
		case 2:
			setIcon(X);
			break;
		}
	}

}//class


