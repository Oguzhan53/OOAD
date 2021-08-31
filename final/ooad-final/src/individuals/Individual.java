/**
 * 
 */
package individuals;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Iterator;
import java.util.Random;

/**
 * Individual class
 * 
 * @author Oguzhan SEZGIN
 *
 */
public class Individual extends IndividualComponent {

	private final int X_BOUND = 995;
	private final int Y_BOUND = 595;
	private final int P_SIZE = 5;
	private int id;
	private int x;
	private int y;
	private int[] prevCoor;
	private Direction direction;
	private double mask;
	private double speed;
	private double distance;
	private double collision;
	private boolean isEnfected;
	private int waitingTime;
	private Mediator mediator;
	private int lifetime;
	private int inHospitalTime;
	private int goHospitalTime;

	public Individual(int id, double mask, double speed, double distance, double collision, boolean isEnfected,
			Mediator mediator) {
		this.id = id;
		this.mask = mask;
		this.speed = speed;
		this.distance = distance;
		this.collision = collision;
		this.isEnfected = isEnfected;
		this.mediator = mediator;
		this.mediator.registerÝndividual(this);

	}

	public Individual(int id, int x, int y, Direction direction, double mask, double speed, double distance,
			double collision, boolean isEnfected, double mortalityRate, Mediator mediator) {
		super();
		this.id = id;
		this.x = x;
		this.y = y;
		this.direction = direction;
		this.mask = mask;
		this.speed = speed;
		this.distance = distance;
		this.collision = collision;
		this.isEnfected = isEnfected;
		this.mediator = mediator;
		this.mediator.registerÝndividual(this);
		this.prevCoor = new int[2];
		this.prevCoor[0] = x;
		this.prevCoor[1] = y;
		this.waitingTime = 0;
		this.inHospitalTime = -1;
		if (isEnfected) {
			this.goHospitalTime = 25;
			this.lifetime = (int) (100 * (1.0 - mortalityRate));
		} else {
			goHospitalTime = -1;
			lifetime = -1;
		}
	}

	public int getLifetime() {
		return lifetime;
	}

	public void setLifetime(int lifetime) {
		this.lifetime = lifetime;
	}

	public int getInHospitalTime() {
		return inHospitalTime;
	}

	public void setInHospitalTime(int inHospitalTime) {
		this.inHospitalTime = inHospitalTime;
	}

	public int getGoHospitalTime() {
		return goHospitalTime;
	}

	public void setGoHospitalTime(int goHospitalTime) {
		this.goHospitalTime = goHospitalTime;
	}

	@Override
	public int getWaitingTime() {
		return waitingTime;
	}

	@Override
	public void setWaitingTime(int waitingTime) {
		this.waitingTime = waitingTime;
	}

	@Override
	public int[] getPrevCoor() {
		return prevCoor;
	}

	public void setPrevCoor(int[] prevCoor) {
		this.prevCoor = prevCoor;
	}

	@Override
	public void paint(Graphics g) {
		if (isEnfected)
			g.setColor(Color.RED);
		else
			g.setColor(Color.GREEN);
		g.fillRect(getX(), getY(), P_SIZE, P_SIZE);
	}

	@Override
	public int getX() {
		return x;
	}

	@Override
	public void setX(int x) {
		this.x = x;
	}

	@Override
	public int getY() {
		return y;
	}

	@Override
	public void setY(int y) {
		this.y = y;
	}

	@Override
	public Direction getDirection() {
		return direction;
	}

	@Override
	public void setDirection(Direction direction) {
		this.direction = direction;
	}

	@Override
	public Mediator getMediator() {
		return mediator;
	}

	public void setMediator(Mediator mediator) {
		this.mediator = mediator;
	}

	@Override
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public double getMask() {
		return mask;
	}

	public void setMask(float mask) {
		this.mask = mask;
	}

	@Override
	public double getSpeed() {
		return speed;
	}

	public void setSpeed(float speed) {
		this.speed = speed;
	}

	@Override
	public double getDistance() {
		return distance;
	}

	public void setDistance(float distance) {
		this.distance = distance;
	}

	@Override
	public double getCollision() {
		return collision;
	}

	public void setCollision(float collision) {
		this.collision = collision;
	}

	@Override
	public boolean isEnfected() {
		return isEnfected;
	}

	@Override
	public void setEnfected(boolean isEnfected) {
		this.isEnfected = isEnfected;
	}

	/**
	 * This methods updates individual coordinate and status
	 */
	@Override
	public Status move(boolean repeat) {
		Random rand = new Random();
		if (waitingTime == 0) {

			int newDirect = 0;
			boolean flag = true;
			while (flag) {
				switch (this.direction) {

				case UP:
					if (this.y - this.speed >= P_SIZE) {
						prevCoor[1] = this.y;
						this.y -= this.speed;
						flag = false;
					} else {
						newDirect = rand.nextInt(4);
						this.direction = Direction.values()[newDirect];
					}
					break;
				case DOWN:
					if (this.y + this.speed <= Y_BOUND) {
						prevCoor[1] = this.y;
						this.y += this.speed;
						flag = false;
					} else {
						newDirect = rand.nextInt(4);
						this.direction = Direction.values()[newDirect];
					}
					break;

				case RIGHT:
					if (this.x + this.speed <= X_BOUND) {
						prevCoor[0] = this.x;
						this.x += this.speed;
						flag = false;
					} else {
						newDirect = rand.nextInt(4);
						this.direction = Direction.values()[newDirect];
					}
					break;
				case LEFT:
					if (this.x - this.speed >= P_SIZE) {
						prevCoor[0] = this.x;
						this.x -= this.speed;
						flag = false;
					} else {
						newDirect = rand.nextInt(4);
						this.direction = Direction.values()[newDirect];
					}
					break;
				default:
					break;
				}
			}
		}

		if (!repeat && this.lifetime != -1 && this.lifetime - 1 >= 0) {
			this.lifetime--;
			if (this.lifetime == 0) {
				return Status.DEATH;
			}
		}
		if (!repeat && this.goHospitalTime != -1 && this.goHospitalTime - 1 >= 0) {
			goHospitalTime--;
			if (this.goHospitalTime == 0) {
				return Status.HOSPITALIZED;
			}
		}

		if (!repeat && this.waitingTime - 1 >= 0) {
			this.waitingTime--;
			if (this.waitingTime == 0) {
				int newDirect = rand.nextInt(4);
				this.direction = Direction.values()[newDirect];
				move(true);
			}
		}

		if (!repeat && this.inHospitalTime != -1 && this.inHospitalTime - 1 >= 0) {
			this.inHospitalTime--;
			if (this.inHospitalTime == 0) {
				return Status.DISCHARGE;
			}

		}

		return Status.CONTINUE;

	}

	@SuppressWarnings("rawtypes")
	@Override
	Iterator createIterator() {
		return new NullIterator();
	}

	@Override
	public void print() {
		System.out.println("id : " + id);
	}

	@Override
	public String toString() {

		return "x : " + this.getX() + " y : " + this.getY();
	}

}
