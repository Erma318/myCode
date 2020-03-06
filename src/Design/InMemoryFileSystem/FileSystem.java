package Design.InMemoryFileSystem;

import java.util.ArrayList;
import java.util.List;

class FileSystem {
    private final Directory root;

    public FileSystem() {
        root = new Directory("/", null);
    }

    public List<Entry> resolve(String path) throws IllegalArgumentException{
        assert path.startsWith("/");
        String[] components = path.substring(1).split("/");
        List<Entry> entries = new ArrayList<>(components.length + 1);
        entries.add(root);
        Entry entry = root;
        for (String component : components) {
            if (!(entry instanceof Directory)) {
                throw new IllegalArgumentException(("invalid path: " + path));
            }
            if (!component.isEmpty()) {
                entry = ((Directory) entry).getChild(component);
                entries.add(entry);
            }
        }
        return entries;
    }

    public void mkdir(String path) {
        List<Entry> entries = resolve(path);
        if (entries.get(entries.size() - 1) != null) {
            throw new IllegalArgumentException("Directory already exists: " + path);
        }
        String[] components = path.split("/");
        final String dirName = components[components.length - 1];
        final Directory parent = (Directory) entries.get(entries.size() - 2);
        Directory newDir = new Directory(dirName, parent);
        parent.addEntry(newDir);
    }

    public void createFile(String path) {
        assert  !path.endsWith("/");
        List<Entry> entries = resolve(path);
        if (entries.get(entries.size() - 1) != null) {
            throw new IllegalArgumentException("File already exists: " + path);
        }
        String[] components = path.split("/");
        final String fileName = components[components.length - 1];
        final Directory parent = (Directory) entries.get(entries.size() - 2);
        File newFile = new File(fileName, parent, 0);
        parent.addEntry(newFile);
    }

    public boolean delete(String path) {
        // TODO: delete the file/directory with the given path
        List<Entry> entries = resolve(path);
        if (entries.get(entries.size() - 1) == null) {
            throw new IllegalArgumentException("File or path does not exist: " + path);
        }
        return ((Directory) entries.get(entries.size() - 2)).deleteEntry(entries.get(entries.size() - 1));
    }

    public List<Entry> list(String path) {
        // TODO: list all the immediate children of the directory specified by the given path
        List<Entry> entries = resolve(path);
        if (entries.get(entries.size() - 1) == null) {
            throw new IllegalArgumentException("Path does not exist: " + path);
        }
        try {
            Directory dir = (Directory) entries.get(entries.size() - 1);
        } catch (ClassCastException e) {
            throw new IllegalArgumentException("The path give is a file: " + path);
        }
        return ((Directory) entries.get(entries.size() - 1)).getContents();
    }

    public int count() {
        // TODO: return the total number of files/directories in the FileSytem
        List<Entry> entries = resolve("/");
        return ((Directory) entries.get(0)).numberOfFiles();
    }

    public static void main(String[] args) {
        FileSystem fs = new FileSystem();
        fs.mkdir("/A");
        fs.mkdir("/A/B");
        fs.mkdir("/A/B/C");
        fs.createFile("/A/B/D");
        fs.list("/A/B/C");
        System.out.println(fs.count());

    }
}
