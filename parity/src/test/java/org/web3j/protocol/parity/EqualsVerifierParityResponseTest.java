package org.web3j.protocol.parity;

import java.math.BigInteger;
import java.util.ArrayList;

import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;
import org.junit.Test;

import org.web3j.protocol.parity.methods.response.FullTraceInfo;
import org.web3j.protocol.parity.methods.response.ParityAllAccountsInfo;
import org.web3j.protocol.parity.methods.response.StateDiff;
import org.web3j.protocol.parity.methods.response.Trace;
import org.web3j.protocol.parity.methods.response.VMTrace;

public class EqualsVerifierParityResponseTest {

    @Test
    public void testAccountsInfo() {
        EqualsVerifier.forClass(ParityAllAccountsInfo.AccountsInfo.class)
                .suppress(Warning.NONFINAL_FIELDS)
                .suppress(Warning.STRICT_INHERITANCE)
                .verify();
    }


    @Test
    public void testFullTraceInfo() {
        VMTrace vmTrace1 = new VMTrace("one", new ArrayList<VMTrace.VMOperation>());
        VMTrace vmTrace2 = new VMTrace("two", new ArrayList<VMTrace.VMOperation>());

        EqualsVerifier.forClass(FullTraceInfo.class)
                .withPrefabValues(VMTrace.class, vmTrace1, vmTrace2)
                .suppress(Warning.NONFINAL_FIELDS)
                .suppress(Warning.STRICT_INHERITANCE)
                .verify();
    }

    @Test
    public void testStateDiff() {
        EqualsVerifier.forClass(StateDiff.class)
                .suppress(Warning.NONFINAL_FIELDS)
                .suppress(Warning.STRICT_INHERITANCE)
                .verify();
    }

    @Test
    public void testChangedState() {
        EqualsVerifier.forClass(StateDiff.ChangedState.class)
                .suppress(Warning.NONFINAL_FIELDS)
                .suppress(Warning.STRICT_INHERITANCE)
                .verify();
    }

    @Test
    public void testUnchangedState() {
        EqualsVerifier.forClass(StateDiff.UnchangedState.class)
                .suppress(Warning.NONFINAL_FIELDS)
                .suppress(Warning.STRICT_INHERITANCE)
                .verify();
    }

    @Test
    public void testAddedState() {
        EqualsVerifier.forClass(StateDiff.AddedState.class)
                .suppress(Warning.NONFINAL_FIELDS)
                .suppress(Warning.STRICT_INHERITANCE)
                .verify();
    }

    @Test
    public void testVMTrace() {
        VMTrace.VMOperation op1 = new VMTrace.VMOperation(
                null, BigInteger.ZERO, null, null);
        VMTrace.VMOperation op2 = new VMTrace.VMOperation(
                null, BigInteger.ONE, null, null);

        EqualsVerifier.forClass(VMTrace.class)
                .withPrefabValues(VMTrace.VMOperation.class, op1, op2)
                .suppress(Warning.NONFINAL_FIELDS)
                .suppress(Warning.STRICT_INHERITANCE)
                .verify();
    }

    @Test
    public void testVMTraceVMOperation() {
        VMTrace vmTrace1 = new VMTrace("one", new ArrayList<VMTrace.VMOperation>());
        VMTrace vmTrace2 = new VMTrace("two", new ArrayList<VMTrace.VMOperation>());

        EqualsVerifier.forClass(VMTrace.VMOperation.class)
                .withPrefabValues(VMTrace.class, vmTrace1, vmTrace2)
                .suppress(Warning.NONFINAL_FIELDS)
                .suppress(Warning.STRICT_INHERITANCE)
                .verify();
    }

    @Test
    public void testVMTraceVMOperationEx() {
        EqualsVerifier.forClass(VMTrace.VMOperation.Ex.class)
                .suppress(Warning.NONFINAL_FIELDS)
                .suppress(Warning.STRICT_INHERITANCE)
                .verify();
    }

    @Test
    public void testVMTraceVMOperationExMem() {
        EqualsVerifier.forClass(VMTrace.VMOperation.Ex.Mem.class)
                .suppress(Warning.NONFINAL_FIELDS)
                .suppress(Warning.STRICT_INHERITANCE)
                .verify();
    }

    @Test
    public void testVMTraceVMOperationExStore() {
        EqualsVerifier.forClass(VMTrace.VMOperation.Ex.Store.class)
                .suppress(Warning.NONFINAL_FIELDS)
                .suppress(Warning.STRICT_INHERITANCE)
                .verify();
    }

    @Test
    public void testTrace() {
        EqualsVerifier.forClass(Trace.class)
                .suppress(Warning.NONFINAL_FIELDS)
                .suppress(Warning.STRICT_INHERITANCE)
                .verify();
    }

    @Test
    public void testTraceSuicideAction() {
        EqualsVerifier.forClass(Trace.SuicideAction.class)
                .suppress(Warning.NONFINAL_FIELDS)
                .suppress(Warning.STRICT_INHERITANCE)
                .verify();
    }

    @Test
    public void testTraceCallAction() {
        EqualsVerifier.forClass(Trace.CallAction.class)
                .suppress(Warning.NONFINAL_FIELDS)
                .suppress(Warning.STRICT_INHERITANCE)
                .verify();
    }

    @Test
    public void testTraceCreateAction() {
        EqualsVerifier.forClass(Trace.CreateAction.class)
                .suppress(Warning.NONFINAL_FIELDS)
                .suppress(Warning.STRICT_INHERITANCE)
                .verify();
    }

    @Test
    public void testTraceResult() {
        EqualsVerifier.forClass(Trace.Result.class)
                .suppress(Warning.NONFINAL_FIELDS)
                .suppress(Warning.STRICT_INHERITANCE)
                .verify();
    }

}
