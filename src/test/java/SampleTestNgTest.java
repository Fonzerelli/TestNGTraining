import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.internal.thread.ThreadTimeoutException;

/**
 *Test class.
 */
public class SampleTestNgTest {

    /**
     * constant.
     */
    private static final int THREE = 3;
    /**
     * another const.
     */
    private static final int THREE_THOUSAND = 3000;

    /**
     * @return Object[][] objects array
     */
    @DataProvider(name = "stringArrayDataProvider")
    public static Object[][] stringArrayDataProvider() {
        return new Object[][]{
                {new String[] {}, 0},
                {null, 0},
                {new String[] {"test1", "test2", "test3", "test1"}, THREE}
        };
    }

    /**
     *
     */
    @BeforeClass
    public final void oneTimeSetUp() {
        System.out.println("@BeforeClass - oneTimeSetUp");
    }

    /**
     *
     */
    @AfterClass
    public final void oneTimeTearDown() {
        System.out.println("@AfterClass - oneTimeTearDown");
    }


    /**
     *
     */
    @BeforeMethod
    public final void setUp() {
        System.out.println("@BeforeMethod - setUp before each test");
    }

    /**
     *
     */
    @AfterMethod
    public final void tearDown() {
        System.out.println("@AfterMethod - tearDown before each test");
    }


    /**
     *
     */
    @Test(expectedExceptions = Error.class)
    public final void testSystemOut() {
        System.out.println("SampleTestNg output from test ng test method");
        throw new Error("error");
    }

    /**
     *
     */
    @Test(enabled = false)
    public final void testFailure() {
        assert false;
    }
 /**
     *
  * @param array String[]
  * @param realCountOfDistinctStrings int
  */
    @Test(dataProvider = "stringArrayDataProvider")
    public final void testGetNumberOfDistinctStrings(final
            String[] array, final int realCountOfDistinctStrings) {

        int countOfDistinctStrings =
                SampleTestNg.getNumberOfDistinctStrings(array);
        assert countOfDistinctStrings == realCountOfDistinctStrings;
    }

    /**
     *
     */
    @Test(timeOut = THREE_THOUSAND,
            expectedExceptions = ThreadTimeoutException.class)
    public final void testTimeout() {
        try {
            Thread.sleep(THREE_THOUSAND);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        while (true) {}
    }
}
