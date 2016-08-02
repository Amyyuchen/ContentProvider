package com.zx.tudou.test;

import com.zx.tudou.MyOpenHelper;

import android.test.AndroidTestCase;

public class Test extends AndroidTestCase {

	public void textDb() {
		MyOpenHelper oh = new MyOpenHelper(getContext());
		oh.getWritableDatabase();
	}

}
