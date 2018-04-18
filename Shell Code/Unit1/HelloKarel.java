import edu.fcps.karel2.Display;
import edu.fcps.karel2.Robot;
public class HelloKarel
{
   public static void main(String[] args)
	{
	   Display.setSize(10,10);
		Robot karel = new Robot();
		karel.move();
		karel.turnLeft();
		karel.move();
	}
}