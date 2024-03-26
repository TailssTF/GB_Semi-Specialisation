package model.writer;

import com.google.gson.Gson;
import model.note.Note;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

public class FileHandler{
    public boolean save(List list, String filePath) {
        try (PrintWriter out = new PrintWriter(new FileWriter(filePath))) {
            Gson gson = new Gson();
            String jsonString = gson.toJson(list);
            out.write(jsonString);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public Object read(String filePath) {
        try (FileReader in = new FileReader(filePath)){
            Gson gson = new Gson();
            List<Note> notes = Arrays.asList(gson.fromJson(in, Note[].class));
            return notes;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
