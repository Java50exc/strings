package telran.strings.test;

import static org.junit.jupiter.api.Assertions.*;
import static telran.strings.Strings.*;

import org.junit.jupiter.api.Test;

class StringsTest {

	@SuppressWarnings("unused")
	@Test
	void javaVariableTrueTest() {
		String regex = javaVariable();
		assertTrue("a".matches(regex));
		assertTrue("$".matches(regex)); int $;
		assertTrue("a123".matches(regex));
		assertTrue("__".matches(regex)); int __;
		assertTrue("_$".matches(regex)); int _$;
		assertTrue("$_".matches(regex)); int $_;
		assertTrue("aA".matches(regex));
		assertTrue("Aa".matches(regex));
		
	}
	@Test
	void javaVariableFalseTest() {
		String regex = javaVariable();
		assertFalse("1a".matches(regex));
		assertFalse("123".matches(regex));
		assertFalse("a&c".matches(regex));
		assertFalse("a C".matches(regex));
		assertFalse("_".matches(regex)); 
	}

}
