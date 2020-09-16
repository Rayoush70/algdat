package no.oslomet.cs.algdat.Oblig1;

////// Løsningsforslag Oblig 1 ////////////////////////

import java.lang.UnsupportedOperationException;
import java.util.NoSuchElementException;

public class Oblig1 {
    private Oblig1() {}

    ///// Oppgave 1 //////////////////////////////////////

    private static final String NO_SUCH_ELEMENT_EXCEPTION_MESSAGE = "arrayet er tom ";

    /*
    //Test code , maks ,arrayet etter sortering og ombyttinger antall!
    public static void main(String[] args) {
        int[] a = {90, 1, 22, 40, 12, 3, 9};
        System.out.println(maks(a));
        int temp;
        for (int i = 1; i < a.length; i++) {
            for (int j = i; j > 0; j--) {
                if (a[j] < a[j - 1]) {
                    temp = a[j];
                    a[j] = a[j - 1];
                    a[j - 1] = temp;
                }
            }
        }
        //skrive ut arrayet etter sortering!
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }


        //skrive ut antall ombyttinger

        System.out.println("\nOmbyttinger tall er " + ombyttinger(a));


    }

    */
    //////////////
    public static int maks(int[] a) {

        int Størsteverdi = 0;


        if (a.length < 1) {

            throw new NoSuchElementException(NO_SUCH_ELEMENT_EXCEPTION_MESSAGE);
        } else if (a.length == 1) {
            Størsteverdi = a[0];
        }


        /*
        Vi lager for loop der vi sjekker om
        er a[1] < a[0] , a[2] < a[1], a[3] < a[2]
        så bytter vi og få ombyttinger. av det får vi største element som er siste element i arrayaet.
        for å sjekke at største verdien ligger bakerst svriver vi ut hele arrayet etter de sammlingene vi har gjørt.
         */

        int temp;
        for (int i = 1; i < a.length; i++) { //går gjennom arrayet!
            for (int j = i; j > 0; j--) {
                if (a[j] < a[j - 1]) {
                    temp = a[j];
                    a[j] = a[j - 1];
                    a[j - 1] = temp;

                    Størsteverdi = a[i];  //oppdatere
                }

                return Størsteverdi;
            }
        }
        return Størsteverdi;
    }

    public static int ombyttinger(int[] a) {

        /*vi difinerer "teller" der er den antall ombyttinger som f;reg[r  gjennom sortering!
        vi regner med at counter (teller) øker 1 hver gang et element være mindre enn den som er neste !
         */

        int teller = 0;
        for (int i = 1; i<a.length; i++){
            if (a[i] >  a[i-1]) {
                int temp= a[i-1];
                a[i-1] = a[i];
                a[i] = temp;
                teller++;
            }
        }
        return teller;
    }

}

/*
Vi får færreste ombyttinger når arrayet er stigende sortert og
blir flest når største verdien kommer som første element. når kravet ikke er oppnåd for hver gang får vi en ombytting.

I Avsnitt 1.1.6 i boka står det som en påstand at hvis vi har n forskjellige tall i rekkefølge, vil det i
gjennomsnitt være Hn − 1 av dem som er større enn det største av de foran. Hn er det n−te
harmoniske tallet.
verdier som kommer etter den f;rste er n-1 og i gjennomsnit stryker vi og så blir det
n-1- (H(n)-1)
= n-1-H(n)-1
=n-H(n)
NB: Kilden her: den ble tilpasset fra pensum boka!

 */
    
  ///////////////////////////////////////////////////////////////////////////////////////
    ///// Oppgave 2        Antall ulike (sortert)  //////////////////////////////////////
  //////////////////////////////////////////////////////////////////////////////////////

    public static int antallUlikeSortert(int[] a) {

        if (a.length > 0) {
            int teller = 1;          //vi difinerer teller som er antall av ulike elementer i arrayet!
            for (int i = 0; i < a.length - 1; i++) {        //Vi går gjennom arrayet!
                if (a[i] != a[i + 1]) {   //hvis en element er ikke lik den neste så øker antallet"teller" med 1
                    teller++;
                }
            }
            return teller;
        } else {
            return 0;       //hvis a.length er < 0 skal returenes 0 som antall forsklige elementer!
        }
    }
}
/*
        //Test code
    public static void main(String[] args) {
        int a [] ={1,1, 2, 3, 3, 4, 5, 5, 7, 7, 9};

        System.out.println(antallUlikeSortert(a));

    }
*/



/////////////////////////////////////////////////////////////////////////////////////
    ///// Oppgave 3          
    // //////////////////////////////////////////////////////////////////////////////

    public static int antallUlikeUsortert(int[] a){
        int teller = 0;    // difinerer tiller som er antall ulike elementer i arrayet!

        for (int i = 0; i < a.length; i++) {     //g[r gjennom arrayet fra posisjonen 0
        int j = 0;
        for (; j < i; j++) {
        int element = a[i];
        if (a[j] == element) break;  // hvis finnes samme element i to steder f[r break
        }
        if (j == i)
        teller++;
        }

        return teller;
        }
        }
  /* Test code 
    public static void main(String[] args) {

        //test code
        int [] a = {2, 6,1,7,9,1,6,8,0,2,0};
        System.out.println(antallUlikeUsortert(a));
    }
     */

    
    //////////////////////////////////////////////////////////////////////////////////
    ///// Oppgave 4 
    /////////////////////////////////////////////////////////////////////////////////

static void delsortering(int a[], int n) {

        int left = 0, right = n - 1;

        // Antall oddetall
        int k = 0;

        while (left < right) {

        //Finne den første oddetall fra den venstre siden!
        while (a[left] % 2 != 0) {
        left++;
        k++;
        }

        // Finn første partall fra høyre side.
        while (a[right] % 2 == 0 && left < right)
        right--;

        // Bytt oddetall til stede på venstre og even nummer høyre.
        if (left < right) {
        // bytte a[left] a[right]
        int temp = a[left];
        a[left] = a[right];
        a[right] = temp;
        }
        }


        // Sorter odde tall i stigende rekkefølge
        Arrays.sort(a, 0, n / 2);
        // Sorter evne tall i stigende rekkefølge
        Arrays.sort(a, k, n);
        }

        }
        /*Test code 
        public static void main(String[] args)
        {
            int  a[] = { 6,10,9,4,1,3,8,5,2,7};

            delsortering(a, a.length);

            System.out.println(Arrays.toString(a));
        }
        
         */

////////////////////////////////////////////////////////////
///// Oppgave 5 
////////////////////////////////////////////////////////////
public static void rotasjon(char[]a){
        // Roter den gitte matrisen n ganger mot høyre
        for(int i=0;i<a.length;i++){
        int j,last;
        // Lagrer det siste elementet i tabellen
        last=a[a.length-1];

        for(j=a.length-1;j>0;j--){
        // Skift element i tebellen etter en
        a[j]=a[j-1];
        }
        // Det siste elementet i tabellen vil bli lagt til starten av tabellen.
        a[0]=(char)last;
        }

        // Viser resulterende matrise etter rotasjon
        System.out.println("Tabellen etter høyre rotasjon: ");
        for(int i=0;i<a.length;i++){
        System.out.print(a[i]+" ");
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
