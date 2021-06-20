package basic;

import java.io.*;


// 10개의 데이터를 읽어서 최대값과 최소값의 차이를 출력
// 65 - 11 = 54
public class InputOutput {
    public static void main(String[] args) {
        try {
            String inputFilePath = "src/basic/input";
            String outputFilePath = "src/basic/output";
            String inputFileName = "/inputFile.txt";
            String outputFileName = "/outputFile.txt";

            BufferedReader bufferedReader = new BufferedReader(new FileReader(inputFilePath + inputFileName));
            int number = Integer.parseInt(bufferedReader.readLine());
            String[] value = bufferedReader.readLine().split(" ");

            int min = 2147000000;
            int max = -2147000000;

            for (int i = 0; i < number; i++) {
                int data = Integer.parseInt(value[i]);
                if (data > max) max = data;
                if (data < min) min = data;
            }

            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(outputFilePath + outputFileName));
            bufferedWriter.write(String.valueOf(max - min));
            bufferedWriter.flush();
            bufferedWriter.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
