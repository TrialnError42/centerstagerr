package com.example.meepmeeptesting;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.geometry.Vector2d;
import com.noahbres.meepmeep.MeepMeep;
import com.noahbres.meepmeep.roadrunner.DefaultBotBuilder;
import com.noahbres.meepmeep.roadrunner.entity.RoadRunnerBotEntity;

public class MeepMeepTesting {
    public static void main(String[] args) {
        MeepMeep meepMeep = new MeepMeep(800);
//        TrajectorySequence redFarThroughTruss = drive.trajectorySequenceBuilder(new Pose2d(-37.47, -70.32, Math.toRadians(90.00)))
//                .splineTo(new Vector2d(-36.21, -42.11), Math.toRadians(89.18))
//                .splineTo(new Vector2d(0.00, -41.68), Math.toRadians(0.67))
//                .splineTo(new Vector2d(48.21, -36.84), Math.toRadians(5.74))
//                .build();

        RoadRunnerBotEntity myBot = new DefaultBotBuilder(meepMeep)
                // Set bot constraints: maxVel, maxAccel, maxAngVel, maxAngAccel, track width
                .setConstraints(60, 60, Math.toRadians(180), Math.toRadians(180), 15)
                .followTrajectorySequence(drive ->
                        drive.trajectorySequenceBuilder(new Pose2d(-37.26, -66.53, 90))
                                        .splineTo(new Vector2d(-36.21, -42.11), Math.toRadians(89.18))
                .splineTo(new Vector2d(0.00, -41.68), Math.toRadians(0.67))
                .splineTo(new Vector2d(48.21, -36.84), Math.toRadians(5.74))
                .build()
                );
//        TrajectorySequence redFarThroughTruss = drive.trajectorySequenceBuilder(new Pose2d(-37.26, -66.53, Math.toRadians(90.00)))
//                .splineTo(new Vector2d(-36.42, -46.95), Math.toRadians(89.18))
//                .splineTo(new Vector2d(-19.79, -40.21), Math.toRadians(-4.53))
//                .splineTo(new Vector2d(-0.21, -39.58), Math.toRadians(0.67))
//                .splineTo(new Vector2d(27.58, -38.74), Math.toRadians(4.73))
//                .splineTo(new Vector2d(48.21, -36.84), Math.toRadians(5.74))
//                .build();
//        drive.setPoseEstimate(redFarThroughTruss.start());
        meepMeep.setBackground(MeepMeep.Background.FIELD_CENTERSTAGE_JUICE_DARK)
                .setDarkMode(true)
                .setBackgroundAlpha(0.95f)
                .addEntity(myBot)
                .start();
    }
}