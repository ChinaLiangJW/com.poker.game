package coom.poke.game;

import java.util.ArrayList;
import java.util.List;

public class Player {
	//玩家的id设置为Integer类型
	public Integer id;
	public String name;
	//使用List存储Card，方便排序
	public List<Card> cards;
	/**
	 * 构造器
	 * @param id
	 * @param name
	 */
	public Player(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
		cards = new ArrayList<Card>();
	}
	
}
