/**
 * 
 */
package meta.codeanywhere.compile;

import java.io.File;
import java.util.ArrayList;

import javax.tools.DiagnosticCollector;
import javax.tools.JavaCompilerTool;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import javax.tools.JavaCompilerTool.CompilationTask;

import meta.codeanywhere.util.JavaSourceFromString;


/**
 * @author Biao Zhang
 * @date 2006-7-15
 */
public class JavaCompiler implements ICompile {
	private ArrayList<File> files;
	private JavaCompilerTool compiler;
	private StandardJavaFileManager fileManager;
	private ArrayList<JavaFileObject> compilationUnits;
	private DiagnosticCollector<JavaFileObject> diagnostics;
	private CompilationTask task;
	
	public JavaCompiler() {
		files = new ArrayList<File>();
		compiler = ToolProvider.getSystemJavaCompilerTool();
		diagnostics = new DiagnosticCollector<JavaFileObject>();
		fileManager = compiler.getStandardFileManager(diagnostics);
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
		task.run();
		return 0;
	}

}
