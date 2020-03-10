public class positionTTT {

	int x;
	int y;
	int state;
	
	//Construct position with all argument 
	public positionTTT(int setX, int setY, int setState)
	{
		this.x = setX;
		this.y = setY;
		this.state = setState;
	}
	
	////Construct position with only X and Y argument
	public positionTTT(int setX, int setY)
	{
		this.x = setX;
		this.y = setY;
		this.state = 0;
	}
	
	//Help with printing for debugging
	public void printPositionTTT()
	{
		System.out.print("("+x+","+y+")");
		System.out.println("state: "+state);
	}
}
