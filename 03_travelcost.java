// Travelcost calculation from distance/gas consumption/price of gas
import java.util.Scanner;

class TravelCost {

    public static void main(String[] args) {
        double distance, consumption, price, cost;
        Scanner in = new Scanner(System.in);
        System.out.println("Give distance to take (in km):");
        distance = in.nextDouble();
        System.out.println("Give gas consumption of the car (in L/100km):");
        consumption = in.nextDouble();
        System.out.println("Give gas price (in €):");
        price = in.nextDouble();
        in.close();
        
        cost = distance * consumption * price / 100;
        System.out.printf("Total gas cost of the trip: €%5.2f\n",cost);
    }
    
}