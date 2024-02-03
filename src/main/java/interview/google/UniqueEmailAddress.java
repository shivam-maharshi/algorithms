package interview.google;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/explore/interview/card/google/67/sql-2/3044
 */
public class UniqueEmailAddress {

    public static int numUniqueEmails(String[] emails) {
        final Set<String> uniqueEmails = new HashSet<>();
        for (String email : emails) {
            final String[] emailWithSplitLocalDomain = email.split("@");
            final String domain = emailWithSplitLocalDomain[1];
            final String normalizedLocal = getNormalizedLocal(emailWithSplitLocalDomain[0]);
            uniqueEmails.add(normalizedLocal + "@" + domain);
        }
        return uniqueEmails.size();
    }

    private static String getNormalizedLocal(final String local) {
        final String localWithoutPeriods = local.replace(".", "");
        return localWithoutPeriods.split("\\+")[0];
    }

}
