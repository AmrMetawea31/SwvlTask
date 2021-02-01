import java.util.Scanner;

public class Swvl2 {
	

public static void main (String[] args) {
Point A = new Point ("A", 4, 5);
Point B = new Point ("B", 5, 3);
Point C = new Point ("C", 6, 5);
Point D = new Point ("D", 7, 5);
Point E = new Point ("E", 9, 3);
Point [] route1 =  {A, B, C, D, E};

Point F = new Point ("F", 2, 4);
Point G = new Point ("G", 4, 1);
Point H = new Point ("H", 8, 3);
Point I = new Point ("I", 8, 5);
Point [] route2 = {F, G, H, I};

Scanner sc = new Scanner(System.in);

System.out.println("Please enter number of stops : ");
  int row = sc.nextInt();
  Point [] route3 = new Point[row];
  
  
 fillingMatrix(sc, route3, row);
 
 findRoute(route1, route2, route3);
 
 
}

public static void fillingMatrix(Scanner scan, Point route3[], int rows)
{
   
   for(int a = 0; a < rows; a++)
   {
	   
	   route3[a]=new Point();
	   System.out.println("Please enter your stop's name : ");
	   route3[a].setName(scan.next());
	   System.out.println("Please enter your X-coordinates : ");
	   route3[a].setX(scan.nextInt());
	   System.out.println("Please enter your Y-coordinates : ");
	   route3[a].setY(scan.nextInt());
	         
   }
     
}

public static void findRoute(Point route1[], Point route2[], Point route3[]) {
	
	String [] route4  = new String[route3.length];
	for(int k =0; k<route3.length; k++) {
		double tmp = 10000.0;
						
			int x3 = route3[k].getX();
			int y3 = route3[k].getY();
	
		for(int i =0; i<route1.length; i++) {
			
				int x1 = route1[i].getX();
				int y1 = route1[i].getY();
			
		double d1 = Math.sqrt(Math.pow(x3-x1,2)+ Math.pow(y3-y1,2));
		
		if(d1<tmp) {
			tmp = d1;
			 route4[k] = route1[i].getName();
		}

		
		if(route2.length > i) {
			int x2 = route2[i].getX();
			int y2 = route2[i].getY();

			double d2 = Math.sqrt(Math.pow(x3-x2,2)+ Math.pow(y3-y2,2));
			
			if(d2<tmp) {
				tmp = d2;
				  route4[k] = route2[i].getName();
				
			}

		}
			
	}
			

		}
	for(int i = 0; i< route4.length; i++) {
		System.out.println(route3[i].getName() + "\t" + route4[i]);
	}
	
}


}