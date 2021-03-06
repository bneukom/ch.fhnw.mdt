package ch.fhnw.mdt.forthdebugger.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ch.fhnw.mdt.forthdebugger.communication.ProcessCommunicator;
import ch.fhnw.mdt.forthdebugger.communication.ProcessCommunicator.CommandTimeOutException;
import ch.fhnw.mdt.forthdebugger.communication.process.IProcessDectorator;
import ch.fhnw.mdt.forthdebugger.test.TestProcess.Output;

public class TestCommandAwait {

	private IProcessDectorator process;
	private ProcessCommunicator communicator;

	
	
	@Test
	public void testAwaitResult() {
		try {
			communicator.sendCommandAwaitResult("foo", communicator.newAwaitResult("bar"));
		} catch (CommandTimeOutException e) {
			fail();
		}
		String lastLine = communicator.getCurrentLine();
		
		assertEquals(lastLine, "bar");
	}
	
	@Test
	public void testCommandCompletion() {
		final Object waiter = new Object();
		try {
			communicator.sendCommandForResult("foo", communicator.newAwaitMatch(".*r"), w -> {
				assertTrue(w.getResult().endsWith("bar"));
				
				synchronized (waiter) {
					waiter.notify();
				}
			});
		} catch (CommandTimeOutException e1) {
			fail();
		}
		
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
		
		communicator = new ProcessCommunicator(process, 5000);
	}

	@After
	public void after() {
	}

}
