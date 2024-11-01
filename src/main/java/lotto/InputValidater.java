package lotto;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class InputValidater {
    public static List<Integer> validateWiningNumbers(String inputWinningNumbers) {
        List<Integer> winningNumbers = Arrays.stream(inputWinningNumbers
                .split(","))
                .map(Integer::parseInt)
                .toList();                              //당첨 번호를 HashSet으로 관리하는것 고려

        HashSet<Integer> set = new HashSet<>();
        for (int number : winningNumbers) {
            //중복값 검사
            if (!set.add(number)) {
                throw new IllegalArgumentException("[ERROR] 당첨 번호에 중복 되는 값이 없어야 합니다.");
            }
            //당첨 번호가 1 ~ 45 사이의 값이 아닐 때 (공통)
            validateNumberRange(number);
        }
        //당첨 번호가 총 개수가 6개가 아닐 때
        if (winningNumbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호의 개수는 6개여야 합니다.");
        }

        return winningNumbers;
    }

    public static void validateBonusNumber(List<Integer> winningNumbers, int bonusNumber) {
        //보너스 번호가 당첨 번호 6개와 중복되는 수 일때
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호 6개와 중복 되지 않아야 합니다.");
        }
        //보너스 번호가 1 ~ 45 사이의 값이 아닐 때 (공통)
        validateNumberRange(bonusNumber);
    }

    private static void validateNumberRange(int number) {
        if (number > 45 || number < 1) {
            throw new IllegalArgumentException("[ERROR] 번호는 1 ~ 45 사이의 숫자여야 합니다.");
        }
    }
}