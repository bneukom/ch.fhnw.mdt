package ch.fhnw.mdt.platform.windows;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Able to enumerate all available com ports via the mode command.
 *
 */
public class ComPortEnumerator {

	private final Pattern comPattern = Pattern.compile("Status for device (COM[0-9]+):");

	public List<String> listPorts() {
		final ProcessBuilder process = new ProcessBuilder("cmd", "/c mode");
		final List<String> ports = new ArrayList<>();
		try {
			final Process p = process.start();

			// wait until done, or timeout
			p.waitFor(5, TimeUnit.SECONDS);

			final InputStream inputStream = p.getInputStream();
			final BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

			String line = null;
			while ((line = reader.readLine()) != null) {
				final Matcher matcher = comPattern.matcher(line);

				// found a com port
				if (matcher.matches()) {
					ports.add(matcher.group(1));
				}
			}
		} catch (final Exception e) {
			// ignore and just return empty port list
		}

		return ports;
	}
}
