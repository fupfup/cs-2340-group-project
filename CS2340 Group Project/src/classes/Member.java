package classes;

import java.io.Serializable;

/**
 * Member class
 * Members have health, stamina, and can be sick or dead.
 *
 */
public class Member implements Serializable
{
	public String name;
	private int health;
	private boolean isSick = false;
	
	/**
	 * constructor
	 * @param name the name of member.
	 */
	public Member(String name)
	{
		this.name = name;
		health = 100;
	}
	
	/**
	 * getter for name
	 * @return the name.
	 */
	public String getName()
	{
		return name;
	}
	
	/**
	 * checks if the guy is alive or dead.
	 * @return status
	 */
	public boolean alive()
	{
		if(health>0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	/**
	 * makes member sick
	 */
	public void sick()
	{
		isSick=true;
	}
	
	/**
	 * return health status of guy
	 * @return is sick or not.
	 */
	public boolean isSick()
	{
		return isSick;
	}
	/**
	 * setter for name
	 * @param name
	 */
	public int getHealth()
	{
		return health;
	}
	public void setName(String name)
	{
		this.name=name;
	}
	public void setHealth(int health)
	{
		this.health=health;
	}
}
