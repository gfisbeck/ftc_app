package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

/**
 * This is NOT an opmode.
 *
 * This hardware class assumes the following device names have been configured on the robot:
 * Note:  All names are lower case and some have single spaces between words.
 *
 * Motor channel:  Left  drive motor:        "motor-driveleft"
 * Motor channel:  Right drive motor:        "motor-driveright"
 * Motor channel:  Arm drive motor:          "Arm"
 * Servo channel:  Servo for left wing:      "srv-left"
 * Servo channel:  Servo for right wing:     "srv-right"
 */

public class HardwareJoeBot
{
    /* Public OpMode members. */
    public DcMotor  motor_driveleft   = null;
    public DcMotor  motor_driveright  = null;
    public DcMotor  motor_arm         = null;
    //public Servo    srv_left          = null;
   // public Servo    srv_right         = null;

    //public static final double RIGHT_SERVO_MAX   =  0.1 ;
    //public static final double RIGHT_SERVO_MIN   =  0.9 ;
    //public static final double LEFT_SERVO_MAX   =  0.9 ;
   // public static final double LEFT_SERVO_MIN   =  0.1 ;

    //public static final double ARM_UP_POWER    =  0.45 ;
    //public static final double ARM_DOWN_POWER  = -0.45 ;

    /* local OpMode members. */
    HardwareMap hwMap           =  null;
    private ElapsedTime period  = new ElapsedTime();

    /* Constructor */
    public HardwareJoeBot(){

    }

    /* Initialize standard Hardware interfaces */
    public void init(HardwareMap ahwMap) {
        // Save reference to Hardware map
        hwMap = ahwMap;

        // Define and Initialize Motors
        motor_driveleft   = hwMap.dcMotor.get("motor-driveleft");
        motor_driveright  = hwMap.dcMotor.get("motor-driveright");
        motor_arm    = hwMap.dcMotor.get("Arm");
        motor_driveleft.setDirection(DcMotor.Direction.FORWARD); // Set to REVERSE if using AndyMark motors
        motor_driveright.setDirection(DcMotor.Direction.REVERSE);// Set to FORWARD if using AndyMark motors

        // Set all motors to zero power
        motor_driveleft.setPower(0);
        motor_driveright.setPower(0);
        motor_arm.setPower(0);

        // Set all motors to run without encoders.
        // May want to use RUN_USING_ENCODERS if encoders are installed.
        motor_driveleft.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        motor_driveright.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        motor_arm.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        // Define and initialize ALL installed servos.
       // srv_left = hwMap.servo.get("srv-left");
        //srv_right = hwMap.servo.get("srv-right");
        //srv_left.setPosition(LEFT_SERVO_MIN);
        //srv_right.setPosition(RIGHT_SERVO_MIN);
    }

    /***
     *
     * waitForTick implements a periodic delay. However, this acts like a metronome with a regular
     * periodic tick.  This is used to compensate for varying processing times for each cycle.
     * The function looks at the elapsed cycle time, and sleeps for the remaining time interval.
     *
     * @param periodMs  Length of wait cycle in mSec.
     * @throws InterruptedException
     */
    public void waitForTick(long periodMs) throws InterruptedException {

        long  remaining = periodMs - (long)period.milliseconds();

        // sleep for the remaining portion of the regular cycle period.
        if (remaining > 0)
            Thread.sleep(remaining);

        // Reset the cycle clock for the next pass.
        period.reset();
    }
}

