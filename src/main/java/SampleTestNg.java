import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * some package info.
 *
 */
public final class SampleTestNg {

    /**
     * private constructor.
     */
    private SampleTestNg() {
    }

    /**
     * @param args array of strings from standart input
     */
    public static void main(final String[] args) {
        System.out.println("Main method executed.");
    }

    /**
     * @param strings strings
     * @return int distinct count
     */
    public static int getNumberOfDistinctStrings(final String... strings) {
        int distinctStringsNumber = 0;
        if (strings != null && strings.length > 0) {
            Set<String> stringSet = new HashSet<>(Arrays.asList(strings));
            distinctStringsNumber = stringSet.size();
        }
        return distinctStringsNumber;
    }

}
