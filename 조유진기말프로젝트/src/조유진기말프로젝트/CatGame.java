package 조유진기말프로젝트;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

//생쥐 이미지가 고양이 앞발 이미지에 닿으면 게임 종료, 다시 시작 창 나가기 버튼 추가 - 실행잘됨!
//고양이 앞발 이미지는 랜덤위치에서 내려옴!

//고양이 클래스
class Cat {
	private Image image;
	public Cat(){
		loadImage();
	}
	
	private void loadImage() {
	      ImageIcon icon = new ImageIcon("고양이.png"); // 고양이 이미지
	      image = icon.getImage();
	  }
	
	//고양이 이미지 그리기
	public void paint(Graphics g) {
	  g.drawImage(image, 225, 30, 50, 50, null); // 이미지 그리기
	}
	  
	  
	public Rectangle getBounds() {
	    return new Rectangle(225, 30, 50, 50);
	}
}

//생쥐 클래스
class Mouse {
  private int x, y;
  private int speed;
  private Image image; // 생쥐 이미지

  public Mouse() {
      x = 250;
      y = 300;
      speed = 10;
      loadImage(); // 이미지 로드
  }
  
  private void loadImage() {
      ImageIcon icon = new ImageIcon("생쥐.png"); // 생쥐 이미지
      image = icon.getImage();
  }
  
  //생쥐 - 상하좌우로 움직이기 
  public void moveUp() {
      y -= speed;
  }
  
  public void moveDown() {
      y += speed;
  }
  
  public void moveLeft() {
      x -= speed;
  }

  public void moveRight() {
      x += speed;
  }

  //생쥐 - get, set 메소드
  public int getX() {
      return x;
  }

  public int getY() {
      return y;
  }
  
  //생쥐 이미지 그리기
  public void paint(Graphics g) {
  	g.drawImage(image, x, y, 30, 30, null); // 이미지 그리기
  }
  
  
  public Rectangle getBounds() {
      return new Rectangle(x, y, 30, 30);
  }
}

//고양이의 앞발 클래스
class Paw {
  private int x, y;
  private Image image; // 앞발 이미지

  public Paw(int x, int y) {
      this.x = x;
      this.y = y;
      loadImage(); // 앞발 이미지 로드
  }

  private void loadImage() {
      ImageIcon icon = new ImageIcon("고양앞발.png"); 
      image = icon.getImage();
  }
  
  public int getX() {
      return x;
  }

  public int getY() {
      return y;
  }

  
  //앞발 - get, set 메소드 
  public void setX(int x) {
      this.x = x;
  }
  
  public void setY(int y) {
      this.y = y;
  }

  //앞발 - 그리기
  public void paint(Graphics g) {
  	g.drawImage(image, x, y, 30, 30, null); // 이미지 그리기
      
  }
  
  public Rectangle getBounds() {
      return new Rectangle(x, y, 30, 30);
  }
}

//방울 클래스
class Bell{
	private int x, y;
    private Image image;
    
    public Bell(int x, int y) {
    	this.x = x;
    	this.y = y;
    	loadImage();
    }
    
    private void loadImage() {
        ImageIcon icon = new ImageIcon("방울.png"); 
        image = icon.getImage();
    }
    
    //방울 - get, set 메서드 
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    
    public void setX(int x) {
        this.x = x;
    }
    
    public void setY(int y) {
        this.y = y;
    }
    
    //방울 그리기
    public void paint(Graphics g) {
        g.drawImage(image, x, y, 30, 30, null);
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, 30, 30);
    }
    
}


//게임 구현 메인클래스~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~!!!
public class CatGame extends JFrame {
  private Timer timer;
  private Cat cat;
  private Mouse mouse;
  private List<Paw> paws;
  private List<Bell> bells;
 
  private boolean gameRunning;
  private boolean bellCollected = false;

// 윈도우의 너비와 높이를 정의
  private int windowWidth = 500;
  private int windowHeight = 400;
  
  public CatGame() {
      initUI();
  }
  
//UI설정 - 윈도우 타이틀, 크기 등 설정하기
  private void initUI() {
      setTitle("고양이 목에 방울달기");
      setSize(500, 400);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      mouse = new Mouse();
      paws = new ArrayList<>();
      bells = new ArrayList<>();
      
      gameRunning = true;

      // 초기 앞발, 방울 생성 -  랜덤 위치 
      for (int i = 0; i < 5; i++) {
          int randomX = (int) (Math.random() * (windowWidth - 20));
          int randomY = (int) (Math.random() * (windowHeight - 20));
          paws.add(new Paw(randomX, randomY));
          
          int bellX = (int) (Math.random() * (windowWidth - 20));
          int bellY = (int) (Math.random() * (windowHeight - 20));
          bells.add(new Bell(bellX, bellY));
      }
      

      timer = new Timer(11, new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
              if (gameRunning) {
                  gameUpdate();
                  repaint();
              }
          }
      });

      timer.start();

      addKeyListener(new KeyAdapter());
      setFocusable(true);

      setLocationRelativeTo(null);
  }

  private void gameUpdate() {
      // 앞발/방울 움직이기 메서드, 충돌 체크 메서드 
	  movePaws();
      moveBells();
      checkCollision();
     
  }

  //방울 움직이기 메서드 정의
  private void moveBells() {
      for (Bell bell : bells) {
          // 방울을 아래로 이동
          bell.setY(bell.getY() + 1);

          // 방울이 화면을 벗어나면 다시 위로 이동
          if (bell.getY() > getHeight()) {
              bell.setY(0);
          }
      }
  }


  private void movePaws() {
      for (Paw paw : paws) {
        // 앞발을 아래로 이동
      	paw.setY(paw.getY() + 1);

        // 앞발이 화면을 벗어나면 다시 위로 이동
        if (paw.getY() > getHeight()) {
          paw.setY(0);
        }

        // 앞발이 생쥐를 잡았다?(=닿았다!) 게임 종료
        if (paw.getBounds().intersects(mouse.getBounds())) {
            endGame();
          }
      }
  }

  
  private void checkCollision() {
	  
	  
	  Iterator<Bell> iterator = bells.iterator(); 
	  while (iterator.hasNext()) {
		  Bell bell = iterator.next();
		  
		  
		  //벨을 획득했을 경우->
		  if (mouse.getBounds().intersects(bell.getBounds())) { 
			  bellCollected=true;
			  iterator.remove(); // Iterator를 사용하여 벨 원소 삭제
			  JOptionPane.showMessageDialog(this, "방울 획득! 고양이에게 달려가세요!");
			  bellCollected=true;
		  }
		  
		 //고양이와 닿았을 경우->
		  if(mouse.getBounds().intersects(cat.getBounds())){
			  if(bellCollected) {
				  JOptionPane.showMessageDialog(this, "방울을 달았습니다! 미션 성공!");
				  endGame();
				  break;
			  }
			  
			  if(bellCollected==false){
				  JOptionPane.showMessageDialog(this, "이런, 잡아먹혔어! 방울을 달 것도 아니면서 뭐하는 거야!");
				  endGame(); 
			  }
		  
		
//생쥐가 앞발에 닿은 경우 -> 게임 종료 메서드 불러옴
  for (Paw paw : paws) {
      if (mouse.getBounds().intersects(paw.getBounds())) {
          endGame();
      }
  }
  
}
}
}

  //게임을 종료하는 메소드 구현하기
  private void endGame() {
      gameRunning = false;
      timer.stop();

      int option = JOptionPane.showOptionDialog(
              this,
              "게임이 종료되었습니다! 재시작하시겠습니까>",
              "게임 종료",
              JOptionPane.YES_NO_OPTION,
              JOptionPane.QUESTION_MESSAGE,
              null,
              null,
              null
      );

      if (option == JOptionPane.YES_OPTION) {
          restartGame();
      } else {
          System.exit(0);
      }
  }
  
  //재시작
  private void restartGame() {
      mouse = new Mouse();
      paws.clear();
   
      gameRunning = true;

      
      timer.start();
  }
  
  //키보드 이벤트 리스너(상하좌우 움직이기)
  private class KeyAdapter implements KeyListener {
      @Override
      public void keyPressed(KeyEvent e) {
          int key = e.getKeyCode();

          if (key == KeyEvent.VK_LEFT) {
              mouse.moveLeft();
          } else if (key == KeyEvent.VK_RIGHT) {
              mouse.moveRight();
          } else if (key == KeyEvent.VK_UP) {
              mouse.moveUp();
          } else if (key == KeyEvent.VK_DOWN) {
              mouse.moveDown();
          }
          
       // 벨을 획득한 경우에만 true로 설정
          if (key == KeyEvent.VK_SPACE) {
              Iterator<Bell> iterator = bells.iterator();
              while (iterator.hasNext()) {
                  Bell bell = iterator.next();
                  if (mouse.getBounds().intersects(bell.getBounds())) {
                      iterator.remove();
                      JOptionPane.showMessageDialog(CatGame.this, "방울 획득! 고양이에게 달려가세요!");
                      bellCollected = true;
                  }
              }
          }   
      }

      @Override
      public void keyTyped(KeyEvent e) {
          // 사용하지 않음
      }

      @Override
      public void keyReleased(KeyEvent e) {
          // 사용하지 않음
      }
  }

  @Override
  public void paint(Graphics g) {
      super.paint(g);
      
      //땅 그리기 (초록색 수평선)
      g.setColor(Color.GREEN);
      //g.fillRect(0, windowHeight - 20, windowWidth, 20);
      g.fillRect(0, 330, windowWidth, 500);
      
      //고양이 그리기 - 윈도우 상단 중앙에 세로폭 가로폭 각각 50인 고양이 이미지 그리기
      //이 부분에 코드 작성
      cat = new Cat();
      cat.paint(g);
     
      // 생쥐 그리기
      mouse.paint(g);
      
      //고양이 앞발 그리기
      for (Paw alien : paws) {
          alien.paint(g);
      }
      
      //방울 그리기
      for (Bell bell : bells) {
    	  bell.paint(g);
      }
  }
  
  //코드 동작하기
  public static void main(String[] args) {
      SwingUtilities.invokeLater(new Runnable() {
          @Override
          public void run() {
              CatGame ex = new CatGame();
              ex.setVisible(true);
          }
      });
  }
}

