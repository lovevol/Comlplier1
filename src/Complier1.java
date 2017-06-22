/**
 * Created by lh
 * on 2017/3/30.
 */
public class Complier1 {
    public static void main(String[] args){
        Analyze analyze = new Analyze();
        analyze.ReadAndAnalyze("test1.txt");
        analyze.ReadAndAnalyze("test2.txt");
        analyze.ReadAndAnalyze("test3.txt");
        analyze.ReadAndAnalyze("test4.txt");
        analyze.ReadAndAnalyze("test5.txt");

    }
}
