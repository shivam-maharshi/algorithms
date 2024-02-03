package interview.google;

/**
 * https://leetcode.com/explore/interview/card/google/67/sql-2/472
 */
public class LicenseKeyFormatting {

    public String licenseKeyFormatting(String s, int k) {
        final String inputWithoutDashes = removeDashes(s);
        final String processedInput = toUpperCase(inputWithoutDashes);
        final StringBuilder resultStringBuilder = new StringBuilder();
        int currentSegmentCount = 0;

        for (int i=processedInput.length()-1; i>=0; i--) {
            if (currentSegmentCount == k) {
                resultStringBuilder.append("-");
                currentSegmentCount = 0;
            }
            resultStringBuilder.append(processedInput.charAt(i));
            currentSegmentCount++;
        }

        return resultStringBuilder.reverse().toString();
    }

    private String removeDashes(final String input) {
        return input.replace("-", "");
    }

    private String toUpperCase(final String input) {
        return input.toUpperCase();
    }

}
