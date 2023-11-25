package database.data;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface Operation_DAO {

    @Insert
    public void addOperation(Operation operation);

    @Delete
    public void deleteOperation(Operation operation);

    @Query("select * from Operation")
    public List<Operation> getAllOperation();
}
