package DVDPlayers;

interface Players {
		void play();
		void stop();

}

interface ExPlayers extends Players {
	void slow();
}

public class DVDPlayer implements ExPlayers{
	public void play() {
		System.out.println("DVD 재생 시작!");
	}
	public void stop() {
		System.out.println("DVD 재생 정지!");
	}
	public void slow() {
		System.out.println("DVD 재생 느리게!");
	}
}

