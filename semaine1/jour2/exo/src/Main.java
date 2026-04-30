public class Main {

    public static void main(String[] args) {
        System.out.println(somme(3));
        System.out.println(compteurdevoyelles("toto"));
    }

    public static int somme(int nombre) {
        int somme = 0;

        for (int i = 0; i<= nombre; i++)
        {
            somme = somme + i;
        }

        return somme;
    }

    public static int compteurdevoyelles(String text)
    {
        int count = 0;
        char c;

        for (int i = 0 ; i< text.length(); i++)
        {
            c = text.charAt(i);
            if( c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'z')
            {
                count++;
            }
        }

        return count;
    }
    
}
