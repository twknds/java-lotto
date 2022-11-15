package lotto.domain;

import lotto.exception.ErrorHandler;
import java.util.Arrays;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;
    public Lotto(List<Integer> numbers) {
        isUnique(numbers);
        validate(numbers);
        this.numbers = numbers;
    }
    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            ErrorHandler.sizeOverException();
        }
        for (int i = 0; i < 6; i++) {
            if (numbers.get(i) < 1 || numbers.get(i) > 45) {
                ErrorHandler.numberUnCorrectException();
            }
        }
    }
    public void isUnique(List<Integer> numbers) {
        if (numbers.size()!=Arrays.asList(numbers.stream().distinct().toArray()).size()){
            ErrorHandler.mutualInputException();
        }
    }
    public LottoProperties lotteryCheck(Lotto awardLotto, int bonusNumber){
        int correct = numberCheck(awardLotto);
        LottoProperties lottoProperties = LottoProperties.findType(correct);
        if (lottoProperties == LottoProperties.LOTTO_THIRDWINNER && isBonusCorrect(bonusNumber)){
            lottoProperties = LottoProperties.LOTTO_SECONDWINNER;
        }
        return lottoProperties;
    }
    public int numberCheck(Lotto awardLotto){
        int correct = 0;
        int i =0;
        int j =0;
        while (i<numbers.size() && j<awardLotto.getNumbers().size()) {
            if (numbers.get(i) == awardLotto.getNumbers().get(j)) {
                correct++;
                i++;
                j++;
                continue;
            }
            if (numbers.get(i) < awardLotto.getNumbers().get(j)) {
                i++;
                continue;
            }
            if (numbers.get(i) > awardLotto.getNumbers().get(j)) {
                j++;
                continue;
            }
        }
        return correct;
    }
    public Boolean isBonusCorrect(int bonusNumber){
        for(int i =0;i<numbers.size();i++){
            if (bonusNumber==numbers.get(i)){
                return true;
            }
        }
        return false;
    }
    public List<Integer> getNumbers() {
        return numbers;
    }
}
