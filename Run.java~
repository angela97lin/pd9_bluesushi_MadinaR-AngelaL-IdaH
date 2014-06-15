import javax.swing.*;
import java.awt.*;

public class Run{
    
    public static String title = "BlueStuff";
    public static Dimension size = new Dimension(1000,700);
    public static JFrame driver;
    
    public Run(){
	driver = new JFrame("Driver Frame");
	driver.setTitle(title);
	driver.setSize(size);
	driver.setResizable(false);
	driver.setLocationRelativeTo(null);
	driver.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	driver.setLayout(new GridLayout(1,1,0,0));
	init();
    }

    public void init(){
	GamePlay screen = new GamePlay(this);
	driver.add(screen);
	driver.setVisible(true);
	

	
    }

    public static void main(String[]args){
	Run game = new Run();
    }


}
