//Program created by Adittya Patil on 1-31-2019
import java.util.*;
public class ACSLDiff2 {



        public static void main(String[] args)
        {
            Scanner sc = new Scanner(System.in);

            String s1 = sc.nextLine();
            String s2 = sc.nextLine();
            String s3 = sc.nextLine();
            String s4 = sc.nextLine();
            String s5 = sc.nextLine();
            String s6 = sc.nextLine();
            String s7 = sc.nextLine();
            String s8 = sc.nextLine();
            String s9 = sc.nextLine();
            String s10 = sc.nextLine();
            String s11 = sc.nextLine();
            String s12 = sc.nextLine();
            String s13 = sc.nextLine();
            String s14 = sc.nextLine();

            System.out.println(algorithmTwo(algorithmOne(s1, s2), algorithmOne(s2,s1)));
            System.out.println(algorithmTwo(algorithmOne(s4, s5), algorithmOne(s5,s4)));
            System.out.println(algorithmTwo(algorithmOne(s7, s8), algorithmOne(s8,s7)));
            System.out.println(algorithmTwo(algorithmOne(s10, s11), algorithmOne(s11,s10)));
            System.out.println(algorithmTwo(algorithmOne(s13, s14), algorithmOne(s14,s13)));



        }

        public static String algorithmOne(String s1, String s2)
        {
            String s = "";
            ArrayList<String> AR1 = new ArrayList<String>();
            ArrayList<String> AR2 = new ArrayList<String>();
            ArrayList<String> AR3 = new ArrayList<String>();
            ArrayList<String> AR4 = new ArrayList<String>();
            Scanner sc1 = new Scanner(s1);
            Scanner sc2 = new Scanner(s2);

            while(sc1.hasNext())
            {
                String x = sc1.next();
                AR1.add(x);
                AR3.add(x);

            }

            while(sc2.hasNext())
            {
                String y = sc2.next();
                AR2.add(y);
                AR4.add(y);
            }

            return constructCommonString(AR1, AR2);


        }

        public static String constructCommonString(ArrayList<String> s1, ArrayList<String> s2)
        {
            String s = "";
            int x = 0;
            int y = 0;
            for(int i=0; i<s1.size(); i++)
            {
                for(int j=0; j<s2.size(); j++)
                {
                    if(s1.get(i).equals(s2.get(j)))
                    {
                        s+=s2.get(j)+" ";
                        s2.remove(j);
                    }

                    else if(substringContains(s1.get(i), s2.get(j)))
                    {
                        s+=s1.get(i)+" ";
                        Scanner sc = new Scanner(findStartAndEnd(s1.get(i), s2.get(j)));
                        x=sc.nextInt();
                        y=sc.nextInt();
                        s2.set(j, s2.get(j).substring(0,x)+s2.get(j).substring(y,s2.get(j).length()));



                    }

                }
            }
            s=s.substring(0,s.length()-1);
            return s;
        }

        public static boolean substringContains(String s, String j)
        {
            boolean Final = false;
            int x = s.length();
            int y = j.length();

            if(x>y)
            {

            }

            else
            {
                for(int i = 0; i<(y-x); i++)
                {
                    if(s.equals(j.substring(i, x+i)))
                    {
                        Final = true;
                    }
                    else if(s.equals(j.substring(y-x, y)))
                    {
                        Final = true;
                    }

                }

            }

            return Final;

        }

        public static String findStartAndEnd(String s, String j)
        {
            int x = s.length();
            int y = j.length();
            int a =0;
            int b =0;
            boolean z = false;

            if(x>y)
            {

            }

            else
            {
                for(int i = 0; i<(y-x); i++)
                {
                    if(s.equals(j.substring(i, x+i)))
                    {
                        a=i;
                        b=x+i;
                        z=true;

                    }


                }

                if(s.equals(j.substring(j.length()-s.length(), j.length())) && z==false)
                {
                    a=j.length()-s.length();
                    b=j.length();
                }

            }

            return a+" "+b;



        }

        public static String algorithmTwo(String first, String second)
        {
            String s ="";
            first = first.replaceAll("\\s","");
            second = second.replaceAll("\\s","");
            for(int i=0; i<first.length(); i++)
            {
                if(second.indexOf(first.charAt(i)) != -1)
                {
                    s+=first.charAt(i);
                    second=second.substring(second.indexOf(first.charAt(i))+1);
                }
                else
                {

                }



            }

            return s;

        }

    }


