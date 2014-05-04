package com.example.sqlitesimple;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {

	private Button btninsert;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		initialWidget();
		final MyDBClass dbClass = new MyDBClass(this);
		btninsert.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				//Value 1
				long flg1 = dbClass.InsertData("1", "Anugool Tippon", "0848647564");
				if(flg1 > 0){
					Toast.makeText(MainActivity.this, "Insert(1) Data Successfully", Toast.LENGTH_LONG).show();
				}
				else{
					Toast.makeText(MainActivity.this, "Insert(1) Data Failed.", Toast.LENGTH_LONG).show();
				}
			}
		});
	}

	private void initialWidget() {
		btninsert = (Button) findViewById(R.id.insert);
	}
}