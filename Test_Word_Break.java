package Week_3;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class Test_Word_Break {

	@Test
	void test_NullString() {
		List<String> dict=new ArrayList<>();
		dict.add("you");
		dict.add("enjoy");
		assertEquals(false,Word_Break.wordBreak(null, dict));
	}
	void test_EmptyDict() {
		List<String> dict=new ArrayList<>();
		assertEquals(false,Word_Break.wordBreak("helloWorld", dict));
	}
	void test_ValidTest_wordsFormingPrefix() {
		List<String> dict=new ArrayList<>();
		dict.add("aaa");
		dict.add("aaaa");
		assertEquals(true,Word_Break.wordBreak("aaaaaaa", dict));
	}
	void test_ValidTest_wordsNotFormingPrefix() {
		List<String> dict=new ArrayList<>();
		dict.add("who");
		dict.add("are");
		dict.add("you");
		dict.add("am");
		dict.add("i");
		assertEquals(true,Word_Break.wordBreak("whoami", dict));
	}
	void test_ValidTest_False() {
		List<String> dict=new ArrayList<>();
		dict.add("i");
		dict.add("ate");
		dict.add("apple");
		assertEquals(false,Word_Break.wordBreak("ieatApple", dict));
	}


}
