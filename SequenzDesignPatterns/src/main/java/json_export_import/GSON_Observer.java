/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package json_export_import;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rgreim
 */
public class GSON_Observer {

    private List<String> seqList = new ArrayList<>();

    public void write(String seq) {

        if (seqList.size() < 10) {
            seqList.add(seq);
        } else {

            try {
                Writer writer = new FileWriter("/home/rgreim/Output.json");
                Gson gson = new Gson();
                String sequence = gson.toJson(seqList);
                writer.write(sequence);
                writer.close();
            } catch (IOException ex) {
                Logger.getLogger(GSON_Observer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void read() {
        try {
            JsonReader reader = new JsonReader(new FileReader("/home/rgreim/Output.json"));
            reader.beginArray();
            while (reader.hasNext()) {
                String sequence = reader.nextString();
                System.out.println("Sequenz: " + sequence);
            }
            reader.endArray();
            reader.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(GSON_Observer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(GSON_Observer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
