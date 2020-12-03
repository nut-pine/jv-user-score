package core.basesyntax;

import core.basesyntax.exception.UserNotFoundException;

public class UserService {

    public int getUserScore(String[] records, String email) {
        int score = 0;
        String[] splitRecords;
        String[] splitEmail = email.split(":");

        for (int i = 0; i < records.length; i++) {
            splitRecords = records[i].split(":");
            if (splitRecords[0].equals(splitEmail[0])) {
                score = Integer.parseInt(splitRecords[1]);
            }
        }

        //if splitEmail.length > 1, than we get wrong email format

        if (score == 0 | splitEmail.length > 1) {
            throw new UserNotFoundException("User with given email doesn't exist");
        }
        return score;
    }
}
