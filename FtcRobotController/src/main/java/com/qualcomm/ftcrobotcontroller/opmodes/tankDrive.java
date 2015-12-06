package com.qualcomm.ftcrobotcontroller.opmodes;

/**
 * Created by member on 11/16/15.
 */

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.Range;

public class tankDrive extends OpMode {
    final double LEFT_OPEN_POSITION = 0.0;
    final double LEFT_CLOSED_POSITION = 0.5;
    final double RIGHT_OPEN_POSITION = 0.0;
    final double RIGHT_CLOSED_POSITION = 0.5;

    DcMotor leftMotor;
    DcMotor rightMotor;

    Servo leftHand;
    Servo rightHand;
     /* Here is all our motors used */

    float xValue = gamepad1.left_stick_x;
    float yValue = -gamepad1.left_stick_y;

    float leftPower;
    float rightPower;

    public void init(){
        //Declaration of motors
        leftMotor = hardwareMap.dcMotor.get("left_drive");
        rightMotor = hardwareMap.dcMotor.get("right_drive");
        //Code for turning robot
        rightMotor.setDirection(DcMotor.Direction.REVERSE);

        leftHand = hardwareMap.servo.get("left_hand");
        rightHand = hardwareMap.servo.get("right_hand");
        leftHand.scaleRange(LEFT_OPEN_POSITION,LEFT_CLOSED_POSITION);
        rightHand.scaleRange(RIGHT_OPEN_POSITION, RIGHT_CLOSED_POSITION);

        leftPower =  Range.clip(yValue + xValue, -1, 1);
        rightPower = Range.clip(yValue + xValue, -1, 1);

    }
    @Override
    public void loop() {
        if(gamepad1.x){
            leftHand.setPosition(LEFT_OPEN_POSITION);

            leftHand.setPosition(RIGHT_OPEN_POSITION);
        }
        if(gamepad1.a){
            leftHand.setPosition(LEFT_CLOSED_POSITION);
            leftHand.setPosition(RIGHT_OPEN_POSITION);
        }

        leftMotor.setPower(leftPower);
        rightMotor.setPower(rightPower);

    }


}