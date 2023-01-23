package SemestralniPrace;
 /*semestralni prace cislo 10
 *program stavi snehulaka nebo testuje, zda zadane cislo je rovno sve soupisce
 *Tomas Koptik
 *21.01.2023
 */
import java.util.Scanner;

public class SP10 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            int choice = 0;
            System.out.println("Pro ukonceni programu napis 0");
            System.out.println("Pro vanocni ulohu napis jednicku");
            System.out.println("Pro semestralni praci napis dvojku");
            while (true) {
                if (sc.hasNextInt()) {
                    choice = sc.nextInt();
                    break;
                } else {
                    System.out.println("Spatny vstup! Zkus znova.");
                    sc.nextLine();
                }
            }
            if (choice == 0) {
                break;
            }
            switch (choice) {
                case 1:
                    do {
                        int option1 = 1;
                        System.out.println("Zadej velikost snehulaka (pouze licha cisla a aspon 5)");
                        int n = sc.nextInt();
                        System.out.println("Zadej z ceho bude klobouk");
                        char znak = sc.next().charAt(0);
                        System.out.println("Zadej z ceho bude snehulak");
                        char snih = sc.next().charAt(0);
                        System.out.println("Zadej z ceho budou oci");
                        char oko = sc.next().charAt(0);
                        final String ANSI_BLUE = "\u001B[34m";
                        final String ANSI_RESET = "\u001B[0m";
                        final String ANSI_PURPLE = "\u001B[35m";
                        final String ANSI_RED = "\u001B[31m";
                        if (n < 5) {
                            n = 5;
                        }
                        for (int i = 1; i < n; i++) {
                            System.out.print("           ");
                            for (int j = 1; j <= n; j++) {
                                System.out.print(ANSI_PURPLE + znak + ANSI_RESET);
                            }
                            System.out.println();
                        }
                        System.out.print("         " + ANSI_PURPLE + znak + ANSI_RESET);
                        for (int i = 1; i <= n + 3; i++) {
                            System.out.print(ANSI_PURPLE + znak + ANSI_RESET);
                        }
                        System.out.println();
                        System.out.print("           ");
                        for (int i = 1; i <= n; i++) {
                            System.out.print(snih);
                        }
                        System.out.println("           ");
                        for (int i = 0; i <= n; i++) {
                            if (i < 1) {
                                System.out.print("           " + snih);
                            } else if (i < 2) {
                                System.out.print(ANSI_BLUE + oko + ANSI_RESET);
                            } else if (i < n - 2) {
                                System.out.print(snih);
                            } else if (i < n - 1) {
                                System.out.print(ANSI_BLUE + oko + ANSI_RESET);
                            } else if (i < n) {
                                System.out.print(snih);
                            }
                        }
                        System.out.println("           ");
                        for (int i = 0; i <= n; i++) {
                            if (i < 1) {
                                System.out.print("           " + snih);
                            } else if (i < n / 2) {
                                System.out.print(snih);
                            } else if (i < n / 2 + 1) {
                                System.out.print(ANSI_RED + "I" + ANSI_RESET);
                            } else if (i < n) {
                                System.out.print(snih);
                            }
                        }
                        System.out.println("           ");
                        for (int i = 1; i < n - 3; i++) {
                            System.out.print("           ");
                            for (int j = 1; j <= n; j++) {
                                System.out.print(snih);
                            }
                            System.out.println();
                        }
                        for (int i = 1; i < n + 3; i++) {
                            System.out.print("         " + snih);
                            for (int j = 1; j <= n + 3; j++) {
                                System.out.print(snih);
                            }
                            System.out.println();
                        }
                        for (int i = 1; i < n + 5; i++) {
                            System.out.print("       " + snih);
                            for (int j = 1; j <= n + 7; j++) {
                                System.out.print(snih);
                            }
                            System.out.println();
                        }
                        System.out.println("Pro ukonceni zadej zaporne cislo nebo 0");
                        System.out.println("Pro pokracovani napis vetsi cislo nez 0");
                        option1 = sc.nextInt();
                        if (option1 <= 0) {
                            break;
                        }
                    } while (true);
                case default:
                    System.out.println("Spatny vstup! Zkus znova");
                    break;
                case 2:
                    long option = 1;
                    long number = 0;
                    long soupiska;
                    do {
                        System.out.println("Zadej cislo");
                        while (true) {
                            if (sc.hasNextLong()) {
                                number = sc.nextLong();
                                break;
                            } else {
                                System.out.println("Spatny vstup! Zkus znova.");
                                sc.nextLine();
                            }
                        }
                        long numberZaloha = number;
                        int length = pocetCifer(number);
                        //calculations 
                        long array[] = new long[length];
                        array = numberToArray(number);
                        soupiska = soupiska(array);
                        //out
                        System.out.println("Soupiska cisla " + numberZaloha + " je " + soupiska);
                        if (soupiska == numberZaloha) {
                            System.out.println("Cislo je zapisem sve soupisky");
                        } else {
                            System.out.println("Cislo neni zapisem sve soupisky");
                        }
                        System.out.println("Pro ukonceni programu zadej zapornou hodnotu nebo nulu");
                        System.out.println("Pro nove spusteni zadej vetsi cislo nez 0");
                        while (true) {
                            if (sc.hasNextLong()) {
                                option = sc.nextLong();
                                break;
                            } else {
                                System.out.println("Spatny vstup! Zkus znova.");
                                sc.nextLine();
                            }
                        }
                    } while (option > 0);
            }
        }

//test case jednotlivych metod
        //pocetCifer - input 4558, expected output 4, output 4
        //numberToArray - input 4558, expected outpout pole o 4 5 5 8, real output 4 5 5 8
        //soupiska - input 4558, expected outpout 142518, real outpout 142518
//    public static void main(String[] args) {
//    long cislo = 4558;
//    long cifra = pocetCifer(cislo);
//        System.out.println(cifra);
//        System.out.println();
//        
//    long array [] = new long [4];
//    array = numberToArray(cislo);
//        for (int i = 0; i < array.length; i++) {
//            System.out.print(array[i] + " ");
//        }
//            System.out.println();
//    
//    int soupiska = soupiska(array);
//        System.out.println(soupiska);
//    
//    }
    }
    /**
     * 
     * @parametr je cislo typu long
     * @return int, ktere predstavuje pocet cifer cisla
     */
    public static int pocetCifer(long number) {
        int length = 0;
        while (number > 0) {
            number = number / 10;
            length++;
        }
        return length;
    }

    /**
     * 
     * @parametr je cislo typu long
     * @return pole, kde na prislusnem indexu je dana cifra
     */
    public static long[] numberToArray(long number) {
        int length = pocetCifer(number);
        long array[] = new long[length];
        for (int i = 0; i < array.length; i++) {
            array[array.length - i - 1] = number % 10;
            number = number / 10;
        }
        return array;
    }

    /**
     * 
     * @parametr je pole typu long
     * @return cislo, ktere na lichych pozicich predstavuje pocet dane cifry
     * a na sudych danou cifru
     */
    public static long soupiska(long array[]) {
        long soupiska = 0;
        long count = 0;
        long multiple = 10;
        for (int i = 9; i >= 0; i--) {
            for (int j = 0; j < array.length; j++) {
                if (array[j] == i) {
                    count++;
                }
            }
            if (count > 0) {
                soupiska = soupiska + count * multiple + i * multiple / 10;
                count = 0;
                multiple = multiple * 100;
            }
        }
        return soupiska;
    }
}

