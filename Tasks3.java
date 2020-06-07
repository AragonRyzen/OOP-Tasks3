import java.util.Scanner;

public class Tasks3 {
    public static void main(String[] argc) {
        Scanner scanner = new Scanner(System.in);
//1

            System.out.println("������� 1");
            System.out.println("������� a");
            int a = scanner.nextInt();
            System.out.println("������� b");
            int b = scanner.nextInt();
            System.out.println("������� c");
            int c = scanner.nextInt();
            double D = Math.pow(b,2) - 4 * a * c;
            if (D > 0) {
                double x1 = (-b + Math.sqrt(D))/2*a;
                double x2 = (-b - Math.sqrt(D))/2*a;
                System.out.println("��������� ����� 2 ������� x1 = "+x1+" x2 = "+x2 );
            }
            if (D == 0) {
                double x = -b/2*a;
                System.out.println("��������� ����� 1 ������� x= "+x);
            }
            if (D < 0) {
                System.out.println("��������� ����� 0 �������");
            }


        //2
        System.out.println("������� 2");
        System.out.println("������� ������");
        String st = scanner.nextLine();
        int rez = findZip(st);
        if (rez == -1) {System.out.println("������� ��������� �� �������");}
        else {System.out.println("������ ������� ��������� -->" + rez);}


        //3
        System.out.println("������� 3");
        System.out.println("������� �����");
        int x = scanner.nextInt();
        System.out.println(checkPerfect(x));

        //4
        System.out.println("������� 3");
        System.out.println("������� ������");
        st = scanner.nextLine();
        System.out.println(flipEndChars(st));


        //5
        System.out.println("������� 5");
        System.out.println("������� ������");
        st = scanner.nextLine();
        System.out.println(isValidHexCode(st));

        //6
        System.out.println("������� 6");
        System.out.println("������� ������ ������� �������");
        int ln1 = scanner.nextInt();
        char[] arr1 = new char[ln1];
        for (int i=0; i<ln1; i++)
        {
            System.out.println("������� ������� ������� �������");
            arr1[i] = scanner.next().charAt(0);
        }

        System.out.println("������� ������ ������� �������");
        int ln2 = scanner.nextInt();
        char[] arr2 = new char[ln2];;

        for (int i=0; i<ln2; i++)
        {
            System.out.println("������� ������� ������� �������");
            arr2[i] = scanner.next().charAt(0);
        }
        System.out.println(same(arr1, arr2));



        //7
        System.out.println("������� 7");
        System.out.println("������� �����");
        int k = scanner.nextInt();
        System.out.println(isKaprekar(k));



        //8
        System.out.println("������� 8");
        System.out.println("������� ������");
        st = scanner.nextLine();
        System.out.println(longestZero(st));


        //9
        System.out.println("������� 9");
        System.out.println("������� �����");
        k = scanner.nextInt();
        System.out.println(nextPrime(k));



        //10
        System.out.println("������� 10");
        System.out.println("������� ������ �����");
        a = scanner.nextInt();
        System.out.println("������� ������ �����");
        b = scanner.nextInt();
        System.out.println("������� ������ �����");
        c = scanner.nextInt();
        System.out.println(rightTriangle(a,b,c));
    }


    public static int findZip(String str) {
        int frst = str.indexOf("zip");
        int tw = str.indexOf("zip", frst + 3);
        return tw;
    }

    public static boolean checkPerfect(int ch) {
            int sum = 0;
            for (int i = 1; i < ch; i++) {
                if (ch % i == 0) {
                    sum = sum + i;
                }
            }

        if (ch == sum) {
            return true;
        } else return false;
    }

    public static String flipEndChars(String str) {
        StringBuilder string = new StringBuilder(str);
        if (str.length() < 2) {
            return "������������";
        } else {
            if (str.charAt(0) == str.charAt(str.length() - 1)) {
                return "��� - ��� ����";
            } else {
                char l = str.charAt(0);
              /*str = str.replace(str.charAt(0), str.charAt(str.length() - 1));
              str = str.replace(str.charAt(str.length()- 1), l);*/
                string.setCharAt(0, str.charAt(str.length() - 1));
                string.setCharAt(str.length() - 1, l);
                str = string.toString();
                return str;
            }
        }

    }

    public static boolean isValidHexCode(String str) {
        boolean valid = false;
        int check = 0;
        if (str.length() == 7) {
            if (str.charAt(0) == '#') {
                for (int i = 1; i < str.length(); i++) {
                    if (((str.charAt(i) <= 'Z') && (str.charAt(i) >= 'A'))
                            || ((str.charAt(i) <= 'z') && (str.charAt(i) >= 'a'))
                            || ((str.charAt(i) <= '9') && (str.charAt(i) >= '0'))) {
                        check++;
                    }
                }
            }
        }
        if (check == str.length() - 1) {
            valid = true;
        }
        return valid;
    }

    public static boolean same(char[] ar1, char[] ar2) {
        char ch =' ';
        int kol1=0;
        int kol2=0;
        for (int i = 0; i < ar1.length; i++) {
          if (ar1[i] != ' ') { ch = ar1[i]; kol1 ++;}
            for (int j = i; j < ar1.length; j++) {
                if ((ar1[j] == ch) && (i != j)) {
                    ar1[j] = ' ';

                }
            }
        }

        for (int i = 0; i < ar2.length; i++) {
            if (ar2[i] != ' ') { ch = ar2[i]; kol2 ++;}
            for (int j = i; j < ar2.length; j++) {
                if ((ar2[j] == ch)) {
                    ar2[j] = ' ';

                }
            }
        }

        System.out.println(kol1);
        System.out.println(kol2);
        if (kol1 == kol2){ return true;}
        else return false;
    }


    public static boolean isKaprekar(int n) {
        if (n != 0 && n != 1) {
            int n2 = n*n;
            int temp = n2;
            int nlen;
            for(nlen = 1; (temp /= 10) > 0; ++nlen) {
            }

            int leftPart = nlen / 2;
            int rightPart = nlen - leftPart;
            int rightNum = (int)((double)n2 % Math.pow(10.0D, (double)rightPart));
            int leftNum = (int)((double)n2 / Math.pow(10.0D, (double)rightPart));
            return n == leftNum + rightNum;
        } else {
            return true;
        }
    }


    public static String longestZero (String str)
    {
        int ln = 0;
        int outerln = 0;
        String outerstr = "";
        for (int i=0; i<str.length(); i++)
        {
            if (str.charAt(i) == '1')
            {
                if (ln>outerln) {outerln = ln; ln=0; }
            }

            if (str.charAt(i) == '0')
            {
                ln++;
            }

            if ((i == str.length())&&( str.charAt(str.length())=='0'))
            {
                ln++;
                if (ln>outerln) {outerln = ln; ln=0; }
            }

            if ((i == str.length())&&( str.charAt(str.length())=='1'))
            {
                if (ln>outerln) {outerln = ln; ln=0; }
            }
        }

for (int i = 0; i<outerln; i++)
{
 outerstr += '0';
}
return outerstr;
    }



    public static int nextPrime(int num) {
        int enters = 0;

        int i;
        for(i = 1; i < num; ++i) {
            if (num % i == 0) {
                enters++;
            }
        }

        if (enters == 1) {
            return num;
        } else {
            num++;

            while(true) {
                enters = 0;

                for(i = 1; i < num; ++i) {
                    if (num % i == 0) {
                        enters++;
                    }
                }

                if (enters == 1) {
                    return num;
                }

                num++;
            }
        }
    }


    public static boolean rightTriangle(int x, int y, int z) {
        if (Math.abs(Math.sqrt((double)(x * x + y * y)) - (double)z) < 1.0E-7D) {
            return true;
        } else if (Math.abs(Math.sqrt((double)(y * y + z * z)) - (double)x) < 1.0E-7D) {
            return true;
        } else {
            return Math.abs(Math.sqrt((double)(x * x + z * z)) - (double)y) < 1.0E-7D;
        }
    }

}


