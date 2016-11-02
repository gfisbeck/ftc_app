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

@TeleOp(name="JEl POV Drive", group="Test")
//@Disabled
public class Opmode_JEl extends LinearOpMode {

    /* Declare OpMode members. */
    HardwareJoeBot  robot           = new HardwareJoeBot();     // Use a JoeBot's hardware
    boolean         intakeEnabledX;
    boolean         intakeEnabledY;
    boolean         bCurrStateY;
    boolean         bPrevStateY;
    boolean         bCurrStateX;
    boolean         bPrevStateX;

    @Override
    public void runOpMode() throws InterruptedException {
        double left;
        double right;


        //double max;

        /* Initialize the hardware variables.
         * The init() method of the hardware class does all the work here
         */
        robot.init(hardwareMap);

        // Send telemetry message to signify robot waiting;
        telemetry.addData("Say", "Hello Ethan");    //
        telemetry.update();

        intakeEnabledY=false;
        intakeEnabledX=false;


        // Wait for the game to start (driver presses PLAY)
        waitForStart();

        // run until the end of the match (driver presses STOP)
        while (opModeIsActive()) {

            // Run wheels in Tank mode (note: The joystick goes negative when pushed forwards, so negate it)
            // In this mode the Left stick moves the robot fwd and back, the Right stick turns left and right.
            left = -gamepad1.left_stick_y/2.3;
            right = -gamepad1.right_stick_y/2.3;
            robot.motor_driveleft.setPower(left);
            robot.motor_driveright.setPower(right);


            // check the status of the y button on either gamepad.
            bCurrStateY = gamepad1.y;

            // check for button state transitions.
            if ((bCurrStateY == true) && (bCurrStateY != bPrevStateY))  {

                // button is transitioning to a pressed state. So Toggle LED
                intakeEnabledY = !intakeEnabledY;

            }
            // update previous state variable.
            bPrevStateY = bCurrStateY;
            if (intakeEnabledY == true){
                robot.motor_arm.setPower(-0.35);
            }
            if (intakeEnabledY != true){
                robot.motor_arm.setPower(0);
            }



            // check the status of the x button on either gamepad.
            bCurrStateX = gamepad1.x;

            // check for button state transitions.
            if ((bCurrStateX == true) && (bCurrStateX != bPrevStateX))  {

                // button is transitioning to a pressed state. So Toggle LED
                intakeEnabledX = !intakeEnabledX;

            }
            // update previous state variable.
            bPrevStateX = bCurrStateX;
            if (intakeEnabledX == true){
                robot.motor_arm.setPower(0.35);
            }
            if (intakeEnabledX != true){
                robot.motor_arm.setPower(0);
            }








            //Look For y button Press


           /* if (gamepad1.y){
                  if (intakeEnabled == true){
                    intakeEnabled=false;
                    telemetry.addLine("Disabled Intake");
                } else {
                    intakeEnabled = true;
                    telemetry.addLine("Enabled Intake");
                    telemetry.update();
                }
            }
           */








            // Pause for metronome tick.  40 mS each cycle = update 25 times a second.
            robot.waitForTick(40);
        }
    }
}
