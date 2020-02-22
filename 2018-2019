//program created by Adittya Patil 12-15-2018
import java.util.*;
public class ACSLDigitReassembly2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Scanner sc1 = new Scanner(sc.nextLine());
        Scanner sc2 = new Scanner(sc.nextLine());
        Scanner sc3 = new Scanner(sc.nextLine());
        Scanner sc4 = new Scanner(sc.nextLine());
        Scanner sc5 = new Scanner(sc.nextLine());

        String s1 = sc1.next();
        String s2 = sc2.next();
        String s3 = sc3.next();
        String s4 = sc4.next();
        String s5 = sc5.next();

        int x1 = sc1.nextInt();
        int x2 = sc2.nextInt();
        int x3 = sc3.nextInt();
        int x4 = sc4.nextInt();
        int x5 = sc5.nextInt();

        System.out.println(findSum(x1, s1));
        System.out.println(findSum(x2, s2));
        System.out.println(findSum(x3, s3));
        System.out.println(findSum(x4, s4));
        System.out.println(findSum(x5, s5));



    }

    public static int findSum(int divisionFactor, String number)
    {
        int finalSum = 0;
        String recreate = "";
        boolean x = true;
        ArrayList<String> numberCombos = new ArrayList<String>();



        while (number.length()%divisionFactor != 0)
        {
            number+="0";
        }

        for(int i = 0; i<number.length(); i++)
        {
            if((i+1)%divisionFactor==0)
            {
                recreate+=number.charAt(i);
                recreate+=" ";
            }

            else if((i+1)%divisionFactor!=0)
            {
                recreate+=number.charAt(i);
            }

        }

        Scanner sc = new Scanner(recreate);

        while(sc.hasNext())
        {
            numberCombos.add(sc.next());

        }

        for(int i=0; i<numberCombos.size(); i++)
        {
            if(isAllZero(numberCombos.get(i)))
            {
                numberCombos.set(i, "0");
            }

            else if(numberCombos.get(i).charAt(0) == '0')
            {
                while(numberCombos.get(i).charAt(0) == '0')
                {
                    numberCombos.set(i, numberCombos.get(i).substring(1));
                }

            }

            else
            {

            }

        }

        for(int i=0; i<numberCombos.size(); i++)
        {
            finalSum+=Integer.parseInt(numberCombos.get(i));
        }

        return finalSum;
    }

    public static boolean isAllZero(String s)
    {
        boolean x = true;
        for(int i=0; i<s.length(); i++)
        {
            if(s.charAt(i) != '0')
            {
                x = false;
            }

            else
            {

            }
        }
        return x;
    }


}
