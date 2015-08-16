package ch.fhnw.mdt.forthdebugger.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.Arrays;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ch.fhnw.mdt.forthdebugger.communication.ProcessCommunicator;
import ch.fhnw.mdt.forthdebugger.communication.ProcessCommunicator.CommandTimeOutException;
import ch.fhnw.mdt.forthdebugger.communication.ProcessCommunicator.WaitForResult;
import ch.fhnw.mdt.forthdebugger.communication.process.IProcessDectorator;
import ch.fhnw.mdt.forthdebugger.test.TestProcess.Output;

public class StressTest {

	private IProcessDectorator process;
	private ProcessCommunicator communicator;

	private static final int THREAD_COUNT = 3;
	private static final int COMMAND_COUNT = 3;
	
	
	@Test
	public void stressTest() {
		
		final Thread[] threads = new Thread[THREAD_COUNT];
		
		for (int thread = 0; thread < THREAD_COUNT; ++thread) {
			threads[thread] = new Thread(() -> {
				for (int i = 0; i < COMMAND_COUNT; ++i) {
					try {
						WaitForResult newWaitForResultLater = communicator.newAwaitResult("bar");
						communicator.sendCommandAwaitResult("foo", newWaitForResultLater);
						
						final String result = newWaitForResultLater.getResult();
						assertEquals(result, "bar");
					} catch (CommandTimeOutException e) {
						fail();
					}
				}
				
			});
			
			threads[thread].start();
		}
		
		Arrays.stream(threads).forEach(t -> {
			try {
				t.join();
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
		
		
	}
	

	@Before
	public void before() {
		process = new TestProcess(s -> {
			switch (s) {
			case "foo": 
				return new Output("bar", 100);
			}
			return null;
		});
		
		communicator = new ProcessCommunicator(process, 1000);
	}

	@After
	public void after() {
	}

}
