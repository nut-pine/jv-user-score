package core.basesyntax;

import core.basesyntax.exception.UserNotFoundException;
import java.util.Arrays;

public class UserService {

    public int getUserScore(String[] records, String email) {
        int userScore = 0;

        if (isNotExist(records,email) != true) {
            userScore = getScore(records,email);
        }

        return userScore;
    }

    private static boolean isNotExist(String[] data, String email) {
        boolean emailIsFound = Arrays.asList(data).contains(email);

        if (data.length == 0 | emailIsFound) {
            throw new UserNotFoundException("User with given email doesn't exist");
        }

        return emailIsFound;
    }

    private static int getScore(String[] data, String email) {
        int score = 0;
        for (int i = 0; i < data.length; i++) {
            int index = data[i].indexOf(':');
            if (data[i].substring(0, index).equals(email)) {
                score = Integer.parseInt(data[i].replaceAll("[^0-9]", ""));
                return score;
            }
        }
        return score;
    }
}
