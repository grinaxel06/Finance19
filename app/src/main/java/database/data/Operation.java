package database.data;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "Operation")
public class Operation {

    @ColumnInfo(name = "Op_id")
    @PrimaryKey(autoGenerate = true)
    int id;

    @ColumnInfo(name = "Op_name")
    String Op_name;

    @ColumnInfo(name = "Op_sum")
    String Op_sum;

    @ColumnInfo(name = "Op_date")
    String Op_date;

    @ColumnInfo(name = "Op_type")
    String Op_type;

    @ColumnInfo(name = "Op_comm")
    String Op_comm;
    @ColumnInfo(name = "RoG")
    boolean RoG;

    @Ignore
    public Operation(){

    }

    public Operation(String Op_name, String Op_sum, String Op_date, String Op_type, String Op_comm,boolean RoG){
        this.Op_name = Op_name;
        this.Op_sum = Op_sum;
        this.Op_date = Op_date;
        this.Op_type = Op_type;
        this.Op_comm = Op_comm;
        this.RoG = RoG;
        this.id = 0;
    }

    public String getOp_name() {
        return Op_name;
    }
    public String getOp_date() {
        return Op_date;
    }
    public String getOp_type() {
        return Op_type;
    }
    public String getOp_comm() {
        return Op_comm;
    }
    public String getOp_sum() {return Op_sum;}

    public boolean isRoG() {
        return RoG;
    }
}
