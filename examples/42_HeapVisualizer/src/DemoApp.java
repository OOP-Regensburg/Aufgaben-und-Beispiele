import java.io.File;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Iterator;

import com.sun.deploy.security.SecureStaticVersioning;
import de.ur.mi.graphics.Rect;
import de.ur.mi.graphicsapp.GraphicsApp;
import de.ur.mi.util.RandomGenerator;
import ur.mi.oop.config.Config;
import ur.mi.oop.heapvisualizer.HeapVisualizer;
import ur.mi.oop.logger.Logger;


@SuppressWarnings("serial")
public class DemoApp extends GraphicsApp {

	private static final String CONFIG_FILE_PATH = "/data/assets/visualizer.config";
	private static final String LOG_FILE_PATH = "/data/assets/visualizer.log";
	private static final int MAX_FRAMES_TO_LOG = 100;
	
	private RandomGenerator random = RandomGenerator.getInstance();
	private Config config;
	private Logger log;
	
	private Rect boundingBox;
	private HeapVisualizer heapVisualizer;
	private ArrayList<Ball> balls;
	
	private int collisionsInCurrentFrame = 0;
	

	public void setup() {
		initConfig();
		initBalls();
		initHeapVisualizer();
		initLogger();
		size(config.getWidth(), config.getHeight());
	}
	
	private void initConfig() {
        File configFile = loadFile(CONFIG_FILE_PATH);
		config = new Config(configFile);
		if(!config.isValid()) {
			println("Invalid config file!");
			System.exit(1);
		}
	}
	
	private void initBalls() {
		balls = new ArrayList<Ball>();
		boundingBox = new Rect(0,0,config.getWidth(),config.getHeight(), null);
		fillBallList();
	}
	
	private void initHeapVisualizer() {
		heapVisualizer = new HeapVisualizer(config.getWidth(), config.getHeight());
	}
	
	private void initLogger() {
		File logFile = createFile(LOG_FILE_PATH);
		log = new Logger(logFile, MAX_FRAMES_TO_LOG);
	}
	
	private void fillBallList() {
		for(int i = balls.size(); i < config.getMaxBalls(); i++) {
			addNewBall();
		}
	}
	
	private void addNewBall() {
		boolean addBall = random.nextBoolean(0.5);
		if(!addBall) {
			return;
		}
		
		int x = random.nextInt(0, config.getWidth());
		int y = random.nextInt(0, config.getHeight());
		int dx = 0;
		int dy = 0;
		while(dx == 0 || dy == 0) {
			dx = random.nextInt(config.getMinBallVelocity(), config.getMaxBallVelocity());
			dy = random.nextInt(config.getMinBallVelocity(), config.getMaxBallVelocity());
		}
		balls.add(new Ball(x,y, config.getBallRadius(), dx, dy, config.getBallColor(), boundingBox));
	}
	

	public void draw() {	
		background(config.getBackgroundColor());
		heapVisualizer.draw();
		
		updateBalls();
		drawBalls();
		
		log.logFrame(balls.size(), collisionsInCurrentFrame);
		
		fillBallList();
	}
	
	private void updateBalls() {
		collisionsInCurrentFrame = 0;
		for(Ball ball: balls) {
			ball.update();
			handleBallCollision(ball);
		}
	}
	private void drawBalls() {
		for (Iterator<Ball> it = balls.iterator(); it.hasNext(); ) {
		    Ball ball = it.next();
			if(ball.isInBoundingBox()) {
				ball.draw();
			} else {
				it.remove();
			}
		}
	}
	
	private void handleBallCollision(Ball ball) {
		for(Ball checkBall: balls) {
			if(ball.equals(checkBall)) {
				continue;
			} else {
				if(ball.collidesWith(checkBall)) {
					int[] newDirecton = ball.reverseDirection();
					checkBall.setDirection(-newDirecton[0], -newDirecton[1]);
					collisionsInCurrentFrame++;
					break;
				}
			}
		}
	}
}
