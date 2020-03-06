package Design.InMemoryFileSystem;

import java.util.ArrayList;
import java.util.List;

public class Directory extends Entry {
    private List<Entry> contents;

    public Directory(String name, Directory path) {
        super(name, path);
        contents = new ArrayList<>();
    }

    protected List<Entry> getContents() {
        return contents;
    }

    public int size() {
        int size = 0;
        for (Entry e : contents) {
            size += e.size();
        }
        return size;
    }

    public int numberOfFiles() {
        int count = 0;
        for (Entry e : contents) {
            if (e instanceof Directory) {
                count++;
                Directory directory = (Directory) e;
                count += directory.numberOfFiles();
            } else {
                count++;
            }
        }
        return count;
    }

    public boolean deleteEntry(Entry entry) {
        return contents.remove(entry);
    }

    public boolean addEntry(Entry entry) {
        return contents.add(entry);
    }

    public Entry getChild(String fileName) {
        for (Entry e : contents) {
            if (e.name.equals(fileName)) {
                return e;
            }
        }
        return null;
    }
}
