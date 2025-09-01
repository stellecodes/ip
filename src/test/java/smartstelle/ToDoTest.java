package smartstelle;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ToDoTest {
    @Test
    public void testConstructorValid() throws StelleException {
        ToDo todo = new ToDo("Ate", false);
        assertNotNull(todo);
        assertEquals("Ate", todo.getName());
        assertFalse(todo.getIsCompleted());
    }

    @Test
    public void testConstructorInvalidName() {
        assertThrows(StelleException.class, () -> new ToDo("", false));
    }
}
