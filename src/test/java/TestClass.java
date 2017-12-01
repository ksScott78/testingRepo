import org.junit.*;

public class TestClass{

    @BeforeClass
    public static void init(){
        System.out.println("Init");
    }
    @Before
    public void setUp(){
        System.out.println("Set up");
    }

    @Test
    public void test1(){
        System.out.println("Testing");
    }

    @After
    public void tearDown(){
        System.out.println("Tear Down");
    }
    @AfterClass
    public static void destroy(){
        System.out.println("Destroy");
    }






}
