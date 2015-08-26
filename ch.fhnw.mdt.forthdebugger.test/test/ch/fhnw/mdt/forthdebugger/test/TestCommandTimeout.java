package ch.fhnw.mdt.forthdebugger.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import ch.fhnw.mdt.forthdebugger.communication.ProcessCommunicator;
import ch.fhnw.mdt.forthdebugger.communication.ProcessCommunicator.CommandTimeOutException;
import ch.fhnw.mdt.forthdebugger.communication.process.IProcessDectorator;
import ch.fhnw.mdt.forthdebugger.test.TestProcess.Output;

public class TestCommandTimeout {

	private IProcessDectorator process;
	private ProcessCommunicator communicator;

	@Test(expected = CommandTimeOutException.class)
	public void testTimeout() throws CommandTimeOutException {
		communicator.sendCommandAwaitResult("foo", communicator.newAwaitResult("bar"));

		fail();
	}

	@Before
	public void before() {
		process = new TestProcess(s -> {
			switch (s) {
			case "foo":
				return new Output("bar", 1500);
			}
			return null;
		});

		communicator = new ProcessCommunicator(process, 10);
	}

	@After
	public void after() {
	}

}
