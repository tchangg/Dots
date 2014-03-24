package com.example.dots;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;

public class Dot
{
  BitmapDrawable bitmap;
  int x, y; //coordinates for the dot
  
  public Dot()
  {
    x = 0;
    y = 0;
  }
  
  public Dot(int x, int y)
  {
    this.x = x;
    this.y = y;
  }
  
  public void setBitmapDrawable(BitmapDrawable b)
  {
    bitmap = b;
  }
  
  public Bitmap getBitmap()
  {
    return bitmap.getBitmap();
  }
  
  public void setX(int x)
  {
    this.x = x;
  }
  public void setY(int y)
  {
    this.y = y;
  }
  public int getX()
  {
    return x;
  }
  public int getY(){ return y;}
  
  
}
