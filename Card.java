package coom.poke.game;

/**
 * 扑克牌有两个属性：花色和点数，不考虑大小王
 * @author Administrator
 *
 */
public class Card implements Comparable<Card>{
	public String color;
	public String num;
	
	public void Card() {
		
	}
	/**
	 * 定义构造函数
	 * @param color
	 * @param num
	 */
	public Card(String color, String num) {
		this.color = color;
		this.num = num;
	}
	/**
	 * 将花色转换为Integer包装类，switch可以比较字符串
	 */
	public Integer colorToInteger(String s) {
		if (s.equals("红桃")) {
			return 4;
		} else if (s.equals("黑桃")) {
			return 3;
		} else if (s.equals("方片")) {
			return 2;
		} else if (s.equals("梅花")){
			return 1;
		}
		return 0;
	}
	
	/**
	 * 将字符串形式的点数转换为Integer包装类
	 */
	public Integer numToInteger(String s) {
		if (s.equals("J")) {
			return 11;
		} else if (s.equals("Q")) {
			return 12;
		} else if (s.equals("K")) {
			return 13;
		} else if (s.equals("A")) {
			return 14;
		} else {
			return Integer.valueOf(s.trim());
			//return 0;
		}
	}
	
	/**
	 * 实现compareTo方法，比较大小
	 */
	@Override
	public int compareTo(Card o) {
		// TODO Auto-generated method stub
		int ret = numToInteger(this.num).compareTo(numToInteger(o.num));
		if (ret != 0)
			return ret;
		else {
			ret = colorToInteger(this.color).compareTo(colorToInteger(o.color));
			return ret;
		}
	}
}
