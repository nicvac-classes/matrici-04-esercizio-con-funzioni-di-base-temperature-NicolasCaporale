//LEGGERE LE ISTRUZIONI NEL FILE README.md

import java.util.Scanner;
import java.util.Random;

// Classe principale, con metodo main
class Esercizio {

    public static Scanner in = new Scanner( System.in );
    public static Random random = new Random();

    //Valori multipli di ritorno per il metodo calcolaMassimo
    public static record Max(int massimo, int rIdx, int cIdx) { }

    public static Max calcolaMassimo(int[][] M, int RIGHE, int COLONNE) {
        int r = 0;
        int c = 0;
        for (int i = 0; i < RIGHE; i++) {
            for (int j = 0; j < COLONNE; j++) {
                if (M[i][j] > M[r][c]) {
                    r = i;
                    c = j;
                }
            }
        }
        return new Max(M[r][c], r, c);
    }

    public static float calcolaMedia(int[][] M, int RIGHE, int COLONNE, int col) {
        int somma = 0;
        for (int i = 0; i < RIGHE; i++) {
            somma += M[i][col];
        }
        return (float) somma / RIGHE;
    }

    // Metodo per riempire la matrice con valori casuali
    // Già risolto nell'esercizio precedente
    public static void riempiCasuale( int[][] M, int RIGHE, int COLONNE, int valMin, int valMax) {
        Random rand = new Random();
        for (int i=0; i <= RIGHE-1; i=i+1 ) {
            for (int j=0; j <= COLONNE-1; j=j+1) {
                M[i][j] = valMin + rand.nextInt((valMax+1)-valMin);
            }
        }
    }

    public static void main(String args[]) {
        int GIORNI = 7;
        int ORE = 5;

        int[][] T = new int[GIORNI][ORE];

        riempiCasuale(T, GIORNI, ORE, 280, 300);

        System.out.println("tabella:");
        for (int i = 0; i < GIORNI; i++) {
            System.out.print("[");
            for (int j = 0; j < ORE; j++) {
                System.out.print(T[i][j]);
                if (j < ORE - 1) System.out.print(" ");
            }
            System.out.println("]");
        }

        Max m = calcolaMassimo(T, GIORNI, ORE);

        System.out.println("massimo: " + m.massimo());
        System.out.println("giorno: " + (m.rIdx() + 1));
        System.out.println("fascia: " + (m.cIdx() + 1));

        System.out.println("medie:");
        for (int j = 0; j < ORE; j++) {
            System.out.print(calcolaMedia(T, GIORNI, ORE, j) + " ");
        }
        System.out.println();
    }
}