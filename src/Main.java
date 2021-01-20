import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        boolean a = true;
        boolean b;
        boolean c;
        boolean d;


	Recursion test = new Recursion();

        Scanner in = new Scanner(System.in);

        String name = null;
        int svar = 0;

        while(a){
            b= true;
            c=true;
            d= true;

            while (d){
                System.out.println("Vill du kolla nissarnas chefer eller underordnade?");
                System.out.println("1. Chefer");
                System.out.println("2. Underordnade");

                svar = in.nextInt();
                if (svar == 1 || svar == 2){
                    d = false;
                }else {
                    System.out.println("Försök igen!");
                }
            }


            while (b){
                System.out.println("Välj en nisse: ");
                for (int i = 0; i < test.tomteverkstaden.size(); i++) {
                    System.out.println(test.tomteverkstaden.get(i).name);
                }

                name = in.next();

                boolean foundYou = false;

                for (int i = 0; i < test.tomteverkstaden.size(); i++) {
                    if (test.tomteverkstaden.get(i).getName().equalsIgnoreCase(name)) {
                        foundYou = true;
                        name = test.tomteverkstaden.get(i).getName();
                        break;
                    }
                }

                if (foundYou){
                    b = false;
                }else {
                    System.out.println("Försök igen!");
                }
            }




                if (svar == 1){
                        test.RecursionMethodUp(name);
                }else if (svar == 2){
                    test.RecursionMethodDown(name);
                }

                
                while (c){
                    System.out.println("Igen? Ja/Nej");
                    String answer = in.next();
                    if (answer.equalsIgnoreCase("Ja")){
                        c = false;
                    }else if (answer.equalsIgnoreCase("Nej")){
                        c = false;
                        a = false;
                    }else {
                        System.out.println("Försök igen!");
                    }
                }


        }

        System.out.println("Hej då!");
       




    }
}
