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
import meta.codeanywhere.manager.security.RuntimeExecPolicy;
import meta.codeanywhere.manager.security.WhileTruePolicy;
/**
 * This is NOT a web security manager
 * This is for the code to run on the server to be security
 * @author Biao Zhang
 * @version 11/16/2006
 */
public class SecurityManager {
	private static SecurityManager manager = null;
	static {
		manager = new SecurityManager();
		manager.addPolicy(new RuntimeExecPolicy());
		manager.addPolicy(new WhileTruePolicy());
	}
	public static SecurityManager getManager() {
		return manager;
	}
	private List<Policy> classLevelPolicy = null;
	private List<Policy> methodLevelPolicy = null;
	private List<Policy> statementLevelPolicy = null;
	
	private SecurityManager() {
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
	
	/**
	 * Check if the code contained in the source if security.
	 * @param source The source code
	 * @return Passed return true, else return false
	 */
	public boolean check(String source) {
		BufferedReader reader = new BufferedReader(new StringReader(source));
		String block = null;
		try {
			block = reader.readLine();
			while (block != null) {
				for (Policy policy: statementLevelPolicy) {
					if (!policy.check(block))
						return false;
				}
				block = reader.readLine();
			}
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}		
		return true;
	}
	
	public static void main(String[] args) {
		SecurityManager sm = SecurityManager.getManager();
		System.out.println(sm.check("while(true) {"));
	}
}
