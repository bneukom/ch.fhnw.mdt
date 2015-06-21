package ch.fhnw.mdt.debugger.lcc;

import java.io.IOException;
import java.math.BigInteger;

import org.eclipse.cdt.debug.core.cdi.CDIException;
import org.eclipse.cdt.debug.core.cdi.ICDIAddressLocation;
import org.eclipse.cdt.debug.core.cdi.ICDICondition;
import org.eclipse.cdt.debug.core.cdi.ICDIFunctionLocation;
import org.eclipse.cdt.debug.core.cdi.ICDILineLocation;
import org.eclipse.cdt.debug.core.cdi.ICDILocation;
import org.eclipse.cdt.debug.core.cdi.ICDISession;
import org.eclipse.cdt.debug.core.cdi.model.ICDIAddressBreakpoint;
import org.eclipse.cdt.debug.core.cdi.model.ICDIBreakpoint;
import org.eclipse.cdt.debug.core.cdi.model.ICDIExceptionpoint;
import org.eclipse.cdt.debug.core.cdi.model.ICDIExpression;
import org.eclipse.cdt.debug.core.cdi.model.ICDIFunctionBreakpoint;
import org.eclipse.cdt.debug.core.cdi.model.ICDIGlobalVariable;
import org.eclipse.cdt.debug.core.cdi.model.ICDIGlobalVariableDescriptor;
import org.eclipse.cdt.debug.core.cdi.model.ICDIInstruction;
import org.eclipse.cdt.debug.core.cdi.model.ICDILineBreakpoint;
import org.eclipse.cdt.debug.core.cdi.model.ICDIMemoryBlock;
import org.eclipse.cdt.debug.core.cdi.model.ICDIMixedInstruction;
import org.eclipse.cdt.debug.core.cdi.model.ICDIRegister;
import org.eclipse.cdt.debug.core.cdi.model.ICDIRegisterDescriptor;
import org.eclipse.cdt.debug.core.cdi.model.ICDIRegisterGroup;
import org.eclipse.cdt.debug.core.cdi.model.ICDIRuntimeOptions;
import org.eclipse.cdt.debug.core.cdi.model.ICDISharedLibrary;
import org.eclipse.cdt.debug.core.cdi.model.ICDISignal;
import org.eclipse.cdt.debug.core.cdi.model.ICDIStackFrame;
import org.eclipse.cdt.debug.core.cdi.model.ICDITarget;
import org.eclipse.cdt.debug.core.cdi.model.ICDITargetConfiguration;
import org.eclipse.cdt.debug.core.cdi.model.ICDIThread;
import org.eclipse.cdt.debug.core.cdi.model.ICDIWatchpoint;
import org.eclipse.cdt.debug.mi.core.cdi.LineLocation;
import org.eclipse.cdt.debug.mi.core.cdi.model.FunctionLocation;

import ch.fhnw.mdt.debugger.lcc.events.LCCResumedEvent;
import ch.fhnw.mdt.debugger.lcc.events.LCCSuspendedEvent;

// TODO parse AST and recieve information about breakpoints for enablement
public class LCCTarget implements ICDITarget {

	private LCCSession session;
	private LCCTargetConfiguration configuration;

	public LCCTarget(LCCSession session) {
		this.session = session;
		this.configuration = new LCCTargetConfiguration(this);
	}

	@Override
	public ICDIThread[] getThreads() throws CDIException {
		return new ICDIThread[0];
	}

	@Override
	public ICDIThread getCurrentThread() throws CDIException {
		return null;
	}

	@Override
	public ICDILineBreakpoint setLineBreakpoint(int type, ICDILineLocation location, ICDICondition condition, boolean deferred) throws CDIException {
		return new LCCLineBreakpoint(location.getFile(), null, null, location.getLineNumber(), this);
	}

	@Override
	public ICDIFunctionBreakpoint setFunctionBreakpoint(int type, ICDIFunctionLocation location, ICDICondition condition, boolean deferred) throws CDIException {
		return null;
	}

	@Override
	public ICDIAddressBreakpoint setAddressBreakpoint(int type, ICDIAddressLocation location, ICDICondition condition, boolean deferred) throws CDIException {
		return null;
	}

	@Override
	public ICDIWatchpoint setWatchpoint(int type, int watchType, String expression, ICDICondition condition) throws CDIException {
		return null;
	}

	@Override
	public ICDIExceptionpoint setExceptionBreakpoint(String clazz, boolean stopOnThrow, boolean stopOnCatch) throws CDIException {
		return null;
	}

	@Override
	public ICDIBreakpoint[] getBreakpoints() throws CDIException {
		return null;
	}

	@Override
	public void deleteBreakpoints(ICDIBreakpoint[] breakpoints) throws CDIException {

	}

	@Override
	public void deleteAllBreakpoints() throws CDIException {

	}

	@Override
	public void stepOver(int count) throws CDIException {

	}

	@Override
	public void stepOverInstruction(int count) throws CDIException {

	}

	@Override
	public void stepInto(int count) throws CDIException {

	}

	@Override
	public void stepIntoInstruction(int count) throws CDIException {

	}

	@Override
	public void stepUntil(ICDILocation location) throws CDIException {

	}

	@Override
	public void resume(boolean passSignal) throws CDIException {
		session.getLCCEventManager().fireEvent(new LCCResumedEvent(this));
		
		session.getLCCEventManager().fireEvent(new LCCSuspendedEvent(session, this));
	}

	@Override
	public void resume(ICDILocation location) throws CDIException {

	}

	@Override
	public void resume(ICDISignal signal) throws CDIException {

	}

	@Override
	public void suspend() throws CDIException {
		session.getLCCEventManager().fireEvent(new LCCSuspendedEvent(session, this));
	}

	@Override
	public boolean isSuspended() {
		return true;
	}

	@Override
	public ICDISignal[] getSignals() throws CDIException {
		return new ICDISignal[0];
	}

	@Override
	public ICDITarget getTarget() {
		return this;
	}

	@Override
	public ICDIExpression createExpression(String code) throws CDIException {
		return null;
	}

	@Override
	public ICDIExpression[] getExpressions() throws CDIException {
		return new ICDIExpression[0];
	}

	@Override
	public void destroyExpressions(ICDIExpression[] expressions) throws CDIException {

	}

	@Override
	public void destroyAllExpressions() throws CDIException {

	}

	@Override
	public void setSourcePaths(String[] srcPaths) throws CDIException {

	}

	@Override
	public String[] getSourcePaths() throws CDIException {
		return new String[0];
	}

	@Override
	public ICDIInstruction[] getInstructions(BigInteger startAddress, BigInteger endAddress) throws CDIException {
		return new ICDIInstruction[0];
	}

	@Override
	public ICDIInstruction[] getInstructions(String filename, int linenum) throws CDIException {
		return new ICDIInstruction[0];
	}

	@Override
	public ICDIInstruction[] getInstructions(String filename, int linenum, int lines) throws CDIException {
		return new ICDIInstruction[0];
	}

	@Override
	public ICDIMixedInstruction[] getMixedInstructions(BigInteger startAddress, BigInteger endAddress) throws CDIException {
		return new ICDIMixedInstruction[0];
	}

	@Override
	public ICDIMixedInstruction[] getMixedInstructions(String filename, int linenum) throws CDIException {
		return new ICDIMixedInstruction[0];
	}

	@Override
	public ICDIMixedInstruction[] getMixedInstructions(String filename, int linenum, int lines) throws CDIException {
		return new ICDIMixedInstruction[0];
	}

	@Override
	public ICDISharedLibrary[] getSharedLibraries() throws CDIException {
		return new ICDISharedLibrary[0];
	}

	@Override
	public ICDIMemoryBlock createMemoryBlock(String address, int units, int wordSize) throws CDIException {
		return null;
	}

	@Override
	public void removeBlocks(ICDIMemoryBlock[] memoryBlocks) throws CDIException {

	}

	@Override
	public void removeAllBlocks() throws CDIException {

	}

	@Override
	public ICDIMemoryBlock[] getMemoryBlocks() throws CDIException {
		return new ICDIMemoryBlock[0];
	}

	@Override
	public ICDISession getSession() {
		return session;
	}

	@Override
	public Process getProcess() {
		final ProcessBuilder processBuilder = new ProcessBuilder("/bin/bash");

		try {
			final Process process = processBuilder.start();
			return process;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ICDITargetConfiguration getConfiguration() {
		return configuration;
	}

	@Override
	public String evaluateExpressionToString(ICDIStackFrame context, String expressionText) throws CDIException {
		return null;
	}

	@Override
	public ICDIGlobalVariableDescriptor getGlobalVariableDescriptors(String filename, String function, String name) throws CDIException {
		return null;
	}

	@Override
	public ICDIGlobalVariable createGlobalVariable(ICDIGlobalVariableDescriptor varDesc) throws CDIException {
		return null;
	}

	@Override
	public ICDIRegisterGroup[] getRegisterGroups() throws CDIException {
		return new ICDIRegisterGroup[0];
	}

	@Override
	public ICDIRegister createRegister(ICDIRegisterDescriptor varDesc) throws CDIException {
		return null;
	}

	@Override
	public boolean isTerminated() {
		return false;
	}

	@Override
	public void terminate() throws CDIException {
		// TODO stop process
	}

	@Override
	public boolean isDisconnected() {
		return false;
	}

	@Override
	public void disconnect() throws CDIException {

	}

	@Override
	public void restart() throws CDIException {

	}

	@Override
	public void resume() throws CDIException {

	}

	@Override
	public void stepOver() throws CDIException {

	}

	@Override
	public void stepInto() throws CDIException {

	}

	@Override
	public void stepOverInstruction() throws CDIException {

	}

	@Override
	public void stepIntoInstruction() throws CDIException {

	}

	@Override
	public void runUntil(ICDILocation location) throws CDIException {

	}

	@Override
	public void jump(ICDILocation location) throws CDIException {

	}

	@Override
	public void signal() throws CDIException {

	}

	@Override
	public void signal(ICDISignal signal) throws CDIException {

	}

	@Override
	public ICDIRuntimeOptions getRuntimeOptions() {
		return null;
	}

	@Override
	public ICDICondition createCondition(int ignoreCount, String expression) {
		return null;
	}

	@Override
	public ICDICondition createCondition(int ignoreCount, String expression, String[] threadIds) {
		return null;
	}

	@Override
	public ICDILineLocation createLineLocation(String file, int line) {
		return new LineLocation(file, line);
	}

	@Override
	public ICDIFunctionLocation createFunctionLocation(String file, String function) {
		return new FunctionLocation(file, function);
	}

	@Override
	public ICDIAddressLocation createAddressLocation(BigInteger address) {
		return null;
	}
}
