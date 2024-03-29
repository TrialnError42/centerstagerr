package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.openftc.easyopencv.OpenCvCamera;

@Autonomous(group = "drive")
public class redAllianceCamera extends AutoCommon {

    double cX = 0;
    double cY = 0;
    double width = 0;

    private OpenCvCamera controlHubCam;  // Use OpenCvCamera class from FTC SDK
    private static final int CAMERA_WIDTH = 640; // width of wanted camera resolution
    private static final int CAMERA_HEIGHT = 360; // height of wanted camera resolution

    // Calculate the distance using the formula
    //122:174
    //340:200

    //right

    //465:141
    //615:184
    public static final double objectWidthInRealWorldUnits = 3.75;  // Replace with the actual width of the object in real-world units
    public static final double focalLength = 728;  // Replace with the focal length of the camera in pixels

    int error = 50;

    @Override
    public void runOpMode() {

        super.runOpMode();


//        initOpenCV();
//        FtcDashboard dashboard = FtcDashboard.getInstance();
//        telemetry = new MultipleTelemetry(telemetry, dashboard.getTelemetry());
//        FtcDashboard.getInstance().startCameraStream(controlHubCam, 30);
//
//        telemetry.addData("Coordinate", "(" + (int) cX + ", " + (int) cY + ")");
//        telemetry.addData("Distance in Inch", (getDistance(width)));
//        if (cX <= 340 && cX >= 122 && cY >= 174 && cY <= 220) { //change 227 to the cX value when piece is in center
//            telemetry.addData("Location: ", "Center");
////                center();
//        } else if (cX <= 615 && cX >= 122 && cY >= 141 && cY <= 200) {//change 60 to the cX value when piece is in center
//            telemetry.addData("Location", "Right");
////                right();
//        } else {
//            telemetry.addData("Location:", "Left");
////                left();
//        }
//        telemetry.update();
        // The OpenCV pipeline automatically processes frames and handles detection


        // Release resources


        if (pos == 2) {
            driveOnHeading(20, 0.3, 0);
        }


        else if (pos == 1){
            driveOnHeading(20, 0.3, 90);
        }

        else if (pos == 3){
            driveOnHeading(22, 0.3, -90);
        }

    }
}
//    private void initOpenCV() {
//
//        // Create an instance of the camera
//        int cameraMonitorViewId = hardwareMap.appContext.getResources().getIdentifier(
//                "cameraMonitorViewId", "id", hardwareMap.appContext.getPackageName());
//
//        // Use OpenCvCameraFactory class from FTC SDK to create camera instance
//        controlHubCam = OpenCvCameraFactory.getInstance().createWebcam(
//                hardwareMap.get(WebcamName.class, "Webcam 1"), cameraMonitorViewId);
//
//        controlHubCam.openCameraDeviceAsync(new OpenCvCamera.AsyncCameraOpenListener()
//        {
//            @Override
//            public void onOpened()
//            {
//                controlHubCam.startStreaming(CAMERA_WIDTH, CAMERA_HEIGHT, OpenCvCameraRotation.UPRIGHT);
//            }
//            @Override
//            public void onError(int errorCode)
//            {
//                /*
//                 * This will be called if the camera could not be opened
//                 */
//            }
//        });
//        controlHubCam.setPipeline(new YellowBlobDetectionPipeline());
//    }
//
//    class YellowBlobDetectionPipeline extends OpenCvPipeline {
//        @Override
//        public Mat processFrame(Mat input) {
//            // Preprocess the frame to detect yellow regions
//            Mat yellowMask = preprocessFrame(input);
//
//            // Find contours of the detected yellow regions
//            List<MatOfPoint> contours = new ArrayList<>();
//            Mat hierarchy = new Mat();
//            Imgproc.findContours(yellowMask, contours, hierarchy, Imgproc.RETR_EXTERNAL, Imgproc.CHAIN_APPROX_SIMPLE);
//
//            // Find the largest yellow contour (blob)
//            MatOfPoint largestContour = findLargestContour(contours);
//
//            if (largestContour != null) {
//                // Draw a red outline around the largest detected object
//                Imgproc.drawContours(input, contours, contours.indexOf(largestContour), new Scalar(255, 0, 0), 2);
//                // Calculate the width of the bounding box
//                width = calculateWidth(largestContour);
//
//                // Display the width next to the label
//                String widthLabel = "Width: " + (int) width + " pixels";
//                Imgproc.putText(input, widthLabel, new Point(cX + 10, cY + 20), Imgproc.FONT_HERSHEY_SIMPLEX, 0.5, new Scalar(0, 255, 0), 2);
//                //Display the Distance
//                String distanceLabel = "Distance: " + String.format("%.2f", getDistance(width)) + " inches";
//                Imgproc.putText(input, distanceLabel, new Point(cX + 10, cY + 60), Imgproc.FONT_HERSHEY_SIMPLEX, 0.5, new Scalar(0, 255, 0), 2);
//                // Calculate the centroid of the largest contour
//                Moments moments = Imgproc.moments(largestContour);
//                cX = moments.get_m10() / moments.get_m00();
//                cY = moments.get_m01() / moments.get_m00();
//
//                // Draw a dot at the centroid
//                String label = "(" + (int) cX + ", " + (int) cY + ")";
//                Imgproc.putText(input, label, new Point(cX + 10, cY), Imgproc.FONT_HERSHEY_COMPLEX, 0.5, new Scalar(0, 255, 0), 2);
//                Imgproc.circle(input, new Point(cX, cY), 5, new Scalar(0, 255, 0), -1);
//
//            }
//
//            return input;
//        }
//
//        private Mat preprocessFrame(Mat frame) {
//            Mat hsvFrame = new Mat();
//            Imgproc.cvtColor(frame, hsvFrame, Imgproc.COLOR_BGR2HSV);
//
//            Scalar lowerYellow = new Scalar(100, 100, 100);
//            Scalar upperYellow = new Scalar(180, 255, 255);
//
//
//            Mat yellowMask = new Mat();
//            Core.inRange(hsvFrame, lowerYellow, upperYellow, yellowMask);
//
//            Mat kernel = Imgproc.getStructuringElement(Imgproc.MORPH_RECT, new Size(5, 5));
//            Imgproc.morphologyEx(yellowMask, yellowMask, Imgproc.MORPH_OPEN, kernel);
//            Imgproc.morphologyEx(yellowMask, yellowMask, Imgproc.MORPH_CLOSE, kernel);
//
//            return yellowMask;
//        }
//
//        private MatOfPoint findLargestContour(List<MatOfPoint> contours) {
//            double maxArea = 0;
//            MatOfPoint largestContour = null;
//
//            for (MatOfPoint contour : contours) {
//                double area = Imgproc.contourArea(contour);
//                if (area > maxArea) {
//                    maxArea = area;
//                    largestContour = contour;
//                }
//            }
//
//            return largestContour;
//        }
//
//        private double calculateWidth(MatOfPoint contour) {
//            Rect boundingRect = Imgproc.boundingRect(contour);
//            return boundingRect.width;
//        }
//
//    }
//
//    private static double getDistance(double width) {
//        double distance = (objectWidthInRealWorldUnits * focalLength) / width;
//        return distance;
//    }
//
//
//}
