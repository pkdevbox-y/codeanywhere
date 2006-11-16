/**
 * @(#)WhileTruePolicy.java
 */
package meta.codeanywhere.manager.security;

/**
 * Detect the dead loop
 * @author Biao Zhang
 * @version 11/16/2006
 */
public class WhileTruePolicy extends Policy {

	public WhileTruePolicy() {
		level = PolicyLevel.StatementLevel;
	}
	
	@Override
	public boolean check(String block) {
		if (block.matches(".*while\\(true\\).*"))
			return false;
		if (block.matches(".*for\\(;;\\).*"))
			return false;
		return true;
	}

}
