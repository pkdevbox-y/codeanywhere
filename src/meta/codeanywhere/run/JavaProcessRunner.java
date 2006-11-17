/**
 * 
 */
package meta.codeanywhere.run;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Writer;

/**
 * @author Biao Zhang
 * @date 2006-7-19
 */
public class JavaProcessRunner implements IRun {

	private ProcessBuilder processBuilder;
	private Process javaProcess;
	private Writer writer;
	private InputStream inputStream;
	private BufferedReader bufferedReader;
	
	public JavaProcessRunner(String classFile, String classPath) {
		processBuilder = new ProcessBuilder("java", "-classpath", classPath, classFile);
	}
	/* (non-Javadoc)
	 * @see meta.codeanywhere.run.IRun#run()
	 */
	public int run() {
		if (processBuilder == null) {
			return -1;
		}
		try {
			javaProcess = processBuilder.start();
			inputStream = javaProcess.getInputStream();
			bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
			
			String line = bufferedReader.readLine();
			while(line != null) {
				writer.write(line);
				line = bufferedReader.readLine();
			}
			bufferedReader.close();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		return 0;
	}

	public void setWriter(Writer writer) {
		this.writer = writer;
	}
	public InputStream getInputStream() {
		return javaProcess.getInputStream();
	}
	public OutputStream getOutputStream() {
		return javaProcess.getOutputStream();
	}
}
