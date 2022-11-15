package lotto.view;

import lotto.domain.GameSet;
import lotto.domain.LottoProperties;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.List;

public class OutputLotto{
    public static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void printResult(GameSet gameSet) throws IOException {
        printPrefix();
        printGameCount(gameSet);
        printAllResult(gameSet);
        bw.flush();
    }
    private static void printPrefix() throws IOException{
        bw.append("당첨 통계\n");
        bw.append("---\n");
        bw.flush();
    }
    private static void printGameCount(GameSet gameSet) throws IOException{
        int i =0;
        for(LottoProperties name:LottoProperties.values()){
            if (name.getCorrect()==-1){
                break;
            }
            bw.append(String.format(name.getStrResultFormat(),name.getCorrect(),name.getSprice(),gameSet.getGameCount()[i++]));
        }
    }
    private static void printAllResult(GameSet gameSet) throws IOException{
        bw.append("총 수익률은 "+ gameSet.getResult()+"%입니다.\n");
    }
    public static void inputView_First(){
        try {
            bw.append("당첨 번호를 입력해 주세요.\n");
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void inputView_Second() {
        try {
            bw.append("보너스 번호를 입력해 주세요.\n");
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void initInput(){
        try {
            bw.append("구입금액을 입력해 주세요.\n");
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void buyView(int lottoCount){
        try {
            bw.append(lottoCount+"개를 구매했습니다.\n");
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void numberPrint(List<Integer> numbers){
        try {
            bw.append("[");
            for (int i = 0; i < numbers.size(); i++) {
                bw.append(numbers.get(i).toString());
                if (i != numbers.size() - 1) {
                    bw.append(", ");
                }
                if (i == numbers.size() - 1) {
                    bw.append("]\n");
                }
            }
            bw.flush();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public static void check(){
        try {
            bw.append("돌아옴\n");
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
