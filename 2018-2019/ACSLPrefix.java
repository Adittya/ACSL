//Program created by Adittya Patil 4-17-2019
import java.util.*;
public class ACSLPrefix {

    public static void main(String[] args)
    {

        Scanner sc = new Scanner(System.in);

        String s1 = sc.nextLine();
        String s2 = sc.nextLine();
        String s3 = sc.nextLine();
        String s4 = sc.nextLine();
        String s5 = sc.nextLine();

        System.out.println(evaluate(s1));
        System.out.println(evaluate(s2));
        System.out.println(evaluate(s3));
        System.out.println(evaluate(s4));
        System.out.println(evaluate(s5));




    }

    public static int evaluate(String s)
    {
        s = reverse(s);
        Scanner sc = new Scanner(s);
        stack x = new stack();
        while(sc.hasNext())
        {
            String v = sc.next();
            if(!isOperator(v))
            {
                x.push(Integer.parseInt(v));
            }

            else
            {
                if(v.equals("+"))
                {
                    x.add();
                }

                else if(v.equals("-"))
                {
                    x.subtract();
                }

                else if(v.equals("*"))
                {
                    x.multiply();
                }

                else if(v.equals("/"))
                {
                    x.divide();
                }

                else if(v.equals("@"))
                {
                    x.switcher();
                }

                else if(v.equals("|"))
                {
                    x.absValue();
                }

                else if(v.equals(">"))
                {
                    x.max();
                }
            }

        }

        return x.returnfirst();


    }

    public static String reverse(String s)
    {
        String y = "";
        Scanner sc = new Scanner(s);
        ArrayList<String> z = new ArrayList<String>();
        while(sc.hasNext())
        {
            z.add(sc.next());
        }

        Collections.reverse(z);

        for(int i = 0; i<z.size(); i++)
        {
            y+=z.get(i);
            y+=" ";
        }

        y = y.substring(0, y.length()-1);
        return y;
    }

    public static boolean isOperator(String s)
    {
        boolean b = true;

        if(s.length()>1)
        {
            b=false;
        }

        else
        {
            if(!s.equals("@") && !s.equals("|") && !s.equals(">") && !s.equals("+") && !s.equals("-") && !s.equals("*") && !s.equals("/"))
            {
                b = false;
            }

        }

        return b;

    }

    static class stack
    {
        ArrayList<Integer> x = new ArrayList<Integer>();


        public stack()
        {
            ArrayList<Integer> x = new ArrayList<Integer>();
        }

        public void push(int c)
        {
            x.add(c);

        }

        public int pop()
        {
            return x.remove(x.size()-1);
        }

        public void add()
        {
            int one = pop();
            int two = pop();
            push(one+two);
        }

        public void subtract()
        {
            int one = pop();
            int two = pop();
            push(one-two);
        }

        public void multiply()
        {
            int one = pop();
            int two = pop();
            push(one*two);
        }

        public void divide()
        {
            int one = pop();
            int two = pop();
            push(one/two);
        }

        public void switcher()
        {
            int one = pop();
            int two = pop();
            int three = pop();

            if(one > 0)
            {
                push(two);
            }

            else if(one < 0)
            {
                push(three);
            }
        }

        public void max()
        {
            int z;
            int one = pop();
            int two = pop();
            int three = pop();

            if(one>two && one>three)
            {
                z = one;
            }

            else if(two>one && two>three)
            {
                z = two;
            }

            else
            {
                z = three;
            }

            push(z);

        }

        public void absValue()
        {
            for(int i =0; i<x.size(); i++)
            {
                if(x.get(i)<0)
                {
                    x.set(i, x.get(i)*-1);
                }
            }
        }

        public String toString()
        {
            return x.toString();
        }

        public int returnfirst()
        {
            return x.get(0);
        }


    }
}
