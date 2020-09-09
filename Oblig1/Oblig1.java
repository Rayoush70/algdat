package no.oslomet.cs.algdat.Oblig1;

////// Løsningsforslag Oblig 1 ////////////////////////

import java.lang.UnsupportedOperationException;
import java.util.NoSuchElementException;

public class Oblig1 {
    private Oblig1() {}

    ///// Oppgave 1 //////////////////////////////////////

    public static int maks(int[] a) {
        final String NO_SUCH_ELEMENT_EXCEPTION_MESSAGE = "Det ser ut til at det ikke er " +
                "noen elementer i den gittende matrisen";

        int Størsteverdi = 0;


        if (a.length < 1){

            throw new NoSuchElementException(NO_SUCH_ELEMENT_EXCEPTION_MESSAGE);
        }


        else if (a.length == 1){
            Størsteverdi = a[0];
        }


        for (int i = 1; i < a.length; i++){
            if(a[i] < a[i-1]){
                int temp = a[i];
                a[i] = a[i-1];
                a[i-1] = temp;
            }

            Størsteverdi = a[i];
        }

        return Størsteverdi;
    }


    public static int ombyttinger(int[] a) {
        int teller = 0;

        for (int i = 1; i < a.length; i++){
            if (a[i] < a[i-1]){
                teller++;

                int temp = a[i];
                a[i] = a[i-1];
                a[i-1] = temp;
            }
        }
        return teller;
    }
            /*
        svar:
         Blir flest ombyttinger om arrayet er sortert ( fra minst til størst).
        blir færrest når lista er sortert (fra størst til minst)

         */




    ///// Oppgave 2        Antall ulike (sortert)  //////////////////////////////////////


    public static int antallUlikeSortert(int[] a) {
        final String ILLIGALSTATE_EXCEPTION_MESSAGE = "Array må sorteres for bruk av denne metoden";

        int teller = 1;

        if (a.length == 0){
            teller = 0;
        }

        for(int i = 1; i < a.length; i++){
            if (a[i] < a[i-1]){
                throw new IllegalStateException(ILLIGALSTATE_EXCEPTION_MESSAGE);
            }

            if ( a[i-1] != a[i]){
                teller++;
            }
        }
        return teller;
    }







    ///// Oppgave 3 //////////////////////////////////////

    public static int antallUlikeUsortert(int[] a) {
        throw new UnsupportedOperationException();
        int teller = 0;

        if (a.length == 0){
            teller = 0;
        }

        for (int i = 0; i < a.length; i++){
            boolean unik = false;

            for (int j = 0; j < i; j++){
                if (a[j] == a[i]){
                    unik = true;
                    break;
                }
            }
            if (!unik){
                teller++;
            }
        }

        return teller;
    }

    }

    ///// Oppgave 4 //////////////////////////////////////

        public static void delsortering(int[]a) {
        throw new UnsupportedOperationException();
            // Her skal vi instansjere de trengende verdiene og hjelpe variabler.
            int aLength = a.length;
            int oddetallene = 0;
            int temp = 0;
            int o = 0;

            quickSort(a, 0, aLength-1); //sortere listen

            for(int i = 0; i < aLength; i++){

                if (a[i]%2 == 0){     //Sjekker om at tallet er partall!
                    if (a[i] == 0){
                        o++;
                    }
                }

                else {
                    temp = a[i];
                    a[i] = a[oddetallene];
                    a[oddetallene] = temp;
                    oddetallene++;
                }
            }
            //Sortere partallene separat.
            quickSort(a, aLength-oddetallene-o, aLength-1);
        }

        //Implementerer metode for quicksort med left og right pekere!
        public static void quickSort(int[]a, int l, int r){
            if (l < r) {
                int partitionIndex = partition(a, l, r);

                //Bruker rekursjon til å sortere
                quickSort(a, l, partitionIndex - 1);
                quickSort(a, partitionIndex + 1, r);
            }
        }

        //Deler og returnerer delingsindeksen
        public static int partition(int[] a, int begin, int end){

            //Bruker pivoten til å dividere listen inn til to lister.
            int pivot = a[end];

            //instansierer i til posisjonen bak starten av arrayet
            int i = (begin-1);

            for (int j = begin; j < end; j++) {
            /* sjekker om nåværende posisjon til arrayet er mindre enn pivoten
             og endrer partiationIndexen +1 og flytter deretter
             tall på riktig plass */

                if (a[j] < pivot) {
                    i++;
                    int swapTmp = a[i];
                    a[i] = a[j];
                    a[j] = swapTmp;
                }
            }

            //vi bytter til slutt om posisjonen til neste og siste ledd!
            int swapTmp = a[i+1];
            a[i+1] = a[end];
            a[end] = swapTmp;
            //returnerer indexen!
            return i+1;
        }




    }

    ///// Oppgave 5 //////////////////////////////////////
    public static void rotasjon(char[] a) {
        throw new UnsupportedOperationException();

        int aLength = a.length;
        int d = 1;
        if (aLength == 1 || aLength == 0) {
        System.out.println(Arrays.toString(a));
        }

        int n = aLength;
        if (n < 2) {
        return;
        }

        if ((d %= n) < 0) {
        d += n;
        }

        char[] b = Arrays.copyOfRange(a, n - d, n);
        for (int i = n - 1; i >= d; i--) {
        a[i] = a[i - d];
        }

        System.arraycopy(b, 0, a, 0, d);

        System.out.println(Arrays.toString(a));
        }

    }

    ///// Oppgave 6 //////////////////////////////////////
    public static void rotasjon(char[] a, int k) {
        throw new UnsupportedOperationException();
    }

    ///// Oppgave 7 //////////////////////////////////////
    /// 7a)
    public static String flett(String s, String t) {
        throw new UnsupportedOperationException();
    }

    /// 7b)
    public static String flett(String... s) {
        throw new UnsupportedOperationException();
    }

    ///// Oppgave 8 //////////////////////////////////////
    public static int[] indekssortering(int[] a) {
        throw new UnsupportedOperationException();
    }

    ///// Oppgave 9 //////////////////////////////////////
    public static int[] tredjeMin(int[] a) {
        throw new UnsupportedOperationException();
    }

    ///// Oppgave 10 //////////////////////////////////////
    public static int bokstavNr(char bokstav) {
        throw new UnsupportedOperationException();
    }

    public static boolean inneholdt(String a, String b) {
        throw new UnsupportedOperationException();
    }

}  // Oblig1
