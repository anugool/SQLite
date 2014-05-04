package com.example.sqlitesimple;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class MyDBClass extends SQLiteOpenHelper {

	private static final int DATABASE_VERSION = 1;
	private static final String DATABASE_NAME = "mydatabase";
	private static final String TABLE_MEMBER = "members";

	public MyDBClass(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}
	
	//Create Table
	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL("CREATE TABLE " + TABLE_MEMBER
				+ "(MemberID INTEGER PRIMARY,"
				+ " Name TEXT(100)," + " Tel TEXT(100));");

		Log.d("CREATE TABLE", "Create Table Successfully.");
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("DROP TABLE" + TABLE_MEMBER);
		onCreate(db);
		Log.d("Members DB", "Table Upgraded from" + oldVersion + "to"+ newVersion);
	}

	// Insert Data
	public long InsertData(String strMemberID, String strName, String strTel) {
		try {
			SQLiteDatabase db;
			db = this.getWritableDatabase();
			ContentValues values = new ContentValues();
			values.put("MemberID", strMemberID);
			values.put("Name", strName);
			values.put("Tel", strTel);
			//insert 
			long rows = db.insert(TABLE_MEMBER, null, values);
			db.close();
			return rows;
		} catch (Exception e) {
			return -1;
		}

	}

}
