package com.zx.tudou;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;

public class PotatoProvider extends ContentProvider {
	SQLiteDatabase db;
UriMatcher um = new UriMatcher(UriMatcher.NO_MATCH);
{
um.addURI("com.zhuoxin.tudou", "tudou", 1);	
}
	@Override
	public boolean onCreate() {
		MyOpenHelper oh = new MyOpenHelper(getContext());
		db = oh.getWritableDatabase();
		return false;
	}

	@Override
	public Cursor query(Uri uri, String[] projection, String selection,
			String[] selectionArgs, String sortOrder) {
		Cursor cursor = null;
		if(um.match(uri)==1){
			cursor = db.query("tudou", projection, selection, selectionArgs,null, null, sortOrder, null);
		}
		return cursor;
	}

	@Override
	public Uri insert(Uri uri, ContentValues values) {
		
		if(um.match(uri)==1){
			db.insert("tudou", null, values);
		}
		return null;
	}

	@Override
	public int delete(Uri uri, String selection, String[] selectionArgs) {
		int i = 0;
		if(um.match(uri)==1){
			i = db.delete("tudou", selection, selectionArgs);
		}
		return i;
	}

	@Override
	public int update(Uri uri, ContentValues values, String selection,
			String[] selectionArgs) {
		int i = 0;
		if(um.match(uri)==1){
			i = db.update("tudou", values, selection, selectionArgs);
		}
		return i;
	}

	@Override
	public String getType(Uri uri) {
		// TODO Auto-generated method stub
		return null;
	}
}
