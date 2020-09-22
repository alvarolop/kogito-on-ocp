package org.acme.travels;

import org.jbpm.process.core.datatype.impl.type.ObjectDataType;
import org.jbpm.ruleflow.core.RuleFlowProcessFactory;
import org.drools.core.util.KieFunctions;

@org.springframework.stereotype.Component("scripts")
public class ScriptsProcess extends org.kie.kogito.process.impl.AbstractProcess<org.acme.travels.ScriptsModel> {

    @org.springframework.beans.factory.annotation.Autowired(required = false)
    java.util.Collection<org.kie.api.runtime.process.WorkItemHandler> handlers;

    org.kie.kogito.app.Application app;

    public ScriptsProcess() {
    }

    @org.springframework.beans.factory.annotation.Autowired()
    public ScriptsProcess(org.kie.kogito.app.Application app) {
        super(app.config().process());
        this.app = app;
    }

    public org.acme.travels.ScriptsProcessInstance createInstance(org.acme.travels.ScriptsModel value) {
        return new org.acme.travels.ScriptsProcessInstance(this, value, this.createProcessRuntime());
    }

    public org.acme.travels.ScriptsProcessInstance createInstance(java.lang.String businessKey, org.acme.travels.ScriptsModel value) {
        return new org.acme.travels.ScriptsProcessInstance(this, value, businessKey, this.createProcessRuntime());
    }

    public org.acme.travels.ScriptsModel createModel() {
        return new org.acme.travels.ScriptsModel();
    }

    public org.acme.travels.ScriptsProcessInstance createInstance(org.kie.kogito.Model value) {
        return this.createInstance((org.acme.travels.ScriptsModel) value);
    }

    public org.acme.travels.ScriptsProcessInstance createInstance(java.lang.String businessKey, org.kie.kogito.Model value) {
        return this.createInstance(businessKey, (org.acme.travels.ScriptsModel) value);
    }

    public org.acme.travels.ScriptsProcessInstance createInstance(org.kie.api.runtime.process.WorkflowProcessInstance wpi) {
        return new org.acme.travels.ScriptsProcessInstance(this, this.createModel(), this.createProcessRuntime(), wpi);
    }

    public org.acme.travels.ScriptsProcessInstance createReadOnlyInstance(org.kie.api.runtime.process.WorkflowProcessInstance wpi) {
        return new org.acme.travels.ScriptsProcessInstance(this, this.createModel(), wpi);
    }

    public ScriptsProcess configure() {
        super.configure();
        return this;
    }

    protected void registerListeners() {
    }

    public org.kie.api.definition.process.Process process() {
        RuleFlowProcessFactory factory = RuleFlowProcessFactory.createProcess("scripts");
        factory.variable("name", new ObjectDataType("java.lang.String"), "customTags", null);
        factory.variable("message", new ObjectDataType("java.lang.String"), "customTags", null);
        factory.name("scripts");
        factory.packageName("org.acme.travels");
        factory.dynamic(false);
        factory.version("1.0");
        factory.visibility("Public");
        factory.metaData("TargetNamespace", "http://www.omg.org/bpmn20");
        org.jbpm.ruleflow.core.factory.EndNodeFactory endNode1 = factory.endNode(1);
        endNode1.name("End Process");
        endNode1.terminate(false);
        endNode1.metaData("UniqueId", "_CFA059DC-2FC1-4151-A3EC-990F0B4E3236");
        endNode1.metaData("elementname", "End Process");
        endNode1.metaData("x", 967);
        endNode1.metaData("width", 56);
        endNode1.metaData("y", 164);
        endNode1.metaData("height", 56);
        endNode1.done();
        org.jbpm.ruleflow.core.factory.StartNodeFactory startNode2 = factory.startNode(2);
        startNode2.name("StartProcess");
        startNode2.interrupting(true);
        startNode2.metaData("UniqueId", "_D02D169A-0CF1-4276-93FC-96FD33057A83");
        startNode2.metaData("elementname", "StartProcess");
        startNode2.metaData("x", 363);
        startNode2.metaData("width", 56);
        startNode2.metaData("y", 164);
        startNode2.metaData("height", 56);
        startNode2.done();
        org.jbpm.ruleflow.core.factory.ActionNodeFactory actionNode3 = factory.actionNode(3);
        actionNode3.name("Say Hello");
        actionNode3.action(kcontext -> {
            java.lang.String name = (java.lang.String) kcontext.getVariable("name");
            System.out.println("Hello " + name);;
        });
        actionNode3.metaData("UniqueId", "_8E2E0452-86B3-4B86-B8A1-CE3B78B0B2EC");
        actionNode3.metaData("elementname", "Say Hello");
        actionNode3.metaData("NodeType", "ScriptTask");
        actionNode3.metaData("x", 499);
        actionNode3.metaData("width", 154);
        actionNode3.metaData("y", 141);
        actionNode3.metaData("height", 102);
        actionNode3.done();
        org.jbpm.ruleflow.core.factory.ActionNodeFactory actionNode4 = factory.actionNode(4);
        actionNode4.name("Update Message");
        actionNode4.action(kcontext -> {
            java.lang.String name = (java.lang.String) kcontext.getVariable("name");
            java.lang.String message = (java.lang.String) kcontext.getVariable("message");
            kcontext.setVariable("message", "Hello " + name);;
        });
        actionNode4.metaData("UniqueId", "_E96920FB-69BF-4C28-9F65-FC3EFAF29AD9");
        actionNode4.metaData("elementname", "Update Message");
        actionNode4.metaData("NodeType", "ScriptTask");
        actionNode4.metaData("x", 733);
        actionNode4.metaData("width", 154);
        actionNode4.metaData("y", 141);
        actionNode4.metaData("height", 102);
        actionNode4.done();
        factory.connection(4, 1, "_FEBCC225-139C-47B0-BA16-7878EEE3532D");
        factory.connection(2, 3, "_80DA9F1E-743F-4BAF-BFF3-67DDC905E3B7");
        factory.connection(3, 4, "_B4A85C14-EA42-43CA-9BA2-CB92E32FACF5");
        factory.validate();
        return factory.getProcess();
    }

    @javax.annotation.PostConstruct()
    public void init() {
        this.activate();
    }
}
