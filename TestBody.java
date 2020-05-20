
public class TestBody {
	public static void test1() {
		Body sun 	= new Body(1e12, 2e11, 0, 0, 2e30, "sun.gif");
		Body saturn = new Body(2.3e12, 9.5e11, 0, 0, 6e26, "saturn.gif");

		System.out.println("The net force exerted between is " 
			+ sun.calcForceExertedBy(saturn) + ", reversely: "
			+ saturn.calcForceExertedBy(sun));
	}
	public static void main(String[] args) {
		test1();
	}
}