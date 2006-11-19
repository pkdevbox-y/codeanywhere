/**
 * 
 */
package meta.codeanywhere.test;

import java.io.PrintWriter;

import meta.codeanywhere.compile.JavaCompiler;
import meta.codeanywhere.run.JavaProcessRunner;

/**
 * @author Biao Xhang
 * @date 2006-7-15
 */
public class TestJavaCompiler {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		JavaCompiler javaCompiler = new JavaCompiler();
		javaCompiler.addSourceFile("D:/Hello.java");
		javaCompiler.compile();
		PrintWriter out = new PrintWriter(System.out);
		JavaProcessRunner javaRunner = new JavaProcessRunner("Hello", ".", out);
		javaRunner.run();
		
		out.close();
	}

}
