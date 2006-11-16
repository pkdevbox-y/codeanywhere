/**
 * @(#)SecurityManager.java
 */
package meta.codeanywhere.manager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.List;

import meta.codeanywhere.manager.security.Policy;
/**
 * This is NOT a web security manager
 * This is for the code to run on the server to be security
 * @author Biao Zhang
 * @version 11/16/2006
 */
public class SecurityManager {
	private List<Policy> classLevelPolicy = null;
	private List<Policy> methodLevelPolicy = null;
	private List<Policy> statementLevelPolicy = null;
	
	public SecurityManager() {
		classLevelPolicy = new LinkedList<Policy>();
		methodLevelPolicy = new LinkedList<Policy>();
		statementLevelPolicy = new LinkedList<Policy>();
	}
	
	public void addPolicy(Policy policy) {
		switch (policy.getLevel()) {
		case ClassLevel:
			classLevelPolicy.add(policy);
			break;
		case MethodLevel:
			methodLevelPolicy.add(policy);
			break;
		case StatementLevel:
			statementLevelPolicy.add(policy);
			break;
		}
	}
	
	public boolean check(String source) {
		BufferedReader reader = new BufferedReader(new StringReader(source));
		String block = null;
		try {
			block = reader.readLine();
			while (block != null) {
				for (Policy policy: statementLevelPolicy) {
					if (policy.check(block))
						return false;
				}
				block = reader.readLine();
			}
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}		
		return true;
	}
}
