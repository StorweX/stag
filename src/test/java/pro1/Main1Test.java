package pro1;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
public class Main1Test
{
    @Test
    void test01()
    {
        // TODO 1.2: Oprav test
        assertEquals(
                62,
                Main1.emptyActionsCount("KIKM",2024)
        );
    }
}