package z1856517.cs.niu.edu.asssignment5;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DatbaseManager extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "listdb";

    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_LIST = "list",ID = "id",
            NAME = "name",CHECKED="flag";

    public DatbaseManager(Context context) { super(context, DATABASE_NAME, null, DATABASE_VERSION); }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        //build SQL statement
        String sqlCreate = "create table " + TABLE_LIST + "( " +ID + " integer primary key autoincrement, " +  NAME + " text ) ";
        sqLiteDatabase.execSQL(sqlCreate);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        sqLiteDatabase.execSQL("drop table if exists " + TABLE_LIST);
        onCreate(sqLiteDatabase);
    }

    public void deleteByID( int id )
    {
        SQLiteDatabase database = getWritableDatabase();

        String sqlDelete = "delete from " + TABLE_LIST +
                " where " + ID + " = " + id;

        database.execSQL(sqlDelete);
        database.close();
    }//end of deleteByID

    public void updateByID( int id, String name)
    {
        String sqlUpdate = "update " + TABLE_LIST +" set " + NAME + " = '" + name + "'" + " where " + ID + " = " + id;
        SQLiteDatabase database = getWritableDatabase();
        database.execSQL(sqlUpdate);
        database.close();
    }
    public ArrayList<Item> selectAll()
    {
        String sqlSelect = "select * from " + TABLE_LIST;

        SQLiteDatabase database = getWritableDatabase();

        Cursor cursor = database.rawQuery(sqlSelect, null);

        ArrayList<Item> items = new ArrayList<>();

        while (cursor.moveToNext())
        {
            Item currentItem = new Item( Integer.parseInt(cursor.getString(0)),cursor.getString(1));
            items.add(currentItem);
        }

        database.close();
        return items;
    }


    public void insert( Item item)
    {
        SQLiteDatabase database = getWritableDatabase();

        String sqlInsert = "insert into " + TABLE_LIST +
                " values( null, '" + item.getName() +
                "' )";

        database.execSQL(sqlInsert);
        database.close();
    }//end of insert
    public int isChecked(int id){
        int flag=0;
        String sqlSelect = "select flag from " + TABLE_LIST +
                " where " + ID + " = " + id;
        SQLiteDatabase database = getWritableDatabase();
        Cursor cursor = database.rawQuery(sqlSelect, null);

        database.close();
        return flag;
    }
    public Item selectByID( int id )
    {
        String sqlSelect = "select * from " + TABLE_LIST +
                " where " + ID + " = " + id;

        SQLiteDatabase database = getWritableDatabase();

        Cursor cursor = database.rawQuery(sqlSelect, null);

        Item item = null;

        if( cursor.moveToFirst() ){
            item = new Item(Integer.parseInt(cursor.getString(0)), cursor.getString(1));
        }
        database.close();
        return  item;
    }

}




















