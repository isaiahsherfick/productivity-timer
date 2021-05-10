import java.awt.*;
import java.awt.event.InputEvent;
import java.util.Random;

public class ProductivityTimer
{
	private int timeBeforeIGetDistractedAgainInMilliseconds;
	private Robot r;
	private Random rand;
	ProductivityTimer(int timeBeforeIGetDistractedAgainInMilliseconds)
	{
		try
		{
			this.r = new Robot();
		}
		catch (AWTException e)
		{
			e.printStackTrace();
		}
		this.timeBeforeIGetDistractedAgainInMilliseconds = timeBeforeIGetDistractedAgainInMilliseconds;
		this.rand = new Random();
	}
	public void beProductive()
	{
		int secondsToWait = this.timeBeforeIGetDistractedAgainInMilliseconds / 1000;
		for (int i = secondsToWait; i > 0; i--)
		{
			try
			{
				Thread.sleep(1000);
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}
		int min = 0;
		int max = 1920;
		int x, y;
		x = this.rand.nextInt((max - min) + 1) + min;
		min = 0;
		max = 1080;
		y = this.rand.nextInt((max - min) + 1) + min;
		r.mouseMove(x,y);
		System.out.println("Hey! Don't get distracted!");
	}
	public static void main(String[] args)
	{
		int minutesUntilINeedToBeProductiveAgain = 0;
		try
		{
			minutesUntilINeedToBeProductiveAgain = Integer.parseInt(args[0]);
			int timeBeforeIGetDistractedAgainInMilliseconds = minutesUntilINeedToBeProductiveAgain * 60000;
			System.out.println("Time to be productive!");
			ProductivityTimer p = new ProductivityTimer(timeBeforeIGetDistractedAgainInMilliseconds);
			while(true)
			{
				p.beProductive();
			}
		}
		catch(ArrayIndexOutOfBoundsException e)
		{
			System.out.println("Missing CL arg");
			System.out.println("Usage: java ProductivityTimer <minutes until I need to be productive again>");
		}
	}
}
