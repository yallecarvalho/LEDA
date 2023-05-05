package forma;

/*
 * @author yallecarvalho
 */

public class Main {

		public static double l1 = 1.0;
		public static double l2 = 3.0;
		
	public static void main(String[] args) {
			
		 Retangulo r = new Retangulo(l1, l2);
		 System.out.println("Área do retângulo: " + r.area());
		 
		 Quadrado q = new Quadrado(l1);
		 System.out.println("Área do quadrado: " + q.area());
		 
		 Triangulo t = new Triangulo(l1, l2);
		 System.out.println("Área do triângulo: " + t.area());
		 
		 Circulo c = new Circulo(l2);
		 System.out.println("Área do triângulo: " + c.area());
		
		 
		 }
}

