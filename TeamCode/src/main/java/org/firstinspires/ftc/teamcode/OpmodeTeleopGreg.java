/*
Copyright (c) 2016 Robert Atkinson

All rights reserved.

Redistribution and use in source and binary forms, with or without modification,
are permitted (subject to the limitations in the disclaimer below) provided that
the following conditions are met:

Redistributions of source code must retain the above copyright notice, this list
of conditions and the following disclaimer.

Redistributions in binary form must reproduce the above copyright notice, this
list of conditions and the following disclaimer in the documentation and/or
other materials provided with the distribution.

Neither the name of Robert Atkinson nor the names of his contributors may be used to
endorse or promote products derived from this software without specific prior
written permission.

NO EXPRESS OR IMPLIED LICENSES TO ANY PARTY'S PATENT RIGHTS ARE GRANTED BY THIS
LICENSE. THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
"AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESSFOR A PARTICULAR PURPOSE
ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE
FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR
TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF
THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
*/
package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

/**
 * This OpMode uses the JoeBot hardware class to define the devices on the robot.
 * All device access is managed through the HardwareJoeBot class.
 * The code is structured as a LinearOpMode
 *
 * This particular OpMode executes a Tank Drive style Teleop for the 2015 JoeBot
 */

@TeleOp(name="Greg Tank Drive", group="Test")
//@Disabled
public class OpmodeTeleopGreg extends LinearOpMode {

    /* Declare OpMode members. */
    HardwareJoeBot  robot           = new HardwareJoeBot();     // Use a JoeBot's hardware

    //double          clawOffset      = 0;                       // Servo mid position
    //final double    CLAW_SPEED      = 0.02 ;                   // sets rate to move servo

    @Override
    public void runOpMode() throws InterruptedException {
        double left;
        double right;
        double rightTrigger;
        double leftTrigger;
        double rPosition;
        double lPosition;

        //double max;

        /* Initialize the hardware variables.
         * The init() method of the hardware class does all the work here
         */
        robot.init(hardwareMap);

        // Send telemetry message to signify robot waiting;
        telemetry.addData("Say", "Hello Greg. This is a test. This is also a test.");
        telemetry.addData("Say", "Starting Drive Control Mode");
        telemetry.update();

        //Set rPosition & lPosition to initial States
       // lPosition = HardwareJoeBot.LEFT_SERVO_MIN;
        //rPosition = HardwareJoeBot.RIGHT_SERVO_MIN;


        // Wait for the game to start (driver presses PLAY)
        waitForStart();

        // run until the end of the match (driver presses STOP)
        while (opModeIsActive()) {

            // Run wheels in Tank mode (note: The joystick goes negative when pushed forwards, so negate it)
            // In this mode the Left stick moves the robot fwd and back, the Right stick turns left and right.
            left = -gamepad1.left_stick_y;
            right = -gamepad1.right_stick_y;
            robot.motor_driveleft.setPower(left);
            robot.motor_driveright.setPower(right);

            // Raise Arm with Triggers
            leftTrigger = gamepad1.left_trigger;
            rightTrigger = gamepad1.right_trigger;
            //If the right trigger is pressed, we're going to ignore left trigger
            if (rightTrigger>0) {
                robot.motor_arm.setPower(rightTrigger);
            } else if (leftTrigger>0) {
                robot.motor_arm.setPower(-leftTrigger);
            } else {
                robot.motor_arm.setPower(0);
            }

            // Use Bumpers to extend wings. If the wing is already out, bumper should pull it in.
           // if (gamepad1.left_bumper) {
                // Check to see if wing is extended
             //   if (lPosition == HardwareJoeBot.LEFT_SERVO_MAX) {
               //     robot.srv_left.setPosition(HardwareJoeBot.LEFT_SERVO_MIN);
                 //   lPosition = HardwareJoeBot.LEFT_SERVO_MIN;
                } //else if (lPosition == HardwareJoeBot.LEFT_SERVO_MIN) {
                    //robot.srv_left.setPosition(HardwareJoeBot.LEFT_SERVO_MAX);
                    //Position = HardwareJoeBot.LEFT_SERVO_MAX;
                }
            }
           /* if (gamepad1.right_bumper) {
                // Check to see if wing is extended
                if (rPosition == HardwareJoeBot.RIGHT_SERVO_MAX) {
                    robot.srv_right.setPosition(HardwareJoeBot.RIGHT_SERVO_MIN);
                    rPosition = HardwareJoeBot.RIGHT_SERVO_MIN;
                } else if (rPosition == HardwareJoeBot.RIGHT_SERVO_MIN){
                    robot.srv_right.setPosition(HardwareJoeBot.RIGHT_SERVO_MAX);
                    rPosition = HardwareJoeBot.RIGHT_SERVO_MAX;
                } */


