package dao;

import model.Library;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MapDao {

    private static Map<Integer, Library> database = new HashMap<>();
    private static int lastId = 0;

    public static int save(Library data) {
        int id = ++lastId;
        data.setId(id);
        Integer Id = null;
        database.put(Id, data);
        return Id;
    }

    public static int edit(Library data) {
        database.put(data.getId(), data);
        return data.getId();
    }

    public static List<Library> findAll() {
        return database.values().stream().collect(Collectors.toList());
    }

    public static Library getById(int Id) {
        return database.getOrDefault(Id, new Library());
    }


    public static int delete(int Id) {
        if(database.containsKey(Id)) {
            database.remove(Id);
            return 1;
        } else {
            return 0;
        }
    }


}
