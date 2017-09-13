package th3g3ntl3m3n.concertapp.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by th3g3ntl3m3n on 19/8/17.
 */

public class Employee extends SQLiteOpenHelper {

    private static final String ID = "_id";
    private static final String MONTH_NAME = "month_name";
    private static final String YEAR = "year";
    private static final String REPORT = "report";
    private static final String CLINIC_ID = "clinic_id";

    private String CREATE_TABLE = "CREATE TABLE " + DatabaseConstants.EMPLOYEETABLE + " ( " +
            ID + " int, " +
            MONTH_NAME + " text, " +
            YEAR + " text, " +
            REPORT + " text, " +
            CLINIC_ID + " text)";
    private String DELETE_TABLE = "DROP TABLE IF EXIST " + DatabaseConstants.EMPLOYEETABLE;

    public Employee(Context context) {
        super(context, DatabaseConstants.DATABSENAME, null, DatabaseConstants.DATABASE_VER);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(DELETE_TABLE);
        onCreate(sqLiteDatabase);
    }

    public void insertRecord(String month, String data, String clinic_id) {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(ID, 1);
        contentValues.put(MONTH_NAME, month);
        contentValues.put(YEAR, "2017");
        contentValues.put(REPORT, data);
        contentValues.put(CLINIC_ID, clinic_id);

        long newRowId = sqLiteDatabase.insert(DatabaseConstants.EMPLOYEETABLE, null, contentValues);
    }
}
