package Design.InMemoryFileSystem;

public class File extends Entry {
    private String content;
    private int size;

    public File(String name, Directory path, int size) {
        super(name, path);
        this.size = size;
    }

    public int size() {
        return size;
    }

    public String getContents() {
        return content;
    }

    public void setContents(String content) {
        this.content = content;
    }
}
