package me.petterim1.maven;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.plugins.annotations.ResolutionScope;

@Mojo(name = "run-script", defaultPhase = LifecyclePhase.PACKAGE, requiresDependencyResolution = ResolutionScope.COMPILE)
public class MavenScriptPlugin extends AbstractMojo {

    @Parameter(required = true)
    protected String script;

    @Override
    public void execute() throws MojoExecutionException, MojoFailureException {
        getLog().info("Running script " + script);
        try {
            Process p = Runtime.getRuntime().exec(script);
            p.waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
