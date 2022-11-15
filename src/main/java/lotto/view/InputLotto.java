package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.exception.ErrorHandler;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class InputLotto {
    public static List<Integer> getInput(){
        List<Integer> inputNumber = new ArrayList<>();
        char[] input = Console.readLine().replaceAll("[^0-9]","").toCharArray();
        for(char inputNum :input){
            inputNumber.add(inputNum-'0');
        }
        Collections.sort(inputNumber);
        return inputNumber;
    }
    public static int moneyInput(){
        int lottoCount = 0;
        InputPrintView.initInput();
        try{
            lottoCount=Integer.parseInt(Console.readLine());
        }catch (NumberFormatException n){
            ErrorHandler.unCorrectMoneyRangeException();
        }
        if(lottoCount%1000!=0){
            ErrorHandler.unCorrectMoneyInputException();
        }
        lottoCount/=1000;
        InputPrintView.buyView(lottoCount);
        return lottoCount;
    }
}
