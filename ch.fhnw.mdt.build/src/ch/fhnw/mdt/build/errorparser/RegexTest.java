package ch.fhnw.mdt.build.errorparser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTest {
	public static void main(String[] args) {
		final String s = "../test.c: ../inc2.h:12: extraneous return value";
		
		
		Pattern filePattern =  Pattern.compile("(.*.c): (.+):(\\d+):(\\d+)? (.*)");
		Matcher matcher = filePattern.matcher(s);
		matcher.find();
		int groupCount = matcher.groupCount();
		for (int i = 0; i < 6; ++i) {
			String group2 = matcher.group(i);
			System.out.println(i + ": " + group2);
		}
		
//		System.out.println("\u22A5");
		
	}
}
