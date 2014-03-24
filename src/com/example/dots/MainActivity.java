package com.example.dots;

import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;

public class MainActivity extends Activity
{
  Intent starterIntent;
  
  @Override
  protected void onCreate(Bundle savedInstanceState)
  {
    starterIntent = getIntent();
    
    super.onCreate(savedInstanceState);
   
    setContentView(R.layout.activity_main);
    DisplayMetrics metrics = new DisplayMetrics();
    getWindowManager().getDefaultDisplay().getMetrics(metrics);
    int width = metrics.widthPixels;
    /*
    Button left = (Button) findViewById(R.id.left);
    Button center = (Button) findViewById(R.id.center);
    Button right = (Button) findViewById(R.id.right);
    
    //left.setWidth(width/3);
    //center.setWidth(width/3);
   // right.setWidth(width/3);
   LayoutParams params = new LayoutParams(width/3, left.getHeight());
   left.setLayoutParams(params);
   center.setLayoutParams(params);
   right.setLayoutParams(params);
    */
    
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu)
  {
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.main, menu);
    return true;
  }
  
  public void clickLeft(View v)
  {
    this.recreate();
  }
  
  public void clickCenter(View v)
  {
    
  }
  
  public void clickRight(View v)
  {
    this.recreate();
  }
  
  @SuppressLint("NewApi")
  public void recreate()
  {
    if(android.os.Build.VERSION.SDK_INT >= 11)
    {
      super.recreate();
    }
    else
    {
      startActivity(getIntent());
      finish();
    }
  }
  
  

}
