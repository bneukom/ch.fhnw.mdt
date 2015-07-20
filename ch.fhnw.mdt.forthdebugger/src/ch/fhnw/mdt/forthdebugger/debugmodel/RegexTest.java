package ch.fhnw.mdt.forthdebugger.debugmodel;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTest {
public static void main(String[] args) {
	String line = "00000674: 80      0 0 ";
	String regex = "([A-Fa-f0-9]{8}): ([A-Fa-f0-9 ]{8}) ?([^\\s]+)(.*)";
	
	Pattern pattern = Pattern.compile("([A-Fa-f0-9]{8}): ([A-Fa-f0-9 ]{8}) ?([^\\s]+)(.*)");
	System.out.println(line.matches(regex));
	Matcher matcher = pattern.matcher(line);
	System.out.println(matcher.find());
	System.out.println(matcher.group(2));
}
}
