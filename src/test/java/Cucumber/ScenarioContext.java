package Cucumber;

import java.util.HashMap;
import java.util.Map;

public class ScenarioContext {
    
	private Map<String,Object> ScenarioContext;
	
	

	public ScenarioContext() {
		
		ScenarioContext = new HashMap<String,Object>();
	}

	public Object getScenarioContext(String Key) {
		return ScenarioContext.get(Key);
	}

	public void setScenarioContext(String Key, Object value) {
		 ScenarioContext.put(Key, value);
	}
	public Boolean isContains(String Key) {
		return ScenarioContext.containsKey(Key);
	}
	
}
