package classes;
import gui.TradeWindow;

/**
 * Does all the moving between Supplies and Store. 
 * @author JeffZ
 *
 */

public class Transaction 
{

	Store store;
	Supplies supplies;
	TradeWindow window;
	int totalWeight;
	int totalCost;
	int[] playerAmts = new int[8];
	
	/**
	 * Initialize transaction
	 * @param store the store
	 * @param supplies the supplies
	 * @param wagon the wagon
	 */
	public Transaction (Store store, Supplies supplies, TradeWindow window)
	{
		this.store = store;
		this.supplies = supplies;
		this.window = window;
		totalWeight = 0;
		totalCost = 0;
		updateWindow();
	}
	
	private void updateWindow(){
		updateWindowStore();
		updateWindowPlayer();
	}
	
	private void updateWindowStore(){
		window.setStore(store.getPrices(), store.getQuantities());
	}
	
	private void updateWindowPlayer(){
		Item[] items = Item.values();
		for (int i=0; i < Item.values().length; i++){
			playerAmts[i] = items[i].getNum();
		}
		window.setPlayer(playerAmts);
	}
	/**
	 * checks to see if there is enough money for transaction and enough weight.
	 * @return true/false
	 */
	public boolean checkLegit()
	{
		if((supplies.getMoney() > totalCost) && supplies.getWeightRemaining() > totalWeight)
		{
			return true;
		}
		return false;
	}
	/**
	 * adds item to the internal list.
	 * @param item the item
	 * @param amt the amount
	 */
	public void addItem(Item item, int amt)
	{
		if(store.getQuantity(item) > amt)
		{
			supplies.addItem(item, amt);
			store.subItem(item, amt);
			totalWeight += supplies.getWeight(item)*amt;
			totalCost += store.getPrice(item)*amt;
		}
		else
		{
			//panel pops up saying "Store doesn't have this much"
		}
	}
	
	
	/**
	 * update the supplies. For usage if checkLegit works out!
	 * @return updated supplies
	 */
	public Supplies updateSupplies()
	{
		supplies.subMoney(totalCost);
		return supplies;
	}
	/**
	 * updates the store. Use if checkLegit works!
	 * @return updated store.
	 */
	public Store updateStore()
	{
		return store;
	}
	
	/**
	 * getter for total cost.
	 * @return the total cost.
	 */
	public int getTotalCost()
	{
		return totalCost;
	}
	
	/**
	 * getter for total weight.
	 * @return the total weight.
	 */
	public int getTotalWeight()
	{
		return totalWeight;
	}
	
}
