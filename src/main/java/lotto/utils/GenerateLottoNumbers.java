package lotto.utils;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class GenerateLottoNumbers {
    final static int START_NUM = 1;
    final static int END_NUM = 45;
    final static int COUNT_NUM = 7;
    public List<Integer> generateLottoNumber() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(START_NUM, END_NUM, COUNT_NUM);
        return numbers;
    }
}
