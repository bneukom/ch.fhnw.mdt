package ch.fhnw.mdt.debugger.lcc;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.eclipse.cdt.debug.core.cdi.CDIException;
import org.eclipse.cdt.debug.core.cdi.ICDILocation;
import org.eclipse.cdt.debug.core.cdi.model.ICDISignal;
import org.eclipse.cdt.debug.core.cdi.model.ICDIStackFrame;
import org.eclipse.cdt.debug.core.cdi.model.ICDITarget;
import org.eclipse.cdt.debug.core.cdi.model.ICDIThread;
import org.eclipse.cdt.debug.core.cdi.model.ICDIThreadStorage;
import org.eclipse.cdt.debug.core.cdi.model.ICDIThreadStorageDescriptor;

public class LCCThread implements ICDIThread {
	private Logger logger = Logger.getLogger(getClass().getName());
	private LCCTarget target;
	
	
	
	
	@Override
	public void stepOver(int count) throws CDIException {
		logger.log(Level.FINE, "stepOver()");
	}

	@Override
	public void stepOverInstruction(int count) throws CDIException {
		logger.log(Level.FINE, "stepOver()");
	}

	@Override
	public void stepInto(int count) throws CDIException {
		logger.log(Level.FINE, "stepOver()");
	}

	@Override
	public void stepIntoInstruction(int count) throws CDIException {
		logger.log(Level.FINE, "stepOver()");
	}

	@Override
	public void stepUntil(ICDILocation location) throws CDIException {
		logger.log(Level.FINE, "stepOver()");
	}

	@Override
	public void resume(boolean passSignal) throws CDIException {
		logger.log(Level.FINE, "stepOver()");
	}

	@Override
	public void resume(ICDILocation location) throws CDIException {
		logger.log(Level.FINE, "stepOver()");
	}

	@Override
	public void resume(ICDISignal signal) throws CDIException {
		logger.log(Level.FINE, "stepOver()");
	}

	@Override
	public void suspend() throws CDIException {
		logger.log(Level.FINE, "stepOver()");		
	}

	@Override
	public boolean isSuspended() {
		logger.log(Level.FINE, "stepOver()");
		return false;
	}

	@Override
	public ICDITarget getTarget() {
		logger.log(Level.FINE, "stepOver()");
		return null;
	}

	@Override
	public ICDIStackFrame[] getStackFrames() throws CDIException {
		return null;
	}

	@Override
	public ICDIStackFrame[] getStackFrames(int lowFrame, int highFrame) throws CDIException {
		return null;
	}

	@Override
	public int getStackFrameCount() throws CDIException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ICDIThreadStorageDescriptor[] getThreadStorageDescriptors() throws CDIException {
		return null;
	}

	@Override
	public ICDIThreadStorage createThreadStorage(ICDIThreadStorageDescriptor varDesc) throws CDIException {
		return null;
	}

	@Override
	public void resume() throws CDIException {
		
	}

	@Override
	public void stepOver() throws CDIException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void stepInto() throws CDIException {
		
	}

	@Override
	public void stepOverInstruction() throws CDIException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void stepIntoInstruction() throws CDIException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void stepReturn() throws CDIException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void runUntil(ICDILocation location) throws CDIException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void jump(ICDILocation location) throws CDIException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void signal() throws CDIException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void signal(ICDISignal signal) throws CDIException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean equals(ICDIThread thead) {
		// TODO Auto-generated method stub
		return false;
	}

}
