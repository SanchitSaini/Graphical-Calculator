package Calculator;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 *
 */
public class CharacterInterpreterTest {

    @Test
    public void testCompute() throws Exception {
        CharacterInterpreter c = new CharacterInterpreter();
        assertEquals(null, c.compute("sin("));

    }

    @Test
    public void testCompute2() throws Exception {
        CharacterInterpreter c = new CharacterInterpreter();
        assertEquals("5.0", c.compute("2.5*sqrt(4)"));

    }

    @Test
    public void testCompute3() throws Exception {
        CharacterInterpreter c = new CharacterInterpreter();
        assertEquals("160.0", c.compute("61+10^2-2*sin(30)"));

    }

    @Test
    public void testCompute4() throws Exception {
        CharacterInterpreter c = new CharacterInterpreter();
        assertEquals("32.0", c.compute("16*ceil(9.32)/floor(5.47)"));

    }

    @Test
    public void testHasPrecedence() throws Exception {
        CharacterInterpreter c = new CharacterInterpreter();
        assertTrue(c.hasPrecedence("*", "-"));
    }

    @Test
    public void testHasPrecedence2() throws Exception {
        CharacterInterpreter c = new CharacterInterpreter();
        assertFalse(c.hasPrecedence("-", "/"));
    }

    @Test
    public void testHasPrecedence3() throws Exception {
        CharacterInterpreter c = new CharacterInterpreter();
        assertFalse(c.hasPrecedence("^", "!"));
    }
}