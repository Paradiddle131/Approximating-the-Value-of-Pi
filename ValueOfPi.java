import processing.core.PApplet;

public class ValueOfPi extends PApplet{
	double r = 250;
	int total = 0; // total dots
	int circle = 0; // total dots in the circle

	double recordPI;

	public void settings() {
		size(502, 502);
	}
	
	public void setup() {
	  background(0);
	  translate(width/2, height/2);
	  stroke(255);
	  noFill();
	  strokeWeight(4);
	  ellipse(0, 0, (float)r*2, (float)r*2);
	  rectMode(CENTER);
	  rect(0, 0, (float)r*2, (float)r*2);
	}

	public void draw() {
	  translate(width/2, height/2);
	  //double pi = 0;
	  for (int i=0; i<10000; i++) {
	    double x = random((float)-r, (float)r);
	    double y = random((float)-r, (float)r);
	    total++;

	    double d = (double)x*(double)x+(double)y*(double)y; // how far fr center
	    if (d<(double)r*(double)r) {
	      circle++;
	      stroke(0, 255, 0, 100);
	    } else {
	      stroke(255, 0, 0, 100);
	    }
	    strokeWeight((float) 0.1);
	    point((float)x, (float)y);

	    double pi = (double)4*((double)(circle)/(double)total);
	    double recordDiff = Math.abs(Math.PI - recordPI);
	    double diff = Math.abs(Math.PI - pi);
	    if (diff<recordDiff) {
	      recordDiff = diff;
	      recordPI = pi;
	      println(recordPI);
	    }
	    //println(pi);
	  }
	}
	
public static void main(String[] args) {
	PApplet.main("ValueOfPi");
}
}
