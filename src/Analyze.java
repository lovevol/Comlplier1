import java.io.*;
import java.util.*;

/**
 * Created by lh
 * on 2017/3/30.
 */
public class Analyze {
    public void ReadAndAnalyze(String fileName) {
        File fileR = new File("res/" + fileName);//读取文件作为输入和输出
        File fileW = new File("res/resultOf" + fileName);
        FileReader fileReader = null;
        FileWriter fileWriter = null;
        BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;
        Set<String> setOfBasic = new TreeSet<>(Arrays.asList("begin", "call", "const",
                "do", "end", "if", "odd", "procedure", "read", "then", "var", "while", "write"));//基本字
        List<String> listOfText = new LinkedList<>();
        Map<String, Integer> map = new LinkedHashMap<>();
        try {
            fileReader = new FileReader(fileR);
            fileWriter = new FileWriter(fileW);
            bufferedReader = new BufferedReader(fileReader);
            bufferedWriter = new BufferedWriter(fileWriter);
            String str = null;
            while ((str = bufferedReader.readLine()) != null) {
                Collections.addAll(listOfText, str.toLowerCase().split("[^a-zA-Z0-9]+"));//把读取到的每行字符串进行分割，保存
            }
            //去除数值和空串
            listOfText.removeIf(string -> string.matches("[0-9]+") || string.matches(""));
            bufferedReader.close();
            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //System.out.println(listOfText);//测试输出
        for (String ident : listOfText) {//除去基本字，剩余的为标识符
            if (!setOfBasic.contains(ident)) {
                Integer fre = map.get(ident);//获取ident在map中的值，如果无，返回null
                map.put(ident, fre == null ? 1 : fre + 1);//统计出现次数
            }
        }
        //System.out.println(map);//测试输出
        Set<String> setOfMap = map.keySet();//获取键的集合
        for (String string : setOfMap) {
            String s;
            s = "(" + string + ":" + map.get(string) + ")";//格式化

            try {
                assert bufferedWriter != null;
                bufferedWriter.write(s + " ");//写入文件
                bufferedWriter.newLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try {
            assert bufferedReader != null;
            bufferedWriter.flush();
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
