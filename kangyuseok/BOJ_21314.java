import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.*;

public class BOJ_21314 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());

        String str = br.readLine();

        //최댓값 구하기 MK 같이 처리
        int cnt = 0; //M개의 숫자 셀것
        String max = "";
        for(int i=0;i<str.length();i++){
            if(str.charAt(i) == 'K'){
                max+="5";
                max+=converter(cnt);
                cnt = 0;
            }
            else cnt++;
        }

        if(cnt > 0) { //맨 마지막 글자가 K가 아닐 경우
            for(int i=0;i<cnt;i++)max+="1";
        }

        //최솟값 구하기 MK 따로 처리
        cnt=0;
        String min = "";
        for(int i=0;i<str.length();i++){
            if(str.charAt(i) == 'K'){
                if(cnt > 0){
                    min+="1";
                    min += converter(cnt-1);
                }
                min += "5";
                cnt = 0;
            }
            else cnt++;
        }

        if(cnt > 0) { //맨 마지막 글자가 K가 아닐 경우
            min+="1";
            min += converter(cnt-1);
        }

        System.out.println(max);
        System.out.println(min);
    }
    static String converter(int cnt){
        String temp = "";
        for(int i=0;i<cnt;i++)temp+="0";
        return temp;
    }

}