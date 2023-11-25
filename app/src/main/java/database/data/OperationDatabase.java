package database.data;

import androidx.room.Database;
import androidx.room.RoomDatabase;


@Database(entities = {Operation.class}, version = 2)
public abstract class OperationDatabase extends RoomDatabase {

    public abstract Operation_DAO getOperationDao();

}
