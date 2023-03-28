public class PropLogic {

    public boolean x;

    public boolean y;

    PropLogic(boolean x, boolean y)
    {
        this.x = x;
        this.y = y;
    }

    public static boolean AND(boolean x, boolean y)
    {
     return x && y;
    }

    public static boolean OR(boolean x, boolean y)
    {
        return x || y;
    }

    public static boolean NOT(boolean y)
    {
        return !y;
    }

    public static boolean XOR(boolean x, boolean y)
    {
        return x == y;
    }

    public static boolean IMPLICATION(boolean x, boolean y)
    {
        return OR(NOT(x),y);
    }

    public static boolean CONVERSE(boolean x, boolean y)
    {
        return OR(NOT(y),x);
    }

    public static boolean BI_IMPLICATION(boolean x, boolean y)
    {
        return AND(OR(NOT(x),y),CONVERSE(x,y));
    }

    public static boolean INVERSE(boolean x, boolean y)
    {
        return OR(NOT(NOT(x)),NOT(y));
    }

    public static boolean CONTRAPOSITIVE(boolean x, boolean y)
    {
        return OR(NOT(NOT(y)),NOT(x));
    }

    public static String DEMORGAN(String x) // Only works for expressions of form P AND Q, If adding NOT, write : NOTP
    {
        String c = "";
        String[] proparray = x.split(" ");
        if(proparray[0].startsWith("NOT"))
        {
            c = c + proparray[0].substring(3) + " ";
        }

        else
        {
            c = c + "NOT" + proparray[0] + " ";
        }

        if(proparray[1].equals("AND"))
        {
            c = c + "OR ";
        }

        else
        {
            c = c + "AND ";
        }

        if(proparray[2].startsWith("NOT"))
        {
            c = c + proparray[2].substring(3);
        }

        else
        {
            c = c + "NOT" + proparray[2];
        }

        return c;
    }

    public static void main(String[] args) {

        // Just checking if DeMorgan works properly

        String f = "NOTP AND Q";
        System.out.println(DEMORGAN(DEMORGAN(f)).equals(f)); // returns true according to DeMorgans law
    }
}
