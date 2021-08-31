/**
 * 
 */
package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

import controller.ControllerInterface;
import individuals.Individual;
import individuals.IndividualComponent;
import individuals.Society;
import model.SocietyModel;
import model.SocietyModelInterface;

/**
 * View Class
 * 
 * @author Oguzhan SEZGIN
 *
 */
public class SocietyView extends JFrame implements Observer, Runnable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final int CANVAS_WIDTH = 1000;
	public static final int CANVAS_HEIGHT = 600;
	public static final int PIXEL_SIZE = 5;
	private JPanel btnPanel;
	private DrawCanvas canvas;
	private JLabel labelHealthy;
	private JLabel labelInfected;
	private JLabel labelDeath;
	private JLabel labelHospitalized;
	private JButton btnResume;
	private JButton btnPause;

	private Society society;
	private SocietyModelInterface societyModel;
	private ControllerInterface controller;

	public SocietyView(ControllerInterface controller) {
		this.controller = controller;

	}

	@Override
	public void start(SocietyModel societyModel) {
		this.society = societyModel.getSociety();
		this.societyModel = societyModel;
		btnPanel = new JPanel(new FlowLayout());
		btnResume = new JButton("Resume ");
		btnPanel.add(btnResume);
		btnResume.setEnabled(false);
		labelHealthy = new JLabel("Healthy count: " + society.getHealtyNum());
		labelInfected = new JLabel("Infected count: " + society.getInfectedNum());
		labelDeath = new JLabel("Death count: " + society.getDeathNum());
		labelHospitalized = new JLabel("Hospitalized count: " + society.getHospitalized());
		btnResume.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				resume();
				requestFocus();

			}
		});
		btnPause = new JButton("Pause");
		btnPanel.add(btnPause);
		btnPause.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				pause();
				requestFocus();

			}
		});

		btnPanel.add(labelHealthy);
		btnPanel.add(new JSeparator(SwingConstants.VERTICAL));
		btnPanel.add(labelInfected);
		btnPanel.add(new JSeparator(SwingConstants.VERTICAL));
		btnPanel.add(labelHospitalized);
		btnPanel.add(new JSeparator(SwingConstants.VERTICAL));
		btnPanel.add(labelDeath);

		canvas = new DrawCanvas();
		canvas.setPreferredSize(new Dimension(CANVAS_WIDTH, CANVAS_HEIGHT));

		Container cp = getContentPane();
		cp.setLayout(new BorderLayout());
		cp.add(canvas, BorderLayout.CENTER);
		cp.add(btnPanel, BorderLayout.SOUTH);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("CORONA SIMULATION");
		pack();
		setVisible(true);
		requestFocus();

	}

	@Override
	public void update(Society society) {
		this.society = society;
		run();

	}

	/**
	 * This method resumes the simulation
	 */
	private void resume() {
		controller.resume();
		this.btnPause.setEnabled(true);
		this.btnResume.setEnabled(false);
	}

	/**
	 * This method pauses simulation
	 */
	private void pause() {
		controller.pause();
		this.btnPause.setEnabled(false);
		this.btnResume.setEnabled(true);
	}

	/**
	 * This method updates the view
	 */
	private void updateView() {
		@SuppressWarnings("rawtypes")
		Iterator iterator = society.getIndividulIterator();
		controller.checkCollision();
		while (iterator.hasNext()) {
			IndividualComponent arraycomponent = (IndividualComponent) iterator.next();
			try {
				if (arraycomponent instanceof Individual) {
					canvas.repaint(arraycomponent.getPrevCoor()[0], arraycomponent.getPrevCoor()[1], PIXEL_SIZE,
							PIXEL_SIZE);

					canvas.repaint(arraycomponent.getX(), arraycomponent.getY(), PIXEL_SIZE, PIXEL_SIZE);
				}
			} catch (UnsupportedOperationException e) {
			}

		}

		labelHealthy.setText("Healthy count: " + society.getHealtyNum());
		labelInfected.setText("Infected count: " + society.getInfectedNum());
		labelHospitalized.setText("Hospitalized count: " + society.getHospitalized());
		labelDeath.setText("Death count: " + society.getDeathNum());

	}

	/**
	 * Inner canvas class
	 * 
	 * @author Oguzhan SEZGIN
	 *
	 */
	class DrawCanvas extends JPanel {
		/**
		 * 
		 */
		private static final long serialVersionUID = -4753414249583906940L;

		/**
		 * This method paints the pixels(individuals)
		 */
		@Override
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			setBackground(Color.WHITE);
			@SuppressWarnings("rawtypes")
			Iterator iterator = society.getIndividulIterator();
			while (iterator.hasNext()) {
				IndividualComponent arraycomponent = (IndividualComponent) iterator.next();
				try {
					if (arraycomponent instanceof Individual) {
						arraycomponent.paint(g);
					}
				} catch (UnsupportedOperationException e) {
				}

			}

		}
	}

	/**
	 * This methods runs view thread
	 */
	@Override
	public void run() {
		synchronized (this.societyModel.getSociety()) {

			updateView();

		}

	}

}
