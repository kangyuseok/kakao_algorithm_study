import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.*;

public class BOJ_16937 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int sticker = Integer.parseInt(st.nextToken());

        List<int[]>list = new ArrayList<>();
        for(int i=0;i<sticker;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.add(new int[]{a, b});
        }

        List<int[]>tempList = new ArrayList<>();

        int answer = 0;
        for(int i=0;i<list.size();i++){
            int sum = 0;
            int a = list.get(i)[0];
            int b = list.get(i)[1];
            tempList.add(new int[]{h-a, w});
            tempList.add(new int[]{h-b, w});
            tempList.add(new int[]{h, w-a});
            tempList.add(new int[]{h, w-b});
            sum += (a*b);
            //System.out.println(a + " " + b);

            for(int j = i+1;j<list.size();j++){
                boolean isComplete = false;
                int tempA = list.get(j)[0];
                int tempB = list.get(j)[1];
                //System.out.println("tempA " + tempA + " " + tempB);
                for(int k = 0;k<4;k++){
                    int tempC = tempList.get(k)[0];
                    int tempD = tempList.get(k)[1];
                    //System.out.println("tempC " +tempC+ " " +tempD);

                    if((tempA <= tempC && tempB <= tempD) || (tempA <= tempD && tempB <= tempC)){
                        //System.out.println("들어가는 사각형 " +tempA + " " + tempB);
                        sum +=(tempA * tempB);
                        isComplete = true;
                        break;
                    }
                }

                if(isComplete) {
                    answer = Math.max(answer, sum);
                    sum -=(tempA * tempB);
                }
            }
            tempList.clear();
        }
        System.out.println(answer);

    }
}