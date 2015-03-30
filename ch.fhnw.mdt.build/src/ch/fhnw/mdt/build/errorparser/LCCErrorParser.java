package ch.fhnw.mdt.build.errorparser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.cdt.core.ErrorParserManager;
import org.eclipse.cdt.core.IErrorParser;
import org.eclipse.cdt.core.IMarkerGenerator;
import org.eclipse.core.resources.IFile;

public class LCCErrorParser implements IErrorParser {

	public LCCErrorParser() {
	}

	@Override
	public boolean processLine(final String line, final ErrorParserManager eoParser) {
		final Pattern filePattern =  Pattern.compile("(.*.c): (.+):(\\d+):(\\d+)? (.*)");
		final Matcher matcher = filePattern.matcher(line);
		final boolean find = matcher.find();
		
		if (!find) return false;
		
		try {
			String fileName = matcher.group(2);
			int lineNumber = Integer.valueOf(matcher.group(3));
			
			IFile file = eoParser.findFileName(fileName);
			String errorMessage = matcher.group(5);
			
			eoParser.generateMarker(file, lineNumber, errorMessage, IMarkerGenerator.SEVERITY_ERROR_RESOURCE, null);

			return true;
		} catch (Exception e) {
			// if something goes wrong while parsing the error line we just ignore it and therefore pass it to the next parser
			return false;
		}
	}

}
