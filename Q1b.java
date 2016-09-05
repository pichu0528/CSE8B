public class Q1b
{
  private static int grade1=3;
  public static void main (String args[])
  {
    final int MAX = 5;
    int a[] = {3,5,7};
    int grade2 = 1;
    double grade3 = 1.5;
    
    do 
    {
      if (count(++grade2))
        System.out.println((MAX> ++grade2 || false));
      count(grade3, a[1]/3);
    }while(grade2>MAX%4 && grade2<MAX-1);
  }
  public static void prt(int grade2){System.out.println(grade1+=grade2);}
  public static int count(double g, int grade1){prt(grade1+2); return 0;}
  public static boolean count(int g)
  {
    if (g%3 <2) return true;
    return false;
  }
}