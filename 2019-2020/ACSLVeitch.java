//program created by Adittya Patil on 3-13-2020

import java.util.*;
public class ACSLVeitch
{
  public static void main(String[] args)
  {
    Scanner sc = new Scanner(System.in);
    for(int i = 0; i < 10; i++)
    {
      String s = sc.nextLine();
      String s1 = hexToBin(s.substring(0,1));
      String s2 = hexToBin(s.substring(1,2));
      String s3 = hexToBin(s.substring(2,3));
      String s4 = hexToBin(s.substring(3,4));
      //visualize(assembleArray(s1, s2, s3, s4));
      System.out.println(finalResult(assembleArray(s1, s2, s3, s4)));
    }



  }

  //tools for initial 2D array setup and visualization

  public static String hexToBin(String hex)
  {
    String bin = "";
    String binFragment = "";
    int iHex;
    hex = hex.trim();
    hex = hex.replaceFirst("0x", "");

    for(int i = 0; i < hex.length(); i++)
    {
        iHex = Integer.parseInt(""+hex.charAt(i),16);
        binFragment = Integer.toBinaryString(iHex);

        while(binFragment.length() < 4)
        {
            binFragment = "0" + binFragment;
        }
        bin += binFragment;
    }
    return bin;
  }

  public static int[][] assembleArray(String bin0, String bin1, String bin2, String bin3)
  {
    int[][] x = new int[4][4];
    for(int i = 0; i < 4; i++)
    {
      x[0][i] = Integer.parseInt(bin0.substring(i, i+1));
      x[1][i] = Integer.parseInt(bin1.substring(i, i+1));
      x[2][i] = Integer.parseInt(bin2.substring(i, i+1));
      x[3][i] = Integer.parseInt(bin3.substring(i, i+1));
    }

    return x;
  }

  public static void visualize(int[][] x)
  {
    for(int i = 0; i < 4; i++)
    {
      System.out.print(x[0][i]+", ");
    }
    System.out.println();
    for(int i = 0; i < 4; i++)
    {
      System.out.print(x[1][i]+", ");
    }
    System.out.println();
    for(int i = 0; i < 4; i++)
    {
      System.out.print(x[2][i]+", ");
    }
    System.out.println();
    for(int i = 0; i < 4; i++)
    {
      System.out.print(x[3][i]+", ");
    }
    System.out.println();
  }

  //tools to help with broader scale operations
  public static String finalResult(int[][] a)
  {
    String s = "";
    s+=findEights(a);
    s+=findFullBars(a);
    s+=findSquares(a);
    s+=fourCorners(a);
    s+=findHalfBars(a);
    s+=findthaEnds(a);
    s+=findIndividuals(a);
    s=s.substring(1);
    return s;
  }


  //tools to help with individual matchings
  public static String findEights(int[][] a)
  {
    String s = "";

    //for B
    if(a[0][0] == 1 && a[0][1] == 1 && a[0][2] == 1 && a[0][3] == 1
    && a[1][0] == 1 && a[1][1] == 1 && a[1][2] == 1 && a[1][3] == 1)
    {
      a[0][0] = -1;
      a[0][1] = -1;
      a[0][2] = -1;
      a[0][3] = -1;
      a[1][0] = -1;
      a[1][1] = -1;
      a[1][2] = -1;
      a[1][3] = -1;

      s+="+B";
    }

    //for D
    if(a[1][0] == 1 && a[1][1] == 1 && a[1][2] == 1 && a[1][3] == 1
    && a[2][0] == 1 && a[2][1] == 1 && a[2][2] == 1 && a[2][3] == 1)
    {
      a[1][0] = -1;
      a[1][1] = -1;
      a[1][2] = -1;
      a[1][3] = -1;
      a[2][0] = -1;
      a[2][1] = -1;
      a[2][2] = -1;
      a[2][3] = -1;

      s+="+D";
    }

    //for ~B
    if(a[2][0] == 1 && a[2][1] == 1 && a[2][2] == 1 && a[2][3] == 1
    && a[3][0] == 1 && a[3][1] == 1 && a[3][2] == 1 && a[3][3] == 1)
    {
      a[2][0] = -1;
      a[2][1] = -1;
      a[2][2] = -1;
      a[2][3] = -1;
      a[3][0] = -1;
      a[3][1] = -1;
      a[3][2] = -1;
      a[3][3] = -1;

      s+="+~B";
    }

    //for A
    if(a[0][0] == 1 && a[0][1] == 1 && a[1][0] == 1 && a[1][1] == 1
    && a[2][0] == 1 && a[2][1] == 1 && a[3][0] == 1 && a[3][1] == 1)
    {
      a[0][0] = -1;
      a[0][1] = -1;
      a[1][0] = -1;
      a[1][1] = -1;
      a[2][0] = -1;
      a[2][1] = -1;
      a[3][0] = -1;
      a[3][1] = -1;

      s+="+A";
    }

    //for C
    if(a[0][1] == 1 && a[0][2] == 1 && a[1][1] == 1 && a[1][2] == 1
    && a[2][1] == 1 && a[2][2] == 1 && a[3][1] == 1 && a[3][2] == 1)
    {
      a[0][1] = -1;
      a[0][2] = -1;
      a[1][1] = -1;
      a[1][2] = -1;
      a[2][1] = -1;
      a[2][2] = -1;
      a[3][1] = -1;
      a[3][2] = -1;

      s+="+C";
    }

    //for ~A
    if(a[0][2] == 1 && a[0][3] == 1 && a[1][2] == 1 && a[1][3] == 1
    && a[2][2] == 1 && a[2][3] == 1 && a[3][2] == 1 && a[3][3] == 1)
    {
      a[0][2] = -1;
      a[0][3] = -1;
      a[1][2] = -1;
      a[1][3] = -1;
      a[2][2] = -1;
      a[2][3] = -1;
      a[3][2] = -1;
      a[3][3] = -1;

      s+="+~A";
    }

    //for ~D
    if(a[0][0] == 1 && a[0][1] == 1 && a[0][2] == 1 && a[0][3] == 1
    && a[3][0] == 1 && a[3][1] == 1 && a[3][2] == 1 && a[3][3] == 1)
    {
      a[0][0] = -1;
      a[0][1] = -1;
      a[0][2] = -1;
      a[0][3] = -1;
      a[3][0] = -1;
      a[3][1] = -1;
      a[3][2] = -1;
      a[3][3] = -1;

      s+="+~D";
    }


    //for ~C
    if(a[0][0] == 1 && a[0][3] == 1 && a[1][0] == 1 && a[1][3] == 1
    && a[2][0] == 1 && a[2][3] == 1 && a[3][0] == 1 && a[3][3] == 1)
    {
      a[0][0] = -1;
      a[0][3] = -1;
      a[1][0] = -1;
      a[1][3] = -1;
      a[2][0] = -1;
      a[2][3] = -1;
      a[3][0] = -1;
      a[3][3] = -1;

      s+="+~C";
    }

    return s;

  }

  public static String findSquares(int[][] a)
  {
    String s = "";

    //for AB
    if(a[0][0] == 1 && a[0][1] == 1 && a[1][0] == 1 && a[1][1] == 1)
    {
      a[0][0] = -1;
      a[0][1] = -1;
      a[1][0] = -1;
      a[1][1] = -1;
      s+="+AB";
    }

    //for BC
    if(a[0][1] == 1 && a[0][2] == 1 && a[1][1] == 1 && a[1][2] == 1)
    {
      a[0][1] = -1;
      a[0][2] = -1;
      a[1][1] = -1;
      a[1][2] = -1;
      s+="+BC";
    }

    //for ~AB
    if(a[0][2] == 1 && a[0][3] == 1 && a[1][2] == 1 && a[1][3] == 1)
    {
      a[0][2] = -1;
      a[0][3] = -1;
      a[1][2] = -1;
      a[1][3] = -1;
      s+="+~AB";
    }

    //for AD
    if(a[1][0] == 1 && a[1][1] == 1 && a[2][0] == 1 && a[2][1] == 1)
    {
      a[1][0] = -1;
      a[1][1] = -1;
      a[2][0] = -1;
      a[2][1] = -1;
      s+="+AD";
    }

    //for CD
    if(a[1][1] == 1 && a[1][2] == 1 && a[2][1] == 1 && a[2][2] == 1)
    {
      a[1][1] = -1;
      a[1][2] = -1;
      a[2][1] = -1;
      a[2][2] = -1;
      s+="+CD";
    }

    //for ~AD
    if(a[1][2] == 1 && a[1][3] == 1 && a[2][2] == 1 && a[2][3] == 1)
    {
      a[1][2] = -1;
      a[1][3] = -1;
      a[2][2] = -1;
      a[2][3] = -1;
      s+="+~AD";
    }

    //for A~B
    if(a[2][0] == 1 && a[2][1] == 1 && a[3][0] == 1 && a[3][1] == 1)
    {
      a[2][0] = -1;
      a[2][1] = -1;
      a[3][0] = -1;
      a[3][1] = -1;
      s+="+A~B";
    }

    //for ~BC
    if(a[2][1] == 1 && a[2][2] == 1 && a[3][1] == 1 && a[3][2] == 1)
    {
      a[2][1] = -1;
      a[2][2] = -1;
      a[3][1] = -1;
      a[3][2] = -1;
      s+="+~BC";
    }

    //for ~A~B
    if(a[2][2] == 1 && a[2][3] == 1 && a[3][2] == 1 && a[3][3] == 1)
    {
      a[2][2] = -1;
      a[2][3] = -1;
      a[3][2] = -1;
      a[3][3] = -1;
      s+="+~A~B";
    }
    return s;
  }

  public static String findFullBars(int[][] a)
  {
    String s = "";

    //for B~D
    if(a[0][0] == 1 && a[0][1] == 1 && a[0][2] == 1 && a[0][3] == 1)
    {
      a[0][0] = -1;
      a[0][1] = -1;
      a[0][2] = -1;
      a[0][3] = -1;
      s+="+B~D";
    }

    //for BD
    if(a[1][0] == 1 && a[1][1] == 1 && a[1][2] == 1 && a[1][3] == 1)
    {
      a[1][0] = -1;
      a[1][1] = -1;
      a[1][2] = -1;
      a[1][3] = -1;
      s+="+BD";
    }

    //for ~BD
    if(a[2][0] == 1 && a[2][1] == 1 && a[2][2] == 1 && a[2][3] == 1)
    {
      a[2][0] = -1;
      a[2][1] = -1;
      a[2][2] = -1;
      a[2][3] = -1;
      s+="+~BD";
    }

    //for ~B~D
    if(a[3][0] == 1 && a[3][1] == 1 && a[3][2] == 1 && a[3][3] == 1)
    {
      a[3][0] = -1;
      a[3][1] = -1;
      a[3][2] = -1;
      a[3][3] = -1;
      s+="+~B~D";
    }

    //for A~C
    if(a[0][0] == 1 && a[1][0] == 1 && a[2][0] == 1 && a[3][0] == 1)
    {
      a[0][0] = -1;
      a[1][0] = -1;
      a[2][0] = -1;
      a[3][0] = -1;
      s+="+A~C";
    }

    //for AC
    if(a[0][1] == 1 && a[1][1] == 1 && a[2][1] == 1 && a[3][1] == 1)
    {
      a[0][1] = -1;
      a[1][1] = -1;
      a[2][1] = -1;
      a[3][1] = -1;
      s+="+AC";
    }

    //for ~AC
    if(a[0][2] == 1 && a[1][2] == 1 && a[2][2] == 1 && a[3][2] == 1)
    {
      a[0][2] = -1;
      a[1][2] = -1;
      a[2][2] = -1;
      a[3][2] = -1;
      s+="+~AC";
    }

    //for ~A~C
    if(a[0][3] == 1 && a[1][3] == 1 && a[2][3] == 1 && a[3][3] == 1)
    {
      a[0][3] = -1;
      a[1][3] = -1;
      a[2][3] = -1;
      a[3][3] = -1;
      s+="+~A~C";
    }



    //for B~C
    if(a[0][0] == 1 && a[0][3] == 1 && a[1][0] == 1 && a[1][3] == 1)
    {
      a[0][0] = -1;
      a[0][3] = -1;
      a[1][0] = -1;
      a[1][3] = -1;
      s+="+B~C";

    }

    //for ~CD
    if(a[1][0] == 1 && a[1][3] == 1 && a[2][0] == 1 && a[2][3] == 1)
    {
      a[1][0] = -1;
      a[1][3] = -1;
      a[2][0] = -1;
      a[2][3] = -1;
      s+="+~CD";

    }

    //for ~B~C
    if(a[2][0] == 1 && a[2][3] == 1 && a[3][0] == 1 && a[3][3] == 1)
    {
      a[2][0] = -1;
      a[2][3] = -1;
      a[3][0] = -1;
      a[3][3] = -1;
      s+="+~B~C";

    }

    //for A~D
    if(a[0][0] == 1 && a[0][1] == 1 && a[3][0] == 1 && a[3][1] == 1)
    {
      a[0][0] = -1;
      a[0][1] = -1;
      a[3][0] = -1;
      a[3][1] = -1;
      s+="+A~D";
    }

    if(a[0][1] == 1 && a[0][2] == 1 && a[3][1] == 1 && a[3][2] == 1)
    {
      a[0][1] = -1;
      a[0][2] = -1;
      a[3][1] = -1;
      a[3][2] = -1;
      s+="+C~D";
    }

    if(a[0][2] == 1 && a[0][3] == 1 && a[3][2] == 1 && a[3][3] == 1)
    {
      a[0][2] = -1;
      a[0][3] = -1;
      a[3][2] = -1;
      a[3][3] = -1;
      s+="+~A~D";
    }
    return s;
  }

  public static String fourCorners(int[][] a)
  {
    String s = "";
    //for ~C~D
    if(a[0][0] == 1 && a[0][3] == 1 && a[3][0] == 1 && a[3][3] == 1)
    {
      a[0][0] = -1;
      a[0][3] = -1;
      a[3][0] = -1;
      a[3][3] = -1;
      s+="+~C~D";
    }
    return s;
  }

  public static String findHalfBars(int[][] a)
  {
    String s = "";
    //for AB~D
    if(a[0][0] == 1 && a[0][1] == 1)
    {
      a[0][0] = -1;
      a[0][1] = -1;
      s+="+AB~D";
    }

    //for BC~D
    if(a[0][1] == 1 && a[0][2] == 1)
    {
      a[0][1] = -1;
      a[0][2] = -1;
      s+="+BC~D";
    }

    //for ~ABD
    if(a[0][2] == 1 && a[0][3] == 1)
    {
      a[0][2] = -1;
      a[0][3] = -1;
      s+="+~AB~D";
    }

    //for ABD
    if(a[1][0] == 1 && a[1][1] == 1)
    {
      a[1][0] = -1;
      a[1][1] = -1;
      s+="+ABD";
    }

    //for BCD
    if(a[1][1] == 1 && a[1][2] == 1)
    {
      a[1][1] = -1;
      a[1][2] = -1;
      s+="+BCD";
    }

    //for ~ABD
    if(a[1][2] == 1 && a[1][3] == 1)
    {
      a[1][2] = -1;
      a[1][3] = -1;
      s+="+~ABD";
    }

    //for A~BD
    if(a[2][0] == 1 && a[2][1] == 1)
    {
      a[2][0] = -1;
      a[2][1] = -1;
      s+="+A~BD";
    }

    //for ~BCD
    if(a[2][1] == 1 && a[2][2] == 1)
    {
      a[2][1] = -1;
      a[2][2] = -1;
      s+="+~BCD";
    }

    //for ~A~BD
    if(a[2][2] == 1 && a[2][3] == 1)
    {
      a[2][2] = -1;
      a[2][3] = -1;
      s+="+~A~BD";
    }

    //for A~B~D
    if(a[3][0] == 1 && a[3][1] == 1)
    {
      a[3][0] = -1;
      a[3][1] = -1;
      s+="+A~B~D";
    }

    //for ~BC~D
    if(a[3][1] == 1 && a[3][2] == 1)
    {
      a[3][1] = -1;
      a[3][2] = -1;
      s+="+~BC~D";
    }

    //for ~A~B~D
    if(a[3][2] == 1 && a[3][3] == 1)
    {
      a[3][2] = -1;
      a[3][3] = -1;
      s+="+~A~B~D";
    }

    //for AB~C
    if(a[0][0] == 1 && a[1][0] == 1)
    {
      a[0][0] = -1;
      a[1][0] = -1;
      s+="+AB~C";
    }

    //for ABC
    if(a[0][1] == 1 && a[1][1] == 1)
    {
      a[0][1] = -1;
      a[1][1] = -1;
      s+="+ABC";
    }

    //for ~ABC
    if(a[0][2] == 1 && a[1][2] == 1)
    {
      a[0][2] = -1;
      a[1][2] = -1;
      s+="+~ABC";
    }

    //for ~AB~C
    if(a[0][3] == 1 && a[1][3] == 1)
    {
      a[0][3] = -1;
      a[1][3] = -1;
      s+="+~AB~C";
    }

    //for A~CD
    if(a[1][0] == 1 && a[2][0] == 1)
    {
      a[1][0] = -1;
      a[2][0] = -1;
      s+="+A~CD";
    }

    //for ACD
    if(a[1][1] == 1 && a[2][1] == 1)
    {
      a[1][1] = -1;
      a[2][1] = -1;
      s+="+ACD";
    }

    //for ~ACD
    if(a[1][2] == 1 && a[2][2] == 1)
    {
      a[1][2] = -1;
      a[2][2] = -1;
      s+="+~ACD";
    }

    //for ~A~CD
    if(a[1][3] == 1 && a[2][3] == 1)
    {
      a[1][3] = -1;
      a[2][3] = -1;
      s+="+~A~CD";
    }

    //for A~B~C
    if(a[2][0] == 1 && a[3][0] == 1)
    {
      a[2][0] = -1;
      a[3][0] = -1;
      s+="+A~B~C";
    }

    //for A~BC
    if(a[2][1] == 1 && a[3][1] == 1)
    {
      a[2][1] = -1;
      a[3][1] = -1;
      s+="+A~BC";
    }

    //for ~A~BC
    if(a[2][2] == 1 && a[3][2] == 1)
    {
      a[2][2] = -1;
      a[3][2] = -1;
      s+="+~A~BC";
    }

    //for ~A~B~C
    if(a[2][3] == 1 && a[3][3] == 1)
    {
      a[2][3] = -1;
      a[3][3] = -1;
      s+="+~A~B~C";
    }

    return s;
  }

  public static String findthaEnds(int[][] a)
  {
    String s = "";
    //for B~C~D
    if(a[0][0] == 1 && a[0][3] == 1)
    {
      a[0][0] = -1;
      a[0][3] = -1;
      s+="+B~C~D";
    }

    //for B~CD
    if(a[1][0] == 1 && a[1][3] == 1)
    {
      a[1][0] = -1;
      a[1][3] = -1;
      s+="+B~CD";
    }

    //for ~B~CD
    if(a[2][0] == 1 && a[2][3] == 1)
    {
      a[2][0] = -1;
      a[2][3] = -1;
      s+="+~B~CD";
    }

    //for ~B~C~D
    if(a[3][0] == 1 && a[3][3] == 1)
    {
      a[3][0] = -1;
      a[3][3] = -1;
      s+="+~B~C~D";
    }

    //for A~C~D
    if(a[0][0] == 1 && a[3][0] == 1)
    {
      a[0][0] = -1;
      a[3][0] = -1;
      s+="+A~C~D";
    }

    //for AC~D
    if(a[0][1] == 1 && a[3][1] == 1)
    {
      a[0][1] = -1;
      a[3][1] = -1;
      s+="+AC~D";
    }

    //for ~AC~D
    if(a[0][2] == 1 && a[3][2] == 1)
    {
      a[0][2] = -1;
      a[3][2] = -1;
      s+="+~AC~D";
    }

    //for ~A~C~D
    if(a[0][3] == 1 && a[3][3] == 1)
    {
      a[0][3] = -1;
      a[3][3] = -1;
      s+="+~A~C~D";
    }

    return s;
  }

  public static String findIndividuals(int[][] a)
  {
    String s = "";
    //for AB~C~D
    if(a[0][0] == 1)
    {
      a[0][0] = -1;
      s+="+AB~C~D";
    }

    //for ABC~D
    if(a[0][1] == 1)
    {
      a[0][1] = -1;
      s+="+ABC~D";
    }

    //for ~ABC~D
    if(a[0][2] == 1)
    {
      a[0][2] = -1;
      s+="+~ABC~D";
    }

    //for ~AB~C~D
    if(a[0][3] == 1)
    {
      a[0][3] = -1;
      s+="+~AB~C~D";
    }

    //for AB~CD
    if(a[1][0] == 1)
    {
      a[1][0] = -1;
      s+="+AB~CD";
    }

    //for ABCD
    if(a[1][1] == 1)
    {
      a[1][1] = -1;
      s+="+ABCD";
    }

    //for ~ABCD
    if(a[1][2] == 1)
    {
      a[1][2] = -1;
      s+="+~ABCD";
    }

    //for ~AB~CD
    if(a[1][3] == 1)
    {
      a[1][3] = -1;
      s+="+~AB~CD";
    }

    //for A~B~CD
    if(a[2][0] == 1)
    {
      a[2][0] = -1;
      s+="+A~B~CD";
    }

    //for A~BCD
    if(a[2][1] == 1)
    {
      a[2][1] = -1;
      s+="+A~BCD";
    }

    //for ~A~BCD
    if(a[2][2] == 1)
    {
      a[2][2] = -1;
      s+="+~A~BCD";
    }

    //for ~A~B~CD
    if(a[2][3] == 1)
    {
      a[2][3] = -1;
      s+="+~A~B~CD";
    }

    //for A~B~C~D
    if(a[3][0] == 1)
    {
      a[3][0] = -1;
      s+="+A~B~C~D";
    }

    //for A~BC~D
    if(a[3][1] == 1)
    {
      a[3][1] = -1;
      s+="+A~BC~D";
    }

    //for ~A~BC~D
    if(a[3][2] == 1)
    {
      a[3][2] = -1;
      s+="+~A~BC~D";
    }

    //for ~A~B~C~D
    if(a[3][3] == 1)
    {
      a[3][3] = -1;
      s+="+~A~B~C~D";
    }

    return s;

  }

}
