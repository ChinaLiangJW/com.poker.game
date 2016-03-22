package coom.poke.game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class PokeGame {
	
	public List<Card> pokeCards;
	public List<Player> players;
//	private Scanner console;
	
	/**
	 * 构造函数
	 */
	public PokeGame() {
		pokeCards = new ArrayList<Card>();
		players = new ArrayList<Player>();
	//	console = new Scanner(System.in);
	}
	
	
	/**
	 * InitialCard()初始化扑克牌
	 * @param args
	 */
	public void InitialCard() {
		//提示创建扑克牌
		System.out.println("------------创建扑克牌------------");
		//初始化initialCards对象
		String[] colors = {"方片", "梅花", "黑桃", "红桃"};
		String[] nums = {"2", "3", "4", "5", "6", "7", "8", "9", "10", 
				"J", "Q", "K", "A"};
		for (String string1 : colors) {
			for (String string2 : nums) {
				pokeCards.add(new Card(string1, string2));
			}
		}
		//提示创建成功
		System.out.println("------------创建成功------------");
		System.out.print("为：[ ");
		for (Card c : pokeCards) {
			System.out.print(c.color+c.num+" ");
		}
		System.out.println("]");
	}
	/**
	 * 利用Collections.shuffle()方法随机排序，洗牌
	 * @param args
	 */
	public void Shuffle() {
		//提示开始洗牌
		System.out.println("------------开始洗牌-------------");
		Collections.shuffle(pokeCards);
		//提示洗牌结束
		System.out.println("------------洗牌结束-------------");
	}
	
	/**
	 * 从键盘输入创建2名玩家，要进行异常处理
	 */
	public void createPlayer() {
		//提示创建玩家
		System.out.println("------------创建玩家-------------");
		//创建2名玩家
		int count= 1;
		while (count <= 2) {
			//提示用户输入ID和姓名
			System.out.println("请输入第"+count+"位玩家的ID和姓名：");
			try {
				//创建Scanner类对象，获得用户输入
				System.out.println("输入ID：");
				//Scanner一定要在while循环内，清空原来的console，否则只能输入一次
				Scanner console = new Scanner(System.in);
				Integer id = console.nextInt();
				System.out.println("输入姓名：");
				String name = console.next();
				//加入到玩家集合中
				players.add(new Player(id, name));
				count++;				
			} catch(InputMismatchException e) {
				// TODO: handle finally clause
				//提示输入整数类型的ID
				System.out.println("请输入整数类型的ID！");
				continue;
			}
		}
		//创建玩家成功，欢迎玩家
		for (Player player : players) {
			System.out.println("欢迎玩家："+player.name);
		}
	}
	
	/**
	 * 发牌
	 * @param args
	 */
	public void deal() {
		//提示开始发牌
		System.out.println("------------开始发牌-------------");
		//每人发两张牌
		int count= 1;
		while (count <= 2) {
			for (Player player : players) {
				//提示玩家拿牌
				System.out.println("---玩家"+player.name+"拿牌");
				//给玩家发牌
				player.cards.add(pokeCards.get(0));
				//从牌堆里删除取到的牌
				pokeCards.remove(0);
			}
			count++;
		}
		//提示发牌结束
		System.out.println("------------发牌结束-------------");
	}
	
	/**
	 * 开始游戏，比大小
	 * @param args
	 */
	public void Game() {
		//提示开始游戏
		System.out.println("------------开始游戏-------------");
		//创建List集合存储玩家的最大手牌
		List<Card> cardPlayer = new ArrayList<Card>();
		for (Player player : players) {
			//提示玩家的最大手牌
			Collections.sort(player.cards);
			Card maxCard = player.cards.get(player.cards.size()-1);
			System.out.println("玩家："+player.name+"的最大手牌为："+
					maxCard.color+maxCard.num);
			//加入最大手牌集
			cardPlayer.add(maxCard);
		}
		//排序，获得最终的最大手牌
		Collections.sort(cardPlayer);
		Card finalMaxCard = cardPlayer.get(cardPlayer.size()-1);
		//判断最大手牌属于哪个玩家，利用contains()方法
		for (Player player : players) {
			if (player.cards.contains(finalMaxCard)) {
				System.out.println("------玩家："+player.name+"获胜！");
				break;
			}
			else 
				continue;
		}
		//打印玩家各自手牌
		System.out.println("玩家各自的手牌为：");
		for (Player player : players) {
			System.out.print(player.name+":[ ");
			for (Card card : player.cards) {
				System.out.print(card.color+card.num+" ");
			}
			System.out.println("]");
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PokeGame pGame = new PokeGame();
		pGame.InitialCard();
		pGame.createPlayer();
		pGame.Shuffle();
		pGame.deal();
		pGame.Game();
	}
}
