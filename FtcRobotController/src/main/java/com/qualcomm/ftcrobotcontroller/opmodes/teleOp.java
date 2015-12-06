package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.Range;

/**
 * Created by member on 12/3/15.
 */
public class teleOp extends OpMode{
    final double LEFT_OPEN_POSITION = 0.0;
    final double LEFT_CLOSED_POSITION = 0.5;
    final double RIGHT_OPEN_POSITION = 0.0;
    final double RIGHT_CLOSED_POSITION = 0.5;

    DcMotor leftMotor;
    DcMotor rightMotor;
    //DcMotor tapeMeasure;
    Servo leftHand;
    Servo rightHand;
     /* Here is all our motors used */

    float xValue = gamepad1.left_stick_x;
    float yValue = -gamepad1.left_stick_y;

    float leftPower;
    float rightPower;
    public void init(){
        leftMotor = hardwareMap.dcMotor.get("left_drive");
        rightMotor = hardwareMap.dcMotor.get("right_drive");
        //tapeMeasure = hardwareMap.dcMotor.get("tape");

        //Code for turning robot
        rightMotor.setDirection(DcMotor.Direction.REVERSE);


        leftHand = hardwareMap.servo.get("left_hand");
        rightHand = hardwareMap.servo.get("right_hand");
        leftHand.scaleRange(LEFT_OPEN_POSITION,LEFT_CLOSED_POSITION);
        rightHand.scaleRange(RIGHT_OPEN_POSITION, RIGHT_CLOSED_POSITION);

        leftPower =  Range.clip(yValue + xValue, -1, 1);
        rightPower = Range.clip(yValue + xValue, -1, 1);
    }
    public void loop(){
        if(gamepad2.x){
            leftHand.setPosition(LEFT_OPEN_POSITION);

            leftHand.setPosition(RIGHT_OPEN_POSITION);
        }
        if(gamepad2.y){
            leftHand.setPosition(LEFT_CLOSED_POSITION);
            leftHand.setPosition(RIGHT_OPEN_POSITION);
        }
        /*if (gamepad2.a) {
            //tapeMeasure.setPower(1);
        }
        else if (gamepad2.b) {
            //tapeMeasure.setPower(-1);
        }
        else {
            //tapeMeasure.setPower(0);
        }*/
        leftMotor.setPower(leftPower);
        rightMotor.setPower(rightPower);

    }
}
