

import java.util.*;

public class ACSLStretch {


    public static void main(String[] args) {

    }

  
    public static String makePath(int length, int width, int start, ArrayList<Integer> voidSquares)
    {
        String pathway = "";
        char direction = findPathDirection(width, start);
        char pieceToUse = 'a';
        if(direction == 'r')
        {
            while(start % width != 0)
            {

            }

        }
        else if(direction == 'l')
        {
            while(start % width != 1)
            {

            }

        }
        return pathway;
    }

    public static char findPathDirection(int w, int s)
    {
        if(s%w == 1)
        {
            return 'r';
        }
        return 'l';
    }

    public static boolean tryPieceA(int l, int w, int initial, char direction, ArrayList<Integer> voidSquares)
    {
        int[] coverage = new int[3];
        boolean r = true;
        if(direction == 'r')
        {
            initial++;
            coverage[0] = initial;
            initial++;
            coverage[1] = initial;
            initial++;
            coverage[2] = initial;
            for(int i = 0; i<3; i++)
            {
                for(int j : voidSquares)
                {
                    if(coverage[i] == j)
                    {
                        r = false;
                    }
                }
            }

            if(coverage[0] % w == 0 && coverage[1] - coverage[0] == 1)
            {
                r = false;
            }
            else if(coverage[1] % w == 0 && coverage[2] - coverage[1] == 1)
            {
                r = false;
            }
        }
        else
        {
            initial--;
            coverage[0] = initial;
            initial--;
            coverage[1] = initial;
            initial--;
            coverage[2] = initial;
            for(int i = 0; i<3; i++)
            {
                for(int j : voidSquares)
                {
                    if(coverage[i] == j)
                    {
                        r = false;
                    }
                }
            }

            if(coverage[1] % w == 1 && coverage[1] - coverage[2] == 1)
            {
                r = false;
            }
            else if(coverage[0] % w == 1 && coverage[0] - coverage[1] == 1)
            {
                r = false;
            }

        }

        return r;
    }

    public static boolean tryPieceBUpwards(int l, int w, int initial, char direction, ArrayList<Integer> voidSquares)
    {
        int[] coverage = new int[3];
        boolean r = true;
        if(direction == 'r')
        {
            initial++;
            coverage[0] = initial;
            initial-=w;
            coverage[1] = initial;
            initial-=w;
            coverage[2] = initial;
            for(int i = 0; i<3; i++)
            {
                for(int j : voidSquares)
                {
                    if(coverage[i] == j)
                    {
                        r = false;
                    }
                }
            }

            if(coverage[1] < 0 || coverage[2] < 0)
            {
                r = false;
            }
        }
        else
        {
            initial--;
            coverage[0] = initial;
            initial-=w;
            coverage[1] = initial;
            initial-=w;
            coverage[2] = initial;
            for(int i = 0; i<3; i++)
            {
                for(int j : voidSquares)
                {
                    if(coverage[i] == j)
                    {
                        r = false;
                    }
                }
            }

            if(coverage[1] < 0 || coverage[2] < 0)
            {
                r = false;
            }

        }

        return r;
    }
    
    public static boolean tryPieceBDownwards(int l, int w, int initial, char direction, ArrayList<Integer> voidSquares)
    {
        int[] coverage = new int[3];
        boolean r = true;
        if(direction == 'r')
        {
            initial++;
            coverage[0] = initial;
            initial+=w;
            coverage[1] = initial;
            initial+=w;
            coverage[2] = initial;
            for(int i = 0; i<3; i++)
            {
                for(int j : voidSquares)
                {
                    if(coverage[i] == j)
                    {
                        r = false;
                    }
                }
            }

            if(coverage[1] > w*l || coverage[2] > w*l)
            {
                r = false;
            }
        }
        else
        {
            initial--;
            coverage[0] = initial--;
            initial+=w;
            coverage[1] = initial;
            initial+=w;
            coverage[2] = initial;
            for(int i = 0; i<3; i++)
            {
                for(int j : voidSquares)
                {
                    if(coverage[i] == j)
                    {
                        r = false;
                    }
                }
            }

            if(coverage[1] > w*l  || coverage[2] > w*l)
            {
                r = false;
            }

        }

        return r;
    }
    
    public static boolean tryPieceC(int l, int w, int initial, char direction, ArrayList<Integer> voidSquares)
    {
        int[] coverage = new int[3];
        boolean r = true;
        if(direction == 'r')
        {
            initial++;
            coverage[0] = initial;
            initial+=w;
            coverage[1] = initial;
            initial++;
            coverage[2] = initial;
            for(int i = 0; i<3; i++)
            {
                for(int j : voidSquares)
                {
                    if(coverage[i] == j)
                    {
                        r = false;
                    }
                }
            }
            
            
        }
        
        else
        {
            
        }
        
        return r;
    }

}
