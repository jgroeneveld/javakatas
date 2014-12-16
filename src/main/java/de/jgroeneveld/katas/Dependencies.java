package de.jgroeneveld.katas;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Created by jgroeneveld on 16.12.14.
 */
public class Dependencies {
    private Set<Entry> entries = new LinkedHashSet<Entry>();

    public void addDirect(char thing, char[] dependencies) {
        Entry entry = findOrCreateEntry(thing);
        entry.addDependencies(findOrCreateEntries(dependencies));
    }

    public char[] dependenciesFor(char thing) {
        Entry entry = findEntry(thing);
        Set<Entry> allDependencies = new DependencySolver().dependenciesFor(entry);

        char[] result = new char[allDependencies.size()];
        int i = 0;
        for (Entry e : allDependencies) {
            result[i++] = e.thing;
        }

        return result;
    }

    private Set<Entry> findOrCreateEntries(char[] dependencies) {
        Set<Entry> entries = new LinkedHashSet<Entry>(dependencies.length);

        for (char c : dependencies) {
            entries.add(findOrCreateEntry(c));
        }

        return entries;
    }

    private Entry findOrCreateEntry(char thing) {
        Entry entry = findEntry(thing);

        if (entry == null) {
            entry = new Entry(thing);
            entries.add(entry);
        }

        return entry;
    }

    private Entry findEntry(char thing) {
        for (Entry e : entries) {
            if (e.thing == thing) {
                return e;
            }
        }

        return null;
    }


    private static class DependencySolver {
        private Set<Entry> visited = new LinkedHashSet<Entry>();

        public Set<Entry> dependenciesFor(Entry entry) {
            if (visited.contains(entry)) {
                return new LinkedHashSet<Entry>();
            }
            visited.add(entry);

            Set<Entry> allDependencies = new LinkedHashSet<Entry>();
            allDependencies.addAll(entry.dependencies);

            for (Entry dependency : entry.dependencies) {
                allDependencies.addAll(dependenciesFor(dependency));
            }

            checkForCircularDependency(entry, allDependencies);
            return allDependencies;
        }

        private void checkForCircularDependency(Entry entry, Set<Entry> allDependencies) {
            if (allDependencies.contains(entry)) {
                throw new CircularDependencyException(entry.thing + " is dependency of itself");
            }
        }
    }

    private static class Entry {
        public char thing;
        public Set<Entry> dependencies = new LinkedHashSet<Entry>();

        public Entry(char thing) {
            this.thing = thing;
        }

        public void addDependencies(Set<Entry> dependencies) {
            this.dependencies.addAll(dependencies);
        }
    }

    public static class CircularDependencyException extends RuntimeException {
        public CircularDependencyException(String msg) {
            super(msg);
        }
    }
}
