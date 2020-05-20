public class NBody {
	public static double readRadius(String filename) {
		In in = new In(filename);
		int discardItem = in.readInt();
		return in.readDouble();
	}

	public static Body[] readBodies(String filename) {
		In in = new In(filename);
		int numOfBodies = in.readInt();
		Body[] bodies = new Body[numOfBodies];
		double discardItem2 = in.readDouble();

		int index = 0;
		while(index < numOfBodies) {
			double xP  = in.readDouble(), yP = in.readDouble();
			double xV  = in.readDouble(), yV = in.readDouble();
			double m   = in.readDouble();
			String img = in.readString();
			bodies[index++] = new Body(xP, yP, xV, yV, m, img);
		}
		return bodies;
	}

	public static void main(String[] args) {
		double time = 0; 

		// Collecting All Needed Input
		double T = Double.valueOf(args[0]), dt = Double.valueOf(args[1]);
		String filename = args[2];
		Body[] bodies = readBodies(filename);

		int numOfBodies = bodies.length;

		StdDraw.enableDoubleBuffering();
		double radius = readRadius(filename);
		StdDraw.setScale(- radius, radius);
		

		while(time < T) {
			// create xForces and yForces arrays
			double[] xForces = new double[numOfBodies];
			double[] yForces = new double[numOfBodies];

			// calculate the net x and y forces for each body, store them respectively
			for(int i = 0; i < numOfBodies; i++) {
				Body curBody = bodies[i];
				double curForceX = 0, curForceY = 0;
				for(int j = 0; j < numOfBodies; j++) {
					if(j != i) {
						curForceX += curBody.calcForceExertedByX(bodies[j]);
						curForceY += curBody.calcForceExertedByY(bodies[j]);
					}
					
				}
				xForces[i] = curForceX;
				yForces[i] = curForceY;
			}

			// update each body's position, velocity and acceleration
			for(int i = 0; i < numOfBodies; i++) bodies[i].update(dt, xForces[i], yForces[i]);


			// Draw the background image.
			StdDraw.picture(1, 1, "images/starfield.jpg", radius * 2, radius * 2);

			// Draw all of the Bodies
			for(Body body : bodies) body.draw();

			// show the offscreen buffer
			StdDraw.show();

			// pause the animation for 10 ms
			StdDraw.pause(10);

			// increase time by dt
			time += dt;

		}
		StdOut.printf("%d\n", bodies.length);
		StdOut.printf("%.2e\n", radius);
		for (int i = 0; i < bodies.length; i++) {
		    	StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                bodies[i].xxPos, bodies[i].yyPos, bodies[i].xxVel,
              	bodies[i].yyVel, bodies[i].mass, bodies[i].imgFileName);   
		}


	}
}