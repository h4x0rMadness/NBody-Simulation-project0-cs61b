public class Body {
	public double xxPos;
	public double yyPos;
	public double xxVel;
	public double yyVel;
	public double mass;
	public String imgFileName;
	public static final double G = 6.67e-11;
	public Body(double xP, double yP, double xV, double yV, double m, String img) {
		xxPos 		= xP;
		yyPos 		= yP;
		xxVel 		= xV;
		yyVel 		= yV;
		mass 		= m;
		imgFileName = img;
	}
	public double calcDistance(Body b) {
		double xP = b.xxPos, yP = b.yyPos;
		return Math.sqrt((xP - xxPos) * (xP - xxPos) + (yP - yyPos) * (yP - yyPos));
	}

	public double calcForceExertedBy(Body b) {
		double distance = calcDistance(b);
		return G * mass * b.mass / (distance * distance);
	}

	public double calcForceExertedByX(Body b) {
		double distance = calcDistance(b);
		double force = calcForceExertedBy(b);
		return force * (b.xxPos - xxPos) / distance;
	}

	public double calcForceExertedByY(Body b) {
		double distance = calcDistance(b);
		double force = calcForceExertedBy(b);
		return force * (b.yyPos - yyPos) / distance;
	}

	public void update(double dt, double fX, double fY) {
		double accnet_x = fX / mass, accnet_y = fY / mass;
		xxVel  = xxVel + dt * accnet_x;
		yyVel = yyVel + dt * accnet_y;
		xxPos = xxPos + dt * xxVel;
		yyPos = yyPos + dt * yyVel;
	}

	public void draw() {
		StdDraw.picture(xxPos, yyPos, "images/" + imgFileName);
	}

	public Body(Body b) {
		xxPos = b.xxPos;
		yyPos = b.yyPos;
		xxVel = b.xxVel;
		yyVel = b.yyVel;
		mass = b.mass;
		imgFileName = b.imgFileName;
	}


}