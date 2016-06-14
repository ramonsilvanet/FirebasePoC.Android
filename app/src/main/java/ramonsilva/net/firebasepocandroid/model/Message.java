package ramonsilva.net.firebasepocandroid.model;

import com.google.firebase.database.Exclude;
import com.google.firebase.database.IgnoreExtraProperties;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ramonsilva on 14/06/16.
 */

@IgnoreExtraProperties
public class Message {

    public String text;
    public String from;

    public Message(){

    }

    public Message(String text, String from){
        this.text = text;
        this.from = from;
    }

    @Exclude
    public Map<String, Object> toMap() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("text", text);
        result.put("from", from);

        return result;
    }
}
