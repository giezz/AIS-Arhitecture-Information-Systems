package giezz.jdbc_jfx.dao;

import giezz.jdbc_jfx.models.Model;
import javafx.collections.ObservableList;

public interface DAO <Entity extends Model, Key> {
    void create (Entity model);
    ObservableList<Entity> getAll();
    Entity get(Key key);
    void update(Entity entity);
    void delete(Key key);
}
