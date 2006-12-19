/**
 * 
 */
package meta.codeanywhere.compile;

import java.io.File;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.tools.Diagnostic;
import javax.tools.DiagnosticCollector;
import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import javax.tools.JavaCompiler.CompilationTask;

import meta.codeanywhere.util.JavaSourceFromString;


/**
 * @author Biao Zhang
 * @date 2006-7-15
 */
public class CAJavaCompiler implements ICompile {
	private ArrayList<File> files;
	private JavaCompiler compiler;
	private StandardJavaFileManager fileManager;
	private ArrayList<JavaFileObject> compilationUnits;
	private DiagnosticCollector<JavaFileObject> diagnostics;
	private CompilationTask task;
	
	public CAJavaCompiler() {
		files = new ArrayList<File>();
		compiler = ToolProvider.getSystemJavaCompiler();
		diagnostics = new DiagnosticCollector<JavaFileObject>();
		fileManager = compiler.getStandardFileManager(diagnostics, Locale.CHINESE, Charset.defaultCharset());
		compilationUnits = new ArrayList<JavaFileObject>();
	}
	public boolean addSourceFile(String name/* extension need */) {
		files.add(new File(name));
		return true;
	}
	public boolean addSourceFile(String name/* no extension need */, String source) {
		JavaSourceFromString sfile = new JavaSourceFromString(name, source);
		compilationUnits.add(sfile);
		return true;
	}
	public int compile() {
		Iterable<? extends JavaFileObject> u = fileManager.getJavaFileObjectsFromFiles(files);
		
		/* add the file in the files to the compilation units*/
		for(JavaFileObject fileObject: u) {
			compilationUnits.add(fileObject);
		}
		
		task = compiler.getTask(null, fileManager, diagnostics, null, null, compilationUnits);
		task.call();
		return 0;
	}
	
	public List<Diagnostic<? extends JavaFileObject>> getDiagnostics() {
		return diagnostics.getDiagnostics();
	}

}
