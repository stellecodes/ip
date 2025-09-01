package smartstelle;

import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class DeadlineTest {
    @Test
    public void testConstructorValid() throws StelleException {
        String date = "2025-08-12T18:00";
        Deadline deadline = new Deadline("Eat", date, false);

        assertNotNull(deadline);
        assertEquals("Eat", deadline.getName());
        assertFalse(deadline.getIsCompleted());
        assertEquals(LocalDateTime.parse(date), deadline.getDate());
    }
}
