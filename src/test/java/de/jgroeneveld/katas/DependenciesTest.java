package de.jgroeneveld.katas;

import org.hamcrest.core.IsEqual;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertThat;

// http://codekata.com/kata/kata18-transitive-dependencies/
public class DependenciesTest {
    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void testDependenciesDirectly() throws Exception {
        Dependencies dependencies = new Dependencies();
        dependencies.addDirect('A', new char[]{'B'});

        assertThat(dependencies.dependenciesFor('A'), IsEqual.equalTo(new char[]{'B'}));
    }

    @Test
    public void testDependenciesIndirectly() throws Exception {
        Dependencies dependencies = new Dependencies();
        dependencies.addDirect('A', new char[]{'B'});
        dependencies.addDirect('B', new char[]{'C'});

        assertThat(dependencies.dependenciesFor('A'), IsEqual.equalTo(new char[]{'B', 'C'}));
    }

    @Test
    public void testDependenciesIndirectlyMultiple() throws Exception {
        Dependencies dependencies = new Dependencies();
        dependencies.addDirect('A', new char[]{'B', 'C'});
        dependencies.addDirect('B', new char[]{'C'});

        assertThat(dependencies.dependenciesFor('A'), IsEqual.equalTo(new char[]{'B', 'C'}));
    }

    @Test
    public void testDependencies() throws Exception {
        Dependencies dependencies = new Dependencies();
        dependencies.addDirect('A', new char[]{'B', 'C'});
        dependencies.addDirect('B', new char[]{'C', 'E'});
        dependencies.addDirect('C', new char[]{'G'});
        dependencies.addDirect('D', new char[]{'A', 'F'});
        dependencies.addDirect('E', new char[]{'F'});
        dependencies.addDirect('F', new char[]{'H'});

        assertThat(dependencies.dependenciesFor('A'), IsEqual.equalTo(new char[]{'B', 'C', 'E', 'G', 'F', 'H'}));
        assertThat(dependencies.dependenciesFor('B'), IsEqual.equalTo(new char[]{'C', 'E', 'G', 'F', 'H'}));
        assertThat(dependencies.dependenciesFor('C'), IsEqual.equalTo(new char[]{'G'}));
        assertThat(dependencies.dependenciesFor('D'), IsEqual.equalTo(new char[]{'A', 'F', 'B', 'C', 'E', 'G', 'H'}));
        assertThat(dependencies.dependenciesFor('E'), IsEqual.equalTo(new char[]{'F', 'H'}));
        assertThat(dependencies.dependenciesFor('F'), IsEqual.equalTo(new char[]{'H'}));
    }

    @Test
    public void testDependenciesCircular() throws Exception {
        expectedException.expect(Dependencies.CircularDependencyException.class);
        expectedException.expectMessage("B is dependency of itself");

        Dependencies dependencies = new Dependencies();
        dependencies.addDirect('A', new char[]{'B'});
        dependencies.addDirect('B', new char[]{'C'});
        dependencies.addDirect('C', new char[]{'D'});
        dependencies.addDirect('D', new char[]{'B'});

        dependencies.dependenciesFor('A');
    }
}