package ch.fhnw.mdt.build.errorparser;

import org.eclipse.cdt.core.ErrorParserManager;
import org.eclipse.cdt.core.IErrorParser;

public class LCCErrorParser implements IErrorParser {

	public LCCErrorParser() {
	}

	@Override
	public boolean processLine(String line, ErrorParserManager eoParser) {
//		eoParser.findFileName("../blake32.h")
		return true;
	}

}
