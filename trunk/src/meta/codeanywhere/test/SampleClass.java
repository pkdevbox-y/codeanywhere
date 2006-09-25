package meta.codeanywhere.test;
import java.io.PrintWriter;

/**
 * a sample class
 */

/**
 * @author Biao Zhang
 *
 */
public class SampleClass {
	private PrintWriter printWriter;
	
	public void setWriter(PrintWriter printWriter) {
		this.printWriter = printWriter;
	}
	
	public void showMessage() {
		printWriter.write("Hello codeAnywhere");
	}
}
