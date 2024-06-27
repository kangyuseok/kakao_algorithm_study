package somin;

import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class BOJ_21314 {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        findMax(str);
        findMin(str);
    }

    public static void findMax(String str) {
        StringBuilder result = new StringBuilder();
        boolean isExistM = false;
        int cntM = 0;

        for (int i=0; i<str.length(); i++) {
            if (str.charAt(i) == 'K' && isExistM) {
                BigInteger n = BigInteger.TEN.pow(cntM).multiply(BigInteger.valueOf(5));
                result.append(n);
                isExistM = false;
                cntM = 0;
            } else if (str.charAt(i) == 'K' && !isExistM) {
                result.append(5);
            } else {
                isExistM = true;
                cntM++;
            }
        }

        if (cntM != 0) {
            for (int i=0; i<cntM; i++) {
                result.append(1);
            }
        }

        System.out.println(result);
    }

    public static void findMin(String str) {
        StringBuilder result = new StringBuilder();
        int cntM = 0;
        boolean isExistM = false;

        for (int i=0; i<str.length(); i++) {
            if (str.charAt(i) == 'K' && isExistM) {
                BigInteger n = BigInteger.TEN.pow(cntM-1);
                result.append(n);
                result.append(5);
                isExistM = false;
                cntM = 0;
            } else if (str.charAt(i) == 'K' && !isExistM) {
                result.append(5);
            } else {
                isExistM = true;
                cntM++;
            }
        }

        if (cntM != 0) {
            if (cntM == 1) result.append(1);
            else result.append(BigInteger.TEN.pow(cntM-1));
        }

        System.out.println(result);
    }
}