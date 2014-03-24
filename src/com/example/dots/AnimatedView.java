package com.example.dots;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import android.util.AttributeSet;
import android.widget.ImageView;

import java.util.Random;

public class AnimatedView extends ImageView
{

  private Context mContext;
  int x = -1;
  int y = -1;
  private int xVelocity = 10;
  private int yVelocity = 5;
  private int numDots = 30;
  private Handler h;
  private Random randNum;
  private Dot[] dotArray;
  private boolean direction; //true is right, false is left
  private Dot test;
  private final int FRAME_RATE = 30;
  
  public AnimatedView(Context context, AttributeSet attrs)
  {
    super(context, attrs);
    mContext = context;
    h = new Handler();
    randNum = new Random();
    
    if(randNum.nextInt(2) == 0)
    {
      direction = true;
      xVelocity = Math.abs(xVelocity); //1 is right
    }
    else
    {
      direction = false;
      xVelocity = -Math.abs(xVelocity);
    }
    
    dotArray = new Dot[numDots];
    for(int i =0; i < dotArray.length; i++)
    {
      //System.out.println("This is happening");
      dotArray[i] = new Dot();
      dotArray[i].setBitmapDrawable((BitmapDrawable)mContext.getResources().getDrawable(R.drawable.small_white_dot));
      //dotArray[i].setY(randNum.nextInt(this.getHeight()));
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
    /*
    for(Dot d : dotArray)
    {
      d.setBitmapDrawable((BitmapDrawable)mContext.getResources().getDrawable(R.drawable.small_white_dot));
      d.setY(randNum.nextInt(this.getHeight()));
    } */
    //if(test != null) System.out.println("This is not null!");
    for(Dot d: dotArray)
    {
      //d = new Dot();
      //if(dotArray[i] == null) System.out.println("THis is null!");
      
     // d.setBitmapDrawable((BitmapDrawable)mContext.getResources().getDrawable(R.drawable.small_white_dot));
     d.setX(d.getX() + xVelocity);
    //  d.setY(randNum.nextInt(this.getHeight()));
    if(direction && (d.getX() > this.getWidth() + 50) /*(ball.getBitmap().getWidth())*/ /*|| (x < -50)*/)
    {
      d.setX(-100);
    }
    else if(!direction && (d.getX()<-50))
    {
      d.setX(this.getWidth()+50);
    }
      c.drawBitmap(d.getBitmap(),  d.getX(), d.getY(), null); 
    }
    
    //c.drawBitmap(ball.getBitmap(),  x, y, null);
    h.postDelayed(r,  FRAME_RATE);
  }

}
