package persistence;


import java.io.PrintWriter;

// Represents data that can be saved to file
// Saveable interface inspired by TellerApp https://github.students.cs.ubc.ca/CPSC210/TellerApp.git
public interface Saveable {

    // MODIFIES: printWriter
    // EFFECTS: writes the saveable to printwriter
    void save(PrintWriter printWriter);
}
