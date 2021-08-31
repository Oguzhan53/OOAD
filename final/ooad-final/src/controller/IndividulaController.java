/**
 * 
 */
package controller;

import java.util.LinkedList;
import java.util.Queue;

import individuals.Individual;
import individuals.Mediator;
import model.Hospital;
import model.SocietyModelInterface;
import view.SocietyView;

/**
 * @author Oguzhan SEZGIN
 *
 */
public class IndividulaController implements ControllerInterface {
	private SocietyModelInterface model;
	private SocietyView view;
	private Mediator mediator;
	private Hospital hospital;
	Queue<Individual> waitingIndividual = new LinkedList<>();

	public IndividulaController(SocietyModelInterface model, int pSize, int healthNum) {
		this.model = model;
		this.mediator = model.create(pSize, healthNum);
		this.view = new SocietyView(this);
		this.hospital = new Hospital(pSize / 10);
		model.registerObserver(view);
		model.setController(this);

	}

	public SocietyModelInterface getModel() {
		return model;
	}

	public void setModel(SocietyModelInterface model) {
		this.model = model;
	}

	public SocietyView getView() {
		return view;
	}

	public void setView(SocietyView view) {
		this.view = view;
	}

	@Override
	public void start() {
		model.start();
	}

	@Override
	public void pause() {
		this.model.pause();

	}

	@Override
	public void resume() {
		this.model.resume();

	}

	@Override
	public void goHospital(Individual individual) {
		if (individual != null)
			waitingIndividual.add(individual);
		registerHospital();

	}

	/**
	 * This method register individual to hospital
	 */
	public void registerHospital() {
		if (waitingIndividual.size() > 0) {
			Individual first = waitingIndividual.peek();
			while (waitingIndividual.size() != 0) {
				first = waitingIndividual.peek();
				if (first.getX() == 2000) {
					waitingIndividual.remove();
				} else
					break;

			}

			if (first.getX() != 2000 && hospital.addInfected(first)) {
				waitingIndividual.remove();
				int oldInfeced = this.model.getSociety().getInfectedNum();
				this.model.getSociety().setHospitalized(this.hospital.getInfectedNum());
				this.model.getSociety().setInfectedNum(oldInfeced - 1);

			}
		}

	}

	@Override
	public void checkCollision() {
		int newInfected = this.mediator.chekCollision();
		int oldHealty = this.model.getSociety().getHealtyNum();
		int oldInfected = this.model.getSociety().getInfectedNum();
		this.model.getSociety().setHealtyNum(oldHealty - newInfected);
		this.model.getSociety().setInfectedNum(oldInfected + newInfected);
	}

	@Override
	public void dischargeIndividual(Individual individual) {
		hospital.dischargeIndividual(individual);
		int oldHealty = this.model.getSociety().getHealtyNum();
		this.model.getSociety().setHospitalized(this.hospital.getInfectedNum());
		this.model.getSociety().setHealtyNum(oldHealty + 1);

	}

}
