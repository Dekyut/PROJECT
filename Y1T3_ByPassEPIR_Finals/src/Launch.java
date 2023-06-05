import java.awt.EventQueue;

public class Launch {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainMenu window = new MainMenu();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

}
