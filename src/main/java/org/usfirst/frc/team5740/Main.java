package org.usfirst.frc.team5740;

import org.usfirst.frc.team5740.gui.StartGui;
import org.usfirst.frc.team5740.trajectory.Path;
import org.usfirst.frc.team5740.trajectory.PathGenerator;
import org.usfirst.frc.team5740.trajectory.TrajectoryGenerator;
import org.usfirst.frc.team5740.trajectory.WaypointSequence;
import org.usfirst.frc.team5740.trajectory.io.JavaSerializer;
import org.usfirst.frc.team5740.trajectory.io.TextFileSerializer;
import org.usfirst.frc.team5740.util.ChezyMath;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Logger;

/**
 *
 * @author Jared341
 */
public class Main {
	
	public static Logger logger =  Logger.getLogger(Main.class.getName());

	public static String javaDirectory = "~/Desktop/gem";
	public static String textDirectory = "D:/Users/Julia/workspace/2018_CIA_Rev8/paths";
	public static TrajectoryGenerator.Config config = new TrajectoryGenerator.Config();
	public static final double kWheelbaseWidth = 23.819 / 12.0; // find with in feet

	public static String joinPath(final String path1, final String path2) {
		final File file1 = new File(path1);
		final File file2 = new File(file1, path2);
		return file2.getPath();
	}

	private static boolean writeFile(final String path, final String data) {
		try {
			final File file = new File(path);

			// if file doesn't exists, then create it
			if (!file.exists()) {
				file.createNewFile();
			}

			final FileWriter fw = new FileWriter(file.getAbsoluteFile());
			final BufferedWriter bw = new BufferedWriter(fw);
			bw.write(data);
			bw.close();
		} catch (final IOException e) {
			return false;
		}

		return true;
	}

	public static void main(final String[] args) {

		logger.info("Starting Path gen ");
		StartGui.startUI(args);

	}

	private static void LeftSwitchPath() {
		config.dt = .02;
		config.max_acc = 6;
		config.max_jerk = 30.0;
		config.max_vel = 8;
		// Path name must be a valid Java class name.
		final String path_name = "LeftSwitchPath";

		// Description of this auto mode path.
		// Remember that this is for the BLUE CASE!
		final WaypointSequence p = new WaypointSequence(10);
		p.addWaypoint(new WaypointSequence.Waypoint(0, 0, 0));
		p.addWaypoint(new WaypointSequence.Waypoint(90.0 / 12.0, 62.0 / 12.0, Math.PI / 9.0));

		final Path path = PathGenerator.makePath(p, config, kWheelbaseWidth, path_name);
		writeFiles(path_name, path);
	}

	private static void RightSwitchPath() { // TODO RightSwitchPath
		config.dt = .02;
		config.max_acc = 6;
		config.max_jerk = 30.0;
		config.max_vel = 8;
		// Path name must be a valid Java class name.
		final String path_name = "RightSwitchPath";

		// Description of this auto mode path.
		// Remember that this is for the BLUE CASE!
		final WaypointSequence p = new WaypointSequence(10);
		p.addWaypoint(new WaypointSequence.Waypoint(0, 0, 0));
		p.addWaypoint(new WaypointSequence.Waypoint(95.0 / 12.0, -45.0 / 12.0, -Math.PI / 9.0));

		final Path path = PathGenerator.makePath(p, config, kWheelbaseWidth, path_name);
		writeFiles(path_name, path);
	}

	private static void SideSwitchPath() { // TODO SideSwitchPath
		config.dt = .02;
		config.max_acc = 6;
		config.max_jerk = 30.0;
		config.max_vel = 8;
		// Path name must be a valid Java class name.
		final String path_name = "SideSwitchPath";

		// Description of this auto mode path.
		// Remember that this is for the GO LEFT case! (starting on right)
		final WaypointSequence p = new WaypointSequence(10);
		p.addWaypoint(new WaypointSequence.Waypoint(0, 0, 0));
		p.addWaypoint(new WaypointSequence.Waypoint(150.0 / 12.0, 0.0, 0.0));

		final Path path = PathGenerator.makePath(p, config, kWheelbaseWidth, path_name);
		writeFiles(path_name, path);
	}

	private static void ForwardSwitchPath() { // TODO ForwardSwitchPath
		config.dt = .02;
		config.max_acc = 6;
		config.max_jerk = 30.0;
		config.max_vel = 8;
		// Path name must be a valid Java class name.
		final String path_name = "ForwardSwitchPath";

		// Description of this auto mode path.
		// Remember that this is for the GO LEFT case! (starting on right)
		final WaypointSequence p = new WaypointSequence(10);
		p.addWaypoint(new WaypointSequence.Waypoint(0, 0, 0));
		p.addWaypoint(new WaypointSequence.Waypoint(21.0 / 12.0, 0.0, 0.0));

		final Path path = PathGenerator.makePath(p, config, kWheelbaseWidth, path_name);
		writeFiles(path_name, path);
	}

	private static void SwitchToCubeLineUpPath() { // TODO SwitchToCubeLineUpPath
		config.dt = .02;
		config.max_acc = 4;
		config.max_jerk = 30.0;
		config.max_vel = 8;
		// Path name must be a valid Java class name.
		final String path_name = "SwitchToCubeLineUpPath";

		// Description of this auto mode path.
		// Remember that this is for the BLUE CASE!
		final WaypointSequence p = new WaypointSequence(10);
		p.addWaypoint(new WaypointSequence.Waypoint(0, 0, 0));
		p.addWaypoint(new WaypointSequence.Waypoint(60.0 / 12.0, 20.0 / 12.0, Math.PI / (180.0 / 65.0)));

		final Path path = PathGenerator.makePath(p, config, kWheelbaseWidth, path_name);
		writeFiles(path_name, path);
	}

	private static void ForwardCubePickupPath() { // TODO ForwardCubePickupPath
		config.dt = .02;
		config.max_acc = 5;
		config.max_jerk = 30.0;
		config.max_vel = 8;
		// Path name must be a valid Java class name.
		final String path_name = "ForwardCubePickupPath";

		// Description of this auto mode path.
		// Remember that this is for the BLUE CASE!
		final WaypointSequence p = new WaypointSequence(10);
		p.addWaypoint(new WaypointSequence.Waypoint(0, 0, 0));
		p.addWaypoint(new WaypointSequence.Waypoint(40.0 / 12.0, 0, 0));

		final Path path = PathGenerator.makePath(p, config, kWheelbaseWidth, path_name);
		writeFiles(path_name, path);
	}

	private static void CubeToSwitchPath() { // TODO CubeToSwitchPath
		config.dt = .02;
		config.max_acc = 5;
		config.max_jerk = 30.0;
		config.max_vel = 8;
		// Path name must be a valid Java class name.
		final String path_name = "CubeToSwitchPath";

		// Description of this auto mode path.
		// Remember that this is for the BLUE CASE!
		final WaypointSequence p = new WaypointSequence(10);
		p.addWaypoint(new WaypointSequence.Waypoint(0, 0, 0));
		p.addWaypoint(new WaypointSequence.Waypoint(45.0 / 12.0, 55.0 / 12.0, Math.PI / (180.0 / 60.0)));

		final Path path = PathGenerator.makePath(p, config, kWheelbaseWidth, path_name);
		writeFiles(path_name, path);
	}

	private static void NearScalePath() { // TODO NearScalePath
		config.dt = .02;
		config.max_acc = 6.0;
		config.max_dec = 4.0;
		config.max_jerk = 30.0;
		config.max_vel = 8;
		// Path name must be a valid Java class name.
		final String path_name = "NearScalePath";

		// Description of this auto mode path.
		// Remember that this is for the RIGHT SCALE CASE starting on the RIGHT!
		final WaypointSequence p = new WaypointSequence(10);
		p.addWaypoint(new WaypointSequence.Waypoint(0, 0, 0));
		p.addWaypoint(new WaypointSequence.Waypoint(145.0 / 12.0, 0, 0)); // 145
		p.addWaypoint(new WaypointSequence.Waypoint(258.0 / 12.0, 30.0 / 12.0, Math.PI / 9.0));// 248

		final Path path = PathGenerator.makePath(p, config, kWheelbaseWidth, path_name);
		writeFiles(path_name, path);
	}

	private static void SlowNearScalePath() { // TODO NearScalePath
		config.dt = .02;
		config.max_acc = 4.0;
		config.max_dec = 4.0;
		config.max_jerk = 30.0;
		config.max_vel = 8;
		// Path name must be a valid Java class name.
		final String path_name = "SlowNearScalePath";

		// Description of this auto mode path.
		// Remember that this is for the RIGHT SCALE CASE starting on the RIGHT!
		final WaypointSequence p = new WaypointSequence(10);
		p.addWaypoint(new WaypointSequence.Waypoint(0, 0, 0));
		p.addWaypoint(new WaypointSequence.Waypoint(145.0 / 12.0, 0, 0)); // 145
		p.addWaypoint(new WaypointSequence.Waypoint(258.0 / 12.0, 30.0 / 12.0, Math.PI / 9.0));// 248

		final Path path = PathGenerator.makePath(p, config, kWheelbaseWidth, path_name);
		writeFiles(path_name, path);
	}

	private static void FastNearScalePath() { // TODO NearScalePath
		config.dt = .02;
		config.max_acc = 7.0;
		config.max_dec = 4.0;
		config.max_jerk = 30.0;
		config.max_vel = 9.0;
		// Path name must be a valid Java class name.
		final String path_name = "FastNearScalePath";

		// Description of this auto mode path.
		// Remember that this is for the RIGHT SCALE CASE starting on the RIGHT!
		final WaypointSequence p = new WaypointSequence(10);
		p.addWaypoint(new WaypointSequence.Waypoint(0, 0, 0));
		p.addWaypoint(new WaypointSequence.Waypoint(145.0 / 12.0, 0, 0)); // 145
		p.addWaypoint(new WaypointSequence.Waypoint(258.0 / 12.0, 40.0 / 12.0, Math.PI / 9.0));// 248 30

		final Path path = PathGenerator.makePath(p, config, kWheelbaseWidth, path_name);
		writeFiles(path_name, path);
	}

	private static void NearScaleSidePath() { // TODO NearScalePath
		config.dt = .02;
		config.max_acc = 7.0;
		config.max_dec = 4.0;
		config.max_jerk = 30.0;
		config.max_vel = 9.0;
		// Path name must be a valid Java class name.
		final String path_name = "NearScaleSidePath";

		// Description of this auto mode path.
		// Remember that this is for the RIGHT SCALE CASE starting on the RIGHT!
		final WaypointSequence p = new WaypointSequence(10);
		p.addWaypoint(new WaypointSequence.Waypoint(0, 0, 0));
		p.addWaypoint(new WaypointSequence.Waypoint(145.0 / 12.0, -25.0 / 12.0, 0)); // 145
		p.addWaypoint(new WaypointSequence.Waypoint(220.0 / 12.0, -25.0 / 12.0, 0)); // 145
		p.addWaypoint(new WaypointSequence.Waypoint(275.0 / 12.0, 0.0 / 12.0, Math.toRadians(60.0)));// 248

		final Path path = PathGenerator.makePath(p, config, kWheelbaseWidth, path_name);
		writeFiles(path_name, path);
	}

	private static void RightFarScalePath() { // TODO RightFarScalePath
		config.dt = .02;
		config.max_acc = 4.5;
		config.max_dec = 3.0;
		config.max_jerk = 30.0;
		config.max_vel = 6;
		// Path name must be a valid Java class name.
		final String path_name = "RightFarScalePath";

		// Description of this auto mode path.
		// Remember that this is for the LEFT SCALE CASE starting on the RIGHT!
		final WaypointSequence p = new WaypointSequence(100);

		p.addWaypoint(new WaypointSequence.Waypoint(0, 0, 0));
		p.addWaypoint(new WaypointSequence.Waypoint(90.0 / 12.0, -25.0 / 12.0, Math.toRadians(0.0)));
		p.addWaypoint(new WaypointSequence.Waypoint(190.0 / 12.0, 55.0 / 12.0, Math.toRadians(89.9)));// 187
		p.addWaypoint(new WaypointSequence.Waypoint(170.0 / 12.0, 215.0 / 12.0, Math.toRadians(89.9)));// 183
		// p.addWaypoint(new WaypointSequence.Waypoint(220.0/12.0, 200.0/12.0,
		// Math.toRadians(0.0)));
		/*
		 * for(int i = 0; i <= steps; i++){ double theta = startAngle + i*(finalAngle -
		 * startAngle)/steps; p.addWaypoint(new WaypointSequence.Waypoint(x -
		 * r*ChezyMath.sin(theta), r*ChezyMath.cos(theta) + y, Math.toRadians(theta)));
		 * }
		 */
		/*
		 * p.addWaypoint(new WaypointSequence.Waypoint(x - r*ChezyMath.sin(theta_1),
		 * r*ChezyMath.cos(theta_1) + y, Math.toRadians(theta_1))); p.addWaypoint(new
		 * WaypointSequence.Waypoint(x - r*ChezyMath.sin(theta_2),
		 * r*ChezyMath.cos(theta_2) + y, Math.toRadians(theta_2))); p.addWaypoint(new
		 * WaypointSequence.Waypoint(x - r*ChezyMath.sin(theta_3),
		 * r*ChezyMath.cos(theta_3) + y, Math.toRadians(theta_3))); p.addWaypoint(new
		 * WaypointSequence.Waypoint(x - r*ChezyMath.sin(theta_4),
		 * r*ChezyMath.cos(theta_4) + y, Math.toRadians(theta_4))); p.addWaypoint(new
		 * WaypointSequence.Waypoint(x - r*ChezyMath.sin(theta_5),
		 * r*ChezyMath.cos(theta_5) + y, Math.toRadians(theta_5))); p.addWaypoint(new
		 * WaypointSequence.Waypoint(x - r*ChezyMath.sin(theta_6),
		 * r*ChezyMath.cos(theta_6) + y, Math.toRadians(theta_6))); p.addWaypoint(new
		 * WaypointSequence.Waypoint(x - r*ChezyMath.sin(theta_7),
		 * r*ChezyMath.cos(theta_7) + y, Math.toRadians(theta_7)));
		 */
		// p.addWaypoint(new WaypointSequence.Waypoint(-225.0/12.0, -175.0/12.0,
		// Math.PI/(180.0/5.0)));

		final Path path = PathGenerator.makePath(p, config, kWheelbaseWidth, path_name);
		writeFiles(path_name, path);
	}

	private static void LeftFarScalePath() { // TODO LeftFarScalePath
		final String path_name = "LeftFarScalePath";

		config.dt = .02;
		config.max_acc = 4.5;
		config.max_jerk = 30.0;
		config.max_vel = 8;
		// Remember that this is for the Right SCALE CASE starting on the LEFT!
		final WaypointSequence p = new WaypointSequence(10);

		p.addWaypoint(new WaypointSequence.Waypoint(0, 0, 0));
		p.addWaypoint(new WaypointSequence.Waypoint(80.0 / 12.0, -20.0 / 12.0, 0));
		p.addWaypoint(new WaypointSequence.Waypoint(187.0 / 12.0, 55.0 / 12.0, Math.PI / 2.0 - 0.0001));
		p.addWaypoint(new WaypointSequence.Waypoint(175.0 / 12.0, 180.0 / 12.0, Math.PI / 2.0 - 0.0001));
		// p.addWaypoint(new WaypointSequence.Waypoint(-215.0/12.0, -215.0/12.0,
		// Math.PI/(180.0/-15.0)));

		final Path path = PathGenerator.makePath(p, config, kWheelbaseWidth, path_name);
		writeFiles(path_name, path);
	}

	private static void IntakeToScalePath() {
		config.dt = .02;
		config.max_acc = 5;
		config.max_jerk = 30.0;
		config.max_vel = 8;
		// Path name must be a valid Java class name.
		final String path_name = "IntakeToScalePath";

		// Description of this auto mode path.
		// Remember that this is for the BLUE CASE!
		final WaypointSequence p = new WaypointSequence(10);
		p.addWaypoint(new WaypointSequence.Waypoint(0, 0, Math.toRadians(-20.0)));
		p.addWaypoint(new WaypointSequence.Waypoint(50.0 / 12.0, 15.0 / 12.0, Math.toRadians(55)));// 50 TODO 15!!!!! 35

		final Path path = PathGenerator.makePath(p, config, kWheelbaseWidth, path_name);
		writeFiles(path_name, path);
	}

	private static void RightIntakeToScalePath() {
		config.dt = .02;
		config.max_acc = 5;
		config.max_jerk = 30.0;
		config.max_vel = 8;
		// Path name must be a valid Java class name.
		final String path_name = "RightIntakeToScalePath";

		// Description of this auto mode path.
		// Remember that this is for the BLUE CASE!
		final WaypointSequence p = new WaypointSequence(10);
		p.addWaypoint(new WaypointSequence.Waypoint(0, 0, Math.toRadians(-20.0)));
		p.addWaypoint(new WaypointSequence.Waypoint(50.0 / 12.0, 15.0 / 12.0, Math.toRadians(55)));// 50 TODO 15 !!!!!
																									// 35

		final Path path = PathGenerator.makePath(p, config, kWheelbaseWidth, path_name);
		writeFiles(path_name, path);
	}

	private static void FarIntakeToScalePath() {
		config.dt = .02;
		config.max_acc = 5;
		config.max_jerk = 30.0;
		config.max_vel = 8;
		// Path name must be a valid Java class name.
		final String path_name = "FarIntakeToScalePath";

		// Description of this auto mode path.
		// Remember that this is for the BLUE CASE!
		final WaypointSequence p = new WaypointSequence(10);
		p.addWaypoint(new WaypointSequence.Waypoint(0, 0, Math.toRadians(65.0)));
		p.addWaypoint(new WaypointSequence.Waypoint(57.0 / 12.0, 15.0 / 12.0, Math.toRadians(-0.0)));

		final Path path = PathGenerator.makePath(p, config, kWheelbaseWidth, path_name);
		writeFiles(path_name, path);
	}

	private static void LeftScaleToIntakePath() { // TODO LeftScaleToIntakePath
		config.dt = .02;
		config.max_acc = 4;
		config.max_jerk = 30.0;
		config.max_vel = 8;
		// Path name must be a valid Java class name.
		final String path_name = "LeftScaleToIntakePath";

		// Description of this auto mode path.
		// Remember that this is for the BLUE CASE!
		final WaypointSequence p = new WaypointSequence(10);
		p.addWaypoint(new WaypointSequence.Waypoint(0, 0, -Math.PI / 9.0));
		p.addWaypoint(new WaypointSequence.Waypoint(50.0 / 12.0, 8.0 / 12.0, Math.PI / (180.0 / 45.0)));// 48, 8 TODO
																										// 5815

		final Path path = PathGenerator.makePath(p, config, kWheelbaseWidth, path_name);
		writeFiles(path_name, path);
	}

	private static void RightScaleToIntakePath() { // TODO RightScaleToIntakePath
		config.dt = .02;
		config.max_acc = 5;
		config.max_jerk = 30.0;
		config.max_vel = 8;
		// Path name must be a valid Java class name.
		final String path_name = "RightScaleToIntakePath";

		// Description of this auto mode path.
		// Remember that this is for the BLUE CASE!
		final WaypointSequence p = new WaypointSequence(10);
		p.addWaypoint(new WaypointSequence.Waypoint(0, 0, -Math.PI / 9.0));
		p.addWaypoint(new WaypointSequence.Waypoint(50.0 / 12.0, 8.0 / 12.0, Math.PI / (180.0 / 45.0)));

		final Path path = PathGenerator.makePath(p, config, kWheelbaseWidth, path_name);
		writeFiles(path_name, path);
	}

	private static void RightFarScaleToIntakePath() {
		config.dt = .02;
		config.max_acc = 5;
		config.max_jerk = 30.0;
		config.max_vel = 8;
		// Path name must be a valid Java class name.
		final String path_name = "RightFarScaleToIntakePath";

		// Description of this auto mode path.
		// Remember that this is for the BLUE CASE!
		final WaypointSequence p = new WaypointSequence(10);
		p.addWaypoint(new WaypointSequence.Waypoint(0, 0, Math.toRadians(-15.0)));
		p.addWaypoint(new WaypointSequence.Waypoint(60.0 / 12.0, 18.0 / 12.0, Math.toRadians(45.0)));// 47 15

		final Path path = PathGenerator.makePath(p, config, kWheelbaseWidth, path_name);
		writeFiles(path_name, path);
	}

	private static void LeftScaleToSecondIntakePath() {
		final String path_name = "LeftScaleToSecondIntakePath";

		config.dt = .02;
		config.max_acc = 4.5;
		config.max_jerk = 30.0;
		config.max_vel = 8;

		final WaypointSequence p = new WaypointSequence(10);
		p.addWaypoint(new WaypointSequence.Waypoint(0, 0, -Math.PI / 9.0));
		p.addWaypoint(new WaypointSequence.Waypoint(.68 + .4, -0.0 / 12.0, Math.PI / (180.0 / 20.0)));
		p.addWaypoint(new WaypointSequence.Waypoint(2.25, 1.25, Math.PI / (180.0 / 76.0)));
		// p.addWaypoint(new WaypointSequence.Waypoint(46.0/12.0, 63.0/12.0, Math.PI /
		// (180.0/65.0)));//46 64 49 63
		p.addWaypoint(new WaypointSequence.Waypoint(44.0 / 12.0, 63.0 / 12.0, Math.PI / (180.0 / 65.0)));// 46 64 49 63

		// p.addWaypoint(new WaypointSequence.Waypoint(50.0/12.0, 45.0/12.0, Math.PI /
		// (180.0/30.0)));

		final Path path = PathGenerator.makePath(p, config, kWheelbaseWidth, path_name);
		writeFiles(path_name, path);
	}

	private static void LeftSecondCubeToScalePath() {
		final String path_name = "LeftSecondCubeToScalePath";

		config.dt = .02;
		config.max_acc = 4.5;
		config.max_jerk = 30.0;
		config.max_vel = 8;

		final WaypointSequence p = new WaypointSequence(10);
		p.addWaypoint(new WaypointSequence.Waypoint(0, 0, Math.toRadians(-20.0)));
		p.addWaypoint(new WaypointSequence.Waypoint(60.0 / 12.0, 15.0 / 12.0, Math.toRadians(55)));
		final Path path = PathGenerator.makePath(p, config, kWheelbaseWidth, path_name);
		writeFiles(path_name, path);
	}

	private static void RightSecondCubeToScalePath() {
		final String path_name = "RightSecondCubeToScalePath";

		config.dt = .02;
		config.max_acc = 4.5;
		config.max_jerk = 30.0;
		config.max_vel = 8;

		final WaypointSequence p = new WaypointSequence(10);
		p.addWaypoint(new WaypointSequence.Waypoint(0, 0, Math.toRadians(-20.0)));
		p.addWaypoint(new WaypointSequence.Waypoint(60.0 / 12.0, 15.0 / 12.0, Math.toRadians(55)));
		final Path path = PathGenerator.makePath(p, config, kWheelbaseWidth, path_name);
		writeFiles(path_name, path);
	}

	private static void RightScaleToSecondIntakePath() {
		// Path name must be a valid Java class name.
		final String path_name = "RightScaleToSecondIntakePath";

		config.dt = .02;
		config.max_acc = 4.5;
		config.max_jerk = 30.0;
		config.max_vel = 8;

		final WaypointSequence p = new WaypointSequence(10);
		p.addWaypoint(new WaypointSequence.Waypoint(0, 0, -Math.PI / 9.0));
		p.addWaypoint(new WaypointSequence.Waypoint(.68 + .4, -0.0 / 12.0, Math.PI / (180.0 / 20.0)));
		p.addWaypoint(new WaypointSequence.Waypoint(2.25, 1.25, Math.PI / (180.0 / 76.0)));
		p.addWaypoint(new WaypointSequence.Waypoint(20.0 / 12.0, 50.0 / 12.0, Math.PI / (180.0 / 65.0)));// 46 64 49
																											// 6341

		// p.addWaypoint(new WaypointSequence.Waypoint(50.0/12.0, 45.0/12.0, Math.PI /
		// (180.0/30.0)));

		final Path path = PathGenerator.makePath(p, config, kWheelbaseWidth, path_name);
		writeFiles(path_name, path);
	}

	private static void FarScaleTurnPath() {
		final String path_name = "FarScaleTurnPath";

		config.dt = .02;
		config.max_acc = 3;
		config.max_jerk = 30.0;
		config.max_vel = 8;

		final double angle = 105;

		final WaypointSequence p = new WaypointSequence(10);
		p.addWaypoint(new WaypointSequence.Waypoint(0, 0, 0));
		p.addWaypoint(new WaypointSequence.Waypoint(Math.PI * kWheelbaseWidth * angle / 360, 0, 0));

		final Path path = PathGenerator.makePath(p, config, kWheelbaseWidth, path_name);
		writeFiles(path_name, path);
	}

	private static void FarScaleForwardPath() {
		final String path_name = "FarScaleForwardPath";
		config.dt = .02;
		config.max_acc = 4.0;
		config.max_jerk = 30.0;
		config.max_vel = 8;

		final WaypointSequence p = new WaypointSequence(10);
		p.addWaypoint(new WaypointSequence.Waypoint(0, 0, 0));
		p.addWaypoint(new WaypointSequence.Waypoint(36.0 / 12.0, 0, 0));

		final Path path = PathGenerator.makePath(p, config, kWheelbaseWidth, path_name);
		writeFiles(path_name, path);
	}

	private static void Turn90Path() {
		final String path_name = "Turn90Path";

		config.dt = .02;
		config.max_acc = 3;
		config.max_jerk = 30.0;
		config.max_vel = 8;

		final double angle = 90;

		final WaypointSequence p = new WaypointSequence(10);
		p.addWaypoint(new WaypointSequence.Waypoint(0, 0, 0));
		p.addWaypoint(new WaypointSequence.Waypoint(Math.PI * kWheelbaseWidth * angle / 360, 0, 0));

		final Path path = PathGenerator.makePath(p, config, kWheelbaseWidth, path_name);
		writeFiles(path_name, path);
	}

	private static void StraightTestPath() {
		final String path_name = "StraightTestPath";

		config.dt = .02;
		config.max_acc = 8.52;
		config.max_dec = 3.0;
		config.max_jerk = 30.0;
		config.max_vel = 10.0;

		final WaypointSequence p = new WaypointSequence(10);
		p.addWaypoint(new WaypointSequence.Waypoint(0, 0, 0));
		p.addWaypoint(new WaypointSequence.Waypoint(30.0, 0, 0));

		final Path path = PathGenerator.makePath(p, config, kWheelbaseWidth, path_name);
		writeFiles(path_name, path);
	}

	private static void writeFiles(final String path_name, final Path path) {

		// Outputs to the directory supplied as the first argument.
		final JavaSerializer js = new JavaSerializer();
		final String serialized = js.serialize(path);
		// System.out.print(serialized);
		final String fullpath = joinPath(javaDirectory, path_name + ".java");
		if (!writeFile(fullpath, serialized)) {
			System.err.println(fullpath + " could not be written!!!!1");
			System.exit(1);
		} else {
			System.out.println("Wrote " + fullpath);
		}

		// Outputs to the directory supplied as the first argument.
		final TextFileSerializer ts = new TextFileSerializer();
		final String serializedtext = ts.serialize(path);
		// System.out.print(serialized);
		final String fullpathtext = joinPath(textDirectory, path_name + ".txt");
		if (!writeFile(fullpathtext, serializedtext)) {
			System.err.println(fullpathtext + " could not be written!!!!1");
			System.exit(1);
		} else {
			System.out.println("Wrote " + fullpathtext);
		}
	}
}
