package ch.fhnw.mdt.forthdebugger.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import ch.fhnw.mdt.forthdebugger.communication.ProcessCommunicator;
import ch.fhnw.mdt.forthdebugger.communication.process.IProcessDectorator;
import ch.fhnw.mdt.forthdebugger.test.TestProcess.Output;

public class TestCommandAwait {

	private IProcessDectorator process;
	private ProcessCommunicator communicator;

	@Test
	public void testAwaitResult() {
		communicator.sendCommandAwaitResult("foo", communicator.waitForResultLater("bar"));
		String lastLine = communicator.getCurrentLine();
		
		assertEquals(lastLine, "bar");
	}
	
	@Test
	public void testCommandCompletion() {
		final Object waiter = new Object();
		communicator.sendCommandForResult("foo", communicator.waitForMatchLater(".*r"), w -> {
			assertEquals(w.getResult(), "bar");
			
			synchronized (waiter) {
				waiter.notify();
			}
		});
		
		synchronized (waiter) {
			try {
				waiter.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	@Before
	public void before() {
		process = new TestProcess(s -> {
			switch (s) {
			case "foo": 
				return new Output("bar", 1000);
			}
			return null;
		});
		
		communicator = new ProcessCommunicator(process);
	}

	@After
	public void after() {
		communicator.shutdown();
	}

}
