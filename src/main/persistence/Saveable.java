package persistence;


import java.io.PrintWriter;

// Represents data that can be saved to file
public interface Saveable {

    // MODIFIES: printWriter
    // EFFECTS: writes the saveable to printwriter
    void save(PrintWriter printWriter);

}
