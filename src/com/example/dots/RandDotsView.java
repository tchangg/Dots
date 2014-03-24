package com.example.dots;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import android.util.AttributeSet;
import android.widget.ImageView;

import java.util.Random;

public class RandDotsView extends ImageView
{

  private Context mContext;
  int x = -1;
  int y = -1;
  private int xVelocity = 10;
  private int yVelocity = 5;
  private int numDots = 70;
  private Handler h;
  private Random randNum;
  private Dot[] dotArray;
  private Dot test;
  private final int FRAME_RATE = 30;
  
  public RandDotsView(Context context, AttributeSet attrs)
  {
    super(context, attrs);
    mContext = context;
    h = new Handler();
    randNum = new Random();
    dotArray = new Dot[numDots];
    System.out.println(this.getHeight());
    for(int i =0; i < dotArray.length; i++)
    {
      dotArray[i] = new Dot();
      dotArray[i].setBitmapDrawable((BitmapDrawable)mContext.getResources().getDrawable(R.drawable.small_white_dot));
    }
  }
  
  public void onSizeChanged(int w, int h, int oldW, int oldH)
  {
    if(w == 0 || h == 0) return;
    else
    {
      for(int i =0; i < dotArray.length; i++)
      {
        dotArray[i].setY(randNum.nextInt(this.getHeight()));
        dotArray[i].setX(randNum.nextInt(this.getWidth()));
      }
    }
  }
  
  private Runnable r = new Runnable()
  {
    public void run()
    {
      invalidate();
    }
  };
  
  protected void onDraw(Canvas c)
  {
    for(Dot d: dotArray)
    {
     d.setX(randNum.nextInt(this.getWidth()));
     d.setY(randNum.nextInt(this.getHeight()));
     c.drawBitmap(d.getBitmap(),  d.getX(), d.getY(), null); 
    }
    
    h.postDelayed(r,  FRAME_RATE);
  }

}
