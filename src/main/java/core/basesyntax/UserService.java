package core.basesyntax;

import core.basesyntax.exception.UserNotFoundException;

public class UserService {

    public int getUserScore(String[] records, String email) {
        String[] splitRecords;

        for (int i = 0; i < records.length;i++) {
            splitRecords = records[i].split(":");
            if (splitRecords.length == 2 && splitRecords[0].equals(email)) {
                return Integer.parseInt(splitRecords[1]);
            }
        }
        throw new UserNotFoundException("User with given email doesn't exist");
    }
}
