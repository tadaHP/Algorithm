import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int totalSubmissionCount = Integer.parseInt(reader.readLine());

        Map<String, List<GradingInfo>> map = new HashMap<>(); // userId, GradingInfo

        for(int i = 0 ; i < totalSubmissionCount; i++){
            String[] split = reader.readLine().split(" ");

            if(split[1].equals("megalusion")){

            }else{
                GradingInfo gradingInfo = new GradingInfo(split);

                List<GradingInfo> list = map.getOrDefault(split[1], new ArrayList<>());
                list.add(gradingInfo);
                map.put(split[1], list);
            }
        }

        int correctPersonCount = 0;
        int correctPersonFailureCount = 0;

        Set<String> keySet = map.keySet();

        for(String key : keySet){
            List<GradingInfo> list = map.get(key);
            int firstCorrectIdx = -1;
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).gradingResult == GradingResult.CORRECT) {
                    firstCorrectIdx = i;
                    break;
                }
            }

            if(firstCorrectIdx  >= 0){
                correctPersonCount++;
                correctPersonFailureCount += firstCorrectIdx;
            }
        }

        if(correctPersonCount < 1){
            writer.write('0');
        }else{ // 정답 비율 = (문제를 맞은 사람의 수) / ((문제를 맞은 사람의 수) + (문제를 맞은 각 사람이 그 문제를 맞기 전까지 틀린 횟수의 총 합)) × 100
            double answer = (double)correctPersonCount / (correctPersonCount+correctPersonFailureCount) * 100;

            writer.write(String.valueOf(answer));
        }

        writer.flush();

        reader.close();
        writer.close();
    }


    public static class GradingInfo{
        int number;
        String userId;
        GradingResult gradingResult;

        public GradingInfo(String[] args){
            this.number = Integer.parseInt(args[0]);
            this.userId = args[1];
            this.gradingResult = GradingResult.getGradingResult(Integer.parseInt(args[2]));
        }
    }


    public enum GradingResult {
        CORRECT(4),
        ERROR_RETURN(5),
        WRONG(6),
        TIME_OUT(7),
        ERROR_MEMORY_OVERFLOW(8),
        ERROR_OUTPUT_OVERFLOW(9),
        ERROR_RUNTIME(10),
        ERROR_COMPILE(11);


        private final int number;

        GradingResult(int number){
            this.number = number;
        }

        static GradingResult getGradingResult(int code){
            for (GradingResult result : values()) {
                if (result.number == code) {
                    return result;
                }
            }
            throw new IllegalArgumentException("Unknown grading code: " + code);
        }
    }
}