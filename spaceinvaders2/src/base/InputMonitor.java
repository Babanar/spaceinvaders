package base;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.LinkedList;

public class InputMonitor extends KeyAdapter {
	private static HashMap<Integer,Boolean> key_state = new HashMap<>();
	private static LinkedList<Integer> listKeyPressed = new LinkedList<>();
	public static InputMonitor instance = new InputMonitor();
	
	
	public static void resetListEvent(){
		listKeyPressed.clear();
	}
	
	public static LinkedList<Integer> getListEvent(){
		return listKeyPressed;
	}
	
	public static boolean isPressed(Integer key){
		return (key_state.containsKey(key) && key_state.get(key));
	}
	
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode()==KeyEvent.VK_ESCAPE)
			System.exit(0);
		
		listKeyPressed.add(e.getKeyCode());
		key_state.put(e.getKeyCode(), true);
	} 

	public void keyReleased(KeyEvent e){
		key_state.put(e.getKeyCode(), false);
	}
	
	
}
