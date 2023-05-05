package forma;

public class Circulo implements Forma {

	 private double raio;
	 
	 public Circulo(double raio) {
		 super();
		 this.raio = raio;
	 }
	 
	 @Override
	 public double area() {
		 double area = Math.PI * raio;
		 return area;
	 }
}
