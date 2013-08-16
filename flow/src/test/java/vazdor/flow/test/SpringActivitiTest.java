package vazdor.flow.test;

import static org.junit.Assert.assertNotNull;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/META-INF/flow-app-context-test.xml"})
public class SpringActivitiTest {

	/**
	 * Inject repository service
	 */
	@Resource
	private RepositoryService repositoryService;
	
	/**
	 * Inject runtime service
	 */	
	@Resource
	private RuntimeService runtimeService;
 
	/**
	 * Inject task service
	 */	
	@Resource
	private TaskService taskService;
	
	@Test
	public void startProcess() throws Exception {
 
		/*
		 * Deploy the process
		 */
		//repositoryService.createDeployment().enableDuplicateFiltering().addInputStream("HumanAndServiceTaskExample.bpmn20.xml",
		//new FileInputStream(filename)).deploy();
		repositoryService.createDeployment().enableDuplicateFiltering().addClasspathResource("processos/Exemplo.bpmn").deploy();
 
		Map<String, Object> variableMap = new HashMap<String, Object>();
		variableMap.put("processStartedBy", "Rafael");
		ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("Exemplo", variableMap);
 
		assertNotNull(processInstance.getId());
		System.out.println("id " + processInstance.getId() + " "
				+ processInstance.getProcessDefinitionId());
	}
	
	@Test
	public void claimAndCompleteHumanTask() throws Exception {
		List<Task> tasks= taskService.createTaskQuery().processDefinitionKey("Exemplo").taskDefinitionKey("usertask1").list();
		for(Task task:tasks){
			taskService.claim(task.getId(), "DJ");
			Map<String, Object> variableMap = new HashMap<String, Object>();
			variableMap.put("HumanTaskCompletedBy", "DJ");
			taskService.complete(task.getId(),variableMap);
		}
	}
}