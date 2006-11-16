/**
 * 
 */
package meta.codeanywhere.manager.security;

/**
 * @author Biao Zhang
 *
 */
public class RuntimeExecPolicy extends Policy {

	public RuntimeExecPolicy() {
		level = PolicyLevel.StatementLevel;
	}
	
	@Override
	public boolean check(String block) {
		if (block.matches(".*exec(.*);")) {
			return false;
		}
		return true;
	}

}
