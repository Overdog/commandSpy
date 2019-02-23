package me.overdog.commandspy.utils;

public class LagDetection 
{

	public static long returnMemoryUsed()
	{
	Runtime r = Runtime.getRuntime();
	long memUsed = (r.totalMemory() - r.freeMemory());
	return memUsed;
	}
	
	public static long returnMemoryTotal()
	{
	Runtime r = Runtime.getRuntime();
	return r.maxMemory();
	}
}
