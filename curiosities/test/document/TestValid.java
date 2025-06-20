package document;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestValid {

    @Test
    public void test() {

        ValidDoc vd = new DocumentCpf();

        assertTrue(vd.valided("393.660.111-92"));
        assertFalse(vd.valided("123.123.123-11"));

    }
}
