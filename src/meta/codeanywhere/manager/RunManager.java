/**
 * @(#)RunManager.java
 */
package meta.codeanywhere.manager;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;

import meta.codeanywhere.run.IRun;
import meta.codeanywhere.run.JavaProcessRunner;

/**
 * The RunManaer processes all the requests to run a class
 * and print out the result.
 * @author Yunjing Xu
 * @version 11/17/2006
 */
public class RunManager {
	
	private static RunManager manager;
	
	private HashMap<Integer, IRun> runners;
	
	private RunManager() {
		runners = new HashMap<Integer, IRun>();
	}

	public static RunManager getManager() {
		if (manager == null) {
			manager = new RunManager();
		}
		return manager;
	}
	
	/**
	 * Run a class for a specific user
	 * @param uid The id of the user to run the class.
	 * @param classFile The name of the class file to run
	 * @param classPath The class path
	 */
	public int run(Integer uid, String classFile, String classPath) {
		IRun runner = new JavaProcessRunner(classFile, classPath);
		if (runner.run() == -1) { // Error
			return -1;
		} else {
			runners.put(uid, runner);
		}
		return 0;
	}
	
	/**
	 * Give the input to a program of specific use.
	 * @param uid The id of the usr.
	 * @param content The content of the input.
	 */
	public void write(Integer uid, String content) {
		IRun runner = runners.get(uid);
		BufferedWriter writer = new BufferedWriter(
				new OutputStreamWriter(runner.getOutputStream()));
		try {
			writer.write(content);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Get the output from a program of specific use.
	 * @param uid The id of the usr.
	 * @return The output of the program.
	 */
	public String read(Integer uid) {
		IRun runner = runners.get(uid);
		BufferedReader reader = new BufferedReader(
				new InputStreamReader(runner.getInputStream()));
		try {
			if (reader.ready()) {
				StringBuffer content = new StringBuffer();
				char[] buf = new char[512];
				int count = reader.read(buf, 0, buf.length);
				while (count == buf.length) {
					content.append(buf);
					count = reader.read(buf, 0, buf.length);
				}
				return content.toString();
			}
		} catch (IOException e) {
			e.printStackTrace();

		}
		return null; // Stream not reader or IOException
	}
}
